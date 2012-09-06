

import static org.junit.Assert.*;
import it.mate.clothoxml.util.Config;

import org.junit.Test;

public class TestXmlUtil {

	@Test
	public void testConfig(){
		assertEquals("/Users/marco/JavaProjects/clotho/conf/CodeRules.xml",Config.getConfig("input.file"));
	}

}
