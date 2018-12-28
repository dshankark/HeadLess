package autos;



import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Lander{

	private static Logger logs=LogManager.getLogger(Logger.class.getName());
	public WebDriver driver;
	By login =By.cssSelector("[href*='sign_in']");



	public Lander(WebDriver driver) {


		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public void landing(Properties p) {
		// TODO Auto-generated method stub

		WebDriverWait ww=new WebDriverWait(driver,30);

		ww.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(p.getProperty("homesrchbt"))));
		logs.info("Element button found");
		driver.findElement(By.xpath(p.getProperty("homefrmloc"))).sendKeys("Chennai");
		driver.findElement(By.xpath(p.getProperty("hometoloc"))).sendKeys("madurai");
		driver.findElement(By.xpath(p.getProperty("homedepdt"))).click();
		driver.findElement(By.xpath(p.getProperty("homedt"))).click();

		Select drpdnadult=new Select(driver.findElement(By.name("adults")));
		drpdnadult.selectByIndex(2);
		driver.findElement(By.xpath(p.getProperty("homesrchbt"))).click();;

	}



	@Test
	public void getScreenshot() throws IOException, InvalidFormatException, HeadlessException, AWTException {
		//	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//	FileUtils.copyFile(src, new File("C:\\ss\\ss.png"));	



		FileOutputStream fos = new FileOutputStream(new File("C:\\ss\\Screenshot.docx"));
		XWPFDocument document = new XWPFDocument();
		XWPFParagraph p= document.createParagraph();
		XWPFRun r = p.createRun();
		String screenshot_name = System.currentTimeMillis() + ".png";
		BufferedImage image = new Robot()
				.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		File file = new File("c:\\ss\\" + screenshot_name);
		ImageIO.write(image, "png", file);
		InputStream pic = new FileInputStream("c:\\ss\\" + screenshot_name);
		r.addBreak();

		r.addPicture(pic, document.PICTURE_TYPE_PNG,screenshot_name, Units.toEMU(350), Units.toEMU(350));

		document.write(fos);
		pic.close();
		file.delete();

		fos.flush();
		fos.close();





	}
}




