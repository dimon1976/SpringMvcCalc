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
    <title>Delete</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<div class="container">
  <div class="row justify-content-center m-5">
    <div class="col-sm-3">
      <form action="<c:url value="/user/delete"/>" method="post">
        <button type="submit" name="confirm" value="yes" class="btn btn-primary">Confirm delete</button>
      </form>
    </div>
  </div>
</div>
</body>
</html>
