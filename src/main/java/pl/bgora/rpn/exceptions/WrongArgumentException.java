/**
 * 
 */
package pl.bgora.rpn.exceptions;

/**
 * Describes wrong input.
 * 
 * This Exception describes situation, when input string is in wrong format.
 * This occurs when for instance user put unrecognized char into input string.
 * @author Bartłomiej Góra (Black007pl@gmail.com)
 * @serial
 *
 */
public class WrongArgumentException extends RPNException {
	

	private static final long serialVersionUID = 8945842987018146049L;

	public WrongArgumentException() {
		super();
	}
	
	public WrongArgumentException(String message){
		super(message);
	}
}
