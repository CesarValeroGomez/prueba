package helper;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import entities.DatosRequest;
import entities.RatingData;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;
import static io.restassured.RestAssured.given;


public class HttpMessageSender {

    private String theUrl;
    private String theUrl2;
    private String sessionId;
    private Map<String,Object> tokenMap;
    private Map<String,Object> sessionMap;
    private DatosRequest datosRequest;
    private TestEnviron testEnviron;
    private ReadPropertiData readData;
    private RatingData ratingData;
    private JsonParser parser = new JsonParser();
    private Gson gson = new Gson();

    public HttpMessageSender() {}

    public void loadLinks(String path)
    {
        testEnviron = new TestEnviron();
        readData = new ReadPropertiData();
        testEnviron = readData.LoadMainData(path, sessionId);
        this.theUrl = testEnviron.toString1();
        this.theUrl2 = testEnviron.toString2();
    }

    public void rateMovies(String path)
    {
        testEnviron = new TestEnviron();
        readData = new ReadPropertiData();
        testEnviron = readData.LoadMainData(path, sessionId);
        ratingData = new RatingData(testEnviron);
    }

    public Response getAuthenticate(String path) {
       // System.out.println(link);
        loadLinks(path);
        Response authResponse =
                given().contentType( ContentType.JSON).
                        log().uri().
                        when().get(theUrl).
                        andReturn();
        JsonElement element = parser.parse(authResponse.body().asString());
        this.tokenMap = gson.fromJson(element, Map.class);
        return authResponse;
    }

    public Response getSessionLogin(String path) {

        datosRequest = readData.LoadRequestData(tokenMap.get("request_token"));
        loadLinks(path);

        Response loginResponse =
                given().contentType( ContentType.JSON).
                        body(datosRequest).
                        log().body().
                        when().post(theUrl).
                        andReturn();

        return loginResponse;
    }

    public Response getCreateSession(String path) {

        loadLinks(path);
        JsonElement jsonElement = new JsonParser().parse(datosRequest.getReqToken());
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        Response sessionResponse =
                given().contentType( ContentType.JSON).
                        body(jsonObject).
                        log().body().
                        when().post(theUrl).
                        andReturn();
        JsonElement element = parser.parse(sessionResponse.body().asString());
        this.sessionMap = gson.fromJson(element, Map.class);
        this.sessionId = String.valueOf(sessionMap.get("session_id"));
        return sessionResponse;
    }

    public Response getCreateList(String path) {

        loadLinks(path);
        Object json = readData.readJson();

        Response listResponse =
                given().contentType( ContentType.JSON).
                        body(json).
                        log().body().
                        when().post(theUrl2).
                        andReturn();

        return listResponse;
    }

    //Rating
    public Response postRatingMovie(String movie_id) {

        rateMovies("");
        ratingData.setMovie_id(movie_id);
        Object json = readData.readJsonRating();

        Response listResponse =
                given().contentType( ContentType.JSON).
                        body(json).
                        log().body().
                        when().post(ratingData.getRatingMovie()).
                        andReturn();
        System.out.println(ratingData.getRatingMovie());
        return listResponse;
    }

    public Response postRatingTvShow(String tv_id) {

        rateMovies("");
        ratingData.setTv_id(tv_id);
        Object json = readData.readJsonRating();

        Response listResponse =
                given().contentType( ContentType.JSON).
                        body(json).
                        log().body().
                        when().post(ratingData.getRatingTvShow()).
                        andReturn();
        System.out.println(ratingData.getRatingTvShow());
        return listResponse;
    }

    public Response postRatingTvEpisode(String tv_id, String season_id, String episode_id) {

        rateMovies("");
        ratingData.setTv_id(tv_id);
        ratingData.setSeason_id(season_id);
        ratingData.setEpisode_id(episode_id);
        Object json = readData.readJsonRating();

        Response listResponse =
                given().contentType( ContentType.JSON).
                        body(json).
                        log().body().
                        when().post(ratingData.getRatingTvEpisode()).
                        andReturn();
        System.out.println(ratingData.getRatingTvEpisode());
        return listResponse;
    }
}
