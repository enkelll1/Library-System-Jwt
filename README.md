<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Library Management System</title>
</head>
<body>

<h1>Library Management System JWT</h1>

<p>Welcome to the <strong>Spring Boot MongoDB Application</strong>! This project serves as a starter template for building a Spring Boot application connected to MongoDB. It’s designed to be simple, fast, and easy to get up and running, making it a great choice for quickly starting a new project.</p>

<h2>Prerequisites</h2>
<p>Before you begin, ensure you have the following installed on your system:</p>
<ul>
    <li><strong>Java 21</strong></li>
    <li><strong>Gradle 7.0+</strong> (or you can use the Gradle wrapper included in the project)</li>
    <li><strong>MongoDB</strong> installed and running locally</li>
</ul>

<h2>Steps to Build</h2>
<p>Follow these steps to set up and run the project:</p>
<ol>
    <li>Clone the repository:
        <pre><code>git clone https://github.com/your-repo-name.git</code></pre>
    </li>
    <li>Navigate to the project directory:
        <pre><code>cd your-repo-name</code></pre>
    </li>
    <li>Build the project:
        <pre><code>./gradlew build</code></pre>
    </li>
    <li>Run the application:
        <pre><code>./gradlew bootRun</code></pre>
    </li>
</ol>

<h2>Accessing the Application</h2>
<p>Once the application is up and running, you can access it by opening your web browser and navigating to 
<a href="http://localhost:8084" target="_blank">http://localhost:8084</a>. All APIs and services are available through this port.</p>

<p><strong>Note:</strong> Ensure that your MongoDB instance is running and accessible. If you don’t have MongoDB installed locally, I can provide a secure cloud-based MongoDB link upon request—just reach out to me privately. This is done to protect credentials and ensure a secure connection.</p>

<h2>API Endpoints to Try</h2>

<h3>Authentication Endpoints</h3>
<ul>
    <li><strong>Register a New User</strong>: <code>POST</code> <a href="http://localhost:8084/auth/register" target="_blank">http://localhost:8084/auth/register</a></li>
    <li><strong>Login</strong>: <code>POST</code> <a href="http://localhost:8084/auth/login" target="_blank">http://localhost:8084/auth/login</a></li>
</ul>

<h3>Book Management Endpoints (Protected by JWT)</h3>
<ul>
    <li><strong>Store a Book</strong>: <code>POST</code> <a href="http://localhost:8084/books/store" target="_blank">http://localhost:8084/books/store</a></li>
    <li><strong>Search for Books</strong>: <code>GET</code> <a href="http://localhost:8084/books/search" target="_blank">http://localhost:8084/books/search</a></li>
</ul>

<h3>Authentication</h3>
<p>Please note that all book management endpoints are protected by JWT. You must first register or login to receive a token, which you can then include in the <code>Authorization</code> header of your requests.</p>

</body>
</html>