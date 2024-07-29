package com.onesignal.inAppMessages.internal.display.impl;

import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.language.ILanguageContext;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.inAppMessages.internal.backend.IInAppBackendService;
import com.onesignal.inAppMessages.internal.display.IInAppDisplayer;
import com.onesignal.inAppMessages.internal.lifecycle.IInAppLifecycleService;
import com.onesignal.inAppMessages.internal.prompt.IInAppMessagePromptFactory;
import com.onesignal.session.internal.influence.IInfluenceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 (2\u00020\u0001:\u0001(BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001aH@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ\u0019\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001eH@ø\u0001\u0000¢\u0006\u0002\u0010\u001fJ)\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020$H@ø\u0001\u0000¢\u0006\u0002\u0010%J!\u0010&\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020$H@ø\u0001\u0000¢\u0006\u0002\u0010'R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006)"}, d2 = {"Lcom/onesignal/inAppMessages/internal/display/impl/InAppDisplayer;", "Lcom/onesignal/inAppMessages/internal/display/IInAppDisplayer;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_lifecycle", "Lcom/onesignal/inAppMessages/internal/lifecycle/IInAppLifecycleService;", "_promptFactory", "Lcom/onesignal/inAppMessages/internal/prompt/IInAppMessagePromptFactory;", "_backend", "Lcom/onesignal/inAppMessages/internal/backend/IInAppBackendService;", "_influenceManager", "Lcom/onesignal/session/internal/influence/IInfluenceManager;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "_languageContext", "Lcom/onesignal/core/internal/language/ILanguageContext;", "_time", "Lcom/onesignal/core/internal/time/ITime;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/inAppMessages/internal/lifecycle/IInAppLifecycleService;Lcom/onesignal/inAppMessages/internal/prompt/IInAppMessagePromptFactory;Lcom/onesignal/inAppMessages/internal/backend/IInAppBackendService;Lcom/onesignal/session/internal/influence/IInfluenceManager;Lcom/onesignal/core/internal/config/ConfigModelStore;Lcom/onesignal/core/internal/language/ILanguageContext;Lcom/onesignal/core/internal/time/ITime;)V", "lastInstance", "Lcom/onesignal/inAppMessages/internal/display/impl/WebViewManager;", "dismissCurrentInAppMessage", "", "displayMessage", "", "message", "Lcom/onesignal/inAppMessages/internal/InAppMessage;", "(Lcom/onesignal/inAppMessages/internal/InAppMessage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "displayPreviewMessage", "previewUUID", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initInAppMessage", "currentActivity", "Landroid/app/Activity;", "content", "Lcom/onesignal/inAppMessages/internal/InAppMessageContent;", "(Landroid/app/Activity;Lcom/onesignal/inAppMessages/internal/InAppMessage;Lcom/onesignal/inAppMessages/internal/InAppMessageContent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showMessageContent", "(Lcom/onesignal/inAppMessages/internal/InAppMessage;Lcom/onesignal/inAppMessages/internal/InAppMessageContent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: InAppDisplayer.kt */
public final class InAppDisplayer implements IInAppDisplayer {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int IN_APP_MESSAGE_INIT_DELAY = 200;
    private final IApplicationService _applicationService;
    private final IInAppBackendService _backend;
    private final ConfigModelStore _configModelStore;
    private final IInfluenceManager _influenceManager;
    private final ILanguageContext _languageContext;
    private final IInAppLifecycleService _lifecycle;
    private final IInAppMessagePromptFactory _promptFactory;
    private final ITime _time;
    private WebViewManager lastInstance;

    public InAppDisplayer(IApplicationService iApplicationService, IInAppLifecycleService iInAppLifecycleService, IInAppMessagePromptFactory iInAppMessagePromptFactory, IInAppBackendService iInAppBackendService, IInfluenceManager iInfluenceManager, ConfigModelStore configModelStore, ILanguageContext iLanguageContext, ITime iTime) {
        Intrinsics.checkNotNullParameter(iApplicationService, "_applicationService");
        Intrinsics.checkNotNullParameter(iInAppLifecycleService, "_lifecycle");
        Intrinsics.checkNotNullParameter(iInAppMessagePromptFactory, "_promptFactory");
        Intrinsics.checkNotNullParameter(iInAppBackendService, "_backend");
        Intrinsics.checkNotNullParameter(iInfluenceManager, "_influenceManager");
        Intrinsics.checkNotNullParameter(configModelStore, "_configModelStore");
        Intrinsics.checkNotNullParameter(iLanguageContext, "_languageContext");
        Intrinsics.checkNotNullParameter(iTime, "_time");
        this._applicationService = iApplicationService;
        this._lifecycle = iInAppLifecycleService;
        this._promptFactory = iInAppMessagePromptFactory;
        this._backend = iInAppBackendService;
        this._influenceManager = iInfluenceManager;
        this._configModelStore = configModelStore;
        this._languageContext = iLanguageContext;
        this._time = iTime;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object displayMessage(com.onesignal.inAppMessages.internal.InAppMessage r10, kotlin.coroutines.Continuation<? super java.lang.Boolean> r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer$displayMessage$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer$displayMessage$1 r0 = (com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer$displayMessage$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer$displayMessage$1 r0 = new com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer$displayMessage$1
            r0.<init>(r9, r11)
        L_0x0019:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0042
            if (r2 == r4) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00a8
        L_0x002e:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0036:
            java.lang.Object r10 = r0.L$1
            com.onesignal.inAppMessages.internal.InAppMessage r10 = (com.onesignal.inAppMessages.internal.InAppMessage) r10
            java.lang.Object r2 = r0.L$0
            com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer r2 = (com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer) r2
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x006d
        L_0x0042:
            kotlin.ResultKt.throwOnFailure(r11)
            com.onesignal.inAppMessages.internal.backend.IInAppBackendService r11 = r9._backend
            com.onesignal.core.internal.config.ConfigModelStore r2 = r9._configModelStore
            com.onesignal.common.modeling.Model r2 = r2.getModel()
            com.onesignal.core.internal.config.ConfigModel r2 = (com.onesignal.core.internal.config.ConfigModel) r2
            java.lang.String r2 = r2.getAppId()
            java.lang.String r5 = r10.getMessageId()
            com.onesignal.inAppMessages.internal.common.InAppHelper r6 = com.onesignal.inAppMessages.internal.common.InAppHelper.INSTANCE
            com.onesignal.core.internal.language.ILanguageContext r7 = r9._languageContext
            java.lang.String r6 = r6.variantIdForMessage(r10, r7)
            r0.L$0 = r9
            r0.L$1 = r10
            r0.label = r4
            java.lang.Object r11 = r11.getIAMData(r2, r5, r6, r0)
            if (r11 != r1) goto L_0x006c
            return r1
        L_0x006c:
            r2 = r9
        L_0x006d:
            com.onesignal.inAppMessages.internal.backend.GetIAMDataResponse r11 = (com.onesignal.inAppMessages.internal.backend.GetIAMDataResponse) r11
            com.onesignal.inAppMessages.internal.InAppMessageContent r5 = r11.getContent()
            r6 = 0
            if (r5 == 0) goto L_0x00ad
            com.onesignal.inAppMessages.internal.InAppMessageContent r5 = r11.getContent()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            java.lang.Double r5 = r5.getDisplayDuration()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            double r7 = r5.doubleValue()
            r10.setDisplayDuration(r7)
            com.onesignal.session.internal.influence.IInfluenceManager r5 = r2._influenceManager
            java.lang.String r7 = r10.getMessageId()
            r5.onInAppMessageDisplayed(r7)
            com.onesignal.inAppMessages.internal.InAppMessageContent r11 = r11.getContent()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)
            r0.L$0 = r6
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r10 = r2.showMessageContent(r10, r11, r0)
            if (r10 != r1) goto L_0x00a8
            return r1
        L_0x00a8:
            java.lang.Boolean r10 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r10
        L_0x00ad:
            boolean r10 = r11.getShouldRetry()
            if (r10 == 0) goto L_0x00b7
            r10 = r6
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            goto L_0x00bc
        L_0x00b7:
            r10 = 0
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r10)
        L_0x00bc:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer.displayMessage(com.onesignal.inAppMessages.internal.InAppMessage, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object displayPreviewMessage(java.lang.String r9, kotlin.coroutines.Continuation<? super java.lang.Boolean> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer$displayPreviewMessage$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer$displayPreviewMessage$1 r0 = (com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer$displayPreviewMessage$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer$displayPreviewMessage$1 r0 = new com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer$displayPreviewMessage$1
            r0.<init>(r8, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0041
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x008c
        L_0x002d:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0035:
            java.lang.Object r9 = r0.L$1
            com.onesignal.inAppMessages.internal.InAppMessage r9 = (com.onesignal.inAppMessages.internal.InAppMessage) r9
            java.lang.Object r2 = r0.L$0
            com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer r2 = (com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer) r2
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x006a
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r10)
            com.onesignal.inAppMessages.internal.InAppMessage r10 = new com.onesignal.inAppMessages.internal.InAppMessage
            com.onesignal.core.internal.time.ITime r2 = r8._time
            r10.<init>((boolean) r4, (com.onesignal.core.internal.time.ITime) r2)
            com.onesignal.inAppMessages.internal.backend.IInAppBackendService r2 = r8._backend
            com.onesignal.core.internal.config.ConfigModelStore r5 = r8._configModelStore
            com.onesignal.common.modeling.Model r5 = r5.getModel()
            com.onesignal.core.internal.config.ConfigModel r5 = (com.onesignal.core.internal.config.ConfigModel) r5
            java.lang.String r5 = r5.getAppId()
            r0.L$0 = r8
            r0.L$1 = r10
            r0.label = r4
            java.lang.Object r9 = r2.getIAMPreviewData(r5, r9, r0)
            if (r9 != r1) goto L_0x0066
            return r1
        L_0x0066:
            r2 = r8
            r7 = r10
            r10 = r9
            r9 = r7
        L_0x006a:
            com.onesignal.inAppMessages.internal.InAppMessageContent r10 = (com.onesignal.inAppMessages.internal.InAppMessageContent) r10
            if (r10 != 0) goto L_0x0070
            r4 = 0
            goto L_0x008c
        L_0x0070:
            java.lang.Double r5 = r10.getDisplayDuration()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            double r5 = r5.doubleValue()
            r9.setDisplayDuration(r5)
            r5 = 0
            r0.L$0 = r5
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r9 = r2.showMessageContent(r9, r10, r0)
            if (r9 != r1) goto L_0x008c
            return r1
        L_0x008c:
            java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer.displayPreviewMessage(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v5, resolved type: com.onesignal.inAppMessages.internal.InAppMessageContent} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00bc A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00e9 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object showMessageContent(com.onesignal.inAppMessages.internal.InAppMessage r11, com.onesignal.inAppMessages.internal.InAppMessageContent r12, kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
        /*
            r10 = this;
            boolean r0 = r13 instanceof com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer$showMessageContent$1
            if (r0 == 0) goto L_0x0014
            r0 = r13
            com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer$showMessageContent$1 r0 = (com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer$showMessageContent$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L_0x0019
        L_0x0014:
            com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer$showMessageContent$1 r0 = new com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer$showMessageContent$1
            r0.<init>(r10, r13)
        L_0x0019:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 5
            r4 = 4
            r5 = 3
            r6 = 1
            r7 = 2
            r8 = 0
            if (r2 == 0) goto L_0x006b
            if (r2 == r6) goto L_0x0057
            if (r2 == r7) goto L_0x0052
            if (r2 == r5) goto L_0x0052
            if (r2 == r4) goto L_0x0040
            if (r2 != r3) goto L_0x0038
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x00ea
        L_0x0038:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0040:
            java.lang.Object r11 = r0.L$2
            r12 = r11
            com.onesignal.inAppMessages.internal.InAppMessageContent r12 = (com.onesignal.inAppMessages.internal.InAppMessageContent) r12
            java.lang.Object r11 = r0.L$1
            com.onesignal.inAppMessages.internal.InAppMessage r11 = (com.onesignal.inAppMessages.internal.InAppMessage) r11
            java.lang.Object r2 = r0.L$0
            com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer r2 = (com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer) r2
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x00db
        L_0x0052:
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x00c6
        L_0x0057:
            java.lang.Object r11 = r0.L$3
            android.app.Activity r11 = (android.app.Activity) r11
            java.lang.Object r12 = r0.L$2
            com.onesignal.inAppMessages.internal.InAppMessageContent r12 = (com.onesignal.inAppMessages.internal.InAppMessageContent) r12
            java.lang.Object r2 = r0.L$1
            com.onesignal.inAppMessages.internal.InAppMessage r2 = (com.onesignal.inAppMessages.internal.InAppMessage) r2
            java.lang.Object r3 = r0.L$0
            com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer r3 = (com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer) r3
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x00aa
        L_0x006b:
            kotlin.ResultKt.throwOnFailure(r13)
            com.onesignal.core.internal.application.IApplicationService r13 = r10._applicationService
            android.app.Activity r13 = r13.getCurrent()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r9 = "InAppDisplayer.showMessageContent: in app message on currentActivity: "
            r2.<init>(r9)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            com.onesignal.debug.internal.logging.Logging.debug$default(r2, r8, r7, r8)
            if (r13 == 0) goto L_0x00c9
            com.onesignal.inAppMessages.internal.display.impl.WebViewManager r2 = r10.lastInstance
            if (r2 == 0) goto L_0x00bd
            boolean r2 = r11.isPreview()
            if (r2 == 0) goto L_0x00bd
            com.onesignal.inAppMessages.internal.display.impl.WebViewManager r2 = r10.lastInstance
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            r0.L$0 = r10
            r0.L$1 = r11
            r0.L$2 = r12
            r0.L$3 = r13
            r0.label = r6
            java.lang.Object r2 = r2.dismissAndAwaitNextMessage(r0)
            if (r2 != r1) goto L_0x00a7
            return r1
        L_0x00a7:
            r3 = r10
            r2 = r11
            r11 = r13
        L_0x00aa:
            r3.lastInstance = r8
            r0.L$0 = r8
            r0.L$1 = r8
            r0.L$2 = r8
            r0.L$3 = r8
            r0.label = r7
            java.lang.Object r11 = r3.initInAppMessage(r11, r2, r12, r0)
            if (r11 != r1) goto L_0x00c6
            return r1
        L_0x00bd:
            r0.label = r5
            java.lang.Object r11 = r10.initInAppMessage(r13, r11, r12, r0)
            if (r11 != r1) goto L_0x00c6
            return r1
        L_0x00c6:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L_0x00c9:
            r0.L$0 = r10
            r0.L$1 = r11
            r0.L$2 = r12
            r0.label = r4
            r4 = 200(0xc8, double:9.9E-322)
            java.lang.Object r13 = kotlinx.coroutines.DelayKt.delay(r4, r0)
            if (r13 != r1) goto L_0x00da
            return r1
        L_0x00da:
            r2 = r10
        L_0x00db:
            r0.L$0 = r8
            r0.L$1 = r8
            r0.L$2 = r8
            r0.label = r3
            java.lang.Object r11 = r2.showMessageContent(r11, r12, r0)
            if (r11 != r1) goto L_0x00ea
            return r1
        L_0x00ea:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer.showMessageContent(com.onesignal.inAppMessages.internal.InAppMessage, com.onesignal.inAppMessages.internal.InAppMessageContent, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public void dismissCurrentInAppMessage() {
        Logging.debug$default("WebViewManager IAM dismissAndAwaitNextMessage lastInstance: " + this.lastInstance, (Throwable) null, 2, (Object) null);
        WebViewManager webViewManager = this.lastInstance;
        if (webViewManager != null) {
            Intrinsics.checkNotNull(webViewManager);
            webViewManager.backgroundDismissAndAwaitNextMessage();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object initInAppMessage(android.app.Activity r18, com.onesignal.inAppMessages.internal.InAppMessage r19, com.onesignal.inAppMessages.internal.InAppMessageContent r20, kotlin.coroutines.Continuation<? super kotlin.Unit> r21) {
        /*
            r17 = this;
            r1 = r17
            r0 = r21
            boolean r2 = r0 instanceof com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer$initInAppMessage$1
            if (r2 == 0) goto L_0x0018
            r2 = r0
            com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer$initInAppMessage$1 r2 = (com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer$initInAppMessage$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r0 = r2.label
            int r0 = r0 - r4
            r2.label = r0
            goto L_0x001d
        L_0x0018:
            com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer$initInAppMessage$1 r2 = new com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer$initInAppMessage$1
            r2.<init>(r1, r0)
        L_0x001d:
            java.lang.Object r0 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            if (r4 == 0) goto L_0x003a
            if (r4 != r5) goto L_0x0032
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ UnsupportedEncodingException -> 0x002f }
            goto L_0x00a9
        L_0x002f:
            r0 = move-exception
            goto L_0x00a2
        L_0x0032:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r0)
            java.lang.String r0 = r20.getContentHtml()     // Catch:{ UnsupportedEncodingException -> 0x002f }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)     // Catch:{ UnsupportedEncodingException -> 0x002f }
            java.lang.String r4 = "UTF-8"
            java.nio.charset.Charset r4 = java.nio.charset.Charset.forName(r4)     // Catch:{ UnsupportedEncodingException -> 0x002f }
            java.lang.String r6 = "forName(charsetName)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r6)     // Catch:{ UnsupportedEncodingException -> 0x002f }
            byte[] r0 = r0.getBytes(r4)     // Catch:{ UnsupportedEncodingException -> 0x002f }
            java.lang.String r4 = "this as java.lang.String).getBytes(charset)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r4)     // Catch:{ UnsupportedEncodingException -> 0x002f }
            r4 = 2
            java.lang.String r9 = android.util.Base64.encodeToString(r0, r4)     // Catch:{ UnsupportedEncodingException -> 0x002f }
            com.onesignal.inAppMessages.internal.display.impl.WebViewManager r7 = new com.onesignal.inAppMessages.internal.display.impl.WebViewManager     // Catch:{ UnsupportedEncodingException -> 0x002f }
            com.onesignal.inAppMessages.internal.lifecycle.IInAppLifecycleService r14 = r1._lifecycle     // Catch:{ UnsupportedEncodingException -> 0x002f }
            com.onesignal.core.internal.application.IApplicationService r15 = r1._applicationService     // Catch:{ UnsupportedEncodingException -> 0x002f }
            com.onesignal.inAppMessages.internal.prompt.IInAppMessagePromptFactory r0 = r1._promptFactory     // Catch:{ UnsupportedEncodingException -> 0x002f }
            r10 = r7
            r11 = r19
            r12 = r18
            r13 = r20
            r16 = r0
            r10.<init>(r11, r12, r13, r14, r15, r16)     // Catch:{ UnsupportedEncodingException -> 0x002f }
            r1.lastInstance = r7     // Catch:{ UnsupportedEncodingException -> 0x002f }
            boolean r0 = r20.isFullBleed()     // Catch:{ UnsupportedEncodingException -> 0x002f }
            if (r0 == 0) goto L_0x0081
            r0 = r18
            r4 = r20
            r7.setContentSafeAreaInsets(r4, r0)     // Catch:{ UnsupportedEncodingException -> 0x002f }
            goto L_0x0085
        L_0x0081:
            r0 = r18
            r4 = r20
        L_0x0085:
            kotlinx.coroutines.MainCoroutineDispatcher r6 = kotlinx.coroutines.Dispatchers.getMain()     // Catch:{ UnsupportedEncodingException -> 0x002f }
            r12 = r6
            kotlin.coroutines.CoroutineContext r12 = (kotlin.coroutines.CoroutineContext) r12     // Catch:{ UnsupportedEncodingException -> 0x002f }
            com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer$initInAppMessage$2 r13 = new com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer$initInAppMessage$2     // Catch:{ UnsupportedEncodingException -> 0x002f }
            r11 = 0
            r6 = r13
            r8 = r18
            r10 = r20
            r6.<init>(r7, r8, r9, r10, r11)     // Catch:{ UnsupportedEncodingException -> 0x002f }
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13     // Catch:{ UnsupportedEncodingException -> 0x002f }
            r2.label = r5     // Catch:{ UnsupportedEncodingException -> 0x002f }
            java.lang.Object r0 = kotlinx.coroutines.BuildersKt.withContext(r12, r13, r2)     // Catch:{ UnsupportedEncodingException -> 0x002f }
            if (r0 != r3) goto L_0x00a9
            return r3
        L_0x00a2:
            java.lang.String r2 = "Catch on initInAppMessage: "
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            com.onesignal.debug.internal.logging.Logging.error(r2, r0)
        L_0x00a9:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer.initInAppMessage(android.app.Activity, com.onesignal.inAppMessages.internal.InAppMessage, com.onesignal.inAppMessages.internal.InAppMessageContent, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/onesignal/inAppMessages/internal/display/impl/InAppDisplayer$Companion;", "", "()V", "IN_APP_MESSAGE_INIT_DELAY", "", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: InAppDisplayer.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
