package com.polidea.rxandroidble2.scan;

import android.os.Parcel;
import android.os.Parcelable;
import com.polidea.rxandroidble2.internal.scan.ExternalScanSettingsExtension;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class ScanSettings implements Parcelable, ExternalScanSettingsExtension<ScanSettings> {
    public static final int CALLBACK_TYPE_ALL_MATCHES = 1;
    public static final int CALLBACK_TYPE_FIRST_MATCH = 2;
    public static final int CALLBACK_TYPE_MATCH_LOST = 4;
    public static final Parcelable.Creator<ScanSettings> CREATOR = new Parcelable.Creator<ScanSettings>() {
        public ScanSettings[] newArray(int i) {
            return new ScanSettings[i];
        }

        public ScanSettings createFromParcel(Parcel parcel) {
            return new ScanSettings(parcel);
        }
    };
    public static final int MATCH_MODE_AGGRESSIVE = 1;
    public static final int MATCH_MODE_STICKY = 2;
    public static final int MATCH_NUM_FEW_ADVERTISEMENT = 2;
    public static final int MATCH_NUM_MAX_ADVERTISEMENT = 3;
    public static final int MATCH_NUM_ONE_ADVERTISEMENT = 1;
    public static final int SCAN_MODE_BALANCED = 1;
    public static final int SCAN_MODE_LOW_LATENCY = 2;
    public static final int SCAN_MODE_LOW_POWER = 0;
    public static final int SCAN_MODE_OPPORTUNISTIC = -1;
    private int mCallbackType;
    private boolean mLegacy;
    private int mMatchMode;
    private int mNumOfMatchesPerFilter;
    private long mReportDelayMillis;
    private int mScanMode;
    private boolean mShouldCheckLocationProviderState;

    @Retention(RetentionPolicy.SOURCE)
    public @interface CallbackType {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface MatchMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface MatchNum {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ScanMode {
    }

    public int describeContents() {
        return 0;
    }

    public int getCallbackType() {
        return this.mCallbackType;
    }

    public boolean getLegacy() {
        return this.mLegacy;
    }

    public int getMatchMode() {
        return this.mMatchMode;
    }

    public int getNumOfMatches() {
        return this.mNumOfMatchesPerFilter;
    }

    public long getReportDelayMillis() {
        return this.mReportDelayMillis;
    }

    public int getScanMode() {
        return this.mScanMode;
    }

    public boolean shouldCheckLocationProviderState() {
        return this.mShouldCheckLocationProviderState;
    }

    ScanSettings(int i, int i2, long j, int i3, int i4, boolean z, boolean z2) {
        this.mScanMode = i;
        this.mCallbackType = i2;
        this.mReportDelayMillis = j;
        this.mNumOfMatchesPerFilter = i4;
        this.mMatchMode = i3;
        this.mLegacy = z;
        this.mShouldCheckLocationProviderState = z2;
    }

    ScanSettings(Parcel parcel) {
        this.mScanMode = parcel.readInt();
        this.mCallbackType = parcel.readInt();
        this.mReportDelayMillis = parcel.readLong();
        this.mMatchMode = parcel.readInt();
        this.mNumOfMatchesPerFilter = parcel.readInt();
        boolean z = true;
        this.mLegacy = parcel.readInt() != 0;
        this.mShouldCheckLocationProviderState = parcel.readInt() == 0 ? false : z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mScanMode);
        parcel.writeInt(this.mCallbackType);
        parcel.writeLong(this.mReportDelayMillis);
        parcel.writeInt(this.mMatchMode);
        parcel.writeInt(this.mNumOfMatchesPerFilter);
        parcel.writeInt(this.mLegacy ? 1 : 0);
        parcel.writeInt(this.mShouldCheckLocationProviderState ? 1 : 0);
    }

    public ScanSettings copyWithCallbackType(int i) {
        return new ScanSettings(this.mScanMode, i, this.mReportDelayMillis, this.mMatchMode, this.mNumOfMatchesPerFilter, this.mLegacy, this.mShouldCheckLocationProviderState);
    }

    public static final class Builder implements ExternalScanSettingsExtension.Builder {
        private int mCallbackType = 1;
        private boolean mLegacy = true;
        private int mMatchMode = 1;
        private int mNumOfMatchesPerFilter = 3;
        private long mReportDelayMillis = 0;
        private int mScanMode = 0;
        private boolean mShouldCheckLocationProviderState = true;

        private static boolean isValidCallbackType(int i) {
            return i == 1 || i == 2 || i == 4 || i == 6;
        }

        public Builder setLegacy(boolean z) {
            this.mLegacy = z;
            return this;
        }

        public Builder setShouldCheckLocationServicesState(boolean z) {
            this.mShouldCheckLocationProviderState = z;
            return this;
        }

        public Builder setScanMode(int i) {
            if (i < -1 || i > 2) {
                throw new IllegalArgumentException("invalid scan mode " + i);
            }
            this.mScanMode = i;
            return this;
        }

        public Builder setCallbackType(int i) {
            if (isValidCallbackType(i)) {
                this.mCallbackType = i;
                return this;
            }
            throw new IllegalArgumentException("invalid callback type - " + i);
        }

        public ScanSettings build() {
            return new ScanSettings(this.mScanMode, this.mCallbackType, this.mReportDelayMillis, this.mMatchMode, this.mNumOfMatchesPerFilter, this.mLegacy, this.mShouldCheckLocationProviderState);
        }
    }
}
