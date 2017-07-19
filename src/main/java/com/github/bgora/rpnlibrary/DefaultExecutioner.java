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
import java.math.RoundingMode;

/**
 * Default Implementation of the RPNExecuting
 *
 * @author Bartłomiej Góra (bartlomiej.gora@gmail.com)
 */
public class DefaultExecutioner implements RPNExecuting {


    private static final String ONE = "1";

    @Override
    public BigDecimal executeOperator(String operator, String var1, String var2, RoundingMode mode) throws WrongArgumentException {
        assert operator != null : "Operator cannot be null!";
        if ("+".equals(operator)) {
            return add(var1, var2);
        } else if ("-".equals(operator)) {
            return sub(var1, var2);
        } else if ("*".equals(operator)) {
            return mull(var1, var2);
        } else if ("/".equals(operator)) {
            return div(var1, var2);
        } else if ("^".equals(operator)) {
            return pow(var1, var2);
        }
        throw new WrongArgumentException("Unrecognized operator: " + operator);
    }

    private BigDecimal div(String var1, String var2) {
        Double big1 = new Double(var1);
        Double big2 = new Double(var2);
        return BigDecimal.valueOf(big1 / big2);
    }

    private BigDecimal mull(String var1, String var2) {
        Double big1 = new Double(var1);
        Double big2 = new Double(var2);
        return BigDecimal.valueOf(big1 * big2);
    }

    private BigDecimal sub(String var1, String var2) {
        Double big1 = new Double(var1);
        Double big2 = new Double(var2);
        return BigDecimal.valueOf(big1 - big2);
    }

    private BigDecimal add(String var1, String var2) {
        Double big1 = new Double(var1);
        Double big2 = new Double(var2);
        return BigDecimal.valueOf(big1 + big2);
    }

    private BigDecimal pow(String var1, String var2) {
        Double big1 = new Double(var1);
        Double big2 = new Double(var2);
        return BigDecimal.valueOf(Math.pow(big1, big2));
    }

    @Override
    public BigDecimal executeFunction(String functionName, RoundingMode mode, String... arguments)
            throws NoSuchFunctionFound {
        if ("sin".equals(functionName)) {
            Double dec = new Double(arguments[0]);
            return BigDecimal.valueOf(Math.sin(dec));
        } else if ("cos".equals(functionName)) {
            Double dec = new Double(arguments[0]);
            return BigDecimal.valueOf(Math.cos(dec));
        } else if ("tg".equals(functionName)) {
            Double dec = new Double(arguments[0]);
            return BigDecimal.valueOf(Math.tan(dec));
        } else if ("ctg".equals(functionName)) {
            Double dec = new Double(arguments[0]);
            Double tan = Math.tan(dec);
            Double one = new Double(ONE);
            return BigDecimal.valueOf(one/tan);
        }
        throw new NoSuchFunctionFound("There is no function named " + functionName);

    }

}
