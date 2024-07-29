package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgxp;
import com.google.android.gms.internal.ads.zzgxq;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public abstract class zzgxp<MessageType extends zzgxq<MessageType, BuilderType>, BuilderType extends zzgxp<MessageType, BuilderType>> implements zzhbk {
    private String zza(String str) {
        String name = getClass().getName();
        return "Reading " + name + " from a " + str + " threw an IOException (should never happen).";
    }

    private static <T> void zzb(Iterable<T> iterable, List<? super T> list) {
        if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
            ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
        }
        int size = list.size();
        for (T next : iterable) {
            if (next == null) {
                String str = "Element at index " + (list.size() - size) + " is null.";
                int size2 = list.size();
                while (true) {
                    size2--;
                    if (size2 >= size) {
                        list.remove(size2);
                    } else {
                        throw new NullPointerException(str);
                    }
                }
            } else {
                list.add(next);
            }
        }
    }

    protected static zzhcw zzbb(zzhbl zzhbl) {
        return new zzhcw(zzhbl);
    }

    @Deprecated
    protected static <T> void zzbc(Iterable<T> iterable, Collection<? super T> collection) {
        zzbd(iterable, (List) collection);
    }

    protected static <T> void zzbd(Iterable<T> iterable, List<? super T> list) {
        byte[] bArr = zzhai.zzd;
        iterable.getClass();
        if (iterable instanceof zzhat) {
            List zzh = ((zzhat) iterable).zzh();
            zzhat zzhat = (zzhat) list;
            int size = list.size();
            for (Object next : zzh) {
                if (next == null) {
                    String str = "Element at index " + (zzhat.size() - size) + " is null.";
                    int size2 = zzhat.size();
                    while (true) {
                        size2--;
                        if (size2 >= size) {
                            zzhat.remove(size2);
                        } else {
                            throw new NullPointerException(str);
                        }
                    }
                } else if (next instanceof zzgyj) {
                    zzhat.zzi((zzgyj) next);
                } else {
                    zzhat.add((String) next);
                }
            }
        } else if (iterable instanceof zzhbu) {
            list.addAll((Collection) iterable);
        } else {
            zzb(iterable, list);
        }
    }

    /* renamed from: zzaC */
    public abstract BuilderType zzaP();

    /* access modifiers changed from: protected */
    public abstract BuilderType zzaD(MessageType messagetype);

    public BuilderType zzaE(zzgyj zzgyj) throws zzhak {
        try {
            zzgyt zzl = zzgyj.zzl();
            zzaR(zzl);
            zzl.zzz(0);
            return this;
        } catch (zzhak e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException(zza("ByteString"), e2);
        }
    }

    /* renamed from: zzaF */
    public BuilderType zzaR(zzgyt zzgyt) throws IOException {
        return zzaW(zzgyt, zzgzf.zza);
    }

    /* renamed from: zzaG */
    public BuilderType zzaS(zzhbl zzhbl) {
        if (zzbt().getClass().isInstance(zzhbl)) {
            return zzaD((zzgxq) zzhbl);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }

    public BuilderType zzaH(InputStream inputStream) throws IOException {
        zzgyt zzI = zzgyt.zzI(inputStream, 4096);
        zzaR(zzI);
        zzI.zzz(0);
        return this;
    }

    /* renamed from: zzaI */
    public BuilderType zzaU(byte[] bArr) throws zzhak {
        return zzaZ(bArr, 0, bArr.length);
    }

    public BuilderType zzaJ(zzgyj zzgyj, zzgzf zzgzf) throws zzhak {
        try {
            zzgyt zzl = zzgyj.zzl();
            zzaW(zzl, zzgzf);
            zzl.zzz(0);
            return this;
        } catch (zzhak e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException(zza("ByteString"), e2);
        }
    }

    /* renamed from: zzaK */
    public abstract BuilderType zzaW(zzgyt zzgyt, zzgzf zzgzf) throws IOException;

    public BuilderType zzaL(InputStream inputStream, zzgzf zzgzf) throws IOException {
        zzgyt zzI = zzgyt.zzI(inputStream, 4096);
        zzaW(zzI, zzgzf);
        zzI.zzz(0);
        return this;
    }

    /* renamed from: zzaM */
    public BuilderType zzaY(byte[] bArr, zzgzf zzgzf) throws zzhak {
        return zzba(bArr, 0, bArr.length, zzgzf);
    }

    /* renamed from: zzaN */
    public BuilderType zzaZ(byte[] bArr, int i, int i2) throws zzhak {
        try {
            zzgyt zzJ = zzgyt.zzJ(bArr, i, i2, false);
            zzaR(zzJ);
            zzJ.zzz(0);
            return this;
        } catch (zzhak e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException(zza("byte array"), e2);
        }
    }

    /* renamed from: zzaO */
    public BuilderType zzba(byte[] bArr, int i, int i2, zzgzf zzgzf) throws zzhak {
        try {
            zzgyt zzJ = zzgyt.zzJ(bArr, i, i2, false);
            zzaW(zzJ, zzgzf);
            zzJ.zzz(0);
            return this;
        } catch (zzhak e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException(zza("byte array"), e2);
        }
    }

    public /* bridge */ /* synthetic */ zzhbk zzaQ(zzgyj zzgyj) throws zzhak {
        zzaE(zzgyj);
        return this;
    }

    public /* bridge */ /* synthetic */ zzhbk zzaT(InputStream inputStream) throws IOException {
        zzaH(inputStream);
        return this;
    }

    public /* bridge */ /* synthetic */ zzhbk zzaV(zzgyj zzgyj, zzgzf zzgzf) throws zzhak {
        zzaJ(zzgyj, zzgzf);
        return this;
    }

    public /* bridge */ /* synthetic */ zzhbk zzaX(InputStream inputStream, zzgzf zzgzf) throws IOException {
        zzaL(inputStream, zzgzf);
        return this;
    }

    public boolean zzbe(InputStream inputStream) throws IOException {
        return zzbf(inputStream, zzgzf.zza);
    }

    public boolean zzbf(InputStream inputStream, zzgzf zzgzf) throws IOException {
        int read = inputStream.read();
        if (read == -1) {
            return false;
        }
        zzaL(new zzgxo(inputStream, zzgyt.zzG(read, inputStream)), zzgzf);
        return true;
    }
}
