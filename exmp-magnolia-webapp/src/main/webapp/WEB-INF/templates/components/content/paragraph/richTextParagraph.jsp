<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="cms" uri="http://magnolia-cms.com/taglib/templating-components/cms" %>
<%@ taglib prefix="cmsfn" uri="http://magnolia-cms.com/taglib/templating-components/cmsfn" %>

<c:if test="${content.display == 'true'}">
    <div class="entry-paragraph-rich-text">
        <c:if test="${!empty content.caption}">
            <div class="entry-caption">${content.caption}</div>
        </c:if>
        <div class="entry-content">${cmsfn:decode(content).text}</div>
    </div>
</c:if>