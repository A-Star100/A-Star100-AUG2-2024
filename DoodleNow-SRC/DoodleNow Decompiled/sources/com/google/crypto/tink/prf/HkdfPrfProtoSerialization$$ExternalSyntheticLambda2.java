package com.google.crypto.tink.prf;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.SecretKeyAccess;
import com.google.crypto.tink.internal.KeySerializer;
import com.google.crypto.tink.internal.Serialization;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class HkdfPrfProtoSerialization$$ExternalSyntheticLambda2 implements KeySerializer.KeySerializationFunction {
    public final Serialization serializeKey(Key key, SecretKeyAccess secretKeyAccess) {
        return HkdfPrfProtoSerialization.serializeKey((HkdfPrfKey) key, secretKeyAccess);
    }
}
