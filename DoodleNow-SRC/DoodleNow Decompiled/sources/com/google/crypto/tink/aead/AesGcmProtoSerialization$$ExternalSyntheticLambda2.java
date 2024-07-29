package com.google.crypto.tink.aead;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.SecretKeyAccess;
import com.google.crypto.tink.internal.KeySerializer;
import com.google.crypto.tink.internal.Serialization;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AesGcmProtoSerialization$$ExternalSyntheticLambda2 implements KeySerializer.KeySerializationFunction {
    public final Serialization serializeKey(Key key, SecretKeyAccess secretKeyAccess) {
        return AesGcmProtoSerialization.serializeKey((AesGcmKey) key, secretKeyAccess);
    }
}
