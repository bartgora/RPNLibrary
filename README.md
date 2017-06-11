    RPNCalculator - Reverse Polish Notation mathematics Library
    Copyright (C) 2011  Bartłomiej Góra

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
    Contact: bartlomiej.gora@gmail.com


# RPNLibrary
<a href="https://travis-ci.org/bartlomiej-gora/RPNLibrary">
<img alt="build:passed" src="https://travis-ci.org/bartlomiej-gora/RPNLibrary.svg">
</a>

Simple RPN Library for Java, just use Calculator.getCalculator() to get instance, 
and next calc.calculate(expression) to calulate.

functionalities:
+,-,*,/ with ()
Sin, cos, tg, ctg.

example: 

BigDecimal result = calc.calculate("2^3*(12/6)+18/3+5.0/2");


