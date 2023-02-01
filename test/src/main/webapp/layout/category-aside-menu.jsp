<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="price-range">
	<h5>Brand</h5>
	<ul>
		<c:forEach items="${brandList}" var="brand">
			<c:choose>
				<c:when test="${brand.id == brandId }">
					<li><label for="${brand.name}"></label> <input type="radio"
						id="${brand.name}"
						onclick="window.location.href='category?command=CATEGORY&category=${categoryPage}&pageId=1&brandId=${brand.id}&sort=${sortSelected}'"
						checked /> <i class="fa"></i> ${brand.name}
				</c:when>
				<c:otherwise>
					<li><label for="${brand.name}"></label> <input type="radio"
						id="${brand.name}" name="${brand.name}"
						onclick="window.location.href='category?command=CATEGORY&category=${categoryPage}&pageId=1&brandId=${brand.id}&sort=${sortSelected}'" />
						<i class="fa"></i> ${brand.name}
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</ul>
</div>
