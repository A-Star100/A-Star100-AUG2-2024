package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.LogRequest;
import com.google.firebase.encoders.annotations.Encodable;
import java.util.List;

final class AutoValue_LogRequest extends LogRequest {
    private final ClientInfo clientInfo;
    private final List<LogEvent> logEvents;
    private final Integer logSource;
    private final String logSourceName;
    private final QosTier qosTier;
    private final long requestTimeMs;
    private final long requestUptimeMs;

    public ClientInfo getClientInfo() {
        return this.clientInfo;
    }

    @Encodable.Field(name = "logEvent")
    public List<LogEvent> getLogEvents() {
        return this.logEvents;
    }

    public Integer getLogSource() {
        return this.logSource;
    }

    public String getLogSourceName() {
        return this.logSourceName;
    }

    public QosTier getQosTier() {
        return this.qosTier;
    }

    public long getRequestTimeMs() {
        return this.requestTimeMs;
    }

    public long getRequestUptimeMs() {
        return this.requestUptimeMs;
    }

    private AutoValue_LogRequest(long j, long j2, ClientInfo clientInfo2, Integer num, String str, List<LogEvent> list, QosTier qosTier2) {
        this.requestTimeMs = j;
        this.requestUptimeMs = j2;
        this.clientInfo = clientInfo2;
        this.logSource = num;
        this.logSourceName = str;
        this.logEvents = list;
        this.qosTier = qosTier2;
    }

    public String toString() {
        return "LogRequest{requestTimeMs=" + this.requestTimeMs + ", requestUptimeMs=" + this.requestUptimeMs + ", clientInfo=" + this.clientInfo + ", logSource=" + this.logSource + ", logSourceName=" + this.logSourceName + ", logEvents=" + this.logEvents + ", qosTier=" + this.qosTier + "}";
    }

    public boolean equals(Object obj) {
        ClientInfo clientInfo2;
        Integer num;
        String str;
        List<LogEvent> list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LogRequest)) {
            return false;
        }
        LogRequest logRequest = (LogRequest) obj;
        if (this.requestTimeMs == logRequest.getRequestTimeMs() && this.requestUptimeMs == logRequest.getRequestUptimeMs() && ((clientInfo2 = this.clientInfo) != null ? clientInfo2.equals(logRequest.getClientInfo()) : logRequest.getClientInfo() == null) && ((num = this.logSource) != null ? num.equals(logRequest.getLogSource()) : logRequest.getLogSource() == null) && ((str = this.logSourceName) != null ? str.equals(logRequest.getLogSourceName()) : logRequest.getLogSourceName() == null) && ((list = this.logEvents) != null ? list.equals(logRequest.getLogEvents()) : logRequest.getLogEvents() == null)) {
            QosTier qosTier2 = this.qosTier;
            if (qosTier2 == null) {
                if (logRequest.getQosTier() == null) {
                    return true;
                }
            } else if (qosTier2.equals(logRequest.getQosTier())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i;
        int i2;
        int i3;
        long j = this.requestTimeMs;
        long j2 = this.requestUptimeMs;
        int i4 = (((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003;
        ClientInfo clientInfo2 = this.clientInfo;
        int i5 = 0;
        int hashCode = (i4 ^ (clientInfo2 == null ? 0 : clientInfo2.hashCode())) * 1000003;
        Integer num = this.logSource;
        if (num == null) {
            i = 0;
        } else {
            i = num.hashCode();
        }
        int i6 = (hashCode ^ i) * 1000003;
        String str = this.logSourceName;
        if (str == null) {
            i2 = 0;
        } else {
            i2 = str.hashCode();
        }
        int i7 = (i6 ^ i2) * 1000003;
        List<LogEvent> list = this.logEvents;
        if (list == null) {
            i3 = 0;
        } else {
            i3 = list.hashCode();
        }
        int i8 = (i7 ^ i3) * 1000003;
        QosTier qosTier2 = this.qosTier;
        if (qosTier2 != null) {
            i5 = qosTier2.hashCode();
        }
        return i8 ^ i5;
    }

    static final class Builder extends LogRequest.Builder {
        private ClientInfo clientInfo;
        private List<LogEvent> logEvents;
        private Integer logSource;
        private String logSourceName;
        private QosTier qosTier;
        private Long requestTimeMs;
        private Long requestUptimeMs;

        public LogRequest.Builder setClientInfo(ClientInfo clientInfo2) {
            this.clientInfo = clientInfo2;
            return this;
        }

        public LogRequest.Builder setLogEvents(List<LogEvent> list) {
            this.logEvents = list;
            return this;
        }

        /* access modifiers changed from: package-private */
        public LogRequest.Builder setLogSource(Integer num) {
            this.logSource = num;
            return this;
        }

        /* access modifiers changed from: package-private */
        public LogRequest.Builder setLogSourceName(String str) {
            this.logSourceName = str;
            return this;
        }

        public LogRequest.Builder setQosTier(QosTier qosTier2) {
            this.qosTier = qosTier2;
            return this;
        }

        Builder() {
        }

        public LogRequest.Builder setRequestTimeMs(long j) {
            this.requestTimeMs = Long.valueOf(j);
            return this;
        }

        public LogRequest.Builder setRequestUptimeMs(long j) {
            this.requestUptimeMs = Long.valueOf(j);
            return this;
        }

        public LogRequest build() {
            String str = this.requestTimeMs == null ? " requestTimeMs" : "";
            if (this.requestUptimeMs == null) {
                str = str + " requestUptimeMs";
            }
            if (str.isEmpty()) {
                return new AutoValue_LogRequest(this.requestTimeMs.longValue(), this.requestUptimeMs.longValue(), this.clientInfo, this.logSource, this.logSourceName, this.logEvents, this.qosTier);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
