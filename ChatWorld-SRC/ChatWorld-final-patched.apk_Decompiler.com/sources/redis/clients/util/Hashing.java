package redis.clients.util;

import com.google.appinventor.components.runtime.util.Ev3Constants;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public interface Hashing {
    public static final Hashing MD5 = new Hashing() {
        public long hash(String key) {
            return hash(SafeEncoder.encode(key));
        }

        public long hash(byte[] key) {
            try {
                if (md5Holder.get() == null) {
                    md5Holder.set(MessageDigest.getInstance("MD5"));
                }
                MessageDigest md5 = (MessageDigest) md5Holder.get();
                md5.reset();
                md5.update(key);
                byte[] bKey = md5.digest();
                return (((long) (bKey[3] & Ev3Constants.Opcode.TST)) << 24) | (((long) (bKey[2] & Ev3Constants.Opcode.TST)) << 16) | (((long) (bKey[1] & Ev3Constants.Opcode.TST)) << 8) | ((long) (bKey[0] & Ev3Constants.Opcode.TST));
            } catch (NoSuchAlgorithmException e) {
                throw new IllegalStateException("++++ no md5 algorithm found");
            }
        }
    };
    public static final Hashing MURMUR_HASH = new MurmurHash();
    public static final ThreadLocal<MessageDigest> md5Holder = new ThreadLocal<>();

    long hash(String str);

    long hash(byte[] bArr);
}
