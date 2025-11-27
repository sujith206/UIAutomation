package com.Ui.webAutomation.nopCommerce.tests;

import com.Ui.webAutomation.nopCommerce.pages.HomePage;
import com.Ui.webAutomation.nopCommerce.pages.LoginPage;
import com.Ui.webAutomation.utils.BaseTest;
import org.testng.annotations.Test;

/**
 * Legacy helper - new TestNG test is `FlipkartTc01Test`.
 */
public class OrangeHrm extends BaseTest {

    @Test
    public void loginOrangeHrm() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.openApplication();
        loginPage.login();
    }

}
