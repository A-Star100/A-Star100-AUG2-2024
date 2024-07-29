package com.onesignal.inAppMessages.internal.display.impl;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.webkit.WebView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import androidx.camera.video.AudioStats;
import androidx.cardview.widget.CardView;
import androidx.core.widget.PopupWindowCompat;
import com.onesignal.common.AndroidUtils;
import com.onesignal.common.ViewUtils;
import com.onesignal.common.threading.Waiter;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.inAppMessages.internal.InAppMessageContent;
import com.onesignal.inAppMessages.internal.display.impl.DraggableRelativeLayout;
import com.onesignal.inAppMessages.internal.display.impl.WebViewManager;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u0000 l2\u00020\u0001:\u0002lmB'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0019\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H@ø\u0001\u0000¢\u0006\u0002\u0010/J2\u00100\u001a\u0002012\u0006\u0010-\u001a\u00020.2\u0006\u00102\u001a\u00020\u00142\u0006\u00103\u001a\u00020\u00142\u0006\u00104\u001a\u00020\u00142\b\u00105\u001a\u0004\u0018\u000106H\u0002J \u00107\u001a\u00020,2\u0006\u00108\u001a\u00020.2\u0006\u00109\u001a\u00020\u00142\u0006\u0010:\u001a\u00020;H\u0002J*\u0010<\u001a\u00020,2\u0006\u00108\u001a\u00020.2\u0006\u0010-\u001a\u00020.2\u0006\u0010:\u001a\u00020;2\b\u0010=\u001a\u0004\u0018\u000106H\u0002J \u0010>\u001a\u00020,2\u0006\u0010?\u001a\u00020\u00102\u0006\u00108\u001a\u00020.2\u0006\u0010-\u001a\u00020.H\u0002J \u0010@\u001a\u00020,2\u0006\u00108\u001a\u00020.2\u0006\u00109\u001a\u00020\u00142\u0006\u0010:\u001a\u00020;H\u0002J\u0011\u0010A\u001a\u00020,H@ø\u0001\u0000¢\u0006\u0002\u0010BJ\b\u0010C\u001a\u00020,H\u0002J\u0010\u0010D\u001a\u00020;2\u0006\u0010E\u001a\u00020FH\u0002J\u0010\u0010G\u001a\u00020F2\u0006\u0010H\u001a\u00020IH\u0002J \u0010J\u001a\u00020K2\u0006\u0010$\u001a\u00020\u00142\u0006\u0010?\u001a\u00020\u00102\u0006\u0010L\u001a\u00020\u0007H\u0002J\b\u0010M\u001a\u00020NH\u0002J\u0010\u0010O\u001a\u00020,2\u0006\u0010&\u001a\u00020'H\u0002J\u0019\u0010P\u001a\u00020,2\u0006\u0010\u000b\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010QJ\b\u0010R\u001a\u00020,H\u0002J\u0011\u0010S\u001a\u00020,H@ø\u0001\u0000¢\u0006\u0002\u0010BJ\u0011\u0010T\u001a\u00020,H@ø\u0001\u0000¢\u0006\u0002\u0010BJ\u0010\u0010U\u001a\u00020\u00072\u0006\u0010H\u001a\u00020IH\u0002J\b\u0010V\u001a\u00020\u0014H\u0002J\u0006\u0010W\u001a\u00020,J\u0010\u0010X\u001a\u00020,2\u0006\u0010Y\u001a\u00020\u0005H\u0002J\u0010\u0010Z\u001a\u00020,2\b\u0010\"\u001a\u0004\u0018\u00010#J\"\u0010[\u001a\u00020,2\u0006\u0010H\u001a\u00020I2\b\u0010\\\u001a\u0004\u0018\u00010N2\u0006\u0010]\u001a\u00020KH\u0002J\u0010\u0010^\u001a\u00020,2\u0006\u0010H\u001a\u00020IH\u0002J\u000e\u0010_\u001a\u00020,2\u0006\u0010\u0002\u001a\u00020\u0003J3\u0010`\u001a\u00020,2\u0006\u0010?\u001a\u00020\u00102\u0006\u0010\\\u001a\u00020N2\b\u0010a\u001a\u0004\u0018\u00010N2\u0006\u0010b\u001a\u00020KH@ø\u0001\u0000¢\u0006\u0002\u0010cJ\u001b\u0010d\u001a\u00020,2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH@ø\u0001\u0000¢\u0006\u0002\u0010QJ\u0019\u0010e\u001a\u00020,2\u0006\u0010f\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010QJ\u0011\u0010g\u001a\u00020,H@ø\u0001\u0000¢\u0006\u0002\u0010BJ\b\u0010h\u001a\u00020iH\u0016J\u0019\u0010j\u001a\u00020,2\u0006\u0010$\u001a\u00020\u0014H@ø\u0001\u0000¢\u0006\u0002\u0010kR\u000e\u0010\n\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00148BX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0014XD¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006n"}, d2 = {"Lcom/onesignal/inAppMessages/internal/display/impl/InAppMessageView;", "", "webView", "Landroid/webkit/WebView;", "messageContent", "Lcom/onesignal/inAppMessages/internal/InAppMessageContent;", "disableDragDismiss", "", "hideGrayOverlay", "(Landroid/webkit/WebView;Lcom/onesignal/inAppMessages/internal/InAppMessageContent;ZZ)V", "cancelDismissTimer", "currentActivity", "Landroid/app/Activity;", "displayDuration", "", "displayPosition", "Lcom/onesignal/inAppMessages/internal/display/impl/WebViewManager$Position;", "getDisplayPosition", "()Lcom/onesignal/inAppMessages/internal/display/impl/WebViewManager$Position;", "displayYSize", "", "getDisplayYSize", "()I", "draggableRelativeLayout", "Lcom/onesignal/inAppMessages/internal/display/impl/DraggableRelativeLayout;", "hasBackground", "isDismissTimerSet", "<set-?>", "isDragging", "()Z", "marginPxSizeBottom", "marginPxSizeLeft", "marginPxSizeRight", "marginPxSizeTop", "messageController", "Lcom/onesignal/inAppMessages/internal/display/impl/InAppMessageView$InAppMessageViewListener;", "pageHeight", "pageWidth", "parentRelativeLayout", "Landroid/widget/RelativeLayout;", "popupWindow", "Landroid/widget/PopupWindow;", "shouldDismissWhenActive", "animateAndDismissLayout", "", "backgroundView", "Landroid/view/View;", "(Landroid/view/View;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateBackgroundColor", "Landroid/animation/ValueAnimator;", "duration", "startColor", "endColor", "animCallback", "Landroid/animation/Animator$AnimatorListener;", "animateBottom", "messageView", "height", "cardViewAnimCallback", "Landroid/view/animation/Animation$AnimationListener;", "animateCenter", "backgroundAnimCallback", "animateInAppMessage", "displayLocation", "animateTop", "checkIfShouldDismiss", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cleanupViewsAfterDismiss", "createAnimationListener", "messageViewCardView", "Landroidx/cardview/widget/CardView;", "createCardView", "context", "Landroid/content/Context;", "createDraggableLayoutParams", "Lcom/onesignal/inAppMessages/internal/display/impl/DraggableRelativeLayout$Params;", "disableDragging", "createParentRelativeLayoutParams", "Landroid/widget/RelativeLayout$LayoutParams;", "createPopupWindow", "delayShowUntilAvailable", "(Landroid/app/Activity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dereferenceViews", "dismissAndAwaitNextMessage", "finishAfterDelay", "getHideDropShadow", "getOverlayColor", "removeAllViews", "setMarginsFromContent", "content", "setMessageController", "setUpDraggableLayout", "relativeLayoutParams", "draggableParams", "setUpParentRelativeLayout", "setWebView", "showDraggableView", "draggableRelativeLayoutParams", "webViewLayoutParams", "(Lcom/onesignal/inAppMessages/internal/display/impl/WebViewManager$Position;Landroid/widget/RelativeLayout$LayoutParams;Landroid/widget/RelativeLayout$LayoutParams;Lcom/onesignal/inAppMessages/internal/display/impl/DraggableRelativeLayout$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showInAppMessageView", "showView", "activity", "startDismissTimerIfNeeded", "toString", "", "updateHeight", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "InAppMessageViewListener", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: InAppMessageView.kt */
public final class InAppMessageView {
    private static final int ACTIVITY_BACKGROUND_COLOR_EMPTY = 0;
    private static final int ACTIVITY_BACKGROUND_COLOR_FULL = Color.parseColor("#BB000000");
    private static final int ACTIVITY_FINISH_AFTER_DISMISS_DELAY_MS = 600;
    private static final int ACTIVITY_INIT_DELAY = 200;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int DRAG_THRESHOLD_PX_SIZE = ViewUtils.INSTANCE.dpToPx(4);
    private static final int IN_APP_BACKGROUND_ANIMATION_DURATION_MS = 400;
    private static final int IN_APP_BANNER_ANIMATION_DURATION_MS = 1000;
    private static final int IN_APP_CENTER_ANIMATION_DURATION_MS = 1000;
    private static final String IN_APP_MESSAGE_CARD_VIEW_TAG = "IN_APP_MESSAGE_CARD_VIEW_TAG";
    private boolean cancelDismissTimer;
    /* access modifiers changed from: private */
    public Activity currentActivity;
    /* access modifiers changed from: private */
    public final boolean disableDragDismiss;
    private final double displayDuration;
    private final WebViewManager.Position displayPosition;
    /* access modifiers changed from: private */
    public DraggableRelativeLayout draggableRelativeLayout;
    /* access modifiers changed from: private */
    public final boolean hasBackground;
    private final boolean hideGrayOverlay;
    private boolean isDismissTimerSet;
    /* access modifiers changed from: private */
    public boolean isDragging;
    private int marginPxSizeBottom;
    private int marginPxSizeLeft;
    private int marginPxSizeRight;
    private int marginPxSizeTop;
    private final InAppMessageContent messageContent;
    /* access modifiers changed from: private */
    public InAppMessageViewListener messageController;
    private int pageHeight;
    private final int pageWidth = -1;
    /* access modifiers changed from: private */
    public RelativeLayout parentRelativeLayout;
    private PopupWindow popupWindow;
    private boolean shouldDismissWhenActive;
    /* access modifiers changed from: private */
    public WebView webView;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&¨\u0006\u0006"}, d2 = {"Lcom/onesignal/inAppMessages/internal/display/impl/InAppMessageView$InAppMessageViewListener;", "", "onMessageWasDismissed", "", "onMessageWasDisplayed", "onMessageWillDismiss", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: InAppMessageView.kt */
    public interface InAppMessageViewListener {
        void onMessageWasDismissed();

        void onMessageWasDisplayed();

        void onMessageWillDismiss();
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: InAppMessageView.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[WebViewManager.Position.values().length];
            iArr[WebViewManager.Position.TOP_BANNER.ordinal()] = 1;
            iArr[WebViewManager.Position.BOTTOM_BANNER.ordinal()] = 2;
            iArr[WebViewManager.Position.CENTER_MODAL.ordinal()] = 3;
            iArr[WebViewManager.Position.FULL_SCREEN.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final void dereferenceViews() {
        this.parentRelativeLayout = null;
        this.draggableRelativeLayout = null;
        this.webView = null;
    }

    private final int getOverlayColor() {
        if (this.hideGrayOverlay) {
            return 0;
        }
        return ACTIVITY_BACKGROUND_COLOR_FULL;
    }

    public final WebViewManager.Position getDisplayPosition() {
        return this.displayPosition;
    }

    public final boolean isDragging() {
        return this.isDragging;
    }

    public final void setMessageController(InAppMessageViewListener inAppMessageViewListener) {
        this.messageController = inAppMessageViewListener;
    }

    public InAppMessageView(WebView webView2, InAppMessageContent inAppMessageContent, boolean z, boolean z2) {
        double d;
        Intrinsics.checkNotNullParameter(inAppMessageContent, "messageContent");
        this.webView = webView2;
        this.messageContent = inAppMessageContent;
        this.disableDragDismiss = z;
        this.hideGrayOverlay = z2;
        this.pageHeight = inAppMessageContent.getPageHeight();
        this.marginPxSizeLeft = ViewUtils.INSTANCE.dpToPx(24);
        this.marginPxSizeRight = ViewUtils.INSTANCE.dpToPx(24);
        this.marginPxSizeTop = ViewUtils.INSTANCE.dpToPx(24);
        this.marginPxSizeBottom = ViewUtils.INSTANCE.dpToPx(24);
        WebViewManager.Position displayLocation = inAppMessageContent.getDisplayLocation();
        Intrinsics.checkNotNull(displayLocation);
        this.displayPosition = displayLocation;
        if (inAppMessageContent.getDisplayDuration() == null) {
            d = AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            Double displayDuration2 = inAppMessageContent.getDisplayDuration();
            Intrinsics.checkNotNull(displayDuration2);
            d = displayDuration2.doubleValue();
        }
        this.displayDuration = d;
        this.hasBackground = !displayLocation.isBanner();
        setMarginsFromContent(inAppMessageContent);
    }

    private final void setMarginsFromContent(InAppMessageContent inAppMessageContent) {
        int i = 0;
        this.marginPxSizeTop = inAppMessageContent.getUseHeightMargin() ? ViewUtils.INSTANCE.dpToPx(24) : 0;
        this.marginPxSizeBottom = inAppMessageContent.getUseHeightMargin() ? ViewUtils.INSTANCE.dpToPx(24) : 0;
        this.marginPxSizeLeft = inAppMessageContent.getUseWidthMargin() ? ViewUtils.INSTANCE.dpToPx(24) : 0;
        if (inAppMessageContent.getUseWidthMargin()) {
            i = ViewUtils.INSTANCE.dpToPx(24);
        }
        this.marginPxSizeRight = i;
    }

    public final void setWebView(WebView webView2) {
        Intrinsics.checkNotNullParameter(webView2, "webView");
        this.webView = webView2;
        Intrinsics.checkNotNull(webView2);
        webView2.setBackgroundColor(0);
    }

    public final Object showView(Activity activity, Continuation<? super Unit> continuation) {
        Object delayShowUntilAvailable = delayShowUntilAvailable(activity, continuation);
        return delayShowUntilAvailable == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? delayShowUntilAvailable : Unit.INSTANCE;
    }

    public final Object checkIfShouldDismiss(Continuation<? super Unit> continuation) {
        if (!this.shouldDismissWhenActive) {
            return Unit.INSTANCE;
        }
        this.shouldDismissWhenActive = false;
        Object finishAfterDelay = finishAfterDelay(continuation);
        return finishAfterDelay == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? finishAfterDelay : Unit.INSTANCE;
    }

    public final Object updateHeight(int i, Continuation<? super Unit> continuation) {
        this.pageHeight = i;
        Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new InAppMessageView$updateHeight$2(this, i, (Continuation<? super InAppMessageView$updateHeight$2>) null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final Object showInAppMessageView(Activity activity, Continuation<? super Unit> continuation) {
        this.currentActivity = activity;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.pageHeight);
        layoutParams.addRule(13);
        RelativeLayout.LayoutParams createParentRelativeLayoutParams = this.hasBackground ? createParentRelativeLayoutParams() : null;
        WebViewManager.Position position = this.displayPosition;
        Object showDraggableView = showDraggableView(position, layoutParams, createParentRelativeLayoutParams, createDraggableLayoutParams(this.pageHeight, position, this.disableDragDismiss), continuation);
        return showDraggableView == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? showDraggableView : Unit.INSTANCE;
    }

    private final int getDisplayYSize() {
        ViewUtils viewUtils = ViewUtils.INSTANCE;
        Activity activity = this.currentActivity;
        Intrinsics.checkNotNull(activity);
        return viewUtils.getWindowHeight(activity);
    }

    private final RelativeLayout.LayoutParams createParentRelativeLayoutParams() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.pageWidth, -1);
        int i = WhenMappings.$EnumSwitchMapping$0[this.displayPosition.ordinal()];
        if (i == 1) {
            layoutParams.addRule(10);
            layoutParams.addRule(14);
        } else if (i == 2) {
            layoutParams.addRule(12);
            layoutParams.addRule(14);
        } else if (i == 3 || i == 4) {
            layoutParams.addRule(13);
        }
        return layoutParams;
    }

    /* access modifiers changed from: private */
    public final DraggableRelativeLayout.Params createDraggableLayoutParams(int i, WebViewManager.Position position, boolean z) {
        DraggableRelativeLayout.Params params = new DraggableRelativeLayout.Params();
        params.setMaxXPos(this.marginPxSizeRight);
        params.setMaxYPos(this.marginPxSizeTop);
        params.setDraggingDisabled(z);
        params.setMessageHeight(i);
        params.setHeight(getDisplayYSize());
        int i2 = WhenMappings.$EnumSwitchMapping$0[position.ordinal()];
        int i3 = 1;
        if (i2 == 1) {
            params.setDragThresholdY(this.marginPxSizeTop - DRAG_THRESHOLD_PX_SIZE);
        } else if (i2 == 2) {
            params.setPosY(getDisplayYSize() - i);
            params.setDragThresholdY(this.marginPxSizeBottom + DRAG_THRESHOLD_PX_SIZE);
        } else if (i2 == 3) {
            int displayYSize = (getDisplayYSize() / 2) - (i / 2);
            params.setDragThresholdY(DRAG_THRESHOLD_PX_SIZE + displayYSize);
            params.setMaxYPos(displayYSize);
            params.setPosY(displayYSize);
        } else if (i2 == 4) {
            InAppMessageView inAppMessageView = this;
            int displayYSize2 = getDisplayYSize() - (this.marginPxSizeBottom + this.marginPxSizeTop);
            params.setMessageHeight(displayYSize2);
            int displayYSize3 = (getDisplayYSize() / 2) - (displayYSize2 / 2);
            params.setDragThresholdY(DRAG_THRESHOLD_PX_SIZE + displayYSize3);
            params.setMaxYPos(displayYSize3);
            params.setPosY(displayYSize3);
        }
        if (position == WebViewManager.Position.TOP_BANNER) {
            i3 = 0;
        }
        params.setDragDirection(i3);
        return params;
    }

    /* access modifiers changed from: private */
    public final Object showDraggableView(WebViewManager.Position position, RelativeLayout.LayoutParams layoutParams, RelativeLayout.LayoutParams layoutParams2, DraggableRelativeLayout.Params params, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new InAppMessageView$showDraggableView$2(this, layoutParams, layoutParams2, params, position, (Continuation<? super InAppMessageView$showDraggableView$2>) null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final void createPopupWindow(RelativeLayout relativeLayout) {
        View view = relativeLayout;
        boolean z = this.hasBackground;
        int i = -1;
        int i2 = z ? -1 : this.pageWidth;
        if (!z) {
            i = -2;
        }
        PopupWindow popupWindow2 = new PopupWindow(view, i2, i, false);
        this.popupWindow = popupWindow2;
        Intrinsics.checkNotNull(popupWindow2);
        popupWindow2.setBackgroundDrawable(new ColorDrawable(0));
        PopupWindow popupWindow3 = this.popupWindow;
        Intrinsics.checkNotNull(popupWindow3);
        int i3 = 1;
        popupWindow3.setTouchable(true);
        PopupWindow popupWindow4 = this.popupWindow;
        Intrinsics.checkNotNull(popupWindow4);
        popupWindow4.setClippingEnabled(false);
        if (!this.hasBackground) {
            int i4 = WhenMappings.$EnumSwitchMapping$0[this.displayPosition.ordinal()];
            if (i4 == 1) {
                i3 = 49;
            } else if (i4 == 2) {
                i3 = 81;
            } else if (!(i4 == 3 || i4 == 4)) {
                throw new NoWhenBranchMatchedException();
            }
        } else {
            i3 = 0;
        }
        int i5 = this.messageContent.isFullBleed() ? 1000 : 1003;
        PopupWindow popupWindow5 = this.popupWindow;
        Intrinsics.checkNotNull(popupWindow5);
        PopupWindowCompat.setWindowLayoutType(popupWindow5, i5);
        PopupWindow popupWindow6 = this.popupWindow;
        Intrinsics.checkNotNull(popupWindow6);
        Activity activity = this.currentActivity;
        Intrinsics.checkNotNull(activity);
        popupWindow6.showAtLocation(activity.getWindow().getDecorView().getRootView(), i3, 0, 0);
    }

    /* access modifiers changed from: private */
    public final void setUpParentRelativeLayout(Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        this.parentRelativeLayout = relativeLayout;
        Intrinsics.checkNotNull(relativeLayout);
        relativeLayout.setBackgroundDrawable(new ColorDrawable(0));
        RelativeLayout relativeLayout2 = this.parentRelativeLayout;
        Intrinsics.checkNotNull(relativeLayout2);
        relativeLayout2.setClipChildren(false);
        RelativeLayout relativeLayout3 = this.parentRelativeLayout;
        Intrinsics.checkNotNull(relativeLayout3);
        relativeLayout3.setClipToPadding(false);
        RelativeLayout relativeLayout4 = this.parentRelativeLayout;
        Intrinsics.checkNotNull(relativeLayout4);
        relativeLayout4.addView(this.draggableRelativeLayout);
    }

    /* access modifiers changed from: private */
    public final void setUpDraggableLayout(Context context, RelativeLayout.LayoutParams layoutParams, DraggableRelativeLayout.Params params) {
        DraggableRelativeLayout draggableRelativeLayout2 = new DraggableRelativeLayout(context);
        this.draggableRelativeLayout = draggableRelativeLayout2;
        if (layoutParams != null) {
            Intrinsics.checkNotNull(draggableRelativeLayout2);
            draggableRelativeLayout2.setLayoutParams(layoutParams);
        }
        DraggableRelativeLayout draggableRelativeLayout3 = this.draggableRelativeLayout;
        Intrinsics.checkNotNull(draggableRelativeLayout3);
        draggableRelativeLayout3.setParams(params);
        DraggableRelativeLayout draggableRelativeLayout4 = this.draggableRelativeLayout;
        Intrinsics.checkNotNull(draggableRelativeLayout4);
        draggableRelativeLayout4.setListener(new InAppMessageView$setUpDraggableLayout$1(this));
        WebView webView2 = this.webView;
        Intrinsics.checkNotNull(webView2);
        if (webView2.getParent() != null) {
            WebView webView3 = this.webView;
            Intrinsics.checkNotNull(webView3);
            ViewParent parent = webView3.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).removeAllViews();
        }
        CardView createCardView = createCardView(context);
        createCardView.setTag(IN_APP_MESSAGE_CARD_VIEW_TAG);
        createCardView.addView(this.webView);
        DraggableRelativeLayout draggableRelativeLayout5 = this.draggableRelativeLayout;
        Intrinsics.checkNotNull(draggableRelativeLayout5);
        draggableRelativeLayout5.setPadding(this.marginPxSizeLeft, this.marginPxSizeTop, this.marginPxSizeRight, this.marginPxSizeBottom);
        DraggableRelativeLayout draggableRelativeLayout6 = this.draggableRelativeLayout;
        Intrinsics.checkNotNull(draggableRelativeLayout6);
        draggableRelativeLayout6.setClipChildren(false);
        DraggableRelativeLayout draggableRelativeLayout7 = this.draggableRelativeLayout;
        Intrinsics.checkNotNull(draggableRelativeLayout7);
        draggableRelativeLayout7.setClipToPadding(false);
        DraggableRelativeLayout draggableRelativeLayout8 = this.draggableRelativeLayout;
        Intrinsics.checkNotNull(draggableRelativeLayout8);
        draggableRelativeLayout8.addView(createCardView);
    }

    private final CardView createCardView(Context context) {
        CardView cardView = new CardView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.displayPosition == WebViewManager.Position.FULL_SCREEN ? -1 : -2);
        layoutParams.addRule(13);
        cardView.setLayoutParams(layoutParams);
        if (Build.VERSION.SDK_INT == 23) {
            cardView.setCardElevation(0.0f);
        } else if (getHideDropShadow(context)) {
            cardView.setCardElevation(0.0f);
        } else {
            cardView.setCardElevation((float) ViewUtils.INSTANCE.dpToPx(5));
        }
        cardView.setRadius((float) ViewUtils.INSTANCE.dpToPx(8));
        cardView.setClipChildren(false);
        cardView.setClipToPadding(false);
        cardView.setPreventCornerOverlap(false);
        cardView.setCardBackgroundColor(0);
        return cardView;
    }

    private final boolean getHideDropShadow(Context context) {
        return AndroidUtils.INSTANCE.getManifestMetaBoolean(context, "com.onesignal.inAppMessageHideDropShadow");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object startDismissTimerIfNeeded(kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof com.onesignal.inAppMessages.internal.display.impl.InAppMessageView$startDismissTimerIfNeeded$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            com.onesignal.inAppMessages.internal.display.impl.InAppMessageView$startDismissTimerIfNeeded$1 r0 = (com.onesignal.inAppMessages.internal.display.impl.InAppMessageView$startDismissTimerIfNeeded$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            com.onesignal.inAppMessages.internal.display.impl.InAppMessageView$startDismissTimerIfNeeded$1 r0 = new com.onesignal.inAppMessages.internal.display.impl.InAppMessageView$startDismissTimerIfNeeded$1
            r0.<init>(r10, r11)
        L_0x0019:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0042
            if (r2 == r5) goto L_0x003a
            if (r2 != r4) goto L_0x0032
            java.lang.Object r0 = r0.L$0
            com.onesignal.inAppMessages.internal.display.impl.InAppMessageView r0 = (com.onesignal.inAppMessages.internal.display.impl.InAppMessageView) r0
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0088
        L_0x0032:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x003a:
            java.lang.Object r2 = r0.L$0
            com.onesignal.inAppMessages.internal.display.impl.InAppMessageView r2 = (com.onesignal.inAppMessages.internal.display.impl.InAppMessageView) r2
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0065
        L_0x0042:
            kotlin.ResultKt.throwOnFailure(r11)
            double r6 = r10.displayDuration
            r8 = 0
            int r11 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r11 <= 0) goto L_0x0090
            boolean r11 = r10.isDismissTimerSet
            if (r11 == 0) goto L_0x0052
            goto L_0x0090
        L_0x0052:
            r10.isDismissTimerSet = r5
            long r6 = (long) r6
            r11 = 1000(0x3e8, float:1.401E-42)
            long r8 = (long) r11
            long r6 = r6 * r8
            r0.L$0 = r10
            r0.label = r5
            java.lang.Object r11 = kotlinx.coroutines.DelayKt.delay(r6, r0)
            if (r11 != r1) goto L_0x0064
            return r1
        L_0x0064:
            r2 = r10
        L_0x0065:
            boolean r11 = r2.cancelDismissTimer
            if (r11 == 0) goto L_0x006e
            r2.cancelDismissTimer = r3
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L_0x006e:
            com.onesignal.inAppMessages.internal.display.impl.InAppMessageView$InAppMessageViewListener r11 = r2.messageController
            if (r11 == 0) goto L_0x0078
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)
            r11.onMessageWillDismiss()
        L_0x0078:
            android.app.Activity r11 = r2.currentActivity
            if (r11 == 0) goto L_0x008b
            r0.L$0 = r2
            r0.label = r4
            java.lang.Object r11 = r2.dismissAndAwaitNextMessage(r0)
            if (r11 != r1) goto L_0x0087
            return r1
        L_0x0087:
            r0 = r2
        L_0x0088:
            r0.isDismissTimerSet = r3
            goto L_0x008d
        L_0x008b:
            r2.shouldDismissWhenActive = r5
        L_0x008d:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L_0x0090:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.display.impl.InAppMessageView.startDismissTimerIfNeeded(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0080 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object delayShowUntilAvailable(android.app.Activity r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.onesignal.inAppMessages.internal.display.impl.InAppMessageView$delayShowUntilAvailable$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.onesignal.inAppMessages.internal.display.impl.InAppMessageView$delayShowUntilAvailable$1 r0 = (com.onesignal.inAppMessages.internal.display.impl.InAppMessageView$delayShowUntilAvailable$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.onesignal.inAppMessages.internal.display.impl.InAppMessageView$delayShowUntilAvailable$1 r0 = new com.onesignal.inAppMessages.internal.display.impl.InAppMessageView$delayShowUntilAvailable$1
            r0.<init>(r6, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0048
            if (r2 == r5) goto L_0x0044
            if (r2 == r4) goto L_0x0038
            if (r2 != r3) goto L_0x0030
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0081
        L_0x0030:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0038:
            java.lang.Object r7 = r0.L$1
            android.app.Activity r7 = (android.app.Activity) r7
            java.lang.Object r2 = r0.L$0
            com.onesignal.inAppMessages.internal.display.impl.InAppMessageView r2 = (com.onesignal.inAppMessages.internal.display.impl.InAppMessageView) r2
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0073
        L_0x0044:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0060
        L_0x0048:
            kotlin.ResultKt.throwOnFailure(r8)
            com.onesignal.common.AndroidUtils r8 = com.onesignal.common.AndroidUtils.INSTANCE
            boolean r8 = r8.isActivityFullyReady(r7)
            if (r8 == 0) goto L_0x0063
            android.widget.RelativeLayout r8 = r6.parentRelativeLayout
            if (r8 != 0) goto L_0x0063
            r0.label = r5
            java.lang.Object r7 = r6.showInAppMessageView(r7, r0)
            if (r7 != r1) goto L_0x0060
            return r1
        L_0x0060:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L_0x0063:
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r4
            r4 = 200(0xc8, double:9.9E-322)
            java.lang.Object r8 = kotlinx.coroutines.DelayKt.delay(r4, r0)
            if (r8 != r1) goto L_0x0072
            return r1
        L_0x0072:
            r2 = r6
        L_0x0073:
            r8 = 0
            r0.L$0 = r8
            r0.L$1 = r8
            r0.label = r3
            java.lang.Object r7 = r2.delayShowUntilAvailable(r7, r0)
            if (r7 != r1) goto L_0x0081
            return r1
        L_0x0081:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.display.impl.InAppMessageView.delayShowUntilAvailable(android.app.Activity, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object dismissAndAwaitNextMessage(Continuation<? super Unit> continuation) {
        DraggableRelativeLayout draggableRelativeLayout2 = this.draggableRelativeLayout;
        if (draggableRelativeLayout2 == null) {
            Logging.error$default("No host presenter to trigger dismiss animation, counting as dismissed already", (Throwable) null, 2, (Object) null);
            dereferenceViews();
            return Unit.INSTANCE;
        }
        Intrinsics.checkNotNull(draggableRelativeLayout2);
        draggableRelativeLayout2.dismiss();
        Object finishAfterDelay = finishAfterDelay(continuation);
        return finishAfterDelay == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? finishAfterDelay : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final Object finishAfterDelay(Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new InAppMessageView$finishAfterDelay$2(this, (Continuation<? super InAppMessageView$finishAfterDelay$2>) null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final void cleanupViewsAfterDismiss() {
        removeAllViews();
        InAppMessageViewListener inAppMessageViewListener = this.messageController;
        if (inAppMessageViewListener != null) {
            inAppMessageViewListener.onMessageWasDismissed();
        }
    }

    public final void removeAllViews() {
        Logging.debug$default("InAppMessageView.removeAllViews()", (Throwable) null, 2, (Object) null);
        if (this.isDismissTimerSet) {
            this.cancelDismissTimer = true;
        }
        DraggableRelativeLayout draggableRelativeLayout2 = this.draggableRelativeLayout;
        if (draggableRelativeLayout2 != null) {
            Intrinsics.checkNotNull(draggableRelativeLayout2);
            draggableRelativeLayout2.removeAllViews();
        }
        PopupWindow popupWindow2 = this.popupWindow;
        if (popupWindow2 != null) {
            Intrinsics.checkNotNull(popupWindow2);
            popupWindow2.dismiss();
        }
        dereferenceViews();
    }

    /* access modifiers changed from: private */
    public final void animateInAppMessage(WebViewManager.Position position, View view, View view2) {
        Intrinsics.checkNotNull(view);
        CardView cardView = (CardView) view.findViewWithTag(IN_APP_MESSAGE_CARD_VIEW_TAG);
        Intrinsics.checkNotNullExpressionValue(cardView, "messageViewCardView");
        Animation.AnimationListener createAnimationListener = createAnimationListener(cardView);
        int i = WhenMappings.$EnumSwitchMapping$0[position.ordinal()];
        if (i == 1) {
            WebView webView2 = this.webView;
            Intrinsics.checkNotNull(webView2);
            animateTop(cardView, webView2.getHeight(), createAnimationListener);
        } else if (i == 2) {
            WebView webView3 = this.webView;
            Intrinsics.checkNotNull(webView3);
            animateBottom(cardView, webView3.getHeight(), createAnimationListener);
        } else if (i == 3 || i == 4) {
            animateCenter(view, view2, createAnimationListener, (Animator.AnimatorListener) null);
        }
    }

    private final Animation.AnimationListener createAnimationListener(CardView cardView) {
        return new InAppMessageView$createAnimationListener$1(cardView, this);
    }

    private final void animateTop(View view, int i, Animation.AnimationListener animationListener) {
        OneSignalAnimate.INSTANCE.animateViewByTranslation(view, (float) ((-i) - this.marginPxSizeTop), 0.0f, 1000, new OneSignalBounceInterpolator(0.1d, 8.0d), animationListener).start();
    }

    private final void animateBottom(View view, int i, Animation.AnimationListener animationListener) {
        OneSignalAnimate.INSTANCE.animateViewByTranslation(view, (float) (i + this.marginPxSizeBottom), 0.0f, 1000, new OneSignalBounceInterpolator(0.1d, 8.0d), animationListener).start();
    }

    private final void animateCenter(View view, View view2, Animation.AnimationListener animationListener, Animator.AnimatorListener animatorListener) {
        Animation animateViewSmallToLarge = OneSignalAnimate.INSTANCE.animateViewSmallToLarge(view, 1000, new OneSignalBounceInterpolator(0.1d, 8.0d), animationListener);
        ValueAnimator animateBackgroundColor = animateBackgroundColor(view2, 400, 0, getOverlayColor(), animatorListener);
        animateViewSmallToLarge.start();
        animateBackgroundColor.start();
    }

    /* access modifiers changed from: private */
    public final Object animateAndDismissLayout(View view, Continuation<? super Unit> continuation) {
        Waiter waiter = new Waiter();
        animateBackgroundColor(view, 400, getOverlayColor(), 0, new InAppMessageView$animateAndDismissLayout$animCallback$1(this, waiter)).start();
        Object waitForWake = waiter.waitForWake(continuation);
        return waitForWake == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? waitForWake : Unit.INSTANCE;
    }

    private final ValueAnimator animateBackgroundColor(View view, int i, int i2, int i3, Animator.AnimatorListener animatorListener) {
        return OneSignalAnimate.INSTANCE.animateViewColor(view, i, i2, i3, animatorListener);
    }

    public String toString() {
        return "InAppMessageView{currentActivity=" + this.currentActivity + ", pageWidth=" + this.pageWidth + ", pageHeight=" + this.pageHeight + ", displayDuration=" + this.displayDuration + ", hasBackground=" + this.hasBackground + ", shouldDismissWhenActive=" + this.shouldDismissWhenActive + ", isDragging=" + this.isDragging + ", disableDragDismiss=" + this.disableDragDismiss + ", displayLocation=" + this.displayPosition + ", webView=" + this.webView + AbstractJsonLexerKt.END_OBJ;
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rXT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/onesignal/inAppMessages/internal/display/impl/InAppMessageView$Companion;", "", "()V", "ACTIVITY_BACKGROUND_COLOR_EMPTY", "", "ACTIVITY_BACKGROUND_COLOR_FULL", "ACTIVITY_FINISH_AFTER_DISMISS_DELAY_MS", "ACTIVITY_INIT_DELAY", "DRAG_THRESHOLD_PX_SIZE", "IN_APP_BACKGROUND_ANIMATION_DURATION_MS", "IN_APP_BANNER_ANIMATION_DURATION_MS", "IN_APP_CENTER_ANIMATION_DURATION_MS", "IN_APP_MESSAGE_CARD_VIEW_TAG", "", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: InAppMessageView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
