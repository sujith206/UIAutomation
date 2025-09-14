package com.Ui.webAutomation.nopCommerce.pages;

import com.Ui.webAutomation.utils.BasePage;
import org.openqa.selenium.By;

public class HomePage extends BasePage {
    // WebElements using By class
    private final By btnLogin = By.xpath("//*[@class='ico-login']");
    private final By txtSearch = By.xpath("//*[@id='small-searchterms']");
    private final By btnSearch = By.xpath("(//*[text()='Search'])[1]");
    private final By lnkElectronics = By.xpath("(//*[text()='Electronics '])[1]");
    private final By lnkCellPhones = By.xpath("(//*[contains(text(),'Cell phones ')])[1]");
    private final By txtCellPhones = By.xpath("(//*[text()='Cell phones'])[2]");
    private final By lnkApplePhone = By.xpath("(//*[text()='Apple iPhone 16 128GB'])");
    private final By txtApplePhone = By.xpath("(//*[text()='Apple iPhone 16 128GB'])[2]");
    private final By btnAddToCart = By.xpath("//*[text()='Add to cart']");

    public void openApplication(){
        openApplication("https://demo.nopcommerce.com");
    }
    public void cellPhonesNavigation(){
        waitForElementToBeClickable(btnLogin);
        hoverElementAndClick(lnkElectronics, lnkCellPhones);
        waitForElementToBeClickable(txtCellPhones);
    }

    public void phoneSelection(){
        scrollToElement(lnkApplePhone);
        highlightElement(lnkApplePhone);
        click(lnkApplePhone);
        waitForElementToBeClickable(txtApplePhone);
        scrollToElement(btnAddToCart);
        highlightElement(btnAddToCart);
        click(btnAddToCart);
    }
}
