package redis.clients.jedis;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import redis.clients.jedis.exceptions.JedisDataException;

public class Pipeline extends MultiKeyPipelineBase implements Closeable {
    private MultiResponseBuilder currentMulti;

    private class MultiResponseBuilder extends Builder<List<Object>> {
        private List<Response<?>> responses;

        private MultiResponseBuilder() {
            this.responses = new ArrayList();
        }

        /* synthetic */ MultiResponseBuilder(Pipeline pipeline, MultiResponseBuilder multiResponseBuilder) {
            this();
        }

        public List<Object> build(Object data) {
            List<Object> list = (List) data;
            List<Object> values = new ArrayList<>();
            if (list.size() == this.responses.size()) {
                for (int i = 0; i < list.size(); i++) {
                    Response<?> response = this.responses.get(i);
                    response.set(list.get(i));
                    try {
                        e = response.get();
                    } catch (JedisDataException e) {
                        e = e;
                        Object obj = e;
                    }
                    values.add(e);
                }
                return values;
            }
            throw new JedisDataException("Expected data size " + this.responses.size() + " but was " + list.size());
        }

        public void setResponseDependency(Response<?> dependency) {
            for (Response<?> response : this.responses) {
                response.setDependency(dependency);
            }
        }

        public void addResponse(Response<?> response) {
            this.responses.add(response);
        }
    }

    /* access modifiers changed from: protected */
    public <T> Response<T> getResponse(Builder<T> builder) {
        if (this.currentMulti == null) {
            return super.getResponse(builder);
        }
        super.getResponse(BuilderFactory.STRING);
        Response<T> lr = new Response<>(builder);
        this.currentMulti.addResponse(lr);
        return lr;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    /* access modifiers changed from: protected */
    public Client getClient(byte[] key) {
        return this.client;
    }

    /* access modifiers changed from: protected */
    public Client getClient(String key) {
        return this.client;
    }

    public void clear() {
        if (isInMulti()) {
            discard();
        }
        sync();
    }

    public boolean isInMulti() {
        return this.currentMulti != null;
    }

    public void sync() {
        if (getPipelinedResponseLength() > 0) {
            for (Object o : this.client.getMany(getPipelinedResponseLength())) {
                generateResponse(o);
            }
        }
    }

    public List<Object> syncAndReturnAll() {
        if (getPipelinedResponseLength() <= 0) {
            return Collections.emptyList();
        }
        List<Object> unformatted = this.client.getMany(getPipelinedResponseLength());
        List<Object> formatted = new ArrayList<>();
        for (Object o : unformatted) {
            try {
                formatted.add(generateResponse(o).get());
            } catch (JedisDataException e) {
                formatted.add(e);
            }
        }
        return formatted;
    }

    public Response<String> discard() {
        if (this.currentMulti != null) {
            this.client.discard();
            this.currentMulti = null;
            return getResponse(BuilderFactory.STRING);
        }
        throw new JedisDataException("DISCARD without MULTI");
    }

    public Response<List<Object>> exec() {
        if (this.currentMulti != null) {
            this.client.exec();
            Response<List<Object>> response = super.getResponse(this.currentMulti);
            this.currentMulti.setResponseDependency(response);
            this.currentMulti = null;
            return response;
        }
        throw new JedisDataException("EXEC without MULTI");
    }

    public Response<String> multi() {
        if (this.currentMulti == null) {
            this.client.multi();
            Response<String> response = getResponse(BuilderFactory.STRING);
            this.currentMulti = new MultiResponseBuilder(this, (MultiResponseBuilder) null);
            return response;
        }
        throw new JedisDataException("MULTI calls can not be nested");
    }

    public void close() {
        clear();
    }
}
