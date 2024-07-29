package com.google.crypto.tink.internal;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.PrimitiveWrapper;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PrimitiveRegistry {
    /* access modifiers changed from: private */
    public final Map<PrimitiveConstructorIndex, PrimitiveConstructor<?, ?>> primitiveConstructorMap;
    /* access modifiers changed from: private */
    public final Map<Class<?>, PrimitiveWrapper<?, ?>> primitiveWrapperMap;

    public static final class Builder {
        /* access modifiers changed from: private */
        public final Map<PrimitiveConstructorIndex, PrimitiveConstructor<?, ?>> primitiveConstructorMap;
        /* access modifiers changed from: private */
        public final Map<Class<?>, PrimitiveWrapper<?, ?>> primitiveWrapperMap;

        public Builder() {
            this.primitiveConstructorMap = new HashMap();
            this.primitiveWrapperMap = new HashMap();
        }

        public Builder(PrimitiveRegistry primitiveRegistry) {
            this.primitiveConstructorMap = new HashMap(primitiveRegistry.primitiveConstructorMap);
            this.primitiveWrapperMap = new HashMap(primitiveRegistry.primitiveWrapperMap);
        }

        public <KeyT extends Key, PrimitiveT> Builder registerPrimitiveConstructor(PrimitiveConstructor<KeyT, PrimitiveT> primitiveConstructor) throws GeneralSecurityException {
            if (primitiveConstructor != null) {
                PrimitiveConstructorIndex primitiveConstructorIndex = new PrimitiveConstructorIndex(primitiveConstructor.getKeyClass(), primitiveConstructor.getPrimitiveClass());
                if (this.primitiveConstructorMap.containsKey(primitiveConstructorIndex)) {
                    PrimitiveConstructor primitiveConstructor2 = this.primitiveConstructorMap.get(primitiveConstructorIndex);
                    if (!primitiveConstructor2.equals(primitiveConstructor) || !primitiveConstructor.equals(primitiveConstructor2)) {
                        throw new GeneralSecurityException("Attempt to register non-equal PrimitiveConstructor object for already existing object of type: " + primitiveConstructorIndex);
                    }
                } else {
                    this.primitiveConstructorMap.put(primitiveConstructorIndex, primitiveConstructor);
                }
                return this;
            }
            throw new NullPointerException("primitive constructor must be non-null");
        }

        public <InputPrimitiveT, WrapperPrimitiveT> Builder registerPrimitiveWrapper(PrimitiveWrapper<InputPrimitiveT, WrapperPrimitiveT> primitiveWrapper) throws GeneralSecurityException {
            if (primitiveWrapper != null) {
                Class<WrapperPrimitiveT> primitiveClass = primitiveWrapper.getPrimitiveClass();
                if (this.primitiveWrapperMap.containsKey(primitiveClass)) {
                    PrimitiveWrapper primitiveWrapper2 = this.primitiveWrapperMap.get(primitiveClass);
                    if (!primitiveWrapper2.equals(primitiveWrapper) || !primitiveWrapper.equals(primitiveWrapper2)) {
                        throw new GeneralSecurityException("Attempt to register non-equal PrimitiveWrapper object or input class object for already existing object of type" + primitiveClass);
                    }
                } else {
                    this.primitiveWrapperMap.put(primitiveClass, primitiveWrapper);
                }
                return this;
            }
            throw new NullPointerException("wrapper must be non-null");
        }

        /* access modifiers changed from: package-private */
        public PrimitiveRegistry build() {
            return new PrimitiveRegistry(this);
        }
    }

    private PrimitiveRegistry(Builder builder) {
        this.primitiveConstructorMap = new HashMap(builder.primitiveConstructorMap);
        this.primitiveWrapperMap = new HashMap(builder.primitiveWrapperMap);
    }

    public <KeyT extends Key, PrimitiveT> PrimitiveT getPrimitive(KeyT keyt, Class<PrimitiveT> cls) throws GeneralSecurityException {
        PrimitiveConstructorIndex primitiveConstructorIndex = new PrimitiveConstructorIndex(keyt.getClass(), cls);
        if (this.primitiveConstructorMap.containsKey(primitiveConstructorIndex)) {
            return this.primitiveConstructorMap.get(primitiveConstructorIndex).constructPrimitive(keyt);
        }
        throw new GeneralSecurityException("No PrimitiveConstructor for " + primitiveConstructorIndex + " available");
    }

    public Class<?> getInputPrimitiveClass(Class<?> cls) throws GeneralSecurityException {
        if (this.primitiveWrapperMap.containsKey(cls)) {
            return this.primitiveWrapperMap.get(cls).getInputPrimitiveClass();
        }
        throw new GeneralSecurityException("No input primitive class for " + cls + " available");
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [com.google.crypto.tink.PrimitiveSet<InputPrimitiveT>, com.google.crypto.tink.PrimitiveSet] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <InputPrimitiveT, WrapperPrimitiveT> WrapperPrimitiveT wrap(com.google.crypto.tink.PrimitiveSet<InputPrimitiveT> r3, java.lang.Class<WrapperPrimitiveT> r4) throws java.security.GeneralSecurityException {
        /*
            r2 = this;
            java.util.Map<java.lang.Class<?>, com.google.crypto.tink.PrimitiveWrapper<?, ?>> r0 = r2.primitiveWrapperMap
            boolean r0 = r0.containsKey(r4)
            if (r0 == 0) goto L_0x0039
            java.util.Map<java.lang.Class<?>, com.google.crypto.tink.PrimitiveWrapper<?, ?>> r0 = r2.primitiveWrapperMap
            java.lang.Object r4 = r0.get(r4)
            com.google.crypto.tink.PrimitiveWrapper r4 = (com.google.crypto.tink.PrimitiveWrapper) r4
            java.lang.Class r0 = r3.getPrimitiveClass()
            java.lang.Class r1 = r4.getInputPrimitiveClass()
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0031
            java.lang.Class r0 = r4.getInputPrimitiveClass()
            java.lang.Class r1 = r3.getPrimitiveClass()
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0031
            java.lang.Object r3 = r4.wrap(r3)
            return r3
        L_0x0031:
            java.security.GeneralSecurityException r3 = new java.security.GeneralSecurityException
            java.lang.String r4 = "Input primitive type of the wrapper doesn't match the type of primitives in the provided PrimitiveSet"
            r3.<init>(r4)
            throw r3
        L_0x0039:
            java.security.GeneralSecurityException r3 = new java.security.GeneralSecurityException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "No wrapper found for "
            r0.<init>(r1)
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.internal.PrimitiveRegistry.wrap(com.google.crypto.tink.PrimitiveSet, java.lang.Class):java.lang.Object");
    }

    private static final class PrimitiveConstructorIndex {
        private final Class<?> keyClass;
        private final Class<?> primitiveClass;

        private PrimitiveConstructorIndex(Class<?> cls, Class<?> cls2) {
            this.keyClass = cls;
            this.primitiveClass = cls2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof PrimitiveConstructorIndex)) {
                return false;
            }
            PrimitiveConstructorIndex primitiveConstructorIndex = (PrimitiveConstructorIndex) obj;
            if (!primitiveConstructorIndex.keyClass.equals(this.keyClass) || !primitiveConstructorIndex.primitiveClass.equals(this.primitiveClass)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.keyClass, this.primitiveClass});
        }

        public String toString() {
            return this.keyClass.getSimpleName() + " with primitive type: " + this.primitiveClass.getSimpleName();
        }
    }
}
