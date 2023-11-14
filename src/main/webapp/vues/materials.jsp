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
  <h1 class="mb-5">Materials Table :</h1>
  <h2 class="mb-5">Selected Department : Department ${dep.title}</h2>

  <a href="<c:url value='/api/formMaterial'/>">Add new Material</a>

  <table class="table">
  <thead>
      <tr>
        <th scope="col">Id</th>
        <th scope="col">Title</th>
        <th scope="col">Type</th>
        <th scope="col">Number</th>
        <th scope="col">Quantity</th>
        <th scope="col">State</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach var="material" items="${materials}">
          <tr>
            <td>${material.id}</td>
            <td>${material.title}</td>
            <td>${material.type}</td>
            <td>${material.num_series}</td>
            <td>${material.qte}</td>
            <td>${material.state}</td>
            <td><a href="<c:url value='/api/deleteMaterial/${material.id}'/>">Delete</a></td>
          </tr>
     </c:forEach>
    </tbody>
  </table>

</body>
</html>
