package net.wytrem.delineo.object;

public abstract class GlObject {
    protected final int id;

    public GlObject(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }
    
    public abstract void delete();
}
