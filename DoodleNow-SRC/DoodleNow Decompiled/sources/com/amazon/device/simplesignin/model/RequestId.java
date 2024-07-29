package com.amazon.device.simplesignin.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.UUID;

public final class RequestId implements Parcelable {
    public static final Parcelable.Creator<RequestId> CREATOR = new Parcelable.Creator<RequestId>() {
        public RequestId createFromParcel(Parcel parcel) {
            return new RequestId(parcel.readString());
        }

        public RequestId[] newArray(int i) {
            return new RequestId[i];
        }
    };
    private final String id;

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return this.id;
    }

    public RequestId(String str) {
        this.id = str;
    }

    public RequestId() {
        this.id = UUID.randomUUID().toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
    }
}
