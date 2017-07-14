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
import com.github.bgora.rpnlibrary.exceptions.RPNException;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    private Calculator calc;

    @Before
    public void setUp() throws Exception {
        calc = Calculator.createDefaultCalculator();
    }

    @Test
    public void testCalculate() throws RPNException {
        BigDecimal result = calc.calculate("2^3*(12/6)+18/3+5/2");
        assertEquals("2^3*(12/6)+18/3+5/2", BigDecimal.valueOf(24.5), result);
    }

    @Test
    public void testMultiply() throws RPNException {
        BigDecimal result = calc.calculate("2*8");
        assertEquals("2*8", BigDecimal.valueOf(16), result);
    }

    @Test
    public void testMultiplyDouble() throws RPNException {
        BigDecimal result = calc.calculate("2*8.59");
        assertEquals("2*8.59", BigDecimal.valueOf(17.18), result);
    }

    @Test
    public void testMultiplyDouble3AfterDot() throws RPNException {
        BigDecimal result = calc.calculate("9*3.351");
        assertEquals("9*3.351", new BigDecimal("30.159"), result);
    }


    @Test
    public void testPower() throws RPNException {
        BigDecimal result = calc.calculate("2^8");
        assertEquals("2^8", BigDecimal.valueOf(256), result);
    }


    @Test
    public void testPowerDouble() throws RPNException {
        BigDecimal result = calc.calculate("3.678^2");
        assertEquals("3.678^2", new BigDecimal("13.527684"), result);
    }

    @Test
    public void testAdd() throws RPNException {
        BigDecimal result = calc.calculate("2+8");
        assertEquals("2+8", BigDecimal.valueOf(10), result);
    }

    @Test
    public void testSub() throws RPNException {
        BigDecimal result = calc.calculate("2-5");
        assertEquals("2-5", BigDecimal.valueOf(-3), result);
    }

    @Test
    public void testDiv() throws RPNException {
        BigDecimal result = calc.calculate("10/4");
        assertEquals("10/4", BigDecimal.valueOf(2.5), result);
    }

    @Test
    public void testDivDouble() throws RPNException {
        BigDecimal result = calc.calculate("10.55/4");
        assertEquals("10.55/4", BigDecimal.valueOf(2.64), result);
    }

    @Test
    public void testDivDouble3AfterDot() throws RPNException {
        BigDecimal result = calc.calculate("10.505/4");
        assertEquals("10.505/4", BigDecimal.valueOf(2.626), result);
    }

    @Test
    public void testSinus() throws RPNException {
        BigDecimal result = calc.calculate("sin(2)");
        assertEquals(BigDecimal.valueOf(Math.sin(2)), result);
    }

    @Test
    public void testOneAddWhiteSpaceSinus() throws RPNException {
        BigDecimal result = calc.calculate("1 + sin(2)");
        assertEquals(BigDecimal.valueOf(1 + Math.sin(2)), result);
    }

    @Test
    public void testSinusPlus() throws RPNException {
        BigDecimal result = calc.calculate("sin(1+1)");
        assertEquals(BigDecimal.valueOf(Math.sin(1 + 1)), result);
    }

    @Test
    public void testSinusMinus() throws RPNException {
        BigDecimal result = calc.calculate("sin(-1)");
        assertEquals(BigDecimal.valueOf(Math.sin(-1)), result);
    }

    @Test
    public void testCosinusMinus() throws RPNException {
        BigDecimal result = calc.calculate("cos(-1)");
        assertEquals(BigDecimal.valueOf(Math.cos(-1)), result);
    }

    @Test
    public void testTgMinus() throws RPNException {
        BigDecimal result = calc.calculate("tg(-1)");
        assertEquals(BigDecimal.valueOf(Math.tan(-1)), result);
    }

    @Test
    public void testCtgMinus() throws RPNException {
        BigDecimal result = calc.calculate("ctg(-1)");
        assertEquals(BigDecimal.valueOf(1.0000000000 / Math.tan(-1)).setScale(10, RoundingMode.HALF_EVEN), result.setScale(10, RoundingMode.HALF_EVEN));
    }

    @Test
    public void testCtgMinus5Zeros() throws RPNException {
        BigDecimal result = calc.calculate("ctg(-1.65091)");
        assertEquals(BigDecimal.valueOf(1.00 / Math.tan(-1.65091)), result);
    }

    @Test
    public void testAddTousands() throws RPNException {
        BigDecimal result = calc.calculate("12 000 + 15");
        assertEquals(BigDecimal.valueOf(12015), result);
    }

    @Test(expected = RPNException.class)
    public void shouldThrowRPNException() throws RPNException {
        calc.calculate("aaaaa");
    }

    @Test
    public void testBrackets() throws WrongArgumentException, NoSuchFunctionFound {
        BigDecimal result = calc.calculate("10 * (5+2)");
        assertEquals(BigDecimal.valueOf(70), result);
    }
}
