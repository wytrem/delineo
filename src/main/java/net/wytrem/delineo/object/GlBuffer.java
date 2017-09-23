package net.wytrem.delineo.object;

import static org.lwjgl.opengl.GL15.GL_DYNAMIC_COPY;
import static org.lwjgl.opengl.GL15.GL_DYNAMIC_DRAW;
import static org.lwjgl.opengl.GL15.GL_DYNAMIC_READ;
import static org.lwjgl.opengl.GL15.GL_STATIC_COPY;
import static org.lwjgl.opengl.GL15.GL_STATIC_DRAW;
import static org.lwjgl.opengl.GL15.GL_STATIC_READ;
import static org.lwjgl.opengl.GL15.GL_STREAM_COPY;
import static org.lwjgl.opengl.GL15.GL_STREAM_DRAW;
import static org.lwjgl.opengl.GL15.GL_STREAM_READ;
import static org.lwjgl.opengl.GL15.glBindBuffer;
import static org.lwjgl.opengl.GL15.glBufferData;
import static org.lwjgl.opengl.GL15.glDeleteBuffers;
import static org.lwjgl.opengl.GL15.glGenBuffers;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;


public abstract class GlBuffer extends GlObject {

    protected Usage usage;

    public GlBuffer() {
        this(Usage.STATIC_DRAW);
    }

    public GlBuffer(Usage usage) {
        super(glGenBuffers());
        this.usage = usage;
    }

    public void bind() {
        glBindBuffer(target(), id);
    }
    
    public void unbind() {
        glBindBuffer(target(), 0);
    }
    
    public abstract int target();

    public void bufferData(ByteBuffer data) {
        bind();
        glBufferData(target(), data, usage.getConstant());
        unbind();
    }

    public void bufferData(ByteBuffer data, Usage usage) {
        this.usage = usage;
        bufferData(data);
    }

    public void bufferData(ShortBuffer data) {
        bind();
        glBufferData(target(), data, usage.getConstant());
        unbind();
    }

    public void bufferData(ShortBuffer data, Usage usage) {
        this.usage = usage;
        bufferData(data);
    }

    public void bufferData(FloatBuffer data) {
        bind();
        glBufferData(target(), data, usage.getConstant());
        unbind();
    }

    public void bufferData(FloatBuffer data, Usage usage) {
        this.usage = usage;
        bufferData(data);
    }

    public void bufferData(IntBuffer data) {
        bind();
        glBufferData(target(), data, usage.getConstant());
        unbind();
    }

    public void bufferData(IntBuffer data, Usage usage) {
        this.usage = usage;
        bufferData(data);
    }

    public Usage getUsage() {
        return usage;
    }

    @Override
    public void delete() {
        glDeleteBuffers(id);
    }

    public static enum Usage {
        STREAM_DRAW(GL_STREAM_DRAW),
        STREAM_READ(GL_STREAM_READ),
        STREAM_COPY(GL_STREAM_COPY),
        STATIC_DRAW(GL_STATIC_DRAW),
        STATIC_READ(GL_STATIC_READ),
        STATIC_COPY(GL_STATIC_COPY),
        DYNAMIC_DRAW(GL_DYNAMIC_DRAW),
        DYNAMIC_READ(GL_DYNAMIC_READ),
        DYNAMIC_COPY(GL_DYNAMIC_COPY);

        private final int constant;

        private Usage(int constant) {
            this.constant = constant;
        }

        public int getConstant() {
            return constant;
        }
    }
}
