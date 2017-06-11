package pl.bgora.rpn.advanced.operators;

import pl.bgora.rpn.advanced.AbstractOperatorStrategy;

import java.math.BigDecimal;

public class AddOperatorStrategy extends AbstractOperatorStrategy {


    public AddOperatorStrategy(String operator) {
        super("+");
    }

    @Override
    public BigDecimal execute(String first, String second) {
        return add(first, second);
    }


    private BigDecimal add(String var1, String var2) {
        BigDecimal big1 = new BigDecimal(var1);
        BigDecimal big2 = new BigDecimal(var2);
        return big1.add(big2);
    }
}
