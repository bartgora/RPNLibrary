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

package com.github.rpnlibrary.advanced;

import com.github.rpnlibrary.CalculationEngine;
import com.github.rpnlibrary.CalculatorEngine;
import com.github.rpnlibrary.CalculatorInterface;
import com.github.rpnlibrary.factory.AbstractCalculatorFactory;

import java.math.RoundingMode;

/**
 * factory for AdvancedCalculator
 *
 * @author Bartłomiej Góra (bartlomiej.gora@gmail.com)
 */
public class AdvancedCalculatorFactory extends AbstractCalculatorFactory {

    public CalculatorInterface createCalulator() {
        CalculatorEngine engine = getDefaultEngine();
        return new AdvancedCalculator(RoundingMode.HALF_UP, engine);
    }

    /**
     * Creates AdvanceCalculator with given CalculatorEngine
     *
     * @param engine CalculatorEngine instance
     * @return AdvanceCalculator
     */
    public CalculatorInterface createCalulator(CalculationEngine engine) {
        return new AdvancedCalculator(RoundingMode.HALF_UP, engine);
    }


    /**
     * Return default CalculatorEngine
     *
     * @return CalculatorEngine
     */
    public CalculatorEngine getDefaultEngine() {
        return new CalculatorEngine(StrategiesUtil.DEFAULT_OPERATORS, StrategiesUtil.DEFAULT_FUNCTIONS);
    }

}
