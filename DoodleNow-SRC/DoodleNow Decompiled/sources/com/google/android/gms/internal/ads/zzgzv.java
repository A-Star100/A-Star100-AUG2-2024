package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgzp;
import com.google.android.gms.internal.ads.zzgzv;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public abstract class zzgzv<MessageType extends zzgzv<MessageType, BuilderType>, BuilderType extends zzgzp<MessageType, BuilderType>> extends zzgxq<MessageType, BuilderType> {
    private static final int zza = Integer.MIN_VALUE;
    private static final int zzb = Integer.MAX_VALUE;
    private static Map<Object, zzgzv<?, ?>> zzc = new ConcurrentHashMap();
    static final int zzr = Integer.MAX_VALUE;
    static final int zzs = 0;
    private int zzd = -1;
    protected zzhcy zzt = zzhcy.zzc();

    protected static zzgzx zzbA() {
        return zzgxx.zzd();
    }

    protected static zzgzx zzbB(zzgzx zzgzx) {
        int size = zzgzx.size();
        return zzgzx.zze(size == 0 ? 10 : size + size);
    }

    protected static zzgzy zzbC() {
        return zzgzc.zzd();
    }

    protected static zzgzy zzbD(zzgzy zzgzy) {
        int size = zzgzy.size();
        return zzgzy.zze(size == 0 ? 10 : size + size);
    }

    protected static zzhac zzbE() {
        return zzgzm.zzd();
    }

    protected static zzhac zzbF(zzhac zzhac) {
        int size = zzhac.size();
        return zzhac.zze(size == 0 ? 10 : size + size);
    }

    protected static zzhad zzbG() {
        return zzgzw.zzg();
    }

    protected static zzhad zzbH(zzhad zzhad) {
        int size = zzhad.size();
        return zzhad.zzh(size == 0 ? 10 : size + size);
    }

    protected static zzhag zzbI() {
        return zzhba.zzh();
    }

    protected static zzhag zzbJ(zzhag zzhag) {
        int size = zzhag.size();
        return zzhag.zze(size == 0 ? 10 : size + size);
    }

    protected static <E> zzhah<E> zzbK() {
        return zzhbw.zzd();
    }

    protected static <E> zzhah<E> zzbL(zzhah<E> zzhah) {
        int size = zzhah.size();
        return zzhah.zzf(size == 0 ? 10 : size + size);
    }

    static Object zzbQ(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    protected static Object zzbR(zzhbl zzhbl, String str, Object[] objArr) {
        return new zzhbx(zzhbl, str, objArr);
    }

    static Method zzbS(Class cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e) {
            String name = cls.getName();
            throw new RuntimeException("Generated message class \"" + name + "\" missing method \"" + str + "\".", e);
        }
    }

    public static <ContainingType extends zzhbl, Type> zzgzt<ContainingType, Type> zzbe(ContainingType containingtype, zzhbl zzhbl, zzhaa zzhaa, int i, zzhdn zzhdn, boolean z, Class cls) {
        return new zzgzt(containingtype, Collections.emptyList(), zzhbl, new zzgzs(zzhaa, i, zzhdn, true, z), cls);
    }

    public static <ContainingType extends zzhbl, Type> zzgzt<ContainingType, Type> zzbf(ContainingType containingtype, Type type, zzhbl zzhbl, zzhaa zzhaa, int i, zzhdn zzhdn, Class cls) {
        return new zzgzt(containingtype, type, zzhbl, new zzgzs(zzhaa, i, zzhdn, false, false), cls);
    }

    static <T extends zzgzv> T zzbh(Class<T> cls) {
        T t = (zzgzv) zzc.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (zzgzv) zzc.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (t == null) {
            t = ((zzgzv) zzhdh.zzg(cls)).zzbt();
            if (t != null) {
                zzc.put(cls, t);
            } else {
                throw new IllegalStateException();
            }
        }
        return t;
    }

    protected static <T extends zzgzv<T, ?>> T zzbk(T t, InputStream inputStream) throws zzhak {
        T zzg = zzg(t, inputStream, zzgzf.zza);
        zzf(zzg);
        return zzg;
    }

    protected static <T extends zzgzv<T, ?>> T zzbl(T t, InputStream inputStream, zzgzf zzgzf) throws zzhak {
        T zzg = zzg(t, inputStream, zzgzf);
        zzf(zzg);
        return zzg;
    }

    protected static <T extends zzgzv<T, ?>> T zzbm(T t, zzgyj zzgyj) throws zzhak {
        T zzbr = zzbr(t, zzgyj, zzgzf.zza);
        zzf(zzbr);
        return zzbr;
    }

    protected static <T extends zzgzv<T, ?>> T zzbn(T t, zzgyt zzgyt) throws zzhak {
        return zzbs(t, zzgyt, zzgzf.zza);
    }

    protected static <T extends zzgzv<T, ?>> T zzbo(T t, InputStream inputStream) throws zzhak {
        T zzbz = zzbz(t, zzgyt.zzI(inputStream, 4096), zzgzf.zza);
        zzf(zzbz);
        return zzbz;
    }

    protected static <T extends zzgzv<T, ?>> T zzbp(T t, ByteBuffer byteBuffer) throws zzhak {
        return zzbv(t, byteBuffer, zzgzf.zza);
    }

    protected static <T extends zzgzv<T, ?>> T zzbq(T t, byte[] bArr) throws zzhak {
        T zzi = zzi(t, bArr, 0, bArr.length, zzgzf.zza);
        zzf(zzi);
        return zzi;
    }

    protected static <T extends zzgzv<T, ?>> T zzbr(T t, zzgyj zzgyj, zzgzf zzgzf) throws zzhak {
        T zzh = zzh(t, zzgyj, zzgzf);
        zzf(zzh);
        return zzh;
    }

    protected static <T extends zzgzv<T, ?>> T zzbs(T t, zzgyt zzgyt, zzgzf zzgzf) throws zzhak {
        T zzbz = zzbz(t, zzgyt, zzgzf);
        zzf(zzbz);
        return zzbz;
    }

    protected static <T extends zzgzv<T, ?>> T zzbu(T t, InputStream inputStream, zzgzf zzgzf) throws zzhak {
        T zzbz = zzbz(t, zzgyt.zzI(inputStream, 4096), zzgzf);
        zzf(zzbz);
        return zzbz;
    }

    protected static <T extends zzgzv<T, ?>> T zzbv(T t, ByteBuffer byteBuffer, zzgzf zzgzf) throws zzhak {
        zzgyt zzgyt;
        int i = zzgyt.zzd;
        if (byteBuffer.hasArray()) {
            zzgyt = zzgyt.zzJ(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining(), false);
        } else if (!byteBuffer.isDirect() || !zzhdh.zzB()) {
            int remaining = byteBuffer.remaining();
            byte[] bArr = new byte[remaining];
            byteBuffer.duplicate().get(bArr);
            zzgyt = zzgyt.zzJ(bArr, 0, remaining, true);
        } else {
            zzgyt = new zzgyr(byteBuffer, false, (zzgyq) null);
        }
        T zzbs = zzbs(t, zzgyt, zzgzf);
        zzf(zzbs);
        return zzbs;
    }

    protected static <T extends zzgzv<T, ?>> T zzbx(T t, byte[] bArr, zzgzf zzgzf) throws zzhak {
        T zzi = zzi(t, bArr, 0, bArr.length, zzgzf);
        zzf(zzi);
        return zzi;
    }

    protected static <T extends zzgzv<T, ?>> T zzby(T t, zzgyt zzgyt) throws zzhak {
        return zzbz(t, zzgyt, zzgzf.zza);
    }

    static <T extends zzgzv<T, ?>> T zzbz(T t, zzgyt zzgyt, zzgzf zzgzf) throws zzhak {
        T zzbj = t.zzbj();
        try {
            zzhcg zzb2 = zzhbv.zza().zzb(zzbj.getClass());
            zzb2.zzh(zzbj, zzgyu.zzq(zzgyt), zzgzf);
            zzb2.zzf(zzbj);
            return zzbj;
        } catch (zzhak e) {
            e = e;
            if (e.zzl()) {
                e = new zzhak((IOException) e);
            }
            e.zzh(zzbj);
            throw e;
        } catch (zzhcw e2) {
            zzhak zza2 = e2.zza();
            zza2.zzh(zzbj);
            throw zza2;
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzhak) {
                throw ((zzhak) e3.getCause());
            }
            zzhak zzhak = new zzhak(e3);
            zzhak.zzh(zzbj);
            throw zzhak;
        } catch (RuntimeException e4) {
            if (e4.getCause() instanceof zzhak) {
                throw ((zzhak) e4.getCause());
            }
            throw e4;
        }
    }

    private int zzc(zzhcg<?> zzhcg) {
        if (zzhcg != null) {
            return zzhcg.zza(this);
        }
        return zzhbv.zza().zzb(getClass()).zza(this);
    }

    protected static <T extends zzgzv> void zzca(Class<T> cls, T t) {
        t.zzbW();
        zzc.put(cls, t);
    }

    protected static final <T extends zzgzv<T, ?>> boolean zzcd(T t, boolean z) {
        byte byteValue = ((Byte) t.zzbO(zzgzu.GET_MEMOIZED_IS_INITIALIZED)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzk = zzhbv.zza().zzb(t.getClass()).zzk(t);
        if (z) {
            t.zzbP(zzgzu.SET_MEMOIZED_IS_INITIALIZED, true != zzk ? null : t);
        }
        return zzk;
    }

    /* access modifiers changed from: private */
    public static <MessageType extends zzgzr<MessageType, BuilderType>, BuilderType, T> zzgzt<MessageType, T> zze(zzgzd<MessageType, T> zzgzd) {
        return (zzgzt) zzgzd;
    }

    private static <T extends zzgzv<T, ?>> T zzf(T t) throws zzhak {
        if (t == null || t.zzbw()) {
            return t;
        }
        zzhak zza2 = t.zzaP().zza();
        zza2.zzh(t);
        throw zza2;
    }

    private static <T extends zzgzv<T, ?>> T zzg(T t, InputStream inputStream, zzgzf zzgzf) throws zzhak {
        try {
            int read = inputStream.read();
            if (read == -1) {
                return null;
            }
            zzgyt zzI = zzgyt.zzI(new zzgxo(inputStream, zzgyt.zzG(read, inputStream)), 4096);
            T zzbz = zzbz(t, zzI, zzgzf);
            try {
                zzI.zzz(0);
                return zzbz;
            } catch (zzhak e) {
                e.zzh(zzbz);
                throw e;
            }
        } catch (zzhak e2) {
            if (e2.zzl()) {
                throw new zzhak((IOException) e2);
            }
            throw e2;
        } catch (IOException e3) {
            throw new zzhak(e3);
        }
    }

    private static <T extends zzgzv<T, ?>> T zzh(T t, zzgyj zzgyj, zzgzf zzgzf) throws zzhak {
        zzgyt zzl = zzgyj.zzl();
        T zzbz = zzbz(t, zzl, zzgzf);
        try {
            zzl.zzz(0);
            return zzbz;
        } catch (zzhak e) {
            e.zzh(zzbz);
            throw e;
        }
    }

    /* access modifiers changed from: private */
    public static <T extends zzgzv<T, ?>> T zzi(T t, byte[] bArr, int i, int i2, zzgzf zzgzf) throws zzhak {
        T zzbj = t.zzbj();
        try {
            zzhcg zzb2 = zzhbv.zza().zzb(zzbj.getClass());
            zzb2.zzi(zzbj, bArr, i, i + i2, new zzgxv(zzgzf));
            zzb2.zzf(zzbj);
            return zzbj;
        } catch (zzhak e) {
            e = e;
            if (e.zzl()) {
                e = new zzhak((IOException) e);
            }
            e.zzh(zzbj);
            throw e;
        } catch (zzhcw e2) {
            zzhak zza2 = e2.zza();
            zza2.zzh(zzbj);
            throw zza2;
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzhak) {
                throw ((zzhak) e3.getCause());
            }
            zzhak zzhak = new zzhak(e3);
            zzhak.zzh(zzbj);
            throw zzhak;
        } catch (IndexOutOfBoundsException unused) {
            zzhak zzj = zzhak.zzj();
            zzj.zzh(zzbj);
            throw zzj;
        }
    }

    private void zzj() {
        if (this.zzt == zzhcy.zzc()) {
            this.zzt = zzhcy.zzf();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzhbv.zza().zzb(getClass()).zzj(this, (zzgzv) obj);
    }

    public int hashCode() {
        if (zzce()) {
            return zzaW();
        }
        if (zzcc()) {
            zzcb(zzaW());
        }
        return zzaX();
    }

    public String toString() {
        return zzhbn.zza(this, super.toString());
    }

    /* access modifiers changed from: package-private */
    public int zzaL() {
        return this.zzd & Integer.MAX_VALUE;
    }

    /* access modifiers changed from: package-private */
    public int zzaM(zzhcg zzhcg) {
        if (zzce()) {
            int zzc2 = zzc(zzhcg);
            if (zzc2 >= 0) {
                return zzc2;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + zzc2);
        } else if (zzaL() != Integer.MAX_VALUE) {
            return zzaL();
        } else {
            int zzc3 = zzc(zzhcg);
            zzaS(zzc3);
            return zzc3;
        }
    }

    public zzhbq zzaO() {
        throw new UnsupportedOperationException("Lite does not support the mutable API.");
    }

    /* access modifiers changed from: package-private */
    public void zzaS(int i) {
        if (i >= 0) {
            this.zzd = i | (this.zzd & Integer.MIN_VALUE);
            return;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + i);
    }

    /* access modifiers changed from: package-private */
    public int zzaW() {
        return zzhbv.zza().zzb(getClass()).zzb(this);
    }

    /* access modifiers changed from: package-private */
    public int zzaX() {
        return this.zzq;
    }

    public int zzaY() {
        return zzaM((zzhcg) null);
    }

    /* access modifiers changed from: protected */
    public final <MessageType extends zzgzv<MessageType, BuilderType>, BuilderType extends zzgzp<MessageType, BuilderType>> BuilderType zzaZ() {
        return (zzgzp) zzbO(zzgzu.NEW_BUILDER);
    }

    public final zzhbt<MessageType> zzbM() {
        return (zzhbt) zzbO(zzgzu.GET_PARSER);
    }

    /* access modifiers changed from: package-private */
    public Object zzbN() throws Exception {
        return zzbO(zzgzu.BUILD_MESSAGE_INFO);
    }

    /* access modifiers changed from: protected */
    public Object zzbO(zzgzu zzgzu) {
        return zzde(zzgzu, (Object) null, (Object) null);
    }

    /* access modifiers changed from: protected */
    public Object zzbP(zzgzu zzgzu, Object obj) {
        return zzde(zzgzu, obj, (Object) null);
    }

    /* access modifiers changed from: package-private */
    public void zzbT() {
        this.zzq = 0;
    }

    /* access modifiers changed from: package-private */
    public void zzbU() {
        zzaS(Integer.MAX_VALUE);
    }

    /* access modifiers changed from: protected */
    public void zzbV() {
        zzhbv.zza().zzb(getClass()).zzf(this);
        zzbW();
    }

    /* access modifiers changed from: package-private */
    public void zzbW() {
        this.zzd &= Integer.MAX_VALUE;
    }

    /* access modifiers changed from: protected */
    public void zzbX(int i, zzgyj zzgyj) {
        zzj();
        zzhcy zzhcy = this.zzt;
        zzhcy.zzg();
        if (i != 0) {
            zzhcy.zzj((i << 3) | 2, zzgyj);
            return;
        }
        throw new IllegalArgumentException("Zero is not a valid field number.");
    }

    /* access modifiers changed from: protected */
    public final void zzbY(zzhcy zzhcy) {
        this.zzt = zzhcy.zze(this.zzt, zzhcy);
    }

    /* access modifiers changed from: protected */
    public void zzbZ(int i, int i2) {
        zzj();
        zzhcy zzhcy = this.zzt;
        zzhcy.zzg();
        if (i != 0) {
            zzhcy.zzj(i << 3, Long.valueOf((long) i2));
            return;
        }
        throw new IllegalArgumentException("Zero is not a valid field number.");
    }

    /* access modifiers changed from: protected */
    public final <MessageType extends zzgzv<MessageType, BuilderType>, BuilderType extends zzgzp<MessageType, BuilderType>> BuilderType zzba(MessageType messagetype) {
        BuilderType zzaZ = zzaZ();
        zzaZ.zzbj(messagetype);
        return zzaZ;
    }

    /* renamed from: zzbb */
    public final BuilderType zzcY() {
        return (zzgzp) zzbO(zzgzu.NEW_BUILDER);
    }

    /* renamed from: zzbc */
    public final BuilderType zzcZ() {
        BuilderType buildertype = (zzgzp) zzbO(zzgzu.NEW_BUILDER);
        buildertype.zzbj(this);
        return buildertype;
    }

    /* renamed from: zzbi */
    public final MessageType zzbt() {
        return (zzgzv) zzbO(zzgzu.GET_DEFAULT_INSTANCE);
    }

    /* access modifiers changed from: package-private */
    public MessageType zzbj() {
        return (zzgzv) zzbO(zzgzu.NEW_MUTABLE_INSTANCE);
    }

    public final boolean zzbw() {
        Boolean bool = Boolean.TRUE;
        return zzcd(this, true);
    }

    /* access modifiers changed from: package-private */
    public void zzcb(int i) {
        this.zzq = i;
    }

    /* access modifiers changed from: package-private */
    public boolean zzcc() {
        return zzaX() == 0;
    }

    /* access modifiers changed from: package-private */
    public boolean zzce() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    /* access modifiers changed from: protected */
    public boolean zzcf(int i, zzgyt zzgyt) throws IOException {
        if ((i & 7) == 4) {
            return false;
        }
        zzj();
        return this.zzt.zzk(i, zzgyt);
    }

    public void zzda(zzgza zzgza) throws IOException {
        zzhbv.zza().zzb(getClass()).zzm(this, zzgzb.zza(zzgza));
    }

    /* access modifiers changed from: protected */
    public abstract Object zzde(zzgzu zzgzu, Object obj, Object obj2);
}
