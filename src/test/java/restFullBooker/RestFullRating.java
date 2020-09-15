package restFullBooker;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helper.HttpMessageSender;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class RestFullRating {

    @Given("I am authenticated with right token and session_id")
    public void authenticatedWithRightData() {
        System.out.println("I am authenticated with rithg  token and session_id");
    }
    @When("I rate a film")
    public void sendingRate() {
        System.out.println("I sent a post to rate a film");
    }

    @Then("The Movie is rated")
    public void rateMovies() {
        HttpMessageSender httpSender = new HttpMessageSender();
        Response authResponse = httpSender.getAuthenticate("/authentication/token/new");
        Response loginResponse = httpSender.getSessionLogin("/authentication/token/validate_with_login");
        Response sessionResponse = httpSender.getCreateSession("/authentication/session/new");
        Response rateMovieResponse = httpSender.postRatingMovie("429617");
        rateMovieResponse.then().assertThat().statusCode(201).log().all();
        System.out.println("The Movie was rated successfully");
    }

    @Then("The TV Show is rated")
    public void rateTvShow() {
        HttpMessageSender httpSender = new HttpMessageSender();
        Response authResponse = httpSender.getAuthenticate("/authentication/token/new");
        Response loginResponse = httpSender.getSessionLogin("/authentication/token/validate_with_login");
        Response sessionResponse = httpSender.getCreateSession("/authentication/session/new");
        Response rateTvShowResponse = httpSender.postRatingTvShow("60735");
        rateTvShowResponse.then().assertThat().statusCode(201).log().all();
        System.out.println("The TV Show was rated successfully");
    }

    @Then("The TV Episode is rated")
    public void rateTvEpisode() {
        HttpMessageSender httpSender = new HttpMessageSender();
        Response authResponse = httpSender.getAuthenticate("/authentication/token/new");
        Response loginResponse = httpSender.getSessionLogin("/authentication/token/validate_with_login");
        Response sessionResponse = httpSender.getCreateSession("/authentication/session/new");
        Response rateEpisodeResponse = httpSender.postRatingTvEpisode("60735","6", "7");
        rateEpisodeResponse.then().assertThat().statusCode(201).log().all();
        System.out.println("The TV Episode was rated successfully");
    }

}
