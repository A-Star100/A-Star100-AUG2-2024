package com.google.crypto.tink.tinkkey;

import com.google.errorprone.annotations.Immutable;

@Immutable
@Deprecated
public final class KeyAccess {
    private final boolean canAccessSecret;

    public boolean canAccessSecret() {
        return this.canAccessSecret;
    }

    private KeyAccess(boolean z) {
        this.canAccessSecret = z;
    }

    public static KeyAccess publicAccess() {
        return new KeyAccess(false);
    }

    static KeyAccess secretAccess() {
        return new KeyAccess(true);
    }
}
