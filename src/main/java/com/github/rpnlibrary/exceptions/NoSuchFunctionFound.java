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

package com.github.rpnlibrary.exceptions;

/**
 * Describes wrong function name.
 * <p>
 * This Exception is thrown when user put wrong name of the function to input string.
 *
 * @author Bartłomiej Góra (bartlomiej.gora@gmail.com)
 * @serial
 */
public class NoSuchFunctionFound extends RPNException {


    /**
     * <code>serialVersionUID</code> -
     */
    private static final long serialVersionUID = 2721403205060626078L;

    public NoSuchFunctionFound() {
        super();
    }

    public NoSuchFunctionFound(String message) {
        super(message);
    }
}
