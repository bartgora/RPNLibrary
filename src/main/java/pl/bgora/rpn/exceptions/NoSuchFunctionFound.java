package pl.bgora.rpn.exceptions;

/**
 * Describes wrong function name.
 * <p/>
 * This Exception is thrown when user put wrong name of the function to input string.
 *
 * @author Bartłomiej Góra (bartlomiej.gora@gmail.com)
 * @serial
 */
public class NoSuchFunctionFound extends RPNException {


    /**
     * <code>serialVersionUID</code> -
     */
    private static final long serialVersionUID = 2721403205060626078L;

    public NoSuchFunctionFound() {
        super();
    }

    public NoSuchFunctionFound(String message) {
        super(message);
    }
}
