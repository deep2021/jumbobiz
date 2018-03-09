<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% boolean no_visable_elements = false; %>
<%@ page isELIgnored="false"%>
<%@ include file="header.jsp" %>
			<div>
				<ul class="breadcrumb">
					<li>
						<a href="#">Home</a> <span class="divider">/</span>
					</li>
					<li>
						<a href="#">Tables</a>
					</li>
				</ul>
			</div>
			<div class="row-fluid sortable">		
				<div class="box span12">
					<div class="box-header well" data-original-title>
						<h2><i class="icon-user"></i>Products</h2>
						<div class="box-icon">
						<h3 ><a class="btn btn-success" href="./addProductForm">
										<i class="icon-zoom-in icon-white"></i>  
                              </a></h3></div>
						<div class="box-icon">
							<a href="#" class="btn btn-setting btn-round"><i class="icon-cog"></i></a>
							<a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
							<a href="#" class="btn btn-close btn-round"><i class="icon-remove"></i></a>
						</div>
					</div>
					<div class="box-content">
						<table class="table table-striped table-bordered bootstrap-datatable datatable">
						  <thead>
							  <tr>
						          <th>Name</th>
								  <th>Price</th>
								  <th>Category</th>
								  <th>SubCategory</th>
								  <th>Supplier</th>
								  <th>Images</th>
								  <th>weight(GM)</th>
								  <th>Height(CM)</th>
								  <th>Colors</th>
								  <th>Sizes(IN)</th>
								  <th>Count</th>
					              <th>Delete</th>
					       	  </tr>
						</thead>
						<thead>
						  <c:forEach var="list" items="${product}" >
							<tr>
							<td class="center">${list.name}</td>	
							<td class="center">${list.price}</td>
								<td class="center">${list.category}</td>
								<td class="center">${list.subCategory}</td>
									<td class="center">${list.supplier}</td>	
						  <td class="center">
						<img src="${pageContext.request.contextPath}/resources/${list.imagepath}" width="300" height="100"/> 
						</td>
						  <td class="center">${list.weight}</td>
								<td class="center">${list.height}</td>
							<td class="center">${list.colors}</td>
								<td class="center">${list.size}</td>
							<td class="center">${list.count}</td>
								<td class="center">
									<a class="btn btn-danger" href="deleteProduct/${list.id}">
										<i class="icon-trash icon-white"></i> 
										Delete
									</a>
								</td>
							</tr>
							</c:forEach> </tbody></table></div></div></div>
							<%@include file="footer.jsp" %>