package redis.clients.util;

public abstract class ShardInfo<T> {
    private int weight;

    /* access modifiers changed from: protected */
    public abstract T createResource();

    public abstract String getName();

    public ShardInfo() {
    }

    public ShardInfo(int weight2) {
        this.weight = weight2;
    }

    public int getWeight() {
        return this.weight;
    }
}
