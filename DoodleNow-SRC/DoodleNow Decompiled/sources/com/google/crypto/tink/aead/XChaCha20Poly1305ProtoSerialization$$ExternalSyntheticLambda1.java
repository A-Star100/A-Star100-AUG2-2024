package com.google.crypto.tink.aead;

import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.internal.ParametersParser;
import com.google.crypto.tink.internal.ProtoParametersSerialization;
import com.google.crypto.tink.internal.Serialization;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class XChaCha20Poly1305ProtoSerialization$$ExternalSyntheticLambda1 implements ParametersParser.ParametersParsingFunction {
    public final Parameters parseParameters(Serialization serialization) {
        return XChaCha20Poly1305ProtoSerialization.parseParameters((ProtoParametersSerialization) serialization);
    }
}
