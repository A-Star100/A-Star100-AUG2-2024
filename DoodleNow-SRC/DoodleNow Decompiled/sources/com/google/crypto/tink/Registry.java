package com.google.crypto.tink;

import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.KeyTypeManager;
import com.google.crypto.tink.internal.MutablePrimitiveRegistry;
import com.google.crypto.tink.internal.PrivateKeyTypeManager;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Logger;
import javax.annotation.Nullable;

public final class Registry {
    private static final ConcurrentMap<String, Catalogue<?>> catalogueMap = new ConcurrentHashMap();
    private static final ConcurrentMap<String, KeyDeriverContainer> keyDeriverMap = new ConcurrentHashMap();
    private static final AtomicReference<KeyManagerRegistry> keyManagerRegistry = new AtomicReference<>(new KeyManagerRegistry());
    private static final ConcurrentMap<String, KeyTemplate> keyTemplateMap = new ConcurrentHashMap();
    private static final Logger logger = Logger.getLogger(Registry.class.getName());
    private static final ConcurrentMap<String, Boolean> newKeyAllowedMap = new ConcurrentHashMap();

    private interface KeyDeriverContainer {
        KeyData deriveKey(ByteString byteString, InputStream inputStream) throws GeneralSecurityException;
    }

    private static <KeyProtoT extends MessageLite> KeyDeriverContainer createDeriverFor(final KeyTypeManager<KeyProtoT> keyTypeManager) {
        return new KeyDeriverContainer() {
            private <KeyFormatProtoT extends MessageLite> MessageLite deriveKeyWithFactory(ByteString byteString, InputStream inputStream, KeyTypeManager.KeyFactory<KeyFormatProtoT, KeyProtoT> keyFactory) throws GeneralSecurityException {
                try {
                    KeyFormatProtoT parseKeyFormat = keyFactory.parseKeyFormat(byteString);
                    keyFactory.validateKeyFormat(parseKeyFormat);
                    return keyFactory.deriveKey(parseKeyFormat, inputStream);
                } catch (InvalidProtocolBufferException e) {
                    throw new GeneralSecurityException("parsing key format failed in deriveKey", e);
                }
            }

            public KeyData deriveKey(ByteString byteString, InputStream inputStream) throws GeneralSecurityException {
                return (KeyData) KeyData.newBuilder().setTypeUrl(KeyTypeManager.this.getKeyType()).setValue(deriveKeyWithFactory(byteString, inputStream, KeyTypeManager.this.keyFactory()).toByteString()).setKeyMaterialType(KeyTypeManager.this.keyMaterialType()).build();
            }
        };
    }

    static synchronized void reset() {
        synchronized (Registry.class) {
            keyManagerRegistry.set(new KeyManagerRegistry());
            MutablePrimitiveRegistry.resetGlobalInstanceTestOnly();
            keyDeriverMap.clear();
            newKeyAllowedMap.clear();
            catalogueMap.clear();
            keyTemplateMap.clear();
        }
    }

    @Deprecated
    public static synchronized void addCatalogue(String str, Catalogue<?> catalogue) throws GeneralSecurityException {
        synchronized (Registry.class) {
            if (str == null) {
                throw new IllegalArgumentException("catalogueName must be non-null.");
            } else if (catalogue != null) {
                ConcurrentMap<String, Catalogue<?>> concurrentMap = catalogueMap;
                if (concurrentMap.containsKey(str.toLowerCase(Locale.US))) {
                    if (!catalogue.getClass().getName().equals(((Catalogue) concurrentMap.get(str.toLowerCase(Locale.US))).getClass().getName())) {
                        Logger logger2 = logger;
                        logger2.warning("Attempted overwrite of a catalogueName catalogue for name " + str);
                        throw new GeneralSecurityException("catalogue for name " + str + " has been already registered");
                    }
                }
                concurrentMap.put(str.toLowerCase(Locale.US), catalogue);
            } else {
                throw new IllegalArgumentException("catalogue must be non-null.");
            }
        }
    }

