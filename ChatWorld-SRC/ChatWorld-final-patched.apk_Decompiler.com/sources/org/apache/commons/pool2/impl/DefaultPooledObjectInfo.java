package org.apache.commons.pool2.impl;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import org.apache.commons.pool2.PooledObject;

public class DefaultPooledObjectInfo implements DefaultPooledObjectInfoMBean {
    private final PooledObject<?> pooledObject;

    public DefaultPooledObjectInfo(PooledObject<?> pooledObject2) {
        this.pooledObject = pooledObject2;
    }

    public long getCreateTime() {
        return this.pooledObject.getCreateTime();
    }

    public String getCreateTimeFormatted() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z").format(Long.valueOf(this.pooledObject.getCreateTime()));
    }

    public long getLastBorrowTime() {
        return this.pooledObject.getLastBorrowTime();
    }

    public String getLastBorrowTimeFormatted() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z").format(Long.valueOf(this.pooledObject.getLastBorrowTime()));
    }

    public String getLastBorrowTrace() {
        StringWriter sw = new StringWriter();
        this.pooledObject.printStackTrace(new PrintWriter(sw));
        return sw.toString();
    }

    public long getLastReturnTime() {
        return this.pooledObject.getLastReturnTime();
    }

    public String getLastReturnTimeFormatted() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z").format(Long.valueOf(this.pooledObject.getLastReturnTime()));
    }

    public String getPooledObjectType() {
        return this.pooledObject.getObject().getClass().getName();
    }

    public String getPooledObjectToString() {
        return this.pooledObject.getObject().toString();
    }

    public long getBorrowedCount() {
        PooledObject<?> pooledObject2 = this.pooledObject;
        if (pooledObject2 instanceof DefaultPooledObject) {
            return ((DefaultPooledObject) pooledObject2).getBorrowedCount();
        }
        return -1;
    }
}
