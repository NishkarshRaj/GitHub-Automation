package midsem;

//Import the required packages
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MidSem 
{
	public static String str;
	public static WebDriver driver;
	public static WebElement element;
	
	@BeforeSuite
	public void Setup_Drivers()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\UPES DevOps\\DevOps Sem 6\\Test Automation\\Softwares\\chromedriver.exe");		
	}
	
	//Before Method because it repeats as many times as the Test Cases
	@BeforeMethod
	public void Visit_GitHub()
	{
		driver = new ChromeDriver();
		driver.navigate().to("https://github.com/login");
		driver.manage().window().maximize();
		/*
		//Assertions
		str = driver.findElement(By.xpath("//*[@id=\"ap_register_form\"]/div/div/h1")).getText();
		Assert.assertTrue(str.contains("Create"));
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"continue\"]")).isEnabled());
		str = driver.findElement(By.xpath("//*[@id=\"ap_register_form\"]/div/div/div[2]/div/label")).getText();
		Assert.assertTrue(str.contains("Mobile"));
		str = driver.findElement(By.xpath("//*[@id=\"ap_register_form\"]/div/div/div[3]/div/label")).getText();
		Assert.assertTrue(str.contains("Email"));
		str = driver.findElement(By.xpath("//*[@id=\"ap_register_form\"]/div/div/div[4]/div/label")).getText();
		Assert.assertTrue(str.contains("Password"));
		*/
	}
	@Test(dataProvider = "getData")
	public void Login(String username, String password) 
	{
		element = driver.findElement(By.name("login"));
		element.sendKeys(username);
		element = driver.findElement(By.name("password"));
		element.sendKeys(password);
		driver.findElement(By.name("commit")).click();
	}
	@DataProvider(name="getData")
	public Object[][] getData(){
	Object[][] obj = new Object[3][2];
	obj[0][0] = "nishkarshraj000@gmail.com";
	obj[0][1] = "Nish123!@#";
	obj[1][0] = "MeghaRawat3";
	obj[1][1] = "Megh4@123";
	obj[2][0] = "raj123khare@gmail.com";
	obj[2][1] = "Ni$hkar$H3";
	return obj;
	}
  @AfterMethod
 	public void Destructor()
 	{
	  //Delete the current session
	  driver.quit();
 	}
  @AfterSuite
	public void Completion()
	{
		System.out.println("All test cases completed");
	}
}
