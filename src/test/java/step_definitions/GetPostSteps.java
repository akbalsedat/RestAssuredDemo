package step_definitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.is;

public class GetPostSteps {
        @Given("^I perform GET operation for \"([^\"]*)\"$")
        public void iPerformGETOperationFor(String url)  {
        }

    @And("I perform GET for the post number {string}")
    public void iPerformGETForThePostNumber(String postNumber) {
            BDDStyleMethod.SimpleGETPost(postNumber);
    }

    @Then("I should see the author's name as {string}")
    public void iShouldSeeTheAuthorSNameAs(String arg0) {

    }

    @Then("I should see the authors' names")
    public void iShouldSeeTheAuthorsNames() {
            BDDStyleMethod.PerformContainsCollection();
    }

    @Then("I should verify GET parameter")
    public void iShouldVerifyGETParameter() {
            BDDStyleMethod.PerformQueryParameter();
    }
}
