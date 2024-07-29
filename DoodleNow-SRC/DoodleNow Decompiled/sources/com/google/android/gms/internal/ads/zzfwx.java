package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
final class zzfwx extends zzfxc {
    final /* synthetic */ zzfwy zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzfwx(zzfwy zzfwy, zzfxe zzfxe, CharSequence charSequence) {
        super(zzfxe, charSequence);
        this.zza = zzfwy;
    }

    /* access modifiers changed from: package-private */
    public final int zzc(int i) {
        return i + 1;
    }

    /* access modifiers changed from: package-private */
    public final int zzd(int i) {
        CharSequence charSequence = this.zzb;
        int length = charSequence.length();
        zzfwr.zzb(i, length, "index");
        while (i < length) {
            zzfwy zzfwy = this.zza;
            if (zzfwy.zza.zzb(charSequence.charAt(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
