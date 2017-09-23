package net.wytrem.delineo.object.shaders.uniform;

import java.util.function.Supplier;

public abstract class Uniform<T> {
    protected String name;
    protected int location;
    protected Supplier<T> supplier;
    
    public Uniform(String name, int location, Supplier<T> supplier) {
        this.name = name;
        this.location = location;
        this.supplier = supplier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }
    
    public abstract void upload();
}
