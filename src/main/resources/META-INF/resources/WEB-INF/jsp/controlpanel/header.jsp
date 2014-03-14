<div class="header">

   <%-- center on page in single row --%>
   <div class="container">

       <div class="row">

           <%-- draw the tabs navigation bar --%>
           <div class="navbar">
               <div class="navbar-inner">
                   <a class="brand" href="#">Control panel</a>
                   <ul class="nav">
                       <c:forEach items="${panels}" var="panel" varStatus="panelStatus">
                           <li class="${panel.uri == activeUri ? 'active' : ''}">
                               <a href="${contextPath}/controlpanel/${panel.uri}">
                                   <spring:escapeBody>${panel.title}</spring:escapeBody>
                               </a>
                           </li>
                       </c:forEach>
                   </ul>
               </div>
           </div>

       </div>

   </div>

</div>