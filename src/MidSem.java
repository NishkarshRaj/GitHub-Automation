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
	}
	@Test(dataProvider = "getData",priority=1)
	public void Login(String username, String password) 
	{
		//Assertions
		str = driver.findElement(By.xpath("//*[@id=\"login\"]/form/div[1]/h1")).getText();
		Assert.assertTrue(str.contains("Sign"));
		str = driver.findElement(By.xpath("//*[@id=\"login\"]/form/div[4]/label[1]")).getText();
		Assert.assertTrue(str.contains("Username"));
		str = driver.findElement(By.xpath("//*[@id=\"login\"]/form/div[4]/label[2]")).getText();
		Assert.assertTrue(str.contains("Password"));
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"login\"]/form/div[4]/input[9]")).isEnabled());
				//Image check	/html/body/div[1]/div[2]/div/a/svg
		
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
	@Test(priority=2)
	public void CreateRepository()
	{
		//Assertions for Login Page
		str = driver.findElement(By.xpath("//*[@id=\"login\"]/form/div[1]/h1")).getText();
		Assert.assertTrue(str.contains("Sign"));
		str = driver.findElement(By.xpath("//*[@id=\"login\"]/form/div[4]/label[1]")).getText();
		Assert.assertTrue(str.contains("Username"));
		str = driver.findElement(By.xpath("//*[@id=\"login\"]/form/div[4]/label[2]")).getText();
		Assert.assertTrue(str.contains("Password"));
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"login\"]/form/div[4]/input[9]")).isEnabled());
		
		//Login
		element = driver.findElement(By.name("login"));
		element.sendKeys("nishkarshraj000@gmail.com");
		element = driver.findElement(By.name("password"));
		element.sendKeys("Nish123!@#");
		driver.findElement(By.name("commit")).click();
		
		//Homepage Assertions
		str = driver.findElement(By.xpath("//*[@id=\"login\"]/form/div[4]/label[2]")).getText();
		Assert.assertTrue(str.contains("Password"));
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"login\"]/form/div[4]/input[9]")).isEnabled());
		
		//Create Repository
		driver.findElement(By.xpath("/html/body/div[4]/div/aside[1]/div[2]/div[1]/div/h2/a")).click();		
		element = driver.findElement(By.xpath("//*[@id=\"repository_name\"]"));		
		element.sendKeys("Test Automation");
		driver.findElement(By.xpath("//*[@id=\"new_repository\"]/div[3]/button")).submit();	
	
		//Add Default file to make the repository forkable because empty repository cannot be forked
		driver.findElement(By.xpath("//*[@id=\"js-repo-pjax-container\"]/div[3]/div/div[1]/div[1]/p/a[1]")).click();
		//File name
		element = driver.findElement(By.xpath("//*[@id=\"js-repo-pjax-container\"]/div[3]/div/div/form[2]/div[1]/span/input"));		
		element.sendKeys("README.md");
		//Content
		element = driver.findElement(By.xpath("//*[@id=\"js-repo-pjax-container\"]/div[3]/div/div/form[2]/div[5]/div[2]/div/div[5]/div[1]/div/div/div/div[5]/div/pre"));		
		element.sendKeys("Default Content");
		driver.findElement(By.xpath("//*[@id=\"submit-file\"]")).click();				
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
