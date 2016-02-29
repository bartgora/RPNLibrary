package pl.bgora.rpn.advanced.functions;

import pl.bgora.rpn.advanced.AbstractRPNArithmeticFunction;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author Bartłomiej Góra (Black007pl@gmail.com)
 */
public class SinusRPNFunction extends AbstractRPNArithmeticFunction {

    public SinusRPNFunction(String name, int paramCount, RoundingMode mode) {
        super(name, paramCount, mode);
    }

    /**
     *
     */
    @Override
    public BigDecimal execute(String... params) {
        BigDecimal param = new BigDecimal(params[0]);
        BigDecimal result = BigDecimal.valueOf(Math.sin(param.doubleValue()));
        return result;
    }

}
