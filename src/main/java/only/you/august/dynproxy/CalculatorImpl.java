package only.you.august.dynproxy;

public class CalculatorImpl implements ICalculator {

	@Override
	public int add(int x, int y) {
		return x + y;
	}

	@Override
	public int multiply(int x, int y) {
		return x * y;
	}

}
