package net.wytrem.delineo.error;

import net.wytrem.delineo.object.shaders.Shader;

/**
 * An exception thrown when an OpenGL {@link Shader} fails to compile.
 */
public class ShaderCompileException extends RuntimeException {

    private static final long serialVersionUID = 6720172806032587528L;

    public ShaderCompileException() {
        super();
    }

    public ShaderCompileException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ShaderCompileException(String message, Throwable cause) {
        super(message, cause);
    }

    public ShaderCompileException(String message) {
        super(message);
    }

    public ShaderCompileException(Throwable cause) {
        super(cause);
    }
}
