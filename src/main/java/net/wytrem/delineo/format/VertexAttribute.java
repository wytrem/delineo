package net.wytrem.delineo.format;

public class VertexAttribute {

    public static final VertexAttribute POSITION_3F = new VertexAttribute(Usage.POSITION, PrimitiveType.FLOAT, 3);
    public static final VertexAttribute COLOR_3F = new VertexAttribute(Usage.COLOR, PrimitiveType.FLOAT, 3);

    
    private final PrimitiveType type;
    private final int count;
    private final Usage usage;
    
    public VertexAttribute(Usage usage, PrimitiveType dataType, int primitiveCount) {
        this.usage = usage;
        this.type = dataType;
        this.count = primitiveCount;
    }
    
    public int getCount() {
        return count;
    }
    
    public Usage getUsage() {
        return usage;
    }
    
    public PrimitiveType getType() {
        return type;
    }
    
    public int getSize() {
        return getCount() * getType().getSize();
    }
    
    public static class Usage {
        public static final Usage POSITION = new Usage("Position", 0);
        public static final Usage COLOR = new Usage("Color", 1);
        public static final Usage TEXCOORDS = new Usage("TexCoords", 2);
        public static final Usage NORMAL = new Usage("Normal", 3);

        private final String name;
        private final int layoutLocation;

        public Usage(String name, int layoutLocation) {
            this.name = name;
            this.layoutLocation = layoutLocation;
        }

        public String getName() {
            return name;
        }
        
        public int getLayoutLocation() {
            return layoutLocation;
        }
    }
}