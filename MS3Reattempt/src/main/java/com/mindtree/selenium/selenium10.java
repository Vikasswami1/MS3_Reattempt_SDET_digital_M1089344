package com.mindtree.selenium;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.ui.Select;

public class selenium10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\drivers1\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//a[@href='/hovers']")).click();
		WebElement b=driver.findElement(By.xpath("//img[@src='/img/avatar-blank.jpg']"));
		Actions actions=new Actions(driver);
		actions.moveToElement(b).build().perform();
		String a=driver.findElement(By.xpath("//div[@class='figcaption']//h5")).getText();
		System.out.println(a);
		driver.navigate().back();
		
		driver.findElement(By.xpath("//a[@href='/checkboxes']")).click();
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.navigate().back();
		driver.findElement(By.xpath("//a[@href='/inputs']")).click();
		driver.findElement(By.xpath("//input[@type='number']")).sendKeys("1234");
		driver.navigate().back();
		
		driver.findElement(By.xpath("//a[@href='/dropdown']")).click();
		Select s= new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
		s.selectByVisibleText("Option 2");
		driver.navigate().back();
		
		driver.findElement(By.xpath("//a[@href='/upload']")).click();
		WebElement upload=driver.findElement(By.xpath("//input[@id='file-upload']"));
		upload.sendKeys("C:\\j\\jd.txt");
		driver.findElement(By.xpath("//input[@id='file-submit']")).click();
		driver.navigate().back();
		driver.navigate().back();
		
		driver.findElement(By.xpath("//a[@href='/tables']")).click();
		driver.navigate().back();
		
		driver.findElement(By.linkText("Key Presses")).click();
		driver.findElement(By.xpath("//input[@id='target']")).sendKeys(Keys.SHIFT);
		String c=driver.findElement(By.xpath("//p[@id='result']")).getText();
		System.out.println(c);
		driver.navigate().back();
		
		driver.findElement(By.xpath("//a[@href='/windows']")).click();
		driver.findElement(By.xpath("//a[@href='/windows/new']")).click();
		Set<String>ids=driver.getWindowHandles();
		Iterator<String> it=ids.iterator();
		String pid=it.next();
		String cid=it.next();
		driver.switchTo().window(cid);
        System.out.println(driver.getTitle());
        driver.switchTo().window(pid);
        driver.navigate().back();
        
        driver.findElement(By.linkText("Context Menu")).click();
        WebElement d=driver.findElement(By.xpath("//div[@id='hot-spot']"));
        actions.contextClick(d).perform();
        driver.switchTo().alert().accept();
        
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	
		
	}


