package com.google.crypto.tink.prf;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.SecretKeyAccess;
import com.google.crypto.tink.internal.KeyParser;
import com.google.crypto.tink.internal.ProtoKeySerialization;
import com.google.crypto.tink.internal.Serialization;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class HkdfPrfProtoSerialization$$ExternalSyntheticLambda3 implements KeyParser.KeyParsingFunction {
    public final Key parseKey(Serialization serialization, SecretKeyAccess secretKeyAccess) {
        return HkdfPrfProtoSerialization.parseKey((ProtoKeySerialization) serialization, secretKeyAccess);
    }
}