    @Deprecated
    public static Catalogue<?> getCatalogue(String str) throws GeneralSecurityException {
        if (str != null) {
            Catalogue<?> catalogue = (Catalogue) catalogueMap.get(str.toLowerCase(Locale.US));
            if (catalogue != null) {
                return catalogue;
            }
            String format = String.format("no catalogue found for %s. ", new Object[]{str});
            if (str.toLowerCase(Locale.US).startsWith("tinkaead")) {
                format = format + "Maybe call AeadConfig.register().";
            }
            if (str.toLowerCase(Locale.US).startsWith("tinkdeterministicaead")) {
                format = format + "Maybe call DeterministicAeadConfig.register().";
            } else if (str.toLowerCase(Locale.US).startsWith("tinkstreamingaead")) {
                format = format + "Maybe call StreamingAeadConfig.register().";
            } else if (str.toLowerCase(Locale.US).startsWith("tinkhybriddecrypt") || str.toLowerCase(Locale.US).startsWith("tinkhybridencrypt")) {
                format = format + "Maybe call HybridConfig.register().";
            } else if (str.toLowerCase(Locale.US).startsWith("tinkmac")) {
                format = format + "Maybe call MacConfig.register().";
            } else if (str.toLowerCase(Locale.US).startsWith("tinkpublickeysign") || str.toLowerCase(Locale.US).startsWith("tinkpublickeyverify")) {
                format = format + "Maybe call SignatureConfig.register().";
            } else if (str.toLowerCase(Locale.US).startsWith("tink")) {
                format = format + "Maybe call TinkConfig.register().";
            }
            throw new GeneralSecurityException(format);
        }
        throw new IllegalArgumentException("catalogueName must be non-null.");
    }

    public static synchronized <P> void registerKeyManager(KeyManager<P> keyManager) throws GeneralSecurityException {
        synchronized (Registry.class) {
            registerKeyManager(keyManager, true);
        }
    }

