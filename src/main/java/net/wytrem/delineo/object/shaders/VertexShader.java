package net.wytrem.delineo.object.shaders;

import static org.lwjgl.opengl.GL20.GL_VERTEX_SHADER;
import static org.lwjgl.opengl.GL20.glCreateShader;


public class VertexShader extends Shader {
    public VertexShader() {
        super(glCreateShader(GL_VERTEX_SHADER));
    }
}
