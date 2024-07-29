package com.jakewharton.rxrelay2;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.disposables.Disposable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ReplayRelay<T> extends Relay<T> {
    static final ReplayDisposable[] EMPTY = new ReplayDisposable[0];
    private static final Object[] EMPTY_ARRAY = new Object[0];
    final ReplayBuffer<T> buffer;
    final AtomicReference<ReplayDisposable<T>[]> observers = new AtomicReference<>(EMPTY);

    interface ReplayBuffer<T> {
        void add(T t);

        T getValue();

        T[] getValues(T[] tArr);

        void replay(ReplayDisposable<T> replayDisposable);

        int size();

        void trimHead();
    }

    @CheckReturnValue
    public static <T> ReplayRelay<T> create() {
        return new ReplayRelay<>(new UnboundedReplayBuffer(16));
    }

    @CheckReturnValue
    public static <T> ReplayRelay<T> create(int i) {
        return new ReplayRelay<>(new UnboundedReplayBuffer(i));
    }

    @CheckReturnValue
    public static <T> ReplayRelay<T> createWithSize(int i) {
        return new ReplayRelay<>(new SizeBoundReplayBuffer(i));
    }

    static <T> ReplayRelay<T> createUnbounded() {
        return new ReplayRelay<>(new SizeBoundReplayBuffer(Integer.MAX_VALUE));
    }

    @CheckReturnValue
    public static <T> ReplayRelay<T> createWithTime(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return new ReplayRelay<>(new SizeAndTimeBoundReplayBuffer(Integer.MAX_VALUE, j, timeUnit, scheduler));
    }

    @CheckReturnValue
    public static <T> ReplayRelay<T> createWithTimeAndSize(long j, TimeUnit timeUnit, Scheduler scheduler, int i) {
        return new ReplayRelay<>(new SizeAndTimeBoundReplayBuffer(i, j, timeUnit, scheduler));
    }

    ReplayRelay(ReplayBuffer<T> replayBuffer) {
        this.buffer = replayBuffer;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super T> observer) {
        ReplayDisposable replayDisposable = new ReplayDisposable(observer, this);
        observer.onSubscribe(replayDisposable);
        if (replayDisposable.cancelled) {
            return;
        }
        if (!add(replayDisposable) || !replayDisposable.cancelled) {
            this.buffer.replay(replayDisposable);
        } else {
            remove(replayDisposable);
        }
    }

    public void accept(T t) {
        if (t != null) {
            ReplayBuffer<T> replayBuffer = this.buffer;
            replayBuffer.add(t);
            for (ReplayDisposable replay : (ReplayDisposable[]) this.observers.get()) {
                replayBuffer.replay(replay);
            }
            return;
        }
        throw new NullPointerException("value == null");
    }

    public boolean hasObservers() {
        return ((ReplayDisposable[]) this.observers.get()).length != 0;
    }

    /* access modifiers changed from: package-private */
    public int observerCount() {
        return ((ReplayDisposable[]) this.observers.get()).length;
    }

    public T getValue() {
        return this.buffer.getValue();
    }

    public void cleanupBuffer() {
        this.buffer.trimHead();
    }

    public Object[] getValues() {
        Object[] objArr = EMPTY_ARRAY;
        Object[] values = getValues(objArr);
        return values == objArr ? new Object[0] : values;
    }

    public T[] getValues(T[] tArr) {
        return this.buffer.getValues(tArr);
    }

    public boolean hasValue() {
        return this.buffer.size() != 0;
    }

    /* access modifiers changed from: package-private */
    public int size() {
        return this.buffer.size();
    }

    /* access modifiers changed from: package-private */
    public boolean add(ReplayDisposable<T> replayDisposable) {
        ReplayDisposable[] replayDisposableArr;
        ReplayDisposable[] replayDisposableArr2;
        do {
            replayDisposableArr = (ReplayDisposable[]) this.observers.get();
            int length = replayDisposableArr.length;
            replayDisposableArr2 = new ReplayDisposable[(length + 1)];
            System.arraycopy(replayDisposableArr, 0, replayDisposableArr2, 0, length);
            replayDisposableArr2[length] = replayDisposable;
        } while (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.observers, replayDisposableArr, replayDisposableArr2));
        return true;
    }

    /* access modifiers changed from: package-private */
    public void remove(ReplayDisposable<T> replayDisposable) {
        ReplayDisposable<T>[] replayDisposableArr;
        ReplayDisposable[] replayDisposableArr2;
        do {
            replayDisposableArr = (ReplayDisposable[]) this.observers.get();
            if (replayDisposableArr != EMPTY) {
                int length = replayDisposableArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        i = -1;
                        break;
                    } else if (replayDisposableArr[i] == replayDisposable) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        replayDisposableArr2 = EMPTY;
                    } else {
                        ReplayDisposable[] replayDisposableArr3 = new ReplayDisposable[(length - 1)];
                        System.arraycopy(replayDisposableArr, 0, replayDisposableArr3, 0, i);
                        System.arraycopy(replayDisposableArr, i + 1, replayDisposableArr3, i, (length - i) - 1);
                        replayDisposableArr2 = replayDisposableArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.observers, replayDisposableArr, replayDisposableArr2));
    }

    static final class ReplayDisposable<T> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = 466549804534799122L;
        volatile boolean cancelled;
        final Observer<? super T> downstream;
        Object index;
        final ReplayRelay<T> state;

        public boolean isDisposed() {
            return this.cancelled;
        }

        ReplayDisposable(Observer<? super T> observer, ReplayRelay<T> replayRelay) {
            this.downstream = observer;
            this.state = replayRelay;
        }

        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.state.remove(this);
            }
        }
    }

    static final class UnboundedReplayBuffer<T> extends AtomicReference<Object> implements ReplayBuffer<T> {
        private static final long serialVersionUID = -733876083048047795L;
        final List<T> buffer;
        volatile int size;

        public int size() {
            return this.size;
        }

        public void trimHead() {
        }

        UnboundedReplayBuffer(int i) {
            if (i > 0) {
                this.buffer = new ArrayList(i);
                return;
            }
            throw new IllegalArgumentException("capacityHint <= 0");
        }

        public void add(T t) {
            this.buffer.add(t);
            this.size++;
        }

        public T getValue() {
            int i = this.size;
            if (i != 0) {
                return this.buffer.get(i - 1);
            }
            return null;
        }

        public T[] getValues(T[] tArr) {
            int i = this.size;
            if (i == 0) {
                if (tArr.length != 0) {
                    tArr[0] = null;
                }
                return tArr;
            }
            if (tArr.length < i) {
                tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), i);
            }
            List<T> list = this.buffer;
            for (int i2 = 0; i2 < i; i2++) {
                tArr[i2] = list.get(i2);
            }
            if (tArr.length > i) {
                tArr[i] = null;
            }
            return tArr;
        }

        public void replay(ReplayDisposable<T> replayDisposable) {
            int i;
            if (replayDisposable.getAndIncrement() == 0) {
                List<T> list = this.buffer;
                Observer<? super T> observer = replayDisposable.downstream;
                Integer num = (Integer) replayDisposable.index;
                int i2 = 1;
                if (num != null) {
                    i = num.intValue();
                } else {
                    i = 0;
                    replayDisposable.index = 0;
                }
                while (!replayDisposable.cancelled) {
                    int i3 = this.size;
                    while (i3 != i) {
                        if (replayDisposable.cancelled) {
                            replayDisposable.index = null;
                            return;
                        } else {
                            observer.onNext(list.get(i));
                            i++;
                        }
                    }
                    if (i == this.size) {
                        replayDisposable.index = Integer.valueOf(i);
                        i2 = replayDisposable.addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    }
                }
                replayDisposable.index = null;
            }
        }
    }

    static final class Node<T> extends AtomicReference<Node<T>> {
        private static final long serialVersionUID = 6404226426336033100L;
        final T value;

        Node(T t) {
            this.value = t;
        }
    }

    static final class TimedNode<T> extends AtomicReference<TimedNode<T>> {
        private static final long serialVersionUID = 6404226426336033100L;
        final long time;
        final T value;

        TimedNode(T t, long j) {
            this.value = t;
            this.time = j;
        }
    }

    static final class SizeBoundReplayBuffer<T> extends AtomicReference<Object> implements ReplayBuffer<T> {
        private static final long serialVersionUID = 1107649250281456395L;
        volatile Node<T> head;
        final int maxSize;
        int size;
        Node<T> tail;

        SizeBoundReplayBuffer(int i) {
            if (i > 0) {
                this.maxSize = i;
                Node<T> node = new Node<>(null);
                this.tail = node;
                this.head = node;
                return;
            }
            throw new IllegalArgumentException("maxSize > 0 required but it was " + i);
        }

        /* access modifiers changed from: package-private */
        public void trim() {
            int i = this.size;
            if (i > this.maxSize) {
                this.size = i - 1;
                this.head = (Node) this.head.get();
            }
        }

        public void add(T t) {
            Node<T> node = new Node<>(t);
            Node<T> node2 = this.tail;
            this.tail = node;
            this.size++;
            node2.set(node);
            trim();
        }

        public void trimHead() {
            Node<T> node = this.head;
            if (node.value != null) {
                Node<T> node2 = new Node<>(null);
                node2.lazySet(node.get());
                this.head = node2;
            }
        }

        public T getValue() {
            Node<T> node = this.head;
            while (true) {
                Node<T> node2 = (Node) node.get();
                if (node2 == null) {
                    return node.value;
                }
                node = node2;
            }
        }

        public T[] getValues(T[] tArr) {
            Node<T> node = this.head;
            int size2 = size();
            if (size2 != 0) {
                if (tArr.length < size2) {
                    tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), size2);
                }
                for (int i = 0; i != size2; i++) {
                    node = (Node) node.get();
                    tArr[i] = node.value;
                }
                if (tArr.length > size2) {
                    tArr[size2] = null;
                }
            } else if (tArr.length != 0) {
                tArr[0] = null;
            }
            return tArr;
        }

        public void replay(ReplayDisposable<T> replayDisposable) {
            if (replayDisposable.getAndIncrement() == 0) {
                Observer<? super T> observer = replayDisposable.downstream;
                Node<T> node = (Node) replayDisposable.index;
                int i = 1;
                if (node == null) {
                    node = this.head;
                }
                while (!replayDisposable.cancelled) {
                    Node<T> node2 = (Node) node.get();
                    if (node2 != null) {
                        observer.onNext(node2.value);
                        node = node2;
                    } else if (node.get() != null) {
                        continue;
                    } else {
                        replayDisposable.index = node;
                        i = replayDisposable.addAndGet(-i);
                        if (i == 0) {
                            return;
                        }
                    }
                }
                replayDisposable.index = null;
            }
        }

        public int size() {
            Node<T> node = this.head;
            int i = 0;
            while (i != Integer.MAX_VALUE && (node = (Node) node.get()) != null) {
                i++;
            }
            return i;
        }
    }

    static final class SizeAndTimeBoundReplayBuffer<T> extends AtomicReference<Object> implements ReplayBuffer<T> {
        private static final long serialVersionUID = -8056260896137901749L;
        volatile TimedNode<T> head;
        final long maxAge;
        final int maxSize;
        final Scheduler scheduler;
        int size;
        TimedNode<T> tail;
        final TimeUnit unit;

        SizeAndTimeBoundReplayBuffer(int i, long j, TimeUnit timeUnit, Scheduler scheduler2) {
            if (i <= 0) {
                throw new IllegalArgumentException("maxSize > 0 required but it was " + i);
            } else if (j <= 0) {
                throw new IllegalArgumentException("maxAge > 0 required but it was " + j);
            } else if (timeUnit == null) {
                throw new NullPointerException("unit == null");
            } else if (scheduler2 != null) {
                this.maxSize = i;
                this.maxAge = j;
                this.unit = timeUnit;
                this.scheduler = scheduler2;
                TimedNode<T> timedNode = new TimedNode<>(null, 0);
                this.tail = timedNode;
                this.head = timedNode;
            } else {
                throw new NullPointerException("scheduler == null");
            }
        }

        /* access modifiers changed from: package-private */
        public void trim() {
            int i = this.size;
            if (i > this.maxSize) {
                this.size = i - 1;
                this.head = (TimedNode) this.head.get();
            }
            long now = this.scheduler.now(this.unit) - this.maxAge;
            TimedNode<T> timedNode = this.head;
            while (this.size > 1) {
                TimedNode<T> timedNode2 = (TimedNode) timedNode.get();
                if (timedNode2 == null) {
                    this.head = timedNode;
                    return;
                } else if (timedNode2.time > now) {
                    this.head = timedNode;
                    return;
                } else {
                    this.size--;
                    timedNode = timedNode2;
                }
            }
            this.head = timedNode;
        }

        public void add(T t) {
            TimedNode<T> timedNode = new TimedNode<>(t, this.scheduler.now(this.unit));
            TimedNode<T> timedNode2 = this.tail;
            this.tail = timedNode;
            this.size++;
            timedNode2.set(timedNode);
            trim();
        }

        public void trimHead() {
            TimedNode<T> timedNode = this.head;
            if (timedNode.value != null) {
                TimedNode<T> timedNode2 = new TimedNode<>(null, 0);
                timedNode2.lazySet(timedNode.get());
                this.head = timedNode2;
            }
        }

        public T getValue() {
            TimedNode<T> timedNode = this.head;
            while (true) {
                TimedNode<T> timedNode2 = (TimedNode) timedNode.get();
                if (timedNode2 == null) {
                    break;
                }
                timedNode = timedNode2;
            }
            if (timedNode.time < this.scheduler.now(this.unit) - this.maxAge) {
                return null;
            }
            return timedNode.value;
        }

        /* access modifiers changed from: package-private */
        public TimedNode<T> getHead() {
            TimedNode<T> timedNode;
            TimedNode<T> timedNode2 = this.head;
            long now = this.scheduler.now(this.unit) - this.maxAge;
            Object obj = timedNode2.get();
            while (true) {
                TimedNode<T> timedNode3 = (TimedNode) obj;
                timedNode = timedNode2;
                timedNode2 = timedNode3;
                if (timedNode2 == null || timedNode2.time > now) {
                    return timedNode;
                }
                obj = timedNode2.get();
            }
            return timedNode;
        }

        public T[] getValues(T[] tArr) {
            TimedNode head2 = getHead();
            int size2 = size(head2);
            if (size2 != 0) {
                if (tArr.length < size2) {
                    tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), size2);
                }
                for (int i = 0; i != size2; i++) {
                    head2 = (TimedNode) head2.get();
                    tArr[i] = head2.value;
                }
                if (tArr.length > size2) {
                    tArr[size2] = null;
                }
            } else if (tArr.length != 0) {
                tArr[0] = null;
            }
            return tArr;
        }

        public void replay(ReplayDisposable<T> replayDisposable) {
            if (replayDisposable.getAndIncrement() == 0) {
                Observer<? super T> observer = replayDisposable.downstream;
                TimedNode timedNode = (TimedNode) replayDisposable.index;
                int i = 1;
                if (timedNode == null) {
                    timedNode = getHead();
                }
                while (!replayDisposable.cancelled) {
                    while (!replayDisposable.cancelled) {
                        TimedNode timedNode2 = (TimedNode) timedNode.get();
                        if (timedNode2 != null) {
                            observer.onNext(timedNode2.value);
                            timedNode = timedNode2;
                        } else if (timedNode.get() == null) {
                            replayDisposable.index = timedNode;
                            i = replayDisposable.addAndGet(-i);
                            if (i == 0) {
                                return;
                            }
                        }
                    }
                    replayDisposable.index = null;
                    return;
                }
                replayDisposable.index = null;
            }
        }

        public int size() {
            return size(getHead());
        }

        /* access modifiers changed from: package-private */
        public int size(TimedNode<T> timedNode) {
            int i = 0;
            while (i != Integer.MAX_VALUE && (timedNode = (TimedNode) timedNode.get()) != null) {
                i++;
            }
            return i;
        }
    }
}
