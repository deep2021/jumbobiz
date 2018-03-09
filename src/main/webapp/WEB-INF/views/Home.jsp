<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page isELIgnored="false"%>
<p align="right"><a href="./login">Login</a>
 <a href="./registration">Registration</a> </p>
<div class="box-content">
						<table class="table table-striped table-bordered bootstrap-datatable datatable">
						  <thead>
							  <tr>
						         <!--  <th>Name</th>
								  <th>Price</th>
								  <th>Category</th>
								  <th>SubCategory</th>
								  <th>Supplier</th> -->
			<!-- 					  <th>Images</th> -->
								 <!--  <th>weight(GM)</th>
								  <th>Height(CM)</th>
								  <th>Colors</th>
								  <th>Sizes(IN)</th>
								  <th>Count</th> -->
					              
					       	  </tr>
						</thead>
						<thead>
						  <c:forEach var="list" items="${product}" >
							<tr>
							<%-- <td class="center">${list.name}</td>	
							<td class="center">${list.price}</td>
								<td class="center">${list.category}</td>
								<td class="center">${list.subCategory}</td>
									<td class="center">${list.supplier}</td> --%>	
						  <td class="center">
						<img src="${pageContext.request.contextPath}/resources/${list.imagepath}" width="200" height="100"/> 
						</td>
						<th>Name</th><td>${list.name}</td>
						<th>Price</th><td>${list.price}</td>
						<th>Pieces</th><td>${list.count}</td>
						<%-- <td>Name:${list.name}</td>
						<td>Price:${list.price}</td>
						<td>${list.count}:Pieces</td>
						 --%>
						  <%-- <td class="center">${list.weight}</td>
								<td class="center">${list.height}</td>
							<td class="center">${list.colors}</td>
								<td class="center">${list.size}</td>
							<td class="center">${list.count}</td> --%>
								<%-- <td class="center">
									<a class="btn btn-danger" href="deleteProduct/${list.id}">
										<i class="icon-trash icon-white"></i> 
										Delete
									</a>
								</td> --%>
							</tr>
							</c:forEach> </tbody></table></div>
					<%-- 		<%@include file="footer.jsp" %> --%>