package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgxp;
import com.google.android.gms.internal.ads.zzgxq;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public abstract class zzgxq<MessageType extends zzgxq<MessageType, BuilderType>, BuilderType extends zzgxp<MessageType, BuilderType>> implements zzhbl {
    protected int zzq = 0;

    protected static <T> void zzaQ(Iterable<T> iterable, List<? super T> list) {
        zzgxp.zzbd(iterable, list);
    }

    protected static void zzaR(zzgyj zzgyj) throws IllegalArgumentException {
        if (!zzgyj.zzp()) {
            throw new IllegalArgumentException("Byte string is not UTF-8.");
        }
    }

    private String zzdI(String str) {
        String name = getClass().getName();
        return "Serializing " + name + " to a " + str + " threw an IOException (should never happen).";
    }

    /* access modifiers changed from: package-private */
    public int zzaL() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public int zzaM(zzhcg zzhcg) {
        return zzaL();
    }

    public zzgyj zzaN() {
        try {
            int zzaY = zzaY();
            zzgyj zzgyj = zzgyj.zzb;
            byte[] bArr = new byte[zzaY];
            zzgza zzF = zzgza.zzF(bArr, 0, zzaY);
            zzda(zzF);
            zzF.zzG();
            return new zzgyf(bArr);
        } catch (IOException e) {
            throw new RuntimeException(zzdI("ByteString"), e);
        }
    }

    public zzhbq zzaO() {
        throw new UnsupportedOperationException("mutableCopy() is not implemented.");
    }

    /* access modifiers changed from: package-private */
    public zzhcw zzaP() {
        return new zzhcw(this);
    }

    /* access modifiers changed from: package-private */
    public void zzaS(int i) {
        throw new UnsupportedOperationException();
    }

    public void zzaT(OutputStream outputStream) throws IOException {
        int zzaY = zzaY();
        zzgyy zzgyy = new zzgyy(outputStream, zzgza.zzB(zzgza.zzD(zzaY) + zzaY));
        zzgyy.zzu(zzaY);
        zzda(zzgyy);
        zzgyy.zzL();
    }

    public void zzaU(OutputStream outputStream) throws IOException {
        zzgyy zzgyy = new zzgyy(outputStream, zzgza.zzB(zzaY()));
        zzda(zzgyy);
        zzgyy.zzL();
    }

    public byte[] zzaV() {
        try {
            int zzaY = zzaY();
            byte[] bArr = new byte[zzaY];
            zzgza zzF = zzgza.zzF(bArr, 0, zzaY);
            zzda(zzF);
            zzF.zzG();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException(zzdI("byte array"), e);
        }
    }
}
