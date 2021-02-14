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

import java.util.HashMap;
import java.util.Map;

/**
 * This implementation Extends DefaultChecker with arithmetic funstions.
 *
 * Provided functions are: sin, cos, tg, ctg
 *
 * @author Bartłomiej Góra (bartlomiej.gora@gmail.com)
 */
public class DefaultChecker implements RPNChecking {

    private Map<String, Integer> operators;

    private Map<String, Integer> functions;

    public DefaultChecker() {
        operators = new HashMap<>();
        operators.put("+", 1);
        operators.put("-", 1);
        operators.put("*", 2);
        operators.put("/", 2);
        operators.put("^", 3);

        functions = new HashMap<>();
        functions.put("sin", 1);
        functions.put("cos", 1);
        functions.put("tg", 1);
        functions.put("ctg", 1);

    }

    /**
     * @see RPNChecking#isDigit(java.lang.String)
     */
    @Override
    public boolean isDigit(String input) {
        return Character.isDigit(input.charAt(0));
    }

    /**
     * @see RPNChecking#isLeftBracket(java.lang.String)
     */
    @Override
    public boolean isLeftBracket(String input) {
        return "(".equals(input);
    }

    /**
     * Returns true if input = +, or -, or *, or /, or ^, false otherwise.
     *
     * @see RPNChecking#isOperator(java.lang.String)
     */
    @Override
    public boolean isOperator(String input) {
        return operators.containsKey(input);
    }

    /**
     * Returns true if input = )
     *
     * @see RPNChecking#isRightBracket(java.lang.String)
     */
    @Override
    public boolean isRightBracket(String input) {
        return ")".equals(input);
    }

    /**
     * Returns true, if input is "+ - * /" or bracket "()"
     *
     * @see RPNChecking#isOperatorOrBracket(java.lang.String)
     */
    @Override
    public boolean isOperatorOrBracket(String c) {
        return isOperator(c) || isRightBracket(c) || isLeftBracket(c);
    }

    /**
     * @see RPNChecking#isLeftAssociativity(java.lang.String)
     */
    @Override
    public boolean isLeftAssociativity(String c) {
        return ("*".equals(c) || "+".equals(c) || "/".equals(c) || "-".equals(c));
    }

    /**
     * @see RPNChecking#isRightAssociativity(java.lang.String)
     */
    @Override
    public boolean isRightAssociativity(String c) {
        return "^".equals(c);
    }

    /**
     * @see RPNChecking#compareOperators(java.lang.String,
     * java.lang.String)
     */
    @Override
    public int compareOperators(String operator1, String operator2) {
        Integer i1 = operators.get(operator1);
        Integer i2 = operators.get(operator2);
        return i1 - i2;
    }

    /**
     * Checks if input is one of the recognized functions.
     *
     * Recognized functions are: sin, cos, tg, ctg.
     *
     * @see RPNChecking#isFunction(java.lang.String)
     */
    @Override
    public boolean isFunction(String input) {
        return functions.containsKey(input);
    }

    @Override
    public int getFunctionParamsCount(String functionName) {
        return functions.get(functionName);
    }

}
