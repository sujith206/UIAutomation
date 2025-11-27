package com.Ui.webAutomation.nopCommerce.tests;

import com.Ui.webAutomation.nopCommerce.pages.HomePage;
import com.Ui.webAutomation.utils.BaseTest;

/**
 * Legacy helper - new TestNG test is `FlipkartTc01Test`.
 */
public class FlipkartTc01 extends BaseTest {

    public void openFlipkartLegacy(){
        HomePage homePage = new HomePage();
        homePage.openApplication();
        homePage.cellPhonesNavigation();
        homePage.phoneSelection();
        homePage.closeBrowser();
    }

}
