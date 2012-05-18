<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="cms" uri="http://magnolia-cms.com/taglib/templating-components/cms" %>

<c:if test="${!empty components}">
    <div class="entry-link">
        <c:if test="${!empty content.caption}">
            <div class="entry-caption">${content.caption}</div>
        </c:if>
        <div class="entry-link-body">
            <c:forEach items="${components}" var="component">
                <cms:component content="${component}" />
            </c:forEach>
        </div>
    </div>
</c:if>