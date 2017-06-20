/*
 * RPNCalculator - Reverse Polish Notation mathematics Library
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

package com.github.bartlomiej_gora.rpn;

/**
 * Interface used to check conditions on input characters for Dijsktra Algorithm

 * @author Bartłomiej Góra (bartlomiej.gora@gmail.com)
 */
public interface RPNChecking {


    /**
     * Checks the parameter is digit
     *
     * @param input String parameter
     * @return true if digit
     */
    boolean isDigit(String input);

    /**
     * Checks if the parameter is arithmetic operator
     *
     * @param input String parameter
     * @return true if operator
     */
    boolean isOperator(String input);

    /**
     * Checks if parameter is left bracket
     *
     * @param input String parameter
     * @return true if left bracket
     */
    boolean isLeftBracket(String input);

    /**
     * Checks if parameter is right bracket
     * @param input String parameter
     * @return true if rigth bracket
     */
    boolean isRightBracket(String input);

    /**
     * Checks if parameter is bracket or arithmetic operator
     * @param c String parameter
     * @return true if operator or bracket
     */
    boolean isOperatorOrBracket(String c);

    /**
     * Checks if parametr is lest associated
     * @param c String parameter
     * @return true if left associativity
     */
    boolean isLeftAssociativity(String c);

    /**
     * Checks if parametr is right associated
     * @param c String parameter
     * @return true if right associativity
     */
    boolean isRightAssociativity(String c);

    /**
     * Compare opertors due to their hierarchy
     *
     * @param operato1 String First operator
     * @param operator2 String Second operator
     * @return int 0 if equals, more than 0 if first is before second less tahn 0 if second is before first
     */
    int compareOperators(String operato1, String operator2);

    /**
     * Checks if given String is function name
     *
     * @param input function name
     * @return true if the toke is function
     */
    boolean isFunction(String input);

    /**
     * Returns parameters count for the given function
     * @param functionName function name
     * @return parameters count
     */
    int getFunctionParamsCount(String functionName);
}
