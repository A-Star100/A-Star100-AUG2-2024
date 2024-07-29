package com.google.crypto.tink.signature;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.SecretKeyAccess;
import com.google.crypto.tink.internal.KeySerializer;
import com.google.crypto.tink.internal.Serialization;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class EcdsaProtoSerialization$$ExternalSyntheticLambda4 implements KeySerializer.KeySerializationFunction {
    public final Serialization serializeKey(Key key, SecretKeyAccess secretKeyAccess) {
        return EcdsaProtoSerialization.serializePrivateKey((EcdsaPrivateKey) key, secretKeyAccess);
    }
}
