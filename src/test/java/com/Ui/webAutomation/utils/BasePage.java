package com.Ui.webAutomation.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

public class BasePage
{

    public WebDriver driver;
    public Wait<WebDriver> wait ;
    JavascriptExecutor js ;
    public BasePage(){
        WebDriverManager.chromedriver().setup();
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sujit\\Downloads\\chrome-win64 (1)\\chrome-win64\\chrome.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();

    }

    public void waitForElementVisibility(By locator){
        WebElement element = webElementFromLocator(locator);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToBeClickable(By locator){
        WebElement element = webElementFromLocator(locator);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void click(By locator){
        WebElement element = webElementFromLocator(locator);
        waitForElementToBeClickable(locator);
        element.click();
    }

    public void clearAndEnterText(By locator,String input ){
        WebElement element = webElementFromLocator(locator);
        waitForElementToBeClickable(locator);
        element.clear();
        element.sendKeys(input);
    }
    public WebElement webElementFromLocator(By locator){
        return driver.findElement(locator);
    }

    public void openApplication(String application){
        driver.get(application);
    }

   public void hoverElementAndClick(By locator1, By locator2){
       WebElement element1 = webElementFromLocator(locator1);
       WebElement element2 = webElementFromLocator(locator2);
       Actions act = new Actions(driver);
       act.moveToElement(element1).build().perform();
       act.moveToElement(element2).click().build().perform();
   }

   public void scrollToElement(By locator){
       WebElement element = webElementFromLocator(locator);
       JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("arguments[0].scrollIntoView(true)",element);

   }

   public void highlightElement(By locator){
       JavascriptExecutor js = (JavascriptExecutor) driver;
       WebElement element = webElementFromLocator(locator);
       js.executeScript("arguments[0].setAttribute('style', 'border: solid 3px yellow');", element);
       js.executeScript("arguments[0].setAttribute('style', 'border: solid 5px blue');", element);
   }

    public String getText(By locator) {
        waitForElementVisibility(locator);
        return webElementFromLocator(locator).getText();
    }

    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void selectByVisibleText(By locator, String text) {
        WebElement dropdown = webElementFromLocator(locator);
        new Select(dropdown).selectByVisibleText(text);
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
