package only.you.august.logging;

import static org.junit.Assert.*;

import org.junit.Test;

import only.you.august.logging.a.A;
import only.you.august.logging.b.B;
import only.you.august.logging.b.c.C;

public class RTest {

	@Test
	public void test() {
		// should log in target/logging-testo.log
		new R();
    	new A();
    	new B();
    	new C();
	}

}
