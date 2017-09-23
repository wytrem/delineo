package net.wytrem.delineo.object.shaders;

import static org.lwjgl.opengl.GL20.GL_FRAGMENT_SHADER;
import static org.lwjgl.opengl.GL20.glCreateShader;

public class FragmentShader extends Shader {
    
    public FragmentShader() {
        super(glCreateShader(GL_FRAGMENT_SHADER));
    }
}
