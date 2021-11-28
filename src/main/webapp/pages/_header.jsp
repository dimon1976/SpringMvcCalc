<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <nav class="navbar navbar-light bg-light">
            <div class="container">
                <a class="navbar-brand" href="<c:url value="/"/>">
                        <img src="images/62837181.jpg" alt="" width="30" height="24">
                </a>
            </div>
        </nav>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <c:if test="${sessionScope.user==null}">
                <li class="nav-item">
                    <a class="nav-link" href="/user/register">Registration</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/user/authorization">Authorization</a>
                </li>
                </c:if>
                <c:if test="${sessionScope.user!=null}">
                <li class="nav-item">
                    <a class="nav-link" href="/user/edit">Edit user</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/user/delete">Delete user</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/calc">Calc</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/user/logout">Logout</a>
                </li>
                <c:if test="${sessionScope.user.admin==1}">
                <li class="nav-item">
                    <a class="nav-link" href="/user/adminmenu">Administrator menu</a>
                </li>
                </c:if>
                </c:if>
        </div>
    </div>
</nav>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>