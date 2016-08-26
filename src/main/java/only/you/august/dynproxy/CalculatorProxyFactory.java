package only.you.august.dynproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import only.you.august.logging.a.A;

public class CalculatorProxyFactory {	
	
	public static ICalculator createProxy(ICalculator source)
	{
		return  (ICalculator) Proxy.newProxyInstance(
				ICalculator.class.getClassLoader(),
                new Class[] { ICalculator.class },
                new CalculatorInvocationHandler(source));
	}
	
	private static class CalculatorInvocationHandler implements InvocationHandler{
		
		private static final Logger _logger = LogManager.getLogger(CalculatorInvocationHandler.class);
		
		private ICalculator _source;

		public CalculatorInvocationHandler(ICalculator source) {
			this._source = source;
		}

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			String msg = String.format("Called method '%s' with arguments: %s", method.getName(), Arrays.toString(args));
			_logger.log(Level.INFO, msg);
			return method.invoke(_source, args);
		}
		
	}
}
