package com.google.crypto.tink.integration.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import com.google.crypto.tink.Aead;
import com.google.crypto.tink.BinaryKeysetReader;
import com.google.crypto.tink.CleartextKeysetHandle;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.KeysetManager;
import com.google.crypto.tink.KeysetWriter;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.subtle.Hex;
import java.io.CharConversionException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStoreException;
import java.security.ProviderException;

public final class AndroidKeysetManager {
    /* access modifiers changed from: private */
    public static final String TAG = "AndroidKeysetManager";
    /* access modifiers changed from: private */
    public static final Object lock = new Object();
    private KeysetManager keysetManager;
    private final Aead masterAead;
    private final KeysetWriter writer;

    /* access modifiers changed from: private */
    public static boolean isAtLeastM() {
        return true;
    }

    /* synthetic */ AndroidKeysetManager(Builder builder, AnonymousClass1 r2) {
        this(builder);
    }

    private AndroidKeysetManager(Builder builder) {
        this.writer = new SharedPrefKeysetWriter(builder.context, builder.keysetName, builder.prefFileName);
        this.masterAead = builder.masterAead;
        this.keysetManager = builder.keysetManager;
    }

    public static final class Builder {
        /* access modifiers changed from: private */
        public Context context = null;
        private KeyTemplate keyTemplate = null;
        /* access modifiers changed from: private */
        public KeysetManager keysetManager;
        /* access modifiers changed from: private */
        public String keysetName = null;
        /* access modifiers changed from: private */
        public Aead masterAead = null;
        private String masterKeyUri = null;
        /* access modifiers changed from: private */
        public String prefFileName = null;
        private boolean useKeystore = true;

        @Deprecated
        public Builder doNotUseKeystore() {
            this.masterKeyUri = null;
            this.useKeystore = false;
            return this;
        }

        public Builder withKeyTemplate(KeyTemplate keyTemplate2) {
            this.keyTemplate = keyTemplate2;
            return this;
        }

        public Builder withSharedPref(Context context2, String str, String str2) throws IOException {
            if (context2 == null) {
                throw new IllegalArgumentException("need an Android context");
            } else if (str != null) {
                this.context = context2;
                this.keysetName = str;
                this.prefFileName = str2;
                return this;
            } else {
                throw new IllegalArgumentException("need a keyset name");
            }
        }

        public Builder withMasterKeyUri(String str) {
            if (!str.startsWith(AndroidKeystoreKmsClient.PREFIX)) {
                throw new IllegalArgumentException("key URI must start with android-keystore://");
            } else if (this.useKeystore) {
                this.masterKeyUri = str;
                return this;
            } else {
                throw new IllegalArgumentException("cannot call withMasterKeyUri() after calling doNotUseKeystore()");
            }
        }

        @Deprecated
        public Builder withKeyTemplate(com.google.crypto.tink.proto.KeyTemplate keyTemplate2) {
            this.keyTemplate = KeyTemplate.create(keyTemplate2.getTypeUrl(), keyTemplate2.getValue().toByteArray(), AndroidKeysetManager.fromProto(keyTemplate2.getOutputPrefixType()));
            return this;
        }

        private static byte[] readKeysetFromPrefs(Context context2, String str, String str2) throws IOException {
            SharedPreferences sharedPreferences;
            if (str != null) {
                Context applicationContext = context2.getApplicationContext();
                if (str2 == null) {
                    sharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext);
                } else {
                    sharedPreferences = applicationContext.getSharedPreferences(str2, 0);
                }
                try {
                    String string = sharedPreferences.getString(str, (String) null);
                    if (string == null) {
                        return null;
                    }
                    return Hex.decode(string);
                } catch (ClassCastException | IllegalArgumentException unused) {
                    throw new CharConversionException(String.format("can't read keyset; the pref value %s is not a valid hex string", new Object[]{str}));
                }
            } else {
                throw new IllegalArgumentException("keysetName cannot be null");
            }
        }

        private KeysetManager readKeysetInCleartext(byte[] bArr) throws GeneralSecurityException, IOException {
            return KeysetManager.withKeysetHandle(CleartextKeysetHandle.read(BinaryKeysetReader.withBytes(bArr)));
        }

