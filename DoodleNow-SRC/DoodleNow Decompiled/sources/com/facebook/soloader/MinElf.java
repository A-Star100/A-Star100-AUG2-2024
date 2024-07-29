package com.facebook.soloader;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.ClosedByInterruptException;
import kotlin.UShort;
import okhttp3.internal.ws.WebSocketProtocol;

public final class MinElf {
    public static final int DT_NEEDED = 1;
    public static final int DT_NULL = 0;
    public static final int DT_STRTAB = 5;
    public static final int ELF_MAGIC = 1179403647;
    public static final int PN_XNUM = 65535;
    public static final int PT_DYNAMIC = 2;
    public static final int PT_LOAD = 1;
    private static final String TAG = "MinElf";

    public enum ISA {
        NOT_SO("not_so"),
        X86("x86"),
        ARM("armeabi-v7a"),
        X86_64("x86_64"),
        AARCH64("arm64-v8a"),
        OTHERS("others");
        
        private final String value;

        public String toString() {
            return this.value;
        }

        private ISA(String str) {
            this.value = str;
        }
    }

    public static String[] extract_DT_NEEDED(File file) throws IOException {
        ElfFileChannel elfFileChannel = new ElfFileChannel(file);
        try {
            String[] extract_DT_NEEDED = extract_DT_NEEDED((ElfByteChannel) elfFileChannel);
            elfFileChannel.close();
            return extract_DT_NEEDED;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    private static String[] extract_DT_NEEDED_with_retries(ElfFileChannel elfFileChannel) throws IOException {
        int i = 0;
        while (true) {
            try {
                return extract_DT_NEEDED_no_retries(elfFileChannel);
            } catch (ClosedByInterruptException e) {
                i++;
                if (i <= 4) {
                    Thread.interrupted();
                    Log.e(TAG, "retrying extract_DT_NEEDED due to ClosedByInterruptException", e);
                    elfFileChannel.openChannel();
                } else {
                    throw e;
                }
            }
        }
    }

    public static String[] extract_DT_NEEDED(ElfByteChannel elfByteChannel) throws IOException {
        if (elfByteChannel instanceof ElfFileChannel) {
            return extract_DT_NEEDED_with_retries((ElfFileChannel) elfByteChannel);
        }
        return extract_DT_NEEDED_no_retries(elfByteChannel);
    }

    private static String[] extract_DT_NEEDED_no_retries(ElfByteChannel elfByteChannel) throws IOException {
        long j;
        String str;
        long j2;
        long j3;
        long j4;
        String str2;
        long j5;
        long j6;
        long j7;
        long j8;
        long j9;
        long j10;
        long j11;
        ElfByteChannel elfByteChannel2 = elfByteChannel;
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        long j12 = getu32(elfByteChannel2, allocate, 0);
        if (j12 == 1179403647) {
            boolean z = true;
            if (getu8(elfByteChannel2, allocate, 4) != 1) {
                z = false;
            }
            if (getu8(elfByteChannel2, allocate, 5) == 2) {
                allocate.order(ByteOrder.BIG_ENDIAN);
            }
            long r15 = z ? getu32(elfByteChannel2, allocate, 28) : get64(elfByteChannel2, allocate, 32);
            long j13 = z ? (long) getu16(elfByteChannel2, allocate, 44) : (long) getu16(elfByteChannel2, allocate, 56);
            int i = getu16(elfByteChannel2, allocate, z ? 42 : 54);
            if (j13 == WebSocketProtocol.PAYLOAD_SHORT_MAX) {
                long r2 = z ? getu32(elfByteChannel2, allocate, 32) : get64(elfByteChannel2, allocate, 40);
                if (z) {
                    j13 = getu32(elfByteChannel2, allocate, r2 + 28);
                } else {
                    j13 = getu32(elfByteChannel2, allocate, r2 + 44);
                }
            }
            long j14 = r15;
            long j15 = 0;
            while (true) {
                if (j15 >= j13) {
                    j = 0;
                    break;
                }
                if (z) {
                    j11 = getu32(elfByteChannel2, allocate, j14);
                } else {
                    j11 = getu32(elfByteChannel2, allocate, j14);
                }
                if (j11 != 2) {
                    j14 += (long) i;
                    j15++;
                } else if (z) {
                    j = getu32(elfByteChannel2, allocate, j14 + 4);
                } else {
                    j = get64(elfByteChannel2, allocate, j14 + 8);
                }
            }
            if (j != 0) {
                long j16 = j;
                int i2 = 0;
                long j17 = 0;
                while (true) {
                    long r28 = z ? getu32(elfByteChannel2, allocate, j16) : get64(elfByteChannel2, allocate, j16);
                    if (r28 == 1) {
                        if (i2 != Integer.MAX_VALUE) {
                            i2++;
                            str = "malformed DT_NEEDED section";
                        } else {
                            throw new ElfError("malformed DT_NEEDED section");
                        }
                    } else if (r28 == 5) {
                        str = "malformed DT_NEEDED section";
                        if (z) {
                            j10 = getu32(elfByteChannel2, allocate, j16 + 4);
                        } else {
                            j10 = get64(elfByteChannel2, allocate, j16 + 8);
                        }
                        j17 = j10;
                    } else {
                        str = "malformed DT_NEEDED section";
                    }
                    j16 += z ? 8 : 16;
                    if (r28 == 0) {
                        if (j17 != 0) {
                            long j18 = r15;
                            int i3 = 0;
                            while (true) {
                                if (((long) i3) >= j13) {
                                    j2 = j;
                                    j3 = 0;
                                    j4 = 0;
                                    break;
                                }
                                if (z) {
                                    j5 = getu32(elfByteChannel2, allocate, j18);
                                } else {
                                    j5 = getu32(elfByteChannel2, allocate, j18);
                                }
                                if (j5 == 1) {
                                    if (z) {
                                        j6 = j13;
                                        j7 = getu32(elfByteChannel2, allocate, j18 + 8);
                                    } else {
                                        j6 = j13;
                                        j7 = get64(elfByteChannel2, allocate, j18 + 16);
                                    }
                                    if (z) {
                                        j2 = j;
                                        j8 = getu32(elfByteChannel2, allocate, j18 + 20);
                                    } else {
                                        j2 = j;
                                        j8 = get64(elfByteChannel2, allocate, j18 + 40);
                                    }
                                    if (j7 <= j17 && j17 < j8 + j7) {
                                        if (z) {
                                            j9 = getu32(elfByteChannel2, allocate, j18 + 4);
                                        } else {
                                            j9 = get64(elfByteChannel2, allocate, j18 + 8);
                                        }
                                        j4 = j9 + (j17 - j7);
                                        j3 = 0;
                                    }
                                } else {
                                    j6 = j13;
                                    j2 = j;
                                }
                                j18 += (long) i;
                                i3++;
                                j13 = j6;
                                j = j2;
                            }
                            if (j4 != j3) {
                                String[] strArr = new String[i2];
                                long j19 = j2;
                                int i4 = 0;
                                while (true) {
                                    long r9 = z ? getu32(elfByteChannel2, allocate, j19) : get64(elfByteChannel2, allocate, j19);
                                    if (r9 == 1) {
                                        strArr[i4] = getSz(elfByteChannel2, allocate, (z ? getu32(elfByteChannel2, allocate, j19 + 4) : get64(elfByteChannel2, allocate, j19 + 8)) + j4);
                                        if (i4 != Integer.MAX_VALUE) {
                                            i4++;
                                            str2 = str;
                                        } else {
                                            throw new ElfError(str);
                                        }
                                    } else {
                                        str2 = str;
                                    }
                                    j19 += z ? 8 : 16;
                                    if (r9 != 0) {
                                        str = str2;
                                    } else if (i4 == i2) {
                                        return strArr;
                                    } else {
                                        throw new ElfError(str2);
                                    }
                                }
                            } else {
                                throw new ElfError("did not find file offset of DT_STRTAB table");
                            }
                        } else {
                            throw new ElfError("Dynamic section string-table not found");
                        }
                    }
                }
            } else {
                throw new ElfError("ELF file does not contain dynamic linking information");
            }
        } else {
            throw new ElfError("file is not ELF: 0x" + Long.toHexString(j12));
        }
    }

    private static String getSz(ElfByteChannel elfByteChannel, ByteBuffer byteBuffer, long j) throws IOException {
        StringBuilder sb = new StringBuilder();
        while (true) {
            long j2 = 1 + j;
            short u8Var = getu8(elfByteChannel, byteBuffer, j);
            if (u8Var == 0) {
                return sb.toString();
            }
            sb.append((char) u8Var);
            j = j2;
        }
    }

    private static void read(ElfByteChannel elfByteChannel, ByteBuffer byteBuffer, int i, long j) throws IOException {
        int read;
        byteBuffer.position(0);
        byteBuffer.limit(i);
        while (byteBuffer.remaining() > 0 && (read = elfByteChannel.read(byteBuffer, j)) != -1) {
            j += (long) read;
        }
        if (byteBuffer.remaining() <= 0) {
            byteBuffer.position(0);
            return;
        }
        throw new ElfError("ELF file truncated");
    }

    private static long get64(ElfByteChannel elfByteChannel, ByteBuffer byteBuffer, long j) throws IOException {
        read(elfByteChannel, byteBuffer, 8, j);
        return byteBuffer.getLong();
    }

    private static long getu32(ElfByteChannel elfByteChannel, ByteBuffer byteBuffer, long j) throws IOException {
        read(elfByteChannel, byteBuffer, 4, j);
        return ((long) byteBuffer.getInt()) & 4294967295L;
    }

    private static int getu16(ElfByteChannel elfByteChannel, ByteBuffer byteBuffer, long j) throws IOException {
        read(elfByteChannel, byteBuffer, 2, j);
        return byteBuffer.getShort() & UShort.MAX_VALUE;
    }

    private static short getu8(ElfByteChannel elfByteChannel, ByteBuffer byteBuffer, long j) throws IOException {
        read(elfByteChannel, byteBuffer, 1, j);
        return (short) (byteBuffer.get() & 255);
    }

    private static class ElfError extends RuntimeException {
        ElfError(String str) {
            super(str);
        }
    }
}
