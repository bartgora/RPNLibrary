package pl.bgora.rpn.advanced;

import java.util.List;

/**
 * Advanced Calculator.
 * 
 * @author Bartłomiej Góra (Black007pl@gmail.com)
 *
 */
public class AdvancedCalculator {
	
	private List<AbstractRPNArithmeticFunction> functions;
	
	public AdvancedCalculator(List<AbstractRPNArithmeticFunction> functions) {
		this.functions = functions;
		
	}

}
