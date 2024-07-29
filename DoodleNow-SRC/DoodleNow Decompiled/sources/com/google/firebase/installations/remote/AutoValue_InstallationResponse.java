package com.google.firebase.installations.remote;

import com.google.firebase.installations.remote.InstallationResponse;

final class AutoValue_InstallationResponse extends InstallationResponse {
    private final TokenResult authToken;
    private final String fid;
    private final String refreshToken;
    private final InstallationResponse.ResponseCode responseCode;
    private final String uri;

    public TokenResult getAuthToken() {
        return this.authToken;
    }

    public String getFid() {
        return this.fid;
    }

    public String getRefreshToken() {
        return this.refreshToken;
    }

    public InstallationResponse.ResponseCode getResponseCode() {
        return this.responseCode;
    }

    public String getUri() {
        return this.uri;
    }

    private AutoValue_InstallationResponse(String str, String str2, String str3, TokenResult tokenResult, InstallationResponse.ResponseCode responseCode2) {
        this.uri = str;
        this.fid = str2;
        this.refreshToken = str3;
        this.authToken = tokenResult;
        this.responseCode = responseCode2;
    }

    public String toString() {
        return "InstallationResponse{uri=" + this.uri + ", fid=" + this.fid + ", refreshToken=" + this.refreshToken + ", authToken=" + this.authToken + ", responseCode=" + this.responseCode + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InstallationResponse)) {
            return false;
        }
        InstallationResponse installationResponse = (InstallationResponse) obj;
        String str = this.uri;
        if (str != null ? str.equals(installationResponse.getUri()) : installationResponse.getUri() == null) {
            String str2 = this.fid;
            if (str2 != null ? str2.equals(installationResponse.getFid()) : installationResponse.getFid() == null) {
                String str3 = this.refreshToken;
                if (str3 != null ? str3.equals(installationResponse.getRefreshToken()) : installationResponse.getRefreshToken() == null) {
                    TokenResult tokenResult = this.authToken;
                    if (tokenResult != null ? tokenResult.equals(installationResponse.getAuthToken()) : installationResponse.getAuthToken() == null) {
                        InstallationResponse.ResponseCode responseCode2 = this.responseCode;
                        if (responseCode2 == null) {
                            if (installationResponse.getResponseCode() == null) {
                                return true;
                            }
                        } else if (responseCode2.equals(installationResponse.getResponseCode())) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int i;
        int i2;
        int i3;
        String str = this.uri;
        int i4 = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.fid;
        if (str2 == null) {
            i = 0;
        } else {
            i = str2.hashCode();
        }
        int i5 = (hashCode ^ i) * 1000003;
        String str3 = this.refreshToken;
        if (str3 == null) {
            i2 = 0;
        } else {
            i2 = str3.hashCode();
        }
        int i6 = (i5 ^ i2) * 1000003;
        TokenResult tokenResult = this.authToken;
        if (tokenResult == null) {
            i3 = 0;
        } else {
            i3 = tokenResult.hashCode();
        }
        int i7 = (i6 ^ i3) * 1000003;
        InstallationResponse.ResponseCode responseCode2 = this.responseCode;
        if (responseCode2 != null) {
            i4 = responseCode2.hashCode();
        }
        return i7 ^ i4;
    }

    public InstallationResponse.Builder toBuilder() {
        return new Builder(this);
    }

    static final class Builder extends InstallationResponse.Builder {
        private TokenResult authToken;
        private String fid;
        private String refreshToken;
        private InstallationResponse.ResponseCode responseCode;
        private String uri;

        public InstallationResponse.Builder setAuthToken(TokenResult tokenResult) {
            this.authToken = tokenResult;
            return this;
        }

        public InstallationResponse.Builder setFid(String str) {
            this.fid = str;
            return this;
        }

        public InstallationResponse.Builder setRefreshToken(String str) {
            this.refreshToken = str;
            return this;
        }

        public InstallationResponse.Builder setResponseCode(InstallationResponse.ResponseCode responseCode2) {
            this.responseCode = responseCode2;
            return this;
        }

        public InstallationResponse.Builder setUri(String str) {
            this.uri = str;
            return this;
        }

        Builder() {
        }

        private Builder(InstallationResponse installationResponse) {
            this.uri = installationResponse.getUri();
            this.fid = installationResponse.getFid();
            this.refreshToken = installationResponse.getRefreshToken();
            this.authToken = installationResponse.getAuthToken();
            this.responseCode = installationResponse.getResponseCode();
        }

        public InstallationResponse build() {
            return new AutoValue_InstallationResponse(this.uri, this.fid, this.refreshToken, this.authToken, this.responseCode);
        }
    }
}
