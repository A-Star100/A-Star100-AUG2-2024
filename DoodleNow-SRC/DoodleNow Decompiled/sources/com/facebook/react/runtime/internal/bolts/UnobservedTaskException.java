package com.facebook.react.runtime.internal.bolts;

class UnobservedTaskException extends RuntimeException {
    public UnobservedTaskException(Throwable th) {
        super(th);
    }
}
