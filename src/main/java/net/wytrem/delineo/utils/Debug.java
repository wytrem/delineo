package net.wytrem.delineo.utils;

import static org.lwjgl.opengl.GL15.GL_ARRAY_BUFFER;
import static org.lwjgl.opengl.GL15.GL_BUFFER_SIZE;
import static org.lwjgl.opengl.GL15.glGetBufferParameteri;
import static org.lwjgl.opengl.GL15.glGetBufferSubData;

import java.nio.ByteBuffer;

import org.lwjgl.BufferUtils;

import net.wytrem.delineo.object.VertexBufferObject;


public class Debug {
    public static void printBufferAsFloat(ByteBuffer data) {
        System.out.println("BUFFER : " + data);
        while (data.hasRemaining()) {
            System.out.println(data.getFloat());
        }
        
        System.out.println("-------------------");
    }
    
    public static void printVertexBufferAsFloat(VertexBufferObject vbo) {
        System.out.println("VBO : " + vbo.getId());
        vbo.bind();
        ByteBuffer data = BufferUtils.createByteBuffer(glGetBufferParameteri(GL_ARRAY_BUFFER, GL_BUFFER_SIZE));
        glGetBufferSubData(GL_ARRAY_BUFFER, 0l, data);
        vbo.unbind();
        System.out.println("data = " + data);
        printBufferAsFloat(data);
    }
}
