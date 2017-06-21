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

package com.github.rpnlibrary.factory;

import com.github.rpnlibrary.CalculatorInterface;

/**
 * AbstractCalculatorFactory.
 * <p>
 * It's subclasses are used do provide CalculatorInterace implementations
 *
 * @author Bartłomiej Góra (bartlomiej.gora@gmail.com)
 * @see CalculatorInterface
 */

public abstract class AbstractCalculatorFactory {

    /**
     * Creates Calculator
     * @return an CalculatorInterface instance
     */
    public abstract CalculatorInterface createCalulator();
}
