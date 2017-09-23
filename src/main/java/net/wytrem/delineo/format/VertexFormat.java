package net.wytrem.delineo.format;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class VertexFormat implements Iterable<VertexAttribute>{
    
    private final Map<VertexAttribute, Integer> attribs;
    private final int stride;
    
    public VertexFormat(VertexAttribute...attributes) {
        this.attribs = new HashMap<>();
        
        int tempStride = 0;
        for (int i = 0; i < attributes.length; i++) {
            VertexAttribute attribute = attributes[i];
            
            attribs.put(attribute, tempStride);
            tempStride += attribute.getSize();
        }
        
        this.stride = tempStride;
    }
    
    public int getOffsetFor(VertexAttribute attrib) {
        return this.attribs.get(attrib);
    }
    
    public int getStride() {
        return stride;
    }

    @Override
    public Iterator<VertexAttribute> iterator() {
        return attribs.keySet().iterator();
    }
}
