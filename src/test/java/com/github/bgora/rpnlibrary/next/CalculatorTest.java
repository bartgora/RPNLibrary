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

package com.github.bgora.rpnlibrary.next;

import com.github.bgora.rpnlibrary.exceptions.RPNException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class CalculatorTest {

    private com.github.bgora.rpnlibrary.next.Calculator calc;

    @BeforeEach
    void setup() {
        calc = Calculator.createCalculator();
    }

    @Test
     void testCalculate() throws RPNException {
        BigDecimal result = calc.calculate("2^3*(12/6)+18/3+5.0/2");
        Assertions.assertThat(result).isEqualTo(new BigDecimal("24.50"));
    }

    @Test
     void testMultiply() throws RPNException {
        BigDecimal result = calc.calculate("2*8");
        Assertions.assertThat(result.setScale(0, RoundingMode.HALF_EVEN))
                .isEqualTo(BigDecimal.valueOf(16));
    }

    @Test
     void testMultiplyDouble() throws RPNException {
        BigDecimal result = calc.calculate("2*8.59");
        Assertions.assertThat(result).isEqualTo(BigDecimal.valueOf(17.18));
    }

    @Test
     void testMultiplyDouble3AfterDot() throws RPNException {
        BigDecimal result = calc.calculate("9*3.351");
        Assertions.assertThat(result).isEqualTo(new BigDecimal("30.16"));
    }


    @Test
     void testPower() throws RPNException {
        BigDecimal result = calc.calculate("2^8");
        Assertions.assertThat(result).isEqualTo(new BigDecimal("256.00"));
    }


    @Test
     void testPowerDouble() throws RPNException {
        BigDecimal result = calc.calculate("3.678^2");
        Assertions.assertThat(result).isEqualTo(new BigDecimal("13.53"));
    }

    @Test
     void testAdd() throws RPNException {
        BigDecimal result = calc.calculate("2+8");
        Assertions.assertThat(result).isEqualTo(new BigDecimal("10.00"));
    }

    @Test
     void testSub() throws RPNException {
        BigDecimal result = calc.calculate("2-5");
        Assertions.assertThat(result).isEqualTo(new BigDecimal("-3.00"));
    }

    @Test
     void testDiv() throws RPNException {
        BigDecimal result = calc.calculate("10.0/4");
        Assertions.assertThat(result).isEqualTo(new BigDecimal("2.50"));
    }

    @Test
     void testDivDouble() throws RPNException {
        BigDecimal result = calc.calculate("10.55/4");
        Assertions.assertThat(result.setScale(2, RoundingMode.HALF_EVEN)).isEqualTo(BigDecimal.valueOf(2.64));
    }

    @Test
     void testDivDouble3AfterDot() throws RPNException {
        BigDecimal result = calc.calculate("10.505/4");
        Assertions.assertThat(result).isEqualTo(new BigDecimal("2.63"));
    }

    @Test
     void testSinus() throws RPNException {
        BigDecimal result = calc.calculate("sin(2)");
        Assertions.assertThat(result).isEqualTo(new BigDecimal("0.91"));
    }

    @Test
     void testOneAddWhiteSpaceSinus() throws RPNException {
        BigDecimal result = calc.calculate("1 + sin(2)");
        Assertions.assertThat(result).isEqualTo(new BigDecimal("1.91"));
    }

    @Test
     void testSinusPlus() throws RPNException {
        BigDecimal result = calc.calculate("sin(1+1)");
        Assertions.assertThat(result).isEqualTo(new BigDecimal("0.91"));
    }

    @Test
     void testSinusMinus() throws RPNException {
        BigDecimal result = calc.calculate("sin(-1)");
        Assertions.assertThat(result).isEqualTo(new BigDecimal("-0.84"));
    }

    @Test
     void testCosMinus() throws RPNException {
        BigDecimal result = calc.calculate("cos(-1)");
        Assertions.assertThat(result).isEqualTo(new BigDecimal("0.54"));
    }

    @Test
     void testTgMinus() throws RPNException {
        BigDecimal result = calc.calculate("tg(-1)");
        Assertions.assertThat(result).isEqualTo(new BigDecimal("-1.56"));
    }

    @Test
     void testCtgMinus() throws RPNException {
        BigDecimal result = calc.calculate("ctg(-1)");
        Assertions.assertThat(result).isEqualTo(new BigDecimal(-0.6400000000, calc.getMathContext()).setScale(2));
    }

    @Test
     void testCtgMinus5Zeros() throws RPNException {
        BigDecimal result = calc.calculate("ctg(-1.65091)");
        Assertions.assertThat(result).isEqualTo(new BigDecimal(0.080, calc.getMathContext()).setScale(2));
    }

    @Test
     void testAddTousands() throws RPNException {
        BigDecimal result = calc.calculate("12 000 + 15");
        Assertions.assertThat(result).isEqualTo(new BigDecimal("12015.00"));
    }

//    @Test(expected = RPNException.class)
//     void shouldThrowRPNException() throws RPNException {
//        calc.calculate("aaaaa");
//    }

    @Test
     void shouldReturn2andHalf() throws RPNException {
        BigDecimal result = calc.calculate("5/2");
        Assertions.assertThat(result).isEqualTo(new BigDecimal("2.50"));
    }

    @Test
     void shouldReturn35() throws RPNException {
        BigDecimal result = calc.calculate("7/2");
        Assertions.assertThat(result).isEqualTo(new BigDecimal("3.50"));
    }

}
