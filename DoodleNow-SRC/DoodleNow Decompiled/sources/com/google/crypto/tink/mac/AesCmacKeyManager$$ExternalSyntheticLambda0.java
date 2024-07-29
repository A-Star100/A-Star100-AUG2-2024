package com.google.crypto.tink.mac;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.internal.PrimitiveConstructor;
import com.google.crypto.tink.mac.internal.ChunkedAesCmacImpl;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AesCmacKeyManager$$ExternalSyntheticLambda0 implements PrimitiveConstructor.PrimitiveConstructionFunction {
    public final Object constructPrimitive(Key key) {
        return new ChunkedAesCmacImpl((AesCmacKey) key);
    }
}
