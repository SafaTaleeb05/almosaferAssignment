package org.example;

public class APIConstants {



    private APIConstants() {
        // No need to instantiate the class, we can hide its constructor
    }

    public static final String BASE_URL = "https://www.almosafer.com/api/";
    public static final String HOTELS_SEARCH_ENDPOINT = "enigma/search/async";
    public static final String CURRENCIES_LIST_ENDPOINT = "currency/list";
    public static final String LIST_URL = "https://www.almosafer.com/api/system/currency/list";
    public static final String FLIGHTS_SEARCH_URL = "https://www.almosafer.com/api/v3/flights/flight/async-search-result";
    public static final int MAX_RESPONSE_TIME= 2000;

}
