<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="cms" uri="http://magnolia-cms.com/taglib/templating-components/cms" %>
<%@ taglib prefix="cmsfn" uri="http://magnolia-cms.com/taglib/templating-components/cmsfn" %>

<div class="entry">
    <div class="entry-title">${content.title}</div>
    <div class="entry-image-${content.imagePosition}">
        <a href="${content.imageLink}" target="_blank">
            <img src="${content.imageLink}" />
        </a>
    </div>
    <div class="entry-content">${cmsfn:decode(content).content}</div>
    <cms:area name="imageAndTextEntryLink" />
    <div class="entry-clear-${content.imagePosition}"></div>
</div>