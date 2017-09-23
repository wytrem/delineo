package net.wytrem.delineo.object.shaders;

import static org.lwjgl.opengl.GL20.glCreateShader;
import static org.lwjgl.opengl.GL32.GL_GEOMETRY_SHADER;


public class GeometryShader extends Shader {
    public GeometryShader() {
        super(glCreateShader(GL_GEOMETRY_SHADER));
    }
}
