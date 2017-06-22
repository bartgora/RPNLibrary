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

package com.github.bgora.rpnlibrary;

import com.github.bgora.rpnlibrary.advanced.AdvancedCalculatorFactory;
import com.github.bgora.rpnlibrary.exceptions.NoSuchFunctionFound;
import com.github.bgora.rpnlibrary.exceptions.WrongArgumentException;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class PowerFunctionTest {

    private CalculatorInterface calc;

    @Before
    public void setUp() throws Exception {
        AdvancedCalculatorFactory advancedCalculatorFactory = new AdvancedCalculatorFactory();
        calc = advancedCalculatorFactory.createCalulator();
    }

    @Test
    public void testPower() throws WrongArgumentException, NoSuchFunctionFound {
        BigDecimal result = calc.calculate("pow(2,8)");
        assertEquals(BigDecimal.valueOf(256), result);
    }

    @Test
    public void testPowerPlus10() throws WrongArgumentException, NoSuchFunctionFound {
        BigDecimal result = calc.calculate("pow(2,8)+10");
        assertEquals(BigDecimal.valueOf(266), result);
    }

    @Test
    public void testPowerMultiply10() throws WrongArgumentException, NoSuchFunctionFound {
        BigDecimal result = calc.calculate("10*pow(2,8)");
        assertEquals(BigDecimal.valueOf(2560), result);
    }

    @Test
    public void testPowerMultiply10Minus20() throws WrongArgumentException, NoSuchFunctionFound {
        BigDecimal result = calc.calculate("10*pow(2,8)-20");
        assertEquals(BigDecimal.valueOf(2540), result);
    }


    @Test
    public void testExecute() throws WrongArgumentException, NoSuchFunctionFound {
        BigDecimal result = calc.calculate("sin(0) * 10 * pow(2,8)");
        assertEquals(BigDecimal.valueOf(0.0), result);
    }

}
