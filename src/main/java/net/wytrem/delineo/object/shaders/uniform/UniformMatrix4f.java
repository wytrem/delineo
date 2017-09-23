package net.wytrem.delineo.object.shaders.uniform;

import static org.lwjgl.opengl.GL20.glUniformMatrix4fv;

import java.util.function.Supplier;

import org.joml.Matrix4fc;

import net.wytrem.delineo.utils.TempVars;

public class UniformMatrix4f extends Uniform<Matrix4fc> {

    public UniformMatrix4f(String name, int location, Supplier<Matrix4fc> supplier) {
        super(name, location, supplier);
    }

    @Override
    public void upload() {
        TempVars tempVars = TempVars.get();
        supplier.get().get(tempVars.matrixWrite);
        glUniformMatrix4fv(location, false, tempVars.matrixWrite);
        tempVars.release();
    }
}
