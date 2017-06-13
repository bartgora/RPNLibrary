package pl.bgora.rpn.advanced.functions;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TanFunctionStrategy extends AbstractFunctionStrategy {

    public TanFunctionStrategy() {
        super("tg", 1, RoundingMode.HALF_EVEN);
    }

    @Override
    public BigDecimal execute(String... params) {
        BigDecimal dec = new BigDecimal(params[0]);
        return BigDecimal.valueOf(Math.tan(dec.doubleValue()));
    }
}
