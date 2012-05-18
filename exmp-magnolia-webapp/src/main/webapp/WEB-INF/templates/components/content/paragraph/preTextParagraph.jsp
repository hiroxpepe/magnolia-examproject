<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="cms" uri="http://magnolia-cms.com/taglib/templating-components/cms" %>
<%@ taglib prefix="cmsfn" uri="http://magnolia-cms.com/taglib/templating-components/cmsfn" %>

<div class="entry-paragraph-pre-text">
    <div class="entry-pre">
        <c:if test="${!empty content.caption}">
            <div class="entry-caption">${content.caption}</div>
        </c:if>
        <div class="entry-pre-body">    
            <pre>${cmsfn:decode(content).text}</pre>
        </div>
    </div>
</div>