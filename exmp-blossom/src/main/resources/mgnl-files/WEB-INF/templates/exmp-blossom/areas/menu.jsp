<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="cms" uri="http://magnolia-cms.com/taglib/templating-components/cms" %>

<div class="menu">
    <div class="block menu-content">
        <div class="menu-bar">
            <c:forEach items="${components}" var="component">
                <cms:component content="${component}" />
            </c:forEach>
        </div>
    </div>
</div>