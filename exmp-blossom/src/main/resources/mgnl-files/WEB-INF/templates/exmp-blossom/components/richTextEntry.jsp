<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="cms" uri="http://magnolia-cms.com/taglib/templating-components/cms" %>
<%@ taglib prefix="cmsfn" uri="http://magnolia-cms.com/taglib/templating-components/cmsfn" %>

<div class="entry">
    <div class="entry-title">${content.title}</div>
    <div class="entry-content">${cmsfn:decode(content).content}</div>
    <cms:area name="richTextEntryLink" />
</div>