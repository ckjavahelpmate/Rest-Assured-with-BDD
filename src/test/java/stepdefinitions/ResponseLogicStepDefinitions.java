package stepdefinitions;

import com.github.fge.jsonschema.SchemaVersion;
import com.github.fge.jsonschema.cfg.ValidationConfiguration;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import io.restassured.module.jsv.JsonSchemaValidator;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import utils.DataUtility;

public class ResponseLogicStepDefinitions {
    BaseUtils baseUtils;

    public ResponseLogicStepDefinitions(BaseUtils baseUtils) {
        this.baseUtils = baseUtils;
    }

    @And("I validate the status code is {int}")
    public void iValidateTheStatusCodeIs(Integer statusCode) {
        baseUtils.response.then().statusCode(statusCode);
    }

    @Then("I validate the {string} is {string}")
    public void iValidateTheStatusCodeIs(String key, String value) {
//		Inline body validation
        baseUtils.response.then().body(key, Matchers.equalTo(value));

//		Extract JsonPath Validation
        String actualValue = baseUtils.response.then().extract().jsonPath().getString(key);
        MatcherAssert.assertThat(actualValue, Matchers.equalTo(value));
    }

    @And("store value of key {string}")
    public void storeValueOfKey(String key) {
        String value = baseUtils.response.then().extract().jsonPath().getString(key);
        DataUtility.setPropertyValue(key, value);
    }

    @And("print value of key {string} on console")
    public void printValueOfKeyOnConsole(String key) {
        System.out.println( key + " :: "+ DataUtility.getPropertyValue(key));
    }

    @Then("print response")
    public void print_response() {
        baseUtils.response.then().log().all();
    }

    @And("validate json schema with file {string}")
    public void validateJsonSchema(String fileName) {
        JsonSchemaFactory jsonSchemaFactory = JsonSchemaFactory.newBuilder()
                .setValidationConfiguration(ValidationConfiguration.newBuilder()
                        .setDefaultVersion(SchemaVersion.DRAFTV3).freeze())
                .freeze();
        baseUtils.response.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("C:\\Users\\10759782\\IdeaProjects\\Rest_Assured_Task\\src\\test\\resources\\json-input"+fileName));
    }
}
