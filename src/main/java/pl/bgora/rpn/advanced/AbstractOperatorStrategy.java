package pl.bgora.rpn.advanced;

import java.math.BigDecimal;

public abstract class AbstractOperatorStrategy {

    private String operator;

    private volatile int hashCode = 0;


    public abstract BigDecimal execute(String first, String second);


    public AbstractOperatorStrategy(String operator) {
        this.operator = operator;
    }

    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof AbstractOperatorStrategy) {
            AbstractOperatorStrategy rpn = (AbstractOperatorStrategy) obj;
            return (operator != null ? operator.equals(rpn.operator) : operator == rpn.operator);
        }
        return false;
    }

    /**
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        if (hashCode == 0) {
            int result = 17;
            result = 31 * result + operator.hashCode();
            hashCode = result;
        }
        return hashCode;
    }

    public String getOperator() {
        return operator;
    }
}
