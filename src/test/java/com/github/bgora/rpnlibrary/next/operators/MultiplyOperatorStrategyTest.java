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

package com.github.bgora.rpnlibrary.next.operators;

import com.github.bgora.rpnlibrary.operators.MultiplyOperatorStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.MathContext;

import static org.assertj.core.api.BDDAssertions.then;

class MultiplyOperatorStrategyTest {

    private MultiplyOperatorStrategy tested;
    private MathContext mathContext;

    @BeforeEach
    void setup() {
        tested = new MultiplyOperatorStrategy();
        mathContext = MathContext.DECIMAL64;
    }

    @Test
    void executeShouldReturn4() {

        final String givenFirstNumber = "2";
        final String givenSecondNumber = "2";

        final BigDecimal result = tested.execute(givenFirstNumber, givenSecondNumber, mathContext);

        then(result).isEqualByComparingTo(BigDecimal.valueOf(4));
    }

    @Test
    void executeShouldReturnMinus4() {

        final String givenFirstNumber = "2";
        final String givenSecondNumber = "-2";

        final BigDecimal result = tested.execute(givenFirstNumber, givenSecondNumber, mathContext);

        then(result).isEqualByComparingTo(BigDecimal.valueOf(-4));
    }

    @Test
    void executeShouldReturn25ForTwoMinus5() {

        final String givenFirstNumber = "-5";
        final String givenSecondNumber = "-5";

        final BigDecimal result = tested.execute(givenFirstNumber, givenSecondNumber, mathContext);

        then(result).isEqualByComparingTo(BigDecimal.valueOf(25));
    }
}