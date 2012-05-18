<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="cms" uri="http://magnolia-cms.com/taglib/templating-components/cms" %>

<div class="header">
    <div class="block header-content">
        <span class="header-logo"><img src="<c:url value="/docroot/images/icon-64a.png" />" width="32" height="32" border="0"></span>
        <span class="header-title">${content.title}</span>
        <span class="header-sub-title">${content.subTitle}</span>
    </div>
</div>