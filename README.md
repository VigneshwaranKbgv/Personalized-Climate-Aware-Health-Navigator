
![Screenshot 2025-02-18 095157](https://github.com/user-attachments/assets/474e274f-8068-4ea7-8bfb-ff32b85de57a)
![Screenshot 2025-02-18 095210](https://github.com/user-attachments/assets/3d87ad69-5771-4cce-8243-7b843213c162)
![Screenshot 2025-02-18 095249](https://github.com/user-attachments/assets/4ede4050-45d2-4d39-80fc-7635384ffa6f)
![Screenshot 2025-02-18 095309](https://github.com/user-attachments/assets/1587e7dd-8840-4a68-a92d-6f292f7c685c)
![Screenshot 2025-02-18 095329](https://github.com/user-attachments/assets/a4df187e-d3f0-4cf3-97c8-23e1d7e0c310)


# Personalized Climate-Aware Health Navigator

## Overview
The **Personalized Climate-Aware Health Navigator** is a **web-based AI-powered platform** that provides **real-time weather-based health and activity recommendations**. It integrates **climate data** with **personal health metrics** to deliver **personalized insights** using **OpenWeather API** and **Gemini AI**. The platform is designed with an **interactive dashboard** that dynamically displays **weather conditions and AI-generated health suggestions**.

## Features
✅ **User Health Data Submission** – Users enter **location, weight, height, and body temperature**.
✅ **Real-Time Weather Data Integration** – Fetches live **temperature, humidity, and weather conditions** via **OpenWeather API**.
✅ **AI-Generated Health & Activity Suggestions** – Uses **Gemini AI** to provide **personalized health advice** based on weather.
✅ **Interactive Dashboard** – Displays **weather reports and suggestions** in a visually engaging way with **animations and icons**.
✅ **Modern UI/UX Enhancements** – Styled with **CSS animations**, **icons**, and a **toggleable suggestions section**.

## Technologies Used
- **Java (JSP & Servlets)** – Core backend logic and request handling.
- **RESTful API Integration** – Fetches real-time weather updates from OpenWeather API.
- **Gemini AI API** – Generates health and activity recommendations.
- **HTML, CSS, JavaScript** – Enhances UI with **animations, collapsible sections, and interactive elements**.
- **Apache Tomcat** – Web server for running the application.
- **MVC Architecture** – Ensures clean separation of concerns.

## Project Structure
### **Model Layer**
- `HealthData.java` – Represents user health data.

### **DAO Layer**
- `HealthDataDAO.java` – Handles database interactions (optional if using data persistence).

### **Controller Layer**
- `HealthDataServlet.java` – Processes form submissions and interacts with the service layer.

### **Service Layer**
- `SuggestionService.java` – Fetches weather data and calls **Gemini AI** for suggestions.

### **View Layer**
- `dashboard.jsp` – Displays **weather data, AI-generated suggestions, and user input forms**.

## How It Works
1️⃣ **User Inputs Health Data** – Users enter **location, weight, height, and temperature**.
2️⃣ **Weather API Fetches Live Data** – Retrieves **current temperature, humidity, and conditions**.
3️⃣ **Gemini AI Generates Suggestions** – Provides **health & activity recommendations** based on weather.
4️⃣ **Dashboard Displays Results** – Weather details & suggestions appear with **icons and animations**.

## Key Features Implemented
🔹 **Weather API Integration** – Fetches and parses live weather data.
🔹 **AI-Generated Personalized Suggestions** – Uses **Gemini AI** for recommendations.
🔹 **Enhanced UI/UX** – Includes **icons, collapsible sections, and animations**.
🔹 **MVC-Based Scalability** – Structured for **easy maintenance & extension**.

## Conclusion
The **Personalized Climate-Aware Health Navigator** is an **AI-driven, real-time health advisory system**. It integrates **climate data with AI** to offer **dynamic, personalized insights**. The platform demonstrates **full-stack expertise**, leveraging **Java, APIs, AI, and UI enhancements**. Future improvements can include **mobile integration, push notifications, and machine learning-based enhancements**.
