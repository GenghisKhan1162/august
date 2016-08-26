package only.you.august.logging.a;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class A {

	private static final Logger _logger = LogManager.getLogger(A.class);

	public A() {
		_logger.log(Level.TRACE, "TRACE in A");
		_logger.log(Level.DEBUG, "DEBUG in A");
		_logger.log(Level.INFO, "INFO in A");
		_logger.log(Level.WARN, "WARN in A");
		_logger.log(Level.ERROR, "ERROR in A");
		_logger.log(Level.FATAL, "FATAL in A");
	}
}