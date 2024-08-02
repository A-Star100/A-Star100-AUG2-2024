package redis.clients.jedis;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;
import redis.clients.jedis.exceptions.JedisDataException;

public class Transaction extends MultiKeyPipelineBase implements Closeable {
    protected boolean inTransaction = true;

    protected Transaction() {
    }

    public Transaction(Client client) {
        this.client = client;
    }

    /* access modifiers changed from: protected */
    public Client getClient(String key) {
        return this.client;
    }

    /* access modifiers changed from: protected */
    public Client getClient(byte[] key) {
        return this.client;
    }

    public void clear() {
        if (this.inTransaction) {
            discard();
        }
    }

    public List<Object> exec() {
        this.client.getMany(getPipelinedResponseLength());
        this.client.exec();
        this.inTransaction = false;
        List<Object> unformatted = this.client.getObjectMultiBulkReply();
        if (unformatted == null) {
            return null;
        }
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

    public List<Response<?>> execGetResponse() {
        this.client.getMany(getPipelinedResponseLength());
        this.client.exec();
        this.inTransaction = false;
        List<Object> unformatted = this.client.getObjectMultiBulkReply();
        if (unformatted == null) {
            return null;
        }
        List<Response<?>> response = new ArrayList<>();
        for (Object o : unformatted) {
            response.add(generateResponse(o));
        }
        return response;
    }

    public String discard() {
        this.client.getMany(getPipelinedResponseLength());
        this.client.discard();
        this.inTransaction = false;
        clean();
        return this.client.getStatusCodeReply();
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void close() {
        clear();
    }
}
