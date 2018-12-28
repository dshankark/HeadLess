package autos;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Readobject {

	public Properties getObjectRepository() throws IOException {
		
		Properties prop =new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Shankar Kumar\\eclipse-workspace\\Headless\\src\\main\\java\\resources\\globalData.properties");
		prop.load(fis);
		return prop;
		
		
	}
}
