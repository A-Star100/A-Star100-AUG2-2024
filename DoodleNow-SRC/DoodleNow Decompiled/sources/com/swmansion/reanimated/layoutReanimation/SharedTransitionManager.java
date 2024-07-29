package com.swmansion.reanimated.layoutReanimation;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.events.EventDispatcherListener;
import com.facebook.react.views.view.ReactViewGroup;
import com.swmansion.reanimated.Utils;
import com.swmansion.rnscreens.events.ScreenWillAppearEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import javax.annotation.Nullable;

public class SharedTransitionManager {
    /* access modifiers changed from: private */
    public final List<View> mAddedSharedViews = new ArrayList();
    /* access modifiers changed from: private */
    public final AnimationsManager mAnimationsManager;
    private final Map<Integer, View> mCurrentSharedTransitionViews = new HashMap();
    private final Map<Integer, Integer> mDisableCleaningForViewTag = new HashMap();
    private boolean mIsTransitionPrepared = false;
    private NativeMethodsHolder mNativeMethodsHolder;
    private final Set<View> mReattachedViews = new HashSet();
    /* access modifiers changed from: private */
    public final List<View> mRemovedSharedViews = new ArrayList();
    private List<SharedElement> mSharedElements = new ArrayList();
    private final Map<Integer, SharedElement> mSharedElementsLookup = new HashMap();
    private final List<SharedElement> mSharedElementsWithAnimation = new ArrayList();
    private final List<SharedElement> mSharedElementsWithProgress = new ArrayList();
    private final Map<Integer, Integer> mSharedTransitionInParentIndex = new HashMap();
    private final Map<Integer, View> mSharedTransitionParent = new HashMap();
    private final Map<Integer, SortedSet<Integer>> mSharedViewChildrenIndices = new HashMap();
    private final Map<Integer, Snapshot> mSnapshotRegistry = new HashMap();
    /* access modifiers changed from: private */
    public final Set<Integer> mTagsToCleanup = new HashSet();
    private View mTransitionContainer;
    private final Set<Integer> mViewTagsToHide = new HashSet();

    interface TreeVisitor {
        void run(View view);
    }

    /* access modifiers changed from: protected */
    public void setNativeMethods(NativeMethodsHolder nativeMethodsHolder) {
        this.mNativeMethodsHolder = nativeMethodsHolder;
    }

    /* access modifiers changed from: protected */
    public void viewDidLayout(View view) {
    }

    class TopWillAppearListener implements EventDispatcherListener {
        private final EventDispatcher mEventDispatcher;

        public TopWillAppearListener(EventDispatcher eventDispatcher) {
            this.mEventDispatcher = eventDispatcher;
        }

        public void onEventDispatch(Event event) {
            if (event.getEventName().equals(ScreenWillAppearEvent.EVENT_NAME)) {
                SharedTransitionManager sharedTransitionManager = SharedTransitionManager.this;
                boolean unused = sharedTransitionManager.tryStartSharedTransitionForViews(sharedTransitionManager.mAddedSharedViews, true);
                SharedTransitionManager.this.mAddedSharedViews.clear();
                this.mEventDispatcher.removeListener(this);
            }
        }
    }

    public SharedTransitionManager(AnimationsManager animationsManager) {
        this.mAnimationsManager = animationsManager;
    }

    /* access modifiers changed from: protected */
    public void notifyAboutNewView(View view) {
        this.mAddedSharedViews.add(view);
    }

