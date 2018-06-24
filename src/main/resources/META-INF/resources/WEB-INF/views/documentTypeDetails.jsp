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
    <h1 class="display-4">${type.name}</h1>
    <br/>
    <h3>Descriptors</h3>
    <p>
        <button class="btn btn-warning" type="button" data-toggle="collapse" data-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
            Add new descriptor
        </button>
    </p>
    <div class="collapse" id="collapseExample">
        <div class="card card-body">
            <form action="/document_management_system/document_types/${type.id}/add_descriptor" method="post">
                <div class="form-group">
                    <label for="name">Descriptor name</label>
                    <input class="form-control" name="name" id="name" placeholder="Descriptor name">
                    <br>
                    <label for="mandatory">Mandatory</label>
                    <select class="custom-select" name="mandatory" id="mandatory">
                        <option value="true">true</option>
                        <option value="false">false</option>
                    </select>
                    <br>
                    <label for="descriptorType">Type</label>
                    <select class="custom-select" name="descriptorType" id="descriptorType">
                        <option value="INTEGER">INTEGER</option>
                        <option value="LONG">LONG</option>
                        <option value="DOUBLE">DOUBLE</option>
                        <option value="BOOLEAN">BOOLEAN</option>
                        <option value="DATE">DATE</option>
                        <option value="TIME">TIME</option>
                        <option value="STRING">STRING</option>
                    </select>
                </div>
                <button type="submit" class="btn btn-success">Save</button>
            </form>
        </div>
    </div>
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Name</th>
            <th scope="col">Type</th>
            <th scope="col">Mandatory</th>
            <th scope="col">Actions</th>
        </tr>
        </thead>
        <c:forEach items="${type.descriptors}" var="descriptor">
            <tr>
                <td><c:out value="${descriptor.name}"/></td>
                <td><c:out value="${descriptor.descriptorType}"/></td>
                <td><c:out value="${descriptor.mandatory}"/></td>
                <td>
                    <form class="form-inline">
                        <button type="button" class="btn btn-outline-info pull-lef details" onclick="window.location.href='/document_management_system/document_types/' + ${type.id}">Edit</button>
                        <button type="button" class="btn btn-outline-danger pull-right" onclick="window.location.href='/document_management_system/document_types/delete/' + ${type.id}">Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<jsp:include page="includeJS.jsp"/>
</body>
</html>