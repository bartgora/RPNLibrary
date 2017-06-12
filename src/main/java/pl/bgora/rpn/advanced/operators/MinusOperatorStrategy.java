package pl.bgora.rpn.advanced.operators;

import pl.bgora.rpn.advanced.AbstractOperatorStrategy;

import java.math.BigDecimal;

public class MinusOperatorStrategy extends AbstractOperatorStrategy {


    public MinusOperatorStrategy(String operator) {
        super("-", 1);
    }

    @Override
    public BigDecimal execute(String first, String second) {
        return add(first, second);
    }


    private BigDecimal add(String var1, String var2) {
        BigDecimal big1 = new BigDecimal(var1);
        BigDecimal big2 = new BigDecimal(var2);
        return big1.subtract(big2);
    }
}
