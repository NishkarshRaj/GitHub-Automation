package midsem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Login 
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
	}
}
