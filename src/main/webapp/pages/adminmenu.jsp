<%--
  Created by IntelliJ IDEA.
  User: dima2
  Date: 27.11.2021
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Admin menu</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-sm-9">
            <c:if test="${sessionScope.user.admin==1}">
            <fieldset>
                <legend>Зарегистрированные пользователи</legend>
                <ol class="list-group list-group-flush">
                    <c:forEach var="user" items="${sessionScope.users}">
                        <c:if test="${sessionScope.user.id!=user.id}">
                            <li class="list-group-item">
                                <form action="${pageContext.request.contextPath}/user/adminmenu" method="post">
                                    <p><label>
                                        <input type="text" name="userId" hidden value="${user.id}">
                                    </label> ${user.name}
                                        <c:if test="${user.admin==1}"> - администратор</c:if>
                                        <c:if test="${user.admin==0}"> - пользователь</c:if>
                                        <button type="submit" name="operation" class="btn btn-danger" value="del">
                                            Удалить
                                        </button>
                                        <button type="submit" name="operation" class="btn btn-primary" value="adminon">
                                            Назначить администратором
                                        </button>
                                        <button type="submit" name="operation" class="btn btn-primary" value="adminoff">
                                            Назначить пользователем
                                        </button>
                                        <button type="submit" name="operation" class="btn btn-info"
                                                value="history_operation">История
                                            операций
                                        </button>
                                    </p>
                                    <c:if test="${requestScope.operation.equals('history_operation')}">
                                        <c:if test="${userid==user.id}">
                                            <c:forEach var="results" items="${results}">
                                                <ul class="list-group">
                                                    <li class="list-group-item">${results.num1} ${results.operation} ${results.num2}
                                                        = ${results.result}</li>
                                                </ul>
                                            </c:forEach>
                                        </c:if>
                                    </c:if>
                                </form>
                            </li>
                        </c:if>
                    </c:forEach>
                </ol>
                </c:if>
        </div>
    </div>
</div>
</body>
</html>
