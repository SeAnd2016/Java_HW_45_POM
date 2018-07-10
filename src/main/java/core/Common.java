package core;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Common implements id {
	
    static WebDriver driver;
	
	public static void open(String url) {
        Logger.getLogger("").setLevel(Level.OFF);
        driver = new HtmlUnitDriver();
        ((HtmlUnitDriver) driver).setJavascriptEnabled(true);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(url);
        System.out.println("Page URL: " + driver.getCurrentUrl());
        System.out.println("UserAgent: " +
        (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;" ));}

 public static boolean isPresent(By by) {
        if (driver.findElements(by).size() > 0) return true;
        else return false;}

 public static boolean isVisible(By by) {
        if ((driver.findElements(by).size() > 0) && driver.findElement(by).isDisplayed()) return true;
        else return false;}
 
	public static void quite() {
		driver.quit();
	}
	
	public static void pageValidation(String test_case, By el) {
		System.out.println(test_case +	(Common.isPresent(el) ? "Exists" : "Not exist")); 
}
	public static void pageValidationIsVisible(String test_case, By el) {
		System.out.println(test_case +	(Common.isVisible(el) ? "Visible" : " Not visible")); 
}
}