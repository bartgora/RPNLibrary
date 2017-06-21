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

package com.github.rpnlibrary.advanced.functions;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Cotangent function
 *
 * @author Bartłomiej Góra (bartlomiej.gora@gmail.com)
 */
public class CtgFunctionStrategy extends AbstractFunctionStrategy {

    public static final String ONE = "1.0000000000000000";

    public CtgFunctionStrategy() {
        super("ctg", 1, RoundingMode.HALF_EVEN);
    }

    @Override
    public BigDecimal execute(String... params) {
        BigDecimal dec = new BigDecimal(params[0]);
        BigDecimal tan = BigDecimal.valueOf(Math.tan(dec.doubleValue()));
        BigDecimal one = new BigDecimal(ONE);
        return one.divide(tan, roundingMode);
    }
}
