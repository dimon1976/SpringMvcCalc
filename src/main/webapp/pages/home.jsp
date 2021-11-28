<%--
  Created by IntelliJ IDEA.
  User: dima2
  Date: 27.11.2021
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<c:if test="${requestScope.message!=null}">
    <div class="alert alert-danger" role="alert">
            ${requestScope.message}
    </div>
</c:if>
</body>
</html>
