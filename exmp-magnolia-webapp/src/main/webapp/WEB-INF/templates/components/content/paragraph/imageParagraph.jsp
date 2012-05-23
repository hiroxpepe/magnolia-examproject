<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="cms" uri="http://magnolia-cms.com/taglib/templating-components/cms" %>
<%@ taglib prefix="cmsfn" uri="http://magnolia-cms.com/taglib/templating-components/cmsfn" %>

<c:if test="${content.display == 'true'}">
    <div class="entry-paragraph-image">
        <c:if test="${!empty content.caption}">
            <div class="entry-caption">${content.caption}</div>
        </c:if>
        <div class="entry-image-${content.imagePosition}">
            <a href="${content.imageLink}" target="_blank">
                <img src="${content.imageLink}" />
            </a>
        </div>
        <div class="entry-clear-${content.imagePosition}"></div>
    </div>
</c:if>