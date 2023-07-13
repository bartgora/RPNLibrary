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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class Calculator2ParamFunctionTest {

    private Calculator calc;

    @BeforeEach
     void setUp() {
        calc = Calculator.createCalculator();
    }


    @Test
     void testMax() throws WrongArgumentException, NoSuchFunctionFound {
        BigDecimal result = calc.calculate("max(10, 8)");
        assertThat(result).isEqualTo(new BigDecimal("10.00"));
    }

    @Test
     void testMaxPlus10() throws WrongArgumentException, NoSuchFunctionFound {
        BigDecimal result = calc.calculate("max(10, 8) + 10");
        assertThat(result).isEqualTo(new BigDecimal("20.00"));
    }

    @Test
     void testMaxMinus5() throws WrongArgumentException, NoSuchFunctionFound {
        BigDecimal result = calc.calculate("max(10, 8) -5");
        assertThat(result).isEqualTo(new BigDecimal("5.00"));
    }

    @Test
     void testMin() throws WrongArgumentException, NoSuchFunctionFound {
        BigDecimal result = calc.calculate("min(10, 8)");
        assertThat(result).isEqualTo(new BigDecimal("8.00"));
    }

    @Test
     void testMinPlus10() throws WrongArgumentException, NoSuchFunctionFound {
        BigDecimal result = calc.calculate("min(10, 8) + 10");
        assertThat(result).isEqualTo(new BigDecimal("18.00"));
    }

    @Test
     void testMinMinus5() throws WrongArgumentException, NoSuchFunctionFound {
        BigDecimal result = calc.calculate("min(10, 8) -5");
        assertThat(result).isEqualTo(new BigDecimal("3.00"));
    }

    @Test
     void testMinDouble() throws WrongArgumentException, NoSuchFunctionFound {
        BigDecimal result = calc.calculate("min(12.5, 9.4)");
        assertThat(result).isEqualTo(new BigDecimal("9.40"));
    }

    @Test
     void testMaxDouble() throws WrongArgumentException, NoSuchFunctionFound {
        BigDecimal result = calc.calculate("max(12 345.50, 8 000.66)");
        assertThat(result).isEqualTo(new BigDecimal("12345.50"));
    }


}
