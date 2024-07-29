package androidx.camera.core.processing;

import androidx.camera.core.processing.OpenGlRenderer;

final class AutoValue_OpenGlRenderer_GraphicDeviceInfo extends OpenGlRenderer.GraphicDeviceInfo {
    private final String eglExtensions;
    private final String eglVersion;
    private final String glExtensions;
    private final String glVersion;

    public String getEglExtensions() {
        return this.eglExtensions;
    }

    public String getEglVersion() {
        return this.eglVersion;
    }

    public String getGlExtensions() {
        return this.glExtensions;
    }

    public String getGlVersion() {
        return this.glVersion;
    }

    private AutoValue_OpenGlRenderer_GraphicDeviceInfo(String str, String str2, String str3, String str4) {
        this.glVersion = str;
        this.eglVersion = str2;
        this.glExtensions = str3;
        this.eglExtensions = str4;
    }

    public String toString() {
        return "GraphicDeviceInfo{glVersion=" + this.glVersion + ", eglVersion=" + this.eglVersion + ", glExtensions=" + this.glExtensions + ", eglExtensions=" + this.eglExtensions + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OpenGlRenderer.GraphicDeviceInfo)) {
            return false;
        }
        OpenGlRenderer.GraphicDeviceInfo graphicDeviceInfo = (OpenGlRenderer.GraphicDeviceInfo) obj;
        if (!this.glVersion.equals(graphicDeviceInfo.getGlVersion()) || !this.eglVersion.equals(graphicDeviceInfo.getEglVersion()) || !this.glExtensions.equals(graphicDeviceInfo.getGlExtensions()) || !this.eglExtensions.equals(graphicDeviceInfo.getEglExtensions())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((((this.glVersion.hashCode() ^ 1000003) * 1000003) ^ this.eglVersion.hashCode()) * 1000003) ^ this.glExtensions.hashCode()) * 1000003) ^ this.eglExtensions.hashCode();
    }

    static final class Builder extends OpenGlRenderer.GraphicDeviceInfo.Builder {
        private String eglExtensions;
        private String eglVersion;
        private String glExtensions;
        private String glVersion;

        Builder() {
        }

        /* access modifiers changed from: package-private */
        public OpenGlRenderer.GraphicDeviceInfo.Builder setGlVersion(String str) {
            if (str != null) {
                this.glVersion = str;
                return this;
            }
            throw new NullPointerException("Null glVersion");
        }

        /* access modifiers changed from: package-private */
        public OpenGlRenderer.GraphicDeviceInfo.Builder setEglVersion(String str) {
            if (str != null) {
                this.eglVersion = str;
                return this;
            }
            throw new NullPointerException("Null eglVersion");
        }

        /* access modifiers changed from: package-private */
        public OpenGlRenderer.GraphicDeviceInfo.Builder setGlExtensions(String str) {
            if (str != null) {
                this.glExtensions = str;
                return this;
            }
            throw new NullPointerException("Null glExtensions");
        }

        /* access modifiers changed from: package-private */
        public OpenGlRenderer.GraphicDeviceInfo.Builder setEglExtensions(String str) {
            if (str != null) {
                this.eglExtensions = str;
                return this;
            }
            throw new NullPointerException("Null eglExtensions");
        }

        /* access modifiers changed from: package-private */
        public OpenGlRenderer.GraphicDeviceInfo build() {
            String str = this.glVersion == null ? " glVersion" : "";
            if (this.eglVersion == null) {
                str = str + " eglVersion";
            }
            if (this.glExtensions == null) {
                str = str + " glExtensions";
            }
            if (this.eglExtensions == null) {
                str = str + " eglExtensions";
            }
            if (str.isEmpty()) {
                return new AutoValue_OpenGlRenderer_GraphicDeviceInfo(this.glVersion, this.eglVersion, this.glExtensions, this.eglExtensions);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
