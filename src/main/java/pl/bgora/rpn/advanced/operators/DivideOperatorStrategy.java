package pl.bgora.rpn.advanced.operators;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DivideOperatorStrategy extends AbstractOperatorStrategy {


    public DivideOperatorStrategy() {
        super("/", 2, RoundingMode.HALF_EVEN);
    }

    @Override
    public BigDecimal execute(String first, String second) {
        BigDecimal big1 = new BigDecimal(first);
        BigDecimal big2 = new BigDecimal(second);
        return big1.divide(big2, roundingMode);
    }


}