    /* access modifiers changed from: protected */
    public void notifyAboutRemovedView(View view) {
        this.mRemovedSharedViews.add(view);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public View getTransitioningView(int i) {
        return this.mCurrentSharedTransitionViews.get(Integer.valueOf(i));
    }

    /* access modifiers changed from: protected */
    public void screenDidLayout(View view) {
        EventDispatcher eventDispatcherForReactTag;
        if (!this.mAddedSharedViews.isEmpty() && (eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag((ReactContext) view.getContext(), view.getId())) != null) {
            eventDispatcherForReactTag.addListener(new TopWillAppearListener(eventDispatcherForReactTag));
        }
    }

    /* access modifiers changed from: protected */
    public void onViewsRemoval(int[] iArr) {
        if (iArr != null) {
            visitTreeForTags(iArr, new SnapshotTreeVisitor());
            if (this.mRemovedSharedViews.size() > 0) {
                boolean prepareSharedTransition = prepareSharedTransition(this.mRemovedSharedViews, false);
                this.mIsTransitionPrepared = prepareSharedTransition;
                if (!prepareSharedTransition) {
                    this.mRemovedSharedViews.clear();
                }
                visitTreeForTags(iArr, new PrepareConfigCleanupTreeVisitor());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void doSnapshotForTopScreenViews(ViewGroup viewGroup) {
        if (viewGroup.getChildCount() > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof ViewGroup) {
                visitNativeTreeAndMakeSnapshot(((ViewGroup) childAt).getChildAt(0));
            } else {
                Log.e("[Reanimated]", "Unable to recognize screen on stack.");
            }
        }
    }

    private void maybeRestartAnimationWithNewLayout(View view) {
        View view2 = this.mCurrentSharedTransitionViews.get(Integer.valueOf(view.getId()));
        if (view2 != null) {
            ArrayList arrayList = new ArrayList();
            for (SharedElement next : this.mSharedElements) {
                if (next.targetView == view2) {
                    arrayList.add(next);
                    View view3 = next.sourceView;
                    View view4 = next.targetView;
                    Snapshot snapshot = new Snapshot(view3);
                    Snapshot snapshot2 = this.mSnapshotRegistry.get(Integer.valueOf(view4.getId()));
                    Snapshot snapshot3 = new Snapshot(view4);
                    int i = (snapshot2.originX - snapshot2.originXByParent) + snapshot3.originX;
                    int i2 = (snapshot2.originY - snapshot2.originYByParent) + snapshot3.originY;
                    snapshot2.originX = i;
                    snapshot2.originY = i2;
                    snapshot2.globalOriginX = i;
                    snapshot2.globalOriginY = i2;
                    snapshot2.originXByParent = snapshot3.originXByParent;
                    snapshot2.originYByParent = snapshot3.originYByParent;
                    snapshot2.height = snapshot3.height;
                    snapshot2.width = snapshot3.width;
                    next.sourceViewSnapshot = snapshot;
                    next.targetViewSnapshot = snapshot2;
                    disableCleaningForViewTag(view3.getId());
                    disableCleaningForViewTag(view4.getId());
                }
            }
            startSharedTransition(arrayList, 4);
        }
    }

    /* access modifiers changed from: protected */
    public boolean prepareSharedTransition(List<View> list, boolean z) {
        if (list.isEmpty()) {
            return false;
        }
        sortViewsByTags(list);
        List<SharedElement> sharedElementsForCurrentTransition = getSharedElementsForCurrentTransition(list, z);
        if (sharedElementsForCurrentTransition.isEmpty()) {
            return false;
        }
        setupTransitionContainer();
        reparentSharedViewsForCurrentTransition(sharedElementsForCurrentTransition);
        orderByAnimationTypes(sharedElementsForCurrentTransition);
        return true;
    }

    /* access modifiers changed from: protected */
    public void onScreenWillDisappear() {
        if (this.mIsTransitionPrepared) {
            this.mIsTransitionPrepared = false;
            for (SharedElement next : this.mSharedElementsWithAnimation) {
                next.targetViewSnapshot = new Snapshot(next.targetView);
            }
            for (SharedElement next2 : this.mSharedElementsWithProgress) {
                next2.targetViewSnapshot = new Snapshot(next2.targetView);
            }
            startPreparedTransitions();
            for (Integer intValue : this.mTagsToCleanup) {
                this.mNativeMethodsHolder.clearAnimationConfig(intValue.intValue());
            }
            this.mTagsToCleanup.clear();
        }
    }

    /* access modifiers changed from: private */
    public boolean tryStartSharedTransitionForViews(List<View> list, boolean z) {
        if (!prepareSharedTransition(list, z)) {
            return false;
        }
        startPreparedTransitions();
        return true;
    }

    private void startPreparedTransitions() {
        startSharedTransition(this.mSharedElementsWithAnimation, 4);
        startSharedTransition(this.mSharedElementsWithProgress, 5);
    }

    private void sortViewsByTags(List<View> list) {
        Collections.sort(list, new SharedTransitionManager$$ExternalSyntheticLambda1());
    }

    private List<SharedElement> getSharedElementsForCurrentTransition(List<View> list, boolean z) {
        View view;
        boolean z2;
        ViewGroup viewGroup;
        boolean z3 = this.mReattachedViews.size() > 0;
        ArrayList<View> arrayList = new ArrayList<>();
        HashSet hashSet = new HashSet();
        if (!z) {
            for (View id : list) {
                hashSet.add(Integer.valueOf(id.getId()));
            }
        }
        ArrayList<SharedElement> arrayList2 = new ArrayList<>();
        ReanimatedNativeHierarchyManager reanimatedNativeHierarchyManager = this.mAnimationsManager.getReanimatedNativeHierarchyManager();
        HashSet hashSet2 = new HashSet();
        for (View id2 : this.mRemovedSharedViews) {
            hashSet2.add(Integer.valueOf(id2.getId()));
        }
        for (View next : list) {
            int findPrecedingViewTagForTransition = this.mNativeMethodsHolder.findPrecedingViewTagForTransition(next.getId());
            if (z3) {
                while (hashSet2.contains(Integer.valueOf(findPrecedingViewTagForTransition))) {
                    this.mNativeMethodsHolder.clearAnimationConfig(findPrecedingViewTagForTransition);
                    findPrecedingViewTagForTransition = this.mNativeMethodsHolder.findPrecedingViewTagForTransition(next.getId());
                }
            }
            boolean z4 = !z && hashSet.contains(Integer.valueOf(findPrecedingViewTagForTransition));
            if (findPrecedingViewTagForTransition >= 0) {
                if (z) {
                    View resolveView = reanimatedNativeHierarchyManager.resolveView(findPrecedingViewTagForTransition);
                    view = next;
                    next = resolveView;
                } else {
                    view = reanimatedNativeHierarchyManager.resolveView(findPrecedingViewTagForTransition);
                }
                if (z4) {
                    clearAllSharedConfigsForView(next);
                    clearAllSharedConfigsForView(view);
                } else {
                    boolean containsKey = this.mCurrentSharedTransitionViews.containsKey(Integer.valueOf(next.getId()));
                    if (!containsKey) {
                        View findScreen = findScreen(next);
                        View findScreen2 = findScreen(view);
                        if (!(findScreen == null || findScreen2 == null || (viewGroup = (ViewGroup) findStack(findScreen)) == null)) {
                            ViewGroupManager viewGroupManager = (ViewGroupManager) reanimatedNativeHierarchyManager.resolveViewManager(viewGroup.getId());
                            int childCount = viewGroupManager.getChildCount(viewGroup);
                            z2 = z3;
                            if (childCount >= 2) {
                                View childAt = viewGroupManager.getChildAt(viewGroup, childCount - 1);
                                View childAt2 = viewGroupManager.getChildAt(viewGroup, childCount - 2);
                                if (!z) {
                                }
                            }
                            z3 = z2;
                        }
                    } else {
                        z2 = z3;
                    }
                    Snapshot snapshot = null;
                    if (z) {
                        this.mViewTagsToHide.add(Integer.valueOf(next.getId()));
                        if (containsKey) {
                            snapshot = new Snapshot(next);
                        } else {
                            makeSnapshot(next);
                        }
                        makeSnapshot(view);
                    } else if (containsKey) {
                        makeSnapshot(next);
                    }
                    if (snapshot == null) {
                        snapshot = this.mSnapshotRegistry.get(Integer.valueOf(next.getId()));
                    }
                    Snapshot snapshot2 = this.mSnapshotRegistry.get(Integer.valueOf(view.getId()));
                    if (snapshot2 != null) {
                        arrayList.add(next);
                        arrayList.add(view);
                        arrayList2.add(new SharedElement(next, snapshot, view, snapshot2));
                    }
                    z3 = z2;
                }
            }
        }
        if (!arrayList.isEmpty()) {
            ArrayList<View> arrayList3 = new ArrayList<>();
            for (SharedElement sharedElement : this.mSharedElements) {
                arrayList3.add(sharedElement.sourceView);
            }
            HashSet hashSet3 = new HashSet();
            for (SharedElement sharedElement2 : arrayList2) {
                hashSet3.add(sharedElement2.sourceView);
            }
            for (View view2 : arrayList3) {
                if (!hashSet3.contains(view2)) {
                    this.mViewTagsToHide.remove(Integer.valueOf(view2.getId()));
                    view2.setVisibility(0);
                }
            }
            this.mCurrentSharedTransitionViews.clear();
            for (View view3 : arrayList) {
                this.mCurrentSharedTransitionViews.put(Integer.valueOf(view3.getId()), view3);
            }
        }
        this.mSharedElements = arrayList2;
        for (SharedElement sharedElement3 : arrayList2) {
            this.mSharedElementsLookup.put(Integer.valueOf(sharedElement3.sourceView.getId()), sharedElement3);
        }
        return arrayList2;
    }

    private void setupTransitionContainer() {
        Activity currentActivity;
        if (this.mTransitionContainer == null) {
            this.mTransitionContainer = new ReactViewGroup(this.mAnimationsManager.getContext());
        }
        if (this.mTransitionContainer.getParent() == null && (currentActivity = this.mAnimationsManager.getContext().getCurrentActivity()) != null) {
            ((ViewGroup) currentActivity.getWindow().getDecorView().getRootView()).addView(this.mTransitionContainer);
            this.mTransitionContainer.bringToFront();
        }
    }

    private void reparentSharedViewsForCurrentTransition(List<SharedElement> list) {
        for (SharedElement sharedElement : list) {
            View view = sharedElement.sourceView;
            if (!this.mSharedTransitionParent.containsKey(Integer.valueOf(view.getId()))) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                int id = viewGroup.getId();
                int indexOfChild = viewGroup.indexOfChild(view);
                this.mSharedTransitionParent.put(Integer.valueOf(view.getId()), (View) view.getParent());
                this.mSharedTransitionInParentIndex.put(Integer.valueOf(view.getId()), Integer.valueOf(indexOfChild));
                SortedSet sortedSet = this.mSharedViewChildrenIndices.get(Integer.valueOf(id));
                if (sortedSet == null) {
                    this.mSharedViewChildrenIndices.put(Integer.valueOf(id), new TreeSet(Collections.singleton(Integer.valueOf(indexOfChild))));
                } else {
                    sortedSet.add(Integer.valueOf(indexOfChild));
                }
            }
        }
        for (SharedElement sharedElement2 : list) {
            View view2 = sharedElement2.sourceView;
            ((ViewGroup) view2.getParent()).removeView(view2);
            ((ViewGroup) this.mTransitionContainer).addView(view2);
            this.mReattachedViews.add(view2);
        }
    }

    private void startSharedTransition(List<SharedElement> list, int i) {
        for (SharedElement next : list) {
            View view = next.sourceView;
            view.setVisibility(0);
            startSharedAnimationForView(view, next.sourceViewSnapshot, next.targetViewSnapshot, i);
            next.targetView.setVisibility(4);
        }
    }

    private void startSharedAnimationForView(View view, Snapshot snapshot, Snapshot snapshot2, int i) {
        HashMap<String, Object> targetMap = snapshot2.toTargetMap();
        HashMap<String, Object> prepareDataForAnimationWorklet = this.mAnimationsManager.prepareDataForAnimationWorklet(snapshot.toCurrentMap(), false, true);
        HashMap hashMap = new HashMap(this.mAnimationsManager.prepareDataForAnimationWorklet(targetMap, true, true));
        hashMap.putAll(prepareDataForAnimationWorklet);
        this.mNativeMethodsHolder.startAnimation(view.getId(), i, hashMap);
    }

    /* access modifiers changed from: protected */
    public void finishSharedAnimation(int i) {
        ViewParent parent;
        if (this.mDisableCleaningForViewTag.containsKey(Integer.valueOf(i))) {
            enableCleaningForViewTag(i);
            return;
        }
        SharedElement sharedElement = this.mSharedElementsLookup.get(Integer.valueOf(i));
        if (sharedElement != null) {
            this.mSharedElementsLookup.remove(Integer.valueOf(i));
            View view = sharedElement.sourceView;
            if (this.mReattachedViews.contains(view)) {
                this.mReattachedViews.remove(view);
                int id = view.getId();
                ((ViewGroup) this.mTransitionContainer).removeView(view);
                int intValue = this.mSharedTransitionInParentIndex.get(Integer.valueOf(id)).intValue();
                ViewGroup viewGroup = (ViewGroup) this.mSharedTransitionParent.get(Integer.valueOf(id));
                int id2 = viewGroup.getId();
                SortedSet sortedSet = this.mSharedViewChildrenIndices.get(Integer.valueOf(id2));
                int size = sortedSet.headSet(Integer.valueOf(intValue)).size();
                sortedSet.remove(Integer.valueOf(intValue));
                if (sortedSet.isEmpty()) {
                    this.mSharedViewChildrenIndices.remove(Integer.valueOf(id2));
                }
                int i2 = intValue - size;
                if (i2 <= viewGroup.getChildCount()) {
                    viewGroup.addView(view, i2);
                } else {
                    viewGroup.addView(view);
                }
                Snapshot snapshot = this.mSnapshotRegistry.get(Integer.valueOf(id));
                if (snapshot != null) {
                    int i3 = snapshot.originX;
                    int i4 = snapshot.originY;
                    if (findStack(view) == null) {
                        snapshot.originX = snapshot.originXByParent;
                        snapshot.originY = snapshot.originYByParent;
                    }
                    HashMap<String, Object> basicMap = snapshot.toBasicMap();
                    HashMap hashMap = new HashMap();
                    for (String next : basicMap.keySet()) {
                        Object obj = basicMap.get(next);
                        if (next.equals(Snapshot.TRANSFORM_MATRIX)) {
                            hashMap.put(next, obj);
                        } else {
                            hashMap.put(next, Double.valueOf((double) PixelUtil.toDIPFromPixel(Utils.convertToFloat(obj))));
                        }
                    }
                    this.mAnimationsManager.progressLayoutAnimation(id, hashMap, true);
                    snapshot.originX = i3;
                    snapshot.originY = i4;
                }
                if (this.mViewTagsToHide.contains(Integer.valueOf(i))) {
                    view.setVisibility(4);
                }
                this.mCurrentSharedTransitionViews.remove(Integer.valueOf(sharedElement.targetView.getId()));
                this.mCurrentSharedTransitionViews.remove(Integer.valueOf(id));
                this.mSharedTransitionParent.remove(Integer.valueOf(id));
                this.mSharedTransitionInParentIndex.remove(Integer.valueOf(id));
            }
            sharedElement.targetView.setVisibility(0);
            if (this.mRemovedSharedViews.contains(view)) {
                this.mRemovedSharedViews.remove(view);
                this.mSnapshotRegistry.remove(Integer.valueOf(view.getId()));
                this.mNativeMethodsHolder.clearAnimationConfig(view.getId());
            }
            if (this.mReattachedViews.isEmpty()) {
                View view2 = this.mTransitionContainer;
                if (!(view2 == null || (parent = view2.getParent()) == null)) {
                    this.mTransitionContainer.post(new SharedTransitionManager$$ExternalSyntheticLambda0(this, parent));
                }
                this.mSharedElements.clear();
                this.mSharedElementsWithProgress.clear();
                this.mSharedElementsWithAnimation.clear();
                this.mViewTagsToHide.clear();
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$finishSharedAnimation$1(ViewParent viewParent) {
        if (this.mReattachedViews.size() <= 0) {
            ((ViewGroup) viewParent).removeView(this.mTransitionContainer);
        }
    }

    @Nullable
    private View findScreen(View view) {
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent.getClass().getSimpleName().equals("Screen")) {
                return (View) parent;
            }
        }
        return null;
    }

    @Nullable
    private View findStack(View view) {
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent.getClass().getSimpleName().equals("ScreenStack")) {
                return (View) parent;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void makeSnapshot(View view) {
        this.mSnapshotRegistry.put(Integer.valueOf(view.getId()), new Snapshot(view));
    }

    class SnapshotTreeVisitor implements TreeVisitor {
        SnapshotTreeVisitor() {
        }

        public void run(View view) {
            if (SharedTransitionManager.this.mAnimationsManager.hasAnimationForTag(view.getId(), 4)) {
                SharedTransitionManager.this.mRemovedSharedViews.add(view);
                SharedTransitionManager.this.makeSnapshot(view);
            }
        }
    }

    class PrepareConfigCleanupTreeVisitor implements TreeVisitor {
        PrepareConfigCleanupTreeVisitor() {
        }

        public void run(View view) {
            SharedTransitionManager.this.mTagsToCleanup.add(Integer.valueOf(view.getId()));
        }
    }

    /* access modifiers changed from: protected */
    public void visitTreeForTags(int[] iArr, TreeVisitor treeVisitor) {
        if (iArr != null) {
            ReanimatedNativeHierarchyManager reanimatedNativeHierarchyManager = this.mAnimationsManager.getReanimatedNativeHierarchyManager();
            for (int resolveView : iArr) {
                visitTree(reanimatedNativeHierarchyManager.resolveView(resolveView), treeVisitor);
            }
        }
    }

    private void visitTree(View view, TreeVisitor treeVisitor) {
        int id = view.getId();
        if (id != -1) {
            ReanimatedNativeHierarchyManager reanimatedNativeHierarchyManager = this.mAnimationsManager.getReanimatedNativeHierarchyManager();
            try {
                treeVisitor.run(view);
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    ViewManager resolveViewManager = reanimatedNativeHierarchyManager.resolveViewManager(id);
                    ViewGroupManager viewGroupManager = resolveViewManager instanceof ViewGroupManager ? (ViewGroupManager) resolveViewManager : null;
                    if (viewGroupManager != null) {
                        for (int i = 0; i < viewGroupManager.getChildCount(viewGroup); i++) {
                            visitTree(viewGroupManager.getChildAt(viewGroup, i), treeVisitor);
                        }
                    }
                }
            } catch (IllegalViewOperationException unused) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void visitNativeTreeAndMakeSnapshot(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (this.mAnimationsManager.hasAnimationForTag(view.getId(), 4)) {
                makeSnapshot(view);
            }
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                visitNativeTreeAndMakeSnapshot(viewGroup.getChildAt(i));
            }
        }
    }

    private void clearAllSharedConfigsForView(View view) {
        int id = view.getId();
        this.mSnapshotRegistry.remove(Integer.valueOf(id));
        this.mNativeMethodsHolder.clearAnimationConfig(id);
    }

    private void disableCleaningForViewTag(int i) {
        Integer num = this.mDisableCleaningForViewTag.get(Integer.valueOf(i));
        if (num != null) {
            this.mDisableCleaningForViewTag.put(Integer.valueOf(i), Integer.valueOf(num.intValue() + 1));
        } else {
            this.mDisableCleaningForViewTag.put(Integer.valueOf(i), 1);
        }
    }

    private void enableCleaningForViewTag(int i) {
        Integer num = this.mDisableCleaningForViewTag.get(Integer.valueOf(i));
        if (num != null) {
            if (num.intValue() == 1) {
                this.mDisableCleaningForViewTag.remove(Integer.valueOf(i));
            } else {
                this.mDisableCleaningForViewTag.put(Integer.valueOf(i), Integer.valueOf(num.intValue() - 1));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void orderByAnimationTypes(List<SharedElement> list) {
        this.mSharedElementsWithProgress.clear();
        this.mSharedElementsWithAnimation.clear();
        for (SharedElement next : list) {
            if (this.mAnimationsManager.hasAnimationForTag(next.sourceView.getId(), 5)) {
                this.mSharedElementsWithProgress.add(next);
            } else {
                this.mSharedElementsWithAnimation.add(next);
            }
        }
    }
}