        public synchronized AndroidKeysetManager build() throws GeneralSecurityException, IOException {
            AndroidKeysetManager androidKeysetManager;
            if (this.keysetName != null) {
                synchronized (AndroidKeysetManager.lock) {
                    byte[] readKeysetFromPrefs = readKeysetFromPrefs(this.context, this.keysetName, this.prefFileName);
                    if (readKeysetFromPrefs == null) {
                        if (this.masterKeyUri != null) {
                            this.masterAead = readOrGenerateNewMasterKey();
                        }
                        this.keysetManager = generateKeysetAndWriteToPrefs();
                    } else {
                        if (this.masterKeyUri != null) {
                            if (AndroidKeysetManager.isAtLeastM()) {
                                this.keysetManager = readMasterkeyDecryptAndParseKeyset(readKeysetFromPrefs);
                            }
                        }
                        this.keysetManager = readKeysetInCleartext(readKeysetFromPrefs);
                    }
                    androidKeysetManager = new AndroidKeysetManager(this, (AnonymousClass1) null);
                }
            } else {
                throw new IllegalArgumentException("keysetName cannot be null");
            }
            return androidKeysetManager;
        }

        private Aead readOrGenerateNewMasterKey() throws GeneralSecurityException {
            if (!AndroidKeysetManager.isAtLeastM()) {
                Log.w(AndroidKeysetManager.TAG, "Android Keystore requires at least Android M");
                return null;
            }
            AndroidKeystoreKmsClient androidKeystoreKmsClient = new AndroidKeystoreKmsClient();
            try {
                boolean generateKeyIfNotExist = AndroidKeystoreKmsClient.generateKeyIfNotExist(this.masterKeyUri);
                try {
                    return androidKeystoreKmsClient.getAead(this.masterKeyUri);
                } catch (GeneralSecurityException | ProviderException e) {
                    if (generateKeyIfNotExist) {
                        Log.w(AndroidKeysetManager.TAG, "cannot use Android Keystore, it'll be disabled", e);
                        return null;
                    }
                    throw new KeyStoreException(String.format("the master key %s exists but is unusable", new Object[]{this.masterKeyUri}), e);
                }
            } catch (GeneralSecurityException | ProviderException e2) {
                Log.w(AndroidKeysetManager.TAG, "cannot use Android Keystore, it'll be disabled", e2);
                return null;
            }
        }

        private KeysetManager generateKeysetAndWriteToPrefs() throws GeneralSecurityException, IOException {
            if (this.keyTemplate != null) {
                KeysetManager add = KeysetManager.withEmptyKeyset().add(this.keyTemplate);
                KeysetManager primary = add.setPrimary(add.getKeysetHandle().getKeysetInfo().getKeyInfo(0).getKeyId());
                SharedPrefKeysetWriter sharedPrefKeysetWriter = new SharedPrefKeysetWriter(this.context, this.keysetName, this.prefFileName);
                if (this.masterAead != null) {
                    primary.getKeysetHandle().write(sharedPrefKeysetWriter, this.masterAead);
                } else {
                    CleartextKeysetHandle.write(primary.getKeysetHandle(), sharedPrefKeysetWriter);
                }
                return primary;
            }
            throw new GeneralSecurityException("cannot read or generate keyset");
        }

