package midsem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class CreateRepository 
{
	public static void main(String [] args)
	{
		System.setProperty("webdriver.chrome.driver", "D:\\UPES DevOps\\DevOps Sem 6\\Test Automation\\Softwares\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.navigate().to("https://github.com/login");
		driver.manage().window().maximize();
		WebElement element; 
		element = driver.findElement(By.name("login"));
		element.sendKeys("nishkarshraj000@gmail.com");
		element = driver.findElement(By.name("password"));
		element.sendKeys("Nish123!@#");
		driver.findElement(By.name("commit")).click();
		
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
}
