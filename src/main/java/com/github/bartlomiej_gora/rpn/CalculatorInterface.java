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

import com.github.bartlomiej_gora.rpn.exceptions.NoSuchFunctionFound;
import com.github.bartlomiej_gora.rpn.exceptions.WrongArgumentException;

import java.math.BigDecimal;

/**
 * Interface for the Calculator
 *
 * @author Bartłomiej Góra (bartlomiej.gora@gmail.com)
 */
public interface CalculatorInterface {


    /**
     * Calculates RPN String into BigDecimal Object.
     * @param input Input String
     * @return The Calculated value
     * @throws WrongArgumentException If the argument was illegal, like leter, or other unrecognized element
     * @throws NoSuchFunctionFound If there is no function with given name
     */
    BigDecimal calculate(String input) throws WrongArgumentException, NoSuchFunctionFound;
}
