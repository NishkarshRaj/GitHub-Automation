package midsem;

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

public class RepoHomeAssert {
  @Test
  public void f() 
  {
		System.setProperty("webdriver.chrome.driver", "D:\\UPES DevOps\\DevOps Sem 6\\Test Automation\\Softwares\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.navigate().to("https://github.com/login");
		driver.manage().window().maximize();
		WebElement element; 
		
		
		//Login
		element = driver.findElement(By.name("login"));
		element.sendKeys("nishkarshraj000@gmail.com");
		element = driver.findElement(By.name("password"));
		element.sendKeys("Nish123!@#");
		driver.findElement(By.name("commit")).click();
		driver.navigate().to("https://github.com/Nishkarsh007/Test-Automation");
		
		//Assertions
		String str;
		str = driver.findElement(By.xpath("//*[@id=\"js-repo-pjax-container\"]/div[2]/nav/span[1]/a/span")).getText();
		Assert.assertTrue(str.contains("Code"));
		str = driver.findElement(By.xpath("//*[@id=\"js-repo-pjax-container\"]/div[2]/nav/span[2]/a/span[1]")).getText();
		Assert.assertTrue(str.contains("Issues"));
		str = driver.findElement(By.xpath("//*[@id=\"js-repo-pjax-container\"]/div[2]/nav/span[3]/a/span[1]")).getText();
		Assert.assertTrue(str.contains("Pull"));
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"js-repo-pjax-container\"]/div[2]/div/ul/li[2]/div/form[2]/button")).isEnabled());
  }
}
