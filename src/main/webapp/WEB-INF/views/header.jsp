<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<!-- <title>carisma | Responsive Bootstrap Template with JSP</title> -->
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="Responsive Bootstrap Template with JSP">
	<meta name="author" content="">

	<!-- The styles -->
	<link id="bs-css" href="<%=session.getAttribute("basevalue") %>/static/css/bootstrap-cerulean.css" rel="stylesheet">
	<style type="text/css">
	  body {
		padding-bottom: 40px;
	  }
	  .sidebar-nav {
		padding: 9px 0;
	  }
	</style>
	<link href="<%=session.getAttribute("basevalue") %>/static/css/bootstrap-responsive.css" rel="stylesheet">
	<link href="<%=session.getAttribute("basevalue") %>/static/css/charisma-app.css" rel="stylesheet">
	<link href="<%=session.getAttribute("basevalue") %>/static/css/jquery-ui-1.8.21.custom.css" rel="stylesheet">
	<link href='<%=session.getAttribute("basevalue") %>/static/css/fullcalendar.css' rel='stylesheet'>
	<link href='<%=session.getAttribute("basevalue") %>/static/css/fullcalendar.print.css' rel='stylesheet'  media='print'>
	<link href='<%=session.getAttribute("basevalue") %>/static/css/chosen.css' rel='stylesheet'>
	<link href='<%=session.getAttribute("basevalue") %>/static/css/uniform.default.css' rel='stylesheet'>
	<link href='<%=session.getAttribute("basevalue") %>/static/css/colorbox.css' rel='stylesheet'>
	<link href='<%=session.getAttribute("basevalue") %>/static/css/jquery.cleditor.css' rel='stylesheet'>
	<link href='<%=session.getAttribute("basevalue") %>/static/css/jquery.noty.css' rel='stylesheet'>
	<link href='<%=session.getAttribute("basevalue") %>/static/css/noty_theme_default.css' rel='stylesheet'>
	<link href='<%=session.getAttribute("basevalue") %>/static/css/elfinder.min.css' rel='stylesheet'>
	<link href='<%=session.getAttribute("basevalue") %>/static/css/elfinder.theme.css' rel='stylesheet'>
	<link href='<%=session.getAttribute("basevalue") %>/static/css/jquery.iphone.toggle.css' rel='stylesheet'>
	<link href='<%=session.getAttribute("basevalue") %>/static/css/opa-icons.css' rel='stylesheet'>
	<link href='<%=session.getAttribute("basevalue") %>/static/css/uploadify.css' rel='stylesheet'>
    <link rel="shortcut icon" href="img/weather_few_clouds.ico">
		
</head>

