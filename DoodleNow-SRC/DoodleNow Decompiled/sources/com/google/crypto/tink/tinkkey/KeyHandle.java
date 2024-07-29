package com.google.crypto.tink.tinkkey;

import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.tinkkey.internal.ProtoKey;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;

@Immutable
@Deprecated
public class KeyHandle {
    private final int id;
    private final TinkKey key;
    private final KeyStatusType status;

    public enum KeyStatusType {
        ENABLED,
        DISABLED,
        DESTROYED
    }

    public int getId() {
        return this.id;
    }

    public KeyStatusType getStatus() {
        return this.status;
    }

    public static KeyHandle createFromKey(TinkKey tinkKey, KeyAccess keyAccess) throws GeneralSecurityException {
        KeyHandle keyHandle = new KeyHandle(tinkKey);
        keyHandle.checkAccess(keyAccess);
        return keyHandle;
    }

    @Deprecated
    public static KeyHandle createFromKey(KeyData keyData, KeyTemplate.OutputPrefixType outputPrefixType) {
        return new KeyHandle(new ProtoKey(keyData, outputPrefixType));
    }

    private KeyHandle(TinkKey tinkKey) {
        this.key = tinkKey;
        this.status = KeyStatusType.ENABLED;
        this.id = Util.randKeyId();
    }

    protected KeyHandle(TinkKey tinkKey, KeyStatusType keyStatusType, int i) {
        this.key = tinkKey;
        this.status = keyStatusType;
        this.id = i;
    }

    public static KeyHandle generateNew(KeyTemplate keyTemplate) throws GeneralSecurityException {
        return new KeyHandle(new ProtoKey(Registry.newKeyData(keyTemplate), keyTemplate.getOutputPrefixType()));
    }

    public boolean hasSecret() {
        return this.key.hasSecret();
    }

    public TinkKey getKey(KeyAccess keyAccess) throws GeneralSecurityException {
        checkAccess(keyAccess);
        return this.key;
    }

    public KeyTemplate getKeyTemplate() {
        return this.key.getKeyTemplate();
    }

    private void checkAccess(KeyAccess keyAccess) throws GeneralSecurityException {
        if (hasSecret() && !keyAccess.canAccessSecret()) {
            throw new GeneralSecurityException("No access");
        }
    }
}
