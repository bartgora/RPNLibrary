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

import java.math.BigDecimal;

/**
 * Interface used for executing Calculation on RPN String
 *
 * @author Bartłomiej Góra (bartlomiej.gora@gmail.com)
 */
public interface RPNExecuting {


    /**
     * This method executes arithmetic operator given as first parameter of type String.
     *
     * @param operator Arithmetic operator to execute.
     * @param var1     first variable
     * @param var2     second variable.
     * @return calculation result.
     * @throws WrongArgumentException if theres is something wrong withe the input.
     */
    BigDecimal executeOperator(String operator, String var1, String var2) throws WrongArgumentException;

    /**
     * This method executes Arithmetic Functions.
     * The first parameter is Function name.
     *
     * @param functionName Name of the function to execute.
     * @param arguments    List of arguments for the called function.
     * @return Calculation result as BigDecimal.
     * @throws NoSuchFunctionFound thrown if Executing object cannot find method.
     */
    BigDecimal executeFunction(String functionName, String... arguments) throws NoSuchFunctionFound;
}
