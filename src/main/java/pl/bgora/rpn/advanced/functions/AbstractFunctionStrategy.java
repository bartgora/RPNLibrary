package pl.bgora.rpn.advanced.functions;


import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Abstract class for arithmetic functions.
 *
 * This class contains function name, param count.
 * It also provides execute method which is responsible for call the underlying math function.
 *
 * @author Bartłomiej Góra (bartlomiej.gora@gmail.com)
 */
public abstract class AbstractFunctionStrategy {

    private String name;

    private int paramCount;

    private volatile int hashCode = 0;

    protected RoundingMode roundingMode;


    /**
     * Default Constructor.
     * Subclass need to provide required fields.
     *
     * @param name Name of the function
     * @param paramCount parameters count
     * @param roundingMode Rounding Mode
     */
    public AbstractFunctionStrategy(String name, int paramCount, RoundingMode roundingMode) {
        this.name = name;
        this.paramCount = paramCount;
        this.roundingMode = roundingMode;
    }

    /**
     * Returns Name value
     *
     * @return name value
     */
    public String getName() {
        return name;
    }


    /**
     * Return paramCount value
     *
     * @return paramCount value
     */
    public int getParamCount() {
        return paramCount;
    }


    public RoundingMode getRoundingMode() {
        return roundingMode;
    }

    /**
     * Executes underlying arithmetic function written in java.
     *
     * @param params Inpout param - A Table of Number, passed as string from Calculator.
     * @return BigDecimal object with resulting value.
     */
    public abstract BigDecimal execute(String... params);

    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof AbstractFunctionStrategy) {
            AbstractFunctionStrategy rpn = (AbstractFunctionStrategy) obj;
            return (name != null ? name.equals(rpn.name) : name == rpn.name) && paramCount == rpn.paramCount;
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
            result = 31 * result + name.hashCode();
            result = 31 * result + paramCount;
            hashCode = result;
        }
        return hashCode;
    }
}
