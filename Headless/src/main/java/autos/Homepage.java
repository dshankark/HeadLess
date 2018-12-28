package autos;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;


@Test
public class Homepage extends Browserbase{
	private static Logger logs=LogManager.getLogger(Logger.class.getName());

	public void home() throws IOException, Exception {
				
		Readobject ro=new Readobject();
		Properties P=ro.getObjectRepository();
		driver= initializeDriver(P);
		
		logs.info("driver intialized");
		String ur=P.getProperty("url");
		driver.get(ur);
		driver.manage().window().maximize();
		Lander lp= new Lander(driver);
		lp.landing(P);
		logs.info("Lander executed successfully");
		lp.getScreenshot();
		

	}
}
