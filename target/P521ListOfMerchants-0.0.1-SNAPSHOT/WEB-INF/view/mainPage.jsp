<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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




<title>Categories List</title>
</head>
<body>
	<div id="page-wrapper">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header"><a href="list">Link Manager<a/></h1>
			</div>
			<!-- /.col-lg-12 -->
		</div>
		
		
		
		
		
		<!-- /.row -->
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">Categories</div>
					<!-- /.panel-heading -->
					<div class="panel-body">
						<div class="dataTable_wrapper">
							<!-- /.table-responsive -->
							<div class="well">
								<a class="btn btn-default btn-lg btn-block"
									href="newCategory.html">Add category</a>
							</div>
							<table class="table table-striped table-bordered table-hover"
								id="dataTables-example">
								<thead>
									<tr>
										<th width="60%">Category name</th>
										<th>ID</th>
										<th>Delete</th>
										<th>Edit</th>
										<th>Add Link</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="category" items="${categoriesList}">
										<tr>
											<td><a href="showLinks&${category.id}"><c:out
														value="${category.name}" />(<c:out
														value="${category.numberOfLinks}" />)</a></td>
											<td><c:out value="${category.id}" /></td>
											<td><a href="delete&${category.id}">delete</a></td>
											<td><a href="edit&${category.id}">edit</a></td>
											<td><a href="newLink&${category.id}">add link</a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>

					</div>
					<!-- /.panel-body -->
				</div>
				<!-- /.panel -->
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<!-- /.row -->
</body>
</html>
