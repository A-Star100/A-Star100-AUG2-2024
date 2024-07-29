package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public enum zzhhf implements zzgzz {
    REQUEST_DESTINATION_UNSPECIFIED(0),
    zzb(1),
    AUDIO(2),
    AUDIO_WORKLET(3),
    DOCUMENT(4),
    EMBED(5),
    FONT(6),
    FRAME(7),
    IFRAME(8),
    IMAGE(9),
    MANIFEST(10),
    OBJECT(11),
    PAINT_WORKLET(12),
    REPORT(13),
    SCRIPT(14),
    SERVICE_WORKER(15),
    SHARED_WORKER(16),
    STYLE(17),
    TRACK(18),
    VIDEO(19),
    WEB_BUNDLE(20),
    WORKER(21),
    XSLT(22),
    FENCED_FRAME(23),
    WEB_IDENTITY(24),
    DICTIONARY(25),
    SPECULATION_RULES(26),
    zzB(27);
    
    private static final zzhaa zzC = null;
    private final int zzE;

    static {
        zzC = new zzhhd();
    }

    private zzhhf(int i) {
        this.zzE = i;
    }

    public static zzhhf zzb(int i) {
        switch (i) {
            case 0:
                return REQUEST_DESTINATION_UNSPECIFIED;
            case 1:
                return zzb;
            case 2:
                return AUDIO;
            case 3:
                return AUDIO_WORKLET;
            case 4:
                return DOCUMENT;
            case 5:
                return EMBED;
            case 6:
                return FONT;
            case 7:
                return FRAME;
            case 8:
                return IFRAME;
            case 9:
                return IMAGE;
            case 10:
                return MANIFEST;
            case 11:
                return OBJECT;
            case 12:
                return PAINT_WORKLET;
            case 13:
                return REPORT;
            case 14:
                return SCRIPT;
            case 15:
                return SERVICE_WORKER;
            case 16:
                return SHARED_WORKER;
            case 17:
                return STYLE;
            case 18:
                return TRACK;
            case 19:
                return VIDEO;
            case 20:
                return WEB_BUNDLE;
            case 21:
                return WORKER;
            case 22:
                return XSLT;
            case 23:
                return FENCED_FRAME;
            case 24:
                return WEB_IDENTITY;
            case 25:
                return DICTIONARY;
            case 26:
                return SPECULATION_RULES;
            case 27:
                return zzB;
            default:
                return null;
        }
    }

    public final String toString() {
        return Integer.toString(this.zzE);
    }

    public final int zza() {
        return this.zzE;
    }
}
