package net.wytrem.delineo.rambuffers;

import java.nio.ByteBuffer;

import net.wytrem.delineo.format.VertexFormat;


public class VertexBuffer extends DataBuffer {

    private VertexFormat currentFormat;
    private int vertexCount;
    private int drawMode;
    
    public VertexBuffer(ByteBuffer buffer) {
        super(buffer);
    }

    public VertexBuffer(int size) {
        super(size);
    }
    
    public VertexBuffer pos(float x, float y, float z) {
        put(x).put(y).put(z);
        return this;
    }
    
    public void startDrawing(int mode, VertexFormat format) {
        this.drawMode = mode;
        this.currentFormat = format;
    }
    
    public void endVertex() {
        vertexCount++;
    }
    
    public void prepareUpload() {
        data.flip();
    }
    
    public void reset() {
        vertexCount = 0;
        currentFormat = null;
        data.clear();
    }
    
    public VertexFormat getCurrentFormat() {
        return currentFormat;
    }
    
    public int getDrawMode() {
        return drawMode;
    }
    
    public int getVertexCount() {
        return vertexCount;
    }
}
