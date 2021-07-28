<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Employee Management System </title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">

</head>
<body>
    <header>
        <nav class="navbar navbar-expand-md navbar-dark"
             style = "background-color: blue">
            <div>
                <a class ="navbar-brand">Employee Management System View</a>
            </div>

            <ul class="navbar-nav">
                <li><a href="<%=request.getContextPath()%>/view"
                       class="nav-link">Employee</a></li>
            </ul>


        </nav>
    </header>
    <br>

        <div class = "row">
            <!--<div class = "alert alert-success" *ngIf = 'message'>{{message}}</div>-->
            <div class  = "container">
                <h3 class = "text-center">List of Employees</h3>
                <hr>
                <div class="container text-left">

                    <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
                        New Employee</a>
                </div>
                <br>
                <table class = "table table-bordered">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Department</th>
                            <th>Salary</th>
                        </tr>
                    </thead>
                    <tbody>

                        <c:forEach var="employee" items="${listEmployee}">
                            <tr>
                                <td ><c:out value = "${employee.id}" /></td>
                                <td ><c:out value = "${employee.name}" /></td>
                                <td ><c:out value = "${employee.department}" /></td>
                                <td ><c:out value = "${employee.salary}" /></td>
                                <td><a href="delete?id=<c:out value='${employee.id}' />">Delete</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
</body>
</html>
