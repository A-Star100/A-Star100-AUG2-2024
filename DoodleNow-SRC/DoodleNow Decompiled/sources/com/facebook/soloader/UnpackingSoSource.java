package com.facebook.soloader;

import android.content.Context;
import android.os.Parcel;
import android.os.StrictMode;
import android.util.Log;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.SyncFailedException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

public abstract class UnpackingSoSource extends DirectorySoSource {
    private static final String DEPS_FILE_NAME = "dso_deps";
    private static final String INSTANCE_LOCK_FILE_NAME = "dso_instance_lock";
    private static final String LOCK_FILE_NAME = "dso_lock";
    private static final String MANIFEST_FILE_NAME = "dso_manifest";
    private static final byte MANIFEST_VERSION = 1;
    protected static final byte STATE_CLEAN = 1;
    protected static final byte STATE_DIRTY = 0;
    private static final String STATE_FILE_NAME = "dso_state";
    private static final String TAG = "fb-UnpackingSoSource";
    @Nullable
    private String[] mAbis;
    protected final Context mContext;
    @Nullable
    protected String mCorruptedLib;
    @Nullable
    protected FileLocker mInstanceLock;
    private final Map<String, Object> mLibsBeingLoaded = new HashMap();

    protected interface InputDso extends Closeable {
        int available() throws IOException;

        Dso getDso();

        String getFileName();

        InputStream getStream();

        void write(DataOutput dataOutput, byte[] bArr) throws IOException;
    }

    /* access modifiers changed from: protected */
    public String getSoNameFromFileName(String str) {
        return str;
    }

    /* access modifiers changed from: protected */
    public abstract Unpacker makeUnpacker(byte b) throws IOException;

    public void setSoSourceAbis(String[] strArr) {
        this.mAbis = strArr;
    }

    protected UnpackingSoSource(Context context, String str) {
        super(getSoStorePath(context, str), 1);
        this.mContext = context;
    }

    protected UnpackingSoSource(Context context, File file) {
        super(file, 1);
        this.mContext = context;
    }

    public static File getSoStorePath(Context context, String str) {
        return new File(context.getApplicationInfo().dataDir + "/" + str);
    }

    public String[] getSoSourceAbis() {
        String[] strArr = this.mAbis;
        return strArr == null ? super.getSoSourceAbis() : strArr;
    }

    public static class Dso {
        public final String hash;
        public final String name;

        public Dso(String str, String str2) {
            this.name = str;
            this.hash = str2;
        }
    }

    public static final class DsoManifest {
        public final Dso[] dsos;

        public DsoManifest(Dso[] dsoArr) {
            this.dsos = dsoArr;
        }

        static final DsoManifest read(DataInput dataInput) throws IOException {
            if (dataInput.readByte() == 1) {
                int readInt = dataInput.readInt();
                if (readInt >= 0) {
                    Dso[] dsoArr = new Dso[readInt];
                    for (int i = 0; i < readInt; i++) {
                        dsoArr[i] = new Dso(dataInput.readUTF(), dataInput.readUTF());
                    }
                    return new DsoManifest(dsoArr);
                }
                throw new RuntimeException("illegal number of shared libraries");
            }
            throw new RuntimeException("wrong dso manifest version");
        }

