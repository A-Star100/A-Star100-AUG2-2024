package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.ads.internal.client.zzba;
import java.io.ByteArrayInputStream;
import java.lang.reflect.InvocationTargetException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzayd extends zzazd {
    private static final zzaze zzi = new zzaze();
    private final Context zzj;

    public zzayd(zzaxp zzaxp, String str, String str2, zzata zzata, int i, int i2, Context context, zzasr zzasr) {
        super(zzaxp, "iz9pI8M74OdFMOjBXhk6CVKK/c29GtinDT3TfbuphLdYOSnoV+Rg8WuW9whaa7rD", "AMztxBQmasdCMrU1nlH2RhtlfSPsjcYFxTHFmKvCDYM=", zzata, i, 27);
        this.zzj = context;
    }

    private final String zzc() {
        try {
            if (this.zzb.zzl() != null) {
                this.zzb.zzl().get();
            }
            zzaud zzc = this.zzb.zzc();
            if (zzc == null || !zzc.zzar()) {
                return null;
            }
            return zzc.zzi();
        } catch (InterruptedException | ExecutionException unused) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        zzava zzava;
        zzasw zzasw;
        Boolean bool;
        AtomicReference zza = zzi.zza(this.zzj.getPackageName());
        synchronized (zza) {
            zzava zzava2 = (zzava) zza.get();
            if (zzava2 == null || zzaxs.zzd(zzava2.zza) || zzava2.zza.equals(ExifInterface.LONGITUDE_EAST) || zzava2.zza.equals("0000000000000000000000000000000000000000000000000000000000000000")) {
                if (!zzaxs.zzd((String) null)) {
                    zzasw = zzasw.ENUM_SIGNAL_SOURCE_CALLER_PROVIDED;
                } else {
                    if (!zzaxs.zzd((String) null)) {
                        bool = false;
                    } else {
                        bool = false;
                    }
                    bool.booleanValue();
                    zzasw = zzasw.ENUM_SIGNAL_SOURCE_ADSHIELD;
                }
                Boolean valueOf = Boolean.valueOf(zzasw == zzasw.ENUM_SIGNAL_SOURCE_ADSHIELD);
                Boolean bool2 = (Boolean) zzba.zzc().zza(zzbdz.zzcp);
                String zzb = ((Boolean) zzba.zzc().zza(zzbdz.zzco)).booleanValue() ? zzb() : null;
                if (bool2.booleanValue() && this.zzb.zzp() && zzaxs.zzd(zzb)) {
                    zzb = zzc();
                }
                zzava zzava3 = new zzava((String) this.zzf.invoke((Object) null, new Object[]{this.zzj, valueOf, zzb}));
                if (zzaxs.zzd(zzava3.zza) || zzava3.zza.equals(ExifInterface.LONGITUDE_EAST)) {
                    int ordinal = zzasw.ordinal();
                    if (ordinal == 3) {
                        String zzc = zzc();
                        if (!zzaxs.zzd(zzc)) {
                            zzava3.zza = zzc;
                        }
                    } else if (ordinal == 4) {
                        throw null;
                    }
                }
                zza.set(zzava3);
            }
            zzava = (zzava) zza.get();
        }
        synchronized (this.zze) {
            if (zzava != null) {
                this.zze.zzz(zzava.zza);
                this.zze.zzae(zzava.zzb);
                this.zze.zzag(zzava.zzc);
                this.zze.zzj(zzava.zzd);
                this.zze.zzy(zzava.zze);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final String zzb() {
        try {
            CertificateFactory instance = CertificateFactory.getInstance("X.509");
            byte[] zzf = zzaxs.zzf((String) zzba.zzc().zza(zzbdz.zzcq));
            ArrayList arrayList = new ArrayList();
            arrayList.add(instance.generateCertificate(new ByteArrayInputStream(zzf)));
            if (!Build.TYPE.equals("user")) {
                arrayList.add(instance.generateCertificate(new ByteArrayInputStream(zzaxs.zzf((String) zzba.zzc().zza(zzbdz.zzcr)))));
            }
            Context context = this.zzj;
            String packageName = context.getPackageName();
            this.zzb.zzk();
            if (Build.VERSION.SDK_INT <= 30 && !Build.VERSION.CODENAME.equals(ExifInterface.LATITUDE_SOUTH)) {
                return null;
            }
            zzgex zze = zzgex.zze();
            context.getPackageManager().requestChecksums(packageName, false, 8, arrayList, new zzazf(zze));
            return (String) zze.get();
        } catch (PackageManager.NameNotFoundException | InterruptedException | NoClassDefFoundError | CertificateEncodingException | CertificateException | ExecutionException unused) {
            return null;
        }
    }
}
