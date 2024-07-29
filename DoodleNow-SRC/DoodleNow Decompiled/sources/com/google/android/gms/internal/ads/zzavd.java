package com.google.android.gms.internal.ads;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzavd {
    static boolean zza = false;
    static final CountDownLatch zzb = new CountDownLatch(1);
    public static final /* synthetic */ int zzc = 0;
    /* access modifiers changed from: private */
    public static MessageDigest zzd;
    private static final Object zze = new Object();
    private static final Object zzf = new Object();

    static zzaud zza(zzatu zzatu) {
        zzata zza2 = zzaud.zza();
        zza2.zzJ((long) zzatu.zza());
        return (zzaud) zza2.zzbr();
    }

    static String zzb(byte[] bArr, String str) throws GeneralSecurityException, UnsupportedEncodingException {
        byte[] bArr2;
        Vector zzc2 = zzc(bArr, 255);
        if (zzc2 == null || zzc2.isEmpty()) {
            bArr2 = zzg(zza(zzatu.PSN_ENCODE_SIZE_FAIL).zzaV(), str, true);
        } else {
            zzauv zza2 = zzauw.zza();
            int size = zzc2.size();
            for (int i = 0; i < size; i++) {
                zza2.zza(zzgyj.zzv(zzg((byte[]) zzc2.get(i), str, false), 0, 256));
            }
            byte[] zzf2 = zzf(bArr);
            zzgyj zzgyj = zzgyj.zzb;
            zza2.zzc(zzgyj.zzv(zzf2, 0, zzf2.length));
            bArr2 = ((zzauw) zza2.zzbr()).zzaV();
        }
        return zzauz.zza(bArr2, true);
    }

    static Vector zzc(byte[] bArr, int i) {
        int length = bArr.length;
        if (length <= 0) {
            return null;
        }
        int i2 = length + 254;
        Vector vector = new Vector();
        int i3 = 0;
        while (i3 < i2 / 255) {
            int i4 = i3 * 255;
            try {
                int length2 = bArr.length;
                if (length2 - i4 > 255) {
                    length2 = i4 + 255;
                }
                vector.add(Arrays.copyOfRange(bArr, i4, length2));
                i3++;
            } catch (IndexOutOfBoundsException unused) {
                return null;
            }
        }
        return vector;
    }

    static void zze() {
        synchronized (zzf) {
            if (!zza) {
                zza = true;
                new Thread(new zzavc((zzavb) null)).start();
            }
        }
    }

    public static byte[] zzf(byte[] bArr) throws NoSuchAlgorithmException {
        byte[] digest;
        synchronized (zze) {
            zze();
            MessageDigest messageDigest = null;
            try {
                if (zzb.await(2, TimeUnit.SECONDS)) {
                    MessageDigest messageDigest2 = zzd;
                    if (messageDigest2 != null) {
                        messageDigest = messageDigest2;
                    }
                }
            } catch (InterruptedException unused) {
            }
            if (messageDigest != null) {
                messageDigest.reset();
                messageDigest.update(bArr);
                digest = zzd.digest();
            } else {
                throw new NoSuchAlgorithmException("Cannot compute hash");
            }
        }
        return digest;
    }

    private static byte[] zzg(byte[] bArr, String str, boolean z) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        byte[] bArr2;
        int length = bArr.length;
        int i = true != z ? 255 : 239;
        if (length > i) {
            bArr = zza(zzatu.PSN_ENCODE_SIZE_FAIL).zzaV();
        }
        int i2 = i + 1;
        int length2 = bArr.length;
        byte b = (byte) length2;
        if (length2 < i) {
            byte[] bArr3 = new byte[(i - length2)];
            new SecureRandom().nextBytes(bArr3);
            bArr2 = ByteBuffer.allocate(i2).put(b).put(bArr).put(bArr3).array();
        } else {
            bArr2 = ByteBuffer.allocate(i2).put(b).put(bArr).array();
        }
        if (z) {
            bArr2 = ByteBuffer.allocate(256).put(zzf(bArr2)).put(bArr2).array();
        }
        byte[] bArr4 = new byte[256];
        zzave[] zzaveArr = new zzawd().zzcG;
        int length3 = zzaveArr.length;
        for (int i3 = 0; i3 < 12; i3++) {
            zzaveArr[i3].zza(bArr2, bArr4);
        }
        if (str != null && str.length() > 0) {
            if (str.length() > 32) {
                str = str.substring(0, 32);
            }
            new zzaux(str.getBytes("UTF-8")).zza(bArr4);
        }
        return bArr4;
    }
}
