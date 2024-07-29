package com.amazon.device.drm.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.amazon.a.a.o.f;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public final class RequestId implements Parcelable {
    public static final Parcelable.Creator<RequestId> CREATOR = new Parcelable.Creator<RequestId>() {
        public RequestId createFromParcel(Parcel parcel) {
            return new RequestId(parcel);
        }

        public RequestId[] newArray(int i) {
            return new RequestId[i];
        }
    };
    private static final String ENCODED_ID = "encodedId";
    private final String encodedId;

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return this.encodedId;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.encodedId);
    }

    private RequestId(Parcel parcel) {
        this.encodedId = parcel.readString();
    }

    public RequestId() {
        this.encodedId = UUID.randomUUID().toString();
    }

    private RequestId(String str) {
        f.a((Object) str, ENCODED_ID);
        this.encodedId = str;
    }

    public static RequestId fromString(String str) {
        return new RequestId(str);
    }

    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.encodedId.equals(((RequestId) obj).encodedId);
    }

    public int hashCode() {
        String str = this.encodedId;
        return 31 + (str == null ? 0 : str.hashCode());
    }

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ENCODED_ID, this.encodedId);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
