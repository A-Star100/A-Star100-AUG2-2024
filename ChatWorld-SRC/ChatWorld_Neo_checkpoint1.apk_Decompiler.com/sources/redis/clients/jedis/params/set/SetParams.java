package redis.clients.jedis.params.set;

import java.util.ArrayList;
import redis.clients.jedis.params.Params;
import redis.clients.util.SafeEncoder;

public class SetParams extends Params {
    private static final String EX = "ex";
    private static final String NX = "nx";
    private static final String PX = "px";
    private static final String XX = "xx";

    private SetParams() {
    }

    public static SetParams setParams() {
        return new SetParams();
    }

    public SetParams ex(int secondsToExpire) {
        addParam(EX, Integer.valueOf(secondsToExpire));
        return this;
    }

    public SetParams px(long millisecondsToExpire) {
        addParam(PX, Long.valueOf(millisecondsToExpire));
        return this;
    }

    public SetParams nx() {
        addParam(NX);
        return this;
    }

    public SetParams xx() {
        addParam(XX);
        return this;
    }

    public byte[][] getByteParams(byte[]... args) {
        ArrayList<byte[]> byteParams = new ArrayList<>();
        for (byte[] arg : args) {
            byteParams.add(arg);
        }
        if (contains(NX)) {
            byteParams.add(SafeEncoder.encode(NX));
        }
        if (contains(XX)) {
            byteParams.add(SafeEncoder.encode(XX));
        }
        if (contains(EX)) {
            byteParams.add(SafeEncoder.encode(EX));
            byteParams.add(SafeEncoder.encode(String.valueOf(getParam(EX))));
        }
        if (contains(PX)) {
            byteParams.add(SafeEncoder.encode(PX));
            byteParams.add(SafeEncoder.encode(String.valueOf(getParam(PX))));
        }
        return (byte[][]) byteParams.toArray(new byte[byteParams.size()][]);
    }
}
