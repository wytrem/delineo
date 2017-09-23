package net.wytrem.delineo.object.shaders.uniform;

import static org.lwjgl.opengl.GL20.glUniform1f;

import java.util.function.Supplier;

public class UniformFloat extends Uniform<Float> {

    public UniformFloat(String name, int location, Supplier<Float> supplier) {
        super(name, location, supplier);
    }

    @Override
    public void upload() {
        glUniform1f(location, supplier.get());
    }

}
