package pl.bgora.rpn.advanced;

import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

/**
 * Advanced Calculator.
 *
 * @author Bartłomiej Góra (bartlomiej.gora@gmail.com)
 */
public class AdvancedCalculator {

    private Map<String, AbstractRPNArithmeticFunction> functions;
    private RoundingMode roundingMode;

    AdvancedCalculator(RoundingMode mode, Map<String, AbstractRPNArithmeticFunction> functions) {
        this.functions = functions;

    }


    public static AdvancedCalculator createDefaultAdvancedCalculator() {
        Map<String, AbstractRPNArithmeticFunction> functions = new HashMap<String, AbstractRPNArithmeticFunction>();
        return new AdvancedCalculator(RoundingMode.HALF_EVEN, functions);
    }

}
