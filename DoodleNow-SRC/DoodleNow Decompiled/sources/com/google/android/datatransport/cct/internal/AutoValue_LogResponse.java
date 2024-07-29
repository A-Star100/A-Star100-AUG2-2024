package com.google.android.datatransport.cct.internal;

final class AutoValue_LogResponse extends LogResponse {
    private final long nextRequestWaitMillis;

    public long getNextRequestWaitMillis() {
        return this.nextRequestWaitMillis;
    }

    public int hashCode() {
        long j = this.nextRequestWaitMillis;
        return ((int) (j ^ (j >>> 32))) ^ 1000003;
    }

    AutoValue_LogResponse(long j) {
        this.nextRequestWaitMillis = j;
    }

    public String toString() {
        return "LogResponse{nextRequestWaitMillis=" + this.nextRequestWaitMillis + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LogResponse)) {
            return false;
        }
        if (this.nextRequestWaitMillis == ((LogResponse) obj).getNextRequestWaitMillis()) {
            return true;
        }
        return false;
    }
}
