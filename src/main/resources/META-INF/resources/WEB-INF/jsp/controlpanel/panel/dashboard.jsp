<%@ include file="panelheader.jspf" %>
<h2>Dashboard</h2>

<c:choose>
    <c:when test="${! empty model.panels}">

        <ul class="dashboard-list">
            <c:forEach items="${model.panels}" var="panel" varStatus="panelStatus">
                <li>
                    <a href="${contextPath}/controlpanel/${panel.uri}">
                        ${panel.title}
                    </a>
                    <p>
                        ${panel.description}
                    </p>
                </li>
            </c:forEach>
        </ul>

    </c:when>

    <c:otherwise>
        <p class="text-info">There are currently no control panels available</p>
    </c:otherwise>
</c:choose>
