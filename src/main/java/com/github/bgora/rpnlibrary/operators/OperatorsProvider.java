package com.github.bgora.rpnlibrary.operators;

import java.util.Map;

public interface OperatorsProvider {

    Map<String, AbstractOperatorStrategy> getOperators();
}
