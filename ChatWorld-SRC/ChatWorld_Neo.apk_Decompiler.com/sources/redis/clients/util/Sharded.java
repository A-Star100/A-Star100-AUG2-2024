package redis.clients.util;

import com.google.appinventor.components.common.ComponentConstants;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import redis.clients.util.ShardInfo;

public class Sharded<R, S extends ShardInfo<R>> {
    public static final Pattern DEFAULT_KEY_TAG_PATTERN = Pattern.compile("\\{(.+?)\\}");
    public static final int DEFAULT_WEIGHT = 1;
    private final Hashing algo;
    private TreeMap<Long, S> nodes;
    private final Map<ShardInfo<R>, R> resources;
    private Pattern tagPattern;

    public Sharded(List<S> shards) {
        this(shards, Hashing.MURMUR_HASH);
    }

    public Sharded(List<S> shards, Hashing algo2) {
        this.resources = new LinkedHashMap();
        this.tagPattern = null;
        this.algo = algo2;
        initialize(shards);
    }

    public Sharded(List<S> shards, Pattern tagPattern2) {
        this(shards, Hashing.MURMUR_HASH, tagPattern2);
    }

    public Sharded(List<S> shards, Hashing algo2, Pattern tagPattern2) {
        this.resources = new LinkedHashMap();
        this.tagPattern = null;
        this.algo = algo2;
        this.tagPattern = tagPattern2;
        initialize(shards);
    }

    private void initialize(List<S> shards) {
        this.nodes = new TreeMap<>();
        for (int i = 0; i != shards.size(); i++) {
            S shardInfo = (ShardInfo) shards.get(i);
            if (shardInfo.getName() == null) {
                for (int n = 0; n < shardInfo.getWeight() * ComponentConstants.TEXTBOX_PREFERRED_WIDTH; n++) {
                    this.nodes.put(Long.valueOf(this.algo.hash("SHARD-" + i + "-NODE-" + n)), shardInfo);
                }
            } else {
                for (int n2 = 0; n2 < shardInfo.getWeight() * ComponentConstants.TEXTBOX_PREFERRED_WIDTH; n2++) {
                    this.nodes.put(Long.valueOf(this.algo.hash(String.valueOf(shardInfo.getName()) + "*" + shardInfo.getWeight() + n2)), shardInfo);
                }
            }
            this.resources.put(shardInfo, shardInfo.createResource());
        }
    }

    public R getShard(byte[] key) {
        return this.resources.get(getShardInfo(key));
    }

    public R getShard(String key) {
        return this.resources.get(getShardInfo(key));
    }

    public S getShardInfo(byte[] key) {
        SortedMap<Long, S> tail = this.nodes.tailMap(Long.valueOf(this.algo.hash(key)));
        if (!tail.isEmpty()) {
            return (ShardInfo) tail.get(tail.firstKey());
        }
        TreeMap<Long, S> treeMap = this.nodes;
        return (ShardInfo) treeMap.get(treeMap.firstKey());
    }

    public S getShardInfo(String key) {
        return getShardInfo(SafeEncoder.encode(getKeyTag(key)));
    }

    public String getKeyTag(String key) {
        Pattern pattern = this.tagPattern;
        if (pattern != null) {
            Matcher m = pattern.matcher(key);
            if (m.find()) {
                return m.group(1);
            }
        }
        return key;
    }

    public Collection<S> getAllShardInfo() {
        return Collections.unmodifiableCollection(this.nodes.values());
    }

    public Collection<R> getAllShards() {
        return Collections.unmodifiableCollection(this.resources.values());
    }
}
