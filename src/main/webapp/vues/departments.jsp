<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<link rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
      integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
      crossorigin="anonymous">
</head>
<body class="container my-5">
   <h1 class="mb-5">Departments Table :</h1>
    <table class="table">
        <thead>
          <tr>
            <th scope="col">Id</th>
            <th scope="col">Title</th>
            <th scope="col">List of materials</th>
          </tr>
        </thead>
        <tbody>
        <c:forEach var="department" items="${departments}">
              <tr>
                <td>${department.id}</td>
                <td>${department.title}</td>
                <td><a href="<c:url value='/api/department/${department.id}'/>">List of materials</a></td>
              </tr>
         </c:forEach>
        </tbody>
      </table>

</body>
</html>
