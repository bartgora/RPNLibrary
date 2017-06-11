/*
    RPNCalculator - Reverse Polish Notation mathematics Library
    Copyright (C) 2011  Bartłomiej "Black007" Góra

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package pl.bgora.rpn.advanced;

import pl.bgora.rpn.CalculatorInterface;
import pl.bgora.rpn.exceptions.NoSuchFunctionFound;
import pl.bgora.rpn.exceptions.WrongArgumentException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

/**
 * Advanced Calculator.
 *
 * @author Bartłomiej Góra (bartlomiej.gora@gmail.com)
 */
public class AdvancedCalculator implements CalculatorInterface {

    private Map<String, AbstractFunctionStrategy> functions;
    private Map<String, AbstractOperatorStrategy> operators;
    private RoundingMode roundingMode;

    AdvancedCalculator(RoundingMode mode, Map<String, AbstractFunctionStrategy> functions, Map<String, AbstractOperatorStrategy> operators) {
        this.functions = functions;
        this.roundingMode = mode;
        this.operators = operators;
    }


    @Override
    public BigDecimal calculate(String input) throws WrongArgumentException, NoSuchFunctionFound {
        return null;
    }
}
