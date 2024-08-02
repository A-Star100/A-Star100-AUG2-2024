package org.apache.commons.pool2.impl;

import java.io.PrintWriter;

public class AbandonedConfig {
    private boolean logAbandoned = false;
    private PrintWriter logWriter = new PrintWriter(System.out);
    private boolean removeAbandonedOnBorrow = false;
    private boolean removeAbandonedOnMaintenance = false;
    private int removeAbandonedTimeout = 300;
    private boolean useUsageTracking = false;

    public boolean getRemoveAbandonedOnBorrow() {
        return this.removeAbandonedOnBorrow;
    }

    public void setRemoveAbandonedOnBorrow(boolean removeAbandonedOnBorrow2) {
        this.removeAbandonedOnBorrow = removeAbandonedOnBorrow2;
    }

    public boolean getRemoveAbandonedOnMaintenance() {
        return this.removeAbandonedOnMaintenance;
    }

    public void setRemoveAbandonedOnMaintenance(boolean removeAbandonedOnMaintenance2) {
        this.removeAbandonedOnMaintenance = removeAbandonedOnMaintenance2;
    }

    public int getRemoveAbandonedTimeout() {
        return this.removeAbandonedTimeout;
    }

    public void setRemoveAbandonedTimeout(int removeAbandonedTimeout2) {
        this.removeAbandonedTimeout = removeAbandonedTimeout2;
    }

    public boolean getLogAbandoned() {
        return this.logAbandoned;
    }

    public void setLogAbandoned(boolean logAbandoned2) {
        this.logAbandoned = logAbandoned2;
    }

    public PrintWriter getLogWriter() {
        return this.logWriter;
    }

    public void setLogWriter(PrintWriter logWriter2) {
        this.logWriter = logWriter2;
    }

    public boolean getUseUsageTracking() {
        return this.useUsageTracking;
    }

    public void setUseUsageTracking(boolean useUsageTracking2) {
        this.useUsageTracking = useUsageTracking2;
    }
}
