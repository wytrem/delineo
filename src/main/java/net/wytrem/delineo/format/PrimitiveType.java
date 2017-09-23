package net.wytrem.delineo.format;

import static org.lwjgl.opengl.GL11.GL_BYTE;
import static org.lwjgl.opengl.GL11.GL_FLOAT;
import static org.lwjgl.opengl.GL11.GL_INT;
import static org.lwjgl.opengl.GL11.GL_SHORT;
import static org.lwjgl.opengl.GL11.GL_UNSIGNED_BYTE;
import static org.lwjgl.opengl.GL11.GL_UNSIGNED_INT;
import static org.lwjgl.opengl.GL11.GL_UNSIGNED_SHORT;

public enum PrimitiveType {
    FLOAT(Float.BYTES, GL_FLOAT),
    UBYTE(Byte.BYTES, GL_UNSIGNED_BYTE),
    BYTE(Byte.BYTES, GL_BYTE),
    USHORT(Short.BYTES, GL_UNSIGNED_SHORT),
    SHORT(Short.BYTES, GL_SHORT),
    UINT(Integer.BYTES, GL_UNSIGNED_INT),
    INT(Integer.BYTES, GL_INT);
    private final int size;
    private final int constant;

    private PrimitiveType(int size, int constant) {
        this.size = size;
        this.constant = constant;
    }

    public int getConstant() {
        return constant;
    }

    public int getSize() {
        return size;
    }
}