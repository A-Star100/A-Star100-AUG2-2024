package redis.clients.jedis;

import redis.clients.jedis.exceptions.JedisDataException;

public class Response<T> {
    private Builder<T> builder;
    private boolean building = false;
    private boolean built = false;
    private Object data;
    private Response<?> dependency = null;
    protected JedisDataException exception = null;
    protected T response = null;
    private boolean set = false;

    public Response(Builder<T> b) {
        this.builder = b;
    }

    public void set(Object data2) {
        this.data = data2;
        this.set = true;
    }

    public T get() {
        Response<?> response2 = this.dependency;
        if (response2 != null && response2.set && !response2.built) {
            response2.build();
        }
        if (this.set) {
            if (!this.built) {
                build();
            }
            JedisDataException jedisDataException = this.exception;
            if (jedisDataException == null) {
                return this.response;
            }
            throw jedisDataException;
        }
        throw new JedisDataException("Please close pipeline or multi block before calling this method.");
    }

    public void setDependency(Response<?> dependency2) {
        this.dependency = dependency2;
    }

    private void build() {
        if (!this.building) {
            this.building = true;
            try {
                Object obj = this.data;
                if (obj != null) {
                    if (obj instanceof JedisDataException) {
                        this.exception = (JedisDataException) obj;
                    } else {
                        this.response = this.builder.build(obj);
                    }
                }
                this.data = null;
            } finally {
                this.building = false;
                this.built = true;
            }
        }
    }

    public String toString() {
        return "Response " + this.builder.toString();
    }
}
