package com.google.android.gms.internal.ads;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.CountDownLatch;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzavc implements Runnable {
    private zzavc() {
    }

    /* synthetic */ zzavc(zzavb zzavb) {
    }

    public final void run() {
        CountDownLatch countDownLatch;
        try {
            zzavd.zzd = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            countDownLatch = zzavd.zzb;
        } catch (NoSuchAlgorithmException unused) {
            countDownLatch = zzavd.zzb;
        } catch (Throwable th) {
            zzavd.zzb.countDown();
            throw th;
        }
        countDownLatch.countDown();
    }
}
