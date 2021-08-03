<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css">

    <title>Employee management system</title>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <div class="container-fluid">
        <a class="navbar-brand" href="Add.jsp">Add</a>
        <!--<a class="navbar-brand" ref="<%=request.getContextPath()%>/insert">Add</a>-->
        <!-- <a class="navbar-brand" href="add-employee">Add</a>-->
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="Delete.jsp">Delete</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="show">View</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">Update</a>
                </li>
            </ul>
            <form class="d-flex">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>

<h1><%= "Welcome to employee management system"%>
    <img src="emp.png" alt=Welcome to employee management system>
</h1>

<br/>
<a href="">Home page</a>
</body>
</html>