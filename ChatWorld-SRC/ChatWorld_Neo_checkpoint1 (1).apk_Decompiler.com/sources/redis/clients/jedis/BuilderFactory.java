package redis.clients.jedis;

import com.google.appinventor.components.common.PropertyTypeConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import redis.clients.util.JedisByteHashMap;
import redis.clients.util.SafeEncoder;

public final class BuilderFactory {
    public static final Builder<Boolean> BOOLEAN = new Builder<Boolean>() {
        public Boolean build(Object data) {
            return Boolean.valueOf(((Long) data).longValue() == 1);
        }

        public String toString() {
            return PropertyTypeConstants.PROPERTY_TYPE_BOOLEAN;
        }
    };
    public static final Builder<byte[]> BYTE_ARRAY = new Builder<byte[]>() {
        public byte[] build(Object data) {
            return (byte[]) data;
        }

        public String toString() {
            return "byte[]";
        }
    };
    public static final Builder<List<byte[]>> BYTE_ARRAY_LIST = new Builder<List<byte[]>>() {
        public List<byte[]> build(Object data) {
            if (data == null) {
                return Collections.emptyList();
            }
            return (List) data;
        }

        public String toString() {
            return "List<byte[]>";
        }
    };
    public static final Builder<Map<byte[], byte[]>> BYTE_ARRAY_MAP = new Builder<Map<byte[], byte[]>>() {
        public Map<byte[], byte[]> build(Object data) {
            Map<byte[], byte[]> hash = new JedisByteHashMap();
            Iterator<byte[]> iterator = ((List) data).iterator();
            while (iterator.hasNext()) {
                hash.put(iterator.next(), iterator.next());
            }
            return hash;
        }

        public String toString() {
            return "Map<byte[], byte[]>";
        }
    };
    public static final Builder<Set<byte[]>> BYTE_ARRAY_ZSET = new Builder<Set<byte[]>>() {
        public Set<byte[]> build(Object data) {
            if (data == null) {
                return Collections.emptySet();
            }
            List<byte[]> l = (List) data;
            Set<byte[]> result = new LinkedHashSet<>(l);
            for (byte[] barray : l) {
                if (barray == null) {
                    result.add((Object) null);
                } else {
                    result.add(barray);
                }
            }
            return result;
        }

        public String toString() {
            return "ZSet<byte[]>";
        }
    };
    public static final Builder<Double> DOUBLE = new Builder<Double>() {
        public Double build(Object data) {
            String asString = BuilderFactory.STRING.build(data);
            if (asString == null) {
                return null;
            }
            return Double.valueOf(asString);
        }

        public String toString() {
            return "double";
        }
    };
    public static final Builder<Object> EVAL_BINARY_RESULT = new Builder<Object>() {
        public Object build(Object data) {
            return evalResult(data);
        }

        public String toString() {
            return "Eval<Object>";
        }

        private Object evalResult(Object result) {
            if (!(result instanceof List)) {
                return result;
            }
            List<?> list = (List) result;
            List<Object> listResult = new ArrayList<>(list.size());
            for (Object bin : list) {
                listResult.add(evalResult(bin));
            }
            return listResult;
        }
    };
    public static final Builder<Object> EVAL_RESULT = new Builder<Object>() {
        public Object build(Object data) {
            return evalResult(data);
        }

        public String toString() {
            return "Eval<Object>";
        }

        private Object evalResult(Object result) {
            if (result instanceof byte[]) {
                return SafeEncoder.encode((byte[]) result);
            }
            if (!(result instanceof List)) {
                return result;
            }
            List<?> list = (List) result;
            List<Object> listResult = new ArrayList<>(list.size());
            for (Object bin : list) {
                listResult.add(evalResult(bin));
            }
            return listResult;
        }
    };
    public static final Builder<List<GeoRadiusResponse>> GEORADIUS_WITH_PARAMS_RESULT = new Builder<List<GeoRadiusResponse>>() {
        public List<GeoRadiusResponse> build(Object data) {
            Iterator<Object> it;
            if (data == null) {
                return Collections.emptyList();
            }
            List<Object> objectList = (List) data;
            if (objectList.isEmpty()) {
                return new ArrayList();
            }
            List<GeoRadiusResponse> responses = new ArrayList<>(objectList.size());
            int i = 0;
            if (objectList.get(0) instanceof List) {
                Iterator<Object> it2 = objectList.iterator();
                while (it2.hasNext()) {
                    List<Object> informations = (List) it2.next();
                    GeoRadiusResponse resp = new GeoRadiusResponse((byte[]) informations.get(i));
                    int size = informations.size();
                    int idx = 1;
                    while (idx < size) {
                        Object info = informations.get(idx);
                        if (info instanceof List) {
                            List<Object> coord = (List) info;
                            it = it2;
                            resp.setCoordinate(new GeoCoordinate(convertByteArrayToDouble(coord.get(i)).doubleValue(), convertByteArrayToDouble(coord.get(1)).doubleValue()));
                        } else {
                            it = it2;
                            resp.setDistance(convertByteArrayToDouble(info).doubleValue());
                        }
                        idx++;
                        it2 = it;
                        i = 0;
                    }
                    responses.add(resp);
                }
            } else {
                Iterator<Object> it3 = objectList.iterator();
                while (it3.hasNext()) {
                    responses.add(new GeoRadiusResponse((byte[]) it3.next()));
                }
            }
            return responses;
        }

        private Double convertByteArrayToDouble(Object obj) {
            return Double.valueOf(SafeEncoder.encode((byte[]) obj));
        }

        public String toString() {
            return "GeoRadiusWithParamsResult";
        }
    };
    public static final Builder<List<GeoCoordinate>> GEO_COORDINATE_LIST = new Builder<List<GeoCoordinate>>() {
        public List<GeoCoordinate> build(Object data) {
            if (data == null) {
                return Collections.emptyList();
            }
            return interpretGeoposResult((List) data);
        }

        public String toString() {
            return "List<GeoCoordinate>";
        }

        private List<GeoCoordinate> interpretGeoposResult(List<Object> responses) {
            List<GeoCoordinate> responseCoordinate = new ArrayList<>(responses.size());
            for (Object response : responses) {
                if (response == null) {
                    responseCoordinate.add((Object) null);
                } else {
                    List<Object> respList = (List) response;
                    responseCoordinate.add(new GeoCoordinate(Double.parseDouble(SafeEncoder.encode((byte[]) respList.get(0))), Double.parseDouble(SafeEncoder.encode((byte[]) respList.get(1)))));
                }
            }
            return responseCoordinate;
        }
    };
    public static final Builder<Long> LONG = new Builder<Long>() {
        public Long build(Object data) {
            return (Long) data;
        }

        public String toString() {
            return "long";
        }
    };
    public static final Builder<List<Long>> LONG_LIST = new Builder<List<Long>>() {
        public List<Long> build(Object data) {
            if (data == null) {
                return null;
            }
            return (List) data;
        }

        public String toString() {
            return "List<Long>";
        }
    };
    public static final Builder<List<Module>> MODULE_LIST = new Builder<List<Module>>() {
        public List<Module> build(Object data) {
            if (data == null) {
                return Collections.emptyList();
            }
            List<List<Object>> objectList = (List) data;
            if (objectList.isEmpty()) {
                return new ArrayList();
            }
            List<Module> responses = new ArrayList<>(objectList.size());
            for (List<Object> moduleResp : objectList) {
                responses.add(new Module(SafeEncoder.encode((byte[]) moduleResp.get(1)), ((Long) moduleResp.get(3)).intValue()));
            }
            return responses;
        }

        public String toString() {
            return "List<Module>";
        }
    };
    public static final Builder<Map<String, String>> PUBSUB_NUMSUB_MAP = new Builder<Map<String, String>>() {
        public Map<String, String> build(Object data) {
            List<Object> flatHash = (List) data;
            Map<String, String> hash = new HashMap<>(flatHash.size() / 2, 1.0f);
            Iterator<Object> iterator = flatHash.iterator();
            while (iterator.hasNext()) {
                hash.put(SafeEncoder.encode((byte[]) iterator.next()), String.valueOf((Long) iterator.next()));
            }
            return hash;
        }

        public String toString() {
            return "PUBSUB_NUMSUB_MAP<String, String>";
        }
    };
    public static final Builder<String> STRING = new Builder<String>() {
        public String build(Object data) {
            if (data == null) {
                return null;
            }
            return SafeEncoder.encode((byte[]) data);
        }

        public String toString() {
            return PropertyTypeConstants.PROPERTY_TYPE_STRING;
        }
    };
    public static final Builder<List<String>> STRING_LIST = new Builder<List<String>>() {
        public List<String> build(Object data) {
            if (data == null) {
                return Collections.emptyList();
            }
            List<byte[]> l = (List) data;
            ArrayList<String> result = new ArrayList<>(l.size());
            for (byte[] barray : l) {
                if (barray == null) {
                    result.add((Object) null);
                } else {
                    result.add(SafeEncoder.encode(barray));
                }
            }
            return result;
        }

        public String toString() {
            return "List<String>";
        }
    };
    public static final Builder<Map<String, String>> STRING_MAP = new Builder<Map<String, String>>() {
        public Map<String, String> build(Object data) {
            List<byte[]> flatHash = (List) data;
            Map<String, String> hash = new HashMap<>(flatHash.size() / 2, 1.0f);
            Iterator<byte[]> iterator = flatHash.iterator();
            while (iterator.hasNext()) {
                hash.put(SafeEncoder.encode(iterator.next()), SafeEncoder.encode(iterator.next()));
            }
            return hash;
        }

        public String toString() {
            return "Map<String, String>";
        }
    };
    public static final Builder<Set<String>> STRING_SET = new Builder<Set<String>>() {
        public Set<String> build(Object data) {
            if (data == null) {
                return Collections.emptySet();
            }
            List<byte[]> l = (List) data;
            Set<String> result = new HashSet<>(l.size(), 1.0f);
            for (byte[] barray : l) {
                if (barray == null) {
                    result.add((Object) null);
                } else {
                    result.add(SafeEncoder.encode(barray));
                }
            }
            return result;
        }

        public String toString() {
            return "Set<String>";
        }
    };
    public static final Builder<Set<String>> STRING_ZSET = new Builder<Set<String>>() {
        public Set<String> build(Object data) {
            if (data == null) {
                return Collections.emptySet();
            }
            List<byte[]> l = (List) data;
            Set<String> result = new LinkedHashSet<>(l.size(), 1.0f);
            for (byte[] barray : l) {
                if (barray == null) {
                    result.add((Object) null);
                } else {
                    result.add(SafeEncoder.encode(barray));
                }
            }
            return result;
        }

        public String toString() {
            return "ZSet<String>";
        }
    };
    public static final Builder<Set<Tuple>> TUPLE_ZSET = new Builder<Set<Tuple>>() {
        public Set<Tuple> build(Object data) {
            if (data == null) {
                return Collections.emptySet();
            }
            List<byte[]> l = (List) data;
            Set<Tuple> result = new LinkedHashSet<>(l.size() / 2, 1.0f);
            Iterator<byte[]> iterator = l.iterator();
            while (iterator.hasNext()) {
                result.add(new Tuple(SafeEncoder.encode(iterator.next()), Double.valueOf(SafeEncoder.encode(iterator.next()))));
            }
            return result;
        }

        public String toString() {
            return "ZSet<Tuple>";
        }
    };
    public static final Builder<Set<Tuple>> TUPLE_ZSET_BINARY = new Builder<Set<Tuple>>() {
        public Set<Tuple> build(Object data) {
            if (data == null) {
                return Collections.emptySet();
            }
            List<byte[]> l = (List) data;
            Set<Tuple> result = new LinkedHashSet<>(l.size() / 2, 1.0f);
            Iterator<byte[]> iterator = l.iterator();
            while (iterator.hasNext()) {
                result.add(new Tuple(iterator.next(), Double.valueOf(SafeEncoder.encode(iterator.next()))));
            }
            return result;
        }

        public String toString() {
            return "ZSet<Tuple>";
        }
    };

    private BuilderFactory() {
        throw new InstantiationError("Must not instantiate this class");
    }
}
