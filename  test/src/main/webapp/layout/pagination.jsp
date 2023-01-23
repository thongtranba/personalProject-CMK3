<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${totalPage > 1}">
	<div id="page_content">
		<table id="pagination">
			<tr>
				<c:if test="${currentPage != 1}">
					<td class="previous-off"><input type="button" value="Previous"
						onclick="window.location.href='category?command=CATEGORY&category=${categoryPage}&pageId=${currentPage - 1}'"></td>
				</c:if>
				<c:forEach begin="1" end="${totalPage}" var="page">
					<c:choose>
						<c:when test="${currentPage == page }">
							<td class="active">${page}</td>
						</c:when>
						<c:otherwise>
							<td><a
								href="category?command=CATEGORY&category=${categoryPage}&pageId=${page}">${page}</a></td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:if test="${currentPage < totalPage}">
					<td class="next-off"><input type="button" value="Next"
						onclick="window.location.href='category?command=CATEGORY&category=${categoryPage}&pageId=${currentPage + 1}'">
					</td>
				</c:if>
			</tr>
		</table>
	</div>
</c:if>