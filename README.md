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
<a href="https://www.codacy.com/app/bartlomiej.gora/RPNLibrary?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=bartlomiej-gora/RPNLibrary&amp;utm_campaign=Badge_Grade"><img src="https://api.codacy.com/project/badge/Grade/94cbf471a20048989c9b066f6ad4d414"/></a>

Simple RPN Library for Java, just use Calculator.getCalculator() to get instance, 
and next calc.calculate(expression) to calulate.

functionalities:
+,-,*,/ with ()
Sin, cos, tg, ctg.

example: 

BigDecimal result = calc.calculate("2^3*(12/6)+18/3+5.0/2");


Version 3.1.0:



Added package pl.bgora.rpn.advanced
Added AdvancedCalculatorFactory

Maven:

```
        <dependency>
            <groupId>com.github.bartlomiej-gora</groupId>
            <artifactId>RPNLibrary</artifactId>
            <version>3.1.0</version>
        </dependency>
```

The advanced Calculator works with CalculationEngine, which uses strategy pattern to run.
please see:
AbstractOperatorStrategy
AbstractFunctionStrategy

Example 1:
===

```java
        AdvancedCalculatorFactory advancedCalculatorFactory = new AdvancedCalculatorFactory();
        calc = advancedCalculatorFactory.createCalulator();
```
Example 2:
===
Asume that you want to add a function max(number, number), which will return greater value, You will have to extend
AbstractFunctionStrategy like this:

```java
public class MaxFunctionStrategy extends AbstractFunctionStrategy {
    public MaxFunctionStrategy() {
        super("max", 2, RoundingMode.HALF_EVEN);
    }

    @Override
    public BigDecimal execute(String... params) {
        String first = params[0];
        String second = params[1];
        //do you calculation here
        return ///result;
    }
}
```

And then you can add your function like that:

```java
        CalculatorInterface calc;
        AdvancedCalculatorFactory advancedCalculatorFactory = new AdvancedCalculatorFactory();
        advancedCalculatorFactory.getDefaultEngine().addFunctionStartegy(new MaxFunctionStrategy());
        calc = advancedCalculatorFactory.createCalulator();
```

