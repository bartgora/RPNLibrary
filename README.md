# RPNLibrary

Simple RPN (Reverse Polish Notation) Library for Java.<br>
It is based on Dijkstra Algorithm. (https://en.wikipedia.org/wiki/Reverse_Polish_notation)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=bartgora_RPNLibrary&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=bartgora_RPNLibrary)

[![Codacy Badge](https://app.codacy.com/project/badge/Grade/b004cdd19ecf42b697db1a19a3ae82ec)](https://app.codacy.com/gh/bartgora/RPNLibrary/dashboard?utm_source=gh&utm_medium=referral&utm_content=&utm_campaign=Badge_grade)

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.bartlomiej-gora/RPNLibrary/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.bartlomiej-gora/RPNLibrary)

[![javadoc](https://javadoc.io/badge2/com.github.bartlomiej-gora/RPNLibrary/javadoc.svg)](https://javadoc.io/doc/com.github.bartlomiej-gora/RPNLibrary)

Available functions:
===
+,-,*,/ with (), power(^)
Sin, cos, tg, ctg,
min, max, fib

example: 
```java
        Calculator calc = Calculator.createCalulator();
        BigDecimal result = calc.calculate("2^3*(12/6)+18/3+5.0/2");
        BigDecimal result2 = calc.calculate("3.678^2");
        BigDecimal resultSin = calc.calculate("sin(2)");
        BigDecimal resultSin2 = calc.calculate("sin(1+1)")
        BigDecimal resultCtg = calc.calculate("ctg(-1.65091)");
        BigDecimal min = calc.calculate("min(10, 8) + 10");
```

To Customize use:
```java
static Calculator Calculator.Calculator createCalculator(RPNChecking checker, RPNExecuting executioner, final MathContext mathContext, final int scale); 
        
    }
```

Maven:
===
```
        <dependency>
            <groupId>com.github.bartlomiej-gora</groupId>
            <artifactId>RPNLibrary</artifactId>
            <version>4.0.0</version>
        </dependency>
```


Changelog:
====

### Version 4.0.0:

- Using big Decimal Math library (https://github.com/eobermuhlner/big-math)
- General refactoring.
- Added Javadoc

### Version 3.2.2:

- Changed internal calculation from BigDecimal to Double in DefaultCalculator implementation

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

<b>IMPORTANT:</b><br>
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



- Added package pl.bgora.rpn.advanced<br>
- Added AdvancedCalculatorFactory<br>


The advanced Calculator works with CalculationEngine, which uses strategy pattern to run.
please see:<br>
pl.bgora.rpn.AbstractOperatorStrategy<br>
pl.bgora.rpn.AbstractFunctionStrategy<br>

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



