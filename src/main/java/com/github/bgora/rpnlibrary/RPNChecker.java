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


/**
 * This implementation Extends DefaultChecker with arithmetic funstions.
 * <p>
 * Provided functions are: sin, cos, tg, ctg
 *
 * @author Bartłomiej Góra (bartlomiej.gora@gmail.com)
 */
public class RPNChecker implements RPNChecking {

    private final StrategyProvider strategyProvider;

    public RPNChecker(final StrategyProvider strategyProvider) {
        this.strategyProvider = strategyProvider;
    }

    /**
     * @see RPNChecking#isDigit(String)
     */
    @Override
    public boolean isDigit(String input) {
        return Character.isDigit(input.charAt(0));
    }

    /**
     * @see RPNChecking#isLeftBracket(String)
     */
    @Override
    public boolean isLeftBracket(String input) {
        return "(".equals(input);
    }

    /**
     * Returns true if input = +, or -, or *, or /, or ^, false otherwise.
     *
     * @see RPNChecking#isOperator(String)
     */
    @Override
    public boolean isOperator(String input) {
        return strategyProvider.isOperatorAvailable(input);
    }

    /**
     * Returns true if input = )
     *
     * @see RPNChecking#isRightBracket(String)
     */
    @Override
    public boolean isRightBracket(String input) {
        return ")".equals(input);
    }

    /**
     * Returns true, if input is "+ - * /" or bracket "()"
     *
     * @see RPNChecking#isOperatorOrBracket(String)
     */
    @Override
    public boolean isOperatorOrBracket(String c) {
        return isOperator(c) || isRightBracket(c) || isLeftBracket(c);
    }

    /**
     * @see RPNChecking#isLeftAssociativity(String)
     */
    @Override
    public boolean isLeftAssociativity(String c) {
        return ("*".equals(c) || "+".equals(c) || "/".equals(c) || "-".equals(c));
    }

    /**
     * @see RPNChecking#isRightAssociativity(String)
     */
    @Override
    public boolean isRightAssociativity(String c) {
        return "^".equals(c);
    }

    /**
     * @see RPNChecking#compareOperators(String,
     * String)
     */
    @Override
    public int compareOperators(String operator1, String operator2) {
        Integer i1 = strategyProvider.getOperator(operator1).getPriority();
        Integer i2 = strategyProvider.getOperator(operator2).getPriority();
        return i1 - i2;
    }

    /**
     * Checks if input is one of the recognized functions.
     * <p>
     * Recognized functions are: sin, cos, tg, ctg.
     *
     * @see RPNChecking#isFunction(String)
     */
    @Override
    public boolean isFunction(String input) {
        return strategyProvider.isFunctionAvailable(input);
    }

    @Override
    public int getFunctionParamsCount(String functionName) {
        return strategyProvider.getFunction(functionName).getParamCount();
    }

}
