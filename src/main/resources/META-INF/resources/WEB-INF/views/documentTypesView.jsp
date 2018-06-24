<%@ page language="java"
         contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE >
<html>
<head>
    <jsp:include page="includeCSS.jsp"/>
    <%--<link rel="stylesheet" href="css/style.css">--%>
    <style>
        #searchField {
            width: 100%;
            font-size: 16px;
            padding: 12px 20px 12px 40px;
            border: 1px solid #ddd;
            margin-bottom: 12px;
        }
    </style>
</head>
<body>
    <jsp:include page="menu.jsp"/>
    <div class="container">
        <h1 class="display-4">Document Types</h1>
        <p>
            <button class="btn btn-warning" type="button" data-toggle="collapse" data-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
                Add new
            </button>
        </p>
        <div class="collapse" id="collapseExample">
            <div class="card card-body">
                <form action="/document_management_system/document_types/add_new" method="post">
                    <div class="form-group">
                        <label for="documentTypeName">New Documet Type</label>
                        <input class="form-control" name="name" id="documentTypeName" placeholder="Document type name">
                    </div>
                    <button type="submit" class="btn btn-success">Save</button>
                </form>
            </div>
        </div>
        <input type="text" id="searchField" onkeyup="filterByName()" placeholder="Search by name..">
        <table class="table" id="documentTypesTable">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">Name</th>
                    <th scope="col">Actions</th>
                </tr>
            </thead>
            <c:forEach items="${types}" var="type">
                <tr>
                    <td><c:out value="${type.name}"/></td>
                    <td>
                        <form class="form-inline">
                            <button type="button" class="btn btn-outline-info pull-lef details" onclick="window.location.href='/document_management_system/document_types/' + ${type.id}">Details</button>
                            <button type="button" class="btn btn-outline-danger pull-right" onclick="window.location.href='/document_management_system/document_types/delete/' + ${type.id}">Delete</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <script>
        function filterByName() {
            var input, filter, table, tr, td, i;
            input = document.getElementById("searchField");
            filter = input.value.toUpperCase();
            table = document.getElementById("documentTypesTable");
            tr = table.getElementsByTagName("tr");

            for (i = 0; i < tr.length; i++) {
                td = tr[i].getElementsByTagName("td")[0];
                if (td) {
                    if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
                        tr[i].style.display = "";
                    } else {
                        tr[i].style.display = "none";
                    }
                }
            }
        }
    </script>
    <jsp:include page="includeJS.jsp"/>
</body>
</html>