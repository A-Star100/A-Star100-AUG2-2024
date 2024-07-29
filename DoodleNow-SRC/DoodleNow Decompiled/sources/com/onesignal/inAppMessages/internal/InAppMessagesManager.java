package com.onesignal.inAppMessages.internal;

import android.app.AlertDialog;
import android.content.DialogInterface;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.onesignal.common.AndroidUtils;
import com.onesignal.common.JSONUtils;
import com.onesignal.common.events.EventProducer;
import com.onesignal.common.modeling.IModelStore;
import com.onesignal.common.modeling.ISingletonModelStoreChangeHandler;
import com.onesignal.common.modeling.ModelChangedArgs;
import com.onesignal.common.threading.ThreadUtilsKt;
import com.onesignal.core.internal.application.IApplicationLifecycleHandler;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.config.ConfigModel;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import com.onesignal.core.internal.language.ILanguageContext;
import com.onesignal.core.internal.startup.IStartableService;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.inAppMessages.IInAppMessageClickListener;
import com.onesignal.inAppMessages.IInAppMessageLifecycleListener;
import com.onesignal.inAppMessages.IInAppMessagesManager;
import com.onesignal.inAppMessages.InAppMessageActionUrlType;
import com.onesignal.inAppMessages.R;
import com.onesignal.inAppMessages.internal.backend.IInAppBackendService;
import com.onesignal.inAppMessages.internal.common.InAppHelper;
import com.onesignal.inAppMessages.internal.common.OneSignalChromeTab;
import com.onesignal.inAppMessages.internal.display.IInAppDisplayer;
import com.onesignal.inAppMessages.internal.lifecycle.IInAppLifecycleEventHandler;
import com.onesignal.inAppMessages.internal.lifecycle.IInAppLifecycleService;
import com.onesignal.inAppMessages.internal.preferences.IInAppPreferencesController;
import com.onesignal.inAppMessages.internal.prompt.impl.InAppMessagePrompt;
import com.onesignal.inAppMessages.internal.repositories.IInAppRepository;
import com.onesignal.inAppMessages.internal.state.InAppStateService;
import com.onesignal.inAppMessages.internal.triggers.ITriggerController;
import com.onesignal.inAppMessages.internal.triggers.ITriggerHandler;
import com.onesignal.inAppMessages.internal.triggers.TriggerModel;
import com.onesignal.inAppMessages.internal.triggers.TriggerModelStore;
import com.onesignal.session.internal.influence.IInfluenceManager;
import com.onesignal.session.internal.outcomes.IOutcomeEventsController;
import com.onesignal.session.internal.session.ISessionLifecycleHandler;
import com.onesignal.session.internal.session.ISessionService;
import com.onesignal.user.IUserManager;
import com.onesignal.user.internal.subscriptions.ISubscriptionChangedHandler;
import com.onesignal.user.internal.subscriptions.ISubscriptionManager;
import com.onesignal.user.subscriptions.IPushSubscription;
import com.onesignal.user.subscriptions.ISubscription;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000 \u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u001e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u00042\u00020\u00062\u00020\u00072\u00020\b2\u00020\tB\u0001\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u0012\u0006\u0010\u001e\u001a\u00020\u001f\u0012\u0006\u0010 \u001a\u00020!\u0012\u0006\u0010\"\u001a\u00020#\u0012\u0006\u0010$\u001a\u00020%\u0012\u0006\u0010&\u001a\u00020'\u0012\u0006\u0010(\u001a\u00020)\u0012\u0006\u0010*\u001a\u00020+¢\u0006\u0002\u0010,J\u0010\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020;H\u0016J\u0010\u0010N\u001a\u00020L2\u0006\u0010M\u001a\u000209H\u0016J\u0018\u0010O\u001a\u00020L2\u0006\u0010P\u001a\u00020/2\u0006\u0010B\u001a\u00020/H\u0016J\u001c\u0010Q\u001a\u00020L2\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020/0SH\u0016J\u0011\u0010T\u001a\u00020LH@ø\u0001\u0000¢\u0006\u0002\u0010UJ'\u0010V\u001a\u00020L2\u0006\u0010W\u001a\u00020>2\f\u0010X\u001a\b\u0012\u0004\u0012\u00020Y0AH@ø\u0001\u0000¢\u0006\u0002\u0010ZJ\b\u0010[\u001a\u00020LH\u0016J\u0011\u0010\\\u001a\u00020LH@ø\u0001\u0000¢\u0006\u0002\u0010UJ\u0011\u0010]\u001a\u00020LH@ø\u0001\u0000¢\u0006\u0002\u0010UJ\u0010\u0010^\u001a\u00020L2\u0006\u0010_\u001a\u00020`H\u0002J'\u0010a\u001a\u00020L2\u0006\u0010b\u001a\u00020/2\f\u0010c\u001a\b\u0012\u0004\u0012\u00020d0AH@ø\u0001\u0000¢\u0006\u0002\u0010eJ!\u0010f\u001a\u00020L2\u0006\u0010W\u001a\u00020>2\u0006\u0010_\u001a\u00020`H@ø\u0001\u0000¢\u0006\u0002\u0010gJ!\u0010h\u001a\u00020L2\u0006\u0010W\u001a\u00020>2\u0006\u0010_\u001a\u00020`H@ø\u0001\u0000¢\u0006\u0002\u0010gJ!\u0010i\u001a\u00020L2\u0006\u0010W\u001a\u00020>2\u0006\u0010j\u001a\u00020kH@ø\u0001\u0000¢\u0006\u0002\u0010lJ\u0010\u0010m\u001a\u00020L2\u0006\u0010_\u001a\u00020`H\u0002J\u0010\u0010n\u001a\u00020C2\u0006\u0010W\u001a\u00020>H\u0002J\u0010\u0010o\u001a\u00020L2\u0006\u0010_\u001a\u00020`H\u0002J\u0016\u0010p\u001a\u00020L2\f\u0010q\u001a\b\u0012\u0004\u0012\u00020/0rH\u0002J#\u0010s\u001a\u00020L2\u0006\u0010W\u001a\u00020>2\b\b\u0002\u0010t\u001a\u00020CH@ø\u0001\u0000¢\u0006\u0002\u0010uJ\u0010\u0010v\u001a\u00020L2\u0006\u0010w\u001a\u00020CH\u0016J\u0018\u0010x\u001a\u00020L2\u0006\u0010W\u001a\u00020>2\u0006\u0010_\u001a\u00020`H\u0016J\u0018\u0010y\u001a\u00020L2\u0006\u0010W\u001a\u00020>2\u0006\u0010_\u001a\u00020`H\u0016J\u0018\u0010z\u001a\u00020L2\u0006\u0010W\u001a\u00020>2\u0006\u0010j\u001a\u00020kH\u0016J\u0010\u0010{\u001a\u00020L2\u0006\u0010W\u001a\u00020>H\u0016J\u0010\u0010|\u001a\u00020L2\u0006\u0010W\u001a\u00020>H\u0016J\u0010\u0010}\u001a\u00020L2\u0006\u0010W\u001a\u00020>H\u0016J\u0010\u0010~\u001a\u00020L2\u0006\u0010W\u001a\u00020>H\u0016J\u001a\u0010\u001a\u00020L2\u0007\u0010\u0001\u001a\u00020\u00052\u0007\u0010\u0001\u001a\u00020/H\u0016J\u001c\u0010\u0001\u001a\u00020L2\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020/H\u0016J\t\u0010\u0001\u001a\u00020LH\u0016J\u0012\u0010\u0001\u001a\u00020L2\u0007\u0010\u0001\u001a\u000205H\u0016J\t\u0010\u0001\u001a\u00020LH\u0016J\u0013\u0010\u0001\u001a\u00020L2\b\u0010\u0001\u001a\u00030\u0001H\u0016J\u001d\u0010\u0001\u001a\u00020L2\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0016J\u0013\u0010\u0001\u001a\u00020L2\b\u0010\u0001\u001a\u00030\u0001H\u0016J\u0012\u0010\u0001\u001a\u00020L2\u0007\u0010\u0001\u001a\u00020/H\u0016J\u0012\u0010\u0001\u001a\u00020L2\u0007\u0010\u0001\u001a\u00020/H\u0016J\t\u0010\u0001\u001a\u00020LH\u0016J\t\u0010\u0001\u001a\u00020LH\u0016J\u001b\u0010\u0001\u001a\u00020L2\u0006\u0010W\u001a\u00020>H@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J\u001b\u0010\u0001\u001a\u00020L2\u0006\u0010W\u001a\u00020>H@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J\u0011\u0010\u0001\u001a\u00020L2\u0006\u0010M\u001a\u00020;H\u0016J\u0011\u0010\u0001\u001a\u00020L2\u0006\u0010M\u001a\u000209H\u0016J\u0011\u0010\u0001\u001a\u00020L2\u0006\u0010P\u001a\u00020/H\u0016J\u0018\u0010\u0001\u001a\u00020L2\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020/0rH\u0016J\u0011\u0010\u0001\u001a\u00020L2\u0006\u0010W\u001a\u00020>H\u0002J \u0010\u0001\u001a\u00020L2\u0007\u0010\u0001\u001a\u00020>2\f\u0010X\u001a\b\u0012\u0004\u0012\u00020Y0AH\u0002J)\u0010\u0001\u001a\u00020L2\u0007\u0010\u0001\u001a\u00020>2\f\u0010X\u001a\b\u0012\u0004\u0012\u00020Y0AH@ø\u0001\u0000¢\u0006\u0002\u0010ZJ\t\u0010 \u0001\u001a\u00020LH\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.X\u0004¢\u0006\u0002\n\u0000R\u0014\u00100\u001a\b\u0012\u0004\u0012\u00020/0.X\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0004¢\u0006\u0002\n\u0000R\u0014\u00103\u001a\b\u0012\u0004\u0012\u00020/0.X\u0004¢\u0006\u0002\n\u0000R\u0012\u00104\u001a\u0004\u0018\u000105X\u000e¢\u0006\u0004\n\u0002\u00106R\u0014\u00107\u001a\b\u0012\u0004\u0012\u00020908X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010:\u001a\b\u0012\u0004\u0012\u00020;08X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010<\u001a\b\u0012\u0004\u0012\u00020>0=X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u000202X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010@\u001a\b\u0012\u0004\u0012\u00020>0AX\u000e¢\u0006\u0002\n\u0000R$\u0010D\u001a\u00020C2\u0006\u0010B\u001a\u00020C8V@VX\u000e¢\u0006\f\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u0014\u0010I\u001a\b\u0012\u0004\u0012\u00020>0=X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010J\u001a\b\u0012\u0004\u0012\u00020/0.X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006¡\u0001"}, d2 = {"Lcom/onesignal/inAppMessages/internal/InAppMessagesManager;", "Lcom/onesignal/inAppMessages/IInAppMessagesManager;", "Lcom/onesignal/core/internal/startup/IStartableService;", "Lcom/onesignal/user/internal/subscriptions/ISubscriptionChangedHandler;", "Lcom/onesignal/common/modeling/ISingletonModelStoreChangeHandler;", "Lcom/onesignal/core/internal/config/ConfigModel;", "Lcom/onesignal/inAppMessages/internal/lifecycle/IInAppLifecycleEventHandler;", "Lcom/onesignal/inAppMessages/internal/triggers/ITriggerHandler;", "Lcom/onesignal/session/internal/session/ISessionLifecycleHandler;", "Lcom/onesignal/core/internal/application/IApplicationLifecycleHandler;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_sessionService", "Lcom/onesignal/session/internal/session/ISessionService;", "_influenceManager", "Lcom/onesignal/session/internal/influence/IInfluenceManager;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "_userManager", "Lcom/onesignal/user/IUserManager;", "_subscriptionManager", "Lcom/onesignal/user/internal/subscriptions/ISubscriptionManager;", "_outcomeEventsController", "Lcom/onesignal/session/internal/outcomes/IOutcomeEventsController;", "_state", "Lcom/onesignal/inAppMessages/internal/state/InAppStateService;", "_prefs", "Lcom/onesignal/inAppMessages/internal/preferences/IInAppPreferencesController;", "_repository", "Lcom/onesignal/inAppMessages/internal/repositories/IInAppRepository;", "_backend", "Lcom/onesignal/inAppMessages/internal/backend/IInAppBackendService;", "_triggerController", "Lcom/onesignal/inAppMessages/internal/triggers/ITriggerController;", "_triggerModelStore", "Lcom/onesignal/inAppMessages/internal/triggers/TriggerModelStore;", "_displayer", "Lcom/onesignal/inAppMessages/internal/display/IInAppDisplayer;", "_lifecycle", "Lcom/onesignal/inAppMessages/internal/lifecycle/IInAppLifecycleService;", "_languageContext", "Lcom/onesignal/core/internal/language/ILanguageContext;", "_time", "Lcom/onesignal/core/internal/time/ITime;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/session/internal/session/ISessionService;Lcom/onesignal/session/internal/influence/IInfluenceManager;Lcom/onesignal/core/internal/config/ConfigModelStore;Lcom/onesignal/user/IUserManager;Lcom/onesignal/user/internal/subscriptions/ISubscriptionManager;Lcom/onesignal/session/internal/outcomes/IOutcomeEventsController;Lcom/onesignal/inAppMessages/internal/state/InAppStateService;Lcom/onesignal/inAppMessages/internal/preferences/IInAppPreferencesController;Lcom/onesignal/inAppMessages/internal/repositories/IInAppRepository;Lcom/onesignal/inAppMessages/internal/backend/IInAppBackendService;Lcom/onesignal/inAppMessages/internal/triggers/ITriggerController;Lcom/onesignal/inAppMessages/internal/triggers/TriggerModelStore;Lcom/onesignal/inAppMessages/internal/display/IInAppDisplayer;Lcom/onesignal/inAppMessages/internal/lifecycle/IInAppLifecycleService;Lcom/onesignal/core/internal/language/ILanguageContext;Lcom/onesignal/core/internal/time/ITime;)V", "clickedClickIds", "", "", "dismissedMessages", "fetchIAMMutex", "Lkotlinx/coroutines/sync/Mutex;", "impressionedMessages", "lastTimeFetchedIAMs", "", "Ljava/lang/Long;", "lifecycleCallback", "Lcom/onesignal/common/events/EventProducer;", "Lcom/onesignal/inAppMessages/IInAppMessageLifecycleListener;", "messageClickCallback", "Lcom/onesignal/inAppMessages/IInAppMessageClickListener;", "messageDisplayQueue", "", "Lcom/onesignal/inAppMessages/internal/InAppMessage;", "messageDisplayQueueMutex", "messages", "", "value", "", "paused", "getPaused", "()Z", "setPaused", "(Z)V", "redisplayedInAppMessages", "viewedPageIds", "addClickListener", "", "listener", "addLifecycleListener", "addTrigger", "key", "addTriggers", "triggers", "", "attemptToShowInAppMessage", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "beginProcessingPrompts", "message", "prompts", "Lcom/onesignal/inAppMessages/internal/prompt/impl/InAppMessagePrompt;", "(Lcom/onesignal/inAppMessages/internal/InAppMessage;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearTriggers", "evaluateInAppMessages", "fetchMessages", "fireClickAction", "action", "Lcom/onesignal/inAppMessages/internal/InAppMessageClickResult;", "fireOutcomesForClick", "messageId", "outcomes", "Lcom/onesignal/inAppMessages/internal/InAppMessageOutcome;", "(Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "firePublicClickHandler", "(Lcom/onesignal/inAppMessages/internal/InAppMessage;Lcom/onesignal/inAppMessages/internal/InAppMessageClickResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fireRESTCallForClick", "fireRESTCallForPageChange", "page", "Lcom/onesignal/inAppMessages/internal/InAppMessagePage;", "(Lcom/onesignal/inAppMessages/internal/InAppMessage;Lcom/onesignal/inAppMessages/internal/InAppMessagePage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fireTagCallForClick", "hasMessageTriggerChanged", "logInAppMessagePreviewActions", "makeRedisplayMessagesAvailableWithTriggers", "newTriggersKeys", "", "messageWasDismissed", "failed", "(Lcom/onesignal/inAppMessages/internal/InAppMessage;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onFocus", "firedOnSubscribe", "onMessageActionOccurredOnMessage", "onMessageActionOccurredOnPreview", "onMessagePageChanged", "onMessageWasDismissed", "onMessageWasDisplayed", "onMessageWillDismiss", "onMessageWillDisplay", "onModelReplaced", "model", "tag", "onModelUpdated", "args", "Lcom/onesignal/common/modeling/ModelChangedArgs;", "onSessionActive", "onSessionEnded", "duration", "onSessionStarted", "onSubscriptionAdded", "subscription", "Lcom/onesignal/user/subscriptions/ISubscription;", "onSubscriptionChanged", "onSubscriptionRemoved", "onTriggerChanged", "newTriggerKey", "onTriggerCompleted", "triggerId", "onTriggerConditionChanged", "onUnfocused", "persistInAppMessage", "(Lcom/onesignal/inAppMessages/internal/InAppMessage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queueMessageForDisplay", "removeClickListener", "removeLifecycleListener", "removeTrigger", "removeTriggers", "keys", "setDataForRedisplay", "showAlertDialogMessage", "inAppMessage", "showMultiplePrompts", "start", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: InAppMessagesManager.kt */
public final class InAppMessagesManager implements IInAppMessagesManager, IStartableService, ISubscriptionChangedHandler, ISingletonModelStoreChangeHandler<ConfigModel>, IInAppLifecycleEventHandler, ITriggerHandler, ISessionLifecycleHandler, IApplicationLifecycleHandler {
    private final IApplicationService _applicationService;
    /* access modifiers changed from: private */
    public final IInAppBackendService _backend;
    /* access modifiers changed from: private */
    public final ConfigModelStore _configModelStore;
    private final IInAppDisplayer _displayer;
    private final IInfluenceManager _influenceManager;
    private final ILanguageContext _languageContext;
    private final IInAppLifecycleService _lifecycle;
    private final IOutcomeEventsController _outcomeEventsController;
    /* access modifiers changed from: private */
    public final IInAppPreferencesController _prefs;
    /* access modifiers changed from: private */
    public final IInAppRepository _repository;
    private final ISessionService _sessionService;
    private final InAppStateService _state;
    /* access modifiers changed from: private */
    public final ISubscriptionManager _subscriptionManager;
    private final ITime _time;
    private final ITriggerController _triggerController;
    private final TriggerModelStore _triggerModelStore;
    private final IUserManager _userManager;
    private final Set<String> clickedClickIds = new LinkedHashSet();
    private final Set<String> dismissedMessages = new LinkedHashSet();
    private final Mutex fetchIAMMutex = MutexKt.Mutex$default(false, 1, (Object) null);
    /* access modifiers changed from: private */
    public final Set<String> impressionedMessages = new LinkedHashSet();
    private Long lastTimeFetchedIAMs;
    private final EventProducer<IInAppMessageLifecycleListener> lifecycleCallback = new EventProducer<>();
    private final EventProducer<IInAppMessageClickListener> messageClickCallback = new EventProducer<>();
    private final List<InAppMessage> messageDisplayQueue = new ArrayList();
    private final Mutex messageDisplayQueueMutex = MutexKt.Mutex$default(false, 1, (Object) null);
    private List<InAppMessage> messages = CollectionsKt.emptyList();
    /* access modifiers changed from: private */
    public final List<InAppMessage> redisplayedInAppMessages = new ArrayList();
    private final Set<String> viewedPageIds = new LinkedHashSet();

    public void onFocus(boolean z) {
    }

    public void onSessionActive() {
    }

    public void onSessionEnded(long j) {
    }

    public void onSubscriptionAdded(ISubscription iSubscription) {
        Intrinsics.checkNotNullParameter(iSubscription, "subscription");
    }

    public void onSubscriptionRemoved(ISubscription iSubscription) {
        Intrinsics.checkNotNullParameter(iSubscription, "subscription");
    }

    public void onUnfocused() {
    }

    public InAppMessagesManager(IApplicationService iApplicationService, ISessionService iSessionService, IInfluenceManager iInfluenceManager, ConfigModelStore configModelStore, IUserManager iUserManager, ISubscriptionManager iSubscriptionManager, IOutcomeEventsController iOutcomeEventsController, InAppStateService inAppStateService, IInAppPreferencesController iInAppPreferencesController, IInAppRepository iInAppRepository, IInAppBackendService iInAppBackendService, ITriggerController iTriggerController, TriggerModelStore triggerModelStore, IInAppDisplayer iInAppDisplayer, IInAppLifecycleService iInAppLifecycleService, ILanguageContext iLanguageContext, ITime iTime) {
        IApplicationService iApplicationService2 = iApplicationService;
        ISessionService iSessionService2 = iSessionService;
        IInfluenceManager iInfluenceManager2 = iInfluenceManager;
        ConfigModelStore configModelStore2 = configModelStore;
        IUserManager iUserManager2 = iUserManager;
        ISubscriptionManager iSubscriptionManager2 = iSubscriptionManager;
        IOutcomeEventsController iOutcomeEventsController2 = iOutcomeEventsController;
        InAppStateService inAppStateService2 = inAppStateService;
        IInAppPreferencesController iInAppPreferencesController2 = iInAppPreferencesController;
        IInAppRepository iInAppRepository2 = iInAppRepository;
        IInAppBackendService iInAppBackendService2 = iInAppBackendService;
        ITriggerController iTriggerController2 = iTriggerController;
        TriggerModelStore triggerModelStore2 = triggerModelStore;
        IInAppDisplayer iInAppDisplayer2 = iInAppDisplayer;
        ILanguageContext iLanguageContext2 = iLanguageContext;
        Intrinsics.checkNotNullParameter(iApplicationService2, "_applicationService");
        Intrinsics.checkNotNullParameter(iSessionService2, "_sessionService");
        Intrinsics.checkNotNullParameter(iInfluenceManager2, "_influenceManager");
        Intrinsics.checkNotNullParameter(configModelStore2, "_configModelStore");
        Intrinsics.checkNotNullParameter(iUserManager2, "_userManager");
        Intrinsics.checkNotNullParameter(iSubscriptionManager2, "_subscriptionManager");
        Intrinsics.checkNotNullParameter(iOutcomeEventsController2, "_outcomeEventsController");
        Intrinsics.checkNotNullParameter(inAppStateService2, "_state");
        Intrinsics.checkNotNullParameter(iInAppPreferencesController2, "_prefs");
        Intrinsics.checkNotNullParameter(iInAppRepository2, "_repository");
        Intrinsics.checkNotNullParameter(iInAppBackendService2, "_backend");
        Intrinsics.checkNotNullParameter(iTriggerController2, "_triggerController");
        Intrinsics.checkNotNullParameter(triggerModelStore2, "_triggerModelStore");
        Intrinsics.checkNotNullParameter(iInAppDisplayer2, "_displayer");
        Intrinsics.checkNotNullParameter(iInAppLifecycleService, "_lifecycle");
        Intrinsics.checkNotNullParameter(iLanguageContext, "_languageContext");
        Intrinsics.checkNotNullParameter(iTime, "_time");
        this._applicationService = iApplicationService2;
        this._sessionService = iSessionService2;
        this._influenceManager = iInfluenceManager2;
        this._configModelStore = configModelStore2;
        this._userManager = iUserManager2;
        this._subscriptionManager = iSubscriptionManager2;
        this._outcomeEventsController = iOutcomeEventsController2;
        this._state = inAppStateService2;
        this._prefs = iInAppPreferencesController2;
        this._repository = iInAppRepository2;
        this._backend = iInAppBackendService2;
        this._triggerController = iTriggerController2;
        this._triggerModelStore = triggerModelStore2;
        this._displayer = iInAppDisplayer2;
        this._lifecycle = iInAppLifecycleService;
        this._languageContext = iLanguageContext;
        this._time = iTime;
    }

    public boolean getPaused() {
        return this._state.getPaused();
    }

    public void setPaused(boolean z) {
        Logging.debug$default("InAppMessagesManager.setPaused(value: " + z + ')', (Throwable) null, 2, (Object) null);
        this._state.setPaused(z);
        if (!z) {
            ThreadUtilsKt.suspendifyOnThread$default(0, new InAppMessagesManager$paused$1(this, (Continuation<? super InAppMessagesManager$paused$1>) null), 1, (Object) null);
        }
    }

    public void start() {
        Set<String> dismissedMessagesId = this._prefs.getDismissedMessagesId();
        if (dismissedMessagesId != null) {
            this.dismissedMessages.addAll(dismissedMessagesId);
        }
        Long lastTimeInAppDismissed = this._prefs.getLastTimeInAppDismissed();
        if (lastTimeInAppDismissed != null) {
            this._state.setLastTimeInAppDismissed(lastTimeInAppDismissed);
        }
        this._subscriptionManager.subscribe(this);
        this._configModelStore.subscribe(this);
        this._lifecycle.subscribe(this);
        this._triggerController.subscribe(this);
        this._sessionService.subscribe(this);
        this._applicationService.addApplicationLifecycleHandler(this);
        ThreadUtilsKt.suspendifyOnThread$default(0, new InAppMessagesManager$start$1(this, (Continuation<? super InAppMessagesManager$start$1>) null), 1, (Object) null);
    }

    public void addLifecycleListener(IInAppMessageLifecycleListener iInAppMessageLifecycleListener) {
        Intrinsics.checkNotNullParameter(iInAppMessageLifecycleListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Logging.debug$default("InAppMessagesManager.addLifecycleListener(listener: " + iInAppMessageLifecycleListener + ')', (Throwable) null, 2, (Object) null);
        this.lifecycleCallback.subscribe(iInAppMessageLifecycleListener);
    }

    public void removeLifecycleListener(IInAppMessageLifecycleListener iInAppMessageLifecycleListener) {
        Intrinsics.checkNotNullParameter(iInAppMessageLifecycleListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Logging.debug$default("InAppMessagesManager.removeLifecycleListener(listener: " + iInAppMessageLifecycleListener + ')', (Throwable) null, 2, (Object) null);
        this.lifecycleCallback.unsubscribe(iInAppMessageLifecycleListener);
    }

    public void addClickListener(IInAppMessageClickListener iInAppMessageClickListener) {
        Intrinsics.checkNotNullParameter(iInAppMessageClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Logging.debug$default("InAppMessagesManager.addClickListener(listener: " + iInAppMessageClickListener + ')', (Throwable) null, 2, (Object) null);
        this.messageClickCallback.subscribe(iInAppMessageClickListener);
    }

    public void removeClickListener(IInAppMessageClickListener iInAppMessageClickListener) {
        Intrinsics.checkNotNullParameter(iInAppMessageClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Logging.debug$default("InAppMessagesManager.removeClickListener(listener: " + iInAppMessageClickListener + ')', (Throwable) null, 2, (Object) null);
        this.messageClickCallback.unsubscribe(iInAppMessageClickListener);
    }

    public void onModelUpdated(ModelChangedArgs modelChangedArgs, String str) {
        Intrinsics.checkNotNullParameter(modelChangedArgs, "args");
        Intrinsics.checkNotNullParameter(str, "tag");
        if (Intrinsics.areEqual((Object) modelChangedArgs.getProperty(), (Object) "appId")) {
            ThreadUtilsKt.suspendifyOnThread$default(0, new InAppMessagesManager$onModelUpdated$2(this, (Continuation<? super InAppMessagesManager$onModelUpdated$2>) null), 1, (Object) null);
        }
    }

    public void onModelReplaced(ConfigModel configModel, String str) {
        Intrinsics.checkNotNullParameter(configModel, "model");
        Intrinsics.checkNotNullParameter(str, "tag");
        ThreadUtilsKt.suspendifyOnThread$default(0, new InAppMessagesManager$onModelReplaced$1(this, (Continuation<? super InAppMessagesManager$onModelReplaced$1>) null), 1, (Object) null);
    }

    public void onSubscriptionChanged(ISubscription iSubscription, ModelChangedArgs modelChangedArgs) {
        Intrinsics.checkNotNullParameter(iSubscription, "subscription");
        Intrinsics.checkNotNullParameter(modelChangedArgs, "args");
        if ((iSubscription instanceof IPushSubscription) && Intrinsics.areEqual((Object) modelChangedArgs.getPath(), (Object) "id")) {
            ThreadUtilsKt.suspendifyOnThread$default(0, new InAppMessagesManager$onSubscriptionChanged$2(this, (Continuation<? super InAppMessagesManager$onSubscriptionChanged$2>) null), 1, (Object) null);
        }
    }

    public void onSessionStarted() {
        for (InAppMessage displayedInSession : this.redisplayedInAppMessages) {
            displayedInSession.setDisplayedInSession(false);
        }
        ThreadUtilsKt.suspendifyOnThread$default(0, new InAppMessagesManager$onSessionStarted$1(this, (Continuation<? super InAppMessagesManager$onSessionStarted$1>) null), 1, (Object) null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00bf A[Catch:{ all -> 0x0113 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00fb A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object fetchMessages(kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            r14 = this;
            boolean r0 = r15 instanceof com.onesignal.inAppMessages.internal.InAppMessagesManager$fetchMessages$1
            if (r0 == 0) goto L_0x0014
            r0 = r15
            com.onesignal.inAppMessages.internal.InAppMessagesManager$fetchMessages$1 r0 = (com.onesignal.inAppMessages.internal.InAppMessagesManager$fetchMessages$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L_0x0019
        L_0x0014:
            com.onesignal.inAppMessages.internal.InAppMessagesManager$fetchMessages$1 r0 = new com.onesignal.inAppMessages.internal.InAppMessagesManager$fetchMessages$1
            r0.<init>(r14, r15)
        L_0x0019:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x0059
            if (r2 == r5) goto L_0x0043
            if (r2 == r4) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x010d
        L_0x0032:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L_0x003a:
            java.lang.Object r2 = r0.L$0
            com.onesignal.inAppMessages.internal.InAppMessagesManager r2 = (com.onesignal.inAppMessages.internal.InAppMessagesManager) r2
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x00fc
        L_0x0043:
            java.lang.Object r2 = r0.L$3
            kotlinx.coroutines.sync.Mutex r2 = (kotlinx.coroutines.sync.Mutex) r2
            java.lang.Object r5 = r0.L$2
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r7 = r0.L$1
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r8 = r0.L$0
            com.onesignal.inAppMessages.internal.InAppMessagesManager r8 = (com.onesignal.inAppMessages.internal.InAppMessagesManager) r8
            kotlin.ResultKt.throwOnFailure(r15)
            r15 = r2
            r2 = r8
            goto L_0x00b5
        L_0x0059:
            kotlin.ResultKt.throwOnFailure(r15)
            com.onesignal.core.internal.application.IApplicationService r15 = r14._applicationService
            boolean r15 = r15.isInForeground()
            if (r15 != 0) goto L_0x0067
            kotlin.Unit r15 = kotlin.Unit.INSTANCE
            return r15
        L_0x0067:
            com.onesignal.core.internal.config.ConfigModelStore r15 = r14._configModelStore
            com.onesignal.common.modeling.Model r15 = r15.getModel()
            com.onesignal.core.internal.config.ConfigModel r15 = (com.onesignal.core.internal.config.ConfigModel) r15
            java.lang.String r7 = r15.getAppId()
            com.onesignal.user.internal.subscriptions.ISubscriptionManager r15 = r14._subscriptionManager
            com.onesignal.user.internal.subscriptions.SubscriptionList r15 = r15.getSubscriptions()
            com.onesignal.user.subscriptions.IPushSubscription r15 = r15.getPush()
            java.lang.String r15 = r15.getId()
            r2 = r15
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            int r2 = r2.length()
            if (r2 != 0) goto L_0x008c
            goto L_0x0118
        L_0x008c:
            com.onesignal.common.IDManager r2 = com.onesignal.common.IDManager.INSTANCE
            boolean r2 = r2.isLocalId(r15)
            if (r2 != 0) goto L_0x0118
            r2 = r7
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            int r2 = r2.length()
            if (r2 != 0) goto L_0x009f
            goto L_0x0118
        L_0x009f:
            kotlinx.coroutines.sync.Mutex r2 = r14.fetchIAMMutex
            r0.L$0 = r14
            r0.L$1 = r7
            r0.L$2 = r15
            r0.L$3 = r2
            r0.label = r5
            java.lang.Object r5 = r2.lock(r6, r0)
            if (r5 != r1) goto L_0x00b2
            return r1
        L_0x00b2:
            r5 = r15
            r15 = r2
            r2 = r14
        L_0x00b5:
            com.onesignal.core.internal.time.ITime r8 = r2._time     // Catch:{ all -> 0x0113 }
            long r8 = r8.getCurrentTimeMillis()     // Catch:{ all -> 0x0113 }
            java.lang.Long r10 = r2.lastTimeFetchedIAMs     // Catch:{ all -> 0x0113 }
            if (r10 == 0) goto L_0x00de
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)     // Catch:{ all -> 0x0113 }
            long r10 = r10.longValue()     // Catch:{ all -> 0x0113 }
            long r10 = r8 - r10
            com.onesignal.core.internal.config.ConfigModelStore r12 = r2._configModelStore     // Catch:{ all -> 0x0113 }
            com.onesignal.common.modeling.Model r12 = r12.getModel()     // Catch:{ all -> 0x0113 }
            com.onesignal.core.internal.config.ConfigModel r12 = (com.onesignal.core.internal.config.ConfigModel) r12     // Catch:{ all -> 0x0113 }
            long r12 = r12.getFetchIAMMinInterval()     // Catch:{ all -> 0x0113 }
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 >= 0) goto L_0x00de
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0113 }
            r15.unlock(r6)
            return r0
        L_0x00de:
            java.lang.Long r8 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r8)     // Catch:{ all -> 0x0113 }
            r2.lastTimeFetchedIAMs = r8     // Catch:{ all -> 0x0113 }
            kotlin.Unit r8 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0113 }
            r15.unlock(r6)
            com.onesignal.inAppMessages.internal.backend.IInAppBackendService r15 = r2._backend
            r0.L$0 = r2
            r0.L$1 = r6
            r0.L$2 = r6
            r0.L$3 = r6
            r0.label = r4
            java.lang.Object r15 = r15.listInAppMessages(r7, r5, r0)
            if (r15 != r1) goto L_0x00fc
            return r1
        L_0x00fc:
            java.util.List r15 = (java.util.List) r15
            if (r15 == 0) goto L_0x0110
            r2.messages = r15
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r15 = r2.evaluateInAppMessages(r0)
            if (r15 != r1) goto L_0x010d
            return r1
        L_0x010d:
            kotlin.Unit r15 = kotlin.Unit.INSTANCE
            return r15
        L_0x0110:
            kotlin.Unit r15 = kotlin.Unit.INSTANCE
            return r15
        L_0x0113:
            r0 = move-exception
            r15.unlock(r6)
            throw r0
        L_0x0118:
            kotlin.Unit r15 = kotlin.Unit.INSTANCE
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.InAppMessagesManager.fetchMessages(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object evaluateInAppMessages(kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.onesignal.inAppMessages.internal.InAppMessagesManager$evaluateInAppMessages$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.onesignal.inAppMessages.internal.InAppMessagesManager$evaluateInAppMessages$1 r0 = (com.onesignal.inAppMessages.internal.InAppMessagesManager$evaluateInAppMessages$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.onesignal.inAppMessages.internal.InAppMessagesManager$evaluateInAppMessages$1 r0 = new com.onesignal.inAppMessages.internal.InAppMessagesManager$evaluateInAppMessages$1
            r0.<init>(r7, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r2 = r0.L$1
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r4 = r0.L$0
            com.onesignal.inAppMessages.internal.InAppMessagesManager r4 = (com.onesignal.inAppMessages.internal.InAppMessagesManager) r4
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x004c
        L_0x0032:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r8)
            java.lang.String r8 = "InAppMessagesManager.evaluateInAppMessages()"
            r2 = 2
            r4 = 0
            com.onesignal.debug.internal.logging.Logging.debug$default(r8, r4, r2, r4)
            java.util.List<com.onesignal.inAppMessages.internal.InAppMessage> r8 = r7.messages
            java.util.Iterator r8 = r8.iterator()
            r4 = r7
            r2 = r8
        L_0x004c:
            boolean r8 = r2.hasNext()
            if (r8 == 0) goto L_0x0082
            java.lang.Object r8 = r2.next()
            com.onesignal.inAppMessages.internal.InAppMessage r8 = (com.onesignal.inAppMessages.internal.InAppMessage) r8
            com.onesignal.inAppMessages.internal.triggers.ITriggerController r5 = r4._triggerController
            boolean r5 = r5.evaluateMessageTriggers(r8)
            if (r5 == 0) goto L_0x004c
            r4.setDataForRedisplay(r8)
            java.util.Set<java.lang.String> r5 = r4.dismissedMessages
            java.lang.String r6 = r8.getMessageId()
            boolean r5 = r5.contains(r6)
            if (r5 != 0) goto L_0x004c
            boolean r5 = r8.isFinished()
            if (r5 != 0) goto L_0x004c
            r0.L$0 = r4
            r0.L$1 = r2
            r0.label = r3
            java.lang.Object r8 = r4.queueMessageForDisplay(r8, r0)
            if (r8 != r1) goto L_0x004c
            return r1
        L_0x0082:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.InAppMessagesManager.evaluateInAppMessages(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void setDataForRedisplay(InAppMessage inAppMessage) {
        boolean contains = this.dismissedMessages.contains(inAppMessage.getMessageId());
        int indexOf = this.redisplayedInAppMessages.indexOf(inAppMessage);
        if (contains && indexOf != -1) {
            InAppMessage inAppMessage2 = this.redisplayedInAppMessages.get(indexOf);
            inAppMessage.getRedisplayStats().setDisplayStats(inAppMessage2.getRedisplayStats());
            inAppMessage.setDisplayedInSession(inAppMessage2.isDisplayedInSession());
            boolean hasMessageTriggerChanged = hasMessageTriggerChanged(inAppMessage);
            Logging.debug$default("InAppMessagesManager.setDataForRedisplay: " + inAppMessage + " triggerHasChanged: " + hasMessageTriggerChanged, (Throwable) null, 2, (Object) null);
            if (hasMessageTriggerChanged && inAppMessage.getRedisplayStats().isDelayTimeSatisfied() && inAppMessage.getRedisplayStats().shouldDisplayAgain()) {
                Logging.debug$default("InAppMessagesManager.setDataForRedisplay message available for redisplay: " + inAppMessage.getMessageId(), (Throwable) null, 2, (Object) null);
                this.dismissedMessages.remove(inAppMessage.getMessageId());
                this.impressionedMessages.remove(inAppMessage.getMessageId());
                this.viewedPageIds.clear();
                this._prefs.setViewPageImpressionedIds(this.viewedPageIds);
                inAppMessage.clearClickIds();
            }
        }
    }

    private final boolean hasMessageTriggerChanged(InAppMessage inAppMessage) {
        if (this._triggerController.messageHasOnlyDynamicTriggers(inAppMessage)) {
            return !inAppMessage.isDisplayedInSession();
        }
        boolean z = !inAppMessage.isDisplayedInSession() && inAppMessage.getTriggers().isEmpty();
        if (inAppMessage.isTriggerChanged() || z) {
            return true;
        }
        return false;
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a8 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object queueMessageForDisplay(com.onesignal.inAppMessages.internal.InAppMessage r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r8 = this;
            java.lang.String r0 = "InAppMessagesManager.queueMessageForDisplay: In app message with id: "
            boolean r1 = r10 instanceof com.onesignal.inAppMessages.internal.InAppMessagesManager$queueMessageForDisplay$1
            if (r1 == 0) goto L_0x0016
            r1 = r10
            com.onesignal.inAppMessages.internal.InAppMessagesManager$queueMessageForDisplay$1 r1 = (com.onesignal.inAppMessages.internal.InAppMessagesManager$queueMessageForDisplay$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0016
            int r10 = r1.label
            int r10 = r10 - r3
            r1.label = r10
            goto L_0x001b
        L_0x0016:
            com.onesignal.inAppMessages.internal.InAppMessagesManager$queueMessageForDisplay$1 r1 = new com.onesignal.inAppMessages.internal.InAppMessagesManager$queueMessageForDisplay$1
            r1.<init>(r8, r10)
        L_0x001b:
            java.lang.Object r10 = r1.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            r4 = 1
            r5 = 2
            r6 = 0
            if (r3 == 0) goto L_0x004b
            if (r3 == r4) goto L_0x0039
            if (r3 != r5) goto L_0x0031
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x00a9
        L_0x0031:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0039:
            java.lang.Object r9 = r1.L$2
            kotlinx.coroutines.sync.Mutex r9 = (kotlinx.coroutines.sync.Mutex) r9
            java.lang.Object r3 = r1.L$1
            com.onesignal.inAppMessages.internal.InAppMessage r3 = (com.onesignal.inAppMessages.internal.InAppMessage) r3
            java.lang.Object r4 = r1.L$0
            com.onesignal.inAppMessages.internal.InAppMessagesManager r4 = (com.onesignal.inAppMessages.internal.InAppMessagesManager) r4
            kotlin.ResultKt.throwOnFailure(r10)
            r10 = r9
            r9 = r3
            goto L_0x0060
        L_0x004b:
            kotlin.ResultKt.throwOnFailure(r10)
            kotlinx.coroutines.sync.Mutex r10 = r8.messageDisplayQueueMutex
            r1.L$0 = r8
            r1.L$1 = r9
            r1.L$2 = r10
            r1.label = r4
            java.lang.Object r3 = r10.lock(r6, r1)
            if (r3 != r2) goto L_0x005f
            return r2
        L_0x005f:
            r4 = r8
        L_0x0060:
            java.util.List<com.onesignal.inAppMessages.internal.InAppMessage> r3 = r4.messageDisplayQueue     // Catch:{ all -> 0x00ac }
            boolean r3 = r3.contains(r9)     // Catch:{ all -> 0x00ac }
            if (r3 != 0) goto L_0x0095
            com.onesignal.inAppMessages.internal.state.InAppStateService r3 = r4._state     // Catch:{ all -> 0x00ac }
            java.lang.String r3 = r3.getInAppMessageIdShowing()     // Catch:{ all -> 0x00ac }
            java.lang.String r7 = r9.getMessageId()     // Catch:{ all -> 0x00ac }
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r7)     // Catch:{ all -> 0x00ac }
            if (r3 != 0) goto L_0x0095
            java.util.List<com.onesignal.inAppMessages.internal.InAppMessage> r3 = r4.messageDisplayQueue     // Catch:{ all -> 0x00ac }
            r3.add(r9)     // Catch:{ all -> 0x00ac }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ac }
            r3.<init>(r0)     // Catch:{ all -> 0x00ac }
            java.lang.String r9 = r9.getMessageId()     // Catch:{ all -> 0x00ac }
            r3.append(r9)     // Catch:{ all -> 0x00ac }
            java.lang.String r9 = ", added to the queue"
            r3.append(r9)     // Catch:{ all -> 0x00ac }
            java.lang.String r9 = r3.toString()     // Catch:{ all -> 0x00ac }
            com.onesignal.debug.internal.logging.Logging.debug$default(r9, r6, r5, r6)     // Catch:{ all -> 0x00ac }
        L_0x0095:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00ac }
            r10.unlock(r6)
            r1.L$0 = r6
            r1.L$1 = r6
            r1.L$2 = r6
            r1.label = r5
            java.lang.Object r9 = r4.attemptToShowInAppMessage(r1)
            if (r9 != r2) goto L_0x00a9
            return r2
        L_0x00a9:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        L_0x00ac:
            r9 = move-exception
            r10.unlock(r6)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.InAppMessagesManager.queueMessageForDisplay(com.onesignal.inAppMessages.internal.InAppMessage, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00be A[Catch:{ all -> 0x016a }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c4 A[Catch:{ all -> 0x016a }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object attemptToShowInAppMessage(kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            r14 = this;
            java.lang.String r0 = "InAppMessagesManager.attemptToShowInAppMessage: "
            boolean r1 = r15 instanceof com.onesignal.inAppMessages.internal.InAppMessagesManager$attemptToShowInAppMessage$1
            if (r1 == 0) goto L_0x0016
            r1 = r15
            com.onesignal.inAppMessages.internal.InAppMessagesManager$attemptToShowInAppMessage$1 r1 = (com.onesignal.inAppMessages.internal.InAppMessagesManager$attemptToShowInAppMessage$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0016
            int r15 = r1.label
            int r15 = r15 - r3
            r1.label = r15
            goto L_0x001b
        L_0x0016:
            com.onesignal.inAppMessages.internal.InAppMessagesManager$attemptToShowInAppMessage$1 r1 = new com.onesignal.inAppMessages.internal.InAppMessagesManager$attemptToShowInAppMessage$1
            r1.<init>(r14, r15)
        L_0x001b:
            java.lang.Object r15 = r1.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            r4 = 0
            r5 = 5
            r6 = 4
            r7 = 3
            r8 = 1
            r9 = 2
            r10 = 0
            if (r3 == 0) goto L_0x0070
            if (r3 == r8) goto L_0x0068
            if (r3 == r9) goto L_0x0055
            if (r3 == r7) goto L_0x0048
            if (r3 == r6) goto L_0x0043
            if (r3 != r5) goto L_0x003b
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x0164
        L_0x003b:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L_0x0043:
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x013e
        L_0x0048:
            java.lang.Object r0 = r1.L$1
            kotlin.jvm.internal.Ref$ObjectRef r0 = (kotlin.jvm.internal.Ref.ObjectRef) r0
            java.lang.Object r3 = r1.L$0
            com.onesignal.inAppMessages.internal.InAppMessagesManager r3 = (com.onesignal.inAppMessages.internal.InAppMessagesManager) r3
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x0121
        L_0x0055:
            java.lang.Object r3 = r1.L$2
            kotlinx.coroutines.sync.Mutex r3 = (kotlinx.coroutines.sync.Mutex) r3
            java.lang.Object r11 = r1.L$1
            kotlin.jvm.internal.Ref$ObjectRef r11 = (kotlin.jvm.internal.Ref.ObjectRef) r11
            java.lang.Object r12 = r1.L$0
            com.onesignal.inAppMessages.internal.InAppMessagesManager r12 = (com.onesignal.inAppMessages.internal.InAppMessagesManager) r12
            kotlin.ResultKt.throwOnFailure(r15)
            r15 = r11
            r11 = r3
            r3 = r12
            goto L_0x00a7
        L_0x0068:
            java.lang.Object r3 = r1.L$0
            com.onesignal.inAppMessages.internal.InAppMessagesManager r3 = (com.onesignal.inAppMessages.internal.InAppMessagesManager) r3
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x0081
        L_0x0070:
            kotlin.ResultKt.throwOnFailure(r15)
            com.onesignal.core.internal.application.IApplicationService r15 = r14._applicationService
            r1.L$0 = r14
            r1.label = r8
            java.lang.Object r15 = r15.waitUntilSystemConditionsAvailable(r1)
            if (r15 != r2) goto L_0x0080
            return r2
        L_0x0080:
            r3 = r14
        L_0x0081:
            java.lang.Boolean r15 = (java.lang.Boolean) r15
            boolean r15 = r15.booleanValue()
            if (r15 != 0) goto L_0x0091
            java.lang.String r15 = "InAppMessagesManager.attemptToShowInAppMessage: In app message not showing due to system condition not correct"
            com.onesignal.debug.internal.logging.Logging.warn$default(r15, r10, r9, r10)
            kotlin.Unit r15 = kotlin.Unit.INSTANCE
            return r15
        L_0x0091:
            kotlin.jvm.internal.Ref$ObjectRef r15 = new kotlin.jvm.internal.Ref$ObjectRef
            r15.<init>()
            kotlinx.coroutines.sync.Mutex r11 = r3.messageDisplayQueueMutex
            r1.L$0 = r3
            r1.L$1 = r15
            r1.L$2 = r11
            r1.label = r9
            java.lang.Object r12 = r11.lock(r10, r1)
            if (r12 != r2) goto L_0x00a7
            return r2
        L_0x00a7:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x016a }
            r12.<init>(r0)     // Catch:{ all -> 0x016a }
            java.util.List<com.onesignal.inAppMessages.internal.InAppMessage> r0 = r3.messageDisplayQueue     // Catch:{ all -> 0x016a }
            r12.append(r0)     // Catch:{ all -> 0x016a }
            java.lang.String r0 = r12.toString()     // Catch:{ all -> 0x016a }
            com.onesignal.debug.internal.logging.Logging.debug$default(r0, r10, r9, r10)     // Catch:{ all -> 0x016a }
            boolean r0 = r3.getPaused()     // Catch:{ all -> 0x016a }
            if (r0 == 0) goto L_0x00c4
            java.lang.String r0 = "InAppMessagesManager.attemptToShowInAppMessage: In app messaging is currently paused, in app messages will not be shown!"
            com.onesignal.debug.internal.logging.Logging.warn$default(r0, r10, r9, r10)     // Catch:{ all -> 0x016a }
            goto L_0x00fd
        L_0x00c4:
            java.util.List<com.onesignal.inAppMessages.internal.InAppMessage> r0 = r3.messageDisplayQueue     // Catch:{ all -> 0x016a }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x016a }
            if (r0 == 0) goto L_0x00d2
            java.lang.String r0 = "InAppMessagesManager.attemptToShowInAppMessage: There are no IAMs left in the queue!"
            com.onesignal.debug.internal.logging.Logging.debug$default(r0, r10, r9, r10)     // Catch:{ all -> 0x016a }
            goto L_0x00fd
        L_0x00d2:
            com.onesignal.inAppMessages.internal.state.InAppStateService r0 = r3._state     // Catch:{ all -> 0x016a }
            java.lang.String r0 = r0.getInAppMessageIdShowing()     // Catch:{ all -> 0x016a }
            if (r0 == 0) goto L_0x00e0
            java.lang.String r0 = "InAppMessagesManager.attemptToShowInAppMessage: There is an IAM currently showing!"
            com.onesignal.debug.internal.logging.Logging.debug$default(r0, r10, r9, r10)     // Catch:{ all -> 0x016a }
            goto L_0x00fd
        L_0x00e0:
            java.lang.String r0 = "InAppMessagesManager.attemptToShowInAppMessage: No IAM showing currently, showing first item in the queue!"
            com.onesignal.debug.internal.logging.Logging.debug$default(r0, r10, r9, r10)     // Catch:{ all -> 0x016a }
            java.util.List<com.onesignal.inAppMessages.internal.InAppMessage> r0 = r3.messageDisplayQueue     // Catch:{ all -> 0x016a }
            java.lang.Object r0 = r0.remove(r4)     // Catch:{ all -> 0x016a }
            r15.element = r0     // Catch:{ all -> 0x016a }
            com.onesignal.inAppMessages.internal.state.InAppStateService r0 = r3._state     // Catch:{ all -> 0x016a }
            T r9 = r15.element     // Catch:{ all -> 0x016a }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)     // Catch:{ all -> 0x016a }
            com.onesignal.inAppMessages.internal.InAppMessage r9 = (com.onesignal.inAppMessages.internal.InAppMessage) r9     // Catch:{ all -> 0x016a }
            java.lang.String r9 = r9.getMessageId()     // Catch:{ all -> 0x016a }
            r0.setInAppMessageIdShowing(r9)     // Catch:{ all -> 0x016a }
        L_0x00fd:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x016a }
            r11.unlock(r10)
            T r0 = r15.element
            if (r0 == 0) goto L_0x0167
            com.onesignal.inAppMessages.internal.display.IInAppDisplayer r0 = r3._displayer
            T r9 = r15.element
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            com.onesignal.inAppMessages.internal.InAppMessage r9 = (com.onesignal.inAppMessages.internal.InAppMessage) r9
            r1.L$0 = r3
            r1.L$1 = r15
            r1.L$2 = r10
            r1.label = r7
            java.lang.Object r0 = r0.displayMessage(r9, r1)
            if (r0 != r2) goto L_0x011e
            return r2
        L_0x011e:
            r13 = r0
            r0 = r15
            r15 = r13
        L_0x0121:
            java.lang.Boolean r15 = (java.lang.Boolean) r15
            if (r15 != 0) goto L_0x0141
            com.onesignal.inAppMessages.internal.state.InAppStateService r15 = r3._state
            r15.setInAppMessageIdShowing(r10)
            T r15 = r0.element
            kotlin.jvm.internal.Intrinsics.checkNotNull(r15)
            com.onesignal.inAppMessages.internal.InAppMessage r15 = (com.onesignal.inAppMessages.internal.InAppMessage) r15
            r1.L$0 = r10
            r1.L$1 = r10
            r1.label = r6
            java.lang.Object r15 = r3.queueMessageForDisplay(r15, r1)
            if (r15 != r2) goto L_0x013e
            return r2
        L_0x013e:
            kotlin.Unit r15 = kotlin.Unit.INSTANCE
            return r15
        L_0x0141:
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            boolean r15 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r4)
            if (r15 == 0) goto L_0x0167
            com.onesignal.inAppMessages.internal.state.InAppStateService r15 = r3._state
            r15.setInAppMessageIdShowing(r10)
            T r15 = r0.element
            kotlin.jvm.internal.Intrinsics.checkNotNull(r15)
            com.onesignal.inAppMessages.internal.InAppMessage r15 = (com.onesignal.inAppMessages.internal.InAppMessage) r15
            r1.L$0 = r10
            r1.L$1 = r10
            r1.label = r5
            java.lang.Object r15 = r3.messageWasDismissed(r15, r8, r1)
            if (r15 != r2) goto L_0x0164
            return r2
        L_0x0164:
            kotlin.Unit r15 = kotlin.Unit.INSTANCE
            return r15
        L_0x0167:
            kotlin.Unit r15 = kotlin.Unit.INSTANCE
            return r15
        L_0x016a:
            r15 = move-exception
            r11.unlock(r10)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.InAppMessagesManager.attemptToShowInAppMessage(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object messageWasDismissed(com.onesignal.inAppMessages.internal.InAppMessage r10, boolean r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r9 = this;
            boolean r0 = r12 instanceof com.onesignal.inAppMessages.internal.InAppMessagesManager$messageWasDismissed$1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            com.onesignal.inAppMessages.internal.InAppMessagesManager$messageWasDismissed$1 r0 = (com.onesignal.inAppMessages.internal.InAppMessagesManager$messageWasDismissed$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            com.onesignal.inAppMessages.internal.InAppMessagesManager$messageWasDismissed$1 r0 = new com.onesignal.inAppMessages.internal.InAppMessagesManager$messageWasDismissed$1
            r0.<init>(r9, r12)
        L_0x0019:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 1
            r5 = 2
            r6 = 0
            if (r2 == 0) goto L_0x004b
            if (r2 == r4) goto L_0x003f
            if (r2 == r5) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x00f8
        L_0x0032:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x00e3
        L_0x003f:
            java.lang.Object r10 = r0.L$1
            com.onesignal.inAppMessages.internal.InAppMessage r10 = (com.onesignal.inAppMessages.internal.InAppMessage) r10
            java.lang.Object r11 = r0.L$0
            com.onesignal.inAppMessages.internal.InAppMessagesManager r11 = (com.onesignal.inAppMessages.internal.InAppMessagesManager) r11
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0083
        L_0x004b:
            kotlin.ResultKt.throwOnFailure(r12)
            boolean r12 = r10.isPreview()
            if (r12 != 0) goto L_0x0097
            java.util.Set<java.lang.String> r12 = r9.dismissedMessages
            java.lang.String r2 = r10.getMessageId()
            r12.add(r2)
            if (r11 != 0) goto L_0x0082
            com.onesignal.inAppMessages.internal.preferences.IInAppPreferencesController r11 = r9._prefs
            java.util.Set<java.lang.String> r12 = r9.dismissedMessages
            r11.setDismissedMessagesId(r12)
            com.onesignal.inAppMessages.internal.state.InAppStateService r11 = r9._state
            com.onesignal.core.internal.time.ITime r12 = r9._time
            long r7 = r12.getCurrentTimeMillis()
            java.lang.Long r12 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r7)
            r11.setLastTimeInAppDismissed(r12)
            r0.L$0 = r9
            r0.L$1 = r10
            r0.label = r4
            java.lang.Object r11 = r9.persistInAppMessage(r10, r0)
            if (r11 != r1) goto L_0x0082
            return r1
        L_0x0082:
            r11 = r9
        L_0x0083:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r2 = "InAppMessagesManager.messageWasDismissed: dismissedMessages: "
            r12.<init>(r2)
            java.util.Set<java.lang.String> r2 = r11.dismissedMessages
            r12.append(r2)
            java.lang.String r12 = r12.toString()
            com.onesignal.debug.internal.logging.Logging.debug$default(r12, r6, r5, r6)
            goto L_0x0098
        L_0x0097:
            r11 = r9
        L_0x0098:
            com.onesignal.session.internal.influence.IInfluenceManager r12 = r11._influenceManager
            r12.onInAppMessageDismissed()
            com.onesignal.inAppMessages.internal.state.InAppStateService r12 = r11._state
            com.onesignal.inAppMessages.internal.prompt.impl.InAppMessagePrompt r12 = r12.getCurrentPrompt()
            if (r12 == 0) goto L_0x00ad
            java.lang.String r10 = "InAppMessagesManager.messageWasDismissed: Stop evaluateMessageDisplayQueue because prompt is currently displayed"
            com.onesignal.debug.internal.logging.Logging.debug$default(r10, r6, r5, r6)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x00ad:
            com.onesignal.common.events.EventProducer<com.onesignal.inAppMessages.IInAppMessageLifecycleListener> r12 = r11.lifecycleCallback
            boolean r12 = r12.getHasSubscribers()
            if (r12 == 0) goto L_0x00c1
            com.onesignal.common.events.EventProducer<com.onesignal.inAppMessages.IInAppMessageLifecycleListener> r12 = r11.lifecycleCallback
            com.onesignal.inAppMessages.internal.InAppMessagesManager$messageWasDismissed$2 r2 = new com.onesignal.inAppMessages.internal.InAppMessagesManager$messageWasDismissed$2
            r2.<init>(r10)
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r12.fireOnMain(r2)
        L_0x00c1:
            com.onesignal.inAppMessages.internal.state.InAppStateService r10 = r11._state
            r10.setInAppMessageIdShowing(r6)
            java.util.List<com.onesignal.inAppMessages.internal.InAppMessage> r10 = r11.messageDisplayQueue
            java.util.Collection r10 = (java.util.Collection) r10
            boolean r10 = r10.isEmpty()
            r10 = r10 ^ r4
            if (r10 == 0) goto L_0x00e6
            java.lang.String r10 = "InAppMessagesManager.messageWasDismissed: In app message on queue available, attempting to show"
            com.onesignal.debug.internal.logging.Logging.debug$default(r10, r6, r5, r6)
            r0.L$0 = r6
            r0.L$1 = r6
            r0.label = r5
            java.lang.Object r10 = r11.attemptToShowInAppMessage(r0)
            if (r10 != r1) goto L_0x00e3
            return r1
        L_0x00e3:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x00e6:
            java.lang.String r10 = "InAppMessagesManager.messageWasDismissed: In app message dismissed evaluating messages"
            com.onesignal.debug.internal.logging.Logging.debug$default(r10, r6, r5, r6)
            r0.L$0 = r6
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r10 = r11.evaluateInAppMessages(r0)
            if (r10 != r1) goto L_0x00f8
            return r1
        L_0x00f8:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.InAppMessagesManager.messageWasDismissed(com.onesignal.inAppMessages.internal.InAppMessage, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object messageWasDismissed$default(InAppMessagesManager inAppMessagesManager, InAppMessage inAppMessage, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return inAppMessagesManager.messageWasDismissed(inAppMessage, z, continuation);
    }

    private final void makeRedisplayMessagesAvailableWithTriggers(Collection<String> collection) {
        for (InAppMessage next : this.messages) {
            if (!next.isTriggerChanged() && this.redisplayedInAppMessages.contains(next) && this._triggerController.isTriggerOnMessage(next, collection)) {
                Logging.debug$default("InAppMessagesManager.makeRedisplayMessagesAvailableWithTriggers: Trigger changed for message: " + next, (Throwable) null, 2, (Object) null);
                next.setTriggerChanged(true);
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object persistInAppMessage(com.onesignal.inAppMessages.internal.InAppMessage r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.onesignal.inAppMessages.internal.InAppMessagesManager$persistInAppMessage$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            com.onesignal.inAppMessages.internal.InAppMessagesManager$persistInAppMessage$1 r0 = (com.onesignal.inAppMessages.internal.InAppMessagesManager$persistInAppMessage$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            com.onesignal.inAppMessages.internal.InAppMessagesManager$persistInAppMessage$1 r0 = new com.onesignal.inAppMessages.internal.InAppMessagesManager$persistInAppMessage$1
            r0.<init>(r8, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r9 = r0.L$1
            com.onesignal.inAppMessages.internal.InAppMessage r9 = (com.onesignal.inAppMessages.internal.InAppMessage) r9
            java.lang.Object r0 = r0.L$0
            com.onesignal.inAppMessages.internal.InAppMessagesManager r0 = (com.onesignal.inAppMessages.internal.InAppMessagesManager) r0
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x006c
        L_0x0032:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r10)
            com.onesignal.core.internal.time.ITime r10 = r8._time
            long r4 = r10.getCurrentTimeMillis()
            r10 = 1000(0x3e8, float:1.401E-42)
            long r6 = (long) r10
            long r4 = r4 / r6
            com.onesignal.inAppMessages.internal.InAppMessageRedisplayStats r10 = r9.getRedisplayStats()
            r10.setLastDisplayTime(r4)
            com.onesignal.inAppMessages.internal.InAppMessageRedisplayStats r10 = r9.getRedisplayStats()
            r10.incrementDisplayQuantity()
            r10 = 0
            r9.setTriggerChanged(r10)
            r9.setDisplayedInSession(r3)
            com.onesignal.inAppMessages.internal.repositories.IInAppRepository r10 = r8._repository
            r0.L$0 = r8
            r0.L$1 = r9
            r0.label = r3
            java.lang.Object r10 = r10.saveInAppMessage(r9, r0)
            if (r10 != r1) goto L_0x006b
            return r1
        L_0x006b:
            r0 = r8
        L_0x006c:
            com.onesignal.inAppMessages.internal.preferences.IInAppPreferencesController r10 = r0._prefs
            com.onesignal.inAppMessages.internal.state.InAppStateService r1 = r0._state
            java.lang.Long r1 = r1.getLastTimeInAppDismissed()
            r10.setLastTimeInAppDismissed(r1)
            java.util.List<com.onesignal.inAppMessages.internal.InAppMessage> r10 = r0.redisplayedInAppMessages
            int r10 = r10.indexOf(r9)
            r1 = -1
            if (r10 == r1) goto L_0x0086
            java.util.List<com.onesignal.inAppMessages.internal.InAppMessage> r1 = r0.redisplayedInAppMessages
            r1.set(r10, r9)
            goto L_0x008b
        L_0x0086:
            java.util.List<com.onesignal.inAppMessages.internal.InAppMessage> r10 = r0.redisplayedInAppMessages
            r10.add(r9)
        L_0x008b:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r1 = "InAppMessagesManager.persistInAppMessage: "
            r10.<init>(r1)
            r10.append(r9)
            java.lang.String r9 = " with msg array data: "
            r10.append(r9)
            java.util.List<com.onesignal.inAppMessages.internal.InAppMessage> r9 = r0.redisplayedInAppMessages
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            r10 = 2
            r0 = 0
            com.onesignal.debug.internal.logging.Logging.debug$default(r9, r0, r10, r0)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.InAppMessagesManager.persistInAppMessage(com.onesignal.inAppMessages.internal.InAppMessage, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public void addTriggers(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "triggers");
        Logging.debug$default("InAppMessagesManager.addTriggers(triggers: " + map + ')', (Throwable) null, 2, (Object) null);
        for (Map.Entry next : map.entrySet()) {
            addTrigger((String) next.getKey(), (String) next.getValue());
        }
    }

    public void addTrigger(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, SubscriberAttributeKt.JSON_NAME_KEY);
        Intrinsics.checkNotNullParameter(str2, "value");
        Logging.debug$default("InAppMessagesManager.addTrigger(key: " + str + ", value: " + str2 + ')', (Throwable) null, 2, (Object) null);
        TriggerModel triggerModel = (TriggerModel) this._triggerModelStore.get(str);
        if (triggerModel != null) {
            triggerModel.setValue(str2);
            return;
        }
        TriggerModel triggerModel2 = new TriggerModel();
        triggerModel2.setId(str);
        triggerModel2.setKey(str);
        triggerModel2.setValue(str2);
        IModelStore.DefaultImpls.add$default(this._triggerModelStore, triggerModel2, (String) null, 2, (Object) null);
    }

    public void removeTriggers(Collection<String> collection) {
        Intrinsics.checkNotNullParameter(collection, "keys");
        Logging.debug$default("InAppMessagesManager.removeTriggers(keys: " + collection + ')', (Throwable) null, 2, (Object) null);
        for (String removeTrigger : collection) {
            removeTrigger(removeTrigger);
        }
    }

    public void removeTrigger(String str) {
        Intrinsics.checkNotNullParameter(str, SubscriberAttributeKt.JSON_NAME_KEY);
        Logging.debug$default("InAppMessagesManager.removeTrigger(key: " + str + ')', (Throwable) null, 2, (Object) null);
        IModelStore.DefaultImpls.remove$default(this._triggerModelStore, str, (String) null, 2, (Object) null);
    }

    public void clearTriggers() {
        Logging.debug$default("InAppMessagesManager.clearTriggers()", (Throwable) null, 2, (Object) null);
        IModelStore.DefaultImpls.clear$default(this._triggerModelStore, (String) null, 1, (Object) null);
    }

    public void onMessageWillDisplay(InAppMessage inAppMessage) {
        Intrinsics.checkNotNullParameter(inAppMessage, OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE);
        if (!this.lifecycleCallback.getHasSubscribers()) {
            Logging.verbose$default("InAppMessagesManager.onMessageWillDisplay: inAppMessageLifecycleHandler is null", (Throwable) null, 2, (Object) null);
        } else {
            this.lifecycleCallback.fireOnMain(new InAppMessagesManager$onMessageWillDisplay$1(inAppMessage));
        }
    }

    public void onMessageWasDisplayed(InAppMessage inAppMessage) {
        Intrinsics.checkNotNullParameter(inAppMessage, OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE);
        if (this.lifecycleCallback.getHasSubscribers()) {
            this.lifecycleCallback.fireOnMain(new InAppMessagesManager$onMessageWasDisplayed$1(inAppMessage));
        } else {
            Logging.verbose$default("InAppMessagesManager.onMessageWasDisplayed: inAppMessageLifecycleHandler is null", (Throwable) null, 2, (Object) null);
        }
        if (!inAppMessage.isPreview() && !this.impressionedMessages.contains(inAppMessage.getMessageId())) {
            this.impressionedMessages.add(inAppMessage.getMessageId());
            String variantIdForMessage = InAppHelper.INSTANCE.variantIdForMessage(inAppMessage, this._languageContext);
            if (variantIdForMessage != null) {
                ThreadUtilsKt.suspendifyOnThread$default(0, new InAppMessagesManager$onMessageWasDisplayed$2(this, variantIdForMessage, inAppMessage, (Continuation<? super InAppMessagesManager$onMessageWasDisplayed$2>) null), 1, (Object) null);
            }
        }
    }

    public void onMessageActionOccurredOnPreview(InAppMessage inAppMessage, InAppMessageClickResult inAppMessageClickResult) {
        Intrinsics.checkNotNullParameter(inAppMessage, OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE);
        Intrinsics.checkNotNullParameter(inAppMessageClickResult, "action");
        ThreadUtilsKt.suspendifyOnThread$default(0, new InAppMessagesManager$onMessageActionOccurredOnPreview$1(inAppMessageClickResult, inAppMessage, this, (Continuation<? super InAppMessagesManager$onMessageActionOccurredOnPreview$1>) null), 1, (Object) null);
    }

    public void onMessageActionOccurredOnMessage(InAppMessage inAppMessage, InAppMessageClickResult inAppMessageClickResult) {
        Intrinsics.checkNotNullParameter(inAppMessage, OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE);
        Intrinsics.checkNotNullParameter(inAppMessageClickResult, "action");
        ThreadUtilsKt.suspendifyOnThread$default(0, new InAppMessagesManager$onMessageActionOccurredOnMessage$1(inAppMessageClickResult, inAppMessage, this, (Continuation<? super InAppMessagesManager$onMessageActionOccurredOnMessage$1>) null), 1, (Object) null);
    }

    public void onMessagePageChanged(InAppMessage inAppMessage, InAppMessagePage inAppMessagePage) {
        Intrinsics.checkNotNullParameter(inAppMessage, OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE);
        Intrinsics.checkNotNullParameter(inAppMessagePage, "page");
        if (!inAppMessage.isPreview()) {
            ThreadUtilsKt.suspendifyOnThread$default(0, new InAppMessagesManager$onMessagePageChanged$1(this, inAppMessage, inAppMessagePage, (Continuation<? super InAppMessagesManager$onMessagePageChanged$1>) null), 1, (Object) null);
        }
    }

    public void onMessageWillDismiss(InAppMessage inAppMessage) {
        Intrinsics.checkNotNullParameter(inAppMessage, OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE);
        if (!this.lifecycleCallback.getHasSubscribers()) {
            Logging.verbose$default("InAppMessagesManager.onMessageWillDismiss: inAppMessageLifecycleHandler is null", (Throwable) null, 2, (Object) null);
        } else {
            this.lifecycleCallback.fireOnMain(new InAppMessagesManager$onMessageWillDismiss$1(inAppMessage));
        }
    }

    public void onMessageWasDismissed(InAppMessage inAppMessage) {
        Intrinsics.checkNotNullParameter(inAppMessage, OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE);
        ThreadUtilsKt.suspendifyOnThread$default(0, new InAppMessagesManager$onMessageWasDismissed$1(this, inAppMessage, (Continuation<? super InAppMessagesManager$onMessageWasDismissed$1>) null), 1, (Object) null);
    }

    public void onTriggerCompleted(String str) {
        Intrinsics.checkNotNullParameter(str, "triggerId");
        Logging.debug$default("InAppMessagesManager.onTriggerCompleted: called with triggerId: " + str, (Throwable) null, 2, (Object) null);
        Set hashSet = new HashSet();
        hashSet.add(str);
        makeRedisplayMessagesAvailableWithTriggers(hashSet);
    }

    public void onTriggerConditionChanged() {
        Logging.debug$default("InAppMessagesManager.onTriggerConditionChanged()", (Throwable) null, 2, (Object) null);
        ThreadUtilsKt.suspendifyOnThread$default(0, new InAppMessagesManager$onTriggerConditionChanged$1(this, (Continuation<? super InAppMessagesManager$onTriggerConditionChanged$1>) null), 1, (Object) null);
    }

    public void onTriggerChanged(String str) {
        Intrinsics.checkNotNullParameter(str, "newTriggerKey");
        Logging.debug$default("InAppMessagesManager.onTriggerChanged(newTriggerKey: " + str + ')', (Throwable) null, 2, (Object) null);
        makeRedisplayMessagesAvailableWithTriggers(CollectionsKt.listOf(str));
        ThreadUtilsKt.suspendifyOnThread$default(0, new InAppMessagesManager$onTriggerChanged$1(this, (Continuation<? super InAppMessagesManager$onTriggerChanged$1>) null), 1, (Object) null);
    }

    /* access modifiers changed from: private */
    public final Object beginProcessingPrompts(InAppMessage inAppMessage, List<? extends InAppMessagePrompt> list, Continuation<? super Unit> continuation) {
        if (!(!list.isEmpty())) {
            return Unit.INSTANCE;
        }
        Logging.debug$default("InAppMessagesManager.beginProcessingPrompts: IAM showing prompts from IAM: " + inAppMessage, (Throwable) null, 2, (Object) null);
        this._displayer.dismissCurrentInAppMessage();
        Object showMultiplePrompts = showMultiplePrompts(inAppMessage, list, continuation);
        return showMultiplePrompts == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? showMultiplePrompts : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object fireOutcomesForClick(java.lang.String r9, java.util.List<com.onesignal.inAppMessages.internal.InAppMessageOutcome> r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof com.onesignal.inAppMessages.internal.InAppMessagesManager$fireOutcomesForClick$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            com.onesignal.inAppMessages.internal.InAppMessagesManager$fireOutcomesForClick$1 r0 = (com.onesignal.inAppMessages.internal.InAppMessagesManager$fireOutcomesForClick$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            com.onesignal.inAppMessages.internal.InAppMessagesManager$fireOutcomesForClick$1 r0 = new com.onesignal.inAppMessages.internal.InAppMessagesManager$fireOutcomesForClick$1
            r0.<init>(r8, r11)
        L_0x0019:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0041
            if (r2 == r5) goto L_0x0035
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            goto L_0x0035
        L_0x002d:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0035:
            java.lang.Object r9 = r0.L$1
            java.util.Iterator r9 = (java.util.Iterator) r9
            java.lang.Object r10 = r0.L$0
            com.onesignal.inAppMessages.internal.InAppMessagesManager r10 = (com.onesignal.inAppMessages.internal.InAppMessagesManager) r10
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x004e
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r11)
            com.onesignal.session.internal.influence.IInfluenceManager r11 = r8._influenceManager
            r11.onDirectInfluenceFromIAM(r9)
            java.util.Iterator r9 = r10.iterator()
            r10 = r8
        L_0x004e:
            boolean r11 = r9.hasNext()
            if (r11 == 0) goto L_0x009e
            java.lang.Object r11 = r9.next()
            com.onesignal.inAppMessages.internal.InAppMessageOutcome r11 = (com.onesignal.inAppMessages.internal.InAppMessageOutcome) r11
            java.lang.String r2 = r11.getName()
            boolean r6 = r11.isUnique()
            if (r6 == 0) goto L_0x0073
            com.onesignal.session.internal.outcomes.IOutcomeEventsController r11 = r10._outcomeEventsController
            r0.L$0 = r10
            r0.L$1 = r9
            r0.label = r5
            java.lang.Object r11 = r11.sendUniqueOutcomeEvent(r2, r0)
            if (r11 != r1) goto L_0x004e
            return r1
        L_0x0073:
            float r6 = r11.getWeight()
            r7 = 0
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 <= 0) goto L_0x008f
            com.onesignal.session.internal.outcomes.IOutcomeEventsController r6 = r10._outcomeEventsController
            float r11 = r11.getWeight()
            r0.L$0 = r10
            r0.L$1 = r9
            r0.label = r4
            java.lang.Object r11 = r6.sendOutcomeEventWithValue(r2, r11, r0)
            if (r11 != r1) goto L_0x004e
            return r1
        L_0x008f:
            com.onesignal.session.internal.outcomes.IOutcomeEventsController r11 = r10._outcomeEventsController
            r0.L$0 = r10
            r0.L$1 = r9
            r0.label = r3
            java.lang.Object r11 = r11.sendOutcomeEvent(r2, r0)
            if (r11 != r1) goto L_0x004e
            return r1
        L_0x009e:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.InAppMessagesManager.fireOutcomesForClick(java.lang.String, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final void fireTagCallForClick(InAppMessageClickResult inAppMessageClickResult) {
        if (inAppMessageClickResult.getTags() != null) {
            InAppMessageTag tags = inAppMessageClickResult.getTags();
            JSONArray jSONArray = null;
            if ((tags != null ? tags.getTagsToAdd() : null) != null) {
                JSONUtils jSONUtils = JSONUtils.INSTANCE;
                JSONObject tagsToAdd = tags.getTagsToAdd();
                Intrinsics.checkNotNull(tagsToAdd);
                this._userManager.addTags(jSONUtils.newStringMapFromJSONObject(tagsToAdd));
            }
            if ((tags != null ? tags.getTagsToRemove() : null) != null) {
                JSONUtils jSONUtils2 = JSONUtils.INSTANCE;
                if (tags != null) {
                    jSONArray = tags.getTagsToRemove();
                }
                Intrinsics.checkNotNull(jSONArray);
                this._userManager.removeTags(jSONUtils2.newStringSetFromJSONArray(jSONArray));
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0079, code lost:
        r10._state.setCurrentPrompt(r9);
        com.onesignal.debug.internal.logging.Logging.debug$default("InAppMessagesManager.showMultiplePrompts: IAM prompt to handle: " + r10._state.getCurrentPrompt(), (java.lang.Throwable) null, 2, (java.lang.Object) null);
        r9 = r10._state.getCurrentPrompt();
        kotlin.jvm.internal.Intrinsics.checkNotNull(r9);
        r9.setPrompted(true);
        r9 = r10._state.getCurrentPrompt();
        kotlin.jvm.internal.Intrinsics.checkNotNull(r9);
        r3.L$0 = r10;
        r3.L$1 = r0;
        r3.L$2 = r1;
        r3.L$3 = r8;
        r3.label = 1;
        r9 = r9.handlePrompt(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00b8, code lost:
        if (r9 != r4) goto L_0x00bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00ba, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00bb, code lost:
        r18 = r9;
        r9 = r0;
        r0 = r18;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00eb A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object showMultiplePrompts(com.onesignal.inAppMessages.internal.InAppMessage r20, java.util.List<? extends com.onesignal.inAppMessages.internal.prompt.impl.InAppMessagePrompt> r21, kotlin.coroutines.Continuation<? super kotlin.Unit> r22) {
        /*
            r19 = this;
            r0 = r22
            boolean r1 = r0 instanceof com.onesignal.inAppMessages.internal.InAppMessagesManager$showMultiplePrompts$1
            if (r1 == 0) goto L_0x0018
            r1 = r0
            com.onesignal.inAppMessages.internal.InAppMessagesManager$showMultiplePrompts$1 r1 = (com.onesignal.inAppMessages.internal.InAppMessagesManager$showMultiplePrompts$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0018
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            r2 = r19
            goto L_0x001f
        L_0x0018:
            com.onesignal.inAppMessages.internal.InAppMessagesManager$showMultiplePrompts$1 r1 = new com.onesignal.inAppMessages.internal.InAppMessagesManager$showMultiplePrompts$1
            r2 = r19
            r1.<init>(r2, r0)
        L_0x001f:
            java.lang.Object r0 = r1.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r1.label
            r5 = 1
            r6 = 2
            r7 = 0
            if (r4 == 0) goto L_0x0058
            if (r4 == r5) goto L_0x003d
            if (r4 != r6) goto L_0x0035
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x0121
        L_0x0035:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x003d:
            java.lang.Object r4 = r1.L$3
            java.util.Iterator r4 = (java.util.Iterator) r4
            java.lang.Object r8 = r1.L$2
            java.util.List r8 = (java.util.List) r8
            java.lang.Object r9 = r1.L$1
            com.onesignal.inAppMessages.internal.InAppMessage r9 = (com.onesignal.inAppMessages.internal.InAppMessage) r9
            java.lang.Object r10 = r1.L$0
            com.onesignal.inAppMessages.internal.InAppMessagesManager r10 = (com.onesignal.inAppMessages.internal.InAppMessagesManager) r10
            kotlin.ResultKt.throwOnFailure(r0)
            r18 = r3
            r3 = r1
            r1 = r8
            r8 = r4
            r4 = r18
            goto L_0x00c0
        L_0x0058:
            kotlin.ResultKt.throwOnFailure(r0)
            java.util.Iterator r0 = r21.iterator()
            r8 = r0
            r10 = r2
            r4 = r3
            r0 = r20
            r3 = r1
            r1 = r21
        L_0x0067:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x00eb
            java.lang.Object r9 = r8.next()
            com.onesignal.inAppMessages.internal.prompt.impl.InAppMessagePrompt r9 = (com.onesignal.inAppMessages.internal.prompt.impl.InAppMessagePrompt) r9
            boolean r11 = r9.hasPrompted()
            if (r11 != 0) goto L_0x0067
            com.onesignal.inAppMessages.internal.state.InAppStateService r11 = r10._state
            r11.setCurrentPrompt(r9)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r11 = "InAppMessagesManager.showMultiplePrompts: IAM prompt to handle: "
            r9.<init>(r11)
            com.onesignal.inAppMessages.internal.state.InAppStateService r11 = r10._state
            com.onesignal.inAppMessages.internal.prompt.impl.InAppMessagePrompt r11 = r11.getCurrentPrompt()
            r9.append(r11)
            java.lang.String r9 = r9.toString()
            com.onesignal.debug.internal.logging.Logging.debug$default(r9, r7, r6, r7)
            com.onesignal.inAppMessages.internal.state.InAppStateService r9 = r10._state
            com.onesignal.inAppMessages.internal.prompt.impl.InAppMessagePrompt r9 = r9.getCurrentPrompt()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            r9.setPrompted(r5)
            com.onesignal.inAppMessages.internal.state.InAppStateService r9 = r10._state
            com.onesignal.inAppMessages.internal.prompt.impl.InAppMessagePrompt r9 = r9.getCurrentPrompt()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            r3.L$0 = r10
            r3.L$1 = r0
            r3.L$2 = r1
            r3.L$3 = r8
            r3.label = r5
            java.lang.Object r9 = r9.handlePrompt(r3)
            if (r9 != r4) goto L_0x00bb
            return r4
        L_0x00bb:
            r18 = r9
            r9 = r0
            r0 = r18
        L_0x00c0:
            com.onesignal.inAppMessages.internal.prompt.impl.InAppMessagePrompt$PromptActionResult r0 = (com.onesignal.inAppMessages.internal.prompt.impl.InAppMessagePrompt.PromptActionResult) r0
            com.onesignal.inAppMessages.internal.state.InAppStateService r11 = r10._state
            r11.setCurrentPrompt(r7)
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r12 = "InAppMessagesManager.showMultiplePrompts: IAM prompt to handle finished with result: "
            r11.<init>(r12)
            r11.append(r0)
            java.lang.String r11 = r11.toString()
            com.onesignal.debug.internal.logging.Logging.debug$default(r11, r7, r6, r7)
            boolean r11 = r9.isPreview()
            if (r11 == 0) goto L_0x00e8
            com.onesignal.inAppMessages.internal.prompt.impl.InAppMessagePrompt$PromptActionResult r11 = com.onesignal.inAppMessages.internal.prompt.impl.InAppMessagePrompt.PromptActionResult.LOCATION_PERMISSIONS_MISSING_MANIFEST
            if (r0 != r11) goto L_0x00e8
            r10.showAlertDialogMessage(r9, r1)
            r15 = r3
            r13 = r9
            goto L_0x00ed
        L_0x00e8:
            r0 = r9
            goto L_0x0067
        L_0x00eb:
            r13 = r0
            r15 = r3
        L_0x00ed:
            r12 = r10
            com.onesignal.inAppMessages.internal.state.InAppStateService r0 = r12._state
            com.onesignal.inAppMessages.internal.prompt.impl.InAppMessagePrompt r0 = r0.getCurrentPrompt()
            if (r0 != 0) goto L_0x0124
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "InAppMessagesManager.showMultiplePrompts: No IAM prompt to handle, dismiss message: "
            r0.<init>(r1)
            java.lang.String r1 = r13.getMessageId()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.onesignal.debug.internal.logging.Logging.debug$default(r0, r7, r6, r7)
            r14 = 0
            r16 = 2
            r17 = 0
            r15.L$0 = r7
            r15.L$1 = r7
            r15.L$2 = r7
            r15.L$3 = r7
            r15.label = r6
            java.lang.Object r0 = messageWasDismissed$default(r12, r13, r14, r15, r16, r17)
            if (r0 != r4) goto L_0x0121
            return r4
        L_0x0121:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0124:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.InAppMessagesManager.showMultiplePrompts(com.onesignal.inAppMessages.internal.InAppMessage, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final void fireClickAction(InAppMessageClickResult inAppMessageClickResult) {
        if (inAppMessageClickResult.getUrl() != null && inAppMessageClickResult.getUrl().length() > 0) {
            if (inAppMessageClickResult.getUrlTarget() == InAppMessageActionUrlType.BROWSER) {
                AndroidUtils.INSTANCE.openURLInBrowser(this._applicationService.getAppContext(), inAppMessageClickResult.getUrl());
            } else if (inAppMessageClickResult.getUrlTarget() == InAppMessageActionUrlType.IN_APP_WEBVIEW) {
                OneSignalChromeTab.INSTANCE.open$com_onesignal_inAppMessages(inAppMessageClickResult.getUrl(), true, this._applicationService.getAppContext());
            }
        }
    }

    /* access modifiers changed from: private */
    public final void logInAppMessagePreviewActions(InAppMessageClickResult inAppMessageClickResult) {
        if (inAppMessageClickResult.getTags() != null) {
            Logging.debug$default("InAppMessagesManager.logInAppMessagePreviewActions: Tags detected inside of the action click payload, ignoring because action came from IAM preview:: " + inAppMessageClickResult.getTags(), (Throwable) null, 2, (Object) null);
        }
        if (inAppMessageClickResult.getOutcomes().size() > 0) {
            Logging.debug$default("InAppMessagesManager.logInAppMessagePreviewActions: Outcomes detected inside of the action click payload, ignoring because action came from IAM preview: " + inAppMessageClickResult.getOutcomes(), (Throwable) null, 2, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public final Object firePublicClickHandler(InAppMessage inAppMessage, InAppMessageClickResult inAppMessageClickResult, Continuation<? super Unit> continuation) {
        if (!this.messageClickCallback.getHasSubscribers()) {
            return Unit.INSTANCE;
        }
        this._influenceManager.onDirectInfluenceFromIAM(inAppMessage.getMessageId());
        Object suspendingFireOnMain = this.messageClickCallback.suspendingFireOnMain(new InAppMessagesManager$firePublicClickHandler$2(new InAppMessageClickEvent(inAppMessage, inAppMessageClickResult), (Continuation<? super InAppMessagesManager$firePublicClickHandler$2>) null), continuation);
        return suspendingFireOnMain == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? suspendingFireOnMain : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object fireRESTCallForPageChange(com.onesignal.inAppMessages.internal.InAppMessage r9, com.onesignal.inAppMessages.internal.InAppMessagePage r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof com.onesignal.inAppMessages.internal.InAppMessagesManager$fireRESTCallForPageChange$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            com.onesignal.inAppMessages.internal.InAppMessagesManager$fireRESTCallForPageChange$1 r0 = (com.onesignal.inAppMessages.internal.InAppMessagesManager$fireRESTCallForPageChange$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            com.onesignal.inAppMessages.internal.InAppMessagesManager$fireRESTCallForPageChange$1 r0 = new com.onesignal.inAppMessages.internal.InAppMessagesManager$fireRESTCallForPageChange$1
            r0.<init>(r8, r11)
        L_0x0019:
            r7 = r0
            java.lang.Object r11 = r7.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 1
            if (r1 == 0) goto L_0x003c
            if (r1 != r2) goto L_0x0034
            java.lang.Object r9 = r7.L$1
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r10 = r7.L$0
            com.onesignal.inAppMessages.internal.InAppMessagesManager r10 = (com.onesignal.inAppMessages.internal.InAppMessagesManager) r10
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ BackendException -> 0x00c0 }
            goto L_0x00b6
        L_0x0034:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r11)
            com.onesignal.inAppMessages.internal.common.InAppHelper r11 = com.onesignal.inAppMessages.internal.common.InAppHelper.INSTANCE
            com.onesignal.core.internal.language.ILanguageContext r1 = r8._languageContext
            java.lang.String r4 = r11.variantIdForMessage(r9, r1)
            if (r4 != 0) goto L_0x004c
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        L_0x004c:
            java.lang.String r6 = r10.getPageId()
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = r9.getMessageId()
            r10.append(r11)
            r10.append(r6)
            java.lang.String r10 = r10.toString()
            java.util.Set<java.lang.String> r11 = r8.viewedPageIds
            boolean r11 = r11.contains(r10)
            if (r11 == 0) goto L_0x0081
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "InAppMessagesManager: Already sent page impression for id: "
            r9.<init>(r10)
            r9.append(r6)
            java.lang.String r9 = r9.toString()
            r10 = 2
            r11 = 0
            com.onesignal.debug.internal.logging.Logging.verbose$default(r9, r11, r10, r11)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        L_0x0081:
            java.util.Set<java.lang.String> r11 = r8.viewedPageIds
            r11.add(r10)
            com.onesignal.inAppMessages.internal.backend.IInAppBackendService r1 = r8._backend     // Catch:{ BackendException -> 0x00be }
            com.onesignal.core.internal.config.ConfigModelStore r11 = r8._configModelStore     // Catch:{ BackendException -> 0x00be }
            com.onesignal.common.modeling.Model r11 = r11.getModel()     // Catch:{ BackendException -> 0x00be }
            com.onesignal.core.internal.config.ConfigModel r11 = (com.onesignal.core.internal.config.ConfigModel) r11     // Catch:{ BackendException -> 0x00be }
            java.lang.String r11 = r11.getAppId()     // Catch:{ BackendException -> 0x00be }
            com.onesignal.user.internal.subscriptions.ISubscriptionManager r3 = r8._subscriptionManager     // Catch:{ BackendException -> 0x00be }
            com.onesignal.user.internal.subscriptions.SubscriptionList r3 = r3.getSubscriptions()     // Catch:{ BackendException -> 0x00be }
            com.onesignal.user.subscriptions.IPushSubscription r3 = r3.getPush()     // Catch:{ BackendException -> 0x00be }
            java.lang.String r3 = r3.getId()     // Catch:{ BackendException -> 0x00be }
            java.lang.String r5 = r9.getMessageId()     // Catch:{ BackendException -> 0x00be }
            r7.L$0 = r8     // Catch:{ BackendException -> 0x00be }
            r7.L$1 = r10     // Catch:{ BackendException -> 0x00be }
            r7.label = r2     // Catch:{ BackendException -> 0x00be }
            r2 = r11
            java.lang.Object r9 = r1.sendIAMPageImpression(r2, r3, r4, r5, r6, r7)     // Catch:{ BackendException -> 0x00be }
            if (r9 != r0) goto L_0x00b4
            return r0
        L_0x00b4:
            r9 = r10
            r10 = r8
        L_0x00b6:
            com.onesignal.inAppMessages.internal.preferences.IInAppPreferencesController r11 = r10._prefs     // Catch:{ BackendException -> 0x00c0 }
            java.util.Set<java.lang.String> r0 = r10.viewedPageIds     // Catch:{ BackendException -> 0x00c0 }
            r11.setViewPageImpressionedIds(r0)     // Catch:{ BackendException -> 0x00c0 }
            goto L_0x00c5
        L_0x00be:
            r9 = r10
            r10 = r8
        L_0x00c0:
            java.util.Set<java.lang.String> r10 = r10.viewedPageIds
            r10.remove(r9)
        L_0x00c5:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.InAppMessagesManager.fireRESTCallForPageChange(com.onesignal.inAppMessages.internal.InAppMessage, com.onesignal.inAppMessages.internal.InAppMessagePage, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object fireRESTCallForClick(com.onesignal.inAppMessages.internal.InAppMessage r10, com.onesignal.inAppMessages.internal.InAppMessageClickResult r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r9 = this;
            boolean r0 = r12 instanceof com.onesignal.inAppMessages.internal.InAppMessagesManager$fireRESTCallForClick$1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            com.onesignal.inAppMessages.internal.InAppMessagesManager$fireRESTCallForClick$1 r0 = (com.onesignal.inAppMessages.internal.InAppMessagesManager$fireRESTCallForClick$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            com.onesignal.inAppMessages.internal.InAppMessagesManager$fireRESTCallForClick$1 r0 = new com.onesignal.inAppMessages.internal.InAppMessagesManager$fireRESTCallForClick$1
            r0.<init>(r9, r12)
        L_0x0019:
            r8 = r0
            java.lang.Object r12 = r8.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r2 = 1
            if (r1 == 0) goto L_0x0042
            if (r1 != r2) goto L_0x003a
            java.lang.Object r10 = r8.L$2
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r11 = r8.L$1
            com.onesignal.inAppMessages.internal.InAppMessage r11 = (com.onesignal.inAppMessages.internal.InAppMessage) r11
            java.lang.Object r0 = r8.L$0
            com.onesignal.inAppMessages.internal.InAppMessagesManager r0 = (com.onesignal.inAppMessages.internal.InAppMessagesManager) r0
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ BackendException -> 0x00c5 }
            r12 = r10
            r10 = r11
            goto L_0x00b8
        L_0x003a:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0042:
            kotlin.ResultKt.throwOnFailure(r12)
            com.onesignal.inAppMessages.internal.common.InAppHelper r12 = com.onesignal.inAppMessages.internal.common.InAppHelper.INSTANCE
            com.onesignal.core.internal.language.ILanguageContext r1 = r9._languageContext
            java.lang.String r4 = r12.variantIdForMessage(r10, r1)
            if (r4 != 0) goto L_0x0052
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x0052:
            java.lang.String r12 = r11.getClickId()
            com.onesignal.inAppMessages.internal.InAppMessageRedisplayStats r1 = r10.getRedisplayStats()
            boolean r1 = r1.isRedisplayEnabled()
            if (r1 == 0) goto L_0x0069
            if (r12 == 0) goto L_0x0069
            boolean r1 = r10.isClickAvailable(r12)
            if (r1 == 0) goto L_0x0069
            goto L_0x0076
        L_0x0069:
            java.util.Set<java.lang.String> r1 = r9.clickedClickIds
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            boolean r1 = kotlin.collections.CollectionsKt.contains(r1, r12)
            if (r1 == 0) goto L_0x0076
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x0076:
            if (r12 == 0) goto L_0x0080
            java.util.Set<java.lang.String> r1 = r9.clickedClickIds
            r1.add(r12)
            r10.addClickId(r12)
        L_0x0080:
            com.onesignal.inAppMessages.internal.backend.IInAppBackendService r1 = r9._backend     // Catch:{ BackendException -> 0x00c3 }
            com.onesignal.core.internal.config.ConfigModelStore r3 = r9._configModelStore     // Catch:{ BackendException -> 0x00c3 }
            com.onesignal.common.modeling.Model r3 = r3.getModel()     // Catch:{ BackendException -> 0x00c3 }
            com.onesignal.core.internal.config.ConfigModel r3 = (com.onesignal.core.internal.config.ConfigModel) r3     // Catch:{ BackendException -> 0x00c3 }
            java.lang.String r3 = r3.getAppId()     // Catch:{ BackendException -> 0x00c3 }
            com.onesignal.user.internal.subscriptions.ISubscriptionManager r5 = r9._subscriptionManager     // Catch:{ BackendException -> 0x00c3 }
            com.onesignal.user.internal.subscriptions.SubscriptionList r5 = r5.getSubscriptions()     // Catch:{ BackendException -> 0x00c3 }
            com.onesignal.user.subscriptions.IPushSubscription r5 = r5.getPush()     // Catch:{ BackendException -> 0x00c3 }
            java.lang.String r5 = r5.getId()     // Catch:{ BackendException -> 0x00c3 }
            java.lang.String r6 = r10.getMessageId()     // Catch:{ BackendException -> 0x00c3 }
            boolean r7 = r11.isFirstClick()     // Catch:{ BackendException -> 0x00c3 }
            r8.L$0 = r9     // Catch:{ BackendException -> 0x00c3 }
            r8.L$1 = r10     // Catch:{ BackendException -> 0x00c3 }
            r8.L$2 = r12     // Catch:{ BackendException -> 0x00c3 }
            r8.label = r2     // Catch:{ BackendException -> 0x00c3 }
            r2 = r3
            r3 = r5
            r5 = r6
            r6 = r12
            java.lang.Object r11 = r1.sendIAMClick(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ BackendException -> 0x00c3 }
            if (r11 != r0) goto L_0x00b7
            return r0
        L_0x00b7:
            r0 = r9
        L_0x00b8:
            com.onesignal.inAppMessages.internal.preferences.IInAppPreferencesController r11 = r0._prefs     // Catch:{ BackendException -> 0x00c0 }
            java.util.Set<java.lang.String> r1 = r0.clickedClickIds     // Catch:{ BackendException -> 0x00c0 }
            r11.setClickedMessagesId(r1)     // Catch:{ BackendException -> 0x00c0 }
            goto L_0x00d5
        L_0x00c0:
            r11 = r10
            r10 = r12
            goto L_0x00c5
        L_0x00c3:
            r0 = r9
            goto L_0x00c0
        L_0x00c5:
            java.util.Set<java.lang.String> r12 = r0.clickedClickIds
            java.util.Collection r12 = (java.util.Collection) r12
            java.util.Collection r12 = kotlin.jvm.internal.TypeIntrinsics.asMutableCollection(r12)
            r12.remove(r10)
            if (r10 == 0) goto L_0x00d5
            r11.removeClickId(r10)
        L_0x00d5:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.InAppMessagesManager.fireRESTCallForClick(com.onesignal.inAppMessages.internal.InAppMessage, com.onesignal.inAppMessages.internal.InAppMessageClickResult, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void showAlertDialogMessage(InAppMessage inAppMessage, List<? extends InAppMessagePrompt> list) {
        String string = this._applicationService.getAppContext().getString(R.string.location_permission_missing_title);
        Intrinsics.checkNotNullExpressionValue(string, "_applicationService.appC…permission_missing_title)");
        String string2 = this._applicationService.getAppContext().getString(R.string.location_permission_missing_message);
        Intrinsics.checkNotNullExpressionValue(string2, "_applicationService.appC…rmission_missing_message)");
        new AlertDialog.Builder(this._applicationService.getCurrent()).setTitle(string).setMessage(string2).setPositiveButton(17039370, new InAppMessagesManager$$ExternalSyntheticLambda0(this, inAppMessage, list)).show();
    }

    /* access modifiers changed from: private */
    /* renamed from: showAlertDialogMessage$lambda-5  reason: not valid java name */
    public static final void m1035showAlertDialogMessage$lambda5(InAppMessagesManager inAppMessagesManager, InAppMessage inAppMessage, List list, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(inAppMessagesManager, "this$0");
        Intrinsics.checkNotNullParameter(inAppMessage, "$inAppMessage");
        Intrinsics.checkNotNullParameter(list, "$prompts");
        ThreadUtilsKt.suspendifyOnThread$default(0, new InAppMessagesManager$showAlertDialogMessage$1$1(inAppMessagesManager, inAppMessage, list, (Continuation<? super InAppMessagesManager$showAlertDialogMessage$1$1>) null), 1, (Object) null);
    }
}
