package org.example;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.example.ReadingHelpers.XMLReader;
import org.example.utils.BaseTest;
import org.example.utils.DatesHelper;
import org.example.utils.TestListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class HotelsSearchTest extends BaseTest {
    @Test(description = "Validate that the request returns 200")
    void validateThat200StatusCodeIsBeingReturned(){
        String baseURI = APIConstants.BASE_URL+APIConstants.HOTELS_SEARCH_ENDPOINT;
        String checkIn = "\"checkIn\":\"" + DatesHelper.getTomorrowDate() + "\"", checkOut = "\"checkOut\":\"" + DatesHelper.getNextWeekDate() + "\"", adultsCount = "\"adultsCount\":" + 2, roomsInfo = "\"roomsInfo\":[{" + adultsCount + "}]", placeId = "\"placeId\":\"" + XMLReader.getXMLData("istanbulPlaceId") + "\"";
        String body = "{" + checkIn + "," + checkOut + "," + roomsInfo + "," + placeId + "}";
        Response response = RestAssured.given().that().header("Content-Type", "application/json").and().header("token", XMLReader.getXMLData("token")).and().body(body).when().post(baseURI).thenReturn();
        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test(description = "Validate that the sId is returned normally  ")
    void validateThatTheSIdIsReturned(){
        String baseURI = APIConstants.BASE_URL+APIConstants.HOTELS_SEARCH_ENDPOINT;
        String checkIn = "\"checkIn\":\"" + DatesHelper.getTomorrowDate() + "\"", checkOut = "\"checkOut\":\"" + DatesHelper.getNextWeekDate() + "\"", adultsCount = "\"adultsCount\":" + 2, roomsInfo = "\"roomsInfo\":[{" + adultsCount + "}]", placeId = "\"placeId\":\"" + XMLReader.getXMLData("istanbulPlaceId") + "\"";
        String body = "{" + checkIn + "," + checkOut + "," + roomsInfo + "," + placeId + "}";
        Response response = RestAssured.given().that().header("Content-Type", "application/json").and().header("token", XMLReader.getXMLData("token")).and().body(body).when().post(baseURI).thenReturn();
        Assert.assertTrue(response.getBody().asString().contains("sId"));
    }

    @Test(description = "Validate that the sId is not empty")
    void validateThatSIdIsNotEmpty(){
        String baseURI = APIConstants.BASE_URL+APIConstants.HOTELS_SEARCH_ENDPOINT;
        String checkIn = "\"checkIn\":\"" + DatesHelper.getTomorrowDate() + "\"", checkOut = "\"checkOut\":\"" + DatesHelper.getNextWeekDate() + "\"", adultsCount = "\"adultsCount\":" + 2, roomsInfo = "\"roomsInfo\":[{" + adultsCount + "}]", placeId = "\"placeId\":\"" + XMLReader.getXMLData("istanbulPlaceId") + "\"";
        String body = "{" + checkIn + "," + checkOut + "," + roomsInfo + "," + placeId + "}";
        Response response = RestAssured.given().that().header("Content-Type", "application/json").and().header("token", XMLReader.getXMLData("token")).and().body(body).when().post(baseURI).thenReturn();
        JsonPath jsonPathEvaluator = response.jsonPath();
        Assert.assertNotNull(jsonPathEvaluator.get("sId"));
    }

    @Test(description = "Validate that the response time is accepted")
    void validateTheResponseTimeAcceptance(){
        String baseURI = APIConstants.BASE_URL+APIConstants.HOTELS_SEARCH_ENDPOINT;
        String checkIn = "\"checkIn\":\"" + DatesHelper.getTomorrowDate() + "\"", checkOut = "\"checkOut\":\"" + DatesHelper.getNextWeekDate() + "\"", adultsCount = "\"adultsCount\":" + 2, roomsInfo = "\"roomsInfo\":[{" + adultsCount + "}]", placeId = "\"placeId\":\"" + XMLReader.getXMLData("istanbulPlaceId") + "\"";
        String body = "{" + checkIn + "," + checkOut + "," + roomsInfo + "," + placeId + "}";
        Response response = RestAssured.given().that().header("Content-Type", "application/json").and().header("token", XMLReader.getXMLData("token")).and().body(body).when().post(baseURI).thenReturn();
        Assert.assertTrue(response.getTime() <= APIConstants.MAX_RESPONSE_TIME);
    }
}
