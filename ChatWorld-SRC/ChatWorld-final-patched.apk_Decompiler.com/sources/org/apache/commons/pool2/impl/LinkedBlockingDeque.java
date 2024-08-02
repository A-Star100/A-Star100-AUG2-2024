package org.apache.commons.pool2.impl;

import androidx.appcompat.widget.ActivityChooserView;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

class LinkedBlockingDeque<E> extends AbstractQueue<E> implements Deque<E>, Serializable {
    private static final long serialVersionUID = -387911632671998426L;
    private final int capacity;
    private transient int count;
    /* access modifiers changed from: private */
    public transient Node<E> first;
    /* access modifiers changed from: private */
    public transient Node<E> last;
    /* access modifiers changed from: private */
    public final InterruptibleReentrantLock lock;
    private final Condition notEmpty;
    private final Condition notFull;

    private static final class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(E x, Node<E> p, Node<E> n) {
            this.item = x;
            this.prev = p;
            this.next = n;
        }
    }

    public LinkedBlockingDeque() {
        this((int) ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    public LinkedBlockingDeque(boolean fairness) {
        this(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, fairness);
    }

    public LinkedBlockingDeque(int capacity2) {
        this(capacity2, false);
    }

    public LinkedBlockingDeque(int capacity2, boolean fairness) {
        if (capacity2 > 0) {
            this.capacity = capacity2;
            InterruptibleReentrantLock interruptibleReentrantLock = new InterruptibleReentrantLock(fairness);
            this.lock = interruptibleReentrantLock;
            this.notEmpty = interruptibleReentrantLock.newCondition();
            this.notFull = interruptibleReentrantLock.newCondition();
            return;
        }
        throw new IllegalArgumentException();
    }

    public LinkedBlockingDeque(Collection<? extends E> c) {
        this((int) ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.lock.lock();
        try {
            for (E e : c) {
                if (e == null) {
                    throw new NullPointerException();
                } else if (!linkLast(e)) {
                    throw new IllegalStateException("Deque full");
                }
            }
        } finally {
            this.lock.unlock();
        }
    }

    private boolean linkFirst(E e) {
        if (this.count >= this.capacity) {
            return false;
        }
        Node<E> f = this.first;
        Node<E> x = new Node<>(e, (Node) null, f);
        this.first = x;
        if (this.last == null) {
            this.last = x;
        } else {
            f.prev = x;
        }
        this.count++;
        this.notEmpty.signal();
        return true;
    }

    private boolean linkLast(E e) {
        if (this.count >= this.capacity) {
            return false;
        }
        Node<E> l = this.last;
        Node<E> x = new Node<>(e, l, (Node<E>) null);
        this.last = x;
        if (this.first == null) {
            this.first = x;
        } else {
            l.next = x;
        }
        this.count++;
        this.notEmpty.signal();
        return true;
    }

    private E unlinkFirst() {
        Node<E> f = this.first;
        if (f == null) {
            return null;
        }
        Node<E> n = f.next;
        E item = f.item;
        f.item = null;
        f.next = f;
        this.first = n;
        if (n == null) {
            this.last = null;
        } else {
            n.prev = null;
        }
        this.count--;
        this.notFull.signal();
        return item;
    }

    private E unlinkLast() {
        Node<E> l = this.last;
        if (l == null) {
            return null;
        }
        Node<E> p = l.prev;
        E item = l.item;
        l.item = null;
        l.prev = l;
        this.last = p;
        if (p == null) {
            this.first = null;
        } else {
            p.next = null;
        }
        this.count--;
        this.notFull.signal();
        return item;
    }

    /* access modifiers changed from: private */
    public void unlink(Node<E> x) {
        Node<E> p = x.prev;
        Node<E> n = x.next;
        if (p == null) {
            unlinkFirst();
        } else if (n == null) {
            unlinkLast();
        } else {
            p.next = n;
            n.prev = p;
            x.item = null;
            this.count--;
            this.notFull.signal();
        }
    }

    public void addFirst(E e) {
        if (!offerFirst(e)) {
            throw new IllegalStateException("Deque full");
        }
    }

    public void addLast(E e) {
        if (!offerLast(e)) {
            throw new IllegalStateException("Deque full");
        }
    }

    public boolean offerFirst(E e) {
        if (e != null) {
            this.lock.lock();
            try {
                return linkFirst(e);
            } finally {
                this.lock.unlock();
            }
        } else {
            throw new NullPointerException();
        }
    }

    public boolean offerLast(E e) {
        if (e != null) {
            this.lock.lock();
            try {
                return linkLast(e);
            } finally {
                this.lock.unlock();
            }
        } else {
            throw new NullPointerException();
        }
    }

    public void putFirst(E e) throws InterruptedException {
        if (e != null) {
            this.lock.lock();
            while (!linkFirst(e)) {
                try {
                    this.notFull.await();
                } finally {
                    this.lock.unlock();
                }
            }
            return;
        }
        throw new NullPointerException();
    }

    public void putLast(E e) throws InterruptedException {
        if (e != null) {
            this.lock.lock();
            while (!linkLast(e)) {
                try {
                    this.notFull.await();
                } finally {
                    this.lock.unlock();
                }
            }
            return;
        }
        throw new NullPointerException();
    }

    public boolean offerFirst(E e, long timeout, TimeUnit unit) throws InterruptedException {
        boolean z;
        if (e != null) {
            long nanos = unit.toNanos(timeout);
            this.lock.lockInterruptibly();
            while (true) {
                try {
                    if (linkFirst(e)) {
                        z = true;
                        break;
                    } else if (nanos <= 0) {
                        z = false;
                        break;
                    } else {
                        nanos = this.notFull.awaitNanos(nanos);
                    }
                } finally {
                    this.lock.unlock();
                }
            }
            return z;
        }
        throw new NullPointerException();
    }

    public boolean offerLast(E e, long timeout, TimeUnit unit) throws InterruptedException {
        boolean z;
        if (e != null) {
            long nanos = unit.toNanos(timeout);
            this.lock.lockInterruptibly();
            while (true) {
                try {
                    if (linkLast(e)) {
                        z = true;
                        break;
                    } else if (nanos <= 0) {
                        z = false;
                        break;
                    } else {
                        nanos = this.notFull.awaitNanos(nanos);
                    }
                } finally {
                    this.lock.unlock();
                }
            }
            return z;
        }
        throw new NullPointerException();
    }

    public E removeFirst() {
        E x = pollFirst();
        if (x != null) {
            return x;
        }
        throw new NoSuchElementException();
    }

    public E removeLast() {
        E x = pollLast();
        if (x != null) {
            return x;
        }
        throw new NoSuchElementException();
    }

    public E pollFirst() {
        this.lock.lock();
        try {
            return unlinkFirst();
        } finally {
            this.lock.unlock();
        }
    }

    public E pollLast() {
        this.lock.lock();
        try {
            return unlinkLast();
        } finally {
            this.lock.unlock();
        }
    }

    public E takeFirst() throws InterruptedException {
        this.lock.lock();
        while (true) {
            try {
                E unlinkFirst = unlinkFirst();
                E x = unlinkFirst;
                if (unlinkFirst != null) {
                    return x;
                }
                this.notEmpty.await();
            } finally {
                this.lock.unlock();
            }
        }
    }

    public E takeLast() throws InterruptedException {
        this.lock.lock();
        while (true) {
            try {
                E unlinkLast = unlinkLast();
                E x = unlinkLast;
                if (unlinkLast != null) {
                    return x;
                }
                this.notEmpty.await();
            } finally {
                this.lock.unlock();
            }
        }
    }

    public E pollFirst(long timeout, TimeUnit unit) throws InterruptedException {
        long nanos = unit.toNanos(timeout);
        this.lock.lockInterruptibly();
        while (true) {
            try {
                E unlinkFirst = unlinkFirst();
                E x = unlinkFirst;
                if (unlinkFirst != null) {
                    this.lock.unlock();
                    return x;
                } else if (nanos <= 0) {
                    return null;
                } else {
                    nanos = this.notEmpty.awaitNanos(nanos);
                }
            } finally {
                this.lock.unlock();
            }
        }
    }

    public E pollLast(long timeout, TimeUnit unit) throws InterruptedException {
        long nanos = unit.toNanos(timeout);
        this.lock.lockInterruptibly();
        while (true) {
            try {
                E unlinkLast = unlinkLast();
                E x = unlinkLast;
                if (unlinkLast != null) {
                    this.lock.unlock();
                    return x;
                } else if (nanos <= 0) {
                    return null;
                } else {
                    nanos = this.notEmpty.awaitNanos(nanos);
                }
            } finally {
                this.lock.unlock();
            }
        }
    }

    public E getFirst() {
        E x = peekFirst();
        if (x != null) {
            return x;
        }
        throw new NoSuchElementException();
    }

    public E getLast() {
        E x = peekLast();
        if (x != null) {
            return x;
        }
        throw new NoSuchElementException();
    }

    public E peekFirst() {
        this.lock.lock();
        try {
            Node<E> node = this.first;
            return node == null ? null : node.item;
        } finally {
            this.lock.unlock();
        }
    }

    public E peekLast() {
        this.lock.lock();
        try {
            Node<E> node = this.last;
            return node == null ? null : node.item;
        } finally {
            this.lock.unlock();
        }
    }

    public boolean removeFirstOccurrence(Object o) {
        if (o == null) {
            return false;
        }
        this.lock.lock();
        try {
            for (Node<E> p = this.first; p != null; p = p.next) {
                if (o.equals(p.item)) {
                    unlink(p);
                    return true;
                }
            }
            this.lock.unlock();
            return false;
        } finally {
            this.lock.unlock();
        }
    }

    public boolean removeLastOccurrence(Object o) {
        if (o == null) {
            return false;
        }
        this.lock.lock();
        try {
            for (Node<E> p = this.last; p != null; p = p.prev) {
                if (o.equals(p.item)) {
                    unlink(p);
                    return true;
                }
            }
            this.lock.unlock();
            return false;
        } finally {
            this.lock.unlock();
        }
    }

    public boolean add(E e) {
        addLast(e);
        return true;
    }

    public boolean offer(E e) {
        return offerLast(e);
    }

    public void put(E e) throws InterruptedException {
        putLast(e);
    }

    public boolean offer(E e, long timeout, TimeUnit unit) throws InterruptedException {
        return offerLast(e, timeout, unit);
    }

    public E remove() {
        return removeFirst();
    }

    public E poll() {
        return pollFirst();
    }

    public E take() throws InterruptedException {
        return takeFirst();
    }

    public E poll(long timeout, TimeUnit unit) throws InterruptedException {
        return pollFirst(timeout, unit);
    }

    public E element() {
        return getFirst();
    }

    public E peek() {
        return peekFirst();
    }

    public int remainingCapacity() {
        this.lock.lock();
        try {
            return this.capacity - this.count;
        } finally {
            this.lock.unlock();
        }
    }

    public int drainTo(Collection<? super E> c) {
        return drainTo(c, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    public int drainTo(Collection<? super E> c, int maxElements) {
        if (c == null) {
            throw new NullPointerException();
        } else if (c != this) {
            this.lock.lock();
            try {
                int n = Math.min(maxElements, this.count);
                for (int i = 0; i < n; i++) {
                    c.add(this.first.item);
                    unlinkFirst();
                }
                return n;
            } finally {
                this.lock.unlock();
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void push(E e) {
        addFirst(e);
    }

    public E pop() {
        return removeFirst();
    }

    public boolean remove(Object o) {
        return removeFirstOccurrence(o);
    }

    public int size() {
        this.lock.lock();
        try {
            return this.count;
        } finally {
            this.lock.unlock();
        }
    }

    public boolean contains(Object o) {
        if (o == null) {
            return false;
        }
        this.lock.lock();
        try {
            for (Node<E> p = this.first; p != null; p = p.next) {
                if (o.equals(p.item)) {
                    return true;
                }
            }
            this.lock.unlock();
            return false;
        } finally {
            this.lock.unlock();
        }
    }

    public Object[] toArray() {
        this.lock.lock();
        try {
            Object[] a = new Object[this.count];
            int k = 0;
            Node<E> p = this.first;
            while (p != null) {
                int k2 = k + 1;
                a[k] = p.item;
                p = p.next;
                k = k2;
            }
            return a;
        } finally {
            this.lock.unlock();
        }
    }

    public <T> T[] toArray(T[] a) {
        this.lock.lock();
        try {
            int length = a.length;
            T[] a2 = a;
            if (length < this.count) {
                a2 = (Object[]) Array.newInstance(a.getClass().getComponentType(), this.count);
            }
            int k = 0;
            Node<E> p = this.first;
            while (p != null) {
                a2[k] = p.item;
                p = p.next;
                k++;
            }
            if (a2.length > k) {
                a2[k] = null;
            }
            return a2;
        } finally {
            this.lock.unlock();
        }
    }

    public String toString() {
        this.lock.lock();
        try {
            return super.toString();
        } finally {
            this.lock.unlock();
        }
    }

    public void clear() {
        this.lock.lock();
        try {
            Node<E> f = this.first;
            while (f != null) {
                f.item = null;
                Node<E> n = f.next;
                f.prev = null;
                f.next = null;
                f = n;
            }
            this.last = null;
            this.first = null;
            this.count = 0;
            this.notFull.signalAll();
        } finally {
            this.lock.unlock();
        }
    }

    public Iterator<E> iterator() {
        return new Itr();
    }

    public Iterator<E> descendingIterator() {
        return new DescendingItr();
    }

    private abstract class AbstractItr implements Iterator<E> {
        private Node<E> lastRet;
        Node<E> next;
        E nextItem;

        /* access modifiers changed from: package-private */
        public abstract Node<E> firstNode();

        /* access modifiers changed from: package-private */
        public abstract Node<E> nextNode(Node<E> node);

        AbstractItr() {
            LinkedBlockingDeque.this.lock.lock();
            try {
                Node<E> firstNode = firstNode();
                this.next = firstNode;
                this.nextItem = firstNode == null ? null : firstNode.item;
            } finally {
                LinkedBlockingDeque.this.lock.unlock();
            }
        }

        private Node<E> succ(Node<E> n) {
            while (true) {
                Node<E> s = nextNode(n);
                if (s == null) {
                    return null;
                }
                if (s.item != null) {
                    return s;
                }
                if (s == n) {
                    return firstNode();
                }
                n = s;
            }
        }

        /* access modifiers changed from: package-private */
        public void advance() {
            LinkedBlockingDeque.this.lock.lock();
            try {
                Node<E> succ = succ(this.next);
                this.next = succ;
                this.nextItem = succ == null ? null : succ.item;
            } finally {
                LinkedBlockingDeque.this.lock.unlock();
            }
        }

        public boolean hasNext() {
            return this.next != null;
        }

        public E next() {
            Node<E> node = this.next;
            if (node != null) {
                this.lastRet = node;
                E x = this.nextItem;
                advance();
                return x;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            Node<E> n = this.lastRet;
            if (n != null) {
                this.lastRet = null;
                LinkedBlockingDeque.this.lock.lock();
                try {
                    if (n.item != null) {
                        LinkedBlockingDeque.this.unlink(n);
                    }
                } finally {
                    LinkedBlockingDeque.this.lock.unlock();
                }
            } else {
                throw new IllegalStateException();
            }
        }
    }

    private class Itr extends LinkedBlockingDeque<E>.AbstractItr {
        private Itr() {
            super();
        }

        /* access modifiers changed from: package-private */
        public Node<E> firstNode() {
            return LinkedBlockingDeque.this.first;
        }

        /* access modifiers changed from: package-private */
        public Node<E> nextNode(Node<E> n) {
            return n.next;
        }
    }

    private class DescendingItr extends LinkedBlockingDeque<E>.AbstractItr {
        private DescendingItr() {
            super();
        }

        /* access modifiers changed from: package-private */
        public Node<E> firstNode() {
            return LinkedBlockingDeque.this.last;
        }

        /* access modifiers changed from: package-private */
        public Node<E> nextNode(Node<E> n) {
            return n.prev;
        }
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        this.lock.lock();
        try {
            s.defaultWriteObject();
            for (Node<E> p = this.first; p != null; p = p.next) {
                s.writeObject(p.item);
            }
            s.writeObject((Object) null);
        } finally {
            this.lock.unlock();
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.count = 0;
        this.first = null;
        this.last = null;
        while (true) {
            E item = s.readObject();
            if (item != null) {
                add(item);
            } else {
                return;
            }
        }
    }

    public boolean hasTakeWaiters() {
        this.lock.lock();
        try {
            return this.lock.hasWaiters(this.notEmpty);
        } finally {
            this.lock.unlock();
        }
    }

    public int getTakeQueueLength() {
        this.lock.lock();
        try {
            return this.lock.getWaitQueueLength(this.notEmpty);
        } finally {
            this.lock.unlock();
        }
    }

    public void interuptTakeWaiters() {
        this.lock.lock();
        try {
            this.lock.interruptWaiters(this.notEmpty);
        } finally {
            this.lock.unlock();
        }
    }
}
