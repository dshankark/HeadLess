package head;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
public class headLess {



	static protected WebDriver driver;

	@Test(enabled=false)
	public  void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Chrome\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		options.addArguments("window-size=1200x600");
		SoftAssert sf= new SoftAssert();
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		String tit= driver.getTitle();
		sf.assertEquals("Googl", tit);
		System.out.println("First Test method");
		sf.assertAll();
		driver.close();
	}

	@Test
	public void temp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Chrome\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		options.addArguments("window-size=1200x600");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.google.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait= new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Gmail')]")));
		Actions action=new Actions(driver);
		WebElement we= driver.findElement(By.xpath("//a[contains(text(),'Gmail')]"));
		action.moveToElement(we).click().build().perform();
		WebElement img= driver.findElement(By.xpath("//div[contains(normalize-spaces(@class),'J-KU J-KU-KO')]"));
		Boolean tf=img.isDisplayed();
		if(tf==true) {
			System.out.println("Element is displayed");
		}
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//		wait.until(ExpectedConditions.titleContains("Gmail"));
		String tit1= driver.getTitle();
		try {
			Assert.assertEquals("Gmai", tit1);
		}catch(Exception e) {
			System.out.println("error e is "+e);
		}
		System.out.println("Nxt Test method 2 statement");
		driver.close();
	}
	@Test
	public void ten() {

		System.out.println("3rd method printing");
	}
}


