package net.wytrem.delineo.object.shaders;

import static org.lwjgl.opengl.GL11.GL_TRUE;
import static org.lwjgl.opengl.GL20.GL_COMPILE_STATUS;
import static org.lwjgl.opengl.GL20.glCompileShader;
import static org.lwjgl.opengl.GL20.glDeleteShader;
import static org.lwjgl.opengl.GL20.glGetShaderInfoLog;
import static org.lwjgl.opengl.GL20.glGetShaderi;
import static org.lwjgl.opengl.GL20.glShaderSource;

import net.wytrem.delineo.error.ShaderCompileException;
import net.wytrem.delineo.object.GlObject;

public abstract class Shader extends GlObject {
    
    public Shader(int id) {
        super(id);
    }
    
    public void delete() {
        glDeleteShader(id);
    }
    
    public void source(String source) {
        glShaderSource(id, source);
    }
    
    public void compile() {
        glCompileShader(id);

        if (glGetShaderi(id, GL_COMPILE_STATUS) != GL_TRUE) {
            throw new ShaderCompileException(glGetShaderInfoLog(id));
        }
    }
}
