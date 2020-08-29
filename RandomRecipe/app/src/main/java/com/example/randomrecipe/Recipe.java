package com.example.randomrecipe;

import java.io.IOException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class Recipe {
    //based on tutorial from DZone: How to Parse JSON Data from a REST API using Simple JSON Library

    //Pass the desired URL as an object
    URL random_url = new URL("www.themealdb.com/api/json/v1/1/random.php");

    //Type cast the URL object
    HttpsURLConnection conn;

    {
        try {
            conn = (HttpsURLConnection)random_url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    conn.setRequestMethod("GET");


}
