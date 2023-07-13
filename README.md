# RPNLibrary

Simple RPN (Reverse Polish Notation) Library for Java.<br>
It is based on Dijkstra Algorithm. (https://en.wikipedia.org/wiki/Reverse_Polish_notation)

[![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=bartgora_RPNLibrary&metric=reliability_rating)](https://sonarcloud.io/summary/new_code?id=bartgora_RPNLibrary)

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.bartlomiej-gora/RPNLibrary/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.bartlomiej-gora/RPNLibrary)

[![javadoc](https://javadoc.io/badge2/com.github.bartlomiej-gora/RPNLibrary/javadoc.svg)](https://javadoc.io/doc/com.github.bartlomiej-gora/RPNLibrary)

Story
===
Couple years ago I read Joshua Bloch's "Java. Effective Programming".
I wanted to practice what I've learned.
I didn't want to create another CRUD like application, so I found that Dijkstra's algorithm would be good 
to learn design patterns, and effective programming.
First version's were available on Sourceforge.
Couple years later I manage to publish my library on maven cetral repo.
Over the years I built a small ecosystem around this library.
Feel free to check my other projects that use this one.
  
 
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

Maven:
===
```
        <dependency>
            <groupId>com.github.bartlomiej-gora</groupId>
            <artifactId>RPNLibrary</artifactId>
            <version>5.0.0</version>
        </dependency>
```



