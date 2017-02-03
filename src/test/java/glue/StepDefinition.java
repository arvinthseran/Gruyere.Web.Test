package glue;


import cucumber.api.PendingException;
import cucumber.api.Transform;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import glue.StepTransformation.SnippetHTMLTransformer;
import glue.StepTransformation.SnippetTransformer;
import glue.StepTransformation.UserNameTransformer;
import org.testng.Assert;
import pageobject.*;

/**
 * Created by arvinth seran on 02/02/2017.
 */
public class StepDefinition extends BaseUtil {

    private BaseUtil baseUtil;

    public StepDefinition(BaseUtil baseUtil) {
        this.baseUtil = baseUtil;
    }

    @When("^I sign up for new account as username:([^\"]*)")
    public void iSignUpForNewAccountAsUsername(@Transform(UserNameTransformer.class) String username) throws Throwable {
        HomePage homePage = new HomePage(baseUtil.baseWebDriver);
        CommonPage commonPage = homePage.NavigateToSignUp();
        System.out.println(username);
        commonPage.CreateAccount(username, username);
    }

    @When("^I Create \"([^\"]*)\" as New Snippet$")
    public void iCreateAsNewSnippet(@Transform(SnippetTransformer.class) String text) throws Throwable {
        System.out.println(text);
        baseUtil.snippet = text;
        CreateSnippet(text);
    }

    @When("^I Create \"([^\"]*)\" New Snippet including HTML tags$")
    public void iCreateNewSnippetIncludingHTMLTags(String text) throws Throwable {
        String formattedText = String.format("<b>%1$s</b><br><small>%1$s</small><br><i>%1$s</i>",text);
        System.out.println(text);
        baseUtil.snippet = text;
        CreateSnippet(formattedText);
    }

    private void CreateSnippet(String text)
    {   HomePage homePage = new HomePage(baseUtil.baseWebDriver);
        CommonPage commonPage = homePage.NavigateToSignIn();
        MyAccountPage myAccountPage = commonPage.Login("arvin", "arvin");
        NewSnippetPage newSnippetPage = myAccountPage.NavigateToNewSnippet();
        newSnippetPage.CreateNewSnippet(text);
    }

    @Then("^Formatted Snippet can be seen under My Snippet$")
    public void formattedSnippetCanBeSeenUnderMySnippet() throws Throwable {
        MySnippetsPage mySnippetsPage = new MySnippetsPage(baseUtil.baseWebDriver);
        Assert.assertEquals(mySnippetsPage.ReadMessage(), "My Snippets");
        Assert.assertTrue(mySnippetsPage.IsFormattedSnippetCreated("b",baseUtil.snippet),
                String.format("%1s snippet is not found in BOLD",baseUtil.snippet));
        Assert.assertTrue(mySnippetsPage.IsFormattedSnippetCreated("small",baseUtil.snippet),
                String.format("%1s snippet is not found in Small",baseUtil.snippet));
        Assert.assertTrue(mySnippetsPage.IsFormattedSnippetCreated("i",baseUtil.snippet),
                String.format("%1s snippet is not found in Italics",baseUtil.snippet));
    }
}
