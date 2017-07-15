    RPNLibrary - Reverse Polish Notation Library
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
<img src="https://travis-ci.org/bartlomiej-gora/RPNLibrary.svg?branch=master">
</a>
<a href="https://www.codacy.com/app/bartlomiej.gora/RPNLibrary?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=bartlomiej-gora/RPNLibrary&amp;utm_campaign=Badge_Grade">
<img src="https://api.codacy.com/project/badge/Grade/94cbf471a20048989c9b066f6ad4d414"/></a>
<a href="https://www.codacy.com/app/bartlomiej.gora/RPNLibrary?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=bartlomiej-gora/RPNLibrary&amp;utm_campaign=Badge_Coverage"><img src="https://api.codacy.com/project/badge/Coverage/94cbf471a20048989c9b066f6ad4d414"/></a>

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.bartlomiej-gora/RPNLibrary/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.bartlomiej-gora/RPNLibrary)


Description:
===
Simple RPN (Reverse Polish Notation) Library for Java.<br>
It is based on Dijkstra Algorithm. (https://en.wikipedia.org/wiki/Reverse_Polish_notation)



functionalities:
+,-,*,/ with ()
Sin, cos, tg, ctg.

example: 
```java
Calculator calc = Calculator.createDefaultCalculator();
BigDecimal result = calc.calculate("2^3*(12/6)+18/3+5.0/2");
```


Maven:
===
```
        <dependency>
            <groupId>com.github.bartlomiej-gora</groupId>
            <artifactId>RPNLibrary</artifactId>
            <version>3.2.1-SNAPSHOT</version>
        </dependency>
```


Changelog:
====

### Version 3.2.1:

- Fixed bug in divide operator, that caused:
 ex: "10/4 = 2, and not 2.5",
 "5/2 = 2, and not 2.5"
- Changed RoundinMode from HALF_UP, to HALF_EVEN
- Changed internal calculation type from BigDecimal to Double

### Version 3.2.1-SNAPSHOT:

- Fixed bug in divide operator, that caused:
 ex: "10/4 = 2, and not 2.5",
 "5/2 = 2, and not 2.5"
- Changed RoundinMode from HALF_UP, to HALF_EVEN
- Changed internal calculation type from BigDecimal to Double

### Version 3.2.0:

<b>IMPORTANT:</b></br>
Changed package names from
```java
    pl.bgora.rpn
```
 to 
 ```java
 com.github.bgora.rpnlibrary
 ```
  
  <b>Fixed bug, that prevented from exucuting functions with multiple parameters.</b>
  
  <b>New functions:</b></br>
  max() - takes two parameters, returns greater one</br>
  min() - take two parameters, returns less one</br>
  fib() - Fibonacci number</br>
  
  <b>Refactor:</b>
  
  Changed <i>createCalulator</i>, and <i> getDefaultEngine</i> to use <i>CalculationEngine</i> interface
  
```java
    /**
     * Creates AdvanceCalculator with given CalculatorEngine
     *
     * @param engine CalculationEngine implementation
     * @return AdvanceCalculator
     */
    public CalculatorInterface createCalulator(CalculationEngine engine) {
        return new AdvancedCalculator(RoundingMode.HALF_UP, engine);
    }


    /**
     * Return default CalculationEngine implementation
     *
     * @return CalculatorEngine
     */
    public CalculationEngine getDefaultEngine() {
        return new CalculatorEngine(StrategiesUtil.DEFAULT_OPERATORS, StrategiesUtil.DEFAULT_FUNCTIONS);
    }
```

### Version 3.1.0:



- Added package pl.bgora.rpn.advanced</br>
- Added AdvancedCalculatorFactory</br>


The advanced Calculator works with CalculationEngine, which uses strategy pattern to run.
please see:</br>
pl.bgora.rpn.AbstractOperatorStrategy</br>
pl.bgora.rpn.AbstractFunctionStrategy</br>

### Example 1:


```java
        AdvancedCalculatorFactory advancedCalculatorFactory = new AdvancedCalculatorFactory();
        calc = advancedCalculatorFactory.createCalulator();
```

### Example 2:

Assume that you want to add a function sqrt(number), which will return The square root , You will have to extend
AbstractFunctionStrategy like this:

```java
public class SqrtFunctionStrategy extends AbstractFunctionStrategy {
    public SqrtFunctionStrategy() {
        super("sqrt", 1, RoundingMode.HALF_EVEN);
    }

    @Override
    public BigDecimal execute(String... params) {
        return java.math.BigDecimal.valueOf(Math.sqrt(x));
    }
}
```

And then you can add your function like that:

```java
        CalculatorInterface calc;
        AdvancedCalculatorFactory advancedCalculatorFactory = new AdvancedCalculatorFactory();
        CalculatorEngine engine = advancedCalculatorFactory.getDefaultEngine();
        engine.addFunctionStartegy(new SqrtFunctionStrategy());
        calc = advancedCalculatorFactory.createCalulator(engine);
```

### Example 3:
Assume that you want to add a function max(number, number), which will return greater value, You will have to extend
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
        BigDecimal result = //do you calculation here
        return result; //result;
    }
}
```

And then you can add your function like that:

```java
        CalculatorInterface calc;
        AdvancedCalculatorFactory advancedCalculatorFactory = new AdvancedCalculatorFactory();
        CalculatorEngine engine = advancedCalculatorFactory.getDefaultEngine();
        engine.addFunctionStartegy(new MaxFunctionStrategy());
        calc = advancedCalculatorFactory.createCalulator(engine);
```



