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
          <div class="col-xs-12">
            <ol class="breadcrumb">
              <li><a href="HomeServlet" target="_self">Home</a></li>
              <li><span>/</span></li>
              <li class="active"><span>Return and Exchange</span></li>
            </ol>
          </div>
        </div>
        <div class="row">
          <div class="col-xs-12">
            <h4 id="return">Return/Exchange</h4>
            <div class="content-page border-page">
              <p><b>Condition:</b></p>
              <p>
                <span>Accept returns for the following cases:</span>
              </p>
              <ul>
                <li>
                  <span>The product was damaged during transportation. </span>
                </li>
                <li>
                  <span>The product is damaged during production. </span>
                </li>
                <li>
                  <span
                    >Products are not what you hear, see and look at the website
                    or from a consultant.</span
                  >
                </li>
              </ul>
              <p>
                <span
                  >If your product is not in the categories above, We reserve
                  the right to refuse your return request guest.</span
                >
              </p>
              <p><b>Return/exchagne time:</b></p>

              <p>
                <span>Fixed exchange time within 30 days.</span>
              </p>
              <p><b>Terms of return/exchange</b></p>
              <ul>
                <li>
                  <span
                    >Same product code (only change size, change color): Free
                    exchange fee</span
                  >
                </li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </main>
	
	
	
	<!-- FOOTER-->
	<jsp:include page="layout/footer.jsp" />
	<!-- END FOOTER-->

</body>
</html>
	