# 
https://github.com/user-attachments/assets/254fc328-b50a-42be-8c41-fdf0caffe182


## Overview

The **Personalized Climate-Aware Health Navigator** is a web-based platform designed to integrate real-time climate data with personal health metrics to provide users with personalized health recommendations/suggestions. It helps users monitor their health by processing their location-based climate data, such as temperature and weather conditions, and offering insights on how these factors may influence their well-being.

## Features

- **User Registration & Authentication**: Users can register and securely log into the platform to access services.
- **Health Data Submission**: Users can input and update personal health metrics, such as weight, temperature, and location.
- **Real-Time Climate Data Integration**:It integrates a weather API to fetch real-time climate data based on user location.
- **Health Recommendations**: The system processes user health data alongside climate data to generate personalized health suggestions.
- **Dashboard Interface**: A user-friendly dashboard allows users to easily view their health metrics and receive suggestions.

## Technologies Used

- **Java**: Core backend logic and business logic implementation.
- **JSP/Servlets**: Used for building the dynamic user interfaces and handling HTTP requests and responses.
- **JDBC/MySQL**: Provides interaction with the MySQL database to store user and health data.
- **Weather API Integration**: Retrieves real-time weather data to customize health recommendations based on climate.
- **JSON Parsing**: Processes API data to extract relevant weather information.
- **Apache Tomcat**: Used as the server to deploy the application.
- **MVC Architecture**: Ensures separation of concerns for scalability and maintainability.

## Project Structure

- **Model Layer**: 
  - `User.java` and `HealthData.java`: Represent user and health data entities.
  - DAO classes (`UserDAO.java`, `HealthDataDAO.java`): Handle database operations, including user registration and health data management.
  
- **Controller Layer**: 
  - Servlets (`UserServlet.java`, `HealthDataServlet.java`): Handle client requests, process data, and interact with the model and view components.
  
- **Service Layer**: 
  - `SuggestionService.java`: Processes user health and climate data to generate personalized health recommendations.
  
- **View Layer**: 
  - JSP files (`index.jsp`, `login.jsp`, `register.jsp`, `dashboard.jsp`): Provides user interfaces for login, registration, and the health dashboard.

## Working

1. **User Registration & Login**: Users register by entering their personal details and health metrics. The platform authenticates the user and provides access to the dashboard.
2. **Health Data Input**: Users input or update their health data, such as weight, temperature, and location.
3. **Weather Data Fetching**: The platform uses a weather API to fetch real-time weather conditions based on the user’s location.
4. **Personalized Suggestions**: Based on the user’s health metrics and the fetched climate data, the system provides personalized health recommendations.
5. **Dashboard Display**: The dashboard shows users their health data and the generated recommendations in an easy-to-understand format.

## Key Features Implemented

- **Model-View-Controller (MVC) Architecture**: This ensures the platform is scalable and easy to maintain.
- **Weather API Integration**: Fetches and parses real-time weather data using **JSON**.
- **Personalized Health Suggestions**: Built a custom algorithm to provide personalized health recommendations based on weather data and user health metrics.
- **Data Persistence**: Utilized **MySQL** for storing user and health data securely.

## Conclusion

The **Personalized Climate-Aware Health Navigator** is designed to offer personalized health insights by integrating personal health metrics with real-time climate data. This project showcases skills in full-stack development, including **Java**, **JSP**, **JDBC**, **MySQL**, **API integration**, and **MVC architecture**. It is a scalable solution that can be enhanced with additional features like mobile support, notifications, and AI-driven recommendations.
