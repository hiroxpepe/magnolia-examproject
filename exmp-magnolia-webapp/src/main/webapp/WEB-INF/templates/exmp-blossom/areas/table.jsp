<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="cms" uri="http://magnolia-cms.com/taglib/templating-components/cms" %>

<c:if test="${!empty components}">
    <div class="entry-table">
        <table>
            <c:forEach items="${components}" var="component">
                <tr>
                    <cms:component content="${component}" />
                </tr>
            </c:forEach>
        </table>
    </div>
</c:if>