<%@ page language="java"
         contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE >
<html>
<head>
    <jsp:include page="includeCSS.jsp"/>
</head>
<body>
    <div class="container">
        <form action="/login" method="post">
            <div class="form-group">
                <label for="exampleInputEmail1">Username</label>
                <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"
                       placeholder="Username">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Password</label>
                <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
            <c:if test="${param.error ne null}">
                   <div class="alert-danger">Invalid username and password.</div>
                  </c:if>
              <c:if test="${param.logout ne null}">
               <div class="alert-normal">You have been logged out.</div>
              </c:if> 
              <input type="hidden" name="${_csrf.parameterName}"
                        value="${_csrf.token}"/>
        </form>
    </div>
</body>
