package only.you.august.dynproxy;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorProxyFactoryTest {

	@Test
	public void test() {
		ICalculator calculator = new CalculatorImpl();
		ICalculator proxy = CalculatorProxyFactory.createProxy(calculator);
		assertNotSame("Proxy shouldn't be same as source", calculator, proxy);
		assertEquals("Proxy should add correctly", 10, proxy.add(7, 3));
		assertEquals("Proxy should multiply correctly", 56, proxy.multiply(7, 8));
	}
}
