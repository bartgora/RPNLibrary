package pl.bgora.rpn.advanced;


import java.math.BigDecimal;

/**
 * Abstract class for arithmetic functions.
 * 
 * This class contains function name, param count.
 * It also provides execute method which is responsible for call the underlying math function.
 * @author Bartłomiej Góra (Black007pl@gmail.com)
 *
 */
public abstract class AbstractRPNArithmeticFunction {

	private String name;
	
	private int paramCount;
	
	private volatile int hashCode = 0;
	
	

	public AbstractRPNArithmeticFunction(){
	}
	
	/**
	 * @param name function name
	 * @param paramCount Parameters count
	 */
	public AbstractRPNArithmeticFunction(String name, int paramCount){
		this.name = name;
		this.paramCount = paramCount;
	}

	/**
	 * Returns Name value
	 * @return name value
	 */
	public String getName() {
		return name;
	}


	/**
	 * Return paramCount value
	 * @return paramCount value
	 */
	public int getParamCount() {
		return paramCount;
	}

	
	
	/**
	 * Executes underlying arithmetic function writen in java.
	 * @param params Inpout param - A Table of Number, passed as string from Calculator.
	 * @return BigDecimal object with resulting value.
	 */
	public abstract BigDecimal execute(String... params );
	
	/** 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof AbstractRPNArithmeticFunction){
			AbstractRPNArithmeticFunction rpn = (AbstractRPNArithmeticFunction) obj; 
			return (name != null ? name.equals(rpn.name): name == rpn.name) && paramCount == rpn.paramCount;
		}
		return false;
	}
	
	/** 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		if(hashCode == 0){
			int result = 17;
			result = 31*result + name.hashCode();
			result = 31*result + paramCount;
			hashCode = result;
		}
		return hashCode;
	}
}
