package net.wytrem.delineo.object.shaders;

import static org.lwjgl.opengl.GL11.GL_TRUE;
import static org.lwjgl.opengl.GL20.GL_LINK_STATUS;
import static org.lwjgl.opengl.GL20.glAttachShader;
import static org.lwjgl.opengl.GL20.glCreateProgram;
import static org.lwjgl.opengl.GL20.glDeleteProgram;
import static org.lwjgl.opengl.GL20.glGetProgramInfoLog;
import static org.lwjgl.opengl.GL20.glGetProgrami;
import static org.lwjgl.opengl.GL20.glGetUniformLocation;
import static org.lwjgl.opengl.GL20.glLinkProgram;
import static org.lwjgl.opengl.GL20.glUseProgram;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import org.joml.Matrix4fc;

import net.wytrem.delineo.error.ProgramLinkException;
import net.wytrem.delineo.object.GlObject;
import net.wytrem.delineo.object.shaders.uniform.Uniform;
import net.wytrem.delineo.object.shaders.uniform.UniformFloat;
import net.wytrem.delineo.object.shaders.uniform.UniformMatrix4f;
import net.wytrem.delineo.utils.TriFunction;

public class Program extends GlObject {

    private Map<String, Uniform<?>> uniforms;

    public Program() {
        super(glCreateProgram());
        this.uniforms = new HashMap<>();
    }
    
    public void attach(Shader shader) {
        glAttachShader(id, shader.getId());
    }
    
    public void link() {
        glLinkProgram(id);
        
        if (glGetProgrami(id, GL_LINK_STATUS) != GL_TRUE) {
            throw new ProgramLinkException(glGetProgramInfoLog(id));
        }
    }
    
    public void use() {
        glUseProgram(id);
        uniforms.values().forEach(Uniform::upload);
    }
    
    public int getUniformLocation(String name) {
        return glGetUniformLocation(id, name);
    }
    
    public UniformMatrix4f registerUniformMatrix4f(String name, Supplier<Matrix4fc> supplier) {
        return registerUniform(name, supplier, UniformMatrix4f::new);
    }
    
    public UniformFloat registerUniform1f(String name, Supplier<Float> supplier) {
        return registerUniform(name, supplier, UniformFloat::new);
    }
    
    public UniformFloat registerUniform1d(String name, Supplier<Double> supplier) {
        return registerUniform(name, () -> supplier.get().floatValue(), UniformFloat::new);
    }
    
    protected <T, U extends Uniform<T>> U registerUniform(String name, Supplier<T> supplier, TriFunction<String, Integer, Supplier<T>, U> constructor) {
        U uniform = constructor.apply(name, getUniformLocation(name), supplier);
        uniforms.put(name, uniform);
        return uniform;
    }
    
    @Override
    public void delete() {
        glDeleteProgram(id);
    }
}
