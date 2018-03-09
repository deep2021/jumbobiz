<% boolean no_visable_elements = false; %>
<% String base = (String)request.getContextPath(); 


   session.setAttribute("basevalue", base);
   //session.setAttribute("novisableelement", no_visable_elements);
   
%>
<%@include file="header.jsp" %>

           <div>
				<ul class="breadcrumb">
					<li>
						<a href="#">Home</a> <span class="divider">/</span>
					</li>
					<li>
						<a href="#">Dashboard</a>
					</li>
				</ul>
			</div>
			
<body>
<h1>Welcome to users profile</h1>
<h5>welcome:${firstname}</h5>
<a href="./logout">Logout</a>
</body>
<%@include file="footer.jsp" %>