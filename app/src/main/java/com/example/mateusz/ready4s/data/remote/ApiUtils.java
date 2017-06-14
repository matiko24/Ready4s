package com.example.mateusz.ready4s.data.remote;

/**
 * Created by Mateusz on 2017-06-14.
 */

public class ApiUtils {

    public static final String BASE_URL = "https://interview-ready4s.herokuapp.com";

    public static SOService getSOSService() {
        return RetrofitClient.getClient(BASE_URL).create(SOService.class);
    }
}
