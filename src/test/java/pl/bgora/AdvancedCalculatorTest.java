package pl.bgora;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;

import pl.bgora.rpn.advanced.AdvancedCalculatorFactory;

/**
 * 
 * 
 * @author Bartłomiej Góra (Black007pl@gmail.com)
 *
 */
public class AdvancedCalculatorTest {

	@Test
	public void testGetFactoryInstance() {
		AdvancedCalculatorFactory factory = AdvancedCalculatorFactory.getFactoryInstance();
		assertNotNull(factory);
	}

	@Test
	public void testAddFunction() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddFunctions() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateNewAdvancedCalculator() {
		fail("Not yet implemented");
	}

}