        public final void write(DataOutput dataOutput) throws IOException {
            dataOutput.writeByte(1);
            dataOutput.writeInt(this.dsos.length);
            int i = 0;
            while (true) {
                Dso[] dsoArr = this.dsos;
                if (i < dsoArr.length) {
                    dataOutput.writeUTF(dsoArr[i].name);
                    dataOutput.writeUTF(this.dsos[i].hash);
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public static class InputDsoStream implements InputDso {
        private final InputStream content;
        private final Dso dso;

        public Dso getDso() {
            return this.dso;
        }

        public InputStream getStream() {
            return this.content;
        }

        public InputDsoStream(Dso dso2, InputStream inputStream) {
            this.dso = dso2;
            this.content = inputStream;
        }

        public void write(DataOutput dataOutput, byte[] bArr) throws IOException {
            SysUtil.copyBytes(dataOutput, this.content, Integer.MAX_VALUE, bArr);
        }

        public String getFileName() {
            return this.dso.name;
        }

        public int available() throws IOException {
            return this.content.available();
        }

        public void close() throws IOException {
            this.content.close();
        }
    }

    protected static abstract class InputDsoIterator implements Closeable {
        public void close() throws IOException {
        }

        public abstract boolean hasNext();

        @Nullable
        public abstract InputDso next() throws IOException;

        protected InputDsoIterator() {
        }
    }

    protected static abstract class Unpacker implements Closeable {
        public void close() throws IOException {
        }

        public abstract DsoManifest getDsoManifest() throws IOException;

        public abstract InputDsoIterator openDsoIterator() throws IOException;

        protected Unpacker() {
        }
    }

    /* access modifiers changed from: private */
    public static void writeState(File file, byte b) throws IOException {
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(0);
            randomAccessFile.write(b);
            randomAccessFile.setLength(randomAccessFile.getFilePointer());
            randomAccessFile.getFD().sync();
            randomAccessFile.close();
            return;
        } catch (SyncFailedException e) {
            Log.w(TAG, "state file sync failed", e);
            return;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    private void deleteUnmentionedFiles(Dso[] dsoArr) throws IOException {
        String[] list = this.soDirectory.list();
        if (list != null) {
            for (String str : list) {
                if (!str.equals(STATE_FILE_NAME) && !str.equals(LOCK_FILE_NAME) && !str.equals(INSTANCE_LOCK_FILE_NAME) && !str.equals(DEPS_FILE_NAME) && !str.equals(MANIFEST_FILE_NAME)) {
                    boolean z = false;
                    int i = 0;
                    while (!z && i < dsoArr.length) {
                        if (dsoArr[i].name.equals(getSoNameFromFileName(str))) {
                            z = true;
                        }
                        i++;
                    }
                    if (!z) {
                        File file = new File(this.soDirectory, str);
                        Log.v(TAG, "deleting unaccounted-for file " + file);
                        SysUtil.dumbDeleteRecursive(file);
                    }
                }
            }
            return;
        }
        throw new IOException("unable to list directory " + this.soDirectory);
    }

    private void extractDso(InputDso inputDso, byte[] bArr) throws IOException {
        boolean writable;
        Log.i(TAG, "extracting DSO " + inputDso.getDso().name);
        try {
            if (this.soDirectory.setWritable(true)) {
                extractDsoImpl(inputDso, bArr);
                if (writable) {
                    return;
                }
                return;
            }
            throw new IOException("cannot make directory writable for us: " + this.soDirectory);
        } finally {
            if (!this.soDirectory.setWritable(false)) {
                Log.w(TAG, "error removing " + this.soDirectory.getCanonicalPath() + " write permission");
            }
        }
    }

    private void extractDsoImpl(InputDso inputDso, byte[] bArr) throws IOException {
        RandomAccessFile randomAccessFile;
        File file = new File(this.soDirectory, inputDso.getFileName());
        RandomAccessFile randomAccessFile2 = null;
        try {
            if (file.exists() && !file.setWritable(true)) {
                Log.w(TAG, "error adding write permission to: " + file);
            }
            try {
                randomAccessFile = new RandomAccessFile(file, "rw");
            } catch (IOException e) {
                Log.w(TAG, "error overwriting " + file + " trying to delete and start over", e);
                SysUtil.dumbDeleteRecursive(file);
                randomAccessFile = new RandomAccessFile(file, "rw");
            }
            randomAccessFile2 = randomAccessFile;
            int available = inputDso.available();
            if (available > 1) {
                SysUtil.fallocateIfSupported(randomAccessFile2.getFD(), (long) available);
            }
            inputDso.write(randomAccessFile2, bArr);
            randomAccessFile2.setLength(randomAccessFile2.getFilePointer());
            if (file.setExecutable(true, false)) {
                if (!file.setWritable(false)) {
                    Log.w(TAG, "error removing " + file + " write permission");
                }
                randomAccessFile2.close();
                return;
            }
            throw new IOException("cannot make file executable: " + file);
        } catch (IOException e2) {
            SysUtil.dumbDeleteRecursive(file);
            throw e2;
        } catch (Throwable th) {
            if (!file.setWritable(false)) {
                Log.w(TAG, "error removing " + file + " write permission");
            }
            if (randomAccessFile2 != null) {
                randomAccessFile2.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x009e, code lost:
        if (r5 != false) goto L_0x00a0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0040 A[Catch:{ all -> 0x00a9, all -> 0x00b0, all -> 0x0033, all -> 0x00d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0057 A[Catch:{ all -> 0x00a9, all -> 0x00b0, all -> 0x0033, all -> 0x00d6 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void regenerate(byte r10, com.facebook.soloader.UnpackingSoSource.DsoManifest r11, com.facebook.soloader.UnpackingSoSource.InputDsoIterator r12) throws java.io.IOException {
        /*
            r9 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "regenerating DSO store "
            r0.<init>(r1)
            java.lang.Class r1 = r9.getClass()
            java.lang.String r1 = r1.getName()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "fb-UnpackingSoSource"
            android.util.Log.v(r1, r0)
            java.io.File r0 = new java.io.File
            java.io.File r2 = r9.soDirectory
            java.lang.String r3 = "dso_manifest"
            r0.<init>(r2, r3)
            java.io.RandomAccessFile r2 = new java.io.RandomAccessFile
            java.lang.String r3 = "rw"
            r2.<init>(r0, r3)
            r0 = 1
            if (r10 != r0) goto L_0x003c
            com.facebook.soloader.UnpackingSoSource$DsoManifest r10 = com.facebook.soloader.UnpackingSoSource.DsoManifest.read(r2)     // Catch:{ Exception -> 0x0036 }
            goto L_0x003d
        L_0x0033:
            r10 = move-exception
            goto L_0x00d2
        L_0x0036:
            r10 = move-exception
            java.lang.String r3 = "error reading existing DSO manifest"
            android.util.Log.i(r1, r3, r10)     // Catch:{ all -> 0x0033 }
        L_0x003c:
            r10 = 0
        L_0x003d:
            r3 = 0
            if (r10 != 0) goto L_0x0047
            com.facebook.soloader.UnpackingSoSource$DsoManifest r10 = new com.facebook.soloader.UnpackingSoSource$DsoManifest     // Catch:{ all -> 0x0033 }
            com.facebook.soloader.UnpackingSoSource$Dso[] r4 = new com.facebook.soloader.UnpackingSoSource.Dso[r3]     // Catch:{ all -> 0x0033 }
            r10.<init>(r4)     // Catch:{ all -> 0x0033 }
        L_0x0047:
            com.facebook.soloader.UnpackingSoSource$Dso[] r11 = r11.dsos     // Catch:{ all -> 0x0033 }
            r9.deleteUnmentionedFiles(r11)     // Catch:{ all -> 0x0033 }
            r11 = 32768(0x8000, float:4.5918E-41)
            byte[] r11 = new byte[r11]     // Catch:{ all -> 0x0033 }
        L_0x0051:
            boolean r4 = r12.hasNext()     // Catch:{ all -> 0x0033 }
            if (r4 == 0) goto L_0x00b5
            com.facebook.soloader.UnpackingSoSource$InputDso r4 = r12.next()     // Catch:{ all -> 0x0033 }
            r5 = r0
            r6 = r3
        L_0x005d:
            if (r5 == 0) goto L_0x008c
            com.facebook.soloader.UnpackingSoSource$Dso[] r7 = r10.dsos     // Catch:{ all -> 0x00a9 }
            int r7 = r7.length     // Catch:{ all -> 0x00a9 }
            if (r6 >= r7) goto L_0x008c
            com.facebook.soloader.UnpackingSoSource$Dso r7 = r4.getDso()     // Catch:{ all -> 0x00a9 }
            java.lang.String r7 = r7.name     // Catch:{ all -> 0x00a9 }
            com.facebook.soloader.UnpackingSoSource$Dso[] r8 = r10.dsos     // Catch:{ all -> 0x00a9 }
            r8 = r8[r6]     // Catch:{ all -> 0x00a9 }
            java.lang.String r8 = r8.name     // Catch:{ all -> 0x00a9 }
            boolean r7 = r8.equals(r7)     // Catch:{ all -> 0x00a9 }
            if (r7 == 0) goto L_0x0089
            com.facebook.soloader.UnpackingSoSource$Dso[] r7 = r10.dsos     // Catch:{ all -> 0x00a9 }
            r7 = r7[r6]     // Catch:{ all -> 0x00a9 }
            java.lang.String r7 = r7.hash     // Catch:{ all -> 0x00a9 }
            com.facebook.soloader.UnpackingSoSource$Dso r8 = r4.getDso()     // Catch:{ all -> 0x00a9 }
            java.lang.String r8 = r8.hash     // Catch:{ all -> 0x00a9 }
            boolean r7 = r7.equals(r8)     // Catch:{ all -> 0x00a9 }
            if (r7 == 0) goto L_0x0089
            r5 = r3
        L_0x0089:
            int r6 = r6 + 1
            goto L_0x005d
        L_0x008c:
            java.io.File r6 = new java.io.File     // Catch:{ all -> 0x00a9 }
            java.io.File r7 = r9.soDirectory     // Catch:{ all -> 0x00a9 }
            java.lang.String r8 = r4.getFileName()     // Catch:{ all -> 0x00a9 }
            r6.<init>(r7, r8)     // Catch:{ all -> 0x00a9 }
            boolean r6 = r6.exists()     // Catch:{ all -> 0x00a9 }
            if (r6 != 0) goto L_0x009e
            goto L_0x00a0
        L_0x009e:
            if (r5 == 0) goto L_0x00a3
        L_0x00a0:
            r9.extractDso(r4, r11)     // Catch:{ all -> 0x00a9 }
        L_0x00a3:
            if (r4 == 0) goto L_0x0051
            r4.close()     // Catch:{ all -> 0x0033 }
            goto L_0x0051
        L_0x00a9:
            r10 = move-exception
            if (r4 == 0) goto L_0x00b4
            r4.close()     // Catch:{ all -> 0x00b0 }
            goto L_0x00b4
        L_0x00b0:
            r11 = move-exception
            r10.addSuppressed(r11)     // Catch:{ all -> 0x0033 }
        L_0x00b4:
            throw r10     // Catch:{ all -> 0x0033 }
        L_0x00b5:
            r2.close()
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r11 = "Finished regenerating DSO store "
            r10.<init>(r11)
            java.lang.Class r11 = r9.getClass()
            java.lang.String r11 = r11.getName()
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            android.util.Log.v(r1, r10)
            return
        L_0x00d2:
            r2.close()     // Catch:{ all -> 0x00d6 }
            goto L_0x00da
        L_0x00d6:
            r11 = move-exception
            r10.addSuppressed(r11)
        L_0x00da:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.UnpackingSoSource.regenerate(byte, com.facebook.soloader.UnpackingSoSource$DsoManifest, com.facebook.soloader.UnpackingSoSource$InputDsoIterator):void");
    }

    /* access modifiers changed from: protected */
    public boolean depsChanged(byte[] bArr, byte[] bArr2) {
        return !Arrays.equals(bArr, bArr2);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x009f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00a0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean refreshLocked(com.facebook.soloader.FileLocker r11, int r12, byte[] r13) throws java.io.IOException {
        /*
            r10 = this;
            java.lang.String r0 = "fb-UnpackingSoSource"
            java.lang.String r1 = "dso store "
            java.io.File r5 = new java.io.File
            java.io.File r2 = r10.soDirectory
            java.lang.String r3 = "dso_state"
            r5.<init>(r2, r3)
            java.io.RandomAccessFile r2 = new java.io.RandomAccessFile
            java.lang.String r3 = "rw"
            r2.<init>(r5, r3)
            r9 = 1
            r4 = 0
            byte r6 = r2.readByte()     // Catch:{ EOFException -> 0x003d, all -> 0x0033 }
            if (r6 == r9) goto L_0x003e
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ EOFException -> 0x003d, all -> 0x0033 }
            r6.<init>(r1)     // Catch:{ EOFException -> 0x003d, all -> 0x0033 }
            java.io.File r1 = r10.soDirectory     // Catch:{ EOFException -> 0x003d, all -> 0x0033 }
            r6.append(r1)     // Catch:{ EOFException -> 0x003d, all -> 0x0033 }
            java.lang.String r1 = " regeneration interrupted: wiping clean"
            r6.append(r1)     // Catch:{ EOFException -> 0x003d, all -> 0x0033 }
            java.lang.String r1 = r6.toString()     // Catch:{ EOFException -> 0x003d, all -> 0x0033 }
            android.util.Log.v(r0, r1)     // Catch:{ EOFException -> 0x003d, all -> 0x0033 }
            goto L_0x003d
        L_0x0033:
            r11 = move-exception
            r2.close()     // Catch:{ all -> 0x0038 }
            goto L_0x003c
        L_0x0038:
            r12 = move-exception
            r11.addSuppressed(r12)
        L_0x003c:
            throw r11
        L_0x003d:
            r6 = r4
        L_0x003e:
            r2.close()
            java.io.File r1 = new java.io.File
            java.io.File r2 = r10.soDirectory
            java.lang.String r7 = "dso_deps"
            r1.<init>(r2, r7)
            java.io.RandomAccessFile r2 = new java.io.RandomAccessFile
            r2.<init>(r1, r3)
            long r7 = r2.length()     // Catch:{ all -> 0x00ed }
            int r3 = (int) r7     // Catch:{ all -> 0x00ed }
            byte[] r7 = new byte[r3]     // Catch:{ all -> 0x00ed }
            int r8 = r2.read(r7)     // Catch:{ all -> 0x00ed }
            if (r8 == r3) goto L_0x0062
            java.lang.String r3 = "short read of so store deps file: marking unclean"
            android.util.Log.v(r0, r3)     // Catch:{ all -> 0x00ed }
            r6 = r4
        L_0x0062:
            boolean r3 = r10.depsChanged(r7, r13)     // Catch:{ all -> 0x00ed }
            if (r3 == 0) goto L_0x006e
            java.lang.String r3 = "deps mismatch on deps store: regenerating"
            android.util.Log.v(r0, r3)     // Catch:{ all -> 0x00ed }
            r6 = r4
        L_0x006e:
            if (r6 == 0) goto L_0x0078
            r3 = r12 & 2
            if (r3 == 0) goto L_0x0075
            goto L_0x0078
        L_0x0075:
            r0 = 0
            r7 = r0
            goto L_0x009a
        L_0x0078:
            java.lang.String r3 = "so store dirty: regenerating"
            android.util.Log.v(r0, r3)     // Catch:{ all -> 0x00ed }
            writeState(r5, r4)     // Catch:{ all -> 0x00ed }
            com.facebook.soloader.UnpackingSoSource$Unpacker r0 = r10.makeUnpacker(r6)     // Catch:{ all -> 0x00ed }
            com.facebook.soloader.UnpackingSoSource$DsoManifest r3 = r0.getDsoManifest()     // Catch:{ all -> 0x00e1 }
            com.facebook.soloader.UnpackingSoSource$InputDsoIterator r7 = r0.openDsoIterator()     // Catch:{ all -> 0x00e1 }
            r10.regenerate(r6, r3, r7)     // Catch:{ all -> 0x00d5 }
            if (r7 == 0) goto L_0x0094
            r7.close()     // Catch:{ all -> 0x00e1 }
        L_0x0094:
            if (r0 == 0) goto L_0x0099
            r0.close()     // Catch:{ all -> 0x00ed }
        L_0x0099:
            r7 = r3
        L_0x009a:
            r2.close()
            if (r7 != 0) goto L_0x00a0
            return r4
        L_0x00a0:
            r0 = r12 & 4
            if (r0 == 0) goto L_0x00a5
            return r9
        L_0x00a5:
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r4)
            r2 = r10
            r3 = r11
            r4 = r13
            r6 = r1
            java.lang.Runnable r11 = r2.createSyncer(r3, r4, r5, r6, r7, r8)
            r12 = r12 & r9
            if (r12 == 0) goto L_0x00d1
            java.lang.Thread r12 = new java.lang.Thread
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            java.lang.String r0 = "SoSync:"
            r13.<init>(r0)
            java.io.File r0 = r10.soDirectory
            java.lang.String r0 = r0.getName()
            r13.append(r0)
            java.lang.String r13 = r13.toString()
            r12.<init>(r11, r13)
            r12.start()
            goto L_0x00d4
        L_0x00d1:
            r11.run()
        L_0x00d4:
            return r9
        L_0x00d5:
            r11 = move-exception
            if (r7 == 0) goto L_0x00e0
            r7.close()     // Catch:{ all -> 0x00dc }
            goto L_0x00e0
        L_0x00dc:
            r12 = move-exception
            r11.addSuppressed(r12)     // Catch:{ all -> 0x00e1 }
        L_0x00e0:
            throw r11     // Catch:{ all -> 0x00e1 }
        L_0x00e1:
            r11 = move-exception
            if (r0 == 0) goto L_0x00ec
            r0.close()     // Catch:{ all -> 0x00e8 }
            goto L_0x00ec
        L_0x00e8:
            r12 = move-exception
            r11.addSuppressed(r12)     // Catch:{ all -> 0x00ed }
        L_0x00ec:
            throw r11     // Catch:{ all -> 0x00ed }
        L_0x00ed:
            r11 = move-exception
            r2.close()     // Catch:{ all -> 0x00f2 }
            goto L_0x00f6
        L_0x00f2:
            r12 = move-exception
            r11.addSuppressed(r12)
        L_0x00f6:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.UnpackingSoSource.refreshLocked(com.facebook.soloader.FileLocker, int, byte[]):boolean");
    }

    private Runnable createSyncer(FileLocker fileLocker, byte[] bArr, File file, File file2, DsoManifest dsoManifest, Boolean bool) {
        final File file3 = file2;
        final byte[] bArr2 = bArr;
        final DsoManifest dsoManifest2 = dsoManifest;
        final File file4 = file;
        final FileLocker fileLocker2 = fileLocker;
        final Boolean bool2 = bool;
        return new Runnable() {
            public void run() {
                RandomAccessFile randomAccessFile;
                RandomAccessFile randomAccessFile2;
                try {
                    Log.v(UnpackingSoSource.TAG, "starting syncer worker");
                    randomAccessFile = new RandomAccessFile(file3, "rw");
                    randomAccessFile.write(bArr2);
                    randomAccessFile.setLength(randomAccessFile.getFilePointer());
                    randomAccessFile.close();
                    randomAccessFile2 = new RandomAccessFile(new File(UnpackingSoSource.this.soDirectory, UnpackingSoSource.MANIFEST_FILE_NAME), "rw");
                    dsoManifest2.write(randomAccessFile2);
                    randomAccessFile2.close();
                    SysUtil.fsyncRecursive(UnpackingSoSource.this.soDirectory);
                    UnpackingSoSource.writeState(file4, (byte) 1);
                    try {
                        Log.v(UnpackingSoSource.TAG, "releasing dso store lock for " + UnpackingSoSource.this.soDirectory + " (from syncer thread)");
                        fileLocker2.close();
                        return;
                    } catch (IOException e) {
                        if (!bool2.booleanValue()) {
                            throw new RuntimeException(e);
                        }
                        return;
                    }
                    throw th;
                    throw th;
                } catch (Throwable th) {
                    Log.v(UnpackingSoSource.TAG, "releasing dso store lock for " + UnpackingSoSource.this.soDirectory + " (from syncer thread)");
                    fileLocker2.close();
                    throw th;
                }
            }
        };
    }

    /* access modifiers changed from: protected */
    public byte[] getDepsBlock() throws IOException {
        Parcel obtain = Parcel.obtain();
        Unpacker makeUnpacker = makeUnpacker((byte) 1);
        try {
            Dso[] dsoArr = makeUnpacker.getDsoManifest().dsos;
            obtain.writeByte((byte) 1);
            obtain.writeInt(dsoArr.length);
            for (int i = 0; i < dsoArr.length; i++) {
                obtain.writeString(dsoArr[i].name);
                obtain.writeString(dsoArr[i].hash);
            }
            if (makeUnpacker != null) {
                makeUnpacker.close();
            }
            byte[] marshall = obtain.marshall();
            obtain.recycle();
            return marshall;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public FileLocker getOrCreateLock(File file, boolean z) throws IOException {
        return SysUtil.getOrCreateLockOnDir(this.soDirectory, file, z);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x011f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void prepare(int r17) throws java.io.IOException {
        /*
            r16 = this;
            r1 = r16
            java.lang.String r0 = "dso store is up-to-date: "
            java.lang.String r2 = "locked dso store "
            java.lang.String r3 = "error adding "
            java.io.File r4 = r1.soDirectory
            com.facebook.soloader.SysUtil.mkdirOrThrow(r4)
            java.io.File r4 = r1.soDirectory
            boolean r4 = r4.canWrite()
            java.lang.String r5 = "error removing "
            java.lang.String r6 = "releasing dso store lock for "
            java.lang.String r7 = " (syncer thread started)"
            java.lang.String r8 = "not releasing dso store lock for "
            r9 = 1
            java.lang.String r10 = " write permission"
            r11 = 0
            java.lang.String r12 = "fb-UnpackingSoSource"
            r13 = 0
            if (r4 != 0) goto L_0x0044
            java.io.File r14 = r1.soDirectory     // Catch:{ all -> 0x00e5 }
            boolean r14 = r14.setWritable(r9)     // Catch:{ all -> 0x00e5 }
            if (r14 != 0) goto L_0x0044
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e5 }
            r14.<init>(r3)     // Catch:{ all -> 0x00e5 }
            java.io.File r3 = r1.soDirectory     // Catch:{ all -> 0x00e5 }
            java.lang.String r3 = r3.getCanonicalPath()     // Catch:{ all -> 0x00e5 }
            r14.append(r3)     // Catch:{ all -> 0x00e5 }
            r14.append(r10)     // Catch:{ all -> 0x00e5 }
            java.lang.String r3 = r14.toString()     // Catch:{ all -> 0x00e5 }
            android.util.Log.w(r12, r3)     // Catch:{ all -> 0x00e5 }
        L_0x0044:
            java.io.File r3 = new java.io.File     // Catch:{ all -> 0x00e5 }
            java.io.File r14 = r1.soDirectory     // Catch:{ all -> 0x00e5 }
            java.lang.String r15 = "dso_lock"
            r3.<init>(r14, r15)     // Catch:{ all -> 0x00e5 }
            com.facebook.soloader.FileLocker r3 = r1.getOrCreateLock(r3, r9)     // Catch:{ all -> 0x00e5 }
            com.facebook.soloader.FileLocker r9 = r1.mInstanceLock     // Catch:{ all -> 0x00e2 }
            if (r9 != 0) goto L_0x0064
            java.io.File r9 = new java.io.File     // Catch:{ all -> 0x00e2 }
            java.io.File r14 = r1.soDirectory     // Catch:{ all -> 0x00e2 }
            java.lang.String r15 = "dso_instance_lock"
            r9.<init>(r14, r15)     // Catch:{ all -> 0x00e2 }
            com.facebook.soloader.FileLocker r9 = r1.getOrCreateLock(r9, r11)     // Catch:{ all -> 0x00e2 }
            r1.mInstanceLock = r9     // Catch:{ all -> 0x00e2 }
        L_0x0064:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e2 }
            r9.<init>(r2)     // Catch:{ all -> 0x00e2 }
            java.io.File r2 = r1.soDirectory     // Catch:{ all -> 0x00e2 }
            r9.append(r2)     // Catch:{ all -> 0x00e2 }
            java.lang.String r2 = r9.toString()     // Catch:{ all -> 0x00e2 }
            android.util.Log.v(r12, r2)     // Catch:{ all -> 0x00e2 }
            byte[] r2 = r16.getDepsBlock()     // Catch:{ all -> 0x00e2 }
            r9 = r17
            boolean r2 = r1.refreshLocked(r3, r9, r2)     // Catch:{ all -> 0x00e2 }
            if (r2 == 0) goto L_0x0082
            goto L_0x0094
        L_0x0082:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e2 }
            r2.<init>(r0)     // Catch:{ all -> 0x00e2 }
            java.io.File r0 = r1.soDirectory     // Catch:{ all -> 0x00e2 }
            r2.append(r0)     // Catch:{ all -> 0x00e2 }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x00e2 }
            android.util.Log.i(r12, r0)     // Catch:{ all -> 0x00e2 }
            r13 = r3
        L_0x0094:
            if (r4 != 0) goto L_0x00b6
            java.io.File r0 = r1.soDirectory
            boolean r0 = r0.setWritable(r11)
            if (r0 != 0) goto L_0x00b6
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r5)
            java.io.File r2 = r1.soDirectory
            java.lang.String r2 = r2.getCanonicalPath()
            r0.append(r2)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            android.util.Log.w(r12, r0)
        L_0x00b6:
            if (r13 == 0) goto L_0x00cd
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r6)
            java.io.File r2 = r1.soDirectory
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            android.util.Log.v(r12, r0)
            r13.close()
            goto L_0x00e1
        L_0x00cd:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r8)
            java.io.File r2 = r1.soDirectory
            r0.append(r2)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            android.util.Log.v(r12, r0)
        L_0x00e1:
            return
        L_0x00e2:
            r0 = move-exception
            r13 = r3
            goto L_0x00e6
        L_0x00e5:
            r0 = move-exception
        L_0x00e6:
            if (r4 != 0) goto L_0x0108
            java.io.File r2 = r1.soDirectory
            boolean r2 = r2.setWritable(r11)
            if (r2 != 0) goto L_0x0108
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r5)
            java.io.File r3 = r1.soDirectory
            java.lang.String r3 = r3.getCanonicalPath()
            r2.append(r3)
            r2.append(r10)
            java.lang.String r2 = r2.toString()
            android.util.Log.w(r12, r2)
        L_0x0108:
            if (r13 == 0) goto L_0x011f
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r6)
            java.io.File r3 = r1.soDirectory
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            android.util.Log.v(r12, r2)
            r13.close()
            goto L_0x0133
        L_0x011f:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r8)
            java.io.File r3 = r1.soDirectory
            r2.append(r3)
            r2.append(r7)
            java.lang.String r2 = r2.toString()
            android.util.Log.v(r12, r2)
        L_0x0133:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.UnpackingSoSource.prepare(int):void");
    }

    private Object getLibraryLock(String str) {
        Object obj;
        synchronized (this.mLibsBeingLoaded) {
            obj = this.mLibsBeingLoaded.get(str);
            if (obj == null) {
                obj = new Object();
                this.mLibsBeingLoaded.put(str, obj);
            }
        }
        return obj;
    }

    @Nullable
    public String getLibraryPath(String str) throws IOException {
        File soFileByName = getSoFileByName(str);
        if (soFileByName == null) {
            return null;
        }
        return soFileByName.getCanonicalPath();
    }

    /* access modifiers changed from: protected */
    public synchronized void prepare(String str) throws IOException {
        synchronized (getLibraryLock(str)) {
            this.mCorruptedLib = str;
            prepare(2);
        }
    }

    public int loadLibrary(String str, int i, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        int loadLibraryFrom;
        synchronized (getLibraryLock(str)) {
            loadLibraryFrom = loadLibraryFrom(str, i, this.soDirectory, threadPolicy);
        }
        return loadLibraryFrom;
    }
}
