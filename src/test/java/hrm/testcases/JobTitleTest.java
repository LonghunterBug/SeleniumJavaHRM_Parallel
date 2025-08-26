package hrm.testcases;

import hrm.common.BaseTest;
import hrm.common.DataTest;
import hrm.pages.BasePage;
import hrm.pages.JobTitlePage;
import hrm.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JobTitleTest extends BaseTest {
    LoginPage loginPage;
    BasePage basePage;
    JobTitlePage jobTitlePage;
    @BeforeMethod
    public void initPage() {
        loginPage = new LoginPage();
        basePage = new BasePage();
        jobTitlePage = new JobTitlePage();
    }
    @Test(priority = 1)
    public void testAddJobTitle() {
        loginPage.loginHRM("Admin", "admin123");
        basePage.clickMenuAdmin();
        jobTitlePage.addJobTitle(DataTest.job_title);
        jobTitlePage.verifySuccessMessageIsDisplayed();
        jobTitlePage.verifyJobTitleIsDisplayedInTable(DataTest.job_title);
    }
    @Test(priority = 2)
    public void testEditJobTitle() {
        loginPage.loginHRM("Admin", "admin123");
        basePage.clickMenuAdmin();
        jobTitlePage.editJobTitle(DataTest.job_title);
        jobTitlePage.verifySuccessMessageIsDisplayed();
        jobTitlePage.verifyJobTitleIsDisplayedInTable(DataTest.job_title_edit);

    }
    @Test(priority = 3)
    public void testDeleteJobTitle(){
        loginPage.loginHRM("Admin","admin123");
        basePage.clickMenuAdmin();
        jobTitlePage.deleteJobTitle(DataTest.job_title_edit);
        jobTitlePage.verifySuccessMessageIsDisplayed();
        jobTitlePage.verifyJobTitleNotDisplayedInTable(DataTest.job_title_edit);

    }
}
