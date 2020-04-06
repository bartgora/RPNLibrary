/*
 * RPNLibrary - Reverse Polish Notation Library
 * Copyright (C) 2011  Bartłomiej Góra
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * Contact: bartlomiej.gora@gmail.com
 */

package com.github.bgora.rpnlibrary;

import com.github.bgora.rpnlibrary.exceptions.NoSuchFunctionFound;
import com.github.bgora.rpnlibrary.exceptions.WrongArgumentException;
import com.github.bgora.rpnlibrary.functions.AbstractFunctionStrategy;
import com.github.bgora.rpnlibrary.operators.AbstractOperatorStrategy;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Map;

/**
 * Calculation Engine.
 * It is a composite that Implements RPNExecuting, and RPNChecking.
 * It uses Strategies for Operators, and Functions.
 *
 * @author Bartłomiej Góra (bartlomiej.gora@gmail.com)
 * @see RPNChecking
 * @see RPNExecuting
 * @see DefaultChecker
 */
public class CalculatorEngine extends DefaultChecker implements CalculationEngine {

    private Map<String, AbstractOperatorStrategy> operators;
    private Map<String, AbstractFunctionStrategy> functions;

    /**
     * Parametrized constructor.
     * <p>
     * Takes two maps with AbstractOperatorStrategy, and AbstractFunctionStrategy, to calculate.
     *
     * @param operators Map containing AbstractOperatorStrategy identified by it's operator
     * @param functions Map containing AbstractFunctionStrategy idetfioed by it's name
     */
    public CalculatorEngine(Map<String, AbstractOperatorStrategy> operators, Map<String, AbstractFunctionStrategy> functions) {
        this.operators = operators;
        this.functions = functions;
    }

    @Override
    public boolean isOperator(String input) {
        return operators.containsKey(input);
    }

    @Override
    public int compareOperators(String operato1, String operator2) {
        AbstractOperatorStrategy strategy1 = operators.get(operato1);
        AbstractOperatorStrategy strategy2 = operators.get(operator2);
        return strategy1.getPriority() - strategy2.getPriority();
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
    public BigDecimal executeOperator(String operator, MathContext mathContext, String var1, String var2) throws WrongArgumentException {
        return operators.get(operator).execute(var1, var2, mathContext);
    }

    @Override
    public BigDecimal executeFunction(String functionName, MathContext mathContext, String... arguments) throws NoSuchFunctionFound {
        return functions.get(functionName).execute(mathContext, arguments);
    }

    @Override
    public void addOperator(AbstractOperatorStrategy abstractOperatorStrategy) {
        this.operators.put(abstractOperatorStrategy.getOperator(), abstractOperatorStrategy);
    }

    @Override
    public void addFunctionStrategy(AbstractFunctionStrategy abstractFunctionStrategy) {
        this.functions.put(abstractFunctionStrategy.getName(), abstractFunctionStrategy);
    }
}
