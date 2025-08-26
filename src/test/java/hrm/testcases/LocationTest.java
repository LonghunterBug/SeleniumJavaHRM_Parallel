package hrm.testcases;

import hrm.common.BaseTest;
import hrm.common.DataTest;
import hrm.pages.BasePage;
import hrm.pages.LocationPage;
import hrm.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LocationTest extends BaseTest {
    LoginPage loginPage;
    BasePage basePage;
    LocationPage locationPage;
    @BeforeMethod
    public void initPage(){
        loginPage = new LoginPage();
        basePage = new BasePage();
        locationPage = new LocationPage();
    }
    @Test(priority = 1)
    public void testAddLocation(){
        loginPage.loginHRM("Admin","admin123");
        basePage.clickMenuAdmin();
        locationPage.addLocation(DataTest.location_name);
        locationPage.verifySuccessMessageIsDisplayed();
        locationPage.verifyLocationIsDisplayedInTable(DataTest.location_name);
    }
    @Test(priority = 2)
    public void testEditLocation(){
        loginPage.loginHRM("Admin","admin123");
        basePage.clickMenuAdmin();
        locationPage.editCountry(DataTest.location_name);
        locationPage.verifySuccessMessageIsDisplayed();
        locationPage.veriyCountryIsUpdatedInTable(DataTest.location_name);
    }
    @Test(priority = 3)
    public void testDeleteLocation(){
        loginPage.loginHRM("Admin","admin123");
        basePage.clickMenuAdmin();
        locationPage.deleteLocation(DataTest.location_name);
        locationPage.verifySuccessMessageIsDisplayed();
        locationPage.verifyLocationNotDisplayedInTable(DataTest.location_name);
    }
}
