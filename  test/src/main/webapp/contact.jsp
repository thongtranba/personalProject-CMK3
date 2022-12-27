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
                            <li><a href="home.jsp" target="_self">Home</a></li>
                            <li><span>/</span></li>
                            <li class="active"><span>Contact</span></li> 
                        </ol>
                    </div>
                </div>
                <div class="row contact">
                    <div class="col-md-6">
                        <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d4494.506858724236!2d13.195647300000001!3d55.719347799999994!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x4653962d02e5ab63%3A0x2b2229b92016e5f6!2sSofiaparken%205E%2C%20222%2041%20Lund!5e0!3m2!1sen!2sse!4v1669586785962!5m2!1sen!2sse" width="100%" height="400px"frameborder="0" style="border:0;" allowfullscreen=""></iframe>
                    
                    </div>
                    <div class="col-md-6">
                        <h4>Send your message directly to us:</h4>
                            <form class="form-contact" action="#" method="POST">
                                <div class="form-group">
                                    <input type="text" class="form-control" name="fullname"  placeholder="Your name" required oninvalid="this.setCustomValidity('type your name')" oninput="this.setCustomValidity('')">
                                </div>
                                <div class="row">
                                    <div class="form-group col-sm-6">
                                        <input type="email" class="form-control" name="email" placeholder="Email" required oninvalid="this.setCustomValidity('type your email')" oninput="this.setCustomValidity('')">
                                    </div>
                                    <div class="form-group col-sm-6">
                                        <input type="tel" class="form-control" name="mobile" placeholder="Mobile phone" required pattern="[0][0-9]{9,}"
                                        oninvalid="this.setCustomValidity('start at 0')" oninput="this.setCustomValidity('')">
                                    </div>
                                    
                                    <div class="form-group col-sm-12">
                                        
                                        <textarea class="form-control" placeholder="Your message" name="content" rows="10" required></textarea>
                                    </div>
                                    <div class="form-group col-sm-12">
                                        <button type="submit" class="btn btn-sm btn-primary pull-right">Send</button>
                                    </div>
                                </div>
                            </form>
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