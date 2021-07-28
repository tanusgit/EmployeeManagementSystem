<%--
  Created by IntelliJ IDEA.
  User: annluu
  Date: 7/28/21
  Time: 12:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>User Management Application</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: blue">
        <div>
            <a href="https://www.xadmin.net" class="navbar-brand"> User Management Application </a>
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/view"
                   class="nav-link">Employee</a></li>
        </ul>
    </nav>
</header>
<br>
<img src="emp.png" alt=Welcome to employee management system>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">

            <form action="add" method="post">

                <fieldset class="form-group">
                    <label>EMPLOYEE ID</label> <input type="text"
                                                      value="<c:out value="${employee.id}" />" class="form-control"
                                                      name="id" required="required">
                </fieldset>

                <fieldset class="form-group">
                        <label>User Name</label> <input type="text"
                                                        value="<c:out value="${employee.name}" />" class="form-control"
                                                        name="name" required="required">
                    </fieldset>

                <fieldset class="form-group">
                        <label>User Department</label> <input type="text"
                                                         value="<c:out value="${employee.department}" />" class="form-control"
                                                         name="department">
                    </fieldset>

                <fieldset class="form-group">
                        <label>User Salary</label> <input type="text"
                                                           value="<c:out value="${employee.salary}" />" class="form-control"
                                                           name="salary">
                    </fieldset>

                <button type="submit" class="btn btn-success">Save</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
