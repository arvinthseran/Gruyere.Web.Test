package pageobject;

import drivers.Interface.IGruWebDriver;

/**
 * Created by arvin on 02/02/2017.
 */
public class MyAccountPage extends MyCommonPage {

    public MyAccountPage(IGruWebDriver driver){
        super(driver);
    }

    public NewSnippetPage NavigateToNewSnippet(){
        FindlnkWithText(lnkNewSnippet).click();
        return new NewSnippetPage(driver);
    }
}
