Changelog:
====

## [5.0.0]

### Changed
- Moved to java 8
- Refactoring, split Calculator class into smaller pieces, using java 8 functional interfaces

### Added
- Added tests written in Kotest:

example:
```kotlin
class RPNFactoryTest : FreeSpec({

    val tested = RPNFactory(RPNChecker(DefaultStrategyProvider()))
            "should Return RPN" - {
                val text = "( 2 + 3 ) * 5"
                val result = tested.apply(text)
                result shouldBe "2 3 + 5 *"
            }
            "should Return RPN for Function call" - {
                val text = "sin ( 1 )"
                val result = tested.apply(text)
                result shouldBe "1 sin"
            }
            "should Return RPN for Function and equation" - {
                val text = "sin ( 1 ) + 27 * 8"
                val result = tested.apply(text)
                result shouldBe "1 sin 27 8 * +"
            }
            "should Return RPN for  two Functions call" - {
                val text = "sin ( 1 ) + ctg ( 0 )"
                val result = tested.apply(text)
                result shouldBe "1 sin 0 ctg +"
            }
})
```

## [4.0.0]

### Changed
- Using big Decimal Math library (https://github.com/eobermuhlner/big-math)
- General refactoring.
- Added Javadoc

## [3.2.2]

### Changed

- Changed internal calculation from BigDecimal to Double in DefaultCalculator implementation

##  [3.2.1]

### Fixed
- Fixed bug in divide operator, that caused:
  ex: "10/4 = 2, and not 2.5",
  "5/2 = 2, and not 2.5"

### Changed
- Changed RoundinMode from HALF_UP, to HALF_EVEN
- Changed internal calculation type from BigDecimal to Double

##  [3.2.0]
### Changed

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

## [3.1.0]

### Added

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


