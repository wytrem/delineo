package net.wytrem.delineo.object;

import static org.lwjgl.opengl.GL15.GL_ELEMENT_ARRAY_BUFFER;


public class ElementBufferObject extends GlBuffer {

    public ElementBufferObject() {
        super();
    }

    public ElementBufferObject(Usage usage) {
        super(usage);
    }

    @Override
    public int target() {
        return GL_ELEMENT_ARRAY_BUFFER;
    }
}
