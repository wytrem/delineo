package net.wytrem.delineo.upload;

import net.wytrem.delineo.rambuffers.IndiceBuffer;
import net.wytrem.delineo.rambuffers.VertexBuffer;
import net.wytrem.delineo.renderable.Renderable;

public interface BufferUploader {
    Renderable upload(VertexBuffer vertexBuffer);
    
    Renderable upload(VertexBuffer vertexBuffer, IndiceBuffer indiceBuffer);
}
