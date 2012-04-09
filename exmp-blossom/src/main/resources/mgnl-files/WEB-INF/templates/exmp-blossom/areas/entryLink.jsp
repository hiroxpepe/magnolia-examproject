<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="cms" uri="http://magnolia-cms.com/taglib/templating-components/cms" %>

<c:if test="${!empty components}">
    <div class="entry-link">
        <c:forEach items="${components}" var="component">
            <cms:component content="${component}" />
        </c:forEach>
    </div>
</c:if>