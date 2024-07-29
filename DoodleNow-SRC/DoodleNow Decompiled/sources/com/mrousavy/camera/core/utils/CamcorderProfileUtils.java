package com.mrousavy.camera.core.utils;

import android.media.CamcorderProfile;
import android.media.EncoderProfiles;
import android.os.Build;
import android.util.Size;
import com.rnfs.Downloader$$ExternalSyntheticApiModelOutline0;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/mrousavy/camera/core/utils/CamcorderProfileUtils;", "", "()V", "Companion", "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: CamcorderProfileUtils.kt */
public final class CamcorderProfileUtils {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u001d\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0002¨\u0006\u0011"}, d2 = {"Lcom/mrousavy/camera/core/utils/CamcorderProfileUtils$Companion;", "", "()V", "findClosestCamcorderProfileQuality", "", "cameraId", "", "resolution", "Landroid/util/Size;", "allowLargerSize", "", "getMaximumFps", "size", "(Ljava/lang/String;Landroid/util/Size;)Ljava/lang/Integer;", "getMaximumVideoSize", "getResolutionForCamcorderProfileQuality", "camcorderProfile", "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: CamcorderProfileUtils.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final int getResolutionForCamcorderProfileQuality(int i) {
            switch (i) {
                case 2:
                    return 25344;
                case 3:
                    return 101376;
                case 4:
                    return 345600;
                case 5:
                    return 921600;
                case 6:
                    return 2073600;
                case 7:
                    return 76800;
                case 8:
                    return 8294400;
                case 9:
                    return 307200;
                case 10:
                    return 8847360;
                case 11:
                    return 3686400;
                case 12:
                    return 2211840;
                case 13:
                    return 33177600;
                default:
                    throw new Error("Invalid CamcorderProfile \"" + i + "\"!");
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: java.util.List} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final int findClosestCamcorderProfileQuality(java.lang.String r6, android.util.Size r7, boolean r8) {
            /*
                r5 = this;
                int r0 = r7.getWidth()
                int r7 = r7.getHeight()
                int r0 = r0 * r7
                java.lang.Integer r6 = kotlin.text.StringsKt.toIntOrNull(r6)
                kotlin.ranges.IntRange r7 = new kotlin.ranges.IntRange
                r1 = 2
                r2 = 13
                r7.<init>(r1, r2)
                java.lang.Iterable r7 = (java.lang.Iterable) r7
                java.util.ArrayList r1 = new java.util.ArrayList
                r1.<init>()
                java.util.Collection r1 = (java.util.Collection) r1
                java.util.Iterator r7 = r7.iterator()
            L_0x0022:
                boolean r2 = r7.hasNext()
                if (r2 == 0) goto L_0x0048
                java.lang.Object r2 = r7.next()
                r3 = r2
                java.lang.Number r3 = (java.lang.Number) r3
                int r3 = r3.intValue()
                if (r6 == 0) goto L_0x003e
                int r4 = r6.intValue()
                boolean r3 = android.media.CamcorderProfile.hasProfile(r4, r3)
                goto L_0x0042
            L_0x003e:
                boolean r3 = android.media.CamcorderProfile.hasProfile(r3)
            L_0x0042:
                if (r3 == 0) goto L_0x0022
                r1.add(r2)
                goto L_0x0022
            L_0x0048:
                java.util.List r1 = (java.util.List) r1
                if (r8 != 0) goto L_0x0079
                java.lang.Iterable r1 = (java.lang.Iterable) r1
                java.util.ArrayList r6 = new java.util.ArrayList
                r6.<init>()
                java.util.Collection r6 = (java.util.Collection) r6
                java.util.Iterator r7 = r1.iterator()
            L_0x0059:
                boolean r8 = r7.hasNext()
                if (r8 == 0) goto L_0x0076
                java.lang.Object r8 = r7.next()
                r1 = r8
                java.lang.Number r1 = (java.lang.Number) r1
                int r1 = r1.intValue()
                com.mrousavy.camera.core.utils.CamcorderProfileUtils$Companion r2 = com.mrousavy.camera.core.utils.CamcorderProfileUtils.Companion
                int r1 = r2.getResolutionForCamcorderProfileQuality(r1)
                if (r1 > r0) goto L_0x0059
                r6.add(r8)
                goto L_0x0059
            L_0x0076:
                r1 = r6
                java.util.List r1 = (java.util.List) r1
            L_0x0079:
                java.lang.Iterable r1 = (java.lang.Iterable) r1
                java.util.Iterator r6 = r1.iterator()
                boolean r7 = r6.hasNext()
                if (r7 == 0) goto L_0x00c9
                java.lang.Object r7 = r6.next()
                boolean r8 = r6.hasNext()
                if (r8 != 0) goto L_0x0090
                goto L_0x00c2
            L_0x0090:
                r8 = r7
                java.lang.Number r8 = (java.lang.Number) r8
                int r8 = r8.intValue()
                com.mrousavy.camera.core.utils.CamcorderProfileUtils$Companion r1 = com.mrousavy.camera.core.utils.CamcorderProfileUtils.Companion
                int r8 = r1.getResolutionForCamcorderProfileQuality(r8)
                int r8 = r8 - r0
                int r8 = java.lang.Math.abs(r8)
            L_0x00a2:
                java.lang.Object r1 = r6.next()
                r2 = r1
                java.lang.Number r2 = (java.lang.Number) r2
                int r2 = r2.intValue()
                com.mrousavy.camera.core.utils.CamcorderProfileUtils$Companion r3 = com.mrousavy.camera.core.utils.CamcorderProfileUtils.Companion
                int r2 = r3.getResolutionForCamcorderProfileQuality(r2)
                int r2 = r2 - r0
                int r2 = java.lang.Math.abs(r2)
                if (r8 <= r2) goto L_0x00bc
                r7 = r1
                r8 = r2
            L_0x00bc:
                boolean r1 = r6.hasNext()
                if (r1 != 0) goto L_0x00a2
            L_0x00c2:
                java.lang.Number r7 = (java.lang.Number) r7
                int r6 = r7.intValue()
                return r6
            L_0x00c9:
                java.util.NoSuchElementException r6 = new java.util.NoSuchElementException
                r6.<init>()
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mrousavy.camera.core.utils.CamcorderProfileUtils.Companion.findClosestCamcorderProfileQuality(java.lang.String, android.util.Size, boolean):int");
        }

        public final Size getMaximumVideoSize(String str) {
            EncoderProfiles m;
            Object obj;
            Intrinsics.checkNotNullParameter(str, "cameraId");
            try {
                if (Build.VERSION.SDK_INT >= 31 && (m = CamcorderProfile.getAll(str, 1)) != null) {
                    List m2 = m.getVideoProfiles();
                    Intrinsics.checkNotNullExpressionValue(m2, "getVideoProfiles(...)");
                    Iterator it = CollectionsKt.filterNotNull(m2).iterator();
                    if (!it.hasNext()) {
                        obj = null;
                    } else {
                        obj = it.next();
                        if (it.hasNext()) {
                            EncoderProfiles.VideoProfile m3 = Downloader$$ExternalSyntheticApiModelOutline0.m(obj);
                            int m$1 = m3.getWidth() * m3.getHeight();
                            do {
                                Object next = it.next();
                                EncoderProfiles.VideoProfile m4 = Downloader$$ExternalSyntheticApiModelOutline0.m(next);
                                int m$12 = m4.getWidth() * m4.getHeight();
                                if (m$1 < m$12) {
                                    obj = next;
                                    m$1 = m$12;
                                }
                            } while (it.hasNext());
                        }
                    }
                    EncoderProfiles.VideoProfile m5 = Downloader$$ExternalSyntheticApiModelOutline0.m(obj);
                    if (m5 != null) {
                        return new Size(m5.getWidth(), m5.getHeight());
                    }
                }
                Integer intOrNull = StringsKt.toIntOrNull(str);
                if (intOrNull != null) {
                    CamcorderProfile camcorderProfile = CamcorderProfile.get(intOrNull.intValue(), 1);
                    return new Size(camcorderProfile.videoFrameWidth, camcorderProfile.videoFrameHeight);
                }
            } catch (Throwable unused) {
            }
            return null;
        }

        public final Integer getMaximumFps(String str, Size size) {
            EncoderProfiles m;
            Intrinsics.checkNotNullParameter(str, "cameraId");
            Intrinsics.checkNotNullParameter(size, "size");
            try {
                int findClosestCamcorderProfileQuality = findClosestCamcorderProfileQuality(str, size, false);
                if (Build.VERSION.SDK_INT < 31 || (m = CamcorderProfile.getAll(str, findClosestCamcorderProfileQuality)) == null) {
                    Integer intOrNull = StringsKt.toIntOrNull(str);
                    if (intOrNull != null) {
                        return Integer.valueOf(CamcorderProfile.get(intOrNull.intValue(), findClosestCamcorderProfileQuality).videoFrameRate);
                    }
                    return null;
                }
                List m2 = m.getVideoProfiles();
                Intrinsics.checkNotNullExpressionValue(m2, "getVideoProfiles(...)");
                Iterator it = m2.iterator();
                if (it.hasNext()) {
                    Comparable valueOf = Integer.valueOf(Downloader$$ExternalSyntheticApiModelOutline0.m(it.next()).getFrameRate());
                    while (it.hasNext()) {
                        Comparable valueOf2 = Integer.valueOf(Downloader$$ExternalSyntheticApiModelOutline0.m(it.next()).getFrameRate());
                        if (valueOf.compareTo(valueOf2) < 0) {
                            valueOf = valueOf2;
                        }
                    }
                    return (Integer) valueOf;
                }
                throw new NoSuchElementException();
            } catch (Throwable unused) {
            }
        }
    }
}
