package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.BeforeStep;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;
import utils.GenericUtils;

public class BaseClass
{
    BaseUtils baseUtils ;
    static String url ;

    public BaseClass(BaseUtils baseUtils)
    {
        this.baseUtils = baseUtils;
    }

    @BeforeAll
    public static void beforeAllScenario()
    {
        String envValue = GenericUtils.getPropertyValue("src/test/resources/global.properties", "ENV");
        url = GenericUtils.getPropertyValue("src/test/resources/"+envValue+".properties", "URL") ;
    }

    @Before
    public void beforeScenario()
    {
//		Getting url from properties file
        RestAssured.baseURI = "https://restful-booker.herokuapp.com/";

//		Specifing the ResponseSpecification Header
        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
        responseSpecBuilder.expectHeader("Server", "Cowboy");

        RestAssured.responseSpecification = responseSpecBuilder.build();

//		Initializing the RequestSpecification
        baseUtils.requestSpecification = RestAssured.given();

    }

    @BeforeStep
    public void beforeStep()
    {
//		System.out.println("**********".repeat(10));
    }

    @AfterStep
    public void afterStep()
    {
//		System.out.println("**********".repeat(10));
    }

    @After
    public void afterScenario()
    {
        System.out.println("=============".repeat(10));
    }
    @AfterAll
    public static void afterAllScenario()
    {
//		System.out.println("@@@@@@@@@".repeat(10));
    }

}