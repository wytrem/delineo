package net.wytrem.delineo.object;

import static org.lwjgl.opengl.GL20.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glVertexAttribPointer;
import static org.lwjgl.opengl.GL30.glBindVertexArray;
import static org.lwjgl.opengl.GL30.glDeleteVertexArrays;
import static org.lwjgl.opengl.GL30.glGenVertexArrays;

import net.wytrem.delineo.format.VertexAttribute;
import net.wytrem.delineo.format.VertexFormat;

public class VertexArrayObject extends GlObject {
    public VertexArrayObject() {
        super(glGenVertexArrays());
    }
    
    public void bind() {
        glBindVertexArray(id);
    }
    
    public void unbind() {
        glBindVertexArray(0);
    }
    
    public void setup(VertexFormat format, VertexBufferObject vbo) {
        bind();
        vbo.bind();
        for (VertexAttribute attrib : format) {
            glVertexAttribPointer(attrib.getUsage().getLayoutLocation(), attrib.getCount(), attrib.getType().getConstant(), false, format.getStride(), format.getOffsetFor(attrib));
            glEnableVertexAttribArray(attrib.getUsage().getLayoutLocation());
        }
        
        vbo.unbind();
        unbind();
    }

    @Override
    public void delete() {
        glDeleteVertexArrays(id);
    }
}
