package com.onesignal.inAppMessages.internal.display.impl;

import android.app.Activity;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.facebook.common.util.UriUtil;
import com.onesignal.common.AndroidUtils;
import com.onesignal.common.JSONObjectExtensionsKt;
import com.onesignal.common.ViewUtils;
import com.onesignal.common.threading.ThreadUtilsKt;
import com.onesignal.core.internal.application.IActivityLifecycleHandler;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import com.onesignal.debug.LogLevel;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.inAppMessages.internal.InAppMessage;
import com.onesignal.inAppMessages.internal.InAppMessageClickResult;
import com.onesignal.inAppMessages.internal.InAppMessageContent;
import com.onesignal.inAppMessages.internal.InAppMessagePage;
import com.onesignal.inAppMessages.internal.lifecycle.IInAppLifecycleService;
import com.onesignal.inAppMessages.internal.prompt.IInAppMessagePromptFactory;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0001\u0018\u0000 <2\u00020\u0001:\u0003<=>B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0006\u0010\u001d\u001a\u00020\u001eJ\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020 H\u0002J\u0011\u0010!\u001a\u00020\u001eH@ø\u0001\u0000¢\u0006\u0002\u0010\"J\u000e\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\u0010J\u0011\u0010%\u001a\u00020\u001eH@ø\u0001\u0000¢\u0006\u0002\u0010\"J\b\u0010&\u001a\u00020\u001eH\u0002J\u0010\u0010'\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0010\u0010(\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0010\u0010)\u001a\u00020\u001e2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010*\u001a\u00020\u001e2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010+\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010,\u001a\u00020-H\u0002J\u0016\u0010.\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005J\u0012\u00100\u001a\u00020\u001e2\b\u00101\u001a\u0004\u0018\u00010\u0018H\u0002J\u0010\u00102\u001a\u00020\u001e2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J)\u00103\u001a\u00020\u001e2\u0006\u00104\u001a\u00020\u00052\u0006\u00105\u001a\u00020\u00122\u0006\u00106\u001a\u00020\u0010H@ø\u0001\u0000¢\u0006\u0002\u00107J\u001b\u00108\u001a\u00020\u001e2\b\u00109\u001a\u0004\u0018\u00010\u0015H@ø\u0001\u0000¢\u0006\u0002\u0010:J\u0011\u0010;\u001a\u00020\u001eH@ø\u0001\u0000¢\u0006\u0002\u0010\"R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0004\n\u0002\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006?"}, d2 = {"Lcom/onesignal/inAppMessages/internal/display/impl/WebViewManager;", "Lcom/onesignal/core/internal/application/IActivityLifecycleHandler;", "message", "Lcom/onesignal/inAppMessages/internal/InAppMessage;", "activity", "Landroid/app/Activity;", "messageContent", "Lcom/onesignal/inAppMessages/internal/InAppMessageContent;", "_lifecycle", "Lcom/onesignal/inAppMessages/internal/lifecycle/IInAppLifecycleService;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_promptFactory", "Lcom/onesignal/inAppMessages/internal/prompt/IInAppMessagePromptFactory;", "(Lcom/onesignal/inAppMessages/internal/InAppMessage;Landroid/app/Activity;Lcom/onesignal/inAppMessages/internal/InAppMessageContent;Lcom/onesignal/inAppMessages/internal/lifecycle/IInAppLifecycleService;Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/inAppMessages/internal/prompt/IInAppMessagePromptFactory;)V", "closing", "", "currentActivityName", "", "dismissFired", "lastPageHeight", "", "Ljava/lang/Integer;", "messageView", "Lcom/onesignal/inAppMessages/internal/display/impl/InAppMessageView;", "messageViewMutex", "Lkotlinx/coroutines/sync/Mutex;", "webView", "Lcom/onesignal/inAppMessages/internal/display/impl/OSWebView;", "backgroundDismissAndAwaitNextMessage", "", "blurryRenderingWebViewForKitKatWorkAround", "Landroid/webkit/WebView;", "calculateHeightAndShowWebViewAfterNewActivity", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createNewInAppMessageView", "dragToDismissDisabled", "dismissAndAwaitNextMessage", "enableWebViewRemoteDebugging", "getWebViewMaxSizeX", "getWebViewMaxSizeY", "onActivityAvailable", "onActivityStopped", "pageRectToViewHeight", "jsonObject", "Lorg/json/JSONObject;", "setContentSafeAreaInsets", "content", "setMessageView", "view", "setWebViewToMaxSize", "setupWebView", "currentActivity", "base64Message", "isFullScreen", "(Landroid/app/Activity;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showMessageView", "newHeight", "(Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateSafeAreaInsets", "Companion", "OSJavaScriptInterface", "Position", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: WebViewManager.kt */
public final class WebViewManager implements IActivityLifecycleHandler {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EVENT_TYPE_ACTION_TAKEN = "action_taken";
    public static final String EVENT_TYPE_KEY = "type";
    public static final String EVENT_TYPE_PAGE_CHANGE = "page_change";
    public static final String EVENT_TYPE_RENDERING_COMPLETE = "rendering_complete";
    public static final String EVENT_TYPE_RESIZE = "resize";
    public static final String GET_PAGE_META_DATA_JS_FUNCTION = "getPageMetaData()";
    public static final String IAM_DISPLAY_LOCATION_KEY = "displayLocation";
    public static final String IAM_DRAG_TO_DISMISS_DISABLED_KEY = "dragToDismissDisabled";
    public static final String IAM_PAGE_META_DATA_KEY = "pageMetaData";
    public static final String JS_OBJ_NAME = "OSAndroid";
    private static final int MARGIN_PX_SIZE = ViewUtils.INSTANCE.dpToPx(24);
    public static final String SAFE_AREA_JS_OBJECT = "{\n   top: %d,\n   bottom: %d,\n   right: %d,\n   left: %d,\n}";
    public static final String SET_SAFE_AREA_INSETS_JS_FUNCTION = "setSafeAreaInsets(%s)";
    public static final String SET_SAFE_AREA_INSETS_SCRIPT = "\n\n<script>\n    setSafeAreaInsets(%s);\n</script>";
    /* access modifiers changed from: private */
    public final IApplicationService _applicationService;
    /* access modifiers changed from: private */
    public final IInAppLifecycleService _lifecycle;
    /* access modifiers changed from: private */
    public final IInAppMessagePromptFactory _promptFactory;
    /* access modifiers changed from: private */
    public Activity activity;
    /* access modifiers changed from: private */
    public boolean closing;
    /* access modifiers changed from: private */
    public String currentActivityName;
    private boolean dismissFired;
    /* access modifiers changed from: private */
    public Integer lastPageHeight;
    /* access modifiers changed from: private */
    public final InAppMessage message;
    /* access modifiers changed from: private */
    public final InAppMessageContent messageContent;
    /* access modifiers changed from: private */
    public InAppMessageView messageView;
    private final Mutex messageViewMutex = MutexKt.Mutex$default(false, 1, (Object) null);
    /* access modifiers changed from: private */
    public OSWebView webView;

    private final void blurryRenderingWebViewForKitKatWorkAround(WebView webView2) {
    }

    private final void setMessageView(InAppMessageView inAppMessageView) {
        this.messageView = inAppMessageView;
    }

    public WebViewManager(InAppMessage inAppMessage, Activity activity2, InAppMessageContent inAppMessageContent, IInAppLifecycleService iInAppLifecycleService, IApplicationService iApplicationService, IInAppMessagePromptFactory iInAppMessagePromptFactory) {
        Intrinsics.checkNotNullParameter(inAppMessage, OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE);
        Intrinsics.checkNotNullParameter(activity2, "activity");
        Intrinsics.checkNotNullParameter(inAppMessageContent, "messageContent");
        Intrinsics.checkNotNullParameter(iInAppLifecycleService, "_lifecycle");
        Intrinsics.checkNotNullParameter(iApplicationService, "_applicationService");
        Intrinsics.checkNotNullParameter(iInAppMessagePromptFactory, "_promptFactory");
        this.message = inAppMessage;
        this.activity = activity2;
        this.messageContent = inAppMessageContent;
        this._lifecycle = iInAppLifecycleService;
        this._applicationService = iApplicationService;
        this._promptFactory = iInAppMessagePromptFactory;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/onesignal/inAppMessages/internal/display/impl/WebViewManager$Position;", "", "(Ljava/lang/String;I)V", "isBanner", "", "()Z", "TOP_BANNER", "BOTTOM_BANNER", "CENTER_MODAL", "FULL_SCREEN", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: WebViewManager.kt */
    public enum Position {
        TOP_BANNER,
        BOTTOM_BANNER,
        CENTER_MODAL,
        FULL_SCREEN;

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* compiled from: WebViewManager.kt */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

            static {
                int[] iArr = new int[Position.values().length];
                iArr[Position.TOP_BANNER.ordinal()] = 1;
                iArr[Position.BOTTOM_BANNER.ordinal()] = 2;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public final boolean isBanner() {
            int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
            return i == 1 || i == 2;
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007¨\u0006\u0012"}, d2 = {"Lcom/onesignal/inAppMessages/internal/display/impl/WebViewManager$OSJavaScriptInterface;", "", "(Lcom/onesignal/inAppMessages/internal/display/impl/WebViewManager;)V", "getDisplayLocation", "Lcom/onesignal/inAppMessages/internal/display/impl/WebViewManager$Position;", "jsonObject", "Lorg/json/JSONObject;", "getDragToDismissDisabled", "", "getPageHeightData", "", "handleActionTaken", "", "handlePageChange", "handleRenderComplete", "postMessage", "message", "", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: WebViewManager.kt */
    public final class OSJavaScriptInterface {
        public OSJavaScriptInterface() {
        }

        @JavascriptInterface
        public final void postMessage(String str) {
            Intrinsics.checkNotNullParameter(str, OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE);
            try {
                Logging.debug$default("OSJavaScriptInterface:postMessage: " + str, (Throwable) null, 2, (Object) null);
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString("type");
                if (string != null) {
                    switch (string.hashCode()) {
                        case -1484226720:
                            if (string.equals(WebViewManager.EVENT_TYPE_PAGE_CHANGE)) {
                                handlePageChange(jSONObject);
                                return;
                            }
                            return;
                        case -934437708:
                            string.equals(WebViewManager.EVENT_TYPE_RESIZE);
                            return;
                        case 42998156:
                            if (string.equals(WebViewManager.EVENT_TYPE_RENDERING_COMPLETE)) {
                                handleRenderComplete(jSONObject);
                                return;
                            }
                            return;
                        case 1851145598:
                            if (string.equals(WebViewManager.EVENT_TYPE_ACTION_TAKEN)) {
                                InAppMessageView access$getMessageView$p = WebViewManager.this.messageView;
                                if (access$getMessageView$p != null && !access$getMessageView$p.isDragging()) {
                                    handleActionTaken(jSONObject);
                                    return;
                                }
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        private final void handleRenderComplete(JSONObject jSONObject) {
            Position displayLocation = getDisplayLocation(jSONObject);
            int pageHeightData = displayLocation == Position.FULL_SCREEN ? -1 : getPageHeightData(jSONObject);
            boolean dragToDismissDisabled = getDragToDismissDisabled(jSONObject);
            WebViewManager.this.messageContent.setDisplayLocation(displayLocation);
            WebViewManager.this.messageContent.setPageHeight(pageHeightData);
            WebViewManager.this.createNewInAppMessageView(dragToDismissDisabled);
        }

        private final int getPageHeightData(JSONObject jSONObject) {
            try {
                WebViewManager webViewManager = WebViewManager.this;
                Activity access$getActivity$p = webViewManager.activity;
                JSONObject jSONObject2 = jSONObject.getJSONObject(WebViewManager.IAM_PAGE_META_DATA_KEY);
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.getJSONObject(IAM_PAGE_META_DATA_KEY)");
                return webViewManager.pageRectToViewHeight(access$getActivity$p, jSONObject2);
            } catch (JSONException unused) {
                return -1;
            }
        }

        private final Position getDisplayLocation(JSONObject jSONObject) {
            Position position = Position.FULL_SCREEN;
            try {
                if (!jSONObject.has(WebViewManager.IAM_DISPLAY_LOCATION_KEY) || Intrinsics.areEqual(jSONObject.get(WebViewManager.IAM_DISPLAY_LOCATION_KEY), (Object) "")) {
                    return position;
                }
                String optString = jSONObject.optString(WebViewManager.IAM_DISPLAY_LOCATION_KEY, "FULL_SCREEN");
                Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(\n  …                        )");
                Locale locale = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
                String upperCase = optString.toUpperCase(locale);
                Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
                return Position.valueOf(upperCase);
            } catch (JSONException e) {
                e.printStackTrace();
                return position;
            }
        }

        private final boolean getDragToDismissDisabled(JSONObject jSONObject) {
            try {
                return jSONObject.getBoolean(WebViewManager.IAM_DRAG_TO_DISMISS_DISABLED_KEY);
            } catch (JSONException unused) {
                return false;
            }
        }

        private final void handleActionTaken(JSONObject jSONObject) throws JSONException {
            JSONObject jSONObject2 = jSONObject.getJSONObject(TtmlNode.TAG_BODY);
            Intrinsics.checkNotNullExpressionValue(jSONObject2, TtmlNode.TAG_BODY);
            String safeString = JSONObjectExtensionsKt.safeString(jSONObject2, "id");
            WebViewManager.this.closing = jSONObject2.getBoolean("close");
            if (WebViewManager.this.message.isPreview()) {
                WebViewManager.this._lifecycle.messageActionOccurredOnPreview(WebViewManager.this.message, new InAppMessageClickResult(jSONObject2, WebViewManager.this._promptFactory));
            } else if (safeString != null) {
                WebViewManager.this._lifecycle.messageActionOccurredOnMessage(WebViewManager.this.message, new InAppMessageClickResult(jSONObject2, WebViewManager.this._promptFactory));
            }
            if (WebViewManager.this.closing) {
                WebViewManager.this.backgroundDismissAndAwaitNextMessage();
            }
        }

        private final void handlePageChange(JSONObject jSONObject) throws JSONException {
            WebViewManager.this._lifecycle.messagePageChanged(WebViewManager.this.message, new InAppMessagePage(jSONObject));
        }
    }

    /* access modifiers changed from: private */
    public final int pageRectToViewHeight(Activity activity2, JSONObject jSONObject) {
        try {
            int dpToPx = ViewUtils.INSTANCE.dpToPx(jSONObject.getJSONObject("rect").getInt("height"));
            Logging.debug$default("getPageHeightData:pxHeight: " + dpToPx, (Throwable) null, 2, (Object) null);
            int webViewMaxSizeY = getWebViewMaxSizeY(activity2);
            if (dpToPx <= webViewMaxSizeY) {
                return dpToPx;
            }
            Logging.debug$default("getPageHeightData:pxHeight is over screen max: " + webViewMaxSizeY, (Throwable) null, 2, (Object) null);
            return webViewMaxSizeY;
        } catch (JSONException e) {
            Logging.error("pageRectToViewHeight could not get page height", e);
            return -1;
        }
    }

    /* access modifiers changed from: private */
    public final Object updateSafeAreaInsets(Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new WebViewManager$updateSafeAreaInsets$2(this, (Continuation<? super WebViewManager$updateSafeAreaInsets$2>) null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object calculateHeightAndShowWebViewAfterNewActivity(kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.onesignal.inAppMessages.internal.display.impl.WebViewManager$calculateHeightAndShowWebViewAfterNewActivity$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.onesignal.inAppMessages.internal.display.impl.WebViewManager$calculateHeightAndShowWebViewAfterNewActivity$1 r0 = (com.onesignal.inAppMessages.internal.display.impl.WebViewManager$calculateHeightAndShowWebViewAfterNewActivity$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.onesignal.inAppMessages.internal.display.impl.WebViewManager$calculateHeightAndShowWebViewAfterNewActivity$1 r0 = new com.onesignal.inAppMessages.internal.display.impl.WebViewManager$calculateHeightAndShowWebViewAfterNewActivity$1
            r0.<init>(r7, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 1
            r5 = 2
            if (r2 == 0) goto L_0x0048
            if (r2 == r4) goto L_0x0044
            if (r2 == r5) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            java.lang.Object r0 = r0.L$0
            com.onesignal.inAppMessages.internal.display.impl.WebViewManager r0 = (com.onesignal.inAppMessages.internal.display.impl.WebViewManager) r0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x009e
        L_0x0034:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x003c:
            java.lang.Object r2 = r0.L$0
            com.onesignal.inAppMessages.internal.display.impl.WebViewManager r2 = (com.onesignal.inAppMessages.internal.display.impl.WebViewManager) r2
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0085
        L_0x0044:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x006f
        L_0x0048:
            kotlin.ResultKt.throwOnFailure(r8)
            com.onesignal.inAppMessages.internal.display.impl.InAppMessageView r8 = r7.messageView
            if (r8 != 0) goto L_0x0052
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L_0x0052:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            com.onesignal.inAppMessages.internal.display.impl.WebViewManager$Position r8 = r8.getDisplayPosition()
            com.onesignal.inAppMessages.internal.display.impl.WebViewManager$Position r2 = com.onesignal.inAppMessages.internal.display.impl.WebViewManager.Position.FULL_SCREEN
            r6 = 0
            if (r8 != r2) goto L_0x0072
            com.onesignal.inAppMessages.internal.InAppMessageContent r8 = r7.messageContent
            boolean r8 = r8.isFullBleed()
            if (r8 != 0) goto L_0x0072
            r0.label = r4
            java.lang.Object r8 = r7.showMessageView(r6, r0)
            if (r8 != r1) goto L_0x006f
            return r1
        L_0x006f:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L_0x0072:
            java.lang.String r8 = "In app message new activity, calculate height and show "
            com.onesignal.debug.internal.logging.Logging.debug$default(r8, r6, r5, r6)
            com.onesignal.core.internal.application.IApplicationService r8 = r7._applicationService
            r0.L$0 = r7
            r0.label = r5
            java.lang.Object r8 = r8.waitUntilActivityReady(r0)
            if (r8 != r1) goto L_0x0084
            return r1
        L_0x0084:
            r2 = r7
        L_0x0085:
            android.app.Activity r8 = r2.activity
            r2.setWebViewToMaxSize(r8)
            com.onesignal.inAppMessages.internal.InAppMessageContent r8 = r2.messageContent
            boolean r8 = r8.isFullBleed()
            if (r8 == 0) goto L_0x009f
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r8 = r2.updateSafeAreaInsets(r0)
            if (r8 != r1) goto L_0x009d
            return r1
        L_0x009d:
            r0 = r2
        L_0x009e:
            r2 = r0
        L_0x009f:
            com.onesignal.inAppMessages.internal.display.impl.OSWebView r8 = r2.webView
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            com.onesignal.inAppMessages.internal.display.impl.WebViewManager$$ExternalSyntheticLambda0 r0 = new com.onesignal.inAppMessages.internal.display.impl.WebViewManager$$ExternalSyntheticLambda0
            r0.<init>(r2)
            java.lang.String r1 = "getPageMetaData()"
            r8.evaluateJavascript(r1, r0)
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.display.impl.WebViewManager.calculateHeightAndShowWebViewAfterNewActivity(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* renamed from: calculateHeightAndShowWebViewAfterNewActivity$lambda-0  reason: not valid java name */
    public static final void m1038calculateHeightAndShowWebViewAfterNewActivity$lambda0(WebViewManager webViewManager, String str) {
        Intrinsics.checkNotNullParameter(webViewManager, "this$0");
        try {
            ThreadUtilsKt.suspendifyOnThread$default(0, new WebViewManager$calculateHeightAndShowWebViewAfterNewActivity$2$1(webViewManager, webViewManager.pageRectToViewHeight(webViewManager.activity, new JSONObject(str)), (Continuation<? super WebViewManager$calculateHeightAndShowWebViewAfterNewActivity$2$1>) null), 1, (Object) null);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void onActivityAvailable(Activity activity2) {
        Intrinsics.checkNotNullParameter(activity2, "activity");
        String str = this.currentActivityName;
        this.activity = activity2;
        this.currentActivityName = activity2.getLocalClassName();
        Logging.debug$default("In app message activity available currentActivityName: " + this.currentActivityName + " lastActivityName: " + str, (Throwable) null, 2, (Object) null);
        ThreadUtilsKt.suspendifyOnMain(new WebViewManager$onActivityAvailable$1(str, this, (Continuation<? super WebViewManager$onActivityAvailable$1>) null));
    }

    public void onActivityStopped(Activity activity2) {
        Intrinsics.checkNotNullParameter(activity2, "activity");
        Logging.debug$default(StringsKt.trimIndent("\n            In app message activity stopped, cleaning views, currentActivityName: " + this.currentActivityName + "\n            activity: " + this.activity + "\n            messageView: " + this.messageView + "\n            "), (Throwable) null, 2, (Object) null);
        if (this.messageView != null && Intrinsics.areEqual((Object) activity2.getLocalClassName(), (Object) this.currentActivityName)) {
            InAppMessageView inAppMessageView = this.messageView;
            Intrinsics.checkNotNull(inAppMessageView);
            inAppMessageView.removeAllViews();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x008b A[Catch:{ all -> 0x005d }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0096 A[SYNTHETIC, Splitter:B:35:0x0096] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00d3 A[Catch:{ all -> 0x005d }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00e8 A[Catch:{ all -> 0x005d }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object showMessageView(java.lang.Integer r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r9 = this;
            java.lang.String r0 = "In app message, showing first one with height: "
            boolean r1 = r11 instanceof com.onesignal.inAppMessages.internal.display.impl.WebViewManager$showMessageView$1
            if (r1 == 0) goto L_0x0016
            r1 = r11
            com.onesignal.inAppMessages.internal.display.impl.WebViewManager$showMessageView$1 r1 = (com.onesignal.inAppMessages.internal.display.impl.WebViewManager$showMessageView$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0016
            int r11 = r1.label
            int r11 = r11 - r3
            r1.label = r11
            goto L_0x001b
        L_0x0016:
            com.onesignal.inAppMessages.internal.display.impl.WebViewManager$showMessageView$1 r1 = new com.onesignal.inAppMessages.internal.display.impl.WebViewManager$showMessageView$1
            r1.<init>(r9, r11)
        L_0x001b:
            java.lang.Object r11 = r1.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            r4 = 4
            r5 = 3
            r6 = 1
            r7 = 2
            r8 = 0
            if (r3 == 0) goto L_0x0070
            if (r3 == r6) goto L_0x0060
            if (r3 == r7) goto L_0x0050
            if (r3 == r5) goto L_0x0043
            if (r3 != r4) goto L_0x003b
            java.lang.Object r10 = r1.L$0
            kotlinx.coroutines.sync.Mutex r10 = (kotlinx.coroutines.sync.Mutex) r10
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ all -> 0x005d }
            goto L_0x00f7
        L_0x003b:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0043:
            java.lang.Object r10 = r1.L$1
            kotlinx.coroutines.sync.Mutex r10 = (kotlinx.coroutines.sync.Mutex) r10
            java.lang.Object r0 = r1.L$0
            com.onesignal.inAppMessages.internal.display.impl.WebViewManager r0 = (com.onesignal.inAppMessages.internal.display.impl.WebViewManager) r0
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ all -> 0x005d }
            goto L_0x00e4
        L_0x0050:
            java.lang.Object r10 = r1.L$1
            kotlinx.coroutines.sync.Mutex r10 = (kotlinx.coroutines.sync.Mutex) r10
            java.lang.Object r0 = r1.L$0
            com.onesignal.inAppMessages.internal.display.impl.WebViewManager r0 = (com.onesignal.inAppMessages.internal.display.impl.WebViewManager) r0
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ all -> 0x005d }
            goto L_0x00cf
        L_0x005d:
            r11 = move-exception
            goto L_0x00ff
        L_0x0060:
            java.lang.Object r10 = r1.L$2
            kotlinx.coroutines.sync.Mutex r10 = (kotlinx.coroutines.sync.Mutex) r10
            java.lang.Object r3 = r1.L$1
            java.lang.Integer r3 = (java.lang.Integer) r3
            java.lang.Object r6 = r1.L$0
            com.onesignal.inAppMessages.internal.display.impl.WebViewManager r6 = (com.onesignal.inAppMessages.internal.display.impl.WebViewManager) r6
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0087
        L_0x0070:
            kotlin.ResultKt.throwOnFailure(r11)
            kotlinx.coroutines.sync.Mutex r11 = r9.messageViewMutex
            r1.L$0 = r9
            r1.L$1 = r10
            r1.L$2 = r11
            r1.label = r6
            java.lang.Object r3 = r11.lock(r8, r1)
            if (r3 != r2) goto L_0x0084
            return r2
        L_0x0084:
            r6 = r9
            r3 = r10
            r10 = r11
        L_0x0087:
            com.onesignal.inAppMessages.internal.display.impl.InAppMessageView r11 = r6.messageView     // Catch:{ all -> 0x005d }
            if (r11 != 0) goto L_0x0096
            java.lang.String r11 = "No messageView found to update a with a new height."
            com.onesignal.debug.internal.logging.Logging.warn$default(r11, r8, r7, r8)     // Catch:{ all -> 0x005d }
            kotlin.Unit r11 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x005d }
            r10.unlock(r8)
            return r11
        L_0x0096:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x005d }
            r11.<init>(r0)     // Catch:{ all -> 0x005d }
            r11.append(r3)     // Catch:{ all -> 0x005d }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x005d }
            com.onesignal.debug.internal.logging.Logging.debug$default(r11, r8, r7, r8)     // Catch:{ all -> 0x005d }
            com.onesignal.inAppMessages.internal.display.impl.InAppMessageView r11 = r6.messageView     // Catch:{ all -> 0x005d }
            if (r11 == 0) goto L_0x00b3
            com.onesignal.inAppMessages.internal.display.impl.OSWebView r0 = r6.webView     // Catch:{ all -> 0x005d }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)     // Catch:{ all -> 0x005d }
            android.webkit.WebView r0 = (android.webkit.WebView) r0     // Catch:{ all -> 0x005d }
            r11.setWebView(r0)     // Catch:{ all -> 0x005d }
        L_0x00b3:
            if (r3 == 0) goto L_0x00ce
            r6.lastPageHeight = r3     // Catch:{ all -> 0x005d }
            com.onesignal.inAppMessages.internal.display.impl.InAppMessageView r11 = r6.messageView     // Catch:{ all -> 0x005d }
            if (r11 == 0) goto L_0x00ce
            int r0 = r3.intValue()     // Catch:{ all -> 0x005d }
            r1.L$0 = r6     // Catch:{ all -> 0x005d }
            r1.L$1 = r10     // Catch:{ all -> 0x005d }
            r1.L$2 = r8     // Catch:{ all -> 0x005d }
            r1.label = r7     // Catch:{ all -> 0x005d }
            java.lang.Object r11 = r11.updateHeight(r0, r1)     // Catch:{ all -> 0x005d }
            if (r11 != r2) goto L_0x00ce
            return r2
        L_0x00ce:
            r0 = r6
        L_0x00cf:
            com.onesignal.inAppMessages.internal.display.impl.InAppMessageView r11 = r0.messageView     // Catch:{ all -> 0x005d }
            if (r11 == 0) goto L_0x00e4
            android.app.Activity r3 = r0.activity     // Catch:{ all -> 0x005d }
            r1.L$0 = r0     // Catch:{ all -> 0x005d }
            r1.L$1 = r10     // Catch:{ all -> 0x005d }
            r1.L$2 = r8     // Catch:{ all -> 0x005d }
            r1.label = r5     // Catch:{ all -> 0x005d }
            java.lang.Object r11 = r11.showView(r3, r1)     // Catch:{ all -> 0x005d }
            if (r11 != r2) goto L_0x00e4
            return r2
        L_0x00e4:
            com.onesignal.inAppMessages.internal.display.impl.InAppMessageView r11 = r0.messageView     // Catch:{ all -> 0x005d }
            if (r11 == 0) goto L_0x00fa
            r1.L$0 = r10     // Catch:{ all -> 0x005d }
            r1.L$1 = r8     // Catch:{ all -> 0x005d }
            r1.L$2 = r8     // Catch:{ all -> 0x005d }
            r1.label = r4     // Catch:{ all -> 0x005d }
            java.lang.Object r11 = r11.checkIfShouldDismiss(r1)     // Catch:{ all -> 0x005d }
            if (r11 != r2) goto L_0x00f7
            return r2
        L_0x00f7:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x005d }
            goto L_0x00fb
        L_0x00fa:
            r11 = r8
        L_0x00fb:
            r10.unlock(r8)
            return r11
        L_0x00ff:
            r10.unlock(r8)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.display.impl.WebViewManager.showMessageView(java.lang.Integer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setupWebView(android.app.Activity r7, java.lang.String r8, boolean r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r6 = this;
            boolean r0 = r10 instanceof com.onesignal.inAppMessages.internal.display.impl.WebViewManager$setupWebView$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            com.onesignal.inAppMessages.internal.display.impl.WebViewManager$setupWebView$1 r0 = (com.onesignal.inAppMessages.internal.display.impl.WebViewManager$setupWebView$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            com.onesignal.inAppMessages.internal.display.impl.WebViewManager$setupWebView$1 r0 = new com.onesignal.inAppMessages.internal.display.impl.WebViewManager$setupWebView$1
            r0.<init>(r6, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0040
            if (r2 != r3) goto L_0x0038
            java.lang.Object r7 = r0.L$2
            r8 = r7
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r7 = r0.L$1
            android.app.Activity r7 = (android.app.Activity) r7
            java.lang.Object r9 = r0.L$0
            com.onesignal.inAppMessages.internal.display.impl.WebViewManager r9 = (com.onesignal.inAppMessages.internal.display.impl.WebViewManager) r9
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x00c0
        L_0x0038:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0040:
            kotlin.ResultKt.throwOnFailure(r10)
            r6.enableWebViewRemoteDebugging()
            com.onesignal.inAppMessages.internal.display.impl.OSWebView r10 = new com.onesignal.inAppMessages.internal.display.impl.OSWebView
            r2 = r7
            android.content.Context r2 = (android.content.Context) r2
            r10.<init>(r2)
            r6.webView = r10
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            r2 = 2
            r10.setOverScrollMode(r2)
            com.onesignal.inAppMessages.internal.display.impl.OSWebView r10 = r6.webView
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            r2 = 0
            r10.setVerticalScrollBarEnabled(r2)
            com.onesignal.inAppMessages.internal.display.impl.OSWebView r10 = r6.webView
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            r10.setHorizontalScrollBarEnabled(r2)
            com.onesignal.inAppMessages.internal.display.impl.OSWebView r10 = r6.webView
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            android.webkit.WebSettings r10 = r10.getSettings()
            r10.setJavaScriptEnabled(r3)
            com.onesignal.inAppMessages.internal.display.impl.OSWebView r10 = r6.webView
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            com.onesignal.inAppMessages.internal.display.impl.WebViewManager$OSJavaScriptInterface r4 = new com.onesignal.inAppMessages.internal.display.impl.WebViewManager$OSJavaScriptInterface
            r4.<init>()
            java.lang.String r5 = "OSAndroid"
            r10.addJavascriptInterface(r4, r5)
            if (r9 == 0) goto L_0x009d
            com.onesignal.inAppMessages.internal.display.impl.OSWebView r9 = r6.webView
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            r10 = 3074(0xc02, float:4.308E-42)
            r9.setSystemUiVisibility(r10)
            int r9 = android.os.Build.VERSION.SDK_INT
            r10 = 30
            if (r9 < r10) goto L_0x009d
            com.onesignal.inAppMessages.internal.display.impl.OSWebView r9 = r6.webView
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            r9.setFitsSystemWindows(r2)
        L_0x009d:
            com.onesignal.inAppMessages.internal.display.impl.OSWebView r9 = r6.webView
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            android.webkit.WebView r9 = (android.webkit.WebView) r9
            r6.blurryRenderingWebViewForKitKatWorkAround(r9)
            com.onesignal.inAppMessages.internal.lifecycle.IInAppLifecycleService r9 = r6._lifecycle
            com.onesignal.inAppMessages.internal.InAppMessage r10 = r6.message
            r9.messageWillDisplay(r10)
            com.onesignal.core.internal.application.IApplicationService r9 = r6._applicationService
            r0.L$0 = r6
            r0.L$1 = r7
            r0.L$2 = r8
            r0.label = r3
            java.lang.Object r9 = r9.waitUntilActivityReady(r0)
            if (r9 != r1) goto L_0x00bf
            return r1
        L_0x00bf:
            r9 = r6
        L_0x00c0:
            r9.setWebViewToMaxSize(r7)
            com.onesignal.inAppMessages.internal.display.impl.OSWebView r7 = r9.webView
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            java.lang.String r9 = "text/html; charset=utf-8"
            java.lang.String r10 = "base64"
            r7.loadData(r8, r9, r10)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.display.impl.WebViewManager.setupWebView(android.app.Activity, java.lang.String, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void setWebViewToMaxSize(Activity activity2) {
        OSWebView oSWebView = this.webView;
        Intrinsics.checkNotNull(oSWebView);
        oSWebView.layout(0, 0, getWebViewMaxSizeX(activity2), getWebViewMaxSizeY(activity2));
    }

    public final void createNewInAppMessageView(boolean z) {
        this.lastPageHeight = Integer.valueOf(this.messageContent.getPageHeight());
        boolean manifestMetaBoolean = AndroidUtils.INSTANCE.getManifestMetaBoolean(this._applicationService.getAppContext(), "com.onesignal.inAppMessageHideGrayOverlay");
        OSWebView oSWebView = this.webView;
        Intrinsics.checkNotNull(oSWebView);
        setMessageView(new InAppMessageView(oSWebView, this.messageContent, z, manifestMetaBoolean));
        InAppMessageView inAppMessageView = this.messageView;
        Intrinsics.checkNotNull(inAppMessageView);
        inAppMessageView.setMessageController(new WebViewManager$createNewInAppMessageView$1(this, this));
        this._applicationService.addActivityLifecycleHandler(this);
    }

    private final int getWebViewMaxSizeX(Activity activity2) {
        if (this.messageContent.isFullBleed()) {
            return ViewUtils.INSTANCE.getFullbleedWindowWidth(activity2);
        }
        return ViewUtils.INSTANCE.getWindowWidth(activity2) - (MARGIN_PX_SIZE * 2);
    }

    private final int getWebViewMaxSizeY(Activity activity2) {
        return ViewUtils.INSTANCE.getWindowHeight(activity2) - (this.messageContent.isFullBleed() ? 0 : MARGIN_PX_SIZE * 2);
    }

    public final void backgroundDismissAndAwaitNextMessage() {
        ThreadUtilsKt.suspendifyOnThread$default(0, new WebViewManager$backgroundDismissAndAwaitNextMessage$1(this, (Continuation<? super WebViewManager$backgroundDismissAndAwaitNextMessage$1>) null), 1, (Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object dismissAndAwaitNextMessage(kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.onesignal.inAppMessages.internal.display.impl.WebViewManager$dismissAndAwaitNextMessage$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.onesignal.inAppMessages.internal.display.impl.WebViewManager$dismissAndAwaitNextMessage$1 r0 = (com.onesignal.inAppMessages.internal.display.impl.WebViewManager$dismissAndAwaitNextMessage$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.onesignal.inAppMessages.internal.display.impl.WebViewManager$dismissAndAwaitNextMessage$1 r0 = new com.onesignal.inAppMessages.internal.display.impl.WebViewManager$dismissAndAwaitNextMessage$1
            r0.<init>(r5, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r0 = r0.L$0
            com.onesignal.inAppMessages.internal.display.impl.WebViewManager r0 = (com.onesignal.inAppMessages.internal.display.impl.WebViewManager) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0057
        L_0x002e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r6)
            com.onesignal.inAppMessages.internal.display.impl.InAppMessageView r6 = r5.messageView
            if (r6 == 0) goto L_0x0061
            boolean r2 = r5.dismissFired
            if (r2 == 0) goto L_0x0042
            goto L_0x0061
        L_0x0042:
            r5.dismissFired = r3
            com.onesignal.inAppMessages.internal.lifecycle.IInAppLifecycleService r2 = r5._lifecycle
            com.onesignal.inAppMessages.internal.InAppMessage r4 = r5.message
            r2.messageWillDismiss(r4)
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = r6.dismissAndAwaitNextMessage(r0)
            if (r6 != r1) goto L_0x0056
            return r1
        L_0x0056:
            r0 = r5
        L_0x0057:
            r6 = 0
            r0.dismissFired = r6
            r6 = 0
            r0.setMessageView(r6)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x0061:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.display.impl.WebViewManager.dismissAndAwaitNextMessage(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void setContentSafeAreaInsets(InAppMessageContent inAppMessageContent, Activity activity2) {
        Intrinsics.checkNotNullParameter(inAppMessageContent, UriUtil.LOCAL_CONTENT_SCHEME);
        Intrinsics.checkNotNullParameter(activity2, "activity");
        String contentHtml = inAppMessageContent.getContentHtml();
        int[] cutoutAndStatusBarInsets = ViewUtils.INSTANCE.getCutoutAndStatusBarInsets(activity2);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(SAFE_AREA_JS_OBJECT, Arrays.copyOf(new Object[]{Integer.valueOf(cutoutAndStatusBarInsets[0]), Integer.valueOf(cutoutAndStatusBarInsets[1]), Integer.valueOf(cutoutAndStatusBarInsets[2]), Integer.valueOf(cutoutAndStatusBarInsets[3])}, 4));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String format2 = String.format(SET_SAFE_AREA_INSETS_SCRIPT, Arrays.copyOf(new Object[]{format}, 1));
        Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
        inAppMessageContent.setContentHtml(contentHtml + format2);
    }

    private final void enableWebViewRemoteDebugging() {
        if (Logging.atLogLevel(LogLevel.DEBUG)) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/onesignal/inAppMessages/internal/display/impl/WebViewManager$Companion;", "", "()V", "EVENT_TYPE_ACTION_TAKEN", "", "EVENT_TYPE_KEY", "EVENT_TYPE_PAGE_CHANGE", "EVENT_TYPE_RENDERING_COMPLETE", "EVENT_TYPE_RESIZE", "GET_PAGE_META_DATA_JS_FUNCTION", "IAM_DISPLAY_LOCATION_KEY", "IAM_DRAG_TO_DISMISS_DISABLED_KEY", "IAM_PAGE_META_DATA_KEY", "JS_OBJ_NAME", "MARGIN_PX_SIZE", "", "SAFE_AREA_JS_OBJECT", "SET_SAFE_AREA_INSETS_JS_FUNCTION", "SET_SAFE_AREA_INSETS_SCRIPT", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: WebViewManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
