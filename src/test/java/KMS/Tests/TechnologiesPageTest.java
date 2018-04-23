package KMS.Tests;

import KMS.Framework.Core.TestBase;
import KMS.Framework.Pages.TechnologiesPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class TechnologiesPageTest extends TestBase {

    @Test
    public void goToTechnologiesTab() {
        TechnologiesPage technologiesPage = PageFactory.initElements(driver, TechnologiesPage.class);

        technologiesPage.clickOnTechnologiesTabButton();
        technologiesPage.verifyTechnologiesTabContent();
    }
}
