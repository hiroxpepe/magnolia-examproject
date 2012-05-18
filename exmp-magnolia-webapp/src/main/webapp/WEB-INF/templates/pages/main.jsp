<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="cms" uri="http://magnolia-cms.com/taglib/templating-components/cms" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
    <cms:init />
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta http-equiv="Content-Language" content="en">
        <meta name="description" content="${content.metaDescription}" />
        <meta name="keywords" content="${content.metaKeywords}" />
        <link rel="shortcut icon" href="<c:url value="/docroot/images/icon.ico" />" />
        <link rel="stylesheet" type="text/css" href="<c:url value="/docroot/styles/exmp-blossom.css" />" />
        <script language="javascript" type="text/javascript" src="<c:url value="/docroot/scripts/jquery.js" />"></script>
        <script language="javascript" type="text/javascript" src="<c:url value="/docroot/scripts/jquery-ui.custom.min.js" />"></script>
        <script language="javascript" type="text/javascript" src="<c:url value="/docroot/scripts/exmp-blossom.js" />"></script>
        <title>${content.title}</title>
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