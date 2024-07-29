package com.facebook.soloader;

import android.content.Context;
import com.facebook.soloader.UnpackingSoSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public final class ExoSoSource extends UnpackingSoSource {
    public ExoSoSource(Context context, String str) {
        super(context, str);
    }

    /* access modifiers changed from: protected */
    public UnpackingSoSource.Unpacker makeUnpacker(byte b) throws IOException {
        return new ExoUnpacker(this, this);
    }

    private final class ExoUnpacker extends UnpackingSoSource.Unpacker {
        /* access modifiers changed from: private */
        public final FileDso[] mDsos;
        final /* synthetic */ ExoSoSource this$0;

        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            r8.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x00e0, code lost:
            r10.close();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        ExoUnpacker(com.facebook.soloader.ExoSoSource r18, com.facebook.soloader.UnpackingSoSource r19) throws java.io.IOException {
            /*
                r17 = this;
                r1 = r17
                r0 = r18
                r1.this$0 = r0
                r17.<init>()
                android.content.Context r0 = r0.mContext
                java.io.File r2 = new java.io.File
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                java.lang.String r4 = "/data/local/tmp/exopackage/"
                r3.<init>(r4)
                java.lang.String r0 = r0.getPackageName()
                r3.append(r0)
                java.lang.String r0 = "/native-libs/"
                r3.append(r0)
                java.lang.String r0 = r3.toString()
                r2.<init>(r0)
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>()
                java.util.LinkedHashSet r3 = new java.util.LinkedHashSet
                r3.<init>()
                java.lang.String[] r4 = com.facebook.soloader.SysUtil.getSupportedAbis()
                int r5 = r4.length
                r6 = 0
                r7 = r6
            L_0x0038:
                if (r7 >= r5) goto L_0x0100
                r8 = r4[r7]
                java.io.File r9 = new java.io.File
                r9.<init>(r2, r8)
                boolean r10 = r9.isDirectory()
                if (r10 != 0) goto L_0x0049
                goto L_0x00e3
            L_0x0049:
                r3.add(r8)
                java.io.File r8 = new java.io.File
                java.lang.String r10 = "metadata.txt"
                r8.<init>(r9, r10)
                boolean r10 = r8.isFile()
                if (r10 != 0) goto L_0x005b
                goto L_0x00e3
            L_0x005b:
                java.io.FileReader r10 = new java.io.FileReader
                r10.<init>(r8)
                java.io.BufferedReader r8 = new java.io.BufferedReader     // Catch:{ all -> 0x00f4 }
                r8.<init>(r10)     // Catch:{ all -> 0x00f4 }
            L_0x0065:
                java.lang.String r11 = r8.readLine()     // Catch:{ all -> 0x00e8 }
                if (r11 == 0) goto L_0x00dd
                int r12 = r11.length()     // Catch:{ all -> 0x00e8 }
                if (r12 != 0) goto L_0x0072
                goto L_0x0065
            L_0x0072:
                r12 = 32
                int r12 = r11.indexOf(r12)     // Catch:{ all -> 0x00e8 }
                r13 = -1
                if (r12 == r13) goto L_0x00c1
                java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e8 }
                r13.<init>()     // Catch:{ all -> 0x00e8 }
                java.lang.String r14 = r11.substring(r6, r12)     // Catch:{ all -> 0x00e8 }
                r13.append(r14)     // Catch:{ all -> 0x00e8 }
                java.lang.String r14 = ".so"
                r13.append(r14)     // Catch:{ all -> 0x00e8 }
                java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x00e8 }
                int r14 = r0.size()     // Catch:{ all -> 0x00e8 }
                r15 = r6
            L_0x0095:
                if (r15 >= r14) goto L_0x00ad
                java.lang.Object r16 = r0.get(r15)     // Catch:{ all -> 0x00e8 }
                r6 = r16
                com.facebook.soloader.ExoSoSource$FileDso r6 = (com.facebook.soloader.ExoSoSource.FileDso) r6     // Catch:{ all -> 0x00e8 }
                java.lang.String r6 = r6.name     // Catch:{ all -> 0x00e8 }
                boolean r6 = r6.equals(r13)     // Catch:{ all -> 0x00e8 }
                if (r6 == 0) goto L_0x00a9
            L_0x00a7:
                r6 = 0
                goto L_0x0065
            L_0x00a9:
                int r15 = r15 + 1
                r6 = 0
                goto L_0x0095
            L_0x00ad:
                int r12 = r12 + 1
                java.lang.String r6 = r11.substring(r12)     // Catch:{ all -> 0x00e8 }
                com.facebook.soloader.ExoSoSource$FileDso r11 = new com.facebook.soloader.ExoSoSource$FileDso     // Catch:{ all -> 0x00e8 }
                java.io.File r12 = new java.io.File     // Catch:{ all -> 0x00e8 }
                r12.<init>(r9, r6)     // Catch:{ all -> 0x00e8 }
                r11.<init>(r13, r6, r12)     // Catch:{ all -> 0x00e8 }
                r0.add(r11)     // Catch:{ all -> 0x00e8 }
                goto L_0x00a7
            L_0x00c1:
                java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ all -> 0x00e8 }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e8 }
                r2.<init>()     // Catch:{ all -> 0x00e8 }
                java.lang.String r3 = "illegal line in exopackage metadata: ["
                r2.append(r3)     // Catch:{ all -> 0x00e8 }
                r2.append(r11)     // Catch:{ all -> 0x00e8 }
                java.lang.String r3 = "]"
                r2.append(r3)     // Catch:{ all -> 0x00e8 }
                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00e8 }
                r0.<init>(r2)     // Catch:{ all -> 0x00e8 }
                throw r0     // Catch:{ all -> 0x00e8 }
            L_0x00dd:
                r8.close()     // Catch:{ all -> 0x00f4 }
                r10.close()
            L_0x00e3:
                int r7 = r7 + 1
                r6 = 0
                goto L_0x0038
            L_0x00e8:
                r0 = move-exception
                r2 = r0
                r8.close()     // Catch:{ all -> 0x00ee }
                goto L_0x00f3
            L_0x00ee:
                r0 = move-exception
                r3 = r0
                r2.addSuppressed(r3)     // Catch:{ all -> 0x00f4 }
            L_0x00f3:
                throw r2     // Catch:{ all -> 0x00f4 }
            L_0x00f4:
                r0 = move-exception
                r2 = r0
                r10.close()     // Catch:{ all -> 0x00fa }
                goto L_0x00ff
            L_0x00fa:
                r0 = move-exception
                r3 = r0
                r2.addSuppressed(r3)
            L_0x00ff:
                throw r2
            L_0x0100:
                int r2 = r3.size()
                java.lang.String[] r2 = new java.lang.String[r2]
                java.lang.Object[] r2 = r3.toArray(r2)
                java.lang.String[] r2 = (java.lang.String[]) r2
                r3 = r19
                r3.setSoSourceAbis(r2)
                int r2 = r0.size()
                com.facebook.soloader.ExoSoSource$FileDso[] r2 = new com.facebook.soloader.ExoSoSource.FileDso[r2]
                java.lang.Object[] r0 = r0.toArray(r2)
                com.facebook.soloader.ExoSoSource$FileDso[] r0 = (com.facebook.soloader.ExoSoSource.FileDso[]) r0
                r1.mDsos = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.ExoSoSource.ExoUnpacker.<init>(com.facebook.soloader.ExoSoSource, com.facebook.soloader.UnpackingSoSource):void");
        }

        public UnpackingSoSource.DsoManifest getDsoManifest() throws IOException {
            return new UnpackingSoSource.DsoManifest(this.mDsos);
        }

        public UnpackingSoSource.InputDsoIterator openDsoIterator() throws IOException {
            return new FileBackedInputDsoIterator();
        }

        private final class FileBackedInputDsoIterator extends UnpackingSoSource.InputDsoIterator {
            private int mCurrentDso;

            private FileBackedInputDsoIterator() {
            }

            public boolean hasNext() {
                return this.mCurrentDso < ExoUnpacker.this.mDsos.length;
            }

            public UnpackingSoSource.InputDso next() throws IOException {
                FileDso[] access$100 = ExoUnpacker.this.mDsos;
                int i = this.mCurrentDso;
                this.mCurrentDso = i + 1;
                FileDso fileDso = access$100[i];
                FileInputStream fileInputStream = new FileInputStream(fileDso.backingFile);
                try {
                    return new UnpackingSoSource.InputDsoStream(fileDso, fileInputStream);
                } catch (Throwable th) {
                    fileInputStream.close();
                    throw th;
                }
            }
        }
    }

    private static final class FileDso extends UnpackingSoSource.Dso {
        final File backingFile;

        FileDso(String str, String str2, File file) {
            super(str, str2);
            this.backingFile = file;
        }
    }
}
