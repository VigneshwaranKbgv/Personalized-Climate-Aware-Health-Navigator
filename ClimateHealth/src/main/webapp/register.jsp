<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
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
        input[type="text"], input[type="password"], input[type="email"] {
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
    <h2>User Registration</h2>

    <% if (request.getParameter("error") != null) { %>
        <p style="color:red;"><%= request.getParameter("error") %></p>
    <% } %>

    <form action="UserServlet" method="post">
        <input type="hidden" name="action" value="register" />
        Username: <input type="text" name="username" required /><br/>
        Password: <input type="password" name="password" required /><br/>
        Email: <input type="email" name="email" required /><br/>
        <input type="submit" value="Register" />
    </form>

    <p>Already have an account? <a href="login.jsp">Login here</a></p>
</body>
</html>
