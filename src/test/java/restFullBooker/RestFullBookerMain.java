package restFullBooker;



import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helper.HttpMessageSender;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class RestFullBookerMain {

    @Given("I have successfully authenticate")
        public void authentication() {
    /*    HttpMessageSender httpSender = new HttpMessageSender();
        Response authResponse = httpSender.getAuthenticate("/authentication/token/new");
        authResponse.then().assertThat().statusCode(200).log().all(); */
        System.out.println("I have successfully authanticate with right apiKey");
    }

    @When("I make the Request with valid credential as Token and sessionId")
    public void sessionLogin() {
        System.out.println("When I already got right Token and session_id, I sent a request to create a List");
    }

    @Then("The List is created")
    public void createSessionList() {
        HttpMessageSender httpSender = new HttpMessageSender();

        Response authResponse = httpSender.getAuthenticate("/authentication/token/new");
        authResponse.then().assertThat().statusCode(200).log().all();
        Response loginResponse = httpSender.getSessionLogin("/authentication/token/validate_with_login");
        loginResponse.then().assertThat().statusCode(200).log().all();
        Response sessionResponse = httpSender.getCreateSession("/authentication/session/new");
        sessionResponse.then().assertThat().statusCode(200).log().all();
        Response listResponse = httpSender.getCreateList("/list");
        listResponse.then().assertThat().statusCode(201).log().all();
        System.out.println("List Created in my Profile");
    }


/*
    @Test
    public void createSessionList() {
        HttpMessageSender httpSender = new HttpMessageSender();

        Response authResponse = httpSender.getAuthenticate("/authentication/token/new");
        authResponse.then().assertThat().statusCode(200).log().all();
        Response loginResponse = httpSender.getSessionLogin("/authentication/token/validate_with_login");
        loginResponse.then().assertThat().statusCode(200).log().all();
        Response sessionResponse = httpSender.getCreateSession("/authentication/session/new");
        sessionResponse.then().assertThat().statusCode(200).log().all();
        Response listResponse = httpSender.getCreateList("/list");
        listResponse.then().assertThat().statusCode(201).log().all();
    } */
    /*
    @Test
    public void authentication() {
        HttpMessageSender httpSender = new HttpMessageSender();

        Response authResponse = httpSender.getAuthenticate("/authentication/token/new");
        authResponse.then().assertThat().statusCode(200).log().all();
    }

    @Test
    public void sessionLogin() {
        HttpMessageSender httpSender = new HttpMessageSender();
        Response authResponse = httpSender.getAuthenticate("/authentication/token/new");
        Response loginResponse = httpSender.getSessionLogin("/authentication/token/validate_with_login");
        loginResponse.then().assertThat().statusCode(200).log().all();
    }

    @Test
    public void createSession() {
        HttpMessageSender httpSender = new HttpMessageSender();
        Response authResponse = httpSender.getAuthenticate("/authentication/token/new");
        Response loginResponse = httpSender.getSessionLogin("/authentication/token/validate_with_login");
        Response sessionResponse = httpSender.getCreateSession("/authentication/session/new");
        sessionResponse.then().assertThat().statusCode(200).log().all();
    }  */


}
