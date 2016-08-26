package only.you.august.logging.b.c;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class C {

	private static final Logger _logger = LogManager.getLogger(C.class);

	public C() {
		_logger.log(Level.TRACE, "TRACE in C");
		_logger.log(Level.DEBUG, "DEBUG in C");
		_logger.log(Level.INFO, "INFO in C");
		_logger.log(Level.WARN, "WARN in C");
		_logger.log(Level.ERROR, "ERROR in C");
		_logger.log(Level.FATAL, "FATAL in C");
	}
}