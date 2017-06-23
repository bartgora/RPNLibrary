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

import com.github.bgora.rpnlibrary.advanced.AdvancedCalculatorFactory;
import com.github.bgora.rpnlibrary.exceptions.NoSuchFunctionFound;
import com.github.bgora.rpnlibrary.exceptions.WrongArgumentException;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class AdvancedCalulatorTest2ParamFunction {

    private CalculatorInterface calc;

    @Before
    public void setUp() throws Exception {
        AdvancedCalculatorFactory advancedCalculatorFactory = new AdvancedCalculatorFactory();
        calc = advancedCalculatorFactory.createCalulator();
    }


    @Test
    public void testMax() throws WrongArgumentException, NoSuchFunctionFound {
        BigDecimal result = calc.calculate("max(10, 8)");
        assertEquals(BigDecimal.valueOf(10), result);
    }

    @Test
    public void testMaxPlus10() throws WrongArgumentException, NoSuchFunctionFound {
        BigDecimal result = calc.calculate("max(10, 8) + 10");
        assertEquals(BigDecimal.valueOf(20), result);
    }

    @Test
    public void testMaxMinus5() throws WrongArgumentException, NoSuchFunctionFound {
        BigDecimal result = calc.calculate("max(10, 8) -5");
        assertEquals(BigDecimal.valueOf(5), result);
    }

    @Test
    public void testMin() throws WrongArgumentException, NoSuchFunctionFound {
        BigDecimal result = calc.calculate("min(10, 8)");
        assertEquals(BigDecimal.valueOf(8), result);
    }

    @Test
    public void testMinPlus10() throws WrongArgumentException, NoSuchFunctionFound {
        BigDecimal result = calc.calculate("min(10, 8) + 10");
        assertEquals(BigDecimal.valueOf(18), result);
    }

    @Test
    public void testMinMinus5() throws WrongArgumentException, NoSuchFunctionFound {
        BigDecimal result = calc.calculate("min(10, 8) -5");
        assertEquals(BigDecimal.valueOf(3), result);
    }
}
