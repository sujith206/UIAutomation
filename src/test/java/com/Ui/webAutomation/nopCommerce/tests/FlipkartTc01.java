package com.Ui.webAutomation.nopCommerce.tests;

import com.Ui.webAutomation.nopCommerce.pages.HomePage;
import org.testng.annotations.Test;

public class FlipkartTc01 {



    @Test
    public void openFlipkart(){
        HomePage homePage = new HomePage();
        homePage.openApplication();
        homePage.cellPhonesNavigation();
        homePage.phoneSelection();
    }

}
