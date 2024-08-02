package org.apache.commons.pool2.impl;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Timer;
import java.util.TimerTask;

class EvictionTimer {
    private static Timer _timer;
    private static int _usageCount;

    private EvictionTimer() {
    }

    /* JADX INFO: finally extract failed */
    static synchronized void schedule(TimerTask task, long delay, long period) {
        Class<EvictionTimer> cls = EvictionTimer.class;
        synchronized (cls) {
            if (_timer == null) {
                ClassLoader ccl = (ClassLoader) AccessController.doPrivileged(new PrivilegedGetTccl());
                try {
                    AccessController.doPrivileged(new PrivilegedSetTccl(cls.getClassLoader()));
                    _timer = (Timer) AccessController.doPrivileged(new PrivilegedNewEvictionTimer());
                    AccessController.doPrivileged(new PrivilegedSetTccl(ccl));
                } catch (Throwable th) {
                    AccessController.doPrivileged(new PrivilegedSetTccl(ccl));
                    throw th;
                }
            }
            _usageCount++;
            _timer.schedule(task, delay, period);
        }
    }

    static synchronized void cancel(TimerTask task) {
        synchronized (EvictionTimer.class) {
            task.cancel();
            int i = _usageCount - 1;
            _usageCount = i;
            if (i == 0) {
                _timer.cancel();
                _timer = null;
            }
        }
    }

    private static class PrivilegedGetTccl implements PrivilegedAction<ClassLoader> {
        private PrivilegedGetTccl() {
        }

        public ClassLoader run() {
            return Thread.currentThread().getContextClassLoader();
        }
    }

    private static class PrivilegedSetTccl implements PrivilegedAction<Void> {
        private final ClassLoader cl;

        PrivilegedSetTccl(ClassLoader cl2) {
            this.cl = cl2;
        }

        public Void run() {
            Thread.currentThread().setContextClassLoader(this.cl);
            return null;
        }
    }

    private static class PrivilegedNewEvictionTimer implements PrivilegedAction<Timer> {
        private PrivilegedNewEvictionTimer() {
        }

        public Timer run() {
            return new Timer("commons-pool-EvictionTimer", true);
        }
    }
}
