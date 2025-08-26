package hrm.testcases;


import hrm.common.BaseTest;
import hrm.common.DataTest;
import hrm.pages.BasePage;
import hrm.pages.JobCategoryPage;
import hrm.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JobCategoryTest extends BaseTest {
    LoginPage loginPage;
    BasePage basePage;
    JobCategoryPage jobCategoryPage;

    @BeforeMethod
    public void initPage() {
        loginPage = new LoginPage();
        basePage = new BasePage();
        jobCategoryPage = new JobCategoryPage();
    }
    @Test(priority = 1)
    public void testAddJobCategory() {
        loginPage.loginHRM("Admin", "admin123");
        basePage.clickMenuAdmin();
        jobCategoryPage.addJobCategory(DataTest.job_category);
        jobCategoryPage.verifySuccessMessageIsDisplayed();
        jobCategoryPage.verifyJobCategoryIsDisplayedInTable(DataTest.job_category);
    }
    @Test(priority = 2)
    public void testEditJobCategory() {
        loginPage.loginHRM("Admin", "admin123");
        basePage.clickMenuAdmin();
        jobCategoryPage.editJobCategory(DataTest.job_category);
        jobCategoryPage.verifySuccessMessageIsDisplayed();
        jobCategoryPage.verifyJobCategoryIsDisplayedInTable(DataTest.job_category_edit);
    }
    @Test(priority = 3)
    public void testDeleteJobCategory(){
        loginPage.loginHRM("Admin", "admin123");
        basePage.clickMenuAdmin();
        jobCategoryPage.deleteJobCategory(DataTest.job_category_edit);
        jobCategoryPage.verifySuccessMessageIsDisplayed();
        jobCategoryPage.verifyJobCategoryNotDisplayedInTable(DataTest.job_category_edit);
    }
}
