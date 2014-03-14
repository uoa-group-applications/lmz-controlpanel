<c:if test="${!empty assetInfo.stylesheets}">
    <c:forEach items="${assetInfo.stylesheets}" var="stylesheet">
        <link href="${stylesheet}" rel="stylesheet" type="text/css" />
    </c:forEach>
</c:if>

<c:if test="${!empty assetInfo.javascripts}">
    <c:forEach items="${assetInfo.javascripts}" var="javascript">
        <script type="text/javascript" src="${javascript}"></script>
    </c:forEach>
</c:if>