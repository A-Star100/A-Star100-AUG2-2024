package org.apache.commons.pool2.impl;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Deque;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectState;
import org.apache.commons.pool2.TrackedUse;

public class DefaultPooledObject<T> implements PooledObject<T> {
    private volatile Exception borrowedBy;
    private volatile long borrowedCount;
    private final long createTime;
    private volatile long lastBorrowTime;
    private volatile long lastReturnTime;
    private volatile long lastUseTime;
    private volatile boolean logAbandoned;
    private final T object;
    private PooledObjectState state = PooledObjectState.IDLE;
    private volatile Exception usedBy;

    public DefaultPooledObject(T object2) {
        long currentTimeMillis = System.currentTimeMillis();
        this.createTime = currentTimeMillis;
        this.lastBorrowTime = currentTimeMillis;
        this.lastUseTime = currentTimeMillis;
        this.lastReturnTime = currentTimeMillis;
        this.logAbandoned = false;
        this.borrowedBy = null;
        this.usedBy = null;
        this.borrowedCount = 0;
        this.object = object2;
    }

    public T getObject() {
        return this.object;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public long getActiveTimeMillis() {
        long rTime = this.lastReturnTime;
        long bTime = this.lastBorrowTime;
        if (rTime > bTime) {
            return rTime - bTime;
        }
        return System.currentTimeMillis() - bTime;
    }

    public long getIdleTimeMillis() {
        long elapsed = System.currentTimeMillis() - this.lastReturnTime;
        if (elapsed >= 0) {
            return elapsed;
        }
        return 0;
    }

    public long getLastBorrowTime() {
        return this.lastBorrowTime;
    }

    public long getLastReturnTime() {
        return this.lastReturnTime;
    }

    public long getBorrowedCount() {
        return this.borrowedCount;
    }

    public long getLastUsedTime() {
        T t = this.object;
        if (t instanceof TrackedUse) {
            return Math.max(((TrackedUse) t).getLastUsed(), this.lastUseTime);
        }
        return this.lastUseTime;
    }

    public int compareTo(PooledObject<T> other) {
        long lastActiveDiff = getLastReturnTime() - other.getLastReturnTime();
        if (lastActiveDiff == 0) {
            return System.identityHashCode(this) - System.identityHashCode(other);
        }
        return (int) Math.min(Math.max(lastActiveDiff, -2147483648L), 2147483647L);
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Object: ");
        result.append(this.object.toString());
        result.append(", State: ");
        synchronized (this) {
            result.append(this.state.toString());
        }
        return result.toString();
    }

    public synchronized boolean startEvictionTest() {
        if (this.state != PooledObjectState.IDLE) {
            return false;
        }
        this.state = PooledObjectState.EVICTION;
        return true;
    }

    public synchronized boolean endEvictionTest(Deque<PooledObject<T>> idleQueue) {
        if (this.state == PooledObjectState.EVICTION) {
            this.state = PooledObjectState.IDLE;
            return true;
        }
        if (this.state == PooledObjectState.EVICTION_RETURN_TO_HEAD) {
            this.state = PooledObjectState.IDLE;
            idleQueue.offerFirst(this);
        }
        return false;
    }

    public synchronized boolean allocate() {
        if (this.state == PooledObjectState.IDLE) {
            this.state = PooledObjectState.ALLOCATED;
            this.lastBorrowTime = System.currentTimeMillis();
            this.lastUseTime = this.lastBorrowTime;
            this.borrowedCount++;
            if (this.logAbandoned) {
                this.borrowedBy = new AbandonedObjectCreatedException();
            }
            return true;
        } else if (this.state != PooledObjectState.EVICTION) {
            return false;
        } else {
            this.state = PooledObjectState.EVICTION_RETURN_TO_HEAD;
            return false;
        }
    }

    public synchronized boolean deallocate() {
        if (this.state != PooledObjectState.ALLOCATED && this.state != PooledObjectState.RETURNING) {
            return false;
        }
        this.state = PooledObjectState.IDLE;
        this.lastReturnTime = System.currentTimeMillis();
        this.borrowedBy = null;
        return true;
    }

    public synchronized void invalidate() {
        this.state = PooledObjectState.INVALID;
    }

    public void use() {
        this.lastUseTime = System.currentTimeMillis();
        this.usedBy = new Exception("The last code to use this object was:");
    }

    public void printStackTrace(PrintWriter writer) {
        boolean written = false;
        Exception borrowedByCopy = this.borrowedBy;
        if (borrowedByCopy != null) {
            borrowedByCopy.printStackTrace(writer);
            written = true;
        }
        Exception usedByCopy = this.usedBy;
        if (usedByCopy != null) {
            usedByCopy.printStackTrace(writer);
            written = true;
        }
        if (written) {
            writer.flush();
        }
    }

    public synchronized PooledObjectState getState() {
        return this.state;
    }

    public synchronized void markAbandoned() {
        this.state = PooledObjectState.ABANDONED;
    }

    public synchronized void markReturning() {
        this.state = PooledObjectState.RETURNING;
    }

    public void setLogAbandoned(boolean logAbandoned2) {
        this.logAbandoned = logAbandoned2;
    }

    static class AbandonedObjectCreatedException extends Exception {
        private static final SimpleDateFormat format = new SimpleDateFormat("'Pooled object created' yyyy-MM-dd HH:mm:ss Z 'by the following code has not been returned to the pool:'");
        private static final long serialVersionUID = 7398692158058772916L;
        private final long _createdTime = System.currentTimeMillis();

        public String getMessage() {
            SimpleDateFormat simpleDateFormat = format;
            synchronized (simpleDateFormat) {
                try {
                    String msg = simpleDateFormat.format(new Date(this._createdTime));
                    return msg;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            }
        }
    }
}
