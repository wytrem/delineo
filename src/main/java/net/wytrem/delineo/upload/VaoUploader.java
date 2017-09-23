package net.wytrem.delineo.upload;

import net.wytrem.delineo.object.VertexArrayObject;
import net.wytrem.delineo.object.VertexBufferObject;
import net.wytrem.delineo.object.GlBuffer.Usage;
import net.wytrem.delineo.rambuffers.IndiceBuffer;
import net.wytrem.delineo.rambuffers.VertexBuffer;
import net.wytrem.delineo.renderable.Renderable;
import net.wytrem.delineo.renderable.VaoRenderable;


public class VaoUploader implements BufferUploader {

    private VertexArrayObject vao;
    private VertexBufferObject vbo;
    private VaoRenderable renderable;

    public VaoUploader() {
        this(new VertexArrayObject(), new VertexBufferObject(Usage.STREAM_DRAW));
    }
    
    public VaoUploader(VertexArrayObject vao, VertexBufferObject vbo) {
        super();
        this.vao = vao;
        this.vbo = vbo;
        this.renderable = new VaoRenderable(vao, 0, 0, 0);
    }

    @Override
    public Renderable upload(VertexBuffer vertexBuffer) {
        vbo.bufferData(vertexBuffer.getData());
        vao.setup(vertexBuffer.getCurrentFormat(), vbo);
        renderable.setMode(vertexBuffer.getDrawMode());
        renderable.setCount(vertexBuffer.getVertexCount());
        return renderable;
    }

    @Override
    public Renderable upload(VertexBuffer vertexBuffer, IndiceBuffer indiceBuffer) {
        throw new UnsupportedOperationException();
    }
}
