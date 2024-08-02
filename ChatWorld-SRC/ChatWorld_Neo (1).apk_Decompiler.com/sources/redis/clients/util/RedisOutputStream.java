package redis.clients.util;

import androidx.appcompat.widget.ActivityChooserView;
import com.google.appinventor.components.runtime.util.Ev3Constants;
import com.google.appinventor.components.runtime.util.FullScreenVideoUtil;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class RedisOutputStream extends FilterOutputStream {
    private static final byte[] DigitOnes = {Ev3Constants.Opcode.MOVE8_8, Ev3Constants.Opcode.MOVE8_16, Ev3Constants.Opcode.MOVE8_32, Ev3Constants.Opcode.MOVE8_F, Ev3Constants.Opcode.MOVE16_8, Ev3Constants.Opcode.MOVE16_16, Ev3Constants.Opcode.MOVE16_32, Ev3Constants.Opcode.MOVE16_F, Ev3Constants.Opcode.MOVE32_8, Ev3Constants.Opcode.MOVE32_16, Ev3Constants.Opcode.MOVE8_8, Ev3Constants.Opcode.MOVE8_16, Ev3Constants.Opcode.MOVE8_32, Ev3Constants.Opcode.MOVE8_F, Ev3Constants.Opcode.MOVE16_8, Ev3Constants.Opcode.MOVE16_16, Ev3Constants.Opcode.MOVE16_32, Ev3Constants.Opcode.MOVE16_F, Ev3Constants.Opcode.MOVE32_8, Ev3Constants.Opcode.MOVE32_16, Ev3Constants.Opcode.MOVE8_8, Ev3Constants.Opcode.MOVE8_16, Ev3Constants.Opcode.MOVE8_32, Ev3Constants.Opcode.MOVE8_F, Ev3Constants.Opcode.MOVE16_8, Ev3Constants.Opcode.MOVE16_16, Ev3Constants.Opcode.MOVE16_32, Ev3Constants.Opcode.MOVE16_F, Ev3Constants.Opcode.MOVE32_8, Ev3Constants.Opcode.MOVE32_16, Ev3Constants.Opcode.MOVE8_8, Ev3Constants.Opcode.MOVE8_16, Ev3Constants.Opcode.MOVE8_32, Ev3Constants.Opcode.MOVE8_F, Ev3Constants.Opcode.MOVE16_8, Ev3Constants.Opcode.MOVE16_16, Ev3Constants.Opcode.MOVE16_32, Ev3Constants.Opcode.MOVE16_F, Ev3Constants.Opcode.MOVE32_8, Ev3Constants.Opcode.MOVE32_16, Ev3Constants.Opcode.MOVE8_8, Ev3Constants.Opcode.MOVE8_16, Ev3Constants.Opcode.MOVE8_32, Ev3Constants.Opcode.MOVE8_F, Ev3Constants.Opcode.MOVE16_8, Ev3Constants.Opcode.MOVE16_16, Ev3Constants.Opcode.MOVE16_32, Ev3Constants.Opcode.MOVE16_F, Ev3Constants.Opcode.MOVE32_8, Ev3Constants.Opcode.MOVE32_16, Ev3Constants.Opcode.MOVE8_8, Ev3Constants.Opcode.MOVE8_16, Ev3Constants.Opcode.MOVE8_32, Ev3Constants.Opcode.MOVE8_F, Ev3Constants.Opcode.MOVE16_8, Ev3Constants.Opcode.MOVE16_16, Ev3Constants.Opcode.MOVE16_32, Ev3Constants.Opcode.MOVE16_F, Ev3Constants.Opcode.MOVE32_8, Ev3Constants.Opcode.MOVE32_16, Ev3Constants.Opcode.MOVE8_8, Ev3Constants.Opcode.MOVE8_16, Ev3Constants.Opcode.MOVE8_32, Ev3Constants.Opcode.MOVE8_F, Ev3Constants.Opcode.MOVE16_8, Ev3Constants.Opcode.MOVE16_16, Ev3Constants.Opcode.MOVE16_32, Ev3Constants.Opcode.MOVE16_F, Ev3Constants.Opcode.MOVE32_8, Ev3Constants.Opcode.MOVE32_16, Ev3Constants.Opcode.MOVE8_8, Ev3Constants.Opcode.MOVE8_16, Ev3Constants.Opcode.MOVE8_32, Ev3Constants.Opcode.MOVE8_F, Ev3Constants.Opcode.MOVE16_8, Ev3Constants.Opcode.MOVE16_16, Ev3Constants.Opcode.MOVE16_32, Ev3Constants.Opcode.MOVE16_F, Ev3Constants.Opcode.MOVE32_8, Ev3Constants.Opcode.MOVE32_16, Ev3Constants.Opcode.MOVE8_8, Ev3Constants.Opcode.MOVE8_16, Ev3Constants.Opcode.MOVE8_32, Ev3Constants.Opcode.MOVE8_F, Ev3Constants.Opcode.MOVE16_8, Ev3Constants.Opcode.MOVE16_16, Ev3Constants.Opcode.MOVE16_32, Ev3Constants.Opcode.MOVE16_F, Ev3Constants.Opcode.MOVE32_8, Ev3Constants.Opcode.MOVE32_16, Ev3Constants.Opcode.MOVE8_8, Ev3Constants.Opcode.MOVE8_16, Ev3Constants.Opcode.MOVE8_32, Ev3Constants.Opcode.MOVE8_F, Ev3Constants.Opcode.MOVE16_8, Ev3Constants.Opcode.MOVE16_16, Ev3Constants.Opcode.MOVE16_32, Ev3Constants.Opcode.MOVE16_F, Ev3Constants.Opcode.MOVE32_8, Ev3Constants.Opcode.MOVE32_16};
    private static final byte[] DigitTens = {Ev3Constants.Opcode.MOVE8_8, Ev3Constants.Opcode.MOVE8_8, Ev3Constants.Opcode.MOVE8_8, Ev3Constants.Opcode.MOVE8_8, Ev3Constants.Opcode.MOVE8_8, Ev3Constants.Opcode.MOVE8_8, Ev3Constants.Opcode.MOVE8_8, Ev3Constants.Opcode.MOVE8_8, Ev3Constants.Opcode.MOVE8_8, Ev3Constants.Opcode.MOVE8_8, Ev3Constants.Opcode.MOVE8_16, Ev3Constants.Opcode.MOVE8_16, Ev3Constants.Opcode.MOVE8_16, Ev3Constants.Opcode.MOVE8_16, Ev3Constants.Opcode.MOVE8_16, Ev3Constants.Opcode.MOVE8_16, Ev3Constants.Opcode.MOVE8_16, Ev3Constants.Opcode.MOVE8_16, Ev3Constants.Opcode.MOVE8_16, Ev3Constants.Opcode.MOVE8_16, Ev3Constants.Opcode.MOVE8_32, Ev3Constants.Opcode.MOVE8_32, Ev3Constants.Opcode.MOVE8_32, Ev3Constants.Opcode.MOVE8_32, Ev3Constants.Opcode.MOVE8_32, Ev3Constants.Opcode.MOVE8_32, Ev3Constants.Opcode.MOVE8_32, Ev3Constants.Opcode.MOVE8_32, Ev3Constants.Opcode.MOVE8_32, Ev3Constants.Opcode.MOVE8_32, Ev3Constants.Opcode.MOVE8_F, Ev3Constants.Opcode.MOVE8_F, Ev3Constants.Opcode.MOVE8_F, Ev3Constants.Opcode.MOVE8_F, Ev3Constants.Opcode.MOVE8_F, Ev3Constants.Opcode.MOVE8_F, Ev3Constants.Opcode.MOVE8_F, Ev3Constants.Opcode.MOVE8_F, Ev3Constants.Opcode.MOVE8_F, Ev3Constants.Opcode.MOVE8_F, Ev3Constants.Opcode.MOVE16_8, Ev3Constants.Opcode.MOVE16_8, Ev3Constants.Opcode.MOVE16_8, Ev3Constants.Opcode.MOVE16_8, Ev3Constants.Opcode.MOVE16_8, Ev3Constants.Opcode.MOVE16_8, Ev3Constants.Opcode.MOVE16_8, Ev3Constants.Opcode.MOVE16_8, Ev3Constants.Opcode.MOVE16_8, Ev3Constants.Opcode.MOVE16_8, Ev3Constants.Opcode.MOVE16_16, Ev3Constants.Opcode.MOVE16_16, Ev3Constants.Opcode.MOVE16_16, Ev3Constants.Opcode.MOVE16_16, Ev3Constants.Opcode.MOVE16_16, Ev3Constants.Opcode.MOVE16_16, Ev3Constants.Opcode.MOVE16_16, Ev3Constants.Opcode.MOVE16_16, Ev3Constants.Opcode.MOVE16_16, Ev3Constants.Opcode.MOVE16_16, Ev3Constants.Opcode.MOVE16_32, Ev3Constants.Opcode.MOVE16_32, Ev3Constants.Opcode.MOVE16_32, Ev3Constants.Opcode.MOVE16_32, Ev3Constants.Opcode.MOVE16_32, Ev3Constants.Opcode.MOVE16_32, Ev3Constants.Opcode.MOVE16_32, Ev3Constants.Opcode.MOVE16_32, Ev3Constants.Opcode.MOVE16_32, Ev3Constants.Opcode.MOVE16_32, Ev3Constants.Opcode.MOVE16_F, Ev3Constants.Opcode.MOVE16_F, Ev3Constants.Opcode.MOVE16_F, Ev3Constants.Opcode.MOVE16_F, Ev3Constants.Opcode.MOVE16_F, Ev3Constants.Opcode.MOVE16_F, Ev3Constants.Opcode.MOVE16_F, Ev3Constants.Opcode.MOVE16_F, Ev3Constants.Opcode.MOVE16_F, Ev3Constants.Opcode.MOVE16_F, Ev3Constants.Opcode.MOVE32_8, Ev3Constants.Opcode.MOVE32_8, Ev3Constants.Opcode.MOVE32_8, Ev3Constants.Opcode.MOVE32_8, Ev3Constants.Opcode.MOVE32_8, Ev3Constants.Opcode.MOVE32_8, Ev3Constants.Opcode.MOVE32_8, Ev3Constants.Opcode.MOVE32_8, Ev3Constants.Opcode.MOVE32_8, Ev3Constants.Opcode.MOVE32_8, Ev3Constants.Opcode.MOVE32_16, Ev3Constants.Opcode.MOVE32_16, Ev3Constants.Opcode.MOVE32_16, Ev3Constants.Opcode.MOVE32_16, Ev3Constants.Opcode.MOVE32_16, Ev3Constants.Opcode.MOVE32_16, Ev3Constants.Opcode.MOVE32_16, Ev3Constants.Opcode.MOVE32_16, Ev3Constants.Opcode.MOVE32_16, Ev3Constants.Opcode.MOVE32_16};
    private static final byte[] digits = {Ev3Constants.Opcode.MOVE8_8, Ev3Constants.Opcode.MOVE8_16, Ev3Constants.Opcode.MOVE8_32, Ev3Constants.Opcode.MOVE8_F, Ev3Constants.Opcode.MOVE16_8, Ev3Constants.Opcode.MOVE16_16, Ev3Constants.Opcode.MOVE16_32, Ev3Constants.Opcode.MOVE16_F, Ev3Constants.Opcode.MOVE32_8, Ev3Constants.Opcode.MOVE32_16, Ev3Constants.Opcode.PORT_CNV_OUTPUT, Ev3Constants.Opcode.PORT_CNV_INPUT, Ev3Constants.Opcode.NOTE_TO_FREQ, Ev3Constants.Opcode.JR_LT8, Ev3Constants.Opcode.JR_LT16, Ev3Constants.Opcode.JR_LT32, Ev3Constants.Opcode.JR_LTF, Ev3Constants.Opcode.JR_GT8, Ev3Constants.Opcode.JR_GT16, Ev3Constants.Opcode.JR_GT32, Ev3Constants.Opcode.JR_GTF, Ev3Constants.Opcode.JR_EQ8, Ev3Constants.Opcode.JR_EQ16, Ev3Constants.Opcode.JR_EQ32, Ev3Constants.Opcode.JR_EQF, Ev3Constants.Opcode.JR_NEQ8, Ev3Constants.Opcode.JR_NEQ16, Ev3Constants.Opcode.JR_NEQ32, Ev3Constants.Opcode.JR_NEQF, Ev3Constants.Opcode.JR_LTEQ8, Ev3Constants.Opcode.JR_LTEQ16, Ev3Constants.Opcode.JR_LTEQ32, Ev3Constants.Opcode.JR_LTEQF, Ev3Constants.Opcode.JR_GTEQ8, Ev3Constants.Opcode.JR_GTEQ16, Ev3Constants.Opcode.JR_GTEQ32};
    private static final int[] sizeTable = {9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED};
    protected final byte[] buf;
    protected int count;

    public RedisOutputStream(OutputStream out) {
        this(out, 8192);
    }

    public RedisOutputStream(OutputStream out, int size) {
        super(out);
        if (size > 0) {
            this.buf = new byte[size];
            return;
        }
        throw new IllegalArgumentException("Buffer size <= 0");
    }

    private void flushBuffer() throws IOException {
        if (this.count > 0) {
            this.out.write(this.buf, 0, this.count);
            this.count = 0;
        }
    }

    public void write(byte b) throws IOException {
        if (this.count == this.buf.length) {
            flushBuffer();
        }
        byte[] bArr = this.buf;
        int i = this.count;
        this.count = i + 1;
        bArr[i] = b;
    }

    public void write(byte[] b) throws IOException {
        write(b, 0, b.length);
    }

    public void write(byte[] b, int off, int len) throws IOException {
        byte[] bArr = this.buf;
        if (len >= bArr.length) {
            flushBuffer();
            this.out.write(b, off, len);
            return;
        }
        if (len >= bArr.length - this.count) {
            flushBuffer();
        }
        System.arraycopy(b, off, this.buf, this.count, len);
        this.count += len;
    }

    public void writeAsciiCrLf(String in) throws IOException {
        int size = in.length();
        for (int i = 0; i != size; i++) {
            if (this.count == this.buf.length) {
                flushBuffer();
            }
            byte[] bArr = this.buf;
            int i2 = this.count;
            this.count = i2 + 1;
            bArr[i2] = (byte) in.charAt(i);
        }
        writeCrLf();
    }

    public static boolean isSurrogate(char ch) {
        return ch >= 55296 && ch <= 57343;
    }

    public static int utf8Length(String str) {
        int strLen = str.length();
        int utfLen = 0;
        int i = 0;
        while (i != strLen) {
            char c = str.charAt(i);
            if (c < 128) {
                utfLen++;
            } else if (c < 2048) {
                utfLen += 2;
            } else if (isSurrogate(c)) {
                i++;
                utfLen += 4;
            } else {
                utfLen += 3;
            }
            i++;
        }
        return utfLen;
    }

    public void writeCrLf() throws IOException {
        if (2 >= this.buf.length - this.count) {
            flushBuffer();
        }
        byte[] bArr = this.buf;
        int i = this.count;
        int i2 = i + 1;
        this.count = i2;
        bArr[i] = 13;
        this.count = i2 + 1;
        bArr[i2] = 10;
    }

    public void writeUtf8CrLf(String str) throws IOException {
        char c;
        int strLen = str.length();
        int i = 0;
        while (i < strLen && (c = str.charAt(i)) < 128) {
            if (this.count == this.buf.length) {
                flushBuffer();
            }
            byte[] bArr = this.buf;
            int i2 = this.count;
            this.count = i2 + 1;
            bArr[i2] = (byte) c;
            i++;
        }
        while (i < strLen) {
            char c2 = str.charAt(i);
            if (c2 < 128) {
                if (this.count == this.buf.length) {
                    flushBuffer();
                }
                byte[] bArr2 = this.buf;
                int i3 = this.count;
                this.count = i3 + 1;
                bArr2[i3] = (byte) c2;
            } else if (c2 < 2048) {
                if (2 >= this.buf.length - this.count) {
                    flushBuffer();
                }
                byte[] bArr3 = this.buf;
                int i4 = this.count;
                int i5 = i4 + 1;
                this.count = i5;
                bArr3[i4] = (byte) ((c2 >> 6) | FullScreenVideoUtil.FULLSCREEN_VIDEO_ACTION_PAUSE);
                this.count = i5 + 1;
                bArr3[i5] = (byte) ((c2 & '?') | 128);
            } else if (isSurrogate(c2)) {
                if (4 >= this.buf.length - this.count) {
                    flushBuffer();
                }
                int i6 = i + 1;
                int uc = Character.toCodePoint(c2, str.charAt(i));
                byte[] bArr4 = this.buf;
                int i7 = this.count;
                int i8 = i7 + 1;
                this.count = i8;
                bArr4[i7] = (byte) ((uc >> 18) | 240);
                int i9 = i8 + 1;
                this.count = i9;
                bArr4[i8] = (byte) (((uc >> 12) & 63) | 128);
                int i10 = i9 + 1;
                this.count = i10;
                bArr4[i9] = (byte) (((uc >> 6) & 63) | 128);
                this.count = i10 + 1;
                bArr4[i10] = (byte) ((uc & 63) | 128);
                i = i6;
            } else {
                if (3 >= this.buf.length - this.count) {
                    flushBuffer();
                }
                byte[] bArr5 = this.buf;
                int i11 = this.count;
                int i12 = i11 + 1;
                this.count = i12;
                bArr5[i11] = (byte) ((c2 >> 12) | 224);
                int i13 = i12 + 1;
                this.count = i13;
                bArr5[i12] = (byte) (((c2 >> 6) & 63) | 128);
                this.count = i13 + 1;
                bArr5[i13] = (byte) ((c2 & '?') | 128);
            }
            i++;
        }
        writeCrLf();
    }

    public void writeIntCrLf(int value) throws IOException {
        if (value < 0) {
            write((byte) 45);
            value = -value;
        }
        int size = 0;
        while (value > sizeTable[size]) {
            size++;
        }
        int size2 = size + 1;
        if (size2 >= this.buf.length - this.count) {
            flushBuffer();
        }
        int charPos = this.count + size2;
        while (value >= 65536) {
            int q = value / 100;
            int r = value - (((q << 6) + (q << 5)) + (q << 2));
            value = q;
            byte[] bArr = this.buf;
            int charPos2 = charPos - 1;
            bArr[charPos2] = DigitOnes[r];
            charPos = charPos2 - 1;
            bArr[charPos] = DigitTens[r];
        }
        do {
            int q2 = (52429 * value) >>> 19;
            charPos--;
            this.buf[charPos] = digits[value - ((q2 << 3) + (q2 << 1))];
            value = q2;
        } while (value != 0);
        this.count += size2;
        writeCrLf();
    }

    public void flush() throws IOException {
        flushBuffer();
        this.out.flush();
    }
}
