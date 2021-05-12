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

import com.github.bgora.rpnlibrary.RPNChecking;
import com.github.bgora.rpnlibrary.RPNExecuting;
import com.github.bgora.rpnlibrary.exceptions.NoSuchFunctionFound;
import com.github.bgora.rpnlibrary.exceptions.WrongArgumentException;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Optional;
import java.util.function.Function;

/**
 * RPN Calculator Implementation with functions.
 * This Implementation uses Dijkstra Algorithm to create Reverse Polish Notation.
 *
 * @author Bartłomiej Góra (bartlomiej.gora@gmail.com)
 */
public class Calculator {

    protected final Function<String, String> transformer;
    protected final Function<String, String> rpnFactory;
    protected final Function<String, BigDecimal> rpnCalculator;
    private final MathContext mathContext;
    private final int SCALE;

    /**
     * Factory method for RPN Calculator object with custom functions, and
     * operations. You should use this factory method if you want to create your
     * own operations. To do so, you have to implement you own objects, that
     * implementas {@code RPNChecking}, and
     * {@code RPNExecuting}.
     *
     * @return new Instance of {@code pl.bgora.Calculator}
     * @see RPNChecking
     * @see RPNExecuting
     */
    public static Calculator createCalculator() {
        final MathContext mathContext = MathContext.DECIMAL64;
        final StrategyProvider strategyProvider = new DefaultStrategyProvider();
        final com.github.bgora.rpnlibrary.next.RPNChecking rpnChecking = new RPNChecker(strategyProvider);
        final com.github.bgora.rpnlibrary.next.RPNExecuting rpnExecuting = new DefaultRPNExecutor(strategyProvider);
        return new Calculator(
                new InputTransformer(rpnChecking),
                new RPNFactory(rpnChecking),
                new RPNCalculator(2,rpnChecking, rpnExecuting, mathContext)
                , mathContext, 2);
    }

    /**
     * Factory method for RPN Calculator object with custom functions, and
     * operations. You should use this factory method if you want to create your
     * own operations. To do so, you have to implement you own objects, that
     * implementas {@code RPNChecking}, and
     * {@code RPNExecuting}.
     * .
     *
     * @param mathContext MathContext - Set Rounding Mode, and precision
     * @param scale       scale number of digits after .
     * @return new Instance of {@code pl.bgora.Calculator}
     * @see RPNChecking
     * @see RPNExecuting
     */

    public static Calculator createCalculator(Function<String, String> transformer,
                                              Function<String, String> rpnFactory,
                                              Function<String, BigDecimal> rpnCalculator,
                                              final MathContext mathContext,
                                              final int scale) {
        return new Calculator(transformer, rpnFactory, rpnCalculator, mathContext, scale);
    }

    /**
     * Constructor Creates an instance of the class.
     *
     * @param transformer
     * @param rpnFactory
     * @param rpnCalculator
     * @param mathContext
     * @param scale
     */
    private Calculator(final Function<String, String> transformer, final Function<String, String> rpnFactory, final Function<String, BigDecimal> rpnCalculator, final MathContext mathContext, final int scale) {
        this.transformer = transformer;
        this.rpnFactory = rpnFactory;
        this.rpnCalculator = rpnCalculator;
        this.mathContext = mathContext;
        this.SCALE = scale;
    }

    public BigDecimal calculate(final String input) throws WrongArgumentException, NoSuchFunctionFound {
        return Optional.of(input)
                .map(transformer)
                .map(rpnFactory)
                .map(rpnCalculator)
                .orElseThrow(()->new WrongArgumentException("Incorrect input"));
    }


    public MathContext getMathContext() {
        return new MathContext(mathContext.getPrecision(), mathContext.getRoundingMode());
    }
}
