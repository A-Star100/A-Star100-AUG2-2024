package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.os.SystemClock;
import com.google.android.exoplayer2.C;
import java.lang.reflect.Method;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzqr {
    private long zzA;
    private long zzB;
    private long zzC;
    private boolean zzD;
    private long zzE;
    private long zzF;
    private boolean zzG;
    private long zzH;
    private zzel zzI;
    private final zzqq zza;
    private final long[] zzb;
    private AudioTrack zzc;
    private int zzd;
    private zzqp zze;
    private int zzf;
    private boolean zzg;
    private long zzh;
    private float zzi;
    private boolean zzj;
    private long zzk;
    private long zzl;
    private Method zzm;
    private long zzn;
    private boolean zzo;
    private boolean zzp;
    private long zzq;
    private long zzr;
    private long zzs;
    private long zzt;
    private long zzu;
    private int zzv;
    private int zzw;
    private long zzx;
    private long zzy;
    private long zzz;

    public zzqr(zzqq zzqq) {
        this.zza = zzqq;
        try {
            this.zzm = AudioTrack.class.getMethod("getLatency", (Class[]) null);
        } catch (NoSuchMethodException unused) {
        }
        this.zzb = new long[10];
        this.zzI = zzel.zza;
    }

    private final long zzl() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int i = 2;
        if (this.zzx != C.TIME_UNSET) {
            AudioTrack audioTrack = this.zzc;
            audioTrack.getClass();
            if (audioTrack.getPlayState() == 2) {
                return this.zzz;
            }
            return Math.min(this.zzA, this.zzz + zzfx.zzo(zzfx.zzp(zzfx.zzr(elapsedRealtime) - this.zzx, this.zzi), this.zzf));
        }
        if (elapsedRealtime - this.zzr >= 5) {
            AudioTrack audioTrack2 = this.zzc;
            audioTrack2.getClass();
            int playState = audioTrack2.getPlayState();
            if (playState != 1) {
                long playbackHeadPosition = ((long) audioTrack2.getPlaybackHeadPosition()) & 4294967295L;
                long j = 0;
                if (this.zzg) {
                    if (playState != 2) {
                        i = playState;
                    } else if (playbackHeadPosition == 0) {
                        this.zzu = this.zzs;
                    }
                    playbackHeadPosition += this.zzu;
                    playState = i;
                }
                if (zzfx.zza <= 29) {
                    if (playbackHeadPosition != 0) {
                        j = playbackHeadPosition;
                    } else if (this.zzs > 0 && playState == 3) {
                        if (this.zzy == C.TIME_UNSET) {
                            this.zzy = elapsedRealtime;
                        }
                    }
                    this.zzy = C.TIME_UNSET;
                    playbackHeadPosition = j;
                }
                if (this.zzs > playbackHeadPosition) {
                    this.zzt++;
                }
                this.zzs = playbackHeadPosition;
            }
            this.zzr = elapsedRealtime;
        }
        return this.zzs + this.zzH + (this.zzt << 32);
    }

    private final long zzm() {
        return zzfx.zzs(zzl(), this.zzf);
    }

    private final void zzn() {
        this.zzk = 0;
        this.zzw = 0;
        this.zzv = 0;
        this.zzl = 0;
        this.zzC = 0;
        this.zzF = 0;
        this.zzj = false;
    }

    public final void zzb(long j) {
        this.zzz = zzl();
        this.zzx = zzfx.zzr(SystemClock.elapsedRealtime());
        this.zzA = j;
    }

    public final void zzc() {
        zzn();
        this.zzc = null;
        this.zze = null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x003c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzd(android.media.AudioTrack r3, boolean r4, int r5, int r6, int r7) {
        /*
            r2 = this;
            r2.zzc = r3
            r2.zzd = r7
            com.google.android.gms.internal.ads.zzqp r0 = new com.google.android.gms.internal.ads.zzqp
            r0.<init>(r3)
            r2.zze = r0
            int r3 = r3.getSampleRate()
            r2.zzf = r3
            r3 = 0
            if (r4 == 0) goto L_0x0023
            int r4 = com.google.android.gms.internal.ads.zzfx.zza
            r0 = 23
            if (r4 >= r0) goto L_0x0023
            r4 = 5
            r0 = 1
            if (r5 == r4) goto L_0x0024
            r4 = 6
            if (r5 != r4) goto L_0x0023
            r5 = r4
            goto L_0x0024
        L_0x0023:
            r0 = r3
        L_0x0024:
            r2.zzg = r0
            boolean r4 = com.google.android.gms.internal.ads.zzfx.zzK(r5)
            r2.zzp = r4
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 == 0) goto L_0x003c
            int r7 = r7 / r6
            long r4 = (long) r7
            int r6 = r2.zzf
            long r4 = com.google.android.gms.internal.ads.zzfx.zzs(r4, r6)
            goto L_0x003d
        L_0x003c:
            r4 = r0
        L_0x003d:
            r2.zzh = r4
            r4 = 0
            r2.zzs = r4
            r2.zzt = r4
            r2.zzG = r3
            r2.zzH = r4
            r2.zzu = r4
            r2.zzo = r3
            r2.zzx = r0
            r2.zzy = r0
            r2.zzq = r4
            r2.zzn = r4
            r3 = 1065353216(0x3f800000, float:1.0)
            r2.zzi = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzqr.zzd(android.media.AudioTrack, boolean, int, int, int):void");
    }

    public final void zze(zzel zzel) {
        this.zzI = zzel;
    }

    public final void zzf() {
        if (this.zzx != C.TIME_UNSET) {
            this.zzx = zzfx.zzr(SystemClock.elapsedRealtime());
        }
        zzqp zzqp = this.zze;
        zzqp.getClass();
        zzqp.zze();
    }

    public final boolean zzg(long j) {
        if (j > zzfx.zzo(zza(false), this.zzf)) {
            return true;
        }
        if (this.zzg) {
            AudioTrack audioTrack = this.zzc;
            audioTrack.getClass();
            if (audioTrack.getPlayState() == 2 && zzl() == 0) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final boolean zzi(long j) {
        return this.zzy != C.TIME_UNSET && j > 0 && SystemClock.elapsedRealtime() - this.zzy >= 200;
    }

    public final boolean zzk() {
        zzn();
        if (this.zzx == C.TIME_UNSET) {
            zzqp zzqp = this.zze;
            zzqp.getClass();
            zzqp.zze();
            return true;
        }
        this.zzz = zzl();
        return false;
    }

    public final boolean zzh() {
        AudioTrack audioTrack = this.zzc;
        audioTrack.getClass();
        return audioTrack.getPlayState() == 3;
    }

    public final boolean zzj(long j) {
        AudioTrack audioTrack = this.zzc;
        audioTrack.getClass();
        int playState = audioTrack.getPlayState();
        if (this.zzg) {
            if (playState == 2) {
                this.zzo = false;
                return false;
            } else if (playState == 1) {
                if (zzl() == 0) {
                    return false;
                }
                playState = 1;
            }
        }
        boolean z = this.zzo;
        boolean zzg2 = zzg(j);
        this.zzo = zzg2;
        if (z && !zzg2 && playState != 1) {
            zzqq zzqq = this.zza;
            int i = this.zzd;
            long zzu2 = zzfx.zzu(this.zzh);
            zzrm zzrm = (zzrm) zzqq;
            zzrr zzrr = zzrm.zza;
            if (zzrr.zzq != null) {
                ((zzrw) zzrm.zza.zzq).zza.zzc.zzx(i, zzu2, SystemClock.elapsedRealtime() - zzrr.zzV);
            }
        }
        return true;
    }

    public final long zza(boolean z) {
        long j;
        Method method;
        zzqr zzqr = this;
        AudioTrack audioTrack = zzqr.zzc;
        audioTrack.getClass();
        if (audioTrack.getPlayState() == 3) {
            long nanoTime = System.nanoTime() / 1000;
            if (nanoTime - zzqr.zzl >= 30000) {
                long zzm2 = zzm();
                if (zzm2 != 0) {
                    zzqr.zzb[zzqr.zzv] = zzfx.zzq(zzm2, zzqr.zzi) - nanoTime;
                    zzqr.zzv = (zzqr.zzv + 1) % 10;
                    int i = zzqr.zzw;
                    if (i < 10) {
                        zzqr.zzw = i + 1;
                    }
                    zzqr.zzl = nanoTime;
                    zzqr.zzk = 0;
                    int i2 = 0;
                    while (true) {
                        int i3 = zzqr.zzw;
                        if (i2 >= i3) {
                            break;
                        }
                        zzqr.zzk += zzqr.zzb[i2] / ((long) i3);
                        i2++;
                    }
                }
            }
            if (!zzqr.zzg) {
                zzqp zzqp = zzqr.zze;
                zzqp.getClass();
                if (zzqp.zzg(nanoTime)) {
                    long zzb2 = zzqp.zzb();
                    long zza2 = zzqp.zza();
                    long zzm3 = zzm();
                    if (Math.abs(zzb2 - nanoTime) > 5000000) {
                        zzrr zzrr = ((zzrm) zzqr.zza).zza;
                        long zzC2 = zzrr.zzK();
                        long zzD2 = zzrr.zzL();
                        StringBuilder sb = new StringBuilder("Spurious audio timestamp (system clock mismatch): ");
                        sb.append(zza2);
                        String str = ", ";
                        sb.append(str);
                        sb.append(zzb2);
                        sb.append(str);
                        sb.append(nanoTime);
                        sb.append(str);
                        sb.append(zzm3);
                        sb.append(str);
                        sb.append(zzC2);
                        sb.append(str);
                        sb.append(zzD2);
                        zzfe.zzf("DefaultAudioSink", sb.toString());
                        zzqp.zzd();
                    } else {
                        zzqr zzqr2 = zzqr;
                        String str2 = ", ";
                        if (Math.abs(zzfx.zzs(zza2, zzqr2.zzf) - zzm3) > 5000000) {
                            zzrr zzrr2 = ((zzrm) zzqr2.zza).zza;
                            zzfe.zzf("DefaultAudioSink", "Spurious audio timestamp (frame position mismatch): " + zza2 + str2 + zzb2 + str2 + nanoTime + str2 + zzm3 + str2 + zzrr2.zzK() + str2 + zzrr2.zzL());
                            zzqp.zzd();
                        } else {
                            zzqp.zzc();
                        }
                    }
                    zzqr = this;
                }
                if (zzqr.zzp && (method = zzqr.zzm) != null && nanoTime - zzqr.zzq >= 500000) {
                    try {
                        AudioTrack audioTrack2 = zzqr.zzc;
                        audioTrack2.getClass();
                        int i4 = zzfx.zza;
                        long intValue = (((long) ((Integer) method.invoke(audioTrack2, new Object[0])).intValue()) * 1000) - zzqr.zzh;
                        zzqr.zzn = intValue;
                        long max = Math.max(intValue, 0);
                        zzqr.zzn = max;
                        if (max > 5000000) {
                            zzfe.zzf("DefaultAudioSink", "Ignoring impossibly large audio latency: " + max);
                            zzqr.zzn = 0;
                        }
                    } catch (Exception unused) {
                        zzqr.zzm = null;
                    }
                    zzqr.zzq = nanoTime;
                }
            }
        }
        long nanoTime2 = System.nanoTime() / 1000;
        zzqp zzqp2 = zzqr.zze;
        zzqp2.getClass();
        boolean zzf2 = zzqp2.zzf();
        if (zzf2) {
            j = zzfx.zzs(zzqp2.zza(), zzqr.zzf) + zzfx.zzp(nanoTime2 - zzqp2.zzb(), zzqr.zzi);
        } else {
            if (zzqr.zzw == 0) {
                j = zzm();
            } else {
                j = zzfx.zzp(zzqr.zzk + nanoTime2, zzqr.zzi);
            }
            if (!z) {
                j = Math.max(0, j - zzqr.zzn);
            }
        }
        if (zzqr.zzD != zzf2) {
            zzqr.zzF = zzqr.zzC;
            zzqr.zzE = zzqr.zzB;
        }
        long j2 = nanoTime2 - zzqr.zzF;
        if (j2 < 1000000) {
            long j3 = (j2 * 1000) / 1000000;
            j = ((j * j3) + ((1000 - j3) * (zzqr.zzE + zzfx.zzp(j2, zzqr.zzi)))) / 1000;
        }
        if (!zzqr.zzj) {
            long j4 = zzqr.zzB;
            if (j > j4) {
                zzqr.zzj = true;
                int i5 = zzfx.zza;
                long currentTimeMillis = System.currentTimeMillis() - zzfx.zzu(zzfx.zzq(zzfx.zzu(j - j4), zzqr.zzi));
                zzrr zzrr3 = ((zzrm) zzqr.zza).zza;
                if (zzrr3.zzq != null) {
                    ((zzrw) zzrr3.zzq).zza.zzc.zzv(currentTimeMillis);
                }
            }
        }
        zzqr.zzC = nanoTime2;
        zzqr.zzB = j;
        zzqr.zzD = zzf2;
        return j;
    }
}
