package com.facebook.react.fabric.mounting;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.collection.SparseArrayCompat;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.RetryableMountingLayerException;
import com.facebook.react.bridge.SoftAssertions;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.config.ReactFeatureFlags;
import com.facebook.react.fabric.GuardedFrameCallback;
import com.facebook.react.fabric.events.EventEmitterWrapper;
import com.facebook.react.fabric.mounting.MountingManager;
import com.facebook.react.fabric.mounting.mountitems.MountItem;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.react.touch.JSResponderHandler;
import com.facebook.react.uimanager.IViewGroupManager;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.ReactOverflowViewWithInset;
import com.facebook.react.uimanager.ReactRoot;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.RootView;
import com.facebook.react.uimanager.RootViewManager;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.uimanager.ViewManagerRegistry;
import com.facebook.react.views.view.ReactViewGroup;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

public class SurfaceMountingManager {
    private static final boolean SHOW_CHANGED_VIEW_HIERARCHIES = false;
    public static final String TAG = "SurfaceMountingManager";
    /* access modifiers changed from: private */
    public final Set<Integer> mErroneouslyReaddedReactTags = new HashSet();
    private volatile boolean mIsStopped = false;
    private JSResponderHandler mJSResponderHandler;
    private MountingManager.MountItemExecutor mMountItemExecutor;
    private Queue<MountItem> mOnViewAttachMountItems = new ArrayDeque();
    /* access modifiers changed from: private */
    public final Stack<Integer> mReactTagsToRemove = new Stack<>();
    private RemoveDeleteTreeUIFrameCallback mRemoveDeleteTreeUIFrameCallback;
    private volatile boolean mRootViewAttached = false;
    private RootViewManager mRootViewManager;
    private final int mSurfaceId;
    private SparseArrayCompat<Object> mTagSetForStoppedSurface;
    /* access modifiers changed from: private */
    public ConcurrentHashMap<Integer, ViewState> mTagToViewState = new ConcurrentHashMap<>();
    private ThemedReactContext mThemedReactContext;
    private ViewManagerRegistry mViewManagerRegistry;

    public ThemedReactContext getContext() {
        return this.mThemedReactContext;
    }

    public int getSurfaceId() {
        return this.mSurfaceId;
    }

    public boolean isRootViewAttached() {
        return this.mRootViewAttached;
    }

    public boolean isStopped() {
        return this.mIsStopped;
    }

    public SurfaceMountingManager(int i, JSResponderHandler jSResponderHandler, ViewManagerRegistry viewManagerRegistry, RootViewManager rootViewManager, MountingManager.MountItemExecutor mountItemExecutor, ThemedReactContext themedReactContext) {
        this.mSurfaceId = i;
        this.mJSResponderHandler = jSResponderHandler;
        this.mViewManagerRegistry = viewManagerRegistry;
        this.mRootViewManager = rootViewManager;
        this.mMountItemExecutor = mountItemExecutor;
        this.mThemedReactContext = themedReactContext;
    }

    public void attachRootView(View view, ThemedReactContext themedReactContext) {
        this.mThemedReactContext = themedReactContext;
        addRootView(view);
    }

