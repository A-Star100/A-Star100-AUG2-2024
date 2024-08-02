package redis.clients.util;

public final class JedisClusterHashTagUtil {
    private JedisClusterHashTagUtil() {
        throw new InstantiationError("Must not instantiate this class");
    }

    public static String getHashTag(String key) {
        return extractHashTag(key, true);
    }

    public static boolean isClusterCompliantMatchPattern(String matchPattern) {
        String tag = extractHashTag(matchPattern, false);
        if (tag == null || tag.isEmpty()) {
            return false;
        }
        return true;
    }

    private static String extractHashTag(String key, boolean returnKeyOnAbsence) {
        int e;
        int s = key.indexOf("{");
        if (s > -1 && (e = key.indexOf("}", s + 1)) > -1 && e != s + 1) {
            return key.substring(s + 1, e);
        }
        if (returnKeyOnAbsence) {
            return key;
        }
        return null;
    }
}
