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

import com.github.bgora.rpnlibrary.CalculationEngine;
import com.github.bgora.rpnlibrary.CalculatorEngine;
import com.github.bgora.rpnlibrary.CalculatorInterface;
import com.github.bgora.rpnlibrary.factory.AbstractCalculatorFactory;

import java.math.RoundingMode;

/**
 * factory for AdvancedCalculator
 *
 * @author Bartłomiej Góra (bartlomiej.gora@gmail.com)
 */
public class AdvancedCalculatorFactory extends AbstractCalculatorFactory {

    public CalculatorInterface createCalulator() {
        CalculationEngine engine = getDefaultEngine();
        return new AdvancedCalculator(RoundingMode.HALF_EVEN, engine);
    }

    /**
     * Creates AdvanceCalculator with given CalculatorEngine
     *
     * @param engine CalculationEngine implementation
     * @return AdvanceCalculator
     */
    public CalculatorInterface createCalulator(CalculationEngine engine) {
        return new AdvancedCalculator(RoundingMode.HALF_EVEN, engine);
    }


    /**
     * Return default CalculationEngine implementation
     *
     * @return CalculatorEngine
     */
    public CalculationEngine getDefaultEngine() {
        return new CalculatorEngine(StrategiesUtil.DEFAULT_OPERATORS, StrategiesUtil.DEFAULT_FUNCTIONS);
    }

}
