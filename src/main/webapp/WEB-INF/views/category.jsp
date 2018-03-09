
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% boolean no_visable_elements = false; %>
<%@ page isELIgnored="false" %>


<%@include file="header.jsp" %>



			<div>
				<ul class="breadcrumb">
					<li>
						<a href="#">Home</a> <span class="divider">/</span>
					</li>
					<li>
						<a href="#">Category</a>
					</li>
				</ul>
			</div>


			<div class="row-fluid sortable">
				<div class="box span12">
					<div class="box-header well" data-original-title>
						<h2><i class="icon-picture"></i>Category</h2>
						<div class="box-icon">
						<a href="#" class="btn btn-setting btn-round"><i class="icon-cog"></i></a>
							<a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
							<a href="#" class="btn btn-close btn-round"><i class="icon-remove"></i></a>
						</div>
					</div>
					<div class="box-content">
						<select name="category" >
                           <c:forEach var="list1" items="${data}" >
 
                             <option value="'+${list1.categoryName}+'">${list1.categoryName}</option>
                                     </c:forEach>
 						</select>
							
					</div>
				</div><!--/span-->
			
			</div><!--/row-->

    
<%@include file="footer.jsp" %>