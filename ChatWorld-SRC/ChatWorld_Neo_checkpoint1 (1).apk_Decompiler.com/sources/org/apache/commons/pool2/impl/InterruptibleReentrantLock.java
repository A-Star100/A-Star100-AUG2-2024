package org.apache.commons.pool2.impl;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class InterruptibleReentrantLock extends ReentrantLock {
    private static final long serialVersionUID = 1;

    public InterruptibleReentrantLock(boolean fairness) {
        super(fairness);
    }

    public void interruptWaiters(Condition condition) {
        for (Thread thread : getWaitingThreads(condition)) {
            thread.interrupt();
        }
    }
}
