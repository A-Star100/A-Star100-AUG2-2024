package com.google.android.gms.internal.ads;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.os.EnvironmentCompat;
import com.amazon.a.a.o.b.f;
import com.android.billingclient.api.zzg$$ExternalSyntheticApiModelOutline0;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.client.zzr;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.wrappers.Wrappers;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Locale;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class zzbvs implements zzbvu {
    public static zzbvu zza;
    static zzbvu zzb;
    static zzbvu zzc;
    private static final Object zzd = new Object();
    private final Object zze = new Object();
    private final Context zzf;
    private final WeakHashMap zzg = new WeakHashMap();
    private final ExecutorService zzh;
    private final VersionInfoParcel zzi;
    private final String zzj;
    private final String zzk;

    protected zzbvs(Context context, VersionInfoParcel versionInfoParcel) {
        zzftf.zza();
        this.zzh = Executors.unconfigurableExecutorService(Executors.newCachedThreadPool());
        context = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzf = context;
        this.zzi = versionInfoParcel;
        boolean booleanValue = ((Boolean) zzba.zzc().zza(zzbdz.zzhK)).booleanValue();
        String str = EnvironmentCompat.MEDIA_UNKNOWN;
        this.zzj = booleanValue ? Locale.getDefault().getCountry() : str;
        if (((Boolean) zzba.zzc().zza(zzbdz.zzhK)).booleanValue()) {
            Handler handler = zzf.zza;
            str = null;
            if (context != null) {
                try {
                    PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo("com.android.vending", 128);
                    if (packageInfo != null) {
                        str = Integer.toString(packageInfo.versionCode);
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                }
            }
        }
        this.zzk = str;
    }

    public static zzbvu zza(Context context) {
        synchronized (zzd) {
            if (zza == null) {
                if (((Boolean) zzbgb.zze.zze()).booleanValue()) {
                    if (!((Boolean) zzba.zzc().zza(zzbdz.zzhG)).booleanValue()) {
                        zza = new zzbvs(context, VersionInfoParcel.forPackage());
                    }
                }
                zza = new zzbvt();
            }
        }
        return zza;
    }

    public static zzbvu zzb(Context context, VersionInfoParcel versionInfoParcel) {
        synchronized (zzd) {
            if (zzc == null) {
                if (((Boolean) zzbgb.zze.zze()).booleanValue()) {
                    if (!((Boolean) zzba.zzc().zza(zzbdz.zzhG)).booleanValue()) {
                        zzbvs zzbvs = new zzbvs(context, versionInfoParcel);
                        Thread thread = Looper.getMainLooper().getThread();
                        if (thread != null) {
                            synchronized (zzbvs.zze) {
                                zzbvs.zzg.put(thread, true);
                            }
                            thread.setUncaughtExceptionHandler(new zzbvr(zzbvs, thread.getUncaughtExceptionHandler()));
                        }
                        Thread.setDefaultUncaughtExceptionHandler(new zzbvq(zzbvs, Thread.getDefaultUncaughtExceptionHandler()));
                        zzc = zzbvs;
                    }
                }
                zzc = new zzbvt();
            }
        }
        return zzc;
    }

    public static zzbvu zzc(Context context) {
        synchronized (zzd) {
            if (zzb == null) {
                if (((Boolean) zzba.zzc().zza(zzbdz.zzhH)).booleanValue()) {
                    if (!((Boolean) zzba.zzc().zza(zzbdz.zzhG)).booleanValue()) {
                        zzb = new zzbvs(context, VersionInfoParcel.forPackage());
                    }
                }
                zzb = new zzbvt();
            }
        }
        return zzb;
    }

    public static String zzd(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static String zze(Throwable th) {
        return zzfxg.zzc(zzf.zzg(zzd(th)));
    }

    /* access modifiers changed from: protected */
    public final void zzf(Thread thread, Throwable th) {
        if (th != null) {
            boolean z = false;
            boolean z2 = false;
            for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
                for (StackTraceElement stackTraceElement : th2.getStackTrace()) {
                    z |= zzf.zzp(stackTraceElement.getClassName());
                    z2 |= getClass().getName().equals(stackTraceElement.getClassName());
                }
            }
            if (z && !z2) {
                zzh(th, "", 1.0f);
            }
        }
    }

    public final void zzg(Throwable th, String str) {
        zzh(th, str, 1.0f);
    }

    public final void zzh(Throwable th, String str, float f) {
        Throwable th2;
        String str2;
        PackageInfo packageInfo;
        ActivityManager.MemoryInfo zzc2;
        Throwable th3;
        float f2 = f;
        Handler handler = zzf.zza;
        boolean z = false;
        if (((Boolean) zzbgb.zzf.zze()).booleanValue()) {
            th2 = th;
        } else {
            LinkedList linkedList = new LinkedList();
            for (Throwable th4 = th; th4 != null; th4 = th4.getCause()) {
                linkedList.push(th4);
            }
            th2 = null;
            while (!linkedList.isEmpty()) {
                Throwable th5 = (Throwable) linkedList.pop();
                StackTraceElement[] stackTrace = th5.getStackTrace();
                ArrayList arrayList = new ArrayList();
                arrayList.add(new StackTraceElement(th5.getClass().getName(), "<filtered>", "<filtered>", 1));
                boolean z2 = false;
                for (StackTraceElement stackTraceElement : stackTrace) {
                    if (zzf.zzp(stackTraceElement.getClassName())) {
                        arrayList.add(stackTraceElement);
                        z2 = true;
                    } else {
                        String className = stackTraceElement.getClassName();
                        if (!TextUtils.isEmpty(className) && (className.startsWith("android.") || className.startsWith("java."))) {
                            arrayList.add(stackTraceElement);
                        } else {
                            arrayList.add(new StackTraceElement("<filtered>", "<filtered>", "<filtered>", 1));
                        }
                    }
                }
                if (z2) {
                    if (th2 == null) {
                        th3 = new Throwable(th5.getMessage());
                    } else {
                        th3 = new Throwable(th5.getMessage(), th2);
                    }
                    th2 = th3;
                    th2.setStackTrace((StackTraceElement[]) arrayList.toArray(new StackTraceElement[0]));
                }
            }
        }
        if (th2 != null) {
            String name = th.getClass().getName();
            String zzd2 = zzd(th);
            String zze2 = ((Boolean) zzba.zzc().zza(zzbdz.zziJ)).booleanValue() ? zze(th) : "";
            double d = (double) f2;
            int i = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
            double random = Math.random();
            int i2 = i > 0 ? (int) (1.0f / f2) : 1;
            if (random < d) {
                ArrayList<String> arrayList2 = new ArrayList<>();
                try {
                    z = Wrappers.packageManager(this.zzf).isCallerInstantApp();
                } catch (Throwable th6) {
                    zzm.zzh("Error fetching instant app info", th6);
                }
                try {
                    str2 = this.zzf.getPackageName();
                } catch (Throwable unused) {
                    zzm.zzj("Cannot obtain package name, proceeding.");
                    str2 = EnvironmentCompat.MEDIA_UNKNOWN;
                }
                Uri.Builder appendQueryParameter = new Uri.Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("is_aia", Boolean.toString(z)).appendQueryParameter("id", "gmob-apps-report-exception").appendQueryParameter("os", Build.VERSION.RELEASE).appendQueryParameter("api", String.valueOf(Build.VERSION.SDK_INT));
                String str3 = Build.MANUFACTURER;
                String str4 = Build.MODEL;
                if (!str4.startsWith(str3)) {
                    str4 = str3 + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + str4;
                }
                Uri.Builder appendQueryParameter2 = appendQueryParameter.appendQueryParameter("device", str4).appendQueryParameter("js", this.zzi.afmaVersion).appendQueryParameter("appid", str2).appendQueryParameter("exceptiontype", name).appendQueryParameter("stacktrace", zzd2).appendQueryParameter("eids", TextUtils.join(f.a, zzba.zza().zza())).appendQueryParameter("exceptionkey", str).appendQueryParameter("cl", "619949182").appendQueryParameter("rc", "dev").appendQueryParameter("sampling_rate", Integer.toString(i2)).appendQueryParameter("pb_tm", String.valueOf(zzbgb.zzc.zze())).appendQueryParameter("gmscv", String.valueOf(GoogleApiAvailabilityLight.getInstance().getApkVersion(this.zzf)));
                boolean z3 = this.zzi.isLiteSdk;
                String str5 = SessionDescription.SUPPORTED_SDP_VERSION;
                Uri.Builder appendQueryParameter3 = appendQueryParameter2.appendQueryParameter("lite", true != z3 ? str5 : "1");
                if (!TextUtils.isEmpty(zze2)) {
                    appendQueryParameter3.appendQueryParameter("hash", zze2);
                }
                if (((Boolean) zzba.zzc().zza(zzbdz.zzhL)).booleanValue() && (zzc2 = zzf.zzc(this.zzf)) != null) {
                    appendQueryParameter3.appendQueryParameter("available_memory", Long.toString(zzc2.availMem));
                    appendQueryParameter3.appendQueryParameter("total_memory", Long.toString(zzc2.totalMem));
                    if (true == zzc2.lowMemory) {
                        str5 = "1";
                    }
                    appendQueryParameter3.appendQueryParameter("is_low_memory", str5);
                }
                if (((Boolean) zzba.zzc().zza(zzbdz.zzhK)).booleanValue()) {
                    if (!TextUtils.isEmpty(this.zzj)) {
                        appendQueryParameter3.appendQueryParameter("countrycode", this.zzj);
                    }
                    if (!TextUtils.isEmpty(this.zzk)) {
                        appendQueryParameter3.appendQueryParameter("psv", this.zzk);
                    }
                    Context context = this.zzf;
                    if (Build.VERSION.SDK_INT >= 26) {
                        packageInfo = zzg$$ExternalSyntheticApiModelOutline0.m();
                    } else {
                        if (context != null) {
                            try {
                                packageInfo = Wrappers.packageManager(context).getPackageInfo("com.android.webview", 128);
                            } catch (PackageManager.NameNotFoundException unused2) {
                            }
                        }
                        packageInfo = null;
                    }
                    if (packageInfo != null) {
                        appendQueryParameter3.appendQueryParameter("wvvc", Integer.toString(packageInfo.versionCode));
                        appendQueryParameter3.appendQueryParameter("wvvn", packageInfo.versionName);
                        appendQueryParameter3.appendQueryParameter("wvpn", packageInfo.packageName);
                    }
                }
                arrayList2.add(appendQueryParameter3.toString());
                for (String zzbvp : arrayList2) {
                    this.zzh.execute(new zzbvp(new zzr((String) null), zzbvp));
                }
            }
        }
    }
}
