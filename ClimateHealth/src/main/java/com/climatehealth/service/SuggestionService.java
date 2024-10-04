package com.climatehealth.service;

import com.climatehealth.api.WeatherAPI;
import java.util.*;

public class SuggestionService {
    private static final Map<String, List<String>> suggestionsMap = new HashMap<>();

    static {
        // Populate suggestionsMap with location-based suggestions
        suggestionsMap.put("New York", Arrays.asList("Visit Central Park", "Check out Times Square"));
        suggestionsMap.put("Los Angeles", Arrays.asList("Enjoy the beaches", "Visit Hollywood"));
    }

    public String getSuggestions(String location) {
        List<String> suggestions = suggestionsMap.getOrDefault(location, new ArrayList<>(List.of("Stay hydrated, wear light clothing, and avoid outdoor activities during peak sun hours.")));
        
        // Fetch weather information
        String weatherInfo = fetchWeatherInfo(location);
        
        StringBuilder result = new StringBuilder(weatherInfo + "\nSuggestions:\n");
        for (String suggestion : suggestions) {
            result.append("- ").append(suggestion).append("\n");
        }
        
        // Check humidity and add relevant suggestion if needed
        int humidity = extractHumidity(weatherInfo);
        if (humidity > 80) {
            result.append("- Humidity can cause dehydration, confusion, fatigue etc. So avoid burning more calories.\n");
        }
        
        return result.toString();
    }

    private String fetchWeatherInfo(String location) {
        WeatherAPI weatherAPI = new WeatherAPI();
        try {
            // Assuming the API returns a map with weather details
            Map<String, Object> weatherDetails = weatherAPI.getWeather(location);
            String description = (String) weatherDetails.get("description");
            Double temperature = (Double) weatherDetails.get("temperature");
            Integer humidity = (Integer) weatherDetails.get("humidity");

            return String.format("Weather in %s:\n- Description: %s\n- Temperature: %.1f°C\n- Humidity: %d%%", 
                location, description, temperature, humidity);
        } catch (Exception e) {
            return "Failed to fetch weather information: " + e.getMessage();
        }
    }
    
    private int extractHumidity(String weatherInfo) {
        // Extract humidity from the weather info string
        String[] lines = weatherInfo.split("\n");
        for (String line : lines) {
            if (line.contains("Humidity:")) {
                String[] parts = line.split(":");
                return Integer.parseInt(parts[1].trim().replace("%", ""));
            }
        }
        return 0; // Default humidity if not found
    }
}
