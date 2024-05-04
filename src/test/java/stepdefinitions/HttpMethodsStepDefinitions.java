package stepdefinitions;

import io.cucumber.java.en.When;

public class HttpMethodsStepDefinitions {
    BaseUtils baseUtils;

    public HttpMethodsStepDefinitions(BaseUtils baseUtils) {
        this.baseUtils = baseUtils;
    }

    @When("I do GET request with URL {string}")
    public void iDoGetRequestWithUrl(String url) {
        baseUtils.response = baseUtils.requestSpecification.when().log().all().get(url);
    }

    @When("I do POST request with URL {string}")
    public void iDoPOSTRequestWithURL(String url) {
        baseUtils.response = baseUtils.requestSpecification.when().log().all().post(url);
    }

    @When("I do PUT request with URL {string}")
    public void iDoPUTRequestWithURL(String url) {
        baseUtils.response = baseUtils.requestSpecification.when().log().all().put(url);
    }

    @When("I do PATCH request with URL {string}")
    public void iDoPATCHRequestWithURL(String url) {
        baseUtils.response = baseUtils.requestSpecification.when().log().all().patch(url);
    }

    @When("I do DELETE request with URL {string}")
    public void iDoDELETERequestWithURL(String url) {
        baseUtils.response = baseUtils.requestSpecification.when().log().all().delete(url);
    }


}
