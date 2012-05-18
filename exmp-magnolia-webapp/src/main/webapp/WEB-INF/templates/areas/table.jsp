<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="cms" uri="http://magnolia-cms.com/taglib/templating-components/cms" %>

<c:if test="${!empty components}">
    <div class="entry-table">
        <c:if test="${!empty content.caption}">
            <div class="entry-caption">${content.caption}</div>
        </c:if>
        <c:if test="${content.wide}">
            <table width="100%">
        </c:if>
        <c:if test="${!content.wide}">
            <table>
        </c:if>
                <tbody align="left">
                    <c:forEach items="${components}" var="component">
                        <tr>
                            <cms:component content="${component}" />
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
    </div>
</c:if>