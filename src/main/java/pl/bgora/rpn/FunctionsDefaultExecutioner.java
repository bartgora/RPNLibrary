package pl.bgora.rpn;

import java.math.BigDecimal;
import java.math.RoundingMode;

import pl.bgora.rpn.exceptions.NoSuchFunctionFound;
import pl.bgora.rpn.exceptions.WrongArgumentException;


class FunctionsDefaultExecutioner implements RPNExecuting {



	@Override
	public BigDecimal executeOperator(String operator, String var1, String var2, RoundingMode mode) throws WrongArgumentException {
		assert operator!= null : "Operator cannot be null!";
		if(operator.equals("+")){
			return add(var1, var2);
		}else if(operator.equals("-")){
			return sub(var1, var2);
		}else if(operator.equals("*")){
			return mull(var1,var2);
		}else if(operator.equals("/")){
			return div(var1, var2, mode);
		}else if(operator.equals("^")){
			return pow(var1, var2);
		}
		throw new WrongArgumentException("Unrecognized operator: " + operator);
	}

	private BigDecimal div(String var1, String var2, RoundingMode mode) {
		BigDecimal big1 = new BigDecimal(var1);
		BigDecimal big2 = new BigDecimal(var2);
		return big1.divide(big2, mode);
	}

	private BigDecimal mull(String var1, String var2) {
		BigDecimal big1 = new BigDecimal(var1);
		BigDecimal big2 = new BigDecimal(var2);
		return big1.multiply(big2);
	}

	private BigDecimal sub(String var1, String var2) {
		BigDecimal big1 = new BigDecimal(var1);
		BigDecimal big2 = new BigDecimal(var2);
		return big1.subtract(big2);
	}

	private BigDecimal add(String var1, String var2) {
		BigDecimal big1 = new BigDecimal(var1);
		BigDecimal big2 = new BigDecimal(var2);
		return big1.add(big2);
	}
	
	private BigDecimal pow(String var1, String var2) {
		BigDecimal big1 = new BigDecimal(var1);
		BigDecimal big2 = new BigDecimal(var2);
		return big1.pow(big2.intValue());
	}

	@Override
	public BigDecimal executeFunction(String functionName, RoundingMode mode, String... arguments)
			throws NoSuchFunctionFound {
		if("sin".equals(functionName)){
			BigDecimal dec = new BigDecimal(arguments[0]);
			return BigDecimal.valueOf(Math.sin(dec.doubleValue()));
		}else if("cos".equals(functionName)){
			BigDecimal dec = new BigDecimal(arguments[0]);
			return BigDecimal.valueOf(Math.cos(dec.doubleValue()));
		}else if("tg".equals(functionName)){
			BigDecimal dec = new BigDecimal(arguments[0]);
			return BigDecimal.valueOf(Math.tan(dec.doubleValue()));
		}else if("ctg".equals(functionName)){
			BigDecimal dec = new BigDecimal(arguments[0]);
			BigDecimal tan = BigDecimal.valueOf(Math.tan(dec.doubleValue()));
			BigDecimal one = new BigDecimal(1);
			return one.divide(tan);
		}
		throw new NoSuchFunctionFound("There is no function named " + functionName);

	}

}