        private KeysetManager readMasterkeyDecryptAndParseKeyset(byte[] bArr) throws GeneralSecurityException, IOException {
            try {
                this.masterAead = new AndroidKeystoreKmsClient().getAead(this.masterKeyUri);
                try {
                    return KeysetManager.withKeysetHandle(KeysetHandle.read(BinaryKeysetReader.withBytes(bArr), this.masterAead));
                } catch (IOException | GeneralSecurityException e) {
                    try {
                        return readKeysetInCleartext(bArr);
                    } catch (IOException unused) {
                        throw e;
                    }
                }
            } catch (GeneralSecurityException | ProviderException e2) {
                try {
                    KeysetManager readKeysetInCleartext = readKeysetInCleartext(bArr);
                    Log.w(AndroidKeysetManager.TAG, "cannot use Android Keystore, it'll be disabled", e2);
                    return readKeysetInCleartext;
                } catch (IOException unused2) {
                    throw e2;
                }
            }
        }
    }

    public synchronized KeysetHandle getKeysetHandle() throws GeneralSecurityException {
        return this.keysetManager.getKeysetHandle();
    }

    @Deprecated
    public synchronized AndroidKeysetManager rotate(com.google.crypto.tink.proto.KeyTemplate keyTemplate) throws GeneralSecurityException {
        KeysetManager rotate = this.keysetManager.rotate(keyTemplate);
        this.keysetManager = rotate;
        write(rotate);
        return this;
    }

    @Deprecated
    public synchronized AndroidKeysetManager add(com.google.crypto.tink.proto.KeyTemplate keyTemplate) throws GeneralSecurityException {
        KeysetManager add = this.keysetManager.add(keyTemplate);
        this.keysetManager = add;
        write(add);
        return this;
    }

    public synchronized AndroidKeysetManager add(KeyTemplate keyTemplate) throws GeneralSecurityException {
        KeysetManager add = this.keysetManager.add(keyTemplate);
        this.keysetManager = add;
        write(add);
        return this;
    }

    public synchronized AndroidKeysetManager setPrimary(int i) throws GeneralSecurityException {
        KeysetManager primary = this.keysetManager.setPrimary(i);
        this.keysetManager = primary;
        write(primary);
        return this;
    }

    @Deprecated
    public synchronized AndroidKeysetManager promote(int i) throws GeneralSecurityException {
        return setPrimary(i);
    }

    public synchronized AndroidKeysetManager enable(int i) throws GeneralSecurityException {
        KeysetManager enable = this.keysetManager.enable(i);
        this.keysetManager = enable;
        write(enable);
        return this;
    }

    public synchronized AndroidKeysetManager disable(int i) throws GeneralSecurityException {
        KeysetManager disable = this.keysetManager.disable(i);
        this.keysetManager = disable;
        write(disable);
        return this;
    }

    public synchronized AndroidKeysetManager delete(int i) throws GeneralSecurityException {
        KeysetManager delete = this.keysetManager.delete(i);
        this.keysetManager = delete;
        write(delete);
        return this;
    }

    public synchronized AndroidKeysetManager destroy(int i) throws GeneralSecurityException {
        KeysetManager destroy = this.keysetManager.destroy(i);
        this.keysetManager = destroy;
        write(destroy);
        return this;
    }

    public synchronized boolean isUsingKeystore() {
        return shouldUseKeystore();
    }

    private void write(KeysetManager keysetManager2) throws GeneralSecurityException {
        try {
            if (shouldUseKeystore()) {
                keysetManager2.getKeysetHandle().write(this.writer, this.masterAead);
            } else {
                CleartextKeysetHandle.write(keysetManager2.getKeysetHandle(), this.writer);
            }
        } catch (IOException e) {
            throw new GeneralSecurityException(e);
        }
    }

    private boolean shouldUseKeystore() {
        return this.masterAead != null && isAtLeastM();
    }

    /* renamed from: com.google.crypto.tink.integration.android.AndroidKeysetManager$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.google.crypto.tink.proto.OutputPrefixType[] r0 = com.google.crypto.tink.proto.OutputPrefixType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType = r0
                com.google.crypto.tink.proto.OutputPrefixType r1 = com.google.crypto.tink.proto.OutputPrefixType.TINK     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.crypto.tink.proto.OutputPrefixType r1 = com.google.crypto.tink.proto.OutputPrefixType.LEGACY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.crypto.tink.proto.OutputPrefixType r1 = com.google.crypto.tink.proto.OutputPrefixType.RAW     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.crypto.tink.proto.OutputPrefixType r1 = com.google.crypto.tink.proto.OutputPrefixType.CRUNCHY     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.integration.android.AndroidKeysetManager.AnonymousClass1.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    public static KeyTemplate.OutputPrefixType fromProto(OutputPrefixType outputPrefixType) {
        int i = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[outputPrefixType.ordinal()];
        if (i == 1) {
            return KeyTemplate.OutputPrefixType.TINK;
        }
        if (i == 2) {
            return KeyTemplate.OutputPrefixType.LEGACY;
        }
        if (i == 3) {
            return KeyTemplate.OutputPrefixType.RAW;
        }
        if (i == 4) {
            return KeyTemplate.OutputPrefixType.CRUNCHY;
        }
        throw new IllegalArgumentException("Unknown output prefix type");
    }
}
