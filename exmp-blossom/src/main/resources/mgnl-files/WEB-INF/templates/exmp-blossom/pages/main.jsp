<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="cms" uri="http://magnolia-cms.com/taglib/templating-components/cms" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
    <cms:init />
    <head>
        <title>${content.title}</title>
        <meta name="description" content="${content.metaDescription}" />
        <meta name="keywords" content="${content.metaKeywords}" />
        <link href="${pageContext.request.contextPath}/docroot/exmp-blossom/images/icon.ico" rel="shortcut icon" />
        <link href="${pageContext.request.contextPath}/docroot/exmp-blossom/styles/exmp-blossom.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <div class="container">
            <cms:area name="menu" />
            <cms:area name="header" />
            <cms:area name="content" />
            <cms:area name="sidebar" />
            <cms:area name="footer" />
        </div>
    </body>
</html>