<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="cms" uri="http://magnolia-cms.com/taglib/templating-components/cms" %>
<%@ taglib prefix="cmsfn" uri="http://magnolia-cms.com/taglib/templating-components/cmsfn" %>

<c:if test="${content.display == 'true'}">
    <div class="entry-paragraph-text">
        <div class="entry-content">${cmsfn:decode(content).text}</div>
    </div>
</c:if>