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

package com.github.bgora.rpnlibrary.advanced;

import com.github.bgora.rpnlibrary.advanced.functions.AbstractFunctionStrategy;
import com.github.bgora.rpnlibrary.advanced.functions.CosinusFunctionStrategy;
import com.github.bgora.rpnlibrary.advanced.functions.CtgFunctionStrategy;
import com.github.bgora.rpnlibrary.advanced.functions.FibFunctionStrategy;
import com.github.bgora.rpnlibrary.advanced.functions.MaxFunctionStrategy;
import com.github.bgora.rpnlibrary.advanced.functions.MinFunctionStrategy;
import com.github.bgora.rpnlibrary.advanced.functions.SinusFunctionStrategy;
import com.github.bgora.rpnlibrary.advanced.functions.TanFunctionStrategy;
import com.github.bgora.rpnlibrary.advanced.operators.AbstractOperatorStrategy;
import com.github.bgora.rpnlibrary.advanced.operators.AddOperatorStrategy;
import com.github.bgora.rpnlibrary.advanced.operators.DivideOperatorStrategy;
import com.github.bgora.rpnlibrary.advanced.operators.MiltiplyOperatorStrategy;
import com.github.bgora.rpnlibrary.advanced.operators.MinusOperatorStrategy;
import com.github.bgora.rpnlibrary.advanced.operators.PowerOperatorStrategy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Utility class for Default Strategies.
 *
 * @author Bartłomiej Góra (bartlomiej.gora@gmail.com)
 */
public final class StrategiesUtil {
    /**
     * Default arithmetic operators
     */
    public static Map<String, AbstractOperatorStrategy> DEFAULT_OPERATORS = new ConcurrentHashMap<String, AbstractOperatorStrategy>();
    /**
     * Default Arithmetic functions
     */
    public static Map<String, AbstractFunctionStrategy> DEFAULT_FUNCTIONS = new ConcurrentHashMap<String, AbstractFunctionStrategy>();

    static {
        AbstractFunctionStrategy sinusFunctionStrategy = new SinusFunctionStrategy();
        DEFAULT_FUNCTIONS.put(sinusFunctionStrategy.getName(), sinusFunctionStrategy);
        AbstractFunctionStrategy cosinusFunctionStrategy = new CosinusFunctionStrategy();
        DEFAULT_FUNCTIONS.put(cosinusFunctionStrategy.getName(), cosinusFunctionStrategy);
        AbstractFunctionStrategy tanFunctionStrategy = new TanFunctionStrategy();
        DEFAULT_FUNCTIONS.put(tanFunctionStrategy.getName(), tanFunctionStrategy);
        AbstractFunctionStrategy ctgFunctionStrategy = new CtgFunctionStrategy();
        DEFAULT_FUNCTIONS.put(ctgFunctionStrategy.getName(), ctgFunctionStrategy);
        AbstractFunctionStrategy maxFunctionStrategy = new MaxFunctionStrategy();
        DEFAULT_FUNCTIONS.put(maxFunctionStrategy.getName(), maxFunctionStrategy);
        AbstractFunctionStrategy minFunctionStrategy = new MinFunctionStrategy();
        DEFAULT_FUNCTIONS.put(minFunctionStrategy.getName(), minFunctionStrategy);
        AbstractFunctionStrategy fibFunctionStrategy = new FibFunctionStrategy();
        DEFAULT_FUNCTIONS.put(fibFunctionStrategy.getName(), fibFunctionStrategy);

        AbstractOperatorStrategy addOperatorStrategy = new AddOperatorStrategy();
        DEFAULT_OPERATORS.put(addOperatorStrategy.getOperator(), addOperatorStrategy);
        AbstractOperatorStrategy minusOperatorStrategy = new MinusOperatorStrategy();
        DEFAULT_OPERATORS.put(minusOperatorStrategy.getOperator(), minusOperatorStrategy);
        AbstractOperatorStrategy miltiplyOperatorStrategy = new MiltiplyOperatorStrategy();
        DEFAULT_OPERATORS.put(miltiplyOperatorStrategy.getOperator(), miltiplyOperatorStrategy);
        AbstractOperatorStrategy divideOperatorStrategy = new DivideOperatorStrategy();
        DEFAULT_OPERATORS.put(divideOperatorStrategy.getOperator(), divideOperatorStrategy);
        AbstractOperatorStrategy powerOperatorStrategy = new PowerOperatorStrategy();
        DEFAULT_OPERATORS.put(powerOperatorStrategy.getOperator(), powerOperatorStrategy);

    }


    private StrategiesUtil() {

    }
}
