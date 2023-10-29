<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="models.*" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
            crossorigin="anonymous">
</head>
<body class="d-flex flex-column" style="min-height: 100vh">
<header>
    <nav class="navbar bg-body-tertiary">
        <div class="container-fluid">
            <a class="navbar-brand">Login</a>
        </div>
    </nav>
</header>

<main style="margin: 50px 600px; max-width: 800px;">
    <div class="card">
        <div class="card-body">
            <h2 class="card-title text-center">Iniciar Sesión</h2>
            <form action="/app/ServletLogin" method="post">
                <div class="mb-4">
                    <label for="username" class="form-label">Nombre de usuario</label>
                    <input type="text" class="form-control" id="username" name="username"
                           placeholder="Nombre de usuario" required>
                </div>
                <div class="mb-4">
                    <label for="password" class="form-label">Contraseña</label> <input
                        type="password" class="form-control" id="password" name="password"
                        placeholder="Contraseña" required>
                </div>
                <button type="submit" class="btn btn-primary">Iniciar
                    Sesión</button>
            </form>
        </div>
    </div>
</main>


<div class="bg-body-tertiary pb-3 pb-" style="margin-top: auto;">
    <br />
    <footer class="mx-4">
        <p>&copy; Mi aplicación JPA</p>
    </footer>
</div>

<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>