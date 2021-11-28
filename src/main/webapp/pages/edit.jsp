<%--
  Created by IntelliJ IDEA.
  User: dima2
  Date: 27.11.2021
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<%--<p>Hello ${sessionScope.user.name}</p>--%>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-sm-3">
            <form action="${pageContext.request.contextPath}/user/edit" method="post">
                <label style="margin-top: 1rem" for="floatingInput">Редактирование профиля ${sessionScope.user.name}</label>
                <div class="form-floating mb-3 mt-1">
                    <input type="text" name="name" class="form-control" id="floatingInput" placeholder="Name">
                    <label for="floatingInput">${sessionScope.user.name}</label>
                </div>
                <div class="form-floating mb-3">
                    <input type="text" name="username" class="form-control" id="floatingInput1" placeholder="Login">
                    <label for="floatingInput1">${sessionScope.user.userName}</label>
                </div>
                <div class="form-floating">
                    <input type="password" name="password" class="form-control" id="floatingPassword" placeholder="Password">
                    <label for="floatingPassword">Password</label>
                </div>
                <button type="submit" class="btn btn-primary mt-2">Submit</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
