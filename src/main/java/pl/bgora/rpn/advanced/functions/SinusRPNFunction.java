package pl.bgora.rpn.advanced.functions;

import java.math.BigDecimal;

import pl.bgora.rpn.advanced.AbstractRPNArithmeticFunction;

/**
 * 
 * 
 * @author Bartłomiej Góra (Black007pl@gmail.com)
 *
 */
public class SinusRPNFunction extends AbstractRPNArithmeticFunction {

	/**
	 * 
	 */
	@Override
	public BigDecimal execute(String... params) {
		BigDecimal param = new BigDecimal(params[0]);
		BigDecimal result = BigDecimal.valueOf(param.doubleValue());
		return result;
	}

}
