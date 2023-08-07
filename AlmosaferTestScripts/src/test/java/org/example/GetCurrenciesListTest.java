package org.example;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.example.utils.TestListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(TestListener.class)
public class GetCurrenciesListTest {

        @Test(description = "Validate that the request returns 200")
        void validateThat200StatusCodeIsBeingReturned(){
            RestAssured.baseURI = APIConstants.LIST_URL;
            RequestSpecification httpRequest = RestAssured.given();
            Response response = httpRequest.request(Method.GET, "");
            Assert.assertEquals(response.getStatusCode(),200);
        }

        @Test(description = "Validate that the base currency is returned")
        void validateThatTheBaseCurrencyIsReturned(){
            RestAssured.baseURI = APIConstants.LIST_URL;
            RequestSpecification httpRequest = RestAssured.given();
            Response response = httpRequest.request(Method.GET, "");
            Assert.assertTrue(response.getBody().asString().contains("base"));
        }

        @Test(description = "Validate that the base currency is not null")
        void validateThatTheBaseCurrencyIsNotNull(){
            RestAssured.baseURI = APIConstants.LIST_URL;
            RequestSpecification httpRequest = RestAssured.given();
            Response response = httpRequest.request(Method.GET, "");
            JsonPath jsonPathEvaluator = response.jsonPath();
            Assert.assertNotNull(jsonPathEvaluator.get("base"));
    }

        @Test(description = "Validate that the equivalent currencies are returned")
        void validateThatTheEquivalentCurrenciesAreReturned(){
            RestAssured.baseURI = APIConstants.LIST_URL;
            RequestSpecification httpRequest = RestAssured.given();
            Response response = httpRequest.request(Method.GET, "");
            JsonPath jsonPathEvaluator = response.jsonPath();
            Assert.assertNotNull(jsonPathEvaluator.get("equivalent"));
    }

        @Test(description = "Validate that the equivalent currencies are not null")
        void validateThatTheEquivalentCurrenciesAreNotNull(){
            RestAssured.baseURI = APIConstants.LIST_URL;
            RequestSpecification httpRequest = RestAssured.given();
            Response response = httpRequest.request(Method.GET, "");
            Assert.assertTrue(response.getBody().asString().contains("equivalent"));
        }

        @Test(description = "Validate that the base currency is returned in the equivalent currencies")
        void validateThatTheBaseCurrencyIsReturnedInTheEquivalentCurrencies(){
            RestAssured.baseURI = APIConstants.LIST_URL;
            RequestSpecification httpRequest = RestAssured.given();
            Response response = httpRequest.request(Method.GET, "");
            JsonPath jsonPathEvaluator = response.jsonPath();
            Assert.assertTrue(jsonPathEvaluator.get("equivalent").toString().contains(jsonPathEvaluator.get("base.symbol")));
        }

         @Test(description = "Validate that the response time is acceptable")
         void validateThatTheResponseTimeIsNormal(){
            RestAssured.baseURI = APIConstants.LIST_URL;
            RequestSpecification httpRequest = RestAssured.given();
            Response response = httpRequest.request(Method.GET, "");
            Assert.assertTrue(response.getTime()<=APIConstants.MAX_RESPONSE_TIME);
    }

}


