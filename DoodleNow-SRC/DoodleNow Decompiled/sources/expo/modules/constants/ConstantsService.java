package expo.modules.constants;

import android.content.Context;
import android.os.Build;
import com.amplitude.api.Constants;
import com.amplitude.api.DeviceInfo;
import com.google.android.exoplayer2.C;
import expo.modules.core.ModuleRegistry;
import expo.modules.core.interfaces.InternalModule;
import expo.modules.core.interfaces.RegistryLifecycleListener;
import expo.modules.interfaces.constants.ConstantsInterface;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u001c2\u00020\u00012\u00020\u0002:\u0002\u001c\u001dB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u0016J\u0016\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0007H\u0016J\u0012\u0010\u0016\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00180\u0017H\u0016J\b\u0010\u0019\u001a\u00020\fH\u0016J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u0007H\u0016R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001e"}, d2 = {"Lexpo/modules/constants/ConstantsService;", "Lexpo/modules/core/interfaces/InternalModule;", "Lexpo/modules/interfaces/constants/ConstantsInterface;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "appConfig", "", "getAppConfig", "()Ljava/lang/String;", "sessionId", "statusBarHeightInternal", "", "getStatusBarHeightInternal", "()I", "setStatusBarHeightInternal", "(I)V", "getAppScopeKey", "getConstants", "", "", "getDeviceName", "getExportedInterfaces", "", "Ljava/lang/Class;", "getStatusBarHeight", "getSystemFonts", "getSystemVersion", "Companion", "ExecutionEnvironment", "expo-constants_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ConstantsService.kt */
public class ConstantsService implements InternalModule, ConstantsInterface {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Context context;
    private final String sessionId;
    private int statusBarHeightInternal;

    public int getStatusBarHeight() {
        return this.statusBarHeightInternal;
    }

    public final int getStatusBarHeightInternal() {
        return this.statusBarHeightInternal;
    }

    public /* synthetic */ void onCreate(ModuleRegistry moduleRegistry) {
        RegistryLifecycleListener.CC.$default$onCreate(this, moduleRegistry);
    }

    public /* synthetic */ void onDestroy() {
        RegistryLifecycleListener.CC.$default$onDestroy(this);
    }

    public final void setStatusBarHeightInternal(int i) {
        this.statusBarHeightInternal = i;
    }

    public ConstantsService(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
        Integer valueOf = Integer.valueOf(context2.getResources().getIdentifier("status_bar_height", "dimen", DeviceInfo.OS_NAME));
        valueOf = valueOf.intValue() <= 0 ? null : valueOf;
        this.statusBarHeightInternal = valueOf != null ? Companion.convertPixelsToDp((float) context2.getResources().getDimensionPixelSize(valueOf.intValue()), context2) : 0;
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
        this.sessionId = uuid;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lexpo/modules/constants/ConstantsService$ExecutionEnvironment;", "", "string", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getString", "()Ljava/lang/String;", "BARE", "STANDALONE", "STORE_CLIENT", "expo-constants_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: ConstantsService.kt */
    public enum ExecutionEnvironment {
        BARE("bare"),
        STANDALONE("standalone"),
        STORE_CLIENT("storeClient");
        
        private final String string;

        public static EnumEntries<ExecutionEnvironment> getEntries() {
            return $ENTRIES;
        }

        public final String getString() {
            return this.string;
        }

        private ExecutionEnvironment(String str) {
            this.string = str;
        }

        static {
            ExecutionEnvironment[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }

    public List<Class<?>> getExportedInterfaces() {
        return CollectionsKt.listOf(ConstantsInterface.class);
    }

    public Map<String, Object> getConstants() {
        return MapsKt.mutableMapOf(TuplesKt.to("sessionId", this.sessionId), TuplesKt.to("executionEnvironment", ExecutionEnvironment.BARE.getString()), TuplesKt.to("statusBarHeight", Integer.valueOf(this.statusBarHeightInternal)), TuplesKt.to("deviceName", getDeviceName()), TuplesKt.to("systemFonts", getSystemFonts()), TuplesKt.to("systemVersion", getSystemVersion()), TuplesKt.to("manifest", getAppConfig()), TuplesKt.to(Constants.AMP_TRACKING_OPTION_PLATFORM, MapsKt.mapOf(TuplesKt.to(DeviceInfo.OS_NAME, MapsKt.emptyMap()))));
    }

    public String getAppScopeKey() {
        return this.context.getPackageName();
    }

    public String getDeviceName() {
        String str = Build.MODEL;
        Intrinsics.checkNotNullExpressionValue(str, "MODEL");
        return str;
    }

    public String getSystemVersion() {
        String str = Build.VERSION.RELEASE;
        Intrinsics.checkNotNullExpressionValue(str, "RELEASE");
        return str;
    }

    public List<String> getSystemFonts() {
        return CollectionsKt.listOf("normal", "notoserif", C.SANS_SERIF_NAME, "sans-serif-light", "sans-serif-thin", "sans-serif-condensed", "sans-serif-medium", C.SERIF_NAME, "Roboto", "monospace");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r1, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0022, code lost:
        throw r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String getAppConfig() {
        /*
            r4 = this;
            r0 = 0
            android.content.Context r1 = r4.context     // Catch:{ FileNotFoundException -> 0x002f, Exception -> 0x0023 }
            android.content.res.AssetManager r1 = r1.getAssets()     // Catch:{ FileNotFoundException -> 0x002f, Exception -> 0x0023 }
            java.lang.String r2 = "app.config"
            java.io.InputStream r1 = r1.open(r2)     // Catch:{ FileNotFoundException -> 0x002f, Exception -> 0x0023 }
            java.io.Closeable r1 = (java.io.Closeable) r1     // Catch:{ FileNotFoundException -> 0x002f, Exception -> 0x0023 }
            r2 = r1
            java.io.InputStream r2 = (java.io.InputStream) r2     // Catch:{ all -> 0x001c }
            java.nio.charset.Charset r3 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ all -> 0x001c }
            java.lang.String r2 = org.apache.commons.io.IOUtils.toString((java.io.InputStream) r2, (java.nio.charset.Charset) r3)     // Catch:{ all -> 0x001c }
            kotlin.io.CloseableKt.closeFinally(r1, r0)     // Catch:{ FileNotFoundException -> 0x002f, Exception -> 0x0023 }
            return r2
        L_0x001c:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x001e }
        L_0x001e:
            r3 = move-exception
            kotlin.io.CloseableKt.closeFinally(r1, r2)     // Catch:{ FileNotFoundException -> 0x002f, Exception -> 0x0023 }
            throw r3     // Catch:{ FileNotFoundException -> 0x002f, Exception -> 0x0023 }
        L_0x0023:
            r1 = move-exception
            java.lang.String r2 = expo.modules.constants.ConstantsServiceKt.TAG
            java.lang.String r3 = "Error reading embedded app config"
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            android.util.Log.e(r2, r3, r1)
        L_0x002f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.constants.ConstantsService.getAppConfig():java.lang.String");
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002¨\u0006\t"}, d2 = {"Lexpo/modules/constants/ConstantsService$Companion;", "", "()V", "convertPixelsToDp", "", "px", "", "context", "Landroid/content/Context;", "expo-constants_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: ConstantsService.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final int convertPixelsToDp(float f, Context context) {
            return (int) (f / (((float) context.getResources().getDisplayMetrics().densityDpi) / 160.0f));
        }
    }
}
