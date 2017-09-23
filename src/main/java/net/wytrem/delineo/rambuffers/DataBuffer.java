package net.wytrem.delineo.rambuffers;

import java.nio.ByteBuffer;

import org.lwjgl.BufferUtils;

public class DataBuffer {
    protected final ByteBuffer data;

    public DataBuffer(int size) {
        this(BufferUtils.createByteBuffer(size));
    }
    
    public DataBuffer(ByteBuffer buffer) {
        this.data = buffer;
    }

    public DataBuffer put(float value) {
        data.putFloat(value);
        return this;
    }
    
    public DataBuffer put(short value) {
        data.putShort(value);
        return this;
    }
    
    public DataBuffer put(int value) {
        data.putInt(value);
        return this;
    }
    
    public DataBuffer put(byte value) {
        data.put(value);
        return this;
    }

    public int capacity() {
        return this.data.capacity();
    }
    
    public ByteBuffer getData() {
        return data;
    }
}
