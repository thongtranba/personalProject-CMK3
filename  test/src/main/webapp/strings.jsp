<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <!-- HEAD-->
<jsp:include page="layout/head.jsp" />
  <body>
   <!-- HEADER-->
	<jsp:include page="layout/header.jsp" />
	<!-- END HEADER-->
   
    <main id="maincontent" class="page-main">
      <div class="container">
        <div class="row">
          <div class="col-xs-9">
            <ol class="breadcrumb">
              <li><a href="homeServlet" target="_self">Home</a></li>
              <li><span>/</span></li>
              <li class="active"><span>Strings</span></li>
            </ol>
          </div>
          <div class="col-xs-3 hidden-lg hidden-md">
            <a
              class="hidden-lg pull-right btn-aside-mobile"
              href="javascript:void(0)"
              >Sort <i class="fa fa-angle-double-right"></i
            ></a>
          </div>
          <div class="clearfix"></div>
          <aside class="col-md-3">
            <div class="inner-aside">
              <div class="category">
                <h5>Brand</h5>
                <ul>
                  <li class="active">
                    <a href="#" title="Yonex" target="_self">Yonex </a>
                  </li>
                  <li class="">
                    <a href="#" title="Lining" target="_self">Lining</a>
                  </li>
                  <li class="">
                    <a href="#" title="Victor" target="_self">Victor</a>
                  </li>
                  <li class="">
                    <a href="#" title="Forza" target="_self">Forza</a>
                  </li>
                  <li class="">
                    <a href="#" title="RSL" target="_self">RSL</a>
                  </li>

                  <li class="">
                    <a href="#" title="SERV" target="_self">SERV</a>
                  </li>
                </ul>
              </div>
              <div class="price-range">
                <h5>Price</h5>
                <ul>
                  <li>
                    <label for="filter-less-100">
                      <input
                        type="radio"
                        id="filter-less-50"
                        name="filter-price"
                        value="0-50"
                      />
                      <i class="fa"></i>
                      under 50 eur
                    </label>
                  </li>
                  <li>
                    <label for="filter-50-150">
                      <input
                        type="radio"
                        id="filter-50-150"
                        name="filter-price"
                        value="50-150"
                      />
                      <i class="fa"></i>
                      50-100 eur
                    </label>
                  </li>
                  <li>
                    <label for="filter-100-500">
                      <input
                        type="radio"
                        id="filter-50-150"
                        name="filter-price"
                        value="100-500"
                      />
                      <i class="fa"></i>
                      100-500 eur
                    </label>
                  </li>
                  <li>
                    <label for="filter-500-1000">
                      <input
                        type="radio"
                        id="filter-50-150"
                        name="filter-price"
                        value="500-1000"
                      />
                      <i class="fa"></i>
                      500-1000 eur
                    </label>
                  </li>

                  <li>
                    <label for="filter-greater-1000">
                      <input
                        type="radio"
                        id="filter-greater-1000"
                        name="filter-price"
                        value="1000"
                      />
                      <i class="fa"></i>
                      greater 1000 eur
                    </label>
                  </li>
                </ul>
              </div>
            </div>
          </aside>
          <div class="col-md-9 products">
            <div class="row equal">
              <div class="col-xs-6">
                <h4 class="home-title">String & Services</h4>
              </div>
              <div class="col-xs-6 sort-by">
                <div class="pull-right">
                  <label class="left hidden-xs" for="sort-select">Sort: </label>
                  <select id="sort-select">
                    <option value="" selected>Default</option>
                    <option value="price-asc">Price increment</option>
                    <option value="price-desc">Price decrement</option>
                    <option value="alpha-asc">A-Z</option>
                    <option value="alpha-desc">Z-A</option>
                    <option value="created-asc">Oldest</option>
                    <option value="created-desc">Newest</option>
                  </select>
                </div>
              </div>
              <div class="clearfix"></div>
             <c:forEach var="string" items="${listStrings}">
              <div class="col-xs-6 col-sm-4">
                <div class="product-container">
                  <div class="image">
                    <img
                      class="img-responsive"
                      src="${string.image}"
                      alt=""
                    />
                  </div>
                  <div class="product-meta">
                    <h5 class="name">
                      <a
                        class="product-name"
                        href="productDetail?id=<c:out value='${string.id}' />"
                        title="${string.name}"
                        >${string.name}</a
                      >
                    </h5>
                    <div class="product-item-price">
                      <span class="product-item-regular">${string.price} euro</span>
                      <span class="product-item-discount">108 euro</span>
                    </div>
                  </div>
                  <div class="button-product-action clearfix">
                    <div class="cart icon">
                      <a
                        class="btn btn-outline-inverse buy"
                        product-id="1"
                        href="javascript:void(0)"
                        title="add to cart"
                      >
                        add to cart <i class="fa fa-shopping-cart"></i>
                      </a>
                    </div>
                    <div class="quickview icon">
                      <a
                        class="btn btn-outline-inverse"
                        href="productDetail?id=<c:out value='${string.id}' />"
                        title="quick view"
                      >
                        detail <i class="fa fa-eye"></i>
                      </a>
                    </div>
                  </div>
                </div>
              </div>
                </c:forEach>
           
            <!-- Paging -->
            <ul class="pagination pull-right">
              <li class="active">
                <a href="javascript:void(0)" onclick="goToPage(1)">1</a>
              </li>
              <li class="">
                <a href="javascript:void(0)" onclick="goToPage(2)">2</a>
              </li>
              <li class="">
                <a href="javascript:void(0)" onclick="goToPage(3)">3</a>
              </li>
              <li>
                <a href="javascript:void(0)" onclick="goToPage(2)">&raquo;</a>
              </li>
            </ul>
            <!-- End paging -->
          </div>
        </div>
      </div>
    </main>
   <!-- FOOTER-->
	<jsp:include page="layout/footer.jsp" />
	<!-- END FOOTER-->
  </body>
</html>
