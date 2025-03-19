<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form modelAttribute="student"  method="POST">

  Student Id: <form:input path="id" /> <br>
  Name: <form:input  path="name" /> <br>
  Email: <form:input path="email" /> <br>
  Course: <form:input path="course" /> <br>
  <input type="submit" value"Register Now">
 </form:form>