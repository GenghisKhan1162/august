package only.you.august.logging;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class R {
	
	private static final Logger _logger = LogManager.getLogger(R.class);

	public R() {
		_logger.log(Level.TRACE, "TRACE in R");
		_logger.log(Level.DEBUG, "DEBUG in R");
		_logger.log(Level.INFO, "INFO in R");
		_logger.log(Level.WARN, "WARN in R");
		_logger.log(Level.ERROR, "ERROR in R");
		_logger.log(Level.FATAL, "FATAL in R");
	}
	
	

}
