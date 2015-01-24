package pl.bgora.rpn.advanced;

import java.util.LinkedList;
import java.util.List;

/**
 * Factory class for creating AdvancedCalculator.
 * 
 * @author Bartłomiej Góra (Black007pl@gmail.com)
 *
 */
public class AdvancedCalculatorFactory {
	
	private List<AbstractRPNArithmeticFunction> functions;

	/**
	 * Private Constructor for factory object.
	 */
	private AdvancedCalculatorFactory(){
		this.functions = new LinkedList<AbstractRPNArithmeticFunction>();
	}
	
	/**
	 * Returns factory instance.
	 * @return factory instance
	 */
	public static AdvancedCalculatorFactory getFactoryInstance(){
		return new AdvancedCalculatorFactory();
	}
	
	
	/**
	 * Adds Object of AbstractRPNArithmeticFunction
	 * @param function 
	 */
	public AdvancedCalculatorFactory addFunction(AbstractRPNArithmeticFunction function){
		this.functions.add(function);
		return this;
	}
	
	
	/**
	 * Adds Functions to this Factory. Calculator will be bale to process those functions.
	 * @param functions java.util.List of Functions.
	 */
	public void addFunctions(List<AbstractRPNArithmeticFunction> functions){
		this.functions.addAll(functions);
	}
	
	/**
	 * Factory method to create new AdvacedCalculator
	 * 
	 * @return {@link pl.bgora.rpn.advanced.AdvancedCalculator}
	 */
	public AdvancedCalculator createNewAdvancedCalculator(){
		AdvancedCalculator calc = new AdvancedCalculator(functions);
		return calc;
	}
	
}
