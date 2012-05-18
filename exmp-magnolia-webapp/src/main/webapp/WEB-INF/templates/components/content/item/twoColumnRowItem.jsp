<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${content.header}">
    <th>${content.firstValue}</th>
    <th>${content.secondValue}</th>
</c:if>
<c:if test="${!content.header}">
    <td>${content.firstValue}</td>
    <td>${content.secondValue}</td>
</c:if>