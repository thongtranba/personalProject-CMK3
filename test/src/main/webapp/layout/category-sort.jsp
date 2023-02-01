<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="pull-right">
	<form
		action="category?command=CATEGORY&category=${categoryPage}&pageId=1&brandId=${brandId}"
		method="POST">
		<c:if test="${brandId == null }">
			<c:set var="brandId" value="${brandId=0}" />
		</c:if>
		<c:set var="inputQuantity" value="${product.inputQuantity}" />
		<select id="sort" name="sort">
			<c:forEach items="${sortSelect}" var="sort">
				<c:choose>
					<c:when test="${sort == sortSelected }">
						<option value="${sort}" selected>${sort}</option>
					</c:when>
					<c:otherwise>
						<option value="${sort}">${sort}</option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</select> <input type="submit" class="btn btn-primary " value="Sort">
	</form>
</div>