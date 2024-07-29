package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.util.MimeTypes;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzrx extends zzto implements zzlh {
    private final Context zzb;
    /* access modifiers changed from: private */
    public final zzqf zzc;
    private final zzqn zzd;
    private int zze;
    private boolean zzf;
    private boolean zzg;
    private zzam zzh;
    private zzam zzi;
    private long zzj;
    private boolean zzk;
    private boolean zzl;
    /* access modifiers changed from: private */
    public zzme zzm;
    /* access modifiers changed from: private */
    public boolean zzn;

    public zzrx(Context context, zzte zzte, zztq zztq, boolean z, Handler handler, zzqg zzqg, zzqn zzqn) {
        super(1, zzte, zztq, false, 44100.0f);
        this.zzb = context.getApplicationContext();
        this.zzd = zzqn;
        this.zzc = new zzqf(handler, zzqg);
        zzqn.zzq(new zzrw(this, (zzrv) null));
    }

    private final int zzaM(zzti zzti, zzam zzam) {
        if (!"OMX.google.raw.decoder".equals(zzti.zza) || zzfx.zza >= 24 || (zzfx.zza == 23 && zzfx.zzM(this.zzb))) {
            return zzam.zzn;
        }
        return -1;
    }

    private static List zzaN(zztq zztq, zzam zzam, boolean z, zzqn zzqn) throws zztw {
        zzti zzb2;
        if (zzam.zzm == null) {
            return zzfzn.zzm();
        }
        if (!zzqn.zzA(zzam) || (zzb2 = zzuc.zzb()) == null) {
            return zzuc.zzf(zztq, zzam, false, false);
        }
        return zzfzn.zzn(zzb2);
    }

    private final void zzaO() {
        long zzb2 = this.zzd.zzb(zzW());
        if (zzb2 != Long.MIN_VALUE) {
            if (!this.zzk) {
                zzb2 = Math.max(this.zzj, zzb2);
            }
            this.zzj = zzb2;
            this.zzk = false;
        }
    }

    /* access modifiers changed from: protected */
    public final void zzA() {
        this.zzd.zzk();
    }

    /* access modifiers changed from: protected */
    public final void zzC() {
        this.zzn = false;
        try {
            super.zzC();
            if (this.zzl) {
                this.zzl = false;
                this.zzd.zzl();
            }
        } catch (Throwable th) {
            if (this.zzl) {
                this.zzl = false;
                this.zzd.zzl();
            }
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public final void zzD() {
        this.zzd.zzi();
    }

    /* access modifiers changed from: protected */
    public final void zzE() {
        zzaO();
        this.zzd.zzh();
    }

    public final String zzU() {
        return "MediaCodecAudioRenderer";
    }

    public final boolean zzW() {
        return super.zzW() && this.zzd.zzz();
    }

    public final boolean zzX() {
        return this.zzd.zzy() || super.zzX();
    }

    /* access modifiers changed from: protected */
    public final float zzZ(float f, zzam zzam, zzam[] zzamArr) {
        int i = -1;
        for (zzam zzam2 : zzamArr) {
            int i2 = zzam2.zzA;
            if (i2 != -1) {
                i = Math.max(i, i2);
            }
        }
        if (i == -1) {
            return -1.0f;
        }
        return ((float) i) * f;
    }

    public final long zza() {
        if (zzcU() == 2) {
            zzaO();
        }
        return this.zzj;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00c1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzaa(com.google.android.gms.internal.ads.zztq r10, com.google.android.gms.internal.ads.zzam r11) throws com.google.android.gms.internal.ads.zztw {
        /*
            r9 = this;
            java.lang.String r0 = r11.zzm
            boolean r0 = com.google.android.gms.internal.ads.zzcb.zzg(r0)
            r1 = 128(0x80, float:1.794E-43)
            if (r0 != 0) goto L_0x000b
            return r1
        L_0x000b:
            int r0 = com.google.android.gms.internal.ads.zzfx.zza
            int r0 = r11.zzG
            boolean r2 = zzaL(r11)
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0046
            if (r0 == 0) goto L_0x001f
            com.google.android.gms.internal.ads.zzti r0 = com.google.android.gms.internal.ads.zzuc.zzb()
            if (r0 == 0) goto L_0x0046
        L_0x001f:
            com.google.android.gms.internal.ads.zzqn r0 = r9.zzd
            com.google.android.gms.internal.ads.zzps r0 = r0.zzd(r11)
            boolean r5 = r0.zzb
            if (r5 != 0) goto L_0x002b
            r5 = r3
            goto L_0x003a
        L_0x002b:
            boolean r5 = r0.zzc
            if (r4 == r5) goto L_0x0032
            r5 = 512(0x200, float:7.175E-43)
            goto L_0x0034
        L_0x0032:
            r5 = 1536(0x600, float:2.152E-42)
        L_0x0034:
            boolean r0 = r0.zzd
            if (r0 == 0) goto L_0x003a
            r5 = r5 | 2048(0x800, float:2.87E-42)
        L_0x003a:
            com.google.android.gms.internal.ads.zzqn r0 = r9.zzd
            boolean r0 = r0.zzA(r11)
            if (r0 != 0) goto L_0x0043
            goto L_0x0047
        L_0x0043:
            r10 = r5 | 172(0xac, float:2.41E-43)
            return r10
        L_0x0046:
            r5 = r3
        L_0x0047:
            java.lang.String r0 = r11.zzm
            java.lang.String r6 = "audio/raw"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x005a
            com.google.android.gms.internal.ads.zzqn r0 = r9.zzd
            boolean r0 = r0.zzA(r11)
            if (r0 != 0) goto L_0x005a
            goto L_0x007c
        L_0x005a:
            com.google.android.gms.internal.ads.zzqn r0 = r9.zzd
            int r6 = r11.zzz
            int r7 = r11.zzA
            r8 = 2
            com.google.android.gms.internal.ads.zzam r6 = com.google.android.gms.internal.ads.zzfx.zzz(r8, r6, r7)
            boolean r0 = r0.zzA(r6)
            if (r0 != 0) goto L_0x006c
            goto L_0x007c
        L_0x006c:
            com.google.android.gms.internal.ads.zzqn r0 = r9.zzd
            java.util.List r10 = zzaN(r10, r11, r3, r0)
            boolean r0 = r10.isEmpty()
            if (r0 == 0) goto L_0x0079
            goto L_0x007c
        L_0x0079:
            if (r2 != 0) goto L_0x007f
            r4 = r8
        L_0x007c:
            r10 = r4 | 128(0x80, float:1.794E-43)
            return r10
        L_0x007f:
            java.lang.Object r0 = r10.get(r3)
            com.google.android.gms.internal.ads.zzti r0 = (com.google.android.gms.internal.ads.zzti) r0
            boolean r2 = r0.zze(r11)
            if (r2 != 0) goto L_0x00a5
            r6 = r4
        L_0x008c:
            int r7 = r10.size()
            if (r6 >= r7) goto L_0x00a5
            java.lang.Object r7 = r10.get(r6)
            com.google.android.gms.internal.ads.zzti r7 = (com.google.android.gms.internal.ads.zzti) r7
            boolean r8 = r7.zze(r11)
            if (r8 == 0) goto L_0x00a2
            r10 = r3
            r2 = r4
            r0 = r7
            goto L_0x00a6
        L_0x00a2:
            int r6 = r6 + 1
            goto L_0x008c
        L_0x00a5:
            r10 = r4
        L_0x00a6:
            if (r4 == r2) goto L_0x00aa
            r6 = 3
            goto L_0x00ab
        L_0x00aa:
            r6 = 4
        L_0x00ab:
            r7 = 8
            if (r2 == 0) goto L_0x00b7
            boolean r11 = r0.zzf(r11)
            if (r11 == 0) goto L_0x00b7
            r7 = 16
        L_0x00b7:
            boolean r11 = r0.zzg
            if (r4 == r11) goto L_0x00bd
            r11 = r3
            goto L_0x00bf
        L_0x00bd:
            r11 = 64
        L_0x00bf:
            if (r4 == r10) goto L_0x00c2
            r1 = r3
        L_0x00c2:
            r10 = r6 | r7
            r10 = r10 | 32
            r10 = r10 | r11
            r10 = r10 | r1
            r10 = r10 | r5
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzrx.zzaa(com.google.android.gms.internal.ads.zztq, com.google.android.gms.internal.ads.zzam):int");
    }

    /* access modifiers changed from: protected */
    public final zzis zzab(zzti zzti, zzam zzam, zzam zzam2) {
        int i;
        int i2;
        zzis zzb2 = zzti.zzb(zzam, zzam2);
        int i3 = zzb2.zze;
        if (zzaJ(zzam2)) {
            i3 |= 32768;
        }
        if (zzaM(zzti, zzam2) > this.zze) {
            i3 |= 64;
        }
        String str = zzti.zza;
        if (i3 != 0) {
            i = i3;
            i2 = 0;
        } else {
            i2 = zzb2.zzd;
            i = 0;
        }
        return new zzis(str, zzam, zzam2, i2, i);
    }

    /* access modifiers changed from: protected */
    public final zztd zzaf(zzti zzti, zzam zzam, MediaCrypto mediaCrypto, float f) {
        int zzaM = zzaM(zzti, zzam);
        if (r0 != 1) {
            for (zzam zzam2 : zzT()) {
                if (zzti.zzb(zzam, zzam2).zzd != 0) {
                    zzaM = Math.max(zzaM, zzaM(zzti, zzam2));
                }
            }
        }
        this.zze = zzaM;
        this.zzf = zzfx.zza < 24 && "OMX.SEC.aac.dec".equals(zzti.zza) && "samsung".equals(zzfx.zzc) && (zzfx.zzb.startsWith("zeroflte") || zzfx.zzb.startsWith("herolte") || zzfx.zzb.startsWith("heroqlte"));
        String str = zzti.zza;
        this.zzg = str.equals("OMX.google.opus.decoder") || str.equals("c2.android.opus.decoder") || str.equals("OMX.google.vorbis.decoder") || str.equals("c2.android.vorbis.decoder");
        String str2 = zzti.zzc;
        int i = this.zze;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str2);
        mediaFormat.setInteger("channel-count", zzam.zzz);
        mediaFormat.setInteger("sample-rate", zzam.zzA);
        zzfh.zzb(mediaFormat, zzam.zzo);
        zzfh.zza(mediaFormat, "max-input-size", i);
        if (zzfx.zza >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f != -1.0f && (zzfx.zza != 23 || (!"ZTE B2017G".equals(zzfx.zzd) && !"AXON 7 mini".equals(zzfx.zzd)))) {
                mediaFormat.setFloat("operating-rate", f);
            }
        }
        if (zzfx.zza <= 28 && MimeTypes.AUDIO_AC4.equals(zzam.zzm)) {
            mediaFormat.setInteger("ac4-is-sync", 1);
        }
        if (zzfx.zza >= 24 && this.zzd.zza(zzfx.zzz(4, zzam.zzz, zzam.zzA)) == 2) {
            mediaFormat.setInteger("pcm-encoding", 4);
        }
        if (zzfx.zza >= 32) {
            mediaFormat.setInteger("max-output-channel-count", 99);
        }
        this.zzi = (!MimeTypes.AUDIO_RAW.equals(zzti.zzb) || MimeTypes.AUDIO_RAW.equals(zzam.zzm)) ? null : zzam;
        return zztd.zza(zzti, mediaFormat, zzam, (MediaCrypto) null);
    }

    /* access modifiers changed from: protected */
    public final List zzag(zztq zztq, zzam zzam, boolean z) throws zztw {
        return zzuc.zzg(zzaN(zztq, zzam, false, this.zzd), zzam);
    }

    /* access modifiers changed from: protected */
    public final void zzaj(zzih zzih) {
        zzam zzam;
        if (zzfx.zza >= 29 && (zzam = zzih.zza) != null && Objects.equals(zzam.zzm, MimeTypes.AUDIO_OPUS) && zzaI()) {
            ByteBuffer byteBuffer = zzih.zzf;
            byteBuffer.getClass();
            zzam zzam2 = zzih.zza;
            zzam2.getClass();
            if (byteBuffer.remaining() == 8) {
                this.zzd.zzr(zzam2.zzC, (int) ((byteBuffer.order(ByteOrder.LITTLE_ENDIAN).getLong() * 48000) / C.NANOS_PER_SECOND));
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void zzak(Exception exc) {
        zzfe.zzd("MediaCodecAudioRenderer", "Audio codec error", exc);
        this.zzc.zza(exc);
    }

    /* access modifiers changed from: protected */
    public final void zzal(String str, zztd zztd, long j, long j2) {
        this.zzc.zze(str, j, j2);
    }

    /* access modifiers changed from: protected */
    public final void zzam(String str) {
        this.zzc.zzf(str);
    }

    /* access modifiers changed from: protected */
    public final void zzao() {
        this.zzk = true;
    }

    /* access modifiers changed from: protected */
    public final void zzap() {
        this.zzd.zzg();
    }

    /* access modifiers changed from: protected */
    public final void zzaq() throws zziz {
        try {
            this.zzd.zzj();
        } catch (zzqm e) {
            throw zzi(e, e.zzc, e.zzb, true != zzaI() ? PlaybackException.ERROR_CODE_AUDIO_TRACK_WRITE_FAILED : 5003);
        }
    }

    /* access modifiers changed from: protected */
    public final boolean zzas(zzam zzam) {
        zzm();
        return this.zzd.zzA(zzam);
    }

    public final zzcg zzc() {
        return this.zzd.zzc();
    }

    public final void zzg(zzcg zzcg) {
        this.zzd.zzs(zzcg);
    }

    public final boolean zzj() {
        boolean z = this.zzn;
        this.zzn = false;
        return z;
    }

    public final zzlh zzk() {
        return this;
    }

    public final void zzt(int i, Object obj) throws zziz {
        if (i == 2) {
            zzqn zzqn = this.zzd;
            obj.getClass();
            zzqn.zzw(((Float) obj).floatValue());
        } else if (i == 3) {
            zzk zzk2 = (zzk) obj;
            zzqn zzqn2 = this.zzd;
            zzk2.getClass();
            zzqn2.zzm(zzk2);
        } else if (i != 6) {
            switch (i) {
                case 9:
                    zzqn zzqn3 = this.zzd;
                    obj.getClass();
                    zzqn3.zzv(((Boolean) obj).booleanValue());
                    return;
                case 10:
                    zzqn zzqn4 = this.zzd;
                    obj.getClass();
                    zzqn4.zzn(((Integer) obj).intValue());
                    return;
                case 11:
                    this.zzm = (zzme) obj;
                    return;
                case 12:
                    if (zzfx.zza >= 23) {
                        zzru.zza(this.zzd, obj);
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else {
            zzl zzl2 = (zzl) obj;
            zzqn zzqn5 = this.zzd;
            zzl2.getClass();
            zzqn5.zzo(zzl2);
        }
    }

    /* access modifiers changed from: protected */
    public final void zzw() {
        this.zzl = true;
        this.zzh = null;
        try {
            this.zzd.zzf();
            super.zzw();
        } catch (Throwable th) {
            super.zzw();
            throw th;
        } finally {
            this.zzc.zzg(this.zza);
        }
    }

    /* access modifiers changed from: protected */
    public final void zzx(boolean z, boolean z2) throws zziz {
        super.zzx(z, z2);
        this.zzc.zzh(this.zza);
        zzm();
        this.zzd.zzt(zzn());
        this.zzd.zzp(zzh());
    }

    /* access modifiers changed from: protected */
    public final void zzz(long j, boolean z) throws zziz {
        super.zzz(j, z);
        this.zzd.zzf();
        this.zzj = j;
        this.zzn = false;
        this.zzk = true;
    }

    /* access modifiers changed from: protected */
    public final zzis zzac(zzlb zzlb) throws zziz {
        zzam zzam = zzlb.zza;
        zzam.getClass();
        this.zzh = zzam;
        zzis zzac = super.zzac(zzlb);
        this.zzc.zzi(zzam, zzac);
        return zzac;
    }

    /* access modifiers changed from: protected */
    public final boolean zzar(long j, long j2, zztf zztf, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, zzam zzam) throws zziz {
        byteBuffer.getClass();
        if (this.zzi != null && (i2 & 2) != 0) {
            zztf.getClass();
            zztf.zzn(i, false);
            return true;
        } else if (z) {
            if (zztf != null) {
                zztf.zzn(i, false);
            }
            this.zza.zzf += i3;
            this.zzd.zzg();
            return true;
        } else {
            try {
                if (!this.zzd.zzx(byteBuffer, j3, i3)) {
                    return false;
                }
                if (zztf != null) {
                    zztf.zzn(i, false);
                }
                this.zza.zze += i3;
                return true;
            } catch (zzqj e) {
                zzam zzam2 = this.zzh;
                if (zzaI()) {
                    zzm();
                }
                throw zzi(e, zzam2, e.zzb, PlaybackException.ERROR_CODE_AUDIO_TRACK_INIT_FAILED);
            } catch (zzqm e2) {
                if (zzaI()) {
                    zzm();
                }
                throw zzi(e2, zzam, e2.zzb, PlaybackException.ERROR_CODE_AUDIO_TRACK_WRITE_FAILED);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void zzan(zzam zzam, MediaFormat mediaFormat) throws zziz {
        int i;
        int[] iArr;
        int i2;
        zzam zzam2 = this.zzi;
        boolean z = true;
        int[] iArr2 = null;
        if (zzam2 != null) {
            zzam = zzam2;
        } else if (zzaw() != null) {
            mediaFormat.getClass();
            if (MimeTypes.AUDIO_RAW.equals(zzam.zzm)) {
                i = zzam.zzB;
            } else if (zzfx.zza < 24 || !mediaFormat.containsKey("pcm-encoding")) {
                i = mediaFormat.containsKey("v-bits-per-sample") ? zzfx.zzl(mediaFormat.getInteger("v-bits-per-sample")) : 2;
            } else {
                i = mediaFormat.getInteger("pcm-encoding");
            }
            zzak zzak = new zzak();
            zzak.zzW(MimeTypes.AUDIO_RAW);
            zzak.zzQ(i);
            zzak.zzF(zzam.zzC);
            zzak.zzG(zzam.zzD);
            zzak.zzP(zzam.zzk);
            zzak.zzK(zzam.zzb);
            zzak.zzM(zzam.zzc);
            zzak.zzN(zzam.zzd);
            zzak.zzY(zzam.zze);
            zzak.zzU(zzam.zzf);
            zzak.zzy(mediaFormat.getInteger("channel-count"));
            zzak.zzX(mediaFormat.getInteger("sample-rate"));
            zzam zzac = zzak.zzac();
            if (this.zzf && zzac.zzz == 6 && (i2 = zzam.zzz) < 6) {
                iArr2 = new int[i2];
                for (int i3 = 0; i3 < zzam.zzz; i3++) {
                    iArr2[i3] = i3;
                }
            } else if (this.zzg) {
                int i4 = zzac.zzz;
                if (i4 == 3) {
                    iArr = new int[]{0, 2, 1};
                } else if (i4 == 5) {
                    iArr = new int[]{0, 2, 1, 3, 4};
                } else if (i4 == 6) {
                    iArr = new int[]{0, 2, 1, 5, 3, 4};
                } else if (i4 == 7) {
                    iArr = new int[]{0, 2, 1, 6, 5, 3, 4};
                } else if (i4 == 8) {
                    iArr = new int[]{0, 2, 1, 7, 5, 6, 3, 4};
                }
                iArr2 = iArr;
            }
            zzam = zzac;
        }
        try {
            if (zzfx.zza >= 29) {
                if (zzaI()) {
                    zzm();
                }
                if (zzfx.zza < 29) {
                    z = false;
                }
                zzek.zzf(z);
            }
            this.zzd.zze(zzam, 0, iArr2);
        } catch (zzqi e) {
            throw zzi(e, e.zza, false, PlaybackException.ERROR_CODE_AUDIO_TRACK_INIT_FAILED);
        }
    }
}
