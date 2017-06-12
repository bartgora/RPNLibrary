package pl.bgora.rpn.advanced;

import java.math.BigDecimal;

public abstract class AbstractOperatorStrategy {

    private String operator;
    private int priority;
    private volatile int hashCode = 0;


    public abstract BigDecimal execute(String first, String second);


    public AbstractOperatorStrategy(String operator, int priority) {
        this.operator = operator;
        this.priority = priority;
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

    public int getPriority() {
        return priority;
    }
}
