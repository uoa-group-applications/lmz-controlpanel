<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!doctype html>
<html lang="en">
    <head>
        <link href="${contextPath}/cpassets/bootstrap-combined-2.3.2.min.css" rel="stylesheet">
        <script src="${contextPath}/js/common/base/jquery-1.9.1.min.js"></script>
        <script src="${contextPath}/cpassets/bootstrap-2.3.2.min.js"></script>
        <style>
            <%@ include file="controlpanel.css" %>
        </style>

        <%-- output the asset information --%>
        <c:if test="${! empty assets}">

            <%-- embedded asset output --%>
            <c:if test="${! empty assets.embeds}">
                <c:forEach items="${assets.embeds}" var="assetInfo">
                    <%@ include file="assets.jsp" %>
                </c:forEach>
            </c:if>

            <%-- base asset output --%>
            <c:set var="assetInfo" value="${assets}" />
            <%@ include file="assets.jsp" %>
        </c:if>
    </head>
    <body>

        <%@ include file="header.jsp" %>
        <%@ include file="body.jsp" %>
        <%@ include file="footer.jsp" %>

    </body>
</html>
