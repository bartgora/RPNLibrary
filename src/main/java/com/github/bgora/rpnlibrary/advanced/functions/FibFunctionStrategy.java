/*
 * RPNLibrary - Reverse Polish NotationLibrary
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

package com.github.bgora.rpnlibrary.advanced.functions;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FibFunctionStrategy extends AbstractFunctionStrategy {


    public FibFunctionStrategy() {
        super("fib", 1, RoundingMode.HALF_EVEN);
    }

    @Override
    public BigDecimal execute(String... params) {
        BigDecimal bigDecimal = new BigDecimal(params[0]);
        return fib(bigDecimal);
    }

    private BigDecimal fib(BigDecimal bigDecimal) {
        if (bigDecimal.equals(BigDecimal.ZERO)) {
            return BigDecimal.ZERO;
        } else if (bigDecimal.equals(BigDecimal.ONE)) {
            return BigDecimal.ONE;
        }
        return fib(bigDecimal.subtract(BigDecimal.ONE)).add(fib(bigDecimal.subtract(BigDecimal.valueOf(2))));
    }
}
