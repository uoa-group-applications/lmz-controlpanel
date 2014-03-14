<%@ include file="panelheader.jspf" %>

<h2>Build</h2>

<p>
    This tab contains information regarding the build information. All password related elements have been removed.
</p>

<table class="table">
    <thead>
        <tr>
            <th>Name</th>
            <th>Value</th>
        </tr>
    </thead>
    <c:forEach items="${model.info}" var="pair">
        <tr>
            <td>${pair.key}</td>
            <td>${pair.value}</td>
        </tr>
    </c:forEach>
</table>