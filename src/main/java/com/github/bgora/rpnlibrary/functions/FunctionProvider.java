package com.github.bgora.rpnlibrary.functions;

import java.util.Map;

public interface FunctionProvider {

    Map<String, AbstractFunctionStrategy> getFunctions();
}
