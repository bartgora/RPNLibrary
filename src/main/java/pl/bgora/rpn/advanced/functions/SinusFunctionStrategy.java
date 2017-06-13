package pl.bgora.rpn.advanced.functions;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Sinus function
 * @author Bartłomiej Góra (bartlomiej.gora@gmail.com)
 */
public class SinusFunctionStrategy extends AbstractFunctionStrategy {

    public SinusFunctionStrategy() {
        super("sin", 1, RoundingMode.HALF_EVEN);
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