    public static synchronized <P> void registerKeyManager(KeyManager<P> keyManager, boolean z) throws GeneralSecurityException {
        synchronized (Registry.class) {
            if (keyManager != null) {
                try {
                    AtomicReference<KeyManagerRegistry> atomicReference = keyManagerRegistry;
                    KeyManagerRegistry keyManagerRegistry2 = new KeyManagerRegistry(atomicReference.get());
                    keyManagerRegistry2.registerKeyManager(keyManager);
                    if (TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS.isCompatible()) {
                        String keyType = keyManager.getKeyType();
                        ensureKeyManagerInsertable(keyType, Collections.emptyMap(), z);
                        newKeyAllowedMap.put(keyType, Boolean.valueOf(z));
                        atomicReference.set(keyManagerRegistry2);
                    } else {
                        throw new GeneralSecurityException("Registering key managers is not supported in FIPS mode");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                throw new IllegalArgumentException("key manager must be non-null.");
            }
        }
    }

    public static synchronized <KeyProtoT extends MessageLite> void registerKeyManager(KeyTypeManager<KeyProtoT> keyTypeManager, boolean z) throws GeneralSecurityException {
        synchronized (Registry.class) {
            if (keyTypeManager != null) {
                AtomicReference<KeyManagerRegistry> atomicReference = keyManagerRegistry;
                KeyManagerRegistry keyManagerRegistry2 = new KeyManagerRegistry(atomicReference.get());
                keyManagerRegistry2.registerKeyManager(keyTypeManager);
                String keyType = keyTypeManager.getKeyType();
                ensureKeyManagerInsertable(keyType, z ? keyTypeManager.keyFactory().keyFormats() : Collections.emptyMap(), z);
                if (!atomicReference.get().typeUrlExists(keyType)) {
                    keyDeriverMap.put(keyType, createDeriverFor(keyTypeManager));
                    if (z) {
                        registerKeyTemplates(keyType, keyTypeManager.keyFactory().keyFormats());
                    }
                }
                newKeyAllowedMap.put(keyType, Boolean.valueOf(z));
                atomicReference.set(keyManagerRegistry2);
            } else {
                throw new IllegalArgumentException("key manager must be non-null.");
            }
        }
    }

    @Deprecated
    public static synchronized <P> void registerKeyManager(String str, KeyManager<P> keyManager) throws GeneralSecurityException {
        synchronized (Registry.class) {
            registerKeyManager(str, keyManager, true);
        }
    }

    @Deprecated
    public static synchronized <P> void registerKeyManager(String str, KeyManager<P> keyManager, boolean z) throws GeneralSecurityException {
        synchronized (Registry.class) {
            if (keyManager != null) {
                try {
                    if (str.equals(keyManager.getKeyType())) {
                        registerKeyManager(keyManager, z);
                    } else {
                        throw new GeneralSecurityException("Manager does not support key type " + str + ".");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                throw new IllegalArgumentException("key manager must be non-null.");
            }
        }
    }

    private static synchronized <KeyProtoT extends MessageLite, KeyFormatProtoT extends MessageLite> void ensureKeyManagerInsertable(String str, Map<String, KeyTypeManager.KeyFactory.KeyFormat<KeyFormatProtoT>> map, boolean z) throws GeneralSecurityException {
        synchronized (Registry.class) {
            if (z) {
                try {
                    ConcurrentMap<String, Boolean> concurrentMap = newKeyAllowedMap;
                    if (concurrentMap.containsKey(str)) {
                        if (!((Boolean) concurrentMap.get(str)).booleanValue()) {
                            throw new GeneralSecurityException("New keys are already disallowed for key type " + str);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (z) {
                if (keyManagerRegistry.get().typeUrlExists(str)) {
                    for (Map.Entry next : map.entrySet()) {
                        if (!keyTemplateMap.containsKey(next.getKey())) {
                            throw new GeneralSecurityException("Attempted to register a new key template " + ((String) next.getKey()) + " from an existing key manager of type " + str);
                        }
                    }
                } else {
                    for (Map.Entry next2 : map.entrySet()) {
                        if (keyTemplateMap.containsKey(next2.getKey())) {
                            throw new GeneralSecurityException("Attempted overwrite of a registered key template " + ((String) next2.getKey()));
                        }
                    }
                }
            }
        }
    }

    public static synchronized <KeyProtoT extends MessageLite, PublicKeyProtoT extends MessageLite> void registerAsymmetricKeyManagers(PrivateKeyTypeManager<KeyProtoT, PublicKeyProtoT> privateKeyTypeManager, KeyTypeManager<PublicKeyProtoT> keyTypeManager, boolean z) throws GeneralSecurityException {
        synchronized (Registry.class) {
            if (privateKeyTypeManager == null || keyTypeManager == null) {
                throw new IllegalArgumentException("given key managers must be non-null.");
            }
            AtomicReference<KeyManagerRegistry> atomicReference = keyManagerRegistry;
            KeyManagerRegistry keyManagerRegistry2 = new KeyManagerRegistry(atomicReference.get());
            keyManagerRegistry2.registerAsymmetricKeyManagers(privateKeyTypeManager, keyTypeManager);
            String keyType = privateKeyTypeManager.getKeyType();
            String keyType2 = keyTypeManager.getKeyType();
            ensureKeyManagerInsertable(keyType, z ? privateKeyTypeManager.keyFactory().keyFormats() : Collections.emptyMap(), z);
            ensureKeyManagerInsertable(keyType2, Collections.emptyMap(), false);
            if (!atomicReference.get().typeUrlExists(keyType)) {
                keyDeriverMap.put(keyType, createDeriverFor(privateKeyTypeManager));
                if (z) {
                    registerKeyTemplates(privateKeyTypeManager.getKeyType(), privateKeyTypeManager.keyFactory().keyFormats());
                }
            }
            ConcurrentMap<String, Boolean> concurrentMap = newKeyAllowedMap;
            concurrentMap.put(keyType, Boolean.valueOf(z));
            concurrentMap.put(keyType2, false);
            atomicReference.set(keyManagerRegistry2);
        }
    }

    private static <KeyFormatProtoT extends MessageLite> void registerKeyTemplates(String str, Map<String, KeyTypeManager.KeyFactory.KeyFormat<KeyFormatProtoT>> map) {
        for (Map.Entry next : map.entrySet()) {
            keyTemplateMap.put((String) next.getKey(), KeyTemplate.create(str, ((MessageLite) ((KeyTypeManager.KeyFactory.KeyFormat) next.getValue()).keyFormat).toByteArray(), ((KeyTypeManager.KeyFactory.KeyFormat) next.getValue()).outputPrefixType));
        }
    }

    public static synchronized <B, P> void registerPrimitiveWrapper(PrimitiveWrapper<B, P> primitiveWrapper) throws GeneralSecurityException {
        synchronized (Registry.class) {
            MutablePrimitiveRegistry.globalInstance().registerPrimitiveWrapper(primitiveWrapper);
        }
    }

    @Deprecated
    public static <P> KeyManager<P> getKeyManager(String str) throws GeneralSecurityException {
        return keyManagerRegistry.get().getKeyManager(str);
    }

    public static <P> KeyManager<P> getKeyManager(String str, Class<P> cls) throws GeneralSecurityException {
        return keyManagerRegistry.get().getKeyManager(str, cls);
    }

    public static KeyManager<?> getUntypedKeyManager(String str) throws GeneralSecurityException {
        return keyManagerRegistry.get().getUntypedKeyManager(str);
    }

    public static synchronized KeyData newKeyData(KeyTemplate keyTemplate) throws GeneralSecurityException {
        KeyData newKeyData;
        synchronized (Registry.class) {
            KeyManager<?> untypedKeyManager = getUntypedKeyManager(keyTemplate.getTypeUrl());
            if (((Boolean) newKeyAllowedMap.get(keyTemplate.getTypeUrl())).booleanValue()) {
                newKeyData = untypedKeyManager.newKeyData(keyTemplate.getValue());
            } else {
                throw new GeneralSecurityException("newKey-operation not permitted for key type " + keyTemplate.getTypeUrl());
            }
        }
        return newKeyData;
    }

    public static synchronized KeyData newKeyData(KeyTemplate keyTemplate) throws GeneralSecurityException {
        KeyData newKeyData;
        synchronized (Registry.class) {
            newKeyData = newKeyData(keyTemplate.getProto());
        }
        return newKeyData;
    }

    public static synchronized MessageLite newKey(KeyTemplate keyTemplate) throws GeneralSecurityException {
        MessageLite newKey;
        synchronized (Registry.class) {
            KeyManager<?> untypedKeyManager = getUntypedKeyManager(keyTemplate.getTypeUrl());
            if (((Boolean) newKeyAllowedMap.get(keyTemplate.getTypeUrl())).booleanValue()) {
                newKey = untypedKeyManager.newKey(keyTemplate.getValue());
            } else {
                throw new GeneralSecurityException("newKey-operation not permitted for key type " + keyTemplate.getTypeUrl());
            }
        }
        return newKey;
    }

    public static synchronized MessageLite newKey(String str, MessageLite messageLite) throws GeneralSecurityException {
        MessageLite newKey;
        synchronized (Registry.class) {
            KeyManager keyManager = getKeyManager(str);
            if (((Boolean) newKeyAllowedMap.get(str)).booleanValue()) {
                newKey = keyManager.newKey(messageLite);
            } else {
                throw new GeneralSecurityException("newKey-operation not permitted for key type " + str);
            }
        }
        return newKey;
    }

    static synchronized KeyData deriveKey(KeyTemplate keyTemplate, InputStream inputStream) throws GeneralSecurityException {
        KeyData deriveKey;
        synchronized (Registry.class) {
            String typeUrl = keyTemplate.getTypeUrl();
            ConcurrentMap<String, KeyDeriverContainer> concurrentMap = keyDeriverMap;
            if (concurrentMap.containsKey(typeUrl)) {
                deriveKey = ((KeyDeriverContainer) concurrentMap.get(typeUrl)).deriveKey(keyTemplate.getValue(), inputStream);
            } else {
                throw new GeneralSecurityException("No keymanager registered or key manager cannot derive keys for " + typeUrl);
            }
        }
        return deriveKey;
    }

    public static KeyData getPublicKeyData(String str, ByteString byteString) throws GeneralSecurityException {
        KeyManager keyManager = getKeyManager(str);
        if (keyManager instanceof PrivateKeyManager) {
            return ((PrivateKeyManager) keyManager).getPublicKeyData(byteString);
        }
        throw new GeneralSecurityException("manager for key type " + str + " is not a PrivateKeyManager");
    }

    @Deprecated
    public static <P> P getPrimitive(String str, MessageLite messageLite) throws GeneralSecurityException {
        return keyManagerRegistry.get().getKeyManager(str).getPrimitive(messageLite);
    }

    public static <P> P getPrimitive(String str, MessageLite messageLite, Class<P> cls) throws GeneralSecurityException {
        return keyManagerRegistry.get().getKeyManager(str, cls).getPrimitive(messageLite);
    }

    @Deprecated
    public static <P> P getPrimitive(String str, ByteString byteString) throws GeneralSecurityException {
        return keyManagerRegistry.get().getKeyManager(str).getPrimitive(byteString);
    }

    public static <P> P getPrimitive(String str, ByteString byteString, Class<P> cls) throws GeneralSecurityException {
        return keyManagerRegistry.get().getKeyManager(str, cls).getPrimitive(byteString);
    }

    @Deprecated
    public static <P> P getPrimitive(String str, byte[] bArr) throws GeneralSecurityException {
        return getPrimitive(str, ByteString.copyFrom(bArr));
    }

    public static <P> P getPrimitive(String str, byte[] bArr, Class<P> cls) throws GeneralSecurityException {
        return getPrimitive(str, ByteString.copyFrom(bArr), cls);
    }

    @Deprecated
    public static <P> P getPrimitive(KeyData keyData) throws GeneralSecurityException {
        return getPrimitive(keyData.getTypeUrl(), keyData.getValue());
    }

    public static <P> P getPrimitive(KeyData keyData, Class<P> cls) throws GeneralSecurityException {
        return getPrimitive(keyData.getTypeUrl(), keyData.getValue(), cls);
    }

    static <KeyT extends Key, P> P getFullPrimitive(KeyT keyt, Class<P> cls) throws GeneralSecurityException {
        return MutablePrimitiveRegistry.globalInstance().getPrimitive(keyt, cls);
    }

    public static <B, P> P wrap(PrimitiveSet<B> primitiveSet, Class<P> cls) throws GeneralSecurityException {
        return MutablePrimitiveRegistry.globalInstance().wrap(primitiveSet, cls);
    }

    public static <P> P wrap(PrimitiveSet<P> primitiveSet) throws GeneralSecurityException {
        return wrap(primitiveSet, primitiveSet.getPrimitiveClass());
    }

    public static synchronized List<String> keyTemplates() {
        List<String> unmodifiableList;
        synchronized (Registry.class) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(keyTemplateMap.keySet());
            unmodifiableList = Collections.unmodifiableList(arrayList);
        }
        return unmodifiableList;
    }

    static synchronized Map<String, KeyTemplate> keyTemplateMap() {
        Map<String, KeyTemplate> unmodifiableMap;
        synchronized (Registry.class) {
            unmodifiableMap = Collections.unmodifiableMap(keyTemplateMap);
        }
        return unmodifiableMap;
    }

    @Nullable
    public static Class<?> getInputPrimitive(Class<?> cls) {
        try {
            return MutablePrimitiveRegistry.globalInstance().getInputPrimitiveClass(cls);
        } catch (GeneralSecurityException unused) {
            return null;
        }
    }

    static MessageLite parseKeyData(KeyData keyData) throws GeneralSecurityException, InvalidProtocolBufferException {
        return keyManagerRegistry.get().parseKeyData(keyData);
    }

    public static synchronized void restrictToFipsIfEmpty() throws GeneralSecurityException {
        synchronized (Registry.class) {
            if (!TinkFipsUtil.useOnlyFips()) {
                if (keyManagerRegistry.get().isEmpty()) {
                    TinkFipsUtil.setFipsRestricted();
                    return;
                }
                throw new GeneralSecurityException("Could not enable FIPS mode as Registry is not empty.");
            }
        }
    }

    private Registry() {
    }
}
