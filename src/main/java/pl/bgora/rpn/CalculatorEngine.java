package pl.bgora.rpn;

import pl.bgora.rpn.advanced.AbstractFunctionStrategy;
import pl.bgora.rpn.advanced.AbstractOperatorStrategy;
import pl.bgora.rpn.exceptions.NoSuchFunctionFound;
import pl.bgora.rpn.exceptions.WrongArgumentException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

public class CalculatorEngine extends DefaultChecker implements RPNExecuting, RPNChecking {

    private Map<String, AbstractOperatorStrategy> operators;
    private Map<String, AbstractFunctionStrategy> functions;

    public CalculatorEngine() {
    }

    public CalculatorEngine(Map<String, AbstractOperatorStrategy> operators, Map<String, AbstractFunctionStrategy> functions) {
        this.operators = operators;
        this.functions = functions;
    }

    @Override
    public boolean isOperator(String input) {
        return operators.containsKey(input);
    }

    @Override
    public int compareOperators(String c1, String c2) {
        AbstractOperatorStrategy s1 = operators.get(c1);
        AbstractOperatorStrategy s2 = operators.get(c2);
        return s1.getPriority() - s2.getPriority();
    }

    @Override
    public boolean isFunction(String input) {
        return functions.containsKey(input);
    }

    @Override
    public int getFunctionParamsCount(String functionName) {
        return functions.get(functionName).getParamCount();
    }

    @Override
    public BigDecimal executeOperator(String operator, String var1, String var2, RoundingMode mode) throws WrongArgumentException {
        return operators.get(operator).execute(var1, var2);
    }

    @Override
    public BigDecimal executeFunction(String functionName, RoundingMode mode, String... arguments) throws NoSuchFunctionFound {
        return functions.get(functionName).execute(arguments);
    }

    public Map<String, AbstractOperatorStrategy> getOperators() {
        return operators;
    }

    public Map<String, AbstractFunctionStrategy> getFunctions() {
        return functions;
    }
}
