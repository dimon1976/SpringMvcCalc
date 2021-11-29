<%--
  Created by IntelliJ IDEA.
  User: dima2
  Date: 27.11.2021
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Authorization</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-sm-3">
            <form action="/user/authorization" method="post">
                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">login</label>
                    <input type="text" name="username" class="form-control" id="exampleInputEmail1"
                           aria-describedby="emailHelp">
                </div>
                <div class="mb-3">
                    <label for="exampleInputPassword1" class="form-label">Password</label>
                    <input type="password" name="password" class="form-control" id="exampleInputPassword1">
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
            <c:if test="${message}">
                <div class="alert alert-danger" role="alert">
                        ${message}
                </div>
            </c:if>
        </div>
    </div>
</div>
</body>
</html>
