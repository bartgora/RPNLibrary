package pl.bgora.rpn.advanced.functions;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CtgFunctionStrategy extends AbstractFunctionStrategy {

    public static final String ONE = "1.0000000000000000";

    public CtgFunctionStrategy() {
        super("ctg", 1, RoundingMode.HALF_EVEN);
    }

    @Override
    public BigDecimal execute(String... params) {
        BigDecimal dec = new BigDecimal(params[0]);
        BigDecimal tan = BigDecimal.valueOf(Math.tan(dec.doubleValue()));
        BigDecimal one = new BigDecimal(ONE);
        return one.divide(tan, roundingMode);
    }
}