<body>

	<% if (!no_visable_elements) { %>
	<!-- topbar starts -->
	<div class="navbar">
		<div class="navbar-inner">
			<div class="container-fluid">
				<a class="btn btn-navbar" data-toggle="collapse" data-target=".top-nav.nav-collapse,.sidebar-nav.nav-collapse">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</a>
				<a class="brand" href="#"><!--  <img alt="Carisma" src="img/weather_few_clouds.png" /> -->  <span>E-COMMERCE</span> </a>
				
				<!-- theme selector starts -->
				<div class="btn-group pull-right theme-container" >
					<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
						<i class="icon-tint"></i><span class="hidden-phone"> Change Theme / Skin</span>
						<span class="caret"></span>
					</a>
					<ul class="dropdown-menu" id="themes">
						<li><a data-value="classic" href="#"><i class="icon-blank"></i> Classic</a></li>
						<li><a data-value="cerulean" href="#"><i class="icon-blank"></i> Cerulean</a></li>
						<li><a data-value="cyborg" href="#"><i class="icon-blank"></i> Cyborg</a></li>
						<li><a data-value="redy" href="#"><i class="icon-blank"></i> Redy</a></li>
						<li><a data-value="journal" href="#"><i class="icon-blank"></i> Journal</a></li>
						<li><a data-value="simplex" href="#"><i class="icon-blank"></i> Simplex</a></li>
						<li><a data-value="slate" href="#"><i class="icon-blank"></i> Slate</a></li>
						<li><a data-value="spacelab" href="#"><i class="icon-blank"></i> Spacelab</a></li>
						<li><a data-value="united" href="#"><i class="icon-blank"></i> United</a></li>
					</ul>
				</div>
					<div class="btn-group pull-right" >
				
						<a href="./adminProfile">Profile</a>
						
						<a href="./logout">Logout</a>
			
				</div>
				<!-- user dropdown ends -->
				
				<div class="top-nav nav-collapse">
					<ul class="nav">
						<li><a href="#">Visit Site</a></li>
						<li>
							<form class="navbar-search pull-left">
								<input placeholder="Search" class="search-query span2" name="query" type="text">
							</form>
						</li>
					</ul>
				</div><!--/.nav-collapse -->
			</div>
		</div>
	</div>
	<!-- topbar ends -->
	<% } %>

	<div class="container-fluid">
		<div class="row-fluid">
		<% 
		
		if (!no_visable_elements) { %>
		
			<!-- left menu starts -->
			<div class="span2 main-menu-span">
				<div class="well nav-collapse sidebar-nav">
					<ul class="nav nav-tabs nav-stacked main-menu">
						<li class="nav-header hidden-tablet">Main</li>
						<li><a class="ajax-link" href="./userList"><i class="icon-home"></i><span class="hidden-tablet"> Users</span></a></li>
						<li><a class="ajax-link" href="./showcategory"><i class="icon-map-marker"></i><span class="hidden-tablet">Categories</span></a></li>
						
						<li><a class="ajax-link" href="./subCategory"><i class="icon-eye-open"></i><span class="hidden-tablet">SubCategories</span></a></li>
						<li><a class="ajax-link" href="./supplierList"><i class="icon-edit"></i><span class="hidden-tablet">Suppliers</span></a></li>
						 <li><a class="ajax-link" href="./viewProduct"><i class="icon-list-alt"></i><span class="hidden-tablet">Product List</span></a></li>
						 <!--li><a class="ajax-link" href="typography.jsp"><i class="icon-font"></i><span class="hidden-tablet"> Typography</span></a></li>
						<li><a class="ajax-link" href="gallery.jsp"><i class="icon-picture"></i><span class="hidden-tablet"> Gallery</span></a></li>
						<li class="nav-header hidden-tablet">Sample Section</li>
						<li><a class="ajax-link" href="table.jsp"><i class="icon-align-justify"></i><span class="hidden-tablet"> Tables</span></a></li>
						<li><a class="ajax-link" href="calendar.jsp"><i class="icon-calendar"></i><span class="hidden-tablet"> Calendar</span></a></li>
						<li><a class="ajax-link" href="grid.jsp"><i class="icon-th"></i><span class="hidden-tablet"> Grid</span></a></li>
						<li><a class="ajax-link" href="file-manager.jsp"><i class="icon-folder-open"></i><span class="hidden-tablet"> File Manager</span></a></li>
						<li><a href="tour.jsp"><i class="icon-globe"></i><span class="hidden-tablet"> Tour</span></a></li>
						<li><a class="ajax-link" href="icon.jsp"><i class="icon-star"></i><span class="hidden-tablet"> Icons</span></a></li>
						<li><a href="error.jsp"><i class="icon-ban-circle"></i><span class="hidden-tablet"> Error Page</span></a></li>
						<li><a href="login.jsp"><i class="icon-lock"></i><span class="hidden-tablet"> Login Page</span></a></li-->
					</ul>
					<label id="for-is-ajax" class="hidden-tablet" for="is-ajax"><input id="is-ajax" type="checkbox"> Ajax on menu</label>
				</div><!--/.well -->
			</div><!--/span-->
			<!-- left menu ends -->
			
			<noscript>
				<div class="alert alert-block span10">
					<h4 class="alert-heading">Warning!</h4>
					<p>You need to have <a href="http://en.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a> enabled to use this site.</p>
				</div>
			</noscript>
			
			<div id="content" class="span10">
			<!-- content starts -->
			<% } %>
