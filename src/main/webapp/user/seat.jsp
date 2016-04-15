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
	<title>Concert List</title>
	
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
	$(document).ready(function() {

	//When page loads...
	$(".tab_content").hide(); //Hide all content
	$("ul.tabs li:first").addClass("active").show(); //Activate first tab
	$(".tab_content:first").show(); //Show first tab content

	//On Click Event
	$("ul.tabs li").click(function() {

		$("ul.tabs li").removeClass("active"); //Remove any "active" class
		$(this).addClass("active"); //Add "active" class to selected tab
		$(".tab_content").hide(); //Hide all tab content

		var activeTab = $(this).find("a").attr("href"); //Find the href attribute value to identify the active tab + content
		$(activeTab).fadeIn(); //Fade in the active ID content
		return false;
	});

});
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
			<h2 class="section_title">Concert tickets</h2>

			<div class="btn_view_site"><a href="http://www.medialoot.com">View Site</a></div>
		</hgroup>
	</header> <!-- end of header bar -->
	
	<section id="secondary_bar">
		<div class="user">
			<p>John Doe (<a href="#">3 Messages</a>)</p>
			<!-- <a class="logout_user" href="#" title="Logout">Logout</a> -->
		</div>
		<div class="breadcrumbs_container">
			<article class="breadcrumbs">
				<a href="index.html">Website Admin</a> 
				<div class="breadcrumb_divider"></div> 
				<a class="current">Concert Tickets</a>
				<div class="breadcrumb_divider"></div> 
				<a class="current">Ticket Details</a>
			</article>
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
			<li class="icn_profile"><a href="#">Your Profile</a></li>
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
		
		<h4 class="alert_info">Welcome to whatever for booking concert's tickets.</h4>
	
		<article class="module width_full">
		<header><h3>Choose seat</h3></header>
		<div class="module_content">
			<h1>Concert Area ${areaId }</h1>
			
			<div class="module_content">

			<!--seat map-->
			<form id="seatmap" action="ticket/book" method="post">
				<input type="hidden" name="areaid" value="${areaId }"/>
				<input type="hidden" name="conctid" value="${concertId }"/>
				<c:forEach var="row" items="${seats }">
					<div>
						<c:forEach var="seat" items="${row }">
							<input name="ticket" class="seats" <c:if test="${seat.status ne '0' }">disabled</c:if> <c:if test="${seat.status eq '2' }">checked</c:if> id="seat${seat.id }" value="${seat.id }" type="checkbox">
							<label for="seat${seat.id }"></label>
						</c:forEach>
					</div>
					<div class="clear"></div>
				</c:forEach>
			</form>
			<div>
				<h2>Summize</h2>
				<ul>
					<li style="font-family: Microsoft Yahei;font-size: 20px;">Donec ullamcorper nulla non metus auctor fringilla. </li>
					<br/>
					<li style="font-family: Microsoft Yahei;font-size: 20px;">Cras mattis consectetur purus sit amet fermentum.</li>
					<br/>
					
				</ul>
				<button class="a-btn" type="submit" form="seatmap">Next</button>
			</div>
			<div class="clear"></div>
			
			

		</div>	
		</div>
		
				
		<div class="clear"></div>
			
		</article><!-- end of styles article -->
		
		
		
		<div class="clear"></div>
		
		
		

		<div class="spacer"></div>
	</section>


</body>

</html>