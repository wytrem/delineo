package net.wytrem.delineo.error;

import net.wytrem.delineo.object.shaders.Program;

/**
 * An exception thrown when an OpenGL {@link Program} fails to link.
 */
public class ProgramLinkException extends RuntimeException {

    private static final long serialVersionUID = 8044023907618792945L;

    public ProgramLinkException() {
        super();
    }

    public ProgramLinkException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ProgramLinkException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProgramLinkException(String message) {
        super(message);
    }

    public ProgramLinkException(Throwable cause) {
        super(cause);
    }
}
