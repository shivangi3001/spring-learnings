<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>

<div class="container">
  <h1> Student List Page </h1>
  <c:choose>
    <c:when test="${!empty studentDtoList}">
      <table class="table-bordered table-hover">
        <tr class="danger">
          <th>Id</th> <th>Name</th> <th>Course</th> <th>Projects</th>
        </tr>

        <c:forEach var="studentDto" items="${studentDtoList}">
          <tr class="bg-success text-white">
            <td>${studentDto.id}</td>
            <td>${studentDto.name}</td>
            <td>${studentDto.course}</td>
            <td>${studentDto.projDone}</td>
          </tr>
        </c:forEach>

      </table>
    </c:when>

    <c:otherwise>
      <h1 class="bg-warning text-white">No records found</h1>
    </c:otherwise>
  </c:choose>

  <br>
  <h3> <a href="welcome">Home Page</a> </h3>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
