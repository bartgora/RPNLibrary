/*
    RPNCalculator - Reverse Polish Notation mathematics Library
    Copyright (C) 2011  Bartłomiej "Black007" Góra

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package pl.bgora.rpn.exceptions;

/**
 * Describes wrong input.
 * <p/>
 * This Exception describes situation, when input string is in wrong format.
 * This occurs when for instance user put unrecognized char into input string.
 *
 * @author Bartłomiej Góra (bartlomiej.gora@gmail.com)
 * @serial
 */
public class WrongArgumentException extends RPNException {


    private static final long serialVersionUID = 8945842987018146049L;

    public WrongArgumentException() {
        super();
    }

    public WrongArgumentException(String message) {
        super(message);
    }
}
