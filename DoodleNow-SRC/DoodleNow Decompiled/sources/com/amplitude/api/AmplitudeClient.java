package com.amplitude.api;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.os.Build;
import android.util.Pair;
import androidx.core.os.EnvironmentCompat;
import androidx.exifinterface.media.ExifInterface;
import com.amazon.a.a.o.b;
import com.amplitude.analytics.connector.AnalyticsConnector;
import com.amplitude.analytics.connector.AnalyticsEvent;
import com.amplitude.analytics.connector.Identity;
import com.amplitude.analytics.connector.util.JSONUtil;
import com.amplitude.api.ConfigManager;
import com.amplitude.eventexplorer.EventExplorer;
import com.amplitude.util.DoubleCheck;
import com.google.common.base.Ascii;
import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AmplitudeClient {
    public static final String DEVICE_ID_KEY = "device_id";
    public static final String END_SESSION_EVENT = "session_end";
    public static final String LAST_EVENT_ID_KEY = "last_event_id";
    public static final String LAST_EVENT_TIME_KEY = "last_event_time";
    public static final String LAST_IDENTIFY_ID_KEY = "last_identify_id";
    public static final String OPT_OUT_KEY = "opt_out";
    public static final String PREVIOUS_SESSION_ID_KEY = "previous_session_id";
    public static final String SEQUENCE_NUMBER_KEY = "sequence_number";
    public static final String START_SESSION_EVENT = "session_start";
    private static final String TAG = "com.amplitude.api.AmplitudeClient";
    public static final String USER_ID_KEY = "user_id";
    private static final AmplitudeLog logger = AmplitudeLog.getLogger();
    protected String apiKey;
    JSONObject apiPropertiesTrackingOptions;
    TrackingOptions appliedTrackingOptions;
    /* access modifiers changed from: private */
    public boolean backoffUpload;
    /* access modifiers changed from: private */
    public int backoffUploadBatchSize;
    String bearerToken;
    protected Call.Factory callFactory;
    final AnalyticsConnector connector;
    protected Context context;
    private boolean coppaControlEnabled;
    protected DatabaseHelper dbHelper;
    protected String deviceId;
    private AmplitudeDeviceIdCallback deviceIdCallback;
    protected DeviceInfo deviceInfo;
    private EventExplorer eventExplorer;
    private int eventMaxCount;
    /* access modifiers changed from: private */
    public int eventUploadMaxBatchSize;
    private long eventUploadPeriodMillis;
    /* access modifiers changed from: private */
    public int eventUploadThreshold;
    /* access modifiers changed from: private */
    public boolean flushEventsOnClose;
    WorkerThread httpThread;
    private long identifyBatchIntervalMillis;
    /* access modifiers changed from: private */
    public IdentifyInterceptor identifyInterceptor;
    private boolean inForeground;
    private IngestionMetadata ingestionMetadata;
    protected boolean initialized;
    TrackingOptions inputTrackingOptions;
    protected String instanceName;
    /* access modifiers changed from: private */
    public boolean isEnteringForeground;
    Throwable lastError;
    long lastEventId;
    long lastEventTime;
    long lastIdentifyId;
    private String libraryName;
    private String libraryVersion;
    private boolean locationListening;
    WorkerThread logThread;
    MiddlewareRunner middlewareRunner;
    private long minTimeBetweenSessionsMillis;
    private boolean newDeviceIdPerInstall;
    private boolean offline;
    /* access modifiers changed from: private */
    public boolean optOut;
    private Plan plan;
    protected String platform;
    long previousSessionId;
    long sequenceNumber;
    /* access modifiers changed from: private */
    public AmplitudeServerZone serverZone;
    long sessionId;
    private long sessionTimeoutMillis;
    /* access modifiers changed from: private */
    public boolean trackingSessionEvents;
    /* access modifiers changed from: private */
    public AtomicBoolean updateScheduled;
    AtomicBoolean uploadingCurrently;
    String url;
    private boolean useAdvertisingIdForDeviceId;
    private boolean useAppSetIdForDeviceId;
    /* access modifiers changed from: private */
    public boolean useDynamicConfig;
    protected String userId;
    private boolean usingForegroundTracking;

    public static /* synthetic */ OkHttpClient $r8$lambda$uWBdBgn9ebx5ZjaSsGzJj44YwX4() {
        return new OkHttpClient();
    }

    private boolean inSession() {
        return this.sessionId >= 0;
    }

    private boolean isWithinMinTimeBetweenSessions(long j) {
        return j - this.lastEventTime < (this.usingForegroundTracking ? this.minTimeBetweenSessionsMillis : this.sessionTimeoutMillis);
    }

    public AmplitudeClient disableDiagnosticLogging() {
        return this;
    }

    public AmplitudeClient enableDiagnosticLogging() {
        return this;
    }

    public AmplitudeClient enableNewDeviceIdPerInstall(boolean z) {
        this.newDeviceIdPerInstall = z;
        return this;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public AmplitudeServerZone getServerZone() {
        return this.serverZone;
    }

    public long getSessionId() {
        return this.sessionId;
    }

    public String getUserId() {
        return this.userId;
    }

    /* access modifiers changed from: package-private */
    public boolean isInForeground() {
        return this.inForeground;
    }

    public boolean isOptedOut() {
        return this.optOut;
    }

    /* access modifiers changed from: package-private */
    public boolean isUsingForegroundTracking() {
        return this.usingForegroundTracking;
    }

    public AmplitudeClient setBearerToken(String str) {
        this.bearerToken = str;
        return this;
    }

    public AmplitudeClient setDeviceIdCallback(AmplitudeDeviceIdCallback amplitudeDeviceIdCallback) {
        this.deviceIdCallback = amplitudeDeviceIdCallback;
        return this;
    }

    public AmplitudeClient setDiagnosticEventMaxCount(int i) {
        return this;
    }

    public AmplitudeClient setEventMaxCount(int i) {
        this.eventMaxCount = i;
        return this;
    }

    public AmplitudeClient setEventUploadMaxBatchSize(int i) {
        this.eventUploadMaxBatchSize = i;
        this.backoffUploadBatchSize = i;
        return this;
    }

    public AmplitudeClient setEventUploadPeriodMillis(int i) {
        this.eventUploadPeriodMillis = (long) i;
        return this;
    }

    public AmplitudeClient setEventUploadThreshold(int i) {
        this.eventUploadThreshold = i;
        return this;
    }

    public AmplitudeClient setFlushEventsOnClose(boolean z) {
        this.flushEventsOnClose = z;
        return this;
    }

    public AmplitudeClient setIngestionMetadata(IngestionMetadata ingestionMetadata2) {
        this.ingestionMetadata = ingestionMetadata2;
        return this;
    }

    public AmplitudeClient setLibraryName(String str) {
        this.libraryName = str;
        return this;
    }

    public AmplitudeClient setLibraryVersion(String str) {
        this.libraryVersion = str;
        return this;
    }

    public AmplitudeClient setMinTimeBetweenSessionsMillis(long j) {
        this.minTimeBetweenSessionsMillis = j;
        return this;
    }

    public AmplitudeClient setPlan(Plan plan2) {
        this.plan = plan2;
        return this;
    }

    public AmplitudeClient setSessionTimeoutMillis(long j) {
        this.sessionTimeoutMillis = j;
        return this;
    }

    public AmplitudeClient setUseDynamicConfig(boolean z) {
        this.useDynamicConfig = z;
        return this;
    }

    public AmplitudeClient trackSessionEvents(boolean z) {
        this.trackingSessionEvents = z;
        return this;
    }

    public AmplitudeClient useAdvertisingIdForDeviceId() {
        this.useAdvertisingIdForDeviceId = true;
        return this;
    }

    public AmplitudeClient useAppSetIdForDeviceId() {
        this.useAppSetIdForDeviceId = true;
        return this;
    }

    /* access modifiers changed from: package-private */
    public void useForegroundTracking() {
        this.usingForegroundTracking = true;
    }

    public AmplitudeClient() {
        this((String) null);
    }

    public AmplitudeClient(String str) {
        this.newDeviceIdPerInstall = false;
        this.useAdvertisingIdForDeviceId = false;
        this.useAppSetIdForDeviceId = false;
        this.initialized = false;
        this.optOut = false;
        this.offline = false;
        TrackingOptions trackingOptions = new TrackingOptions();
        this.inputTrackingOptions = trackingOptions;
        TrackingOptions copyOf = TrackingOptions.copyOf(trackingOptions);
        this.appliedTrackingOptions = copyOf;
        this.apiPropertiesTrackingOptions = copyOf.getApiPropertiesTrackingOptions();
        this.coppaControlEnabled = false;
        this.locationListening = true;
        this.serverZone = AmplitudeServerZone.US;
        this.sessionId = -1;
        this.sequenceNumber = 0;
        this.lastEventId = -1;
        this.lastIdentifyId = -1;
        this.lastEventTime = -1;
        this.previousSessionId = -1;
        this.eventUploadThreshold = 30;
        this.eventUploadMaxBatchSize = 50;
        this.eventMaxCount = 1000;
        this.eventUploadPeriodMillis = 30000;
        this.minTimeBetweenSessionsMillis = 300000;
        this.identifyBatchIntervalMillis = 30000;
        this.sessionTimeoutMillis = Constants.SESSION_TIMEOUT_MILLIS;
        this.backoffUpload = false;
        this.backoffUploadBatchSize = 50;
        this.usingForegroundTracking = false;
        this.trackingSessionEvents = false;
        this.inForeground = false;
        this.isEnteringForeground = false;
        this.flushEventsOnClose = true;
        this.libraryName = Constants.LIBRARY;
        this.libraryVersion = "2.39.7";
        this.useDynamicConfig = false;
        this.updateScheduled = new AtomicBoolean(false);
        this.uploadingCurrently = new AtomicBoolean(false);
        this.url = Constants.EVENT_LOG_URL;
        this.bearerToken = null;
        this.logThread = new WorkerThread("logThread");
        this.httpThread = new WorkerThread("httpThread");
        this.middlewareRunner = new MiddlewareRunner();
        this.instanceName = Utils.normalizeInstanceName(str);
        this.logThread.start();
        this.httpThread.start();
        this.connector = AnalyticsConnector.getInstance(this.instanceName);
    }

    public AmplitudeClient initialize(Context context2, String str) {
        return initialize(context2, str, (String) null);
    }

    public AmplitudeClient initialize(Context context2, String str, String str2) {
        return initialize(context2, str, str2, (String) null, false);
    }

    public synchronized AmplitudeClient initialize(Context context2, String str, String str2, String str3, boolean z) {
        return initializeInternal(context2, str, str2, str3, z, (Call.Factory) null);
    }

    public synchronized AmplitudeClient initialize(Context context2, String str, String str2, String str3, boolean z, Call.Factory factory) {
        return initializeInternal(context2, str, str2, str3, z, factory);
    }

    public synchronized AmplitudeClient initializeInternal(Context context2, String str, String str2, String str3, boolean z, Call.Factory factory) {
        if (context2 == null) {
            logger.e(TAG, "Argument context cannot be null in initialize()");
            return this;
        } else if (Utils.isEmptyString(str)) {
            logger.e(TAG, "Argument apiKey cannot be null or blank in initialize()");
            return this;
        } else {
            Context applicationContext = context2.getApplicationContext();
            this.context = applicationContext;
            this.apiKey = str;
            this.dbHelper = DatabaseHelper.getDatabaseHelper(applicationContext, this.instanceName);
            if (Utils.isEmptyString(str3)) {
                str3 = Constants.PLATFORM;
            }
            this.platform = str3;
            runOnLogThread(new AmplitudeClient$$ExternalSyntheticLambda0(this, factory, str2, this));
            return this;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$initializeInternal$2$com-amplitude-api-AmplitudeClient  reason: not valid java name */
    public /* synthetic */ void m390lambda$initializeInternal$2$comamplitudeapiAmplitudeClient(Call.Factory factory, String str, final AmplitudeClient amplitudeClient) {
        if (!this.initialized) {
            if (factory == null) {
                try {
                    this.callFactory = new AmplitudeClient$$ExternalSyntheticLambda2(DoubleCheck.provider(new AmplitudeClient$$ExternalSyntheticLambda1()));
                } catch (CursorWindowAllocationException e) {
                    logger.e(TAG, String.format("Failed to initialize Amplitude SDK due to: %s", new Object[]{e.getMessage()}));
                    amplitudeClient.apiKey = null;
                    return;
                }
            } else {
                this.callFactory = factory;
            }
            if (this.useDynamicConfig) {
                ConfigManager.getInstance().refresh(new ConfigManager.RefreshListener() {
                    public void onFinished() {
                        AmplitudeClient.this.url = ConfigManager.getInstance().getIngestionEndpoint();
                    }
                }, this.serverZone);
            }
            this.deviceInfo = initializeDeviceInfo();
            String initializeDeviceId = initializeDeviceId();
            this.deviceId = initializeDeviceId;
            AmplitudeDeviceIdCallback amplitudeDeviceIdCallback = this.deviceIdCallback;
            if (amplitudeDeviceIdCallback != null) {
                amplitudeDeviceIdCallback.onDeviceIdReady(initializeDeviceId);
            }
            if (str != null) {
                amplitudeClient.userId = str;
                this.dbHelper.insertOrReplaceKeyValue(USER_ID_KEY, str);
            } else {
                amplitudeClient.userId = this.dbHelper.getValue(USER_ID_KEY);
            }
            this.connector.getEventBridge().setEventReceiver(new AmplitudeClient$$ExternalSyntheticLambda3(this));
            this.connector.getIdentityStore().setIdentity(new Identity(str, this.deviceId, new HashMap()));
            this.deviceInfo.prefetch();
            Long longValue = this.dbHelper.getLongValue(OPT_OUT_KEY);
            this.optOut = longValue != null && longValue.longValue() == 1;
            long longvalue = getLongvalue(PREVIOUS_SESSION_ID_KEY, -1);
            this.previousSessionId = longvalue;
            if (longvalue >= 0) {
                this.sessionId = longvalue;
            }
            this.sequenceNumber = getLongvalue(SEQUENCE_NUMBER_KEY, 0);
            this.lastEventId = getLongvalue(LAST_EVENT_ID_KEY, -1);
            this.lastIdentifyId = getLongvalue(LAST_IDENTIFY_ID_KEY, -1);
            this.lastEventTime = getLongvalue(LAST_EVENT_TIME_KEY, -1);
            this.dbHelper.setDatabaseResetListener(new DatabaseResetListener() {
                public void onDatabaseReset(SQLiteDatabase sQLiteDatabase) {
                    AmplitudeClient.this.dbHelper.insertOrReplaceKeyValueToTable(sQLiteDatabase, ProductResponseJsonKeys.STORE, AmplitudeClient.DEVICE_ID_KEY, amplitudeClient.deviceId);
                    AmplitudeClient.this.dbHelper.insertOrReplaceKeyValueToTable(sQLiteDatabase, ProductResponseJsonKeys.STORE, AmplitudeClient.USER_ID_KEY, amplitudeClient.userId);
                    AmplitudeClient.this.dbHelper.insertOrReplaceKeyValueToTable(sQLiteDatabase, "long_store", AmplitudeClient.OPT_OUT_KEY, Long.valueOf(amplitudeClient.optOut ? 1 : 0));
                    AmplitudeClient.this.dbHelper.insertOrReplaceKeyValueToTable(sQLiteDatabase, "long_store", AmplitudeClient.PREVIOUS_SESSION_ID_KEY, Long.valueOf(amplitudeClient.sessionId));
                    AmplitudeClient.this.dbHelper.insertOrReplaceKeyValueToTable(sQLiteDatabase, "long_store", AmplitudeClient.LAST_EVENT_TIME_KEY, Long.valueOf(amplitudeClient.lastEventTime));
                }
            });
            this.identifyInterceptor = new IdentifyInterceptor(this.dbHelper, this.logThread, this.identifyBatchIntervalMillis, this);
            this.initialized = true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$null$1$com-amplitude-api-AmplitudeClient  reason: not valid java name */
    public /* synthetic */ Unit m391lambda$null$1$comamplitudeapiAmplitudeClient(AnalyticsEvent analyticsEvent) {
        logEventAsync(analyticsEvent.getEventType(), JSONUtil.toJSONObject(analyticsEvent.getEventProperties()), (JSONObject) null, JSONUtil.toJSONObject(analyticsEvent.getUserProperties()), (JSONObject) null, (JSONObject) null, getCurrentTimeMillis(), false);
        return Unit.INSTANCE;
    }

    public AmplitudeClient enableForegroundTracking(Application application) {
        if (!this.usingForegroundTracking && contextAndApiKeySet("enableForegroundTracking()")) {
            application.registerActivityLifecycleCallbacks(new AmplitudeCallbacks(this));
        }
        return this;
    }

    public AmplitudeClient enableLocationListening() {
        this.locationListening = true;
        DeviceInfo deviceInfo2 = this.deviceInfo;
        if (deviceInfo2 != null) {
            deviceInfo2.setLocationListening(true);
        }
        return this;
    }

    public AmplitudeClient disableLocationListening() {
        this.locationListening = false;
        DeviceInfo deviceInfo2 = this.deviceInfo;
        if (deviceInfo2 != null) {
            deviceInfo2.setLocationListening(false);
        }
        return this;
    }

    public AmplitudeClient setIdentifyBatchIntervalMillis(long j) {
        if (j < this.eventUploadPeriodMillis) {
            logger.w(TAG, "Warning: minimum batch interval is event upload period.");
            return this;
        }
        this.identifyBatchIntervalMillis = j;
        IdentifyInterceptor identifyInterceptor2 = this.identifyInterceptor;
        if (identifyInterceptor2 != null) {
            identifyInterceptor2.setIdentifyBatchIntervalMillis(j);
        }
        return this;
    }

    public AmplitudeClient setServerUrl(String str) {
        if (!Utils.isEmptyString(str)) {
            this.url = str;
        }
        return this;
    }

    public AmplitudeClient setTrackingOptions(TrackingOptions trackingOptions) {
        this.inputTrackingOptions = trackingOptions;
        TrackingOptions copyOf = TrackingOptions.copyOf(trackingOptions);
        this.appliedTrackingOptions = copyOf;
        if (this.coppaControlEnabled) {
            copyOf.mergeIn(TrackingOptions.forCoppaControl());
        }
        this.apiPropertiesTrackingOptions = this.appliedTrackingOptions.getApiPropertiesTrackingOptions();
        return this;
    }

    public AmplitudeClient enableCoppaControl() {
        this.coppaControlEnabled = true;
        this.appliedTrackingOptions.mergeIn(TrackingOptions.forCoppaControl());
        this.apiPropertiesTrackingOptions = this.appliedTrackingOptions.getApiPropertiesTrackingOptions();
        return this;
    }

    public AmplitudeClient disableCoppaControl() {
        this.coppaControlEnabled = false;
        TrackingOptions copyOf = TrackingOptions.copyOf(this.inputTrackingOptions);
        this.appliedTrackingOptions = copyOf;
        this.apiPropertiesTrackingOptions = copyOf.getApiPropertiesTrackingOptions();
        return this;
    }

    public AmplitudeClient setOptOut(final boolean z) {
        if (!contextAndApiKeySet("setOptOut()")) {
            return this;
        }
        runOnLogThread(new Runnable() {
            public void run() {
                if (!Utils.isEmptyString(AmplitudeClient.this.apiKey)) {
                    boolean unused = this.optOut = z;
                    AmplitudeClient.this.dbHelper.insertOrReplaceKeyLongValue(AmplitudeClient.OPT_OUT_KEY, Long.valueOf(z ? 1 : 0));
                }
            }
        });
        return this;
    }

    public AmplitudeClient enableLogging(boolean z) {
        logger.setEnableLogging(z);
        return this;
    }

    public AmplitudeClient setLogLevel(int i) {
        logger.setLogLevel(i);
        return this;
    }

    public AmplitudeClient setLogCallback(AmplitudeLogCallback amplitudeLogCallback) {
        logger.setAmplitudeLogCallback(amplitudeLogCallback);
        return this;
    }

    public AmplitudeClient setOffline(boolean z) {
        this.offline = z;
        if (!z) {
            uploadEvents();
        }
        return this;
    }

    public void showEventExplorer(Activity activity) {
        if (this.eventExplorer == null) {
            this.eventExplorer = new EventExplorer(this.instanceName);
        }
        this.eventExplorer.show(activity);
    }

    public void addEventMiddleware(Middleware middleware) {
        this.middlewareRunner.add(middleware);
    }

    public void logEvent(String str) {
        logEvent(str, (JSONObject) null);
    }

    public void logEvent(String str, JSONObject jSONObject) {
        logEvent(str, jSONObject, false);
    }

    public void logEvent(String str, JSONObject jSONObject, MiddlewareExtra middlewareExtra) {
        logEvent(str, jSONObject, (JSONObject) null, getCurrentTimeMillis(), false, middlewareExtra);
    }

    public void logEvent(String str, JSONObject jSONObject, boolean z) {
        logEvent(str, jSONObject, (JSONObject) null, z);
    }

    public void logEvent(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        logEvent(str, jSONObject, jSONObject2, false);
    }

    public void logEvent(String str, JSONObject jSONObject, JSONObject jSONObject2, boolean z) {
        logEvent(str, jSONObject, jSONObject2, getCurrentTimeMillis(), z);
    }

    public void logEvent(String str, JSONObject jSONObject, JSONObject jSONObject2, long j, boolean z) {
        logEvent(str, jSONObject, jSONObject2, j, z, (MiddlewareExtra) null);
    }

    public void logEvent(String str, JSONObject jSONObject, JSONObject jSONObject2, long j, boolean z, MiddlewareExtra middlewareExtra) {
        if (validateLogEvent(str)) {
            logEventAsync(str, jSONObject, (JSONObject) null, (JSONObject) null, jSONObject2, (JSONObject) null, j, z, middlewareExtra);
        }
    }

    public void logEventSync(String str) {
        logEventSync(str, (JSONObject) null);
    }

    public void logEventSync(String str, JSONObject jSONObject) {
        logEventSync(str, jSONObject, false);
    }

    public void logEventSync(String str, JSONObject jSONObject, boolean z) {
        logEventSync(str, jSONObject, (JSONObject) null, z);
    }

    public void logEventSync(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        logEventSync(str, jSONObject, jSONObject2, false);
    }

    public void logEventSync(String str, JSONObject jSONObject, JSONObject jSONObject2, boolean z) {
        logEventSync(str, jSONObject, jSONObject2, getCurrentTimeMillis(), z);
    }

    public void logEventSync(String str, JSONObject jSONObject, JSONObject jSONObject2, long j, boolean z) {
        if (validateLogEvent(str)) {
            logEvent(str, jSONObject, (JSONObject) null, (JSONObject) null, jSONObject2, (JSONObject) null, j, z, this.inForeground);
            return;
        }
    }

    /* access modifiers changed from: protected */
    public boolean validateLogEvent(String str) {
        if (!Utils.isEmptyString(str)) {
            return contextAndApiKeySet("logEvent()");
        }
        logger.e(TAG, "Argument eventType cannot be null or blank in logEvent()");
        return false;
    }

    /* access modifiers changed from: protected */
    public void logEventAsync(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, JSONObject jSONObject5, long j, boolean z) {
        logEventAsync(str, jSONObject, jSONObject2, jSONObject3, jSONObject4, jSONObject5, j, z, (MiddlewareExtra) null);
    }

    /* access modifiers changed from: protected */
    public void logEventAsync(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, JSONObject jSONObject5, long j, boolean z, MiddlewareExtra middlewareExtra) {
        final JSONObject cloneJSONObject = jSONObject != null ? Utils.cloneJSONObject(jSONObject) : jSONObject;
        final JSONObject cloneJSONObject2 = jSONObject2 != null ? Utils.cloneJSONObject(jSONObject2) : jSONObject2;
        final JSONObject cloneJSONObject3 = jSONObject3 != null ? Utils.cloneJSONObject(jSONObject3) : jSONObject3;
        final JSONObject cloneJSONObject4 = jSONObject4 != null ? Utils.cloneJSONObject(jSONObject4) : jSONObject4;
        final JSONObject cloneJSONObject5 = jSONObject5 != null ? Utils.cloneJSONObject(jSONObject5) : jSONObject5;
        final boolean z2 = this.inForeground;
        final String str2 = str;
        final long j2 = j;
        final boolean z3 = z;
        final MiddlewareExtra middlewareExtra2 = middlewareExtra;
        runOnLogThread(new Runnable() {
            public void run() {
                if (!Utils.isEmptyString(AmplitudeClient.this.apiKey)) {
                    AmplitudeClient.this.logEvent(str2, cloneJSONObject, cloneJSONObject2, cloneJSONObject3, cloneJSONObject4, cloneJSONObject5, j2, z3, middlewareExtra2, z2);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public long logEvent(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, JSONObject jSONObject5, long j, boolean z, boolean z2) {
        return logEvent(str, jSONObject, jSONObject2, jSONObject3, jSONObject4, jSONObject5, j, z, (MiddlewareExtra) null, z2);
    }

    /* access modifiers changed from: protected */
    public long logEvent(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, JSONObject jSONObject5, long j, boolean z, MiddlewareExtra middlewareExtra, boolean z2) {
        JSONObject jSONObject6;
        JSONObject jSONObject7;
        JSONObject jSONObject8;
        Location mostRecentLocation;
        String str2 = str;
        JSONObject jSONObject9 = jSONObject;
        JSONObject jSONObject10 = jSONObject3;
        JSONObject jSONObject11 = jSONObject4;
        JSONObject jSONObject12 = jSONObject5;
        long j2 = j;
        AmplitudeLog amplitudeLog = logger;
        String str3 = TAG;
        amplitudeLog.d(str3, "Logged event to Amplitude: " + str2);
        long j3 = -1;
        if (this.optOut) {
            return -1;
        }
        if ((!this.trackingSessionEvents || (!str2.equals(START_SESSION_EVENT) && !str2.equals(END_SESSION_EVENT))) && !z) {
            if (!z2 || this.isEnteringForeground) {
                this.isEnteringForeground = false;
                startNewSessionIfNeeded(j2);
            } else {
                refreshSessionTime(j2);
            }
        }
        JSONObject jSONObject13 = new JSONObject();
        try {
            jSONObject13.put("event_type", replaceWithJSONNull(str));
            jSONObject13.put("timestamp", j2);
            jSONObject13.put(USER_ID_KEY, replaceWithJSONNull(this.userId));
            jSONObject13.put(DEVICE_ID_KEY, replaceWithJSONNull(this.deviceId));
            jSONObject13.put("session_id", z ? -1 : this.sessionId);
            jSONObject13.put("uuid", UUID.randomUUID().toString());
            jSONObject13.put(SEQUENCE_NUMBER_KEY, getNextSequenceNumber());
            if (this.appliedTrackingOptions.shouldTrackVersionName()) {
                jSONObject13.put(Constants.AMP_TRACKING_OPTION_VERSION_NAME, replaceWithJSONNull(this.deviceInfo.getVersionName()));
            }
            if (this.appliedTrackingOptions.shouldTrackOsName()) {
                jSONObject13.put(Constants.AMP_TRACKING_OPTION_OS_NAME, replaceWithJSONNull(this.deviceInfo.getOsName()));
            }
            if (this.appliedTrackingOptions.shouldTrackOsVersion()) {
                jSONObject13.put(Constants.AMP_TRACKING_OPTION_OS_VERSION, replaceWithJSONNull(this.deviceInfo.getOsVersion()));
            }
            if (this.appliedTrackingOptions.shouldTrackApiLevel()) {
                jSONObject13.put(Constants.AMP_TRACKING_OPTION_API_LEVEL, replaceWithJSONNull(Integer.valueOf(Build.VERSION.SDK_INT)));
            }
            if (this.appliedTrackingOptions.shouldTrackDeviceBrand()) {
                jSONObject13.put(Constants.AMP_TRACKING_OPTION_DEVICE_BRAND, replaceWithJSONNull(this.deviceInfo.getBrand()));
            }
            if (this.appliedTrackingOptions.shouldTrackDeviceManufacturer()) {
                jSONObject13.put(Constants.AMP_TRACKING_OPTION_DEVICE_MANUFACTURER, replaceWithJSONNull(this.deviceInfo.getManufacturer()));
            }
            if (this.appliedTrackingOptions.shouldTrackDeviceModel()) {
                jSONObject13.put(Constants.AMP_TRACKING_OPTION_DEVICE_MODEL, replaceWithJSONNull(this.deviceInfo.getModel()));
            }
            if (this.appliedTrackingOptions.shouldTrackCarrier()) {
                jSONObject13.put(Constants.AMP_TRACKING_OPTION_CARRIER, replaceWithJSONNull(this.deviceInfo.getCarrier()));
            }
            if (this.appliedTrackingOptions.shouldTrackCountry()) {
                jSONObject13.put(Constants.AMP_TRACKING_OPTION_COUNTRY, replaceWithJSONNull(this.deviceInfo.getCountry()));
            }
            if (this.appliedTrackingOptions.shouldTrackLanguage()) {
                jSONObject13.put(Constants.AMP_TRACKING_OPTION_LANGUAGE, replaceWithJSONNull(this.deviceInfo.getLanguage()));
            }
            if (this.appliedTrackingOptions.shouldTrackPlatform()) {
                jSONObject13.put(Constants.AMP_TRACKING_OPTION_PLATFORM, this.platform);
            }
            JSONObject jSONObject14 = new JSONObject();
            String str4 = this.libraryName;
            if (str4 == null) {
                str4 = Constants.LIBRARY_UNKNOWN;
            }
            jSONObject14.put("name", str4);
            String str5 = this.libraryVersion;
            if (str5 == null) {
                str5 = Constants.VERSION_UNKNOWN;
            }
            jSONObject14.put(Constants.AMP_PLAN_VERSION, str5);
            jSONObject13.put("library", jSONObject14);
            Plan plan2 = this.plan;
            if (plan2 != null) {
                jSONObject13.put("plan", plan2.toJSONObject());
            }
            IngestionMetadata ingestionMetadata2 = this.ingestionMetadata;
            if (ingestionMetadata2 != null) {
                jSONObject13.put("ingestion_metadata", ingestionMetadata2.toJSONObject());
            }
            JSONObject jSONObject15 = jSONObject2 == null ? new JSONObject() : jSONObject2;
            JSONObject jSONObject16 = this.apiPropertiesTrackingOptions;
            if (jSONObject16 != null && jSONObject16.length() > 0) {
                jSONObject15.put("tracking_options", this.apiPropertiesTrackingOptions);
            }
            if (this.appliedTrackingOptions.shouldTrackLatLng() && (mostRecentLocation = this.deviceInfo.getMostRecentLocation()) != null) {
                JSONObject jSONObject17 = new JSONObject();
                jSONObject17.put("lat", mostRecentLocation.getLatitude());
                jSONObject17.put("lng", mostRecentLocation.getLongitude());
                jSONObject15.put("location", jSONObject17);
            }
            if (this.appliedTrackingOptions.shouldTrackAdid() && this.deviceInfo.getAdvertisingId() != null) {
                jSONObject15.put("androidADID", this.deviceInfo.getAdvertisingId());
            }
            if (this.appliedTrackingOptions.shouldTrackAppSetId() && this.deviceInfo.getAppSetId() != null) {
                jSONObject15.put("android_app_set_id", this.deviceInfo.getAppSetId());
            }
            jSONObject15.put("limit_ad_tracking", this.deviceInfo.isLimitAdTrackingEnabled());
            jSONObject15.put("gps_enabled", this.deviceInfo.isGooglePlayServicesEnabled());
            jSONObject13.put("api_properties", jSONObject15);
            if (jSONObject9 == null) {
                jSONObject6 = new JSONObject();
            } else {
                jSONObject6 = truncate(jSONObject9);
            }
            jSONObject13.put("event_properties", jSONObject6);
            if (jSONObject10 == null) {
                jSONObject7 = new JSONObject();
            } else {
                jSONObject7 = truncate(jSONObject10);
            }
            jSONObject13.put("user_properties", jSONObject7);
            jSONObject13.put("groups", jSONObject11 == null ? new JSONObject() : truncate(jSONObject11));
            if (jSONObject12 == null) {
                jSONObject8 = new JSONObject();
            } else {
                jSONObject8 = truncate(jSONObject12);
            }
            jSONObject13.put("group_properties", jSONObject8);
            j3 = saveEvent(str2, jSONObject13, middlewareExtra);
            if (str2.equals(Constants.IDENTIFY_EVENT) && jSONObject10 != null) {
                this.connector.getIdentityStore().editIdentity().updateUserProperties(JSONUtil.toUpdateUserPropertiesMap(jSONObject3)).commit();
            }
        } catch (JSONException e) {
            logger.e(TAG, String.format("JSON Serialization of event type %s failed, skipping: %s", new Object[]{str2, e.toString()}));
        }
        return j3;
    }

    /* access modifiers changed from: protected */
    public long saveEvent(String str, JSONObject jSONObject, MiddlewareExtra middlewareExtra) {
        if (!this.middlewareRunner.run(new MiddlewarePayload(jSONObject, middlewareExtra))) {
            return -1;
        }
        if (Utils.isEmptyString(jSONObject.toString())) {
            logger.e(TAG, String.format("Detected empty event string for event type %s, skipping", new Object[]{str}));
            return -1;
        }
        JSONObject intercept = this.identifyInterceptor.intercept(str, jSONObject);
        if (intercept == null) {
            return -1;
        }
        return saveEvent(str, intercept);
    }

    /* access modifiers changed from: protected */
    public long saveEvent(String str, JSONObject jSONObject) {
        String jSONObject2 = jSONObject.toString();
        if (str.equals(Constants.IDENTIFY_EVENT) || str.equals(Constants.GROUP_IDENTIFY_EVENT)) {
            long addIdentify = this.dbHelper.addIdentify(jSONObject2);
            this.lastIdentifyId = addIdentify;
            setLastIdentifyId(addIdentify);
        } else {
            long addEvent = this.dbHelper.addEvent(jSONObject2);
            this.lastEventId = addEvent;
            setLastEventId(addEvent);
        }
        int min = Math.min(Math.max(1, this.eventMaxCount / 10), 20);
        if (this.dbHelper.getEventCount() > ((long) this.eventMaxCount)) {
            DatabaseHelper databaseHelper = this.dbHelper;
            databaseHelper.removeEvents(databaseHelper.getNthEventId((long) min));
        }
        if (this.dbHelper.getIdentifyCount() > ((long) this.eventMaxCount)) {
            DatabaseHelper databaseHelper2 = this.dbHelper;
            databaseHelper2.removeIdentifys(databaseHelper2.getNthIdentifyId((long) min));
        }
        long totalEventCount = this.dbHelper.getTotalEventCount();
        int i = this.eventUploadThreshold;
        if (totalEventCount % ((long) i) != 0 || totalEventCount < ((long) i)) {
            updateServerLater(this.eventUploadPeriodMillis);
        } else {
            updateServer();
        }
        return (str.equals(Constants.IDENTIFY_EVENT) || str.equals(Constants.GROUP_IDENTIFY_EVENT)) ? this.lastIdentifyId : this.lastEventId;
    }

    private long getLongvalue(String str, long j) {
        Long longValue = this.dbHelper.getLongValue(str);
        return longValue == null ? j : longValue.longValue();
    }

    /* access modifiers changed from: package-private */
    public long getNextSequenceNumber() {
        long j = this.sequenceNumber + 1;
        this.sequenceNumber = j;
        this.dbHelper.insertOrReplaceKeyLongValue(SEQUENCE_NUMBER_KEY, Long.valueOf(j));
        return this.sequenceNumber;
    }

    /* access modifiers changed from: package-private */
    public void setLastEventTime(long j) {
        this.lastEventTime = j;
        this.dbHelper.insertOrReplaceKeyLongValue(LAST_EVENT_TIME_KEY, Long.valueOf(j));
    }

    /* access modifiers changed from: package-private */
    public void setLastEventId(long j) {
        this.lastEventId = j;
        this.dbHelper.insertOrReplaceKeyLongValue(LAST_EVENT_ID_KEY, Long.valueOf(j));
    }

    /* access modifiers changed from: package-private */
    public void setLastIdentifyId(long j) {
        this.lastIdentifyId = j;
        this.dbHelper.insertOrReplaceKeyLongValue(LAST_IDENTIFY_ID_KEY, Long.valueOf(j));
    }

    /* access modifiers changed from: package-private */
    public void setPreviousSessionId(long j) {
        this.previousSessionId = j;
        this.dbHelper.insertOrReplaceKeyLongValue(PREVIOUS_SESSION_ID_KEY, Long.valueOf(j));
    }

    public boolean startNewSessionIfNeeded(long j) {
        if (inSession()) {
            if (isWithinMinTimeBetweenSessions(j)) {
                refreshSessionTime(j);
                return false;
            }
            startNewSession(j);
            return true;
        } else if (isWithinMinTimeBetweenSessions(j)) {
            long j2 = this.previousSessionId;
            if (j2 == -1) {
                startNewSession(j);
                return true;
            }
            setSessionId(j2);
            refreshSessionTime(j);
            return false;
        } else {
            startNewSession(j);
            return true;
        }
    }

    private void startNewSession(long j) {
        if (this.trackingSessionEvents) {
            sendSessionEvent(END_SESSION_EVENT);
        }
        setSessionId(j);
        refreshSessionTime(j);
        if (this.trackingSessionEvents) {
            sendSessionEvent(START_SESSION_EVENT);
        }
    }

    /* access modifiers changed from: private */
    public void setSessionId(long j) {
        this.sessionId = j;
        setPreviousSessionId(j);
    }

    /* access modifiers changed from: package-private */
    public void refreshSessionTime(long j) {
        if (inSession()) {
            setLastEventTime(j);
        }
    }

    /* access modifiers changed from: private */
    public void sendSessionEvent(String str) {
        if (contextAndApiKeySet(String.format("sendSessionEvent('%s')", new Object[]{str})) && inSession()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("special", str);
                logEvent(str, (JSONObject) null, jSONObject, (JSONObject) null, (JSONObject) null, (JSONObject) null, this.lastEventTime, false, false);
            } catch (JSONException unused) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void onExitForeground(final long j) {
        this.isEnteringForeground = false;
        this.inForeground = false;
        runOnLogThread(new Runnable() {
            public void run() {
                if (!Utils.isEmptyString(AmplitudeClient.this.apiKey)) {
                    AmplitudeClient.this.refreshSessionTime(j);
                    if (AmplitudeClient.this.flushEventsOnClose) {
                        AmplitudeClient.this.identifyInterceptor.transferInterceptedIdentify();
                        AmplitudeClient.this.updateServer();
                    }
                    AmplitudeClient.this.dbHelper.insertOrReplaceKeyValue(AmplitudeClient.DEVICE_ID_KEY, AmplitudeClient.this.deviceId);
                    AmplitudeClient.this.dbHelper.insertOrReplaceKeyValue(AmplitudeClient.USER_ID_KEY, AmplitudeClient.this.userId);
                    AmplitudeClient.this.dbHelper.insertOrReplaceKeyLongValue(AmplitudeClient.OPT_OUT_KEY, Long.valueOf(AmplitudeClient.this.optOut ? 1 : 0));
                    AmplitudeClient.this.dbHelper.insertOrReplaceKeyLongValue(AmplitudeClient.PREVIOUS_SESSION_ID_KEY, Long.valueOf(AmplitudeClient.this.sessionId));
                    AmplitudeClient.this.dbHelper.insertOrReplaceKeyLongValue(AmplitudeClient.LAST_EVENT_TIME_KEY, Long.valueOf(AmplitudeClient.this.lastEventTime));
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void onEnterForeground(final long j) {
        this.isEnteringForeground = true;
        this.inForeground = true;
        runOnLogThread(new Runnable() {
            public void run() {
                if (!Utils.isEmptyString(AmplitudeClient.this.apiKey)) {
                    if (AmplitudeClient.this.useDynamicConfig) {
                        ConfigManager.getInstance().refresh(new ConfigManager.RefreshListener() {
                            public void onFinished() {
                                AmplitudeClient.this.url = ConfigManager.getInstance().getIngestionEndpoint();
                            }
                        }, AmplitudeClient.this.serverZone);
                    }
                    if (AmplitudeClient.this.isEnteringForeground) {
                        AmplitudeClient.this.startNewSessionIfNeeded(j);
                    }
                    boolean unused = AmplitudeClient.this.isEnteringForeground = false;
                }
            }
        });
    }

    public void logRevenue(double d) {
        logRevenue((String) null, 1, d);
    }

    public void logRevenue(String str, int i, double d) {
        logRevenue(str, i, d, (String) null, (String) null);
    }

    public void logRevenue(String str, int i, double d, String str2, String str3) {
        logRevenue(str, i, d, str2, str3, (MiddlewareExtra) null);
    }

    public void logRevenue(String str, int i, double d, String str2, String str3, MiddlewareExtra middlewareExtra) {
        if (contextAndApiKeySet("logRevenue()")) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("special", Constants.AMP_REVENUE_EVENT);
                String str4 = str;
                jSONObject.put("productId", str);
                int i2 = i;
                jSONObject.put("quantity", i);
                jSONObject.put(b.x, d);
                jSONObject.put(b.D, str2);
                jSONObject.put("receiptSig", str3);
            } catch (JSONException unused) {
            }
            logEventAsync(Constants.AMP_REVENUE_EVENT, (JSONObject) null, jSONObject, (JSONObject) null, (JSONObject) null, (JSONObject) null, getCurrentTimeMillis(), false, middlewareExtra);
        }
    }

    public void logRevenueV2(Revenue revenue) {
        logRevenueV2(revenue, (MiddlewareExtra) null);
    }

    public void logRevenueV2(Revenue revenue, MiddlewareExtra middlewareExtra) {
        if (contextAndApiKeySet("logRevenueV2()") && revenue != null && revenue.isValidRevenue()) {
            logEvent(Constants.AMP_REVENUE_EVENT, revenue.toJSONObject(), (JSONObject) null, (JSONObject) null, (JSONObject) null, (JSONObject) null, getCurrentTimeMillis(), false, middlewareExtra, this.inForeground);
        }
    }

    public void setUserProperties(JSONObject jSONObject, boolean z) {
        setUserProperties(jSONObject);
    }

    public void setUserProperties(JSONObject jSONObject) {
        setUserProperties(jSONObject, (MiddlewareExtra) null);
    }

    public void setUserProperties(JSONObject jSONObject, MiddlewareExtra middlewareExtra) {
        Identify convertPropertiesToIdentify;
        if (jSONObject != null && jSONObject.length() != 0 && contextAndApiKeySet("setUserProperties") && (convertPropertiesToIdentify = convertPropertiesToIdentify(jSONObject)) != null) {
            identify(convertPropertiesToIdentify, false, middlewareExtra);
        }
    }

    private Identify convertPropertiesToIdentify(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        JSONObject truncate = truncate(jSONObject);
        if (truncate.length() == 0) {
            return null;
        }
        Identify identify = new Identify();
        Iterator<String> keys = truncate.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                identify.setUserProperty(next, truncate.get(next));
            } catch (JSONException e) {
                logger.e(TAG, e.toString());
            }
        }
        return identify;
    }

    public void clearUserProperties() {
        identify(new Identify().clearAll());
    }

    public void identify(Identify identify) {
        identify(identify, false);
    }

    public void identify(Identify identify, boolean z) {
        identify(identify, z, (MiddlewareExtra) null);
    }

    public void identify(Identify identify, boolean z, MiddlewareExtra middlewareExtra) {
        if (identify != null && identify.userPropertiesOperations.length() != 0 && contextAndApiKeySet("identify()")) {
            logEventAsync(Constants.IDENTIFY_EVENT, (JSONObject) null, (JSONObject) null, identify.userPropertiesOperations, (JSONObject) null, (JSONObject) null, getCurrentTimeMillis(), z, middlewareExtra);
        }
    }

    public void setGroup(String str, Object obj) {
        setGroup(str, obj, (MiddlewareExtra) null);
    }

    public void setGroup(String str, Object obj, MiddlewareExtra middlewareExtra) {
        JSONObject jSONObject;
        if (contextAndApiKeySet("setGroup()") && !Utils.isEmptyString(str)) {
            try {
                jSONObject = new JSONObject().put(str, obj);
            } catch (JSONException e) {
                logger.e(TAG, e.toString());
                jSONObject = null;
            }
            logEventAsync(Constants.IDENTIFY_EVENT, (JSONObject) null, (JSONObject) null, new Identify().setUserProperty(str, obj).userPropertiesOperations, jSONObject, (JSONObject) null, getCurrentTimeMillis(), false, middlewareExtra);
        }
    }

    public void groupIdentify(String str, Object obj, Identify identify) {
        groupIdentify(str, obj, identify, false);
    }

    public void groupIdentify(String str, Object obj, Identify identify, boolean z) {
        groupIdentify(str, obj, identify, z, (MiddlewareExtra) null);
    }

    public void groupIdentify(String str, Object obj, JSONObject jSONObject, boolean z, MiddlewareExtra middlewareExtra) {
        Identify convertPropertiesToIdentify = convertPropertiesToIdentify(jSONObject);
        if (convertPropertiesToIdentify != null) {
            groupIdentify(str, obj, convertPropertiesToIdentify, z, middlewareExtra);
        }
    }

    public void groupIdentify(String str, Object obj, Identify identify, boolean z, MiddlewareExtra middlewareExtra) {
        JSONObject jSONObject;
        Identify identify2 = identify;
        if (identify2 == null || identify2.userPropertiesOperations.length() == 0) {
            return;
        }
        if (contextAndApiKeySet("groupIdentify()") && !Utils.isEmptyString(str)) {
            try {
                String str2 = str;
                Object obj2 = obj;
                jSONObject = new JSONObject().put(str, obj);
            } catch (JSONException e) {
                logger.e(TAG, e.toString());
                jSONObject = null;
            }
            logEventAsync(Constants.GROUP_IDENTIFY_EVENT, (JSONObject) null, (JSONObject) null, (JSONObject) null, jSONObject, identify2.userPropertiesOperations, getCurrentTimeMillis(), z, middlewareExtra);
        }
    }

    public JSONObject truncate(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new JSONObject();
        }
        if (jSONObject.length() > 1000) {
            logger.w(TAG, "Warning: too many properties (more than 1000), ignoring");
            return new JSONObject();
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                Object obj = jSONObject.get(next);
                if (!next.equals(Constants.AMP_REVENUE_RECEIPT)) {
                    if (!next.equals(Constants.AMP_REVENUE_RECEIPT_SIG)) {
                        if (obj.getClass().equals(String.class)) {
                            jSONObject.put(next, truncate((String) obj));
                        } else if (obj.getClass().equals(JSONObject.class)) {
                            jSONObject.put(next, truncate((JSONObject) obj));
                        } else if (obj.getClass().equals(JSONArray.class)) {
                            jSONObject.put(next, truncate((JSONArray) obj));
                        }
                    }
                }
                jSONObject.put(next, obj);
            } catch (JSONException e) {
                logger.e(TAG, e.toString());
            }
        }
        return jSONObject;
    }

    public JSONArray truncate(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null) {
            return new JSONArray();
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            Object obj = jSONArray.get(i);
            if (obj.getClass().equals(String.class)) {
                jSONArray.put(i, truncate((String) obj));
            } else if (obj.getClass().equals(JSONObject.class)) {
                jSONArray.put(i, truncate((JSONObject) obj));
            } else if (obj.getClass().equals(JSONArray.class)) {
                jSONArray.put(i, truncate((JSONArray) obj));
            }
        }
        return jSONArray;
    }

    public static String truncate(String str) {
        return str.length() <= 1024 ? str : str.substring(0, 1024);
    }

    public AmplitudeClient setUserId(String str) {
        return setUserId(str, false);
    }

    public AmplitudeClient setUserId(final String str, final boolean z) {
        if (!contextAndApiKeySet("setUserId()")) {
            return this;
        }
        runOnLogThread(new Runnable() {
            public void run() {
                if (!Utils.isEmptyString(this.apiKey)) {
                    if (z && AmplitudeClient.this.trackingSessionEvents) {
                        AmplitudeClient.this.sendSessionEvent(AmplitudeClient.END_SESSION_EVENT);
                    }
                    this.userId = str;
                    AmplitudeClient.this.dbHelper.insertOrReplaceKeyValue(AmplitudeClient.USER_ID_KEY, str);
                    if (z) {
                        long currentTimeMillis = AmplitudeClient.this.getCurrentTimeMillis();
                        AmplitudeClient.this.setSessionId(currentTimeMillis);
                        AmplitudeClient.this.refreshSessionTime(currentTimeMillis);
                        if (AmplitudeClient.this.trackingSessionEvents) {
                            AmplitudeClient.this.sendSessionEvent(AmplitudeClient.START_SESSION_EVENT);
                        }
                    }
                    this.connector.getIdentityStore().editIdentity().setUserId(str).commit();
                }
            }
        });
        return this;
    }

    public AmplitudeClient setDeviceId(final String str) {
        Set<String> invalidDeviceIds = getInvalidDeviceIds();
        if (contextAndApiKeySet("setDeviceId()") && !Utils.isEmptyString(str) && !invalidDeviceIds.contains(str)) {
            runOnLogThread(new Runnable() {
                public void run() {
                    if (!Utils.isEmptyString(this.apiKey)) {
                        this.deviceId = str;
                        AmplitudeClient.this.saveDeviceId(str);
                        this.connector.getIdentityStore().editIdentity().setDeviceId(str).commit();
                    }
                }
            });
        }
        return this;
    }

    public AmplitudeClient regenerateDeviceId() {
        if (!contextAndApiKeySet("regenerateDeviceId()")) {
            return this;
        }
        runOnLogThread(new Runnable() {
            public void run() {
                if (!Utils.isEmptyString(this.apiKey)) {
                    AmplitudeClient.this.setDeviceId(DeviceInfo.generateUUID() + "R");
                }
            }
        });
        return this;
    }

    public void uploadEvents() {
        if (contextAndApiKeySet("uploadEvents()")) {
            this.logThread.post(new Runnable() {
                public void run() {
                    if (!Utils.isEmptyString(AmplitudeClient.this.apiKey)) {
                        AmplitudeClient.this.identifyInterceptor.transferInterceptedIdentify();
                        AmplitudeClient.this.updateServer();
                    }
                }
            });
        }
    }

    private void updateServerLater(long j) {
        if (!this.updateScheduled.getAndSet(true)) {
            this.logThread.postDelayed(new Runnable() {
                public void run() {
                    AmplitudeClient.this.updateScheduled.set(false);
                    AmplitudeClient.this.updateServer();
                }
            }, j);
        }
    }

    /* access modifiers changed from: protected */
    public void updateServer() {
        updateServer(false);
    }

    /* access modifiers changed from: protected */
    public void updateServer(boolean z) {
        if (!this.optOut && !this.offline && !this.uploadingCurrently.getAndSet(true)) {
            long min = Math.min((long) (z ? this.backoffUploadBatchSize : this.eventUploadMaxBatchSize), this.dbHelper.getTotalEventCount());
            if (min <= 0) {
                this.uploadingCurrently.set(false);
                return;
            }
            try {
                Pair<Pair<Long, Long>, JSONArray> mergeEventsAndIdentifys = mergeEventsAndIdentifys(this.dbHelper.getEvents(this.lastEventId, min), this.dbHelper.getIdentifys(this.lastIdentifyId, min), min);
                if (((JSONArray) mergeEventsAndIdentifys.second).length() == 0) {
                    this.uploadingCurrently.set(false);
                    return;
                }
                final long longValue = ((Long) ((Pair) mergeEventsAndIdentifys.first).first).longValue();
                final long longValue2 = ((Long) ((Pair) mergeEventsAndIdentifys.first).second).longValue();
                final String jSONArray = ((JSONArray) mergeEventsAndIdentifys.second).toString();
                this.httpThread.post(new Runnable() {
                    public void run() {
                        AmplitudeClient amplitudeClient = AmplitudeClient.this;
                        amplitudeClient.makeEventUploadPostRequest(amplitudeClient.callFactory, jSONArray, longValue, longValue2);
                    }
                });
            } catch (JSONException e) {
                this.uploadingCurrently.set(false);
                logger.e(TAG, e.toString());
            } catch (CursorWindowAllocationException e2) {
                this.uploadingCurrently.set(false);
                logger.e(TAG, String.format("Caught Cursor window exception during event upload, deferring upload: %s", new Object[]{e2.getMessage()}));
            }
        }
    }

    /* access modifiers changed from: protected */
    public Pair<Pair<Long, Long>, JSONArray> mergeEventsAndIdentifys(List<JSONObject> list, List<JSONObject> list2, long j) throws JSONException {
        long j2;
        long j3;
        JSONArray jSONArray = new JSONArray();
        long j4 = -1;
        long j5 = -1;
        while (true) {
            if (((long) jSONArray.length()) >= j) {
                break;
            }
            boolean isEmpty = list.isEmpty();
            boolean isEmpty2 = list2.isEmpty();
            if (isEmpty && isEmpty2) {
                logger.w(TAG, String.format("mergeEventsAndIdentifys: number of events and identifys less than expected by %d", new Object[]{Long.valueOf(j - ((long) jSONArray.length()))}));
                break;
            }
            if (isEmpty2) {
                JSONObject remove = list.remove(0);
                j2 = remove.getLong("event_id");
                jSONArray.put(remove);
            } else {
                if (isEmpty) {
                    JSONObject remove2 = list2.remove(0);
                    j3 = remove2.getLong("event_id");
                    jSONArray.put(remove2);
                } else if (!list.get(0).has(SEQUENCE_NUMBER_KEY) || list.get(0).getLong(SEQUENCE_NUMBER_KEY) < list2.get(0).getLong(SEQUENCE_NUMBER_KEY)) {
                    JSONObject remove3 = list.remove(0);
                    j2 = remove3.getLong("event_id");
                    jSONArray.put(remove3);
                } else {
                    JSONObject remove4 = list2.remove(0);
                    j3 = remove4.getLong("event_id");
                    jSONArray.put(remove4);
                }
                j5 = j3;
            }
            j4 = j2;
        }
        return new Pair<>(new Pair(Long.valueOf(j4), Long.valueOf(j5)), jSONArray);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void makeEventUploadPostRequest(okhttp3.Call.Factory r14, java.lang.String r15, long r16, long r18) {
        /*
            r13 = this;
            r7 = r13
            r3 = r16
            r5 = r18
            java.lang.String r8 = "Exception:"
            java.lang.String r0 = "Upload failed, "
            java.lang.String r1 = "Bearer "
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r9 = ""
            r2.<init>(r9)
            long r9 = r13.getCurrentTimeMillis()
            r2.append(r9)
            java.lang.String r2 = r2.toString()
            okhttp3.FormBody$Builder r9 = new okhttp3.FormBody$Builder
            r9.<init>()
            java.lang.String r10 = "v"
            java.lang.String r11 = "2"
            okhttp3.FormBody$Builder r9 = r9.add(r10, r11)
            java.lang.String r10 = "client"
            java.lang.String r11 = r7.apiKey
            okhttp3.FormBody$Builder r9 = r9.add(r10, r11)
            java.lang.String r10 = "e"
            r11 = r15
            okhttp3.FormBody$Builder r9 = r9.add(r10, r15)
            java.lang.String r10 = "upload_time"
            okhttp3.FormBody$Builder r2 = r9.add(r10, r2)
            okhttp3.FormBody r2 = r2.build()
            r9 = 0
            okhttp3.Request$Builder r10 = new okhttp3.Request$Builder     // Catch:{ IllegalArgumentException -> 0x0187 }
            r10.<init>()     // Catch:{ IllegalArgumentException -> 0x0187 }
            java.lang.String r11 = r7.url     // Catch:{ IllegalArgumentException -> 0x0187 }
            okhttp3.Request$Builder r10 = r10.url((java.lang.String) r11)     // Catch:{ IllegalArgumentException -> 0x0187 }
            okhttp3.Request$Builder r2 = r10.post(r2)     // Catch:{ IllegalArgumentException -> 0x0187 }
            java.lang.String r10 = r7.bearerToken     // Catch:{ IllegalArgumentException -> 0x0187 }
            boolean r10 = com.amplitude.api.Utils.isEmptyString(r10)     // Catch:{ IllegalArgumentException -> 0x0187 }
            if (r10 != 0) goto L_0x0070
            java.lang.String r10 = "Authorization"
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ IllegalArgumentException -> 0x0187 }
            r11.<init>(r1)     // Catch:{ IllegalArgumentException -> 0x0187 }
            java.lang.String r1 = r7.bearerToken     // Catch:{ IllegalArgumentException -> 0x0187 }
            r11.append(r1)     // Catch:{ IllegalArgumentException -> 0x0187 }
            java.lang.String r1 = r11.toString()     // Catch:{ IllegalArgumentException -> 0x0187 }
            r2.addHeader(r10, r1)     // Catch:{ IllegalArgumentException -> 0x0187 }
        L_0x0070:
            okhttp3.Request r1 = r2.build()     // Catch:{ IllegalArgumentException -> 0x0187 }
            r2 = r14
            okhttp3.Call r1 = r14.newCall(r1)     // Catch:{ ConnectException -> 0x017b, UnknownHostException -> 0x0176, IOException -> 0x0166, AssertionError -> 0x015a, Exception -> 0x014e }
            okhttp3.Response r1 = r1.execute()     // Catch:{ ConnectException -> 0x017b, UnknownHostException -> 0x0176, IOException -> 0x0166, AssertionError -> 0x015a, Exception -> 0x014e }
            okhttp3.ResponseBody r2 = r1.body()     // Catch:{ ConnectException -> 0x017b, UnknownHostException -> 0x0176, IOException -> 0x0166, AssertionError -> 0x015a, Exception -> 0x014e }
            java.lang.String r2 = r2.string()     // Catch:{ ConnectException -> 0x017b, UnknownHostException -> 0x0176, IOException -> 0x0166, AssertionError -> 0x015a, Exception -> 0x014e }
            int r10 = r1.code()     // Catch:{ ConnectException -> 0x017b, UnknownHostException -> 0x0176, IOException -> 0x0166, AssertionError -> 0x015a, Exception -> 0x014e }
            r11 = 200(0xc8, float:2.8E-43)
            r12 = 1
            if (r10 != r11) goto L_0x00af
            com.amplitude.api.WorkerThread r0 = r7.logThread     // Catch:{ ConnectException -> 0x00ac, UnknownHostException -> 0x00a9, IOException -> 0x00a6, AssertionError -> 0x00a3, Exception -> 0x00a0 }
            com.amplitude.api.AmplitudeClient$13 r10 = new com.amplitude.api.AmplitudeClient$13     // Catch:{ ConnectException -> 0x00ac, UnknownHostException -> 0x00a9, IOException -> 0x00a6, AssertionError -> 0x00a3, Exception -> 0x00a0 }
            r1 = r10
            r2 = r13
            r3 = r16
            r5 = r18
            r1.<init>(r3, r5)     // Catch:{ ConnectException -> 0x00ac, UnknownHostException -> 0x00a9, IOException -> 0x00a6, AssertionError -> 0x00a3, Exception -> 0x00a0 }
            r0.post(r10)     // Catch:{ ConnectException -> 0x00ac, UnknownHostException -> 0x00a9, IOException -> 0x00a6, AssertionError -> 0x00a3, Exception -> 0x00a0 }
            goto L_0x0186
        L_0x00a0:
            r0 = move-exception
            goto L_0x0150
        L_0x00a3:
            r0 = move-exception
            goto L_0x015c
        L_0x00a6:
            r0 = move-exception
            goto L_0x0168
        L_0x00a9:
            r0 = move-exception
            goto L_0x0178
        L_0x00ac:
            r0 = move-exception
            goto L_0x017d
        L_0x00af:
            int r10 = r1.code()     // Catch:{ ConnectException -> 0x017b, UnknownHostException -> 0x0176, IOException -> 0x0166, AssertionError -> 0x015a, Exception -> 0x014e }
            r11 = 400(0x190, float:5.6E-43)
            if (r10 != r11) goto L_0x00ca
            java.lang.String r10 = "invalid_api_key"
            boolean r10 = r2.equals(r10)     // Catch:{ ConnectException -> 0x017b, UnknownHostException -> 0x0176, IOException -> 0x0166, AssertionError -> 0x015a, Exception -> 0x014e }
            if (r10 == 0) goto L_0x00ca
            com.amplitude.api.AmplitudeLog r0 = logger     // Catch:{ ConnectException -> 0x017b, UnknownHostException -> 0x0176, IOException -> 0x0166, AssertionError -> 0x015a, Exception -> 0x014e }
            java.lang.String r1 = TAG     // Catch:{ ConnectException -> 0x017b, UnknownHostException -> 0x0176, IOException -> 0x0166, AssertionError -> 0x015a, Exception -> 0x014e }
            java.lang.String r2 = "Invalid API key, make sure your API key is correct in initialize()"
            r0.e(r1, r2)     // Catch:{ ConnectException -> 0x017b, UnknownHostException -> 0x0176, IOException -> 0x0166, AssertionError -> 0x015a, Exception -> 0x014e }
            goto L_0x0181
        L_0x00ca:
            int r10 = r1.code()     // Catch:{ ConnectException -> 0x017b, UnknownHostException -> 0x0176, IOException -> 0x0166, AssertionError -> 0x015a, Exception -> 0x014e }
            if (r10 != r11) goto L_0x00e3
            java.lang.String r10 = "bad_checksum"
            boolean r10 = r2.equals(r10)     // Catch:{ ConnectException -> 0x017b, UnknownHostException -> 0x0176, IOException -> 0x0166, AssertionError -> 0x015a, Exception -> 0x014e }
            if (r10 == 0) goto L_0x00e3
            com.amplitude.api.AmplitudeLog r0 = logger     // Catch:{ ConnectException -> 0x017b, UnknownHostException -> 0x0176, IOException -> 0x0166, AssertionError -> 0x015a, Exception -> 0x014e }
            java.lang.String r1 = TAG     // Catch:{ ConnectException -> 0x017b, UnknownHostException -> 0x0176, IOException -> 0x0166, AssertionError -> 0x015a, Exception -> 0x014e }
            java.lang.String r2 = "Bad checksum, post request was mangled in transit, will attempt to reupload later"
            r0.w((java.lang.String) r1, (java.lang.String) r2)     // Catch:{ ConnectException -> 0x017b, UnknownHostException -> 0x0176, IOException -> 0x0166, AssertionError -> 0x015a, Exception -> 0x014e }
            goto L_0x0181
        L_0x00e3:
            int r1 = r1.code()     // Catch:{ ConnectException -> 0x017b, UnknownHostException -> 0x0176, IOException -> 0x0166, AssertionError -> 0x015a, Exception -> 0x014e }
            r10 = 413(0x19d, float:5.79E-43)
            if (r1 != r10) goto L_0x0135
            boolean r0 = r7.backoffUpload     // Catch:{ ConnectException -> 0x017b, UnknownHostException -> 0x0176, IOException -> 0x0166, AssertionError -> 0x015a, Exception -> 0x014e }
            if (r0 == 0) goto L_0x0107
            int r0 = r7.backoffUploadBatchSize     // Catch:{ ConnectException -> 0x017b, UnknownHostException -> 0x0176, IOException -> 0x0166, AssertionError -> 0x015a, Exception -> 0x014e }
            if (r0 != r12) goto L_0x0107
            r0 = 0
            int r2 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r2 < 0) goto L_0x00fe
            com.amplitude.api.DatabaseHelper r2 = r7.dbHelper     // Catch:{ ConnectException -> 0x017b, UnknownHostException -> 0x0176, IOException -> 0x0166, AssertionError -> 0x015a, Exception -> 0x014e }
            r2.removeEvent(r3)     // Catch:{ ConnectException -> 0x017b, UnknownHostException -> 0x0176, IOException -> 0x0166, AssertionError -> 0x015a, Exception -> 0x014e }
        L_0x00fe:
            int r0 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r0 < 0) goto L_0x0107
            com.amplitude.api.DatabaseHelper r0 = r7.dbHelper     // Catch:{ ConnectException -> 0x017b, UnknownHostException -> 0x0176, IOException -> 0x0166, AssertionError -> 0x015a, Exception -> 0x014e }
            r0.removeIdentify(r5)     // Catch:{ ConnectException -> 0x017b, UnknownHostException -> 0x0176, IOException -> 0x0166, AssertionError -> 0x015a, Exception -> 0x014e }
        L_0x0107:
            r7.backoffUpload = r12     // Catch:{ ConnectException -> 0x017b, UnknownHostException -> 0x0176, IOException -> 0x0166, AssertionError -> 0x015a, Exception -> 0x014e }
            com.amplitude.api.DatabaseHelper r0 = r7.dbHelper     // Catch:{ ConnectException -> 0x017b, UnknownHostException -> 0x0176, IOException -> 0x0166, AssertionError -> 0x015a, Exception -> 0x014e }
            long r0 = r0.getEventCount()     // Catch:{ ConnectException -> 0x017b, UnknownHostException -> 0x0176, IOException -> 0x0166, AssertionError -> 0x015a, Exception -> 0x014e }
            int r0 = (int) r0     // Catch:{ ConnectException -> 0x017b, UnknownHostException -> 0x0176, IOException -> 0x0166, AssertionError -> 0x015a, Exception -> 0x014e }
            int r1 = r7.backoffUploadBatchSize     // Catch:{ ConnectException -> 0x017b, UnknownHostException -> 0x0176, IOException -> 0x0166, AssertionError -> 0x015a, Exception -> 0x014e }
            int r0 = java.lang.Math.min(r0, r1)     // Catch:{ ConnectException -> 0x017b, UnknownHostException -> 0x0176, IOException -> 0x0166, AssertionError -> 0x015a, Exception -> 0x014e }
            double r0 = (double) r0     // Catch:{ ConnectException -> 0x017b, UnknownHostException -> 0x0176, IOException -> 0x0166, AssertionError -> 0x015a, Exception -> 0x014e }
            r2 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r0 = r0 / r2
            double r0 = java.lang.Math.ceil(r0)     // Catch:{ ConnectException -> 0x017b, UnknownHostException -> 0x0176, IOException -> 0x0166, AssertionError -> 0x015a, Exception -> 0x014e }
            int r0 = (int) r0     // Catch:{ ConnectException -> 0x017b, UnknownHostException -> 0x0176, IOException -> 0x0166, AssertionError -> 0x015a, Exception -> 0x014e }
            r7.backoffUploadBatchSize = r0     // Catch:{ ConnectException -> 0x017b, UnknownHostException -> 0x0176, IOException -> 0x0166, AssertionError -> 0x015a, Exception -> 0x014e }
            com.amplitude.api.AmplitudeLog r0 = logger     // Catch:{ ConnectException -> 0x017b, UnknownHostException -> 0x0176, IOException -> 0x0166, AssertionError -> 0x015a, Exception -> 0x014e }
            java.lang.String r1 = TAG     // Catch:{ ConnectException -> 0x017b, UnknownHostException -> 0x0176, IOException -> 0x0166, AssertionError -> 0x015a, Exception -> 0x014e }
            java.lang.String r2 = "Request too large, will decrease size and attempt to reupload"
            r0.w((java.lang.String) r1, (java.lang.String) r2)     // Catch:{ ConnectException -> 0x017b, UnknownHostException -> 0x0176, IOException -> 0x0166, AssertionError -> 0x015a, Exception -> 0x014e }
            com.amplitude.api.WorkerThread r0 = r7.logThread     // Catch:{ ConnectException -> 0x017b, UnknownHostException -> 0x0176, IOException -> 0x0166, AssertionError -> 0x015a, Exception -> 0x014e }
            com.amplitude.api.AmplitudeClient$14 r1 = new com.amplitude.api.AmplitudeClient$14     // Catch:{ ConnectException -> 0x017b, UnknownHostException -> 0x0176, IOException -> 0x0166, AssertionError -> 0x015a, Exception -> 0x014e }
            r1.<init>()     // Catch:{ ConnectException -> 0x017b, UnknownHostException -> 0x0176, IOException -> 0x0166, AssertionError -> 0x015a, Exception -> 0x014e }
            r0.post(r1)     // Catch:{ ConnectException -> 0x017b, UnknownHostException -> 0x0176, IOException -> 0x0166, AssertionError -> 0x015a, Exception -> 0x014e }
            goto L_0x0181
        L_0x0135:
            com.amplitude.api.AmplitudeLog r1 = logger     // Catch:{ ConnectException -> 0x017b, UnknownHostException -> 0x0176, IOException -> 0x0166, AssertionError -> 0x015a, Exception -> 0x014e }
            java.lang.String r3 = TAG     // Catch:{ ConnectException -> 0x017b, UnknownHostException -> 0x0176, IOException -> 0x0166, AssertionError -> 0x015a, Exception -> 0x014e }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ ConnectException -> 0x017b, UnknownHostException -> 0x0176, IOException -> 0x0166, AssertionError -> 0x015a, Exception -> 0x014e }
            r4.<init>(r0)     // Catch:{ ConnectException -> 0x017b, UnknownHostException -> 0x0176, IOException -> 0x0166, AssertionError -> 0x015a, Exception -> 0x014e }
            r4.append(r2)     // Catch:{ ConnectException -> 0x017b, UnknownHostException -> 0x0176, IOException -> 0x0166, AssertionError -> 0x015a, Exception -> 0x014e }
            java.lang.String r0 = ", will attempt to reupload later"
            r4.append(r0)     // Catch:{ ConnectException -> 0x017b, UnknownHostException -> 0x0176, IOException -> 0x0166, AssertionError -> 0x015a, Exception -> 0x014e }
            java.lang.String r0 = r4.toString()     // Catch:{ ConnectException -> 0x017b, UnknownHostException -> 0x0176, IOException -> 0x0166, AssertionError -> 0x015a, Exception -> 0x014e }
            r1.w((java.lang.String) r3, (java.lang.String) r0)     // Catch:{ ConnectException -> 0x017b, UnknownHostException -> 0x0176, IOException -> 0x0166, AssertionError -> 0x015a, Exception -> 0x014e }
            goto L_0x0181
        L_0x014e:
            r0 = move-exception
            r12 = r9
        L_0x0150:
            com.amplitude.api.AmplitudeLog r1 = logger
            java.lang.String r2 = TAG
            r1.e(r2, r8, r0)
            r7.lastError = r0
            goto L_0x017f
        L_0x015a:
            r0 = move-exception
            r12 = r9
        L_0x015c:
            com.amplitude.api.AmplitudeLog r1 = logger
            java.lang.String r2 = TAG
            r1.e(r2, r8, r0)
            r7.lastError = r0
            goto L_0x017f
        L_0x0166:
            r0 = move-exception
            r12 = r9
        L_0x0168:
            com.amplitude.api.AmplitudeLog r1 = logger
            java.lang.String r2 = TAG
            java.lang.String r3 = r0.toString()
            r1.e(r2, r3)
            r7.lastError = r0
            goto L_0x017f
        L_0x0176:
            r0 = move-exception
            r12 = r9
        L_0x0178:
            r7.lastError = r0
            goto L_0x017f
        L_0x017b:
            r0 = move-exception
            r12 = r9
        L_0x017d:
            r7.lastError = r0
        L_0x017f:
            if (r12 != 0) goto L_0x0186
        L_0x0181:
            java.util.concurrent.atomic.AtomicBoolean r0 = r7.uploadingCurrently
            r0.set(r9)
        L_0x0186:
            return
        L_0x0187:
            r0 = move-exception
            com.amplitude.api.AmplitudeLog r1 = logger
            java.lang.String r2 = TAG
            java.lang.String r0 = r0.toString()
            r1.e(r2, r0)
            java.util.concurrent.atomic.AtomicBoolean r0 = r7.uploadingCurrently
            r0.set(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplitude.api.AmplitudeClient.makeEventUploadPostRequest(okhttp3.Call$Factory, java.lang.String, long, long):void");
    }

    /* access modifiers changed from: protected */
    public DeviceInfo initializeDeviceInfo() {
        return new DeviceInfo(this.context, this.locationListening, this.appliedTrackingOptions.shouldTrackAdid());
    }

    private Set<String> getInvalidDeviceIds() {
        HashSet hashSet = new HashSet();
        hashSet.add("");
        hashSet.add("9774d56d682e549c");
        hashSet.add(EnvironmentCompat.MEDIA_UNKNOWN);
        hashSet.add("000000000000000");
        hashSet.add(Constants.PLATFORM);
        hashSet.add("DEFACE");
        hashSet.add("00000000-0000-0000-0000-000000000000");
        return hashSet;
    }

    private String initializeDeviceId() {
        Set<String> invalidDeviceIds = getInvalidDeviceIds();
        String value = this.dbHelper.getValue(DEVICE_ID_KEY);
        if (!Utils.isEmptyString(value) && !invalidDeviceIds.contains(value) && !value.endsWith(ExifInterface.LATITUDE_SOUTH)) {
            return value;
        }
        if (!this.newDeviceIdPerInstall && this.useAdvertisingIdForDeviceId && !this.deviceInfo.isLimitAdTrackingEnabled()) {
            String advertisingId = this.deviceInfo.getAdvertisingId();
            if (!Utils.isEmptyString(advertisingId) && !invalidDeviceIds.contains(advertisingId)) {
                saveDeviceId(advertisingId);
                return advertisingId;
            }
        }
        if (this.useAppSetIdForDeviceId) {
            String appSetId = this.deviceInfo.getAppSetId();
            if (!Utils.isEmptyString(appSetId) && !invalidDeviceIds.contains(appSetId)) {
                String str = appSetId + ExifInterface.LATITUDE_SOUTH;
                saveDeviceId(str);
                return str;
            }
        }
        String str2 = DeviceInfo.generateUUID() + "R";
        saveDeviceId(str2);
        return str2;
    }

    /* access modifiers changed from: private */
    public void saveDeviceId(String str) {
        this.dbHelper.insertOrReplaceKeyValue(DEVICE_ID_KEY, str);
    }

    /* access modifiers changed from: protected */
    public void runOnLogThread(Runnable runnable) {
        Thread currentThread = Thread.currentThread();
        WorkerThread workerThread = this.logThread;
        if (currentThread != workerThread) {
            workerThread.post(runnable);
        } else {
            runnable.run();
        }
    }

    /* access modifiers changed from: protected */
    public Object replaceWithJSONNull(Object obj) {
        return obj == null ? JSONObject.NULL : obj;
    }

    /* access modifiers changed from: protected */
    public synchronized boolean contextAndApiKeySet(String str) {
        if (this.context == null) {
            AmplitudeLog amplitudeLog = logger;
            String str2 = TAG;
            amplitudeLog.e(str2, "context cannot be null, set context with initialize() before calling " + str);
            return false;
        } else if (!Utils.isEmptyString(this.apiKey)) {
            return true;
        } else {
            AmplitudeLog amplitudeLog2 = logger;
            String str3 = TAG;
            amplitudeLog2.e(str3, "apiKey cannot be null or empty, set apiKey with initialize() before calling " + str);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public String bytesToHexString(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i];
            int i2 = i * 2;
            cArr2[i2] = cArr[(b & 255) >>> 4];
            cArr2[i2 + 1] = cArr[b & Ascii.SI];
        }
        return new String(cArr2);
    }

    /* access modifiers changed from: protected */
    public long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }

    public AmplitudeClient setServerZone(AmplitudeServerZone amplitudeServerZone) {
        return setServerZone(amplitudeServerZone, true);
    }

    public AmplitudeClient setServerZone(AmplitudeServerZone amplitudeServerZone, boolean z) {
        if (amplitudeServerZone == null) {
            return null;
        }
        this.serverZone = amplitudeServerZone;
        if (z) {
            setServerUrl(AmplitudeServerZone.getEventLogApiForZone(amplitudeServerZone));
        }
        return this;
    }
}
