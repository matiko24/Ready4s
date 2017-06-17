package com.example.mateusz.ready4s.data.model;

/**
 * Created by Mateusz on 2017-06-16.
 */

public class MyLatLng {

    public static String getLatAsStringWithNS(double lat) {
        String latString = String.valueOf(Math.abs(lat));

        if (lat > 0)
            latString += "\u00B0N";
        else
            latString += "\u00B0S";

        return latString;
    }

    public static String getLngAsStringWithWE(double lng) {

        String lngString = String.valueOf(Math.abs(lng));

        if (lng > 0)
            lngString += "\u00B0E";
        else
            lngString += "\u00B0W";

        return lngString;
    }

    public static String getLatLngAsStringWithNSWE(double lat, double lng) {
        return getLatAsStringWithNS(lat) + "  " + getLngAsStringWithWE(lng);
    }
}
