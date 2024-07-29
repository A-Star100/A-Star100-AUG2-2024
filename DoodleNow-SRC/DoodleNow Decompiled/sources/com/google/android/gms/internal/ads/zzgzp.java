package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgzp;
import com.google.android.gms.internal.ads.zzgzv;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public class zzgzp<MessageType extends zzgzv<MessageType, BuilderType>, BuilderType extends zzgzp<MessageType, BuilderType>> extends zzgxp<MessageType, BuilderType> {
    protected MessageType zza;
    private final MessageType zzb;

    protected zzgzp(MessageType messagetype) {
        this.zzb = messagetype;
        if (!messagetype.zzce()) {
            this.zza = zza();
            return;
        }
        throw new IllegalArgumentException("Default instance must be immutable.");
    }

    private MessageType zza() {
        return this.zzb.zzbj();
    }

    private static <MessageType> void zzb(MessageType messagetype, MessageType messagetype2) {
        zzhbv.zza().zzb(messagetype.getClass()).zzg(messagetype, messagetype2);
    }

    /* access modifiers changed from: protected */
    public /* bridge */ /* synthetic */ zzgxp zzaD(zzgxq zzgxq) {
        zzbi((zzgzv) zzgxq);
        return this;
    }

    public /* bridge */ /* synthetic */ zzgxp zzaK(zzgyt zzgyt, zzgzf zzgzf) throws IOException {
        zzbk(zzgyt, zzgzf);
        return this;
    }

    public /* bridge */ /* synthetic */ zzgxp zzaN(byte[] bArr, int i, int i2) throws zzhak {
        zzbl(bArr, i, i2);
        return this;
    }

    public /* bridge */ /* synthetic */ zzgxp zzaO(byte[] bArr, int i, int i2, zzgzf zzgzf) throws zzhak {
        zzbm(bArr, i, i2, zzgzf);
        return this;
    }

    public /* bridge */ /* synthetic */ zzhbk zzaW(zzgyt zzgyt, zzgzf zzgzf) throws IOException {
        zzbk(zzgyt, zzgzf);
        return this;
    }

    public /* bridge */ /* synthetic */ zzhbk zzaZ(byte[] bArr, int i, int i2) throws zzhak {
        zzbl(bArr, i, i2);
        return this;
    }

    public /* bridge */ /* synthetic */ zzhbk zzba(byte[] bArr, int i, int i2, zzgzf zzgzf) throws zzhak {
        zzbm(bArr, i, i2, zzgzf);
        return this;
    }

    public final BuilderType zzbg() {
        if (!this.zzb.zzce()) {
            this.zza = zza();
            return this;
        }
        throw new IllegalArgumentException("Default instance must be immutable.");
    }

    /* renamed from: zzbh */
    public BuilderType zzaP() {
        BuilderType zzbb = zzbt().zzcY();
        zzbb.zza = zzbs();
        return zzbb;
    }

    /* access modifiers changed from: protected */
    public BuilderType zzbi(MessageType messagetype) {
        zzbj(messagetype);
        return this;
    }

    public BuilderType zzbj(MessageType messagetype) {
        if (zzbt().equals(messagetype)) {
            return this;
        }
        zzbu();
        zzb(this.zza, messagetype);
        return this;
    }

    public BuilderType zzbk(zzgyt zzgyt, zzgzf zzgzf) throws IOException {
        zzbu();
        try {
            zzhbv.zza().zzb(this.zza.getClass()).zzh(this.zza, zzgyu.zzq(zzgyt), zzgzf);
            return this;
        } catch (RuntimeException e) {
            if (e.getCause() instanceof IOException) {
                throw ((IOException) e.getCause());
            }
            throw e;
        }
    }

    public BuilderType zzbl(byte[] bArr, int i, int i2) throws zzhak {
        zzbm(bArr, i, i2, zzgzf.zza);
        return this;
    }

    public BuilderType zzbm(byte[] bArr, int i, int i2, zzgzf zzgzf) throws zzhak {
        zzbu();
        try {
            zzhbv.zza().zzb(this.zza.getClass()).zzi(this.zza, bArr, i, i + i2, new zzgxv(zzgzf));
            return this;
        } catch (zzhak e) {
            throw e;
        } catch (IndexOutOfBoundsException unused) {
            throw zzhak.zzj();
        } catch (IOException e2) {
            throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
        }
    }

    /* renamed from: zzbn */
    public final MessageType zzbr() {
        MessageType zzbo = zzbs();
        if (zzbo.zzbw()) {
            return zzbo;
        }
        throw zzbb(zzbo);
    }

    /* renamed from: zzbo */
    public MessageType zzbs() {
        if (!this.zza.zzce()) {
            return this.zza;
        }
        this.zza.zzbV();
        return this.zza;
    }

    /* renamed from: zzbp */
    public MessageType zzbt() {
        return this.zzb;
    }

    public /* bridge */ /* synthetic */ zzhbk zzbq() {
        zzbg();
        return this;
    }

    /* access modifiers changed from: protected */
    public final void zzbu() {
        if (!this.zza.zzce()) {
            zzbv();
        }
    }

    /* access modifiers changed from: protected */
    public void zzbv() {
        MessageType zza2 = zza();
        zzb(zza2, this.zza);
        this.zza = zza2;
    }

    public final boolean zzbw() {
        return zzgzv.zzcd(this.zza, false);
    }
}
