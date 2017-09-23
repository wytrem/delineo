package net.wytrem.delineo.object;

import static org.lwjgl.opengl.GL15.GL_ARRAY_BUFFER;


public class VertexBufferObject extends GlBuffer {

    public VertexBufferObject() {
        super();
    }

    public VertexBufferObject(Usage usage) {
        super(usage);
    }
    
    @Override
    public int target() {
        return GL_ARRAY_BUFFER;
    }
}
