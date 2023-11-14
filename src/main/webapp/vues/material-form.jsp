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
   <h1 class="mt-5">Add New Material :</h1>

   <form:form action="addMaterial" modelAttribute="material">

       <p> Title : <form:input class="form-control" path="title"/> </p>

       <p> Type :<form:select class="form-control" path="type">
            <c:forEach items="${types}" var="type">
                <form:option value="${type}" label="${type}" />
            </c:forEach>
        </form:select>
       </p>

       <p> Series : <form:input class="form-control" path="num_series"/> </p>
       <p> Quantity : <form:input class="form-control" path="qte"/> </p>

       <p> States : <form:select class="form-control" path="state">
            <c:forEach items="${states}" var="state">
                <form:option value="${state}" label="${state}" />
            </c:forEach>
        </form:select>
       </p>

       <p> Department : <form:select class="form-control" path="department.id">
             <form:options items="${departments}" itemValue="id" itemLabel="title"/>
        </form:select>
       </p>

       <input class="btn btn-success mt-3 ml-1" type="submit" value="submit"/>
   </form:form>
</body>
</html>
