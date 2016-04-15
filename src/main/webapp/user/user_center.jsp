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
	<title>User Center</title>
	
	<link rel="stylesheet" href="css/layout.css" type="text/css" media="screen" />
	<!--[if lt IE 9]>
	<link rel="stylesheet" href="css/ie.css" type="text/css" media="screen" />
	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
	<script src="js/jquery-1.5.2.min.js" type="text/javascript"></script>
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
			<h2 class="section_title">Dashboard</h2><div class="btn_view_site"><a href="http://www.medialoot.com">View Site</a></div>
		</hgroup>
	</header> <!-- end of header bar -->
	
	<section id="secondary_bar">
		<div class="user">
			<p>John Doe (<a href="#">3 Messages</a>)</p>
			<!-- <a class="logout_user" href="#" title="Logout">Logout</a> -->
		</div>
		<div class="breadcrumbs_container">
			<article class="breadcrumbs"><a href="index.html">Website Admin</a> <div class="breadcrumb_divider"></div> <a class="current">Dashboard</a></article>
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
		
		<c:if test="${null ne msgt }">
			<h4 class="alert_${msgt }">${msg }</h4>
		</c:if>
		
		<article class="module width_full">
			<div class="module_content">
				<article class="user_hello">
					<span class="centre" style="font-size:48px">Hello, user.</span>
				</article>
				<div class="clear"></div>
			</div>
		</article><!-- end of stats article -->
		
	<article class="control">
		<div class="control_wrapper">
		<c:url var="userinfo" value="user/info"><c:param name="id" value="2"/></c:url>
		<a href="${userinfo }">
			<article class="flip-container" ontouchstart="this.classList.toggle('hover');">
				<article class="flipper">
					<article class="front">
						<article class="control_content">
							<span class="centre font_big">My Profile</span>
						</article>
					</article>
					<article class="back">
						<article class="control_content">
							<span class="centre font_small">Who I am?</span>
						</article>
					</article>
				</article>
			</article>
		</a>
		</div>
		<div class="control_wrapper">
		<c:url var="userorder" value="user/order"><c:param name="id" value="1"/></c:url>
		<a href="${userorder }">
			<article class="flip-container" ontouchstart="this.classList.toggle('hover');">
				<article class="flipper">
					<article class="front">
						<article class="control_content">
							<span class="centre font_big">My Order</span>
						</article>
					</article>
					<article class="back">
						<article class="control_content">
							<span class="centre font_small">Where are my tickets?</span>
						</article>
					</article>
				</article>
			</article>
		</a>
		</div>		<div class="control_wrapper">
		<a href="https://www.google.com.tw">
			<article class="flip-container" ontouchstart="this.classList.toggle('hover');">
				<article class="flipper">
					<article class="front">
						<article class="control_content">
							<span class="centre font_big">Change Password</span>
						</article>
					</article>
					<article class="back">
						<article class="control_content">
							<span class="centre font_small">Another month, huh?</span>
						</article>
					</article>
				</article>
			</article>
		</a>
		</div>		<div class="control_wrapper">
		<a href="https://www.google.com.tw">
			<article class="flip-container" ontouchstart="this.classList.toggle('hover');">
				<article class="flipper">
					<article class="front">
						<article class="control_content">
							<span class="centre font_big">Support</span>
						</article>
					</article>
					<article class="back">
						<article class="control_content">
							<span class="centre font_small">We always here.</span>
						</article>
					</article>
				</article>
			</article>
		</a>
		</div>
		
		<div class="clear"></div>

	</article>

		<div class="spacer"></div>
	</section>


</body>

</html>