    private static void logViewHierarchy(ViewGroup viewGroup, boolean z) {
        int i;
        int id = viewGroup.getId();
        String str = TAG;
        FLog.e(str, "  <ViewGroup tag=" + id + " class=" + viewGroup.getClass().toString() + ">");
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            String str2 = TAG;
            FLog.e(str2, "     <View idx=" + i2 + " tag=" + viewGroup.getChildAt(i2).getId() + " class=" + viewGroup.getChildAt(i2).getClass().toString() + ">");
        }
        String str3 = TAG;
        FLog.e(str3, "  </ViewGroup tag=" + id + ">");
        if (z) {
            FLog.e(str3, "Displaying Ancestors:");
            for (ViewParent parent = viewGroup.getParent(); parent != null; parent = parent.getParent()) {
                ViewGroup viewGroup2 = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                if (viewGroup2 == null) {
                    i = -1;
                } else {
                    i = viewGroup2.getId();
                }
                String str4 = TAG;
                FLog.e(str4, "<ViewParent tag=" + i + " class=" + parent.getClass().toString() + ">");
            }
        }
    }

    public boolean getViewExists(int i) {
        SparseArrayCompat<Object> sparseArrayCompat = this.mTagSetForStoppedSurface;
        if (sparseArrayCompat != null && sparseArrayCompat.containsKey(i)) {
            return true;
        }
        ConcurrentHashMap<Integer, ViewState> concurrentHashMap = this.mTagToViewState;
        if (concurrentHashMap == null) {
            return false;
        }
        return concurrentHashMap.containsKey(Integer.valueOf(i));
    }

    public void scheduleMountItemOnViewAttach(MountItem mountItem) {
        this.mOnViewAttachMountItems.add(mountItem);
    }

    private void addRootView(View view) {
        if (!isStopped()) {
            this.mTagToViewState.put(Integer.valueOf(this.mSurfaceId), new ViewState(this.mSurfaceId, view, this.mRootViewManager, true));
            SurfaceMountingManager$$ExternalSyntheticLambda1 surfaceMountingManager$$ExternalSyntheticLambda1 = new SurfaceMountingManager$$ExternalSyntheticLambda1(this, view);
            if (UiThreadUtil.isOnUiThread()) {
                surfaceMountingManager$$ExternalSyntheticLambda1.run();
            } else {
                UiThreadUtil.runOnUiThread(surfaceMountingManager$$ExternalSyntheticLambda1);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$addRootView$0(View view) {
        if (!isStopped()) {
            if (view.getId() == this.mSurfaceId) {
                String str = TAG;
                ReactSoftExceptionLogger.logSoftException(str, new IllegalViewOperationException("Race condition in addRootView detected. Trying to set an id of [" + this.mSurfaceId + "] on the RootView, but that id has already been set. "));
            } else if (view.getId() != -1) {
                FLog.e(TAG, "Trying to add RootTag to RootView that already has a tag: existing tag: [%d] new tag: [%d]", Integer.valueOf(view.getId()), Integer.valueOf(this.mSurfaceId));
                throw new IllegalViewOperationException("Trying to add a root view with an explicit id already set. React Native uses the id field to track react tags and will overwrite this field. If that is fine, explicitly overwrite the id field to View.NO_ID before calling addRootView.");
            }
            view.setId(this.mSurfaceId);
            if (view instanceof ReactRoot) {
                ((ReactRoot) view).setRootViewTag(this.mSurfaceId);
            }
            this.mRootViewAttached = true;
            executeMountItemsOnViewAttach();
        }
    }

    private void executeMountItemsOnViewAttach() {
        this.mMountItemExecutor.executeItems(this.mOnViewAttachMountItems);
    }

    public void stopSurface() {
        String str = TAG;
        FLog.e(str, "Stopping surface [" + this.mSurfaceId + "]");
        if (!isStopped()) {
            this.mIsStopped = true;
            for (ViewState next : this.mTagToViewState.values()) {
                if (next.mStateWrapper != null) {
                    next.mStateWrapper.destroyState();
                    next.mStateWrapper = null;
                }
                if (next.mEventEmitter != null) {
                    next.mEventEmitter.destroy();
                    next.mEventEmitter = null;
                }
            }
            SurfaceMountingManager$$ExternalSyntheticLambda0 surfaceMountingManager$$ExternalSyntheticLambda0 = new SurfaceMountingManager$$ExternalSyntheticLambda0(this);
            if (UiThreadUtil.isOnUiThread()) {
                surfaceMountingManager$$ExternalSyntheticLambda0.run();
            } else {
                UiThreadUtil.runOnUiThread(surfaceMountingManager$$ExternalSyntheticLambda0);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$stopSurface$1() {
        this.mTagSetForStoppedSurface = new SparseArrayCompat<>();
        for (Map.Entry next : this.mTagToViewState.entrySet()) {
            this.mTagSetForStoppedSurface.put(((Integer) next.getKey()).intValue(), this);
            onViewStateDeleted((ViewState) next.getValue());
        }
        this.mTagToViewState = null;
        this.mJSResponderHandler = null;
        this.mRootViewManager = null;
        this.mMountItemExecutor = null;
        this.mThemedReactContext = null;
        this.mOnViewAttachMountItems.clear();
        if (ReactFeatureFlags.enableViewRecycling) {
            this.mViewManagerRegistry.onSurfaceStopped(this.mSurfaceId);
        }
        String str = TAG;
        FLog.e(str, "Surface [" + this.mSurfaceId + "] was stopped on SurfaceMountingManager.");
    }

    public void addViewAt(int i, int i2, int i3) {
        UiThreadUtil.assertOnUiThread();
        if (!isStopped()) {
            ViewState viewState = getViewState(i);
            if (viewState.mView instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) viewState.mView;
                ViewState viewState2 = getViewState(i2);
                View view = viewState2.mView;
                if (view != null) {
                    ViewParent parent = view.getParent();
                    if (parent != null) {
                        boolean z = parent instanceof ViewGroup;
                        int id = z ? ((ViewGroup) parent).getId() : -1;
                        ReactSoftExceptionLogger.logSoftException(TAG, new IllegalStateException("addViewAt: cannot insert view [" + i2 + "] into parent [" + i + "]: View already has a parent: [" + id + "]  Parent: " + parent.getClass().getSimpleName() + " View: " + view.getClass().getSimpleName()));
                        if (ReactNativeFeatureFlags.enableFixForClippedSubviewsCrash()) {
                            if (parent instanceof ReactViewGroup) {
                                ReactViewGroup reactViewGroup = (ReactViewGroup) parent;
                                if (reactViewGroup.getRemoveClippedSubviews()) {
                                    reactViewGroup.removeViewWithSubviewClippingEnabled(view);
                                } else {
                                    reactViewGroup.removeView(view);
                                }
                            } else if (z) {
                                ((ViewGroup) parent).removeView(view);
                            }
                        } else if (z) {
                            ((ViewGroup) parent).removeView(view);
                        }
                        this.mErroneouslyReaddedReactTags.add(Integer.valueOf(i2));
                    }
                    try {
                        getViewGroupManager(viewState).addView(viewGroup, view, i3);
                    } catch (IllegalStateException e) {
                        throw new IllegalStateException("addViewAt: failed to insert view [" + i2 + "] into parent [" + i + "] at index " + i3, e);
                    }
                } else {
                    throw new IllegalStateException("Unable to find view for viewState " + viewState2 + " and tag " + i2);
                }
            } else {
                String str = "Unable to add a view into a view that is not a ViewGroup. ParentTag: " + i + " - Tag: " + i2 + " - Index: " + i3;
                FLog.e(TAG, str);
                throw new IllegalStateException(str);
            }
        }
    }

    public void removeViewAt(int i, int i2, int i3) {
        if (!isStopped()) {
            if (this.mErroneouslyReaddedReactTags.contains(Integer.valueOf(i))) {
                ReactSoftExceptionLogger.logSoftException(TAG, new IllegalViewOperationException("removeViewAt tried to remove a React View that was actually reused. This indicates a bug in the Differ (specifically instruction ordering). [" + i + "]"));
                return;
            }
            UiThreadUtil.assertOnUiThread();
            ViewState nullableViewState = getNullableViewState(i2);
            if (nullableViewState == null) {
                ReactSoftExceptionLogger.logSoftException(MountingManager.TAG, new IllegalStateException("Unable to find viewState for tag: [" + i2 + "] for removeViewAt"));
            } else if (nullableViewState.mView instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) nullableViewState.mView;
                if (viewGroup != null) {
                    IViewGroupManager<ViewGroup> viewGroupManager = getViewGroupManager(nullableViewState);
                    View childAt = viewGroupManager.getChildAt(viewGroup, i3);
                    int id = childAt != null ? childAt.getId() : -1;
                    if (id != i) {
                        int childCount = viewGroup.getChildCount();
                        int i4 = 0;
                        while (true) {
                            if (i4 >= childCount) {
                                i4 = -1;
                                break;
                            } else if (viewGroup.getChildAt(i4).getId() == i) {
                                break;
                            } else {
                                i4++;
                            }
                        }
                        if (i4 == -1) {
                            FLog.e(TAG, "removeViewAt: [" + i + "] -> [" + i2 + "] @" + i3 + ": view already removed from parent! Children in parent: " + childCount);
                            return;
                        }
                        logViewHierarchy(viewGroup, true);
                        ReactSoftExceptionLogger.logSoftException(TAG, new IllegalStateException("Tried to remove view [" + i + "] of parent [" + i2 + "] at index " + i3 + ", but got view tag " + id + " - actual index of view: " + i4));
                        i3 = i4;
                    }
                    try {
                        viewGroupManager.removeViewAt(viewGroup, i3);
                    } catch (RuntimeException e) {
                        int childCount2 = viewGroupManager.getChildCount(viewGroup);
                        logViewHierarchy(viewGroup, true);
                        throw new IllegalStateException("Cannot remove child at index " + i3 + " from parent ViewGroup [" + viewGroup.getId() + "], only " + childCount2 + " children in parent. Warning: childCount may be incorrect!", e);
                    }
                } else {
                    throw new IllegalStateException("Unable to find view for tag [" + i2 + "]");
                }
            } else {
                String str = "Unable to remove a view from a view that is not a ViewGroup. ParentTag: " + i2 + " - Tag: " + i + " - Index: " + i3;
                FLog.e(TAG, str);
                throw new IllegalStateException(str);
            }
        }
    }

    public void removeDeleteTreeAt(int i, int i2, int i3) {
        if (!isStopped()) {
            UiThreadUtil.assertOnUiThread();
            ViewState nullableViewState = getNullableViewState(i2);
            if (nullableViewState == null) {
                ReactSoftExceptionLogger.logSoftException(MountingManager.TAG, new IllegalStateException("Unable to find viewState for tag: [" + i2 + "] for removeDeleteTreeAt"));
            } else if (nullableViewState.mView instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) nullableViewState.mView;
                if (viewGroup != null) {
                    IViewGroupManager<ViewGroup> viewGroupManager = getViewGroupManager(nullableViewState);
                    View childAt = viewGroupManager.getChildAt(viewGroup, i3);
                    int id = childAt != null ? childAt.getId() : -1;
                    if (id != i) {
                        int childCount = viewGroup.getChildCount();
                        int i4 = 0;
                        while (true) {
                            if (i4 >= childCount) {
                                i4 = -1;
                                break;
                            } else if (viewGroup.getChildAt(i4).getId() == i) {
                                break;
                            } else {
                                i4++;
                            }
                        }
                        if (i4 == -1) {
                            FLog.e(TAG, "removeDeleteTreeAt: [" + i + "] -> [" + i2 + "] @" + i3 + ": view already removed from parent! Children in parent: " + childCount);
                            return;
                        }
                        logViewHierarchy(viewGroup, true);
                        ReactSoftExceptionLogger.logSoftException(TAG, new IllegalStateException("Tried to remove+delete view [" + i + "] of parent [" + i2 + "] at index " + i3 + ", but got view tag " + id + " - actual index of view: " + i4));
                        i3 = i4;
                    }
                    try {
                        viewGroupManager.removeViewAt(viewGroup, i3);
                        if (this.mReactTagsToRemove.empty()) {
                            if (this.mRemoveDeleteTreeUIFrameCallback == null) {
                                this.mRemoveDeleteTreeUIFrameCallback = new RemoveDeleteTreeUIFrameCallback(this.mThemedReactContext);
                            }
                            ReactChoreographer.getInstance().postFrameCallback(ReactChoreographer.CallbackType.IDLE_EVENT, this.mRemoveDeleteTreeUIFrameCallback);
                        }
                        this.mReactTagsToRemove.push(Integer.valueOf(i));
                    } catch (RuntimeException e) {
                        int childCount2 = viewGroupManager.getChildCount(viewGroup);
                        logViewHierarchy(viewGroup, true);
                        throw new IllegalStateException("Cannot remove child at index " + i3 + " from parent ViewGroup [" + viewGroup.getId() + "], only " + childCount2 + " children in parent. Warning: childCount may be incorrect!", e);
                    }
                } else {
                    throw new IllegalStateException("Unable to find view for tag [" + i2 + "]");
                }
            } else {
                String str = "Unable to remove+delete a view from a view that is not a ViewGroup. ParentTag: " + i2 + " - Tag: " + i + " - Index: " + i3;
                FLog.e(TAG, str);
                throw new IllegalStateException(str);
            }
        }
    }

    public void createView(String str, int i, ReadableMap readableMap, StateWrapper stateWrapper, EventEmitterWrapper eventEmitterWrapper, boolean z) {
        if (!isStopped()) {
            ViewState nullableViewState = getNullableViewState(i);
            if (nullableViewState == null || nullableViewState.mView == null) {
                createViewUnsafe(str, i, readableMap, stateWrapper, eventEmitterWrapper, z);
            }
        }
    }

    public void createViewUnsafe(String str, int i, ReadableMap readableMap, StateWrapper stateWrapper, EventEmitterWrapper eventEmitterWrapper, boolean z) {
        View view;
        ViewManager viewManager;
        ReactStylesDiffMap reactStylesDiffMap = new ReactStylesDiffMap(readableMap);
        if (z) {
            viewManager = this.mViewManagerRegistry.get(str);
            view = viewManager.createView(i, this.mThemedReactContext, reactStylesDiffMap, stateWrapper, this.mJSResponderHandler);
        } else {
            viewManager = null;
            view = null;
        }
        ViewState viewState = new ViewState(i, view, viewManager);
        viewState.mCurrentProps = reactStylesDiffMap;
        viewState.mStateWrapper = stateWrapper;
        viewState.mEventEmitter = eventEmitterWrapper;
        this.mTagToViewState.put(Integer.valueOf(i), viewState);
    }

    public void updateProps(int i, ReadableMap readableMap) {
        if (!isStopped()) {
            ViewState viewState = getViewState(i);
            viewState.mCurrentProps = new ReactStylesDiffMap(readableMap);
            View view = viewState.mView;
            if (view != null) {
                ((ViewManager) Assertions.assertNotNull(viewState.mViewManager)).updateProperties(view, viewState.mCurrentProps);
                return;
            }
            throw new IllegalStateException("Unable to find view for tag [" + i + "]");
        }
    }

    @Deprecated
    public void receiveCommand(int i, int i2, ReadableArray readableArray) {
        if (!isStopped()) {
            ViewState nullableViewState = getNullableViewState(i);
            if (nullableViewState == null) {
                throw new RetryableMountingLayerException("Unable to find viewState for tag: [" + i + "] for commandId: " + i2);
            } else if (nullableViewState.mViewManager == null) {
                throw new RetryableMountingLayerException("Unable to find viewManager for tag " + i);
            } else if (nullableViewState.mView != null) {
                nullableViewState.mViewManager.receiveCommand(nullableViewState.mView, i2, readableArray);
            } else {
                throw new RetryableMountingLayerException("Unable to find viewState view for tag " + i);
            }
        }
    }

    public void receiveCommand(int i, String str, ReadableArray readableArray) {
        if (!isStopped()) {
            ViewState nullableViewState = getNullableViewState(i);
            if (nullableViewState == null) {
                throw new RetryableMountingLayerException("Unable to find viewState for tag: " + i + " for commandId: " + str);
            } else if (nullableViewState.mViewManager == null) {
                throw new RetryableMountingLayerException("Unable to find viewState manager for tag " + i);
            } else if (nullableViewState.mView != null) {
                nullableViewState.mViewManager.receiveCommand(nullableViewState.mView, str, readableArray);
            } else {
                throw new RetryableMountingLayerException("Unable to find viewState view for tag " + i);
            }
        }
    }

    public void sendAccessibilityEvent(int i, int i2) {
        if (!isStopped()) {
            ViewState viewState = getViewState(i);
            if (viewState.mViewManager == null) {
                throw new RetryableMountingLayerException("Unable to find viewState manager for tag " + i);
            } else if (viewState.mView != null) {
                viewState.mView.sendAccessibilityEvent(i2);
            } else {
                throw new RetryableMountingLayerException("Unable to find viewState view for tag " + i);
            }
        }
    }

    public void updateLayout(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        if (!isStopped()) {
            ViewState viewState = getViewState(i);
            if (!viewState.mIsRoot) {
                View view = viewState.mView;
                if (view != null) {
                    view.measure(View.MeasureSpec.makeMeasureSpec(i5, 1073741824), View.MeasureSpec.makeMeasureSpec(i6, 1073741824));
                    ViewParent parent = view.getParent();
                    if (parent instanceof RootView) {
                        parent.requestLayout();
                    }
                    ViewState viewState2 = getViewState(i2);
                    IViewGroupManager iViewGroupManager = viewState2.mViewManager != null ? (IViewGroupManager) viewState2.mViewManager : null;
                    if (iViewGroupManager == null || !iViewGroupManager.needsCustomLayoutForChildren()) {
                        view.layout(i3, i4, i5 + i3, i6 + i4);
                    }
                    int i8 = i7 == 0 ? 4 : 0;
                    if (view.getVisibility() != i8) {
                        view.setVisibility(i8);
                        return;
                    }
                    return;
                }
                throw new IllegalStateException("Unable to find View for tag: " + i);
            }
        }
    }

    public void updatePadding(int i, int i2, int i3, int i4, int i5) {
        UiThreadUtil.assertOnUiThread();
        if (!isStopped()) {
            ViewState viewState = getViewState(i);
            if (!viewState.mIsRoot) {
                View view = viewState.mView;
                if (view != null) {
                    ViewManager viewManager = viewState.mViewManager;
                    if (viewManager != null) {
                        viewManager.setPadding(view, i2, i3, i4, i5);
                        return;
                    }
                    throw new IllegalStateException("Unable to find ViewManager for view: " + viewState);
                }
                throw new IllegalStateException("Unable to find View for tag: " + i);
            }
        }
    }

    public void updateOverflowInset(int i, int i2, int i3, int i4, int i5) {
        if (!isStopped()) {
            ViewState viewState = getViewState(i);
            if (!viewState.mIsRoot) {
                View view = viewState.mView;
                if (view == null) {
                    throw new IllegalStateException("Unable to find View for tag: " + i);
                } else if (view instanceof ReactOverflowViewWithInset) {
                    ((ReactOverflowViewWithInset) view).setOverflowInset(i2, i3, i4, i5);
                }
            }
        }
    }

    public void updateState(int i, StateWrapper stateWrapper) {
        UiThreadUtil.assertOnUiThread();
        if (!isStopped()) {
            ViewState viewState = getViewState(i);
            StateWrapper stateWrapper2 = viewState.mStateWrapper;
            viewState.mStateWrapper = stateWrapper;
            ViewManager viewManager = viewState.mViewManager;
            if (viewManager != null) {
                Object updateState = viewManager.updateState(viewState.mView, viewState.mCurrentProps, stateWrapper);
                if (updateState != null) {
                    viewManager.updateExtraData(viewState.mView, updateState);
                }
                if (stateWrapper2 != null) {
                    stateWrapper2.destroyState();
                    return;
                }
                return;
            }
            throw new IllegalStateException("Unable to find ViewManager for tag: " + i);
        }
    }

    public void updateEventEmitter(int i, EventEmitterWrapper eventEmitterWrapper) {
        UiThreadUtil.assertOnUiThread();
        if (!isStopped()) {
            ViewState viewState = this.mTagToViewState.get(Integer.valueOf(i));
            if (viewState == null) {
                viewState = new ViewState(i, (View) null, (ViewManager) null);
                this.mTagToViewState.put(Integer.valueOf(i), viewState);
            }
            EventEmitterWrapper eventEmitterWrapper2 = viewState.mEventEmitter;
            viewState.mEventEmitter = eventEmitterWrapper;
            if (!(eventEmitterWrapper2 == eventEmitterWrapper || eventEmitterWrapper2 == null)) {
                eventEmitterWrapper2.destroy();
            }
            Queue<PendingViewEvent> queue = viewState.mPendingEventQueue;
            if (queue != null) {
                for (PendingViewEvent dispatch : queue) {
                    dispatch.dispatch(eventEmitterWrapper);
                }
                viewState.mPendingEventQueue = null;
            }
        }
    }

    public synchronized void setJSResponder(int i, int i2, boolean z) {
        UiThreadUtil.assertOnUiThread();
        if (!isStopped()) {
            if (!z) {
                this.mJSResponderHandler.setJSResponder(i2, (ViewParent) null);
                return;
            }
            ViewState viewState = getViewState(i);
            View view = viewState.mView;
            if (i2 != i && (view instanceof ViewParent)) {
                this.mJSResponderHandler.setJSResponder(i2, (ViewParent) view);
            } else if (view == null) {
                SoftAssertions.assertUnreachable("Cannot find view for tag [" + i + "].");
            } else {
                if (viewState.mIsRoot) {
                    SoftAssertions.assertUnreachable("Cannot block native responder on [" + i + "] that is a root view");
                }
                this.mJSResponderHandler.setJSResponder(i2, view.getParent());
            }
        }
    }

    /* access modifiers changed from: private */
    public void onViewStateDeleted(ViewState viewState) {
        if (viewState.mStateWrapper != null) {
            viewState.mStateWrapper.destroyState();
            viewState.mStateWrapper = null;
        }
        if (viewState.mEventEmitter != null) {
            viewState.mEventEmitter.destroy();
            viewState.mEventEmitter = null;
        }
        ViewManager viewManager = viewState.mViewManager;
        if (!viewState.mIsRoot && viewManager != null) {
            viewManager.onDropViewInstance(viewState.mView);
        }
    }

    public void deleteView(int i) {
        UiThreadUtil.assertOnUiThread();
        if (!isStopped()) {
            ViewState nullableViewState = getNullableViewState(i);
            if (nullableViewState == null) {
                String str = MountingManager.TAG;
                ReactSoftExceptionLogger.logSoftException(str, new IllegalStateException("Unable to find viewState for tag: " + i + " for deleteView"));
                return;
            }
            this.mTagToViewState.remove(Integer.valueOf(i));
            onViewStateDeleted(nullableViewState);
        }
    }

    public void preallocateView(String str, int i, ReadableMap readableMap, StateWrapper stateWrapper, EventEmitterWrapper eventEmitterWrapper, boolean z) {
        UiThreadUtil.assertOnUiThread();
        if (!isStopped() && getNullableViewState(i) == null) {
            createViewUnsafe(str, i, readableMap, stateWrapper, eventEmitterWrapper, z);
        }
    }

    public EventEmitterWrapper getEventEmitter(int i) {
        ViewState nullableViewState = getNullableViewState(i);
        if (nullableViewState == null) {
            return null;
        }
        return nullableViewState.mEventEmitter;
    }

    public View getView(int i) {
        View view;
        ViewState nullableViewState = getNullableViewState(i);
        if (nullableViewState == null) {
            view = null;
        } else {
            view = nullableViewState.mView;
        }
        if (view != null) {
            return view;
        }
        throw new IllegalViewOperationException("Trying to resolve view with tag " + i + " which doesn't exist");
    }

    private ViewState getViewState(int i) {
        ViewState viewState = this.mTagToViewState.get(Integer.valueOf(i));
        if (viewState != null) {
            return viewState;
        }
        throw new RetryableMountingLayerException("Unable to find viewState for tag " + i + ". Surface stopped: " + isStopped());
    }

    /* access modifiers changed from: private */
    public ViewState getNullableViewState(int i) {
        ConcurrentHashMap<Integer, ViewState> concurrentHashMap = this.mTagToViewState;
        if (concurrentHashMap == null) {
            return null;
        }
        return concurrentHashMap.get(Integer.valueOf(i));
    }

    private static IViewGroupManager<ViewGroup> getViewGroupManager(ViewState viewState) {
        if (viewState.mViewManager != null) {
            return (IViewGroupManager) viewState.mViewManager;
        }
        throw new IllegalStateException("Unable to find ViewManager for view: " + viewState);
    }

    public void printSurfaceState() {
        FLog.e(TAG, "Views created for surface {%d}:", Integer.valueOf(getSurfaceId()));
        for (ViewState next : this.mTagToViewState.values()) {
            Integer num = null;
            String name = next.mViewManager != null ? next.mViewManager.getName() : null;
            View view = next.mView;
            View view2 = view != null ? (View) view.getParent() : null;
            if (view2 != null) {
                num = Integer.valueOf(view2.getId());
            }
            FLog.e(TAG, "<%s id=%d parentTag=%s isRoot=%b />", name, Integer.valueOf(next.mReactTag), num, Boolean.valueOf(next.mIsRoot));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0005, code lost:
        r2 = r0.get(java.lang.Integer.valueOf(r2));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void enqueuePendingEvent(int r2, java.lang.String r3, boolean r4, com.facebook.react.bridge.WritableMap r5, int r6) {
        /*
            r1 = this;
            java.util.concurrent.ConcurrentHashMap<java.lang.Integer, com.facebook.react.fabric.mounting.SurfaceMountingManager$ViewState> r0 = r1.mTagToViewState
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.Object r2 = r0.get(r2)
            com.facebook.react.fabric.mounting.SurfaceMountingManager$ViewState r2 = (com.facebook.react.fabric.mounting.SurfaceMountingManager.ViewState) r2
            if (r2 != 0) goto L_0x0012
            return
        L_0x0012:
            com.facebook.react.fabric.mounting.SurfaceMountingManager$PendingViewEvent r0 = new com.facebook.react.fabric.mounting.SurfaceMountingManager$PendingViewEvent
            r0.<init>(r3, r5, r6, r4)
            com.facebook.react.fabric.mounting.SurfaceMountingManager$4 r3 = new com.facebook.react.fabric.mounting.SurfaceMountingManager$4
            r3.<init>(r2, r0)
            com.facebook.react.bridge.UiThreadUtil.runOnUiThread(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.fabric.mounting.SurfaceMountingManager.enqueuePendingEvent(int, java.lang.String, boolean, com.facebook.react.bridge.WritableMap, int):void");
    }

    private static class ViewState {
        public ReadableMap mCurrentLocalData;
        public ReactStylesDiffMap mCurrentProps;
        public EventEmitterWrapper mEventEmitter;
        final boolean mIsRoot;
        public Queue<PendingViewEvent> mPendingEventQueue;
        final int mReactTag;
        public StateWrapper mStateWrapper;
        final View mView;
        final ViewManager mViewManager;

        private ViewState(int i, View view, ViewManager viewManager) {
            this(i, view, viewManager, false);
        }

        private ViewState(int i, View view, ViewManager viewManager, boolean z) {
            this.mCurrentProps = null;
            this.mCurrentLocalData = null;
            this.mStateWrapper = null;
            this.mEventEmitter = null;
            this.mPendingEventQueue = null;
            this.mReactTag = i;
            this.mView = view;
            this.mIsRoot = z;
            this.mViewManager = viewManager;
        }

        public String toString() {
            boolean z = this.mViewManager == null;
            return "ViewState [" + this.mReactTag + "] - isRoot: " + this.mIsRoot + " - props: " + this.mCurrentProps + " - localData: " + this.mCurrentLocalData + " - viewManager: " + this.mViewManager + " - isLayoutOnly: " + z;
        }
    }

    private static class PendingViewEvent {
        private final boolean mCanCoalesceEvent;
        private final int mEventCategory;
        private final String mEventName;
        private final WritableMap mParams;

        public PendingViewEvent(String str, WritableMap writableMap, int i, boolean z) {
            this.mEventName = str;
            this.mParams = writableMap;
            this.mEventCategory = i;
            this.mCanCoalesceEvent = z;
        }

        public void dispatch(EventEmitterWrapper eventEmitterWrapper) {
            if (this.mCanCoalesceEvent) {
                eventEmitterWrapper.dispatchUnique(this.mEventName, this.mParams);
            } else {
                eventEmitterWrapper.dispatch(this.mEventName, this.mParams, this.mEventCategory);
            }
        }
    }

    private class RemoveDeleteTreeUIFrameCallback extends GuardedFrameCallback {
        private static final long FRAME_TIME_MS = 16;
        private static final long MAX_TIME_IN_FRAME = 9;

        private RemoveDeleteTreeUIFrameCallback(ReactContext reactContext) {
            super(reactContext);
        }

        private boolean haveExceededNonBatchedFrameTime(long j) {
            return 16 - ((System.nanoTime() - j) / 1000000) < MAX_TIME_IN_FRAME;
        }

        public void doFrameGuarded(long j) {
            Stack stack = new Stack();
            int i = 0;
            while (!SurfaceMountingManager.this.mReactTagsToRemove.empty()) {
                try {
                    int intValue = ((Integer) SurfaceMountingManager.this.mReactTagsToRemove.pop()).intValue();
                    i++;
                    if (SurfaceMountingManager.this.mErroneouslyReaddedReactTags.contains(Integer.valueOf(intValue))) {
                        ReactSoftExceptionLogger.logSoftException(SurfaceMountingManager.TAG, new IllegalViewOperationException("RemoveDeleteTree recursively tried to remove a React View that was actually reused. This indicates a bug in the Differ. [" + intValue + "]"));
                    } else {
                        stack.clear();
                        ViewState r5 = SurfaceMountingManager.this.getNullableViewState(intValue);
                        if (r5 != null) {
                            View view = r5.mView;
                            ViewManager viewManager = r5.mViewManager;
                            if (viewManager instanceof IViewGroupManager) {
                                IViewGroupManager iViewGroupManager = (IViewGroupManager) viewManager;
                                int i2 = 0;
                                boolean z = false;
                                while (true) {
                                    View childAt = iViewGroupManager.getChildAt(view, i2);
                                    if (childAt == null) {
                                        break;
                                    }
                                    int id = childAt.getId();
                                    if (!z) {
                                        if (SurfaceMountingManager.this.getNullableViewState(id) == null) {
                                            z = false;
                                            stack.push(Integer.valueOf(childAt.getId()));
                                            i2++;
                                        }
                                    }
                                    z = true;
                                    stack.push(Integer.valueOf(childAt.getId()));
                                    i2++;
                                }
                                if (z) {
                                    iViewGroupManager.removeAllViews(view);
                                }
                                if (z) {
                                    SurfaceMountingManager.this.mReactTagsToRemove.addAll(stack);
                                }
                            }
                            SurfaceMountingManager.this.mTagToViewState.remove(Integer.valueOf(intValue));
                            SurfaceMountingManager.this.onViewStateDeleted(r5);
                            if (i % 20 == 0 && haveExceededNonBatchedFrameTime(j)) {
                                break;
                            }
                        } else {
                            continue;
                        }
                    }
                } catch (RuntimeException e) {
                    ReactSoftExceptionLogger.logSoftException(SurfaceMountingManager.TAG, e);
                } catch (Throwable th) {
                    if (!SurfaceMountingManager.this.mReactTagsToRemove.empty()) {
                        ReactChoreographer.getInstance().postFrameCallback(ReactChoreographer.CallbackType.IDLE_EVENT, this);
                    } else {
                        SurfaceMountingManager.this.mErroneouslyReaddedReactTags.clear();
                        SurfaceMountingManager.this.mReactTagsToRemove.clear();
                    }
                    throw th;
                }
            }
            if (!SurfaceMountingManager.this.mReactTagsToRemove.empty()) {
                ReactChoreographer.getInstance().postFrameCallback(ReactChoreographer.CallbackType.IDLE_EVENT, this);
                return;
            }
            SurfaceMountingManager.this.mErroneouslyReaddedReactTags.clear();
            SurfaceMountingManager.this.mReactTagsToRemove.clear();
        }
    }
}
