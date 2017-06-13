package pl.bgora.rpn.advanced.operators;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PowerOperatorStrategy extends AbstractOperatorStrategy {


    public PowerOperatorStrategy() {
        super("^", 3, RoundingMode.HALF_EVEN);
    }

    @Override
    public BigDecimal execute(String first, String second) {
        BigDecimal big1 = new BigDecimal(first);
        BigDecimal big2 = new BigDecimal(second);
        return big1.pow(big2.intValue());
    }


}
