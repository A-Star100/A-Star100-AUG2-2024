package redis.clients.jedis;

import java.util.LinkedList;
import java.util.Queue;

public class Queable {
    private Queue<Response<?>> pipelinedResponses = new LinkedList();

    /* access modifiers changed from: protected */
    public void clean() {
        this.pipelinedResponses.clear();
    }

    /* access modifiers changed from: protected */
    public Response<?> generateResponse(Object data) {
        Response<?> response = this.pipelinedResponses.poll();
        if (response != null) {
            response.set(data);
        }
        return response;
    }

    /* access modifiers changed from: protected */
    public <T> Response<T> getResponse(Builder<T> builder) {
        Response<T> lr = new Response<>(builder);
        this.pipelinedResponses.add(lr);
        return lr;
    }

    /* access modifiers changed from: protected */
    public boolean hasPipelinedResponse() {
        return !this.pipelinedResponses.isEmpty();
    }

    /* access modifiers changed from: protected */
    public int getPipelinedResponseLength() {
        return this.pipelinedResponses.size();
    }
}
