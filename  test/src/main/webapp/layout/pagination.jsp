<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<ul class="pagination pull-right">
	<c:forEach begin="1" end="${totalPage}" var="page" >
		<li ><a class="page " href="category?command=CATEGORY&category=${categoryPage}&pageId=${page}"
			>${page}</a></li>
	</c:forEach>
</ul>