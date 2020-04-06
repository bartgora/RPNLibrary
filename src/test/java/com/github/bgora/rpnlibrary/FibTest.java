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

import com.github.bgora.rpnlibrary.exceptions.NoSuchFunctionFound;
import com.github.bgora.rpnlibrary.exceptions.WrongArgumentException;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class FibTest {

    private Calculator calc;

    @Before
    public void setUp() {
        calc = Calculator.createCalculator();
    }

    @Test
    public void testFib0() throws WrongArgumentException, NoSuchFunctionFound {
        BigDecimal result = calc.calculate("fib(0)");
        Assertions.assertThat(result).isEqualTo(new BigDecimal("0.00"));
    }

    @Test
    public void testFib1() throws WrongArgumentException, NoSuchFunctionFound {
        BigDecimal result = calc.calculate("fib(1)");
        Assertions.assertThat(result).isEqualTo(new BigDecimal("1.00"));
    }

    @Test
    public void testFib6() throws WrongArgumentException, NoSuchFunctionFound {
        BigDecimal result = calc.calculate("fib(6)");
        Assertions.assertThat(result).isEqualTo(new BigDecimal("8.00"));
    }

    @Test
    public void testFib10() throws WrongArgumentException, NoSuchFunctionFound {
        BigDecimal result = calc.calculate("fib(10)");
        Assertions.assertThat(result).isEqualTo(new BigDecimal("55.00"));
    }

    @Test
    public void testFib15() throws WrongArgumentException, NoSuchFunctionFound {
        BigDecimal result = calc.calculate("fib(15)");
        Assertions.assertThat(result).isEqualTo(new BigDecimal("610.00"));
    }

    @Test
    public void testFib19() throws WrongArgumentException, NoSuchFunctionFound {
        BigDecimal result = calc.calculate("fib(19)");
        Assertions.assertThat(result).isEqualTo(new BigDecimal("4181.00"));
    }
}
