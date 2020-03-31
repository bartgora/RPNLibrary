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

package com.github.bgora.rpnlibrary.advanced.operators;

import java.math.BigDecimal;
import java.math.MathContext;

public abstract class AbstractOperatorStrategy {

    private final String operator;
    private final int priority;
    private volatile int hashCode = 0;


    public AbstractOperatorStrategy(final String operator, int priority) {
        this.operator = operator;
        this.priority = priority;
    }


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

    public String getOperator() {
        return operator;
    }

    public int getPriority() {
        return priority;
    }

}
