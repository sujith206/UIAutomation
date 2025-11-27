package com.Ui.webAutomation.nopCommerce.pages;

import com.Ui.webAutomation.utils.BasePage;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    private final By userName = By.xpath("//*[@name='username']");
    private final By password = By.xpath("//*[@name='password']");
    private final By submit =By.xpath("//*[@type='submit']");

    public void openApplication() throws InterruptedException {
        openApplication("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(10000);

    }
    public void login() throws InterruptedException {
        waitForElementToBeClickable(userName);
        clearAndEnterText(userName,"Admin");
        waitForElementToBeClickable(password);
        clearAndEnterText(password,"admin123");
        waitForElementToBeClickable(submit);
        click(submit);
        Thread.sleep(3000);
    }

}
