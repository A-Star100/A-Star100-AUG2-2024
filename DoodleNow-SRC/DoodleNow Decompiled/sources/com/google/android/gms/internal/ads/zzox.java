package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.metrics.LogSessionId;
import android.media.metrics.MediaMetricsManager;
import android.media.metrics.PlaybackMetrics;
import android.media.metrics.PlaybackSession;
import android.media.metrics.TrackChangeEvent;
import android.os.SystemClock;
import android.util.Pair;
import com.facebook.react.views.text.ReactTextView$$ExternalSyntheticApiModelOutline0;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.drm.FrameworkMediaDrm$$ExternalSyntheticApiModelOutline0;
import java.io.IOException;
import java.util.HashMap;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzox implements zzms, zzoy {
    private final Context zza;
    private final zzoz zzb;
    private final PlaybackSession zzc;
    private final long zzd = SystemClock.elapsedRealtime();
    private final zzcw zze = new zzcw();
    private final zzcu zzf = new zzcu();
    private final HashMap zzg = new HashMap();
    private final HashMap zzh = new HashMap();
    private String zzi;
    private PlaybackMetrics.Builder zzj;
    private int zzk;
    private int zzl = 0;
    private int zzm = 0;
    private zzce zzn;
    private zzow zzo;
    private zzow zzp;
    private zzow zzq;
    private zzam zzr;
    private zzam zzs;
    private zzam zzt;
    private boolean zzu;
    private boolean zzv;
    private int zzw;
    private int zzx;
    private int zzy;
    private boolean zzz;

    private zzox(Context context, PlaybackSession playbackSession) {
        this.zza = context.getApplicationContext();
        this.zzc = playbackSession;
        zzov zzov = new zzov(zzov.zza);
        this.zzb = zzov;
        zzov.zzh(this);
    }

    public static zzox zzb(Context context) {
        MediaMetricsManager m = ReactTextView$$ExternalSyntheticApiModelOutline0.m(context.getSystemService("media_metrics"));
        if (m == null) {
            return null;
        }
        return new zzox(context, m.createPlaybackSession());
    }

    private static int zzr(int i) {
        switch (zzfx.zzj(i)) {
            case PlaybackException.ERROR_CODE_DRM_PROVISIONING_FAILED:
                return 24;
            case PlaybackException.ERROR_CODE_DRM_CONTENT_ERROR:
                return 28;
            case PlaybackException.ERROR_CODE_DRM_LICENSE_ACQUISITION_FAILED:
                return 25;
            case PlaybackException.ERROR_CODE_DRM_DISALLOWED_OPERATION:
                return 26;
            default:
                return 27;
        }
    }

    private final void zzs() {
        long j;
        long j2;
        PlaybackMetrics.Builder builder = this.zzj;
        if (builder != null && this.zzz) {
            PlaybackMetrics.Builder unused = builder.setAudioUnderrunCount(this.zzy);
            PlaybackMetrics.Builder unused2 = this.zzj.setVideoFramesDropped(this.zzw);
            PlaybackMetrics.Builder unused3 = this.zzj.setVideoFramesPlayed(this.zzx);
            Long l = (Long) this.zzg.get(this.zzi);
            PlaybackMetrics.Builder builder2 = this.zzj;
            if (l == null) {
                j = 0;
            } else {
                j = l.longValue();
            }
            PlaybackMetrics.Builder unused4 = builder2.setNetworkTransferDurationMillis(j);
            Long l2 = (Long) this.zzh.get(this.zzi);
            PlaybackMetrics.Builder builder3 = this.zzj;
            if (l2 == null) {
                j2 = 0;
            } else {
                j2 = l2.longValue();
            }
            PlaybackMetrics.Builder unused5 = builder3.setNetworkBytesRead(j2);
            PlaybackMetrics.Builder unused6 = this.zzj.setStreamSource((l2 == null || l2.longValue() <= 0) ? 0 : 1);
            this.zzc.reportPlaybackMetrics(this.zzj.build());
        }
        this.zzj = null;
        this.zzi = null;
        this.zzy = 0;
        this.zzw = 0;
        this.zzx = 0;
        this.zzr = null;
        this.zzs = null;
        this.zzt = null;
        this.zzz = false;
    }

    private final void zzt(long j, zzam zzam, int i) {
        if (!zzfx.zzG(this.zzs, zzam)) {
            int i2 = this.zzs == null ? 1 : 0;
            this.zzs = zzam;
            zzx(0, j, zzam, i2);
        }
    }

    private final void zzu(long j, zzam zzam, int i) {
        if (!zzfx.zzG(this.zzt, zzam)) {
            int i2 = this.zzt == null ? 1 : 0;
            this.zzt = zzam;
            zzx(2, j, zzam, i2);
        }
    }

    @RequiresNonNull({"metricsBuilder"})
    private final void zzv(zzcx zzcx, zzvh zzvh) {
        int zza2;
        PlaybackMetrics.Builder builder = this.zzj;
        if (zzvh != null && (zza2 = zzcx.zza(zzvh.zza)) != -1) {
            int i = 0;
            zzcx.zzd(zza2, this.zzf, false);
            zzcx.zze(this.zzf.zzd, this.zze, 0);
            zzbi zzbi = this.zze.zze.zzd;
            int i2 = 2;
            if (zzbi != null) {
                int zzn2 = zzfx.zzn(zzbi.zzb);
                i = zzn2 != 0 ? zzn2 != 1 ? zzn2 != 2 ? 1 : 4 : 5 : 3;
            }
            PlaybackMetrics.Builder unused = builder.setStreamType(i);
            zzcw zzcw = this.zze;
            if (zzcw.zzo != C.TIME_UNSET && !zzcw.zzm && !zzcw.zzj && !zzcw.zzb()) {
                PlaybackMetrics.Builder unused2 = builder.setMediaDurationMillis(zzfx.zzu(this.zze.zzo));
            }
            if (true != this.zze.zzb()) {
                i2 = 1;
            }
            PlaybackMetrics.Builder unused3 = builder.setPlaybackType(i2);
            this.zzz = true;
        }
    }

    private final void zzw(long j, zzam zzam, int i) {
        if (!zzfx.zzG(this.zzr, zzam)) {
            int i2 = this.zzr == null ? 1 : 0;
            this.zzr = zzam;
            zzx(1, j, zzam, i2);
        }
    }

    private final void zzx(int i, long j, zzam zzam, int i2) {
        TrackChangeEvent.Builder m = FrameworkMediaDrm$$ExternalSyntheticApiModelOutline0.m(i).setTimeSinceCreatedMillis(j - this.zzd);
        if (zzam != null) {
            TrackChangeEvent.Builder unused = m.setTrackState(1);
            TrackChangeEvent.Builder unused2 = m.setTrackChangeReason(i2 != 1 ? 1 : 2);
            String str = zzam.zzl;
            if (str != null) {
                TrackChangeEvent.Builder unused3 = m.setContainerMimeType(str);
            }
            String str2 = zzam.zzm;
            if (str2 != null) {
                TrackChangeEvent.Builder unused4 = m.setSampleMimeType(str2);
            }
            String str3 = zzam.zzj;
            if (str3 != null) {
                TrackChangeEvent.Builder unused5 = m.setCodecName(str3);
            }
            int i3 = zzam.zzi;
            if (i3 != -1) {
                TrackChangeEvent.Builder unused6 = m.setBitrate(i3);
            }
            int i4 = zzam.zzr;
            if (i4 != -1) {
                TrackChangeEvent.Builder unused7 = m.setWidth(i4);
            }
            int i5 = zzam.zzs;
            if (i5 != -1) {
                TrackChangeEvent.Builder unused8 = m.setHeight(i5);
            }
            int i6 = zzam.zzz;
            if (i6 != -1) {
                TrackChangeEvent.Builder unused9 = m.setChannelCount(i6);
            }
            int i7 = zzam.zzA;
            if (i7 != -1) {
                TrackChangeEvent.Builder unused10 = m.setAudioSampleRate(i7);
            }
            String str4 = zzam.zzd;
            if (str4 != null) {
                int i8 = zzfx.zza;
                String[] split = str4.split("-", -1);
                Pair create = Pair.create(split[0], split.length >= 2 ? split[1] : null);
                TrackChangeEvent.Builder unused11 = m.setLanguage((String) create.first);
                if (create.second != null) {
                    TrackChangeEvent.Builder unused12 = m.setLanguageRegion((String) create.second);
                }
            }
            float f = zzam.zzt;
            if (f != -1.0f) {
                TrackChangeEvent.Builder unused13 = m.setVideoFrameRate(f);
            }
        } else {
            TrackChangeEvent.Builder unused14 = m.setTrackState(0);
        }
        this.zzz = true;
        this.zzc.reportTrackChangeEvent(m.build());
    }

    @EnsuresNonNullIf(expression = {"#1"}, result = true)
    private final boolean zzy(zzow zzow) {
        if (zzow == null) {
            return false;
        }
        return zzow.zzc.equals(this.zzb.zze());
    }

    public final LogSessionId zza() {
        return this.zzc.getSessionId();
    }

    public final void zzc(zzmq zzmq, String str) {
        zzvh zzvh = zzmq.zzd;
        if (zzvh == null || !zzvh.zzb()) {
            zzs();
            this.zzi = str;
            this.zzj = FrameworkMediaDrm$$ExternalSyntheticApiModelOutline0.m().setPlayerName("AndroidXMedia3").setPlayerVersion("1.3.0");
            zzv(zzmq.zzb, zzmq.zzd);
        }
    }

    public final void zzd(zzmq zzmq, String str, boolean z) {
        zzvh zzvh = zzmq.zzd;
        if ((zzvh == null || !zzvh.zzb()) && str.equals(this.zzi)) {
            zzs();
        }
        this.zzg.remove(str);
        this.zzh.remove(str);
    }

    public final /* synthetic */ void zze(zzmq zzmq, zzam zzam, zzis zzis) {
    }

    public final void zzf(zzmq zzmq, int i, long j, long j2) {
        long j3;
        zzvh zzvh = zzmq.zzd;
        if (zzvh != null) {
            zzoz zzoz = this.zzb;
            zzcx zzcx = zzmq.zzb;
            HashMap hashMap = this.zzh;
            String zzf2 = zzoz.zzf(zzcx, zzvh);
            Long l = (Long) hashMap.get(zzf2);
            Long l2 = (Long) this.zzg.get(zzf2);
            HashMap hashMap2 = this.zzh;
            long j4 = 0;
            if (l == null) {
                j3 = 0;
            } else {
                j3 = l.longValue();
            }
            hashMap2.put(zzf2, Long.valueOf(j3 + j));
            HashMap hashMap3 = this.zzg;
            if (l2 != null) {
                j4 = l2.longValue();
            }
            hashMap3.put(zzf2, Long.valueOf(j4 + ((long) i)));
        }
    }

    public final void zzg(zzmq zzmq, zzvd zzvd) {
        zzvh zzvh = zzmq.zzd;
        if (zzvh != null) {
            zzam zzam = zzvd.zzb;
            zzam.getClass();
            zzow zzow = new zzow(zzam, 0, this.zzb.zzf(zzmq.zzb, zzvh));
            int i = zzvd.zza;
            if (i != 0) {
                if (i == 1) {
                    this.zzp = zzow;
                    return;
                } else if (i != 2) {
                    if (i == 3) {
                        this.zzq = zzow;
                        return;
                    }
                    return;
                }
            }
            this.zzo = zzow;
        }
    }

    public final /* synthetic */ void zzh(zzmq zzmq, int i, long j) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:129:0x01eb, code lost:
        if (r8 != 1) goto L_0x01ef;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzi(com.google.android.gms.internal.ads.zzco r19, com.google.android.gms.internal.ads.zzmr r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r20
            int r2 = r20.zzb()
            if (r2 != 0) goto L_0x000c
            goto L_0x03c7
        L_0x000c:
            r2 = 0
            r3 = r2
        L_0x000e:
            int r4 = r20.zzb()
            r5 = 11
            if (r3 >= r4) goto L_0x0038
            int r4 = r1.zza(r3)
            com.google.android.gms.internal.ads.zzmq r6 = r1.zzc(r4)
            if (r4 != 0) goto L_0x0026
            com.google.android.gms.internal.ads.zzoz r4 = r0.zzb
            r4.zzk(r6)
            goto L_0x0035
        L_0x0026:
            if (r4 != r5) goto L_0x0030
            com.google.android.gms.internal.ads.zzoz r4 = r0.zzb
            int r5 = r0.zzk
            r4.zzj(r6, r5)
            goto L_0x0035
        L_0x0030:
            com.google.android.gms.internal.ads.zzoz r4 = r0.zzb
            r4.zzi(r6)
        L_0x0035:
            int r3 = r3 + 1
            goto L_0x000e
        L_0x0038:
            long r3 = android.os.SystemClock.elapsedRealtime()
            boolean r6 = r1.zzd(r2)
            if (r6 == 0) goto L_0x0051
            com.google.android.gms.internal.ads.zzmq r6 = r1.zzc(r2)
            android.media.metrics.PlaybackMetrics$Builder r7 = r0.zzj
            if (r7 == 0) goto L_0x0051
            com.google.android.gms.internal.ads.zzcx r7 = r6.zzb
            com.google.android.gms.internal.ads.zzvh r6 = r6.zzd
            r0.zzv(r7, r6)
        L_0x0051:
            r6 = 2
            boolean r7 = r1.zzd(r6)
            r9 = 3
            r10 = 0
            r11 = 1
            if (r7 == 0) goto L_0x00c9
            android.media.metrics.PlaybackMetrics$Builder r7 = r0.zzj
            if (r7 == 0) goto L_0x00c9
            com.google.android.gms.internal.ads.zzdk r7 = r19.zzo()
            com.google.android.gms.internal.ads.zzfzn r7 = r7.zza()
            int r12 = r7.size()
            r13 = r2
        L_0x006c:
            if (r13 >= r12) goto L_0x0092
            java.lang.Object r14 = r7.get(r13)
            com.google.android.gms.internal.ads.zzdj r14 = (com.google.android.gms.internal.ads.zzdj) r14
            r15 = r2
        L_0x0075:
            int r5 = r14.zzb
            int r16 = r13 + 1
            if (r15 >= r5) goto L_0x008d
            boolean r5 = r14.zzd(r15)
            if (r5 == 0) goto L_0x008a
            com.google.android.gms.internal.ads.zzam r5 = r14.zzb(r15)
            com.google.android.gms.internal.ads.zzae r5 = r5.zzp
            if (r5 == 0) goto L_0x008a
            goto L_0x0093
        L_0x008a:
            int r15 = r15 + 1
            goto L_0x0075
        L_0x008d:
            r13 = r16
            r5 = 11
            goto L_0x006c
        L_0x0092:
            r5 = r10
        L_0x0093:
            if (r5 == 0) goto L_0x00c9
            android.media.metrics.PlaybackMetrics$Builder r7 = r0.zzj
            int r12 = com.google.android.gms.internal.ads.zzfx.zza
            r12 = r2
        L_0x009a:
            int r13 = r5.zzb
            if (r12 >= r13) goto L_0x00c5
            com.google.android.gms.internal.ads.zzad r13 = r5.zza(r12)
            java.util.UUID r13 = r13.zza
            java.util.UUID r14 = com.google.android.gms.internal.ads.zzo.zzd
            boolean r14 = r13.equals(r14)
            if (r14 == 0) goto L_0x00ae
            r5 = r9
            goto L_0x00c6
        L_0x00ae:
            java.util.UUID r14 = com.google.android.gms.internal.ads.zzo.zze
            boolean r14 = r13.equals(r14)
            if (r14 == 0) goto L_0x00b8
            r5 = r6
            goto L_0x00c6
        L_0x00b8:
            java.util.UUID r14 = com.google.android.gms.internal.ads.zzo.zzc
            boolean r13 = r13.equals(r14)
            if (r13 == 0) goto L_0x00c2
            r5 = 6
            goto L_0x00c6
        L_0x00c2:
            int r12 = r12 + 1
            goto L_0x009a
        L_0x00c5:
            r5 = r11
        L_0x00c6:
            android.media.metrics.PlaybackMetrics.Builder unused = r7.setDrmType(r5)
        L_0x00c9:
            r5 = 1011(0x3f3, float:1.417E-42)
            boolean r5 = r1.zzd(r5)
            if (r5 == 0) goto L_0x00d6
            int r5 = r0.zzy
            int r5 = r5 + r11
            r0.zzy = r5
        L_0x00d6:
            com.google.android.gms.internal.ads.zzce r5 = r0.zzn
            r16 = 9
            if (r5 != 0) goto L_0x00de
            goto L_0x0277
        L_0x00de:
            android.content.Context r7 = r0.zza
            int r8 = r5.zzb
            r12 = 1001(0x3e9, float:1.403E-42)
            if (r8 != r12) goto L_0x00eb
            r7 = 20
        L_0x00e8:
            r8 = r2
            goto L_0x0252
        L_0x00eb:
            r8 = r5
            com.google.android.gms.internal.ads.zziz r8 = (com.google.android.gms.internal.ads.zziz) r8
            int r12 = r8.zze
            if (r12 != r11) goto L_0x00f4
            r12 = r11
            goto L_0x00f5
        L_0x00f4:
            r12 = r2
        L_0x00f5:
            int r8 = r8.zzi
            java.lang.Throwable r13 = r5.getCause()
            r13.getClass()
            boolean r14 = r13 instanceof java.io.IOException
            r15 = 23
            if (r14 == 0) goto L_0x01e5
            boolean r8 = r13 instanceof com.google.android.gms.internal.ads.zzhr
            if (r8 == 0) goto L_0x0110
            com.google.android.gms.internal.ads.zzhr r13 = (com.google.android.gms.internal.ads.zzhr) r13
            int r7 = r13.zzd
            r8 = r7
            r7 = 5
            goto L_0x0252
        L_0x0110:
            boolean r8 = r13 instanceof com.google.android.gms.internal.ads.zzhq
            if (r8 != 0) goto L_0x01e0
            boolean r8 = r13 instanceof com.google.android.gms.internal.ads.zzcc
            if (r8 == 0) goto L_0x011a
            goto L_0x01e0
        L_0x011a:
            boolean r8 = r13 instanceof com.google.android.gms.internal.ads.zzhp
            if (r8 != 0) goto L_0x01ad
            boolean r12 = r13 instanceof com.google.android.gms.internal.ads.zzhz
            if (r12 == 0) goto L_0x0124
            goto L_0x01ad
        L_0x0124:
            int r7 = r5.zzb
            r8 = 1002(0x3ea, float:1.404E-42)
            if (r7 != r8) goto L_0x012d
            r7 = 21
            goto L_0x00e8
        L_0x012d:
            boolean r7 = r13 instanceof com.google.android.gms.internal.ads.zzse
            if (r7 == 0) goto L_0x0179
            java.lang.Throwable r7 = r13.getCause()
            r7.getClass()
            int r8 = com.google.android.gms.internal.ads.zzfx.zza
            boolean r8 = r7 instanceof android.media.MediaDrm.MediaDrmStateException
            if (r8 == 0) goto L_0x014e
            android.media.MediaDrm$MediaDrmStateException r7 = (android.media.MediaDrm.MediaDrmStateException) r7
            java.lang.String r7 = r7.getDiagnosticInfo()
            int r7 = com.google.android.gms.internal.ads.zzfx.zzk(r7)
            int r8 = zzr(r7)
            goto L_0x021c
        L_0x014e:
            int r8 = com.google.android.gms.internal.ads.zzfx.zza
            if (r8 < r15) goto L_0x0159
            boolean r8 = r7 instanceof android.media.MediaDrmResetException
            if (r8 == 0) goto L_0x0159
            r7 = 27
            goto L_0x00e8
        L_0x0159:
            boolean r8 = r7 instanceof android.media.NotProvisionedException
            if (r8 == 0) goto L_0x0160
            r7 = 24
            goto L_0x00e8
        L_0x0160:
            boolean r8 = r7 instanceof android.media.DeniedByServerException
            if (r8 == 0) goto L_0x0167
            r7 = 29
            goto L_0x00e8
        L_0x0167:
            boolean r8 = r7 instanceof com.google.android.gms.internal.ads.zzsp
            if (r8 == 0) goto L_0x016d
            goto L_0x01fb
        L_0x016d:
            boolean r7 = r7 instanceof com.google.android.gms.internal.ads.zzsc
            if (r7 == 0) goto L_0x0175
            r7 = 28
            goto L_0x00e8
        L_0x0175:
            r7 = 30
            goto L_0x00e8
        L_0x0179:
            boolean r7 = r13 instanceof com.google.android.gms.internal.ads.zzhl
            if (r7 == 0) goto L_0x01a8
            java.lang.Throwable r7 = r13.getCause()
            boolean r7 = r7 instanceof java.io.FileNotFoundException
            if (r7 == 0) goto L_0x01a8
            java.lang.Throwable r7 = r13.getCause()
            r7.getClass()
            java.lang.Throwable r7 = r7.getCause()
            int r8 = com.google.android.gms.internal.ads.zzfx.zza
            boolean r8 = r7 instanceof android.system.ErrnoException
            r12 = 31
            if (r8 == 0) goto L_0x01a4
            android.system.ErrnoException r7 = (android.system.ErrnoException) r7
            int r7 = r7.errno
            int r8 = android.system.OsConstants.EACCES
            if (r7 != r8) goto L_0x01a4
            r7 = 32
            goto L_0x00e8
        L_0x01a4:
            r8 = r2
            r7 = r12
            goto L_0x0252
        L_0x01a8:
            r8 = r2
            r7 = r16
            goto L_0x0252
        L_0x01ad:
            com.google.android.gms.internal.ads.zzfm r7 = com.google.android.gms.internal.ads.zzfm.zzb(r7)
            int r7 = r7.zza()
            if (r7 != r11) goto L_0x01bb
            r8 = r2
            r7 = r9
            goto L_0x0252
        L_0x01bb:
            java.lang.Throwable r7 = r13.getCause()
            boolean r12 = r7 instanceof java.net.UnknownHostException
            if (r12 == 0) goto L_0x01c7
            r8 = r2
            r7 = 6
            goto L_0x0252
        L_0x01c7:
            boolean r7 = r7 instanceof java.net.SocketTimeoutException
            if (r7 == 0) goto L_0x01cf
            r8 = r2
            r7 = 7
            goto L_0x0252
        L_0x01cf:
            if (r8 == 0) goto L_0x01db
            com.google.android.gms.internal.ads.zzhp r13 = (com.google.android.gms.internal.ads.zzhp) r13
            int r7 = r13.zzc
            if (r7 != r11) goto L_0x01db
            r8 = r2
            r7 = 4
            goto L_0x0252
        L_0x01db:
            r8 = r2
            r7 = 8
            goto L_0x0252
        L_0x01e0:
            r8 = r2
            r7 = 11
            goto L_0x0252
        L_0x01e5:
            if (r12 == 0) goto L_0x01ef
            r7 = 35
            if (r8 == 0) goto L_0x00e8
            if (r8 != r11) goto L_0x01ef
            goto L_0x00e8
        L_0x01ef:
            if (r12 == 0) goto L_0x01f7
            if (r8 != r9) goto L_0x01f7
            r7 = 15
            goto L_0x00e8
        L_0x01f7:
            if (r12 == 0) goto L_0x01fe
            if (r8 != r6) goto L_0x01fe
        L_0x01fb:
            r8 = r2
            r7 = r15
            goto L_0x0252
        L_0x01fe:
            boolean r7 = r13 instanceof com.google.android.gms.internal.ads.zztm
            if (r7 == 0) goto L_0x020e
            com.google.android.gms.internal.ads.zztm r13 = (com.google.android.gms.internal.ads.zztm) r13
            java.lang.String r7 = r13.zzd
            int r7 = com.google.android.gms.internal.ads.zzfx.zzk(r7)
            r8 = r7
            r7 = 13
            goto L_0x0252
        L_0x020e:
            boolean r7 = r13 instanceof com.google.android.gms.internal.ads.zzth
            r8 = 14
            if (r7 == 0) goto L_0x0222
            com.google.android.gms.internal.ads.zzth r13 = (com.google.android.gms.internal.ads.zzth) r13
            java.lang.String r7 = r13.zzb
            int r7 = com.google.android.gms.internal.ads.zzfx.zzk(r7)
        L_0x021c:
            r17 = r8
            r8 = r7
            r7 = r17
            goto L_0x0252
        L_0x0222:
            boolean r7 = r13 instanceof java.lang.OutOfMemoryError
            if (r7 == 0) goto L_0x0229
            r7 = r8
            goto L_0x00e8
        L_0x0229:
            boolean r7 = r13 instanceof com.google.android.gms.internal.ads.zzqj
            if (r7 == 0) goto L_0x0234
            com.google.android.gms.internal.ads.zzqj r13 = (com.google.android.gms.internal.ads.zzqj) r13
            int r7 = r13.zza
            r8 = 17
            goto L_0x021c
        L_0x0234:
            boolean r7 = r13 instanceof com.google.android.gms.internal.ads.zzqm
            if (r7 == 0) goto L_0x023f
            com.google.android.gms.internal.ads.zzqm r13 = (com.google.android.gms.internal.ads.zzqm) r13
            int r7 = r13.zza
            r8 = 18
            goto L_0x021c
        L_0x023f:
            boolean r7 = r13 instanceof android.media.MediaCodec.CryptoException
            if (r7 == 0) goto L_0x024e
            android.media.MediaCodec$CryptoException r13 = (android.media.MediaCodec.CryptoException) r13
            int r7 = r13.getErrorCode()
            int r8 = zzr(r7)
            goto L_0x021c
        L_0x024e:
            r7 = 22
            goto L_0x00e8
        L_0x0252:
            android.media.metrics.PlaybackSession r12 = r0.zzc
            android.media.metrics.PlaybackErrorEvent$Builder r13 = com.google.android.exoplayer2.drm.FrameworkMediaDrm$$ExternalSyntheticApiModelOutline0.m()
            long r14 = r0.zzd
            long r14 = r3 - r14
            android.media.metrics.PlaybackErrorEvent$Builder r13 = r13.setTimeSinceCreatedMillis(r14)
            android.media.metrics.PlaybackErrorEvent$Builder r7 = r13.setErrorCode(r7)
            android.media.metrics.PlaybackErrorEvent$Builder r7 = r7.setSubErrorCode(r8)
            android.media.metrics.PlaybackErrorEvent$Builder r5 = r7.setException(r5)
            android.media.metrics.PlaybackErrorEvent r5 = r5.build()
            r12.reportPlaybackErrorEvent(r5)
            r0.zzz = r11
            r0.zzn = r10
        L_0x0277:
            boolean r5 = r1.zzd(r6)
            if (r5 == 0) goto L_0x02a3
            com.google.android.gms.internal.ads.zzdk r5 = r19.zzo()
            boolean r7 = r5.zzb(r6)
            boolean r8 = r5.zzb(r11)
            boolean r5 = r5.zzb(r9)
            if (r7 != 0) goto L_0x0294
            if (r8 != 0) goto L_0x0294
            if (r5 == 0) goto L_0x02a3
            r5 = r11
        L_0x0294:
            if (r7 != 0) goto L_0x0299
            r0.zzw(r3, r10, r2)
        L_0x0299:
            if (r8 != 0) goto L_0x029e
            r0.zzt(r3, r10, r2)
        L_0x029e:
            if (r5 != 0) goto L_0x02a3
            r0.zzu(r3, r10, r2)
        L_0x02a3:
            com.google.android.gms.internal.ads.zzow r5 = r0.zzo
            boolean r5 = r0.zzy(r5)
            if (r5 == 0) goto L_0x02bb
            com.google.android.gms.internal.ads.zzow r5 = r0.zzo
            com.google.android.gms.internal.ads.zzam r7 = r5.zza
            int r8 = r7.zzs
            r12 = -1
            if (r8 == r12) goto L_0x02bb
            int r5 = r5.zzb
            r0.zzw(r3, r7, r2)
            r0.zzo = r10
        L_0x02bb:
            com.google.android.gms.internal.ads.zzow r5 = r0.zzp
            boolean r5 = r0.zzy(r5)
            if (r5 == 0) goto L_0x02ce
            com.google.android.gms.internal.ads.zzow r5 = r0.zzp
            com.google.android.gms.internal.ads.zzam r7 = r5.zza
            int r5 = r5.zzb
            r0.zzt(r3, r7, r2)
            r0.zzp = r10
        L_0x02ce:
            com.google.android.gms.internal.ads.zzow r5 = r0.zzq
            boolean r5 = r0.zzy(r5)
            if (r5 == 0) goto L_0x02e1
            com.google.android.gms.internal.ads.zzow r5 = r0.zzq
            com.google.android.gms.internal.ads.zzam r7 = r5.zza
            int r5 = r5.zzb
            r0.zzu(r3, r7, r2)
            r0.zzq = r10
        L_0x02e1:
            android.content.Context r5 = r0.zza
            com.google.android.gms.internal.ads.zzfm r5 = com.google.android.gms.internal.ads.zzfm.zzb(r5)
            int r5 = r5.zza()
            switch(r5) {
                case 0: goto L_0x0302;
                case 1: goto L_0x02ff;
                case 2: goto L_0x02fd;
                case 3: goto L_0x02fb;
                case 4: goto L_0x02f9;
                case 5: goto L_0x02f7;
                case 6: goto L_0x02ee;
                case 7: goto L_0x02f5;
                case 8: goto L_0x02ee;
                case 9: goto L_0x02f2;
                case 10: goto L_0x02f0;
                default: goto L_0x02ee;
            }
        L_0x02ee:
            r13 = r11
            goto L_0x0303
        L_0x02f0:
            r13 = 7
            goto L_0x0303
        L_0x02f2:
            r13 = 8
            goto L_0x0303
        L_0x02f5:
            r13 = r9
            goto L_0x0303
        L_0x02f7:
            r13 = 6
            goto L_0x0303
        L_0x02f9:
            r13 = 5
            goto L_0x0303
        L_0x02fb:
            r13 = 4
            goto L_0x0303
        L_0x02fd:
            r13 = r6
            goto L_0x0303
        L_0x02ff:
            r13 = r16
            goto L_0x0303
        L_0x0302:
            r13 = r2
        L_0x0303:
            int r5 = r0.zzm
            if (r13 == r5) goto L_0x0322
            r0.zzm = r13
            android.media.metrics.PlaybackSession r5 = r0.zzc
            android.media.metrics.NetworkEvent$Builder r7 = com.google.android.exoplayer2.drm.FrameworkMediaDrm$$ExternalSyntheticApiModelOutline0.m()
            android.media.metrics.NetworkEvent$Builder r7 = r7.setNetworkType(r13)
            long r12 = r0.zzd
            long r12 = r3 - r12
            android.media.metrics.NetworkEvent$Builder r7 = r7.setTimeSinceCreatedMillis(r12)
            android.media.metrics.NetworkEvent r7 = r7.build()
            r5.reportNetworkEvent(r7)
        L_0x0322:
            int r5 = r19.zzf()
            if (r5 == r6) goto L_0x032a
            r0.zzu = r2
        L_0x032a:
            r5 = r19
            com.google.android.gms.internal.ads.zzml r5 = (com.google.android.gms.internal.ads.zzml) r5
            com.google.android.gms.internal.ads.zziz r5 = r5.zzC()
            r7 = 10
            if (r5 != 0) goto L_0x0339
            r0.zzv = r2
            goto L_0x0341
        L_0x0339:
            boolean r2 = r1.zzd(r7)
            if (r2 == 0) goto L_0x0341
            r0.zzv = r11
        L_0x0341:
            int r2 = r19.zzf()
            boolean r5 = r0.zzu
            if (r5 == 0) goto L_0x034b
            r5 = 5
            goto L_0x0394
        L_0x034b:
            boolean r5 = r0.zzv
            if (r5 == 0) goto L_0x0352
            r5 = 13
            goto L_0x0394
        L_0x0352:
            r5 = 4
            if (r2 != r5) goto L_0x0358
            r5 = 11
            goto L_0x0394
        L_0x0358:
            if (r2 != r6) goto L_0x0375
            int r2 = r0.zzl
            if (r2 == 0) goto L_0x0373
            if (r2 != r6) goto L_0x0361
            goto L_0x0373
        L_0x0361:
            boolean r2 = r19.zzv()
            if (r2 != 0) goto L_0x0369
            r5 = 7
            goto L_0x0394
        L_0x0369:
            int r2 = r19.zzg()
            if (r2 == 0) goto L_0x0371
            r5 = r7
            goto L_0x0394
        L_0x0371:
            r5 = 6
            goto L_0x0394
        L_0x0373:
            r5 = r6
            goto L_0x0394
        L_0x0375:
            if (r2 != r9) goto L_0x0389
            boolean r2 = r19.zzv()
            if (r2 != 0) goto L_0x037e
            goto L_0x0394
        L_0x037e:
            int r2 = r19.zzg()
            if (r2 == 0) goto L_0x0387
            r5 = r16
            goto L_0x0394
        L_0x0387:
            r5 = r9
            goto L_0x0394
        L_0x0389:
            if (r2 != r11) goto L_0x0392
            int r2 = r0.zzl
            if (r2 == 0) goto L_0x0392
            r5 = 12
            goto L_0x0394
        L_0x0392:
            int r5 = r0.zzl
        L_0x0394:
            int r2 = r0.zzl
            if (r2 == r5) goto L_0x03b6
            r0.zzl = r5
            r0.zzz = r11
            android.media.metrics.PlaybackSession r2 = r0.zzc
            android.media.metrics.PlaybackStateEvent$Builder r5 = com.google.android.exoplayer2.drm.FrameworkMediaDrm$$ExternalSyntheticApiModelOutline0.m()
            int r6 = r0.zzl
            android.media.metrics.PlaybackStateEvent$Builder r5 = r5.setState(r6)
            long r6 = r0.zzd
            long r3 = r3 - r6
            android.media.metrics.PlaybackStateEvent$Builder r3 = r5.setTimeSinceCreatedMillis(r3)
            android.media.metrics.PlaybackStateEvent r3 = r3.build()
            r2.reportPlaybackStateEvent(r3)
        L_0x03b6:
            r2 = 1028(0x404, float:1.44E-42)
            boolean r3 = r1.zzd(r2)
            if (r3 == 0) goto L_0x03c7
            com.google.android.gms.internal.ads.zzoz r3 = r0.zzb
            com.google.android.gms.internal.ads.zzmq r1 = r1.zzc(r2)
            r3.zzg(r1)
        L_0x03c7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzox.zzi(com.google.android.gms.internal.ads.zzco, com.google.android.gms.internal.ads.zzmr):void");
    }

    public final void zzj(zzmq zzmq, zzuy zzuy, zzvd zzvd, IOException iOException, boolean z) {
    }

    public final /* synthetic */ void zzk(zzmq zzmq, int i) {
    }

    public final void zzl(zzmq zzmq, zzce zzce) {
        this.zzn = zzce;
    }

    public final void zzm(zzmq zzmq, zzcn zzcn, zzcn zzcn2, int i) {
        if (i == 1) {
            this.zzu = true;
            i = 1;
        }
        this.zzk = i;
    }

    public final /* synthetic */ void zzn(zzmq zzmq, Object obj, long j) {
    }

    public final void zzo(zzmq zzmq, zzir zzir) {
        this.zzw += zzir.zzg;
        this.zzx += zzir.zze;
    }

    public final /* synthetic */ void zzp(zzmq zzmq, zzam zzam, zzis zzis) {
    }

    public final void zzq(zzmq zzmq, zzdp zzdp) {
        zzow zzow = this.zzo;
        if (zzow != null) {
            zzam zzam = zzow.zza;
            if (zzam.zzs == -1) {
                zzak zzb2 = zzam.zzb();
                zzb2.zzab(zzdp.zzc);
                zzb2.zzI(zzdp.zzd);
                this.zzo = new zzow(zzb2.zzac(), 0, zzow.zzc);
            }
        }
    }
}
