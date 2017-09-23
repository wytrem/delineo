package net.wytrem.delineo.renderable;

import static org.lwjgl.opengl.GL11.glDrawArrays;

import net.wytrem.delineo.object.VertexArrayObject;


public class VaoRenderable implements Renderable {
    private VertexArrayObject vao;
    private int mode, first, count;

    public VaoRenderable(VertexArrayObject vao, int mode, int first, int count) {
        this.vao = vao;
        this.mode = mode;
        this.first = first;
        this.count = count;
    }

    @Override
    public void render() {
        vao.bind();
        glDrawArrays(mode, first, count);
        vao.unbind();
    }

    public VertexArrayObject getVao() {
        return vao;
    }

    public void setVao(VertexArrayObject vao) {
        this.vao = vao;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
