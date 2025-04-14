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

package com.github.bgora.rpnlibrary.operators;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * Abstract class for operators.
 * <p>
 * This class contains operator name, param count.
 * It also provides execute method which is responsible for call the underlying math function.
 *
 * @author Bartłomiej Góra (bartlomiej.gora@gmail.com)
 */
public abstract class AbstractOperatorStrategy {

    private final String operator;
    private volatile int hashCode = 0;

    /**
     * Default Constructor.
     * Subclass need to provide required fields.
     *
     * @param operator Name of the operator
     */
    public AbstractOperatorStrategy(final String operator) {
        this.operator = operator;

    }

    /**
     * Execute Operator
     *
     * @param first       first argument of the operation
     * @param second      second argument of the operation
     * @param mathContext matchContext object to do eqation
     * @return result of the operation
     */
    public abstract BigDecimal execute(final String first, final String second, final MathContext mathContext);

    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final AbstractOperatorStrategy that = (AbstractOperatorStrategy) o;
        return operator.equals(that.operator);
    }

    /**
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        if (hashCode == 0) {
            int result = 17;
            result = 31 * result + operator.hashCode();
            hashCode = result;
        }
        return hashCode;
    }


    /**
     * Returns operator sign
     *
     * @return operator
     */
    public String getOperator() {
        return operator;
    }


}
