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
package pl.bgora.rpn;

import pl.bgora.rpn.exceptions.WrongArgumentException;

import java.math.BigDecimal;
import java.math.RoundingMode;


/**
 * @author Bartłomiej Góra (bartlomiej.gora@gmail.com)
 */
class DefaultRPNExecutioner implements RPNExecuting {

    @Override
    public BigDecimal executeOperator(String operator, String var1, String var2, RoundingMode mode) throws WrongArgumentException {
        assert operator != null : "Operator cannot be null!";
        if (operator.equals("+")) {
            return add(var1, var2);
        } else if (operator.equals("-")) {
            return sub(var1, var2);
        } else if (operator.equals("*")) {
            return mull(var1, var2);
        } else if (operator.equals("/")) {
            return div(var1, var2, mode);
        } else if (operator.equals("^")) {
            return pow(var1, var2);
        }
        throw new WrongArgumentException("Unricignized operator: " + operator);
    }

    /**
     * @param var1
     * @param var2
     * @param mode
     * @return
     */
    private BigDecimal div(String var1, String var2, RoundingMode mode) {
        BigDecimal big1 = new BigDecimal(var1);
        BigDecimal big2 = new BigDecimal(var2);
        return big1.divide(big2, mode);
    }

    private BigDecimal mull(String var1, String var2) {
        BigDecimal big1 = new BigDecimal(var1);
        BigDecimal big2 = new BigDecimal(var2);
        return big1.multiply(big2);
    }

    private BigDecimal sub(String var1, String var2) {
        BigDecimal big1 = new BigDecimal(var1);
        BigDecimal big2 = new BigDecimal(var2);
        return big1.subtract(big2);
    }

    private BigDecimal add(String var1, String var2) {
        BigDecimal big1 = new BigDecimal(var1);
        BigDecimal big2 = new BigDecimal(var2);
        return big1.add(big2);
    }

    private BigDecimal pow(String var1, String var2) {
        BigDecimal big1 = new BigDecimal(var1);
        BigDecimal big2 = new BigDecimal(var2);
        return big1.pow(big2.intValue());
    }


}
