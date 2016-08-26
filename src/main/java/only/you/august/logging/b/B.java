package only.you.august.logging.b;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class B {

	private static final Logger _logger = LogManager.getLogger(B.class);

	public B() {
		_logger.log(Level.TRACE, "TRACE in B");
		_logger.log(Level.DEBUG, "DEBUG in B");
		_logger.log(Level.INFO, "INFO in B");
		_logger.log(Level.WARN, "WARN in B");
		_logger.log(Level.ERROR, "ERROR in B");
		_logger.log(Level.FATAL, "FATAL in B");
	}
}