package net.wytrem.delineo.rambuffers;

import java.nio.ByteBuffer;


public class IndiceBuffer extends DataBuffer {
    public IndiceBuffer(ByteBuffer buffer) {
        super(buffer);
    }

    public IndiceBuffer(int size) {
        super(size);
    }
}
