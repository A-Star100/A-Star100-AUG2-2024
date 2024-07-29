package androidx.webkit;

import com.bleplx.adapter.utils.Constants;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;

public class WebMessageCompat {
    public static final int TYPE_ARRAY_BUFFER = 1;
    public static final int TYPE_STRING = 0;
    private final byte[] mArrayBuffer;
    private final WebMessagePortCompat[] mPorts;
    private final String mString;
    private final int mType;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {
    }

    private String typeToString(int i) {
        return i != 0 ? i != 1 ? Constants.BluetoothState.UNKNOWN : "ArrayBuffer" : "String";
    }

    public WebMessagePortCompat[] getPorts() {
        return this.mPorts;
    }

    public int getType() {
        return this.mType;
    }

    public WebMessageCompat(String str) {
        this(str, (WebMessagePortCompat[]) null);
    }

    public WebMessageCompat(String str, WebMessagePortCompat[] webMessagePortCompatArr) {
        this.mString = str;
        this.mArrayBuffer = null;
        this.mPorts = webMessagePortCompatArr;
        this.mType = 0;
    }

    public WebMessageCompat(byte[] bArr) {
        this(bArr, (WebMessagePortCompat[]) null);
    }

    public WebMessageCompat(byte[] bArr, WebMessagePortCompat[] webMessagePortCompatArr) {
        Objects.requireNonNull(bArr);
        this.mArrayBuffer = bArr;
        this.mString = null;
        this.mPorts = webMessagePortCompatArr;
        this.mType = 1;
    }

    public byte[] getArrayBuffer() {
        checkType(1);
        Objects.requireNonNull(this.mArrayBuffer);
        return this.mArrayBuffer;
    }

    public String getData() {
        checkType(0);
        return this.mString;
    }

    private void checkType(int i) {
        if (i != this.mType) {
            throw new IllegalStateException("Wrong data accessor type detected. " + typeToString(this.mType) + " expected, but got " + typeToString(i));
        }
    }
}
