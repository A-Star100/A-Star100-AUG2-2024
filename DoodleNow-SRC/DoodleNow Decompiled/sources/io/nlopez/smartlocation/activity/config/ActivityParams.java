package io.nlopez.smartlocation.activity.config;

public class ActivityParams {
    public static final ActivityParams NORMAL = new Builder().setInterval(500).build();
    private long interval;

    public long getInterval() {
        return this.interval;
    }

    public int hashCode() {
        long j = this.interval;
        return (int) (j ^ (j >>> 32));
    }

    ActivityParams(long j) {
        this.interval = j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityParams)) {
            return false;
        }
        if (this.interval == ((ActivityParams) obj).interval) {
            return true;
        }
        return false;
    }

    public static class Builder {
        private long interval;

        public Builder setInterval(long j) {
            this.interval = j;
            return this;
        }

        public ActivityParams build() {
            return new ActivityParams(this.interval);
        }
    }
}
