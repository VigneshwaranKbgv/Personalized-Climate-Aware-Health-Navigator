<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.climatehealth.model.HealthData" %>
<%@ page import="com.climatehealth.dao.HealthDataDAO" %>
<%@ page import="java.util.*" %>
<%@ page import="com.climatehealth.service.SuggestionService" %>
<html>
<head>
    <title>Health Data Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            padding: 20px;
            text-align: center;
        }
        form {
            display: inline-block;
            background: white;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
        }
        input[type="text"], input[type="number"] {
            width: 200px;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        input[type="submit"] {
            padding: 10px 20px;
            color: white;
            background-color: #007bff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <h1>Health Data Entry</h1>

    <% if (request.getParameter("success") != null) { %>
        <div style="color: green;"><%= request.getParameter("success") %></div>
    <% } else if (request.getParameter("error") != null) { %>
        <div style="color: red;"><%= request.getParameter("error") %></div>
    <% } %>

    <form action="HealthDataServlet" method="post">
        <label for="location">Location:</label>
        <input type="text" id="location" name="location" required><br>

        <label for="weight">Weight (kg):</label>
        <input type="number" step="0.1" id="weight" name="weight" required><br>

        <label for="height">Height (cm):</label>
        <input type="number" step="0.1" id="height" name="height" required><br>

        <label for="temperature">Temperature (°C):</label>
        <input type="number" step="0.1" id="temperature" name="temperature" required><br>

        <input type="submit" value="Submit">
    </form>

    <% 
    String location = request.getParameter("location");
    if (location != null) {
        SuggestionService suggestionService = new SuggestionService();
        String suggestions = suggestionService.getSuggestions(location);
        
        if (suggestions != null && !suggestions.isEmpty()) {
            out.println("<h2>Suggestions for " + location + ":</h2><pre>" + suggestions + "</pre>");
        }
    }
    %>
</body>
</html>
