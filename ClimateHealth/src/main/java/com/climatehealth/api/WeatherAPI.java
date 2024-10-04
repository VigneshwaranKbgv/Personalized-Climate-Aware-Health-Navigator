package com.climatehealth.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

public class WeatherAPI {
    private static final String API_KEY = "API KEY"; // Replace with actual API key
    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather"; // Open weather URL

    public Map<String, Object> getWeather(String location) throws Exception {
        String urlString = String.format("%s?q=%s&appid=%s&units=metric", BASE_URL, location, API_KEY);
        System.out.println("Fetching weather data from: " + urlString); // Debugging line

        // Create URI
        URI uri = new URI(urlString);
        URL url = uri.toURL(); // Convert URI to URL

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        if (conn.getResponseCode() != 200) {
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            StringBuilder errorResponse = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                errorResponse.append(line);
            }
            br.close();

            throw new RuntimeException("HTTP error code: " + conn.getResponseCode() + " - " + errorResponse.toString());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null) {
            response.append(line);
        }
        br.close();

        // Parse JSON response to extract needed information
        JSONObject jsonObject = new JSONObject(response.toString());
        String description = jsonObject.getJSONArray("weather").getJSONObject(0).getString("description");
        double temperature = jsonObject.getJSONObject("main").getDouble("temp");
        int humidity = jsonObject.getJSONObject("main").getInt("humidity");

        Map<String, Object> weatherDetails = new HashMap<>();
        weatherDetails.put("description", description);
        weatherDetails.put("temperature", temperature);
        weatherDetails.put("humidity", humidity);
        
        return weatherDetails;
    }

}
