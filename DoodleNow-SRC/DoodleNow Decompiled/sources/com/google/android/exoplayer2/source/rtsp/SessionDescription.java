package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.HashMap;

final class SessionDescription {
    public static final String ATTR_CONTROL = "control";
    public static final String ATTR_FMTP = "fmtp";
    public static final String ATTR_LENGTH = "length";
    public static final String ATTR_RANGE = "range";
    public static final String ATTR_RTPMAP = "rtpmap";
    public static final String ATTR_TOOL = "tool";
    public static final String ATTR_TYPE = "type";
    public static final String SUPPORTED_SDP_VERSION = "0";
    public final ImmutableMap<String, String> attributes;
    public final int bitrate;
    public final String connection;
    public final String emailAddress;
    public final String key;
    public final ImmutableList<MediaDescription> mediaDescriptionList;
    public final String origin;
    public final String phoneNumber;
    public final String sessionInfo;
    public final String sessionName;
    public final String timing;
    public final Uri uri;

    public static final class Builder {
        /* access modifiers changed from: private */
        public final HashMap<String, String> attributes = new HashMap<>();
        /* access modifiers changed from: private */
        public int bitrate = -1;
        /* access modifiers changed from: private */
        public String connection;
        /* access modifiers changed from: private */
        public String emailAddress;
        /* access modifiers changed from: private */
        public String key;
        /* access modifiers changed from: private */
        public final ImmutableList.Builder<MediaDescription> mediaDescriptionListBuilder = new ImmutableList.Builder<>();
        /* access modifiers changed from: private */
        public String origin;
        /* access modifiers changed from: private */
        public String phoneNumber;
        /* access modifiers changed from: private */
        public String sessionInfo;
        /* access modifiers changed from: private */
        public String sessionName;
        /* access modifiers changed from: private */
        public String timing;
        /* access modifiers changed from: private */
        public Uri uri;

        public Builder setBitrate(int i) {
            this.bitrate = i;
            return this;
        }

        public Builder setConnection(String str) {
            this.connection = str;
            return this;
        }

        public Builder setEmailAddress(String str) {
            this.emailAddress = str;
            return this;
        }

        public Builder setKey(String str) {
            this.key = str;
            return this;
        }

        public Builder setOrigin(String str) {
            this.origin = str;
            return this;
        }

        public Builder setPhoneNumber(String str) {
            this.phoneNumber = str;
            return this;
        }

        public Builder setSessionInfo(String str) {
            this.sessionInfo = str;
            return this;
        }

        public Builder setSessionName(String str) {
            this.sessionName = str;
            return this;
        }

        public Builder setTiming(String str) {
            this.timing = str;
            return this;
        }

        public Builder setUri(Uri uri2) {
            this.uri = uri2;
            return this;
        }

        public Builder addAttribute(String str, String str2) {
            this.attributes.put(str, str2);
            return this;
        }

        public Builder addMediaDescription(MediaDescription mediaDescription) {
            this.mediaDescriptionListBuilder.add((Object) mediaDescription);
            return this;
        }

        public SessionDescription build() {
            return new SessionDescription(this);
        }
    }

    private SessionDescription(Builder builder) {
        this.attributes = ImmutableMap.copyOf(builder.attributes);
        this.mediaDescriptionList = builder.mediaDescriptionListBuilder.build();
        this.sessionName = (String) Util.castNonNull(builder.sessionName);
        this.origin = (String) Util.castNonNull(builder.origin);
        this.timing = (String) Util.castNonNull(builder.timing);
        this.uri = builder.uri;
        this.connection = builder.connection;
        this.bitrate = builder.bitrate;
        this.key = builder.key;
        this.emailAddress = builder.emailAddress;
        this.phoneNumber = builder.phoneNumber;
        this.sessionInfo = builder.sessionInfo;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SessionDescription sessionDescription = (SessionDescription) obj;
        if (this.bitrate != sessionDescription.bitrate || !this.attributes.equals(sessionDescription.attributes) || !this.mediaDescriptionList.equals(sessionDescription.mediaDescriptionList) || !Util.areEqual(this.origin, sessionDescription.origin) || !Util.areEqual(this.sessionName, sessionDescription.sessionName) || !Util.areEqual(this.timing, sessionDescription.timing) || !Util.areEqual(this.sessionInfo, sessionDescription.sessionInfo) || !Util.areEqual(this.uri, sessionDescription.uri) || !Util.areEqual(this.emailAddress, sessionDescription.emailAddress) || !Util.areEqual(this.phoneNumber, sessionDescription.phoneNumber) || !Util.areEqual(this.connection, sessionDescription.connection) || !Util.areEqual(this.key, sessionDescription.key)) {
            return false;
        }
        return true;
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
        int hashCode = (((JfifUtil.MARKER_EOI + this.attributes.hashCode()) * 31) + this.mediaDescriptionList.hashCode()) * 31;
        String str = this.origin;
        int i9 = 0;
        if (str == null) {
            i = 0;
        } else {
            i = str.hashCode();
        }
        int i10 = (hashCode + i) * 31;
        String str2 = this.sessionName;
        if (str2 == null) {
            i2 = 0;
        } else {
            i2 = str2.hashCode();
        }
        int i11 = (i10 + i2) * 31;
        String str3 = this.timing;
        if (str3 == null) {
            i3 = 0;
        } else {
            i3 = str3.hashCode();
        }
        int i12 = (((i11 + i3) * 31) + this.bitrate) * 31;
        String str4 = this.sessionInfo;
        if (str4 == null) {
            i4 = 0;
        } else {
            i4 = str4.hashCode();
        }
        int i13 = (i12 + i4) * 31;
        Uri uri2 = this.uri;
        if (uri2 == null) {
            i5 = 0;
        } else {
            i5 = uri2.hashCode();
        }
        int i14 = (i13 + i5) * 31;
        String str5 = this.emailAddress;
        if (str5 == null) {
            i6 = 0;
        } else {
            i6 = str5.hashCode();
        }
        int i15 = (i14 + i6) * 31;
        String str6 = this.phoneNumber;
        if (str6 == null) {
            i7 = 0;
        } else {
            i7 = str6.hashCode();
        }
        int i16 = (i15 + i7) * 31;
        String str7 = this.connection;
        if (str7 == null) {
            i8 = 0;
        } else {
            i8 = str7.hashCode();
        }
        int i17 = (i16 + i8) * 31;
        String str8 = this.key;
        if (str8 != null) {
            i9 = str8.hashCode();
        }
        return i17 + i9;
    }
}
