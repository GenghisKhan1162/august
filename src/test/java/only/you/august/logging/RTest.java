package only.you.august.logging;

import org.junit.Ignore;
import org.junit.Test;

import only.you.august.logging.a.A;
import only.you.august.logging.b.B;
import only.you.august.logging.b.c.C;

public class RTest {

	// should be logged in target/logging-testo.log
	@Ignore
	@Test
	public void ShouldBeLoggedInLoggingTesto() {		
		new R();
    	new A();
    	new B();
    	new C();
	}

}
