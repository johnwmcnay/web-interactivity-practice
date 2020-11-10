<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Test" />
    </jsp:include>
</head>
<body>
    <h3><c:out value="${message}" /></h3>
    <p><c:out value="${id}" /></p>

    <c:choose>
        <c:when test="${id == 1}">
            <c:out value="You are Player 1" />
                <jsp:include page="/WEB-INF/partials/rps.jsp">
                    <jsp:param name="disabled" value="" />
                </jsp:include>
        </c:when>
        <c:otherwise>
            <c:out value="Player 1" />
            <jsp:include page="/WEB-INF/partials/rps.jsp">
                <jsp:param name="disabled" value="disabled" />
            </jsp:include>
        </c:otherwise>
    </c:choose>

    <br>

    <c:choose>
        <c:when test="${id == 2}">
            <c:out value="You are Player 2" />
            <jsp:include page="/WEB-INF/partials/rps.jsp">
                <jsp:param name="disabled" value="" />
            </jsp:include>
        </c:when>
        <c:otherwise>
            <c:out value="Player 2" />
                <jsp:include page="/WEB-INF/partials/rps.jsp">
            <jsp:param name="disabled" value="disabled" />
        </jsp:include>
        </c:otherwise>
    </c:choose>

</body>
</html>
