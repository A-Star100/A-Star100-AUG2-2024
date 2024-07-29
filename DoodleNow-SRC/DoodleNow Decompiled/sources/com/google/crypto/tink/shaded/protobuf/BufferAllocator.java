package com.google.crypto.tink.shaded.protobuf;

import java.nio.ByteBuffer;

@CheckReturnValue
abstract class BufferAllocator {
    private static final BufferAllocator UNPOOLED = new BufferAllocator() {
        public AllocatedBuffer allocateHeapBuffer(int i) {
            return AllocatedBuffer.wrap(new byte[i]);
        }

        public AllocatedBuffer allocateDirectBuffer(int i) {
            return AllocatedBuffer.wrap(ByteBuffer.allocateDirect(i));
        }
    };

    public static BufferAllocator unpooled() {
        return UNPOOLED;
    }

    public abstract AllocatedBuffer allocateDirectBuffer(int i);

    public abstract AllocatedBuffer allocateHeapBuffer(int i);

    BufferAllocator() {
    }
}
