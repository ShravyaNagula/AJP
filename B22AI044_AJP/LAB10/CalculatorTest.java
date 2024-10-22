import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;
import org.junit.After;
public class CalculatorTest{
	private Calculator objCalcUnderTest;
	@Before
	public void setUp(){
		objCalcUnderTest = new Calculator();
	}
	@Test
	public void testAdd(){
		int a = 15, b = 20, expectedResult = 35;
		long result = objCalcUnderTest.add(a, b);
		Assert.assertEquals(expectedResult, result);;
	}
	@Test
	public void testSubtract(){
		int a = 25, b = 20, expectedResult = 5;
		long result = objCalcUnderTest.subtract(a, b);
		Assert.assertEquals(expectedResult, result);;
	}
	@Test
	public void testMultiply(){
		int a = 10, b = 25;
		long expectedResult = 250;
		long result = objCalcUnderTest.multiply(a, b);
		Assert.assertEquals(expectedResult, result);;
	}
	@After
	public void tearDown(){
		objCalcUnderTest = null;
	}
}
