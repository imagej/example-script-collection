import static org.junit.Assert.assertEquals;

import java.util.concurrent.ExecutionException;

import net.imagej.ImageJService;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.scijava.Context;
import org.scijava.module.Module;
import org.scijava.module.ModuleInfo;
import org.scijava.module.ModuleService;
import org.scijava.service.SciJavaService;

import io.scif.SCIFIOService;

public class ScriptTest {

	private Context context;

	@Before
	public void initialize() {
		context = new Context(SciJavaService.class, ImageJService.class, SCIFIOService.class);
	}

	@After
	public void disposeContext() {
		if (context != null) {
			context.dispose();
			context = null;
		}
	}

	@SuppressWarnings("null")
	@Test
	public void testScriptOutput() {
		String testString = "Hello World!";

		// ScriptService scriptService = context.getService(ScriptService.class);
		ModuleService moduleService = context.getService(ModuleService.class);
		ModuleInfo info = moduleService.getModuleById("script:Help/Examples/Convert_to_Lower_Case.groovy");
		Module module = null;
		try {
			module = moduleService.run(info, false, "input", testString).get();
		} catch (InterruptedException | ExecutionException exc) {
			exc.printStackTrace();
		}
		assertEquals(testString.toLowerCase(), module.getOutput("output"));
	}

}
