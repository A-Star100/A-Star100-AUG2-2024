package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.AndroidClientInfo;

final class AutoValue_AndroidClientInfo extends AndroidClientInfo {
    private final String applicationBuild;
    private final String country;
    private final String device;
    private final String fingerprint;
    private final String hardware;
    private final String locale;
    private final String manufacturer;
    private final String mccMnc;
    private final String model;
    private final String osBuild;
    private final String product;
    private final Integer sdkVersion;

    public String getApplicationBuild() {
        return this.applicationBuild;
    }

    public String getCountry() {
        return this.country;
    }

    public String getDevice() {
        return this.device;
    }

    public String getFingerprint() {
        return this.fingerprint;
    }

    public String getHardware() {
        return this.hardware;
    }

    public String getLocale() {
        return this.locale;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public String getMccMnc() {
        return this.mccMnc;
    }

    public String getModel() {
        return this.model;
    }

    public String getOsBuild() {
        return this.osBuild;
    }

    public String getProduct() {
        return this.product;
    }

    public Integer getSdkVersion() {
        return this.sdkVersion;
    }

    private AutoValue_AndroidClientInfo(Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.sdkVersion = num;
        this.model = str;
        this.hardware = str2;
        this.device = str3;
        this.product = str4;
        this.osBuild = str5;
        this.manufacturer = str6;
        this.fingerprint = str7;
        this.locale = str8;
        this.country = str9;
        this.mccMnc = str10;
        this.applicationBuild = str11;
    }

    public String toString() {
        return "AndroidClientInfo{sdkVersion=" + this.sdkVersion + ", model=" + this.model + ", hardware=" + this.hardware + ", device=" + this.device + ", product=" + this.product + ", osBuild=" + this.osBuild + ", manufacturer=" + this.manufacturer + ", fingerprint=" + this.fingerprint + ", locale=" + this.locale + ", country=" + this.country + ", mccMnc=" + this.mccMnc + ", applicationBuild=" + this.applicationBuild + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AndroidClientInfo)) {
            return false;
        }
        AndroidClientInfo androidClientInfo = (AndroidClientInfo) obj;
        Integer num = this.sdkVersion;
        if (num != null ? num.equals(androidClientInfo.getSdkVersion()) : androidClientInfo.getSdkVersion() == null) {
            String str = this.model;
            if (str != null ? str.equals(androidClientInfo.getModel()) : androidClientInfo.getModel() == null) {
                String str2 = this.hardware;
                if (str2 != null ? str2.equals(androidClientInfo.getHardware()) : androidClientInfo.getHardware() == null) {
                    String str3 = this.device;
                    if (str3 != null ? str3.equals(androidClientInfo.getDevice()) : androidClientInfo.getDevice() == null) {
                        String str4 = this.product;
                        if (str4 != null ? str4.equals(androidClientInfo.getProduct()) : androidClientInfo.getProduct() == null) {
                            String str5 = this.osBuild;
                            if (str5 != null ? str5.equals(androidClientInfo.getOsBuild()) : androidClientInfo.getOsBuild() == null) {
                                String str6 = this.manufacturer;
                                if (str6 != null ? str6.equals(androidClientInfo.getManufacturer()) : androidClientInfo.getManufacturer() == null) {
                                    String str7 = this.fingerprint;
                                    if (str7 != null ? str7.equals(androidClientInfo.getFingerprint()) : androidClientInfo.getFingerprint() == null) {
                                        String str8 = this.locale;
                                        if (str8 != null ? str8.equals(androidClientInfo.getLocale()) : androidClientInfo.getLocale() == null) {
                                            String str9 = this.country;
                                            if (str9 != null ? str9.equals(androidClientInfo.getCountry()) : androidClientInfo.getCountry() == null) {
                                                String str10 = this.mccMnc;
                                                if (str10 != null ? str10.equals(androidClientInfo.getMccMnc()) : androidClientInfo.getMccMnc() == null) {
                                                    String str11 = this.applicationBuild;
                                                    if (str11 == null) {
                                                        if (androidClientInfo.getApplicationBuild() == null) {
                                                            return true;
                                                        }
                                                    } else if (str11.equals(androidClientInfo.getApplicationBuild())) {
                                                        return true;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
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
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        Integer num = this.sdkVersion;
        int i11 = 0;
        int hashCode = ((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003;
        String str = this.model;
        if (str == null) {
            i = 0;
        } else {
            i = str.hashCode();
        }
        int i12 = (hashCode ^ i) * 1000003;
        String str2 = this.hardware;
        if (str2 == null) {
            i2 = 0;
        } else {
            i2 = str2.hashCode();
        }
        int i13 = (i12 ^ i2) * 1000003;
        String str3 = this.device;
        if (str3 == null) {
            i3 = 0;
        } else {
            i3 = str3.hashCode();
        }
        int i14 = (i13 ^ i3) * 1000003;
        String str4 = this.product;
        if (str4 == null) {
            i4 = 0;
        } else {
            i4 = str4.hashCode();
        }
        int i15 = (i14 ^ i4) * 1000003;
        String str5 = this.osBuild;
        if (str5 == null) {
            i5 = 0;
        } else {
            i5 = str5.hashCode();
        }
        int i16 = (i15 ^ i5) * 1000003;
        String str6 = this.manufacturer;
        if (str6 == null) {
            i6 = 0;
        } else {
            i6 = str6.hashCode();
        }
        int i17 = (i16 ^ i6) * 1000003;
        String str7 = this.fingerprint;
        if (str7 == null) {
            i7 = 0;
        } else {
            i7 = str7.hashCode();
        }
        int i18 = (i17 ^ i7) * 1000003;
        String str8 = this.locale;
        if (str8 == null) {
            i8 = 0;
        } else {
            i8 = str8.hashCode();
        }
        int i19 = (i18 ^ i8) * 1000003;
        String str9 = this.country;
        if (str9 == null) {
            i9 = 0;
        } else {
            i9 = str9.hashCode();
        }
        int i20 = (i19 ^ i9) * 1000003;
        String str10 = this.mccMnc;
        if (str10 == null) {
            i10 = 0;
        } else {
            i10 = str10.hashCode();
        }
        int i21 = (i20 ^ i10) * 1000003;
        String str11 = this.applicationBuild;
        if (str11 != null) {
            i11 = str11.hashCode();
        }
        return i21 ^ i11;
    }

    static final class Builder extends AndroidClientInfo.Builder {
        private String applicationBuild;
        private String country;
        private String device;
        private String fingerprint;
        private String hardware;
        private String locale;
        private String manufacturer;
        private String mccMnc;
        private String model;
        private String osBuild;
        private String product;
        private Integer sdkVersion;

        public AndroidClientInfo.Builder setApplicationBuild(String str) {
            this.applicationBuild = str;
            return this;
        }

        public AndroidClientInfo.Builder setCountry(String str) {
            this.country = str;
            return this;
        }

        public AndroidClientInfo.Builder setDevice(String str) {
            this.device = str;
            return this;
        }

        public AndroidClientInfo.Builder setFingerprint(String str) {
            this.fingerprint = str;
            return this;
        }

        public AndroidClientInfo.Builder setHardware(String str) {
            this.hardware = str;
            return this;
        }

        public AndroidClientInfo.Builder setLocale(String str) {
            this.locale = str;
            return this;
        }

        public AndroidClientInfo.Builder setManufacturer(String str) {
            this.manufacturer = str;
            return this;
        }

        public AndroidClientInfo.Builder setMccMnc(String str) {
            this.mccMnc = str;
            return this;
        }

        public AndroidClientInfo.Builder setModel(String str) {
            this.model = str;
            return this;
        }

        public AndroidClientInfo.Builder setOsBuild(String str) {
            this.osBuild = str;
            return this;
        }

        public AndroidClientInfo.Builder setProduct(String str) {
            this.product = str;
            return this;
        }

        public AndroidClientInfo.Builder setSdkVersion(Integer num) {
            this.sdkVersion = num;
            return this;
        }

        Builder() {
        }

        public AndroidClientInfo build() {
            return new AutoValue_AndroidClientInfo(this.sdkVersion, this.model, this.hardware, this.device, this.product, this.osBuild, this.manufacturer, this.fingerprint, this.locale, this.country, this.mccMnc, this.applicationBuild);
        }
    }
}
