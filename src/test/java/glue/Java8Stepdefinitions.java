package glue;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java8.En;
import org.testng.Assert;
import pageobject.*;


import java.util.List;

/**
 * Created by arvin on 02/02/2017.
 */
public class Java8Stepdefinitions extends BaseUtil implements En {

    public Java8Stepdefinitions(BaseUtil baseUtil) {

        Given("^I'm on the gruyere website$", () -> {
            baseUtil.baseWebDriver.GoToUrl(url);
        });

        When("^I sign up for new account using existing username$", (DataTable table) -> {
            HomePage homePage = new HomePage(baseUtil.baseWebDriver);
            CommonPage commonPage = homePage.NavigateToSignUp();
            List<UserAccount> accounts = table.asList(UserAccount.class);

            for (UserAccount user : accounts) {
                baseUtil.UserName = user.username;
                baseUtil.Password = user.password;
                commonPage.CreateAccount(user.username, user.password);
            }
        });

        When("^I login using existing username$", (DataTable table) -> {
            HomePage homePage = new HomePage(baseUtil.baseWebDriver);
            CommonPage commonPage = homePage.NavigateToSignIn();
            List<UserAccount> accounts = table.asList(UserAccount.class);

            for (UserAccount user : accounts) {
                baseUtil.UserName = user.username;
                baseUtil.Password = user.password;
                commonPage.Login(user.username, user.password);
            }
        });

        Then("^I'm taken to my account page$", () -> {
            MyAccountPage myAccountPage = new MyAccountPage(baseUtil.baseWebDriver);
            String expected = String.format("%1$s <%1$s>", baseUtil.UserName);
            String actual = myAccountPage.ReadMenu();
            Assert.assertTrue(actual.toLowerCase().contains(expected.toLowerCase()),
                    String.format("%s not found in - %s", expected, actual));
        });

        Then("^Message \"([^\"]*)\" should be displayed$", (String text) -> {
            SaveProfilePage saveProfilePage = new SaveProfilePage(baseUtil.baseWebDriver);
            Assert.assertEquals(saveProfilePage.ReadMessage(), text);
        });
        When("^I enter invalid username or password$", () -> {
            HomePage homePage = new HomePage(baseUtil.baseWebDriver);
            CommonPage commonPage = homePage.NavigateToSignIn();
            commonPage.Login("abc", "123");

        });
        Then("^Snippet can be seen under My Snippet$", () -> {
            MySnippetsPage mySnippetsPage = new MySnippetsPage(baseUtil.baseWebDriver);
            Assert.assertEquals(mySnippetsPage.ReadMessage(), "My Snippets");
            Assert.assertTrue(mySnippetsPage.IsSnippetCreated(baseUtil.snippet),
                    String.format("%1s not found",baseUtil.snippet));
        });

    }

    public class UserAccount {
        String username;
        String password;

        public UserAccount(String userName, String passWord) {
            username = userName;
            password = passWord;
        }
    }
}

