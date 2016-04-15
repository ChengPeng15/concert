<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String ctxPath = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+ctxPath+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath%>">
	<meta charset="utf-8"/>
	<title>Home Page</title>
	
	<link rel="stylesheet" href="css/layout.css" type="text/css" media="screen" />
	<style type="text/css">
	.ml20{color:red;font-size: 13px;}
	.ml10{color:#999;font-size: 16px;font-weight: bold;}
	</style>

	<!--[if lt IE 9]>
	<link rel="stylesheet" href="css/ie.css" type="text/css" media="screen" />
	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
	<script src="js/jquery-1.5.2.min.js"  type="text/javascript"></script>
	<script src="js/hideshow.js" type="text/javascript"></script>
	<script src="js/jquery.tablesorter.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="js/jquery.equalHeight.js"></script>
	<script type="text/javascript">
	$(document).ready(function() 
    	{ 
      	  $(".tablesorter").tablesorter(); 
   	 } 
	);
    </script>
    <script type="text/javascript">
    $(function(){
        $('.column').equalHeight();
    });
</script>

</head>


<body>

	<header id="header">
		<hgroup>
			<h1 class="site_title"><a href="index.html">Website Admin</a></h1>
			<h2 class="section_title">Concert tickets</h2><div class="btn_view_site"><a href="http://www.medialoot.com">View Site</a></div>
		</hgroup>
	</header> <!-- end of header bar -->
	
	<section id="secondary_bar">
		<div class="user">
			<p>John Doe (<a href="#">3 Messages</a>)</p>
			<!-- <a class="logout_user" href="#" title="Logout">Logout</a> -->
		</div>
		<div class="breadcrumbs_container">
			<article class="breadcrumbs"><a href="index.html">Website Admin</a> <div class="breadcrumb_divider"></div> <a class="current">Concert tickets</a></article>
		</div>
	</section><!-- end of secondary bar -->
	
	<aside id="sidebar" class="column">
		<form class="quick_search">
			<input type="text" value="Quick Search" onfocus="if(!this._haschanged){this.value=''};this._haschanged=true;">
		</form>
		<hr/>
		<h3>Content</h3>
		<ul class="toggle">
			<li class="icn_new_article"><a href="#">New Article</a></li>
			<li class="icn_edit_article"><a href="#">Edit Articles</a></li>
			<li class="icn_categories"><a href="#">Categories</a></li>
			<li class="icn_tags"><a href="#">Tags</a></li>
		</ul>
		<h3>Users</h3>
		<ul class="toggle">
			<li class="icn_add_user"><a href="#">Add New User</a></li>
			<li class="icn_view_users"><a href="#">View Users</a></li>
			<li class="icn_profile"><a href="user/user_center.jsp">Your Profile</a></li>
		</ul>
		<h3>Media</h3>
		<ul class="toggle">
			<li class="icn_folder"><a href="#">File Manager</a></li>
			<li class="icn_photo"><a href="#">Gallery</a></li>
			<li class="icn_audio"><a href="#">Audio</a></li>
			<li class="icn_video"><a href="#">Video</a></li>
		</ul>
		<h3>Admin</h3>
		<ul class="toggle">
			<li class="icn_settings"><a href="#">Options</a></li>
			<li class="icn_security"><a href="#">Security</a></li>
			<li class="icn_jump_back"><a href="#">Logout</a></li>
		</ul>
		
		<footer>
			<hr />
			<p><strong>Copyright &copy; 2011 Website Admin</strong></p>
			<p>Theme by <a href="http://www.medialoot.com">MediaLoot</a></p>
		</footer>
	</aside><!-- end of sidebar -->
	
	<section id="main" class="column">
		
		<c:if test="${null ne msgt }">
			<h4 class="alert_${msgt }">${msg }</h4>
		</c:if>
		
		<!-- start of News -->
		<article class="module width_full">
			<header><h3>News</h3></header>
			<div class="message_list">
				<div class="module_content">
					<div class="message"><p>Guide to Nashville's outdoor concerts in 2016</p>
					<p><strong>The Tennessean</strong></p></div>
					<div class="message"><p>Big Five concert roars to life</p>
					<p><strong>The Herald</strong></p></div>
					<div class="message"><p>'Perfect Pairs' explored in upcoming concert</p>
					<p><strong>Baltimore Sun</strong></p></div>
				</div>
			</div>
			<!--<footer>
				<form class="post_message">
					<input type="text" value="Message" onfocus="if(!this._haschanged){this.value=''};this._haschanged=true;">
					<input type="submit" class="btn_post_message" value=""/>
				</form>
			</footer>-->
		</article><!-- end of news -->
		
		<article class="module width_full">
			<header>
				<h3 class="tabs_involved">Concerts</h3>
				<ul class="tabs">
	   				<li class="active"><a href="concert/list">more</a></li>
				</ul>
			</header>
		<div class="tab_container">
			<c:if test="${null ne concerts }">
				<c:forEach var="concert" items="${concerts }">
					<a href="concert/info/${concert.id }">
						<div class="list" style="width:auto; float:left; margin:5px">
							<img src="images/concerts/${concert.id }.jpg" width="160" height="220" alt="${concert.title }" />
							<br/>
							<span class="centre">
								${concert.title }<br/>
								${concert.open }<br/>
								${concert.end }<br/>
								Ticket:${concert.total - concert.sold }/${concert.total } (Available/Total)
							</span>
						</div>
					</a>
				</c:forEach>
			</c:if>
			<c:if test="${null eq concerts }">
				<span class="centre">No concert for now.</span>
			</c:if>
		</div>
		<div class="clear"></div>
		
		</article><!-- end of content manager article -->

		<!-- start the stadiums -->
		<article class="module width_full">
			<header>
				<h3 class="tabs_involved">Stadiums</h3>
				<ul class="tabs">
	   				<li class="active"><a href="stadium/list">more</a></li>
				</ul>
			</header>
			<div class="tab_container">
				<c:if test="${null ne stadiums }">
					<c:forEach var="stadium" items="${stadiums }">
						<a href="stadium/info/${stadium.id }">
							<div class="list" style="width:auto; float:left; margin:5px">
								<img src="images/stadiums/${stadium.id }.jpg" width="160" alt="${stadium.name }" />
								<br/>
								<span class="centre">
									${stadium.name }<br/>
									${stadium.address }<br/>
									${stadium.total } Seats
								</span>
							</div>
						</a>
					</c:forEach>
				</c:if>
				<c:if test="${null eq stadiums }">
					<span class="centre">No stadium for now.</span>
				</c:if>
			</div>
			<div class="clear"></div>
		</article>
		
		
		
		<div class="clear"></div>
		
		
		

		<div class="spacer"></div>
	</section>


</body>

</html>