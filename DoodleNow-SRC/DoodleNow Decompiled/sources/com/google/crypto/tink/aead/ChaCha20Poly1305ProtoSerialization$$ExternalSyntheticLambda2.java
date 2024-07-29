package com.google.crypto.tink.aead;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.SecretKeyAccess;
import com.google.crypto.tink.internal.KeySerializer;
import com.google.crypto.tink.internal.Serialization;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ChaCha20Poly1305ProtoSerialization$$ExternalSyntheticLambda2 implements KeySerializer.KeySerializationFunction {
    public final Serialization serializeKey(Key key, SecretKeyAccess secretKeyAccess) {
        return ChaCha20Poly1305ProtoSerialization.serializeKey((ChaCha20Poly1305Key) key, secretKeyAccess);
    }
}
