<%--
  Created by IntelliJ IDEA.
  User: dima2
  Date: 27.11.2021
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<div class="container">
    <div class="row justify-content-center m-5">
        <div class="col-sm-9">
            <form class="row gx-3 gy-2 align-items-center" action="${pageContext.request.contextPath}/calc/calc"
                  method="post">
                <div class="col-sm-3">
                    <label class="visually-hidden" for="specificSizeInputName">Number</label>
                    <input type="number" name="num1" class="form-control" id="specificSizeInputName"
                           placeholder="Number">
                </div>
                <div class="col-sm-3">
                    <label class="visually-hidden" for="specificSizeSelect">Preference</label>
                    <select name="operation" class="form-select" id="specificSizeSelect">
                        <option selected>Choose...</option>
                        <option value="sum">+</option>
                        <option value="subtrack">-</option>
                        <option value="multiply">*</option>
                        <option value="div">/</option>
                    </select>
                </div>
                <div class="col-sm-3">
                    <label class="visually-hidden" for="specificSizeInputName2">Number</label>
                    <input type="number" name="num2" class="form-control" id="specificSizeInputName2"
                           placeholder="Number">
                </div>
                <div class="col-auto">
                    <button type="submit" class="btn btn-primary">=</button>
                </div>
                <c:if test="${requestScope.message!=null}">
                    <div class="col-sm-3 justify-content-center">
                        <div class="alert alert-dark" role="alert">
                                ${requestScope.message}
                        </div>
                    </div>
                </c:if>
                <c:if test="${requestScope.results!=null}">
                    <fieldset>
                        <legend>История операций</legend>
                        <c:forEach var="results" items="${requestScope.results}">
                            <ol class="list-group list-group-numbered">
                                <li class="list-group-item mt-1">${results.num1} ${results.operation} ${results.num2}
                                    = ${results.result}</li>
                            </ol>
                        </c:forEach>
                    </fieldset>
                </c:if>
            </form>
        </div>
    </div>

</div>
</body>
</html>
