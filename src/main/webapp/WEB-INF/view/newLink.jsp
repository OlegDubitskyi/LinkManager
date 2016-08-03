<%@ page language="java" contentType="text/html; 	charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="cf"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01   
       Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet"
	type="text/css">

<!-- Bootstrap Core CSS -->
<link
	href="<c:url value="/resources/bower_components/bootstrap/dist/css/bootstrap.min.css" />"
	rel="stylesheet">
<!-- MetisMenu CSS -->
<link
	href="<c:url value="/resources/bower_components/metisMenu/dist/metisMenu.min.css" />"
	rel="stylesheet">
<!-- DataTables CSS -->
<link
	href="<c:url value="/resources/bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.css" />"
	rel="stylesheet">
<!-- DataTables Responsive CSS -->
<link
	href="<c:url value="/resources/bower_components/datatables-responsive/css/dataTables.responsive.css" />"
	rel="stylesheet">
<!-- Custom CSS -->
<link href="<c:url value="/resources/dist/css/sb-admin-2.css" />"
	rel="stylesheet">
<!-- Custom Fonts -->
<link
	href="<c:url value="/resources/bower_components/font-awesome/css/font-awesome.min.css" />"
	rel="stylesheet" type="text/css">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>New Link</title>
<style>
.error {
	color: red;
	font-weight: bold;
}
</style>

</head>
<body>
	<div id="page-wrapper">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header"><a href="list" >Link Manager</a></h1>
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<!-- /.row -->
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">Add/Edit Link</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-6">
								<cf:form method="POST" action="addLink" modelAttribute="article" role="form" >
									<cf:hidden path="id" />
									<cf:hidden path="categoryId" />
									<div class="form-group">
										<cf:label path="linkName">Link Name</cf:label> 
										<cf:input path="linkName" class="form-control" placeholder="Enter text" /><br /> <cf:errors
											path="linkName" cssClass="error" />
									</div>
									<div class="form-group">
										<cf:label path="url">URL</cf:label> 
										<cf:input path="url" class="form-control" placeholder="Enter text" /><br /> <cf:errors path="url"
											cssClass="error" />
									</div>
									<div class="form-group">
										<cf:label path="keywords">Keywords</cf:label> 
										<cf:input path="keywords" class="form-control" placeholder="Enter text" /><br /> <cf:errors
											path="keywords" cssClass="error" />
									</div>

									<button type="submit" class="btn btn-default">Submit
										Button</button>
								</cf:form>
								
							</div>
							<!-- /.col-lg-6 (nested) -->
						</div>
						<!-- /.row (nested) -->
					</div>
					<!-- /.panel-body -->
				</div>
				<!-- /.panel -->
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<!-- /.row -->
	</div>
	<!-- /#page-wrapper -->

</body>
</html>
