package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;
import utils.DataUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class RequestLogicStepDefinitions {
    BaseUtils baseUtils;

    public RequestLogicStepDefinitions(BaseUtils baseUtils) {
        this.baseUtils = baseUtils;
    }

    @Given("path param {string} with value {string}")
    public void pathParamWithValue(String pathParam, String value) {
        baseUtils.requestSpecification.pathParam(pathParam, value);
    }

    @And("path param {string} with data value")
    public void pathParamWithDataValueOfKey(String key) {
        baseUtils.requestSpecification.pathParam(key, DataUtility.getPropertyValue(key));
    }

    @Given("query param {string} with value {string}")
    public void pathParamWithIntValue(String queryParam, String queryParamValue) {
        baseUtils.requestSpecification.queryParam(queryParam, queryParamValue);
    }

    @Given("header param {string} with value {string}")
    public void headerParamWithIntValue(String headerParam, String headerParamValue) {
        if (headerParamValue.equals("token")) {
            String value = DataUtility.getPropertyValue(headerParamValue);
            baseUtils.requestSpecification.header(headerParam, "token=" + value);
        } else {
            baseUtils.requestSpecification.header(headerParam, headerParamValue);
        }
    }

    @Given("body param from file {string}")
    public void bodyParamFromFile(String fileName) {
        String filePath = "src/test/resources/json-input/" + fileName;
        try {
            FileInputStream fin = new FileInputStream(filePath);
            baseUtils.requestSpecification.body(fin);
            baseUtils.requestSpecification.contentType(ContentType.JSON);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
