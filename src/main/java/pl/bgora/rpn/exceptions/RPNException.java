package pl.bgora.rpn.exceptions;

/**
 * Base Exception class for all exceptions in RPNLibrary project.
 *
 * @author Bartłomiej Góra (Black007pl@gmail.com)
 */
public class RPNException extends Exception {


    private static final long serialVersionUID = 601457826479138831L;

    /**
     * Contructor
     * Creates class instance
     */
    public RPNException() {
        super();
    }

    /**
     * Contructor.
     * Creates class instance
     *
     * @param message Exception Message
     */
    public RPNException(String message) {
        super(message);
    }
}
