package only.you.august.dynproxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

public class CalculatorImpl implements ICalculator {

	private Logger _log = LoggerFactory.getLogger( CalculatorImpl.class );
	
	private Marker _confidentialMarker = MarkerFactory.getMarker("CONFIDENTIAL");
	
	@Override
	public int add(int x, int y) {
		_log.warn(_confidentialMarker, "We are in CalculatorImpl::add");
		_log.warn("Called add method with arguments {} and {}", x, y);
		return x + y;
	}

	@Override
	public int multiply(int x, int y) {
		_log.debug(_confidentialMarker, "We are in CalculatorImpl::multiply");
		_log.warn("Called multiply method");
		return x * y;
	}

}
