package com.google.crypto.tink.aead;

import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.internal.ParametersSerializer;
import com.google.crypto.tink.internal.Serialization;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AesEaxProtoSerialization$$ExternalSyntheticLambda0 implements ParametersSerializer.ParametersSerializationFunction {
    public final Serialization serializeParameters(Parameters parameters) {
        return AesEaxProtoSerialization.serializeParameters((AesEaxParameters) parameters);
    }
}
