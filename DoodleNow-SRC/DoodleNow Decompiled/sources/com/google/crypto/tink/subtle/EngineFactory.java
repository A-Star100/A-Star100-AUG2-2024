package com.google.crypto.tink.subtle;

import com.google.android.gms.security.ProviderInstaller;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.subtle.EngineWrapper;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;
import java.util.ArrayList;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;

public final class EngineFactory<T_WRAPPER extends EngineWrapper<JcePrimitiveT>, JcePrimitiveT> {
    public static final EngineFactory<EngineWrapper.TCipher, Cipher> CIPHER = new EngineFactory<>(new EngineWrapper.TCipher());
    public static final EngineFactory<EngineWrapper.TKeyAgreement, KeyAgreement> KEY_AGREEMENT = new EngineFactory<>(new EngineWrapper.TKeyAgreement());
    public static final EngineFactory<EngineWrapper.TKeyFactory, KeyFactory> KEY_FACTORY = new EngineFactory<>(new EngineWrapper.TKeyFactory());
    public static final EngineFactory<EngineWrapper.TKeyPairGenerator, KeyPairGenerator> KEY_PAIR_GENERATOR = new EngineFactory<>(new EngineWrapper.TKeyPairGenerator());
    public static final EngineFactory<EngineWrapper.TMac, Mac> MAC = new EngineFactory<>(new EngineWrapper.TMac());
    public static final EngineFactory<EngineWrapper.TMessageDigest, MessageDigest> MESSAGE_DIGEST = new EngineFactory<>(new EngineWrapper.TMessageDigest());
    public static final EngineFactory<EngineWrapper.TSignature, Signature> SIGNATURE = new EngineFactory<>(new EngineWrapper.TSignature());
    private final Policy<JcePrimitiveT> policy;

    private interface Policy<JcePrimitiveT> {
        JcePrimitiveT getInstance(String str) throws GeneralSecurityException;

        JcePrimitiveT getInstance(String str, List<Provider> list) throws GeneralSecurityException;
    }

    private static class DefaultPolicy<JcePrimitiveT> implements Policy<JcePrimitiveT> {
        private final EngineWrapper<JcePrimitiveT> jceFactory;

        private DefaultPolicy(EngineWrapper<JcePrimitiveT> engineWrapper) {
            this.jceFactory = engineWrapper;
        }

        public JcePrimitiveT getInstance(String str) throws GeneralSecurityException {
            return this.jceFactory.getInstance(str, (Provider) null);
        }

        public JcePrimitiveT getInstance(String str, List<Provider> list) throws GeneralSecurityException {
            for (Provider instance : list) {
                try {
                    return this.jceFactory.getInstance(str, instance);
                } catch (Exception unused) {
                }
            }
            return getInstance(str);
        }
    }

    private static class FipsPolicy<JcePrimitiveT> implements Policy<JcePrimitiveT> {
        private final EngineWrapper<JcePrimitiveT> jceFactory;

        private FipsPolicy(EngineWrapper<JcePrimitiveT> engineWrapper) {
            this.jceFactory = engineWrapper;
        }

        public JcePrimitiveT getInstance(String str) throws GeneralSecurityException {
            Exception exc = null;
            for (Provider instance : EngineFactory.toProviderList(ProviderInstaller.PROVIDER_NAME, "AndroidOpenSSL", "Conscrypt")) {
                try {
                    return this.jceFactory.getInstance(str, instance);
                } catch (Exception e) {
                    if (exc == null) {
                        exc = e;
                    }
                }
            }
            throw new GeneralSecurityException("No good Provider found.", exc);
        }

        public JcePrimitiveT getInstance(String str, List<Provider> list) throws GeneralSecurityException {
            return getInstance(str);
        }
    }

    private static class AndroidPolicy<JcePrimitiveT> implements Policy<JcePrimitiveT> {
        private final EngineWrapper<JcePrimitiveT> jceFactory;

        private AndroidPolicy(EngineWrapper<JcePrimitiveT> engineWrapper) {
            this.jceFactory = engineWrapper;
        }

        public JcePrimitiveT getInstance(String str) throws GeneralSecurityException {
            Exception exc = null;
            for (Provider instance : EngineFactory.toProviderList(ProviderInstaller.PROVIDER_NAME, "AndroidOpenSSL")) {
                try {
                    return this.jceFactory.getInstance(str, instance);
                } catch (Exception e) {
                    if (exc == null) {
                        exc = e;
                    }
                }
            }
            return this.jceFactory.getInstance(str, (Provider) null);
        }

        public JcePrimitiveT getInstance(String str, List<Provider> list) throws GeneralSecurityException {
            return getInstance(str);
        }
    }

    public static List<Provider> toProviderList(String... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String provider : strArr) {
            Provider provider2 = Security.getProvider(provider);
            if (provider2 != null) {
                arrayList.add(provider2);
            }
        }
        return arrayList;
    }

    public EngineFactory(T_WRAPPER t_wrapper) {
        if (TinkFipsUtil.useOnlyFips()) {
            this.policy = new FipsPolicy(t_wrapper);
        } else if (SubtleUtil.isAndroid()) {
            this.policy = new AndroidPolicy(t_wrapper);
        } else {
            this.policy = new DefaultPolicy(t_wrapper);
        }
    }

    public JcePrimitiveT getInstance(String str) throws GeneralSecurityException {
        return this.policy.getInstance(str);
    }

    /* access modifiers changed from: package-private */
    public JcePrimitiveT getInstance(String str, List<Provider> list) throws GeneralSecurityException {
        return this.policy.getInstance(str, list);
    }
}
