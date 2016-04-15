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
	
	<c:if test="${0 eq edit }">
		<title>Add Concert</title>
	</c:if>
	<c:if test="${1 eq edit }">
		<title>Edit Concert</title>
	</c:if>
	
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
		<header>
			<c:if test="${0 eq edit }">
				<h3>Add Concert</h3>
			</c:if>
			<c:if test="${1 eq edit }">
				<h3>Edit Concert</h3>
			</c:if>
		</header>
		<div class="module_content">

			<div class="ticket-info-top">
				<h1>Concert Info</h1>	
					<form id="concert" method="post" enctype="multipart/form-data">
					<div class="info-top-left">
						<p>
							<c:if test="${0 eq edit }">
								<img src="images/concerts/upload.png" alt="Upload Poster">
							</c:if>
							<c:if test="${1 eq edit }">
								<img src="images/concerts/${concert.id }.jpg" width="188" height="284" alt="">
							</c:if>
						</p>
						<br/>
						<input name="poster" type="file" accept="image/*"/>	
					</div>
					<div class="iofo-top-right">
						<input id="id" name="id" value="${concert.id }" hidden="true" />
							<span class="former">Title:<input name="title" type="text" value="${concert.title }"/></span><br/>
							<!-- need a select -->
							<span class="former">Stadium:
								<select class="former" name="stadiumid">
									<c:forEach var="stadium" items="${stadiums }">
										<option value="${stadium.id }" <c:if test="${concert.stadiumId eq stadium.id }">selected</c:if>>${stadium.name }</option>
									</c:forEach>
								</select>
							</span><br/>
							<span class="former">Open:<input name="open" type="text" value="${concert.open }"/></span><br/>
							<span class="former">End:<input name="end" type="text" value="${concert.end }"/></span><br/>
							<c:if test="${'1' eq edit}"><span class="former">Total Tickets:<input name="total" type="text" value="${concert.total }" disabled="disabled"/></span><br/></c:if>
							<c:if test="${'1' eq edit}"><span class="former">Sold Tickets:<input name="sold" type="text" value="${concert.sold }" disabled="disabled"/></span></c:if>
							<c:if test="${'0' eq edit}"><span class="former">Seatmap:<input name="seatmap" type="file" accept=".xls,.xlsx"/></span></c:if>
					</div>
					</form>
				<div class="clear"></div>
			</div>
			<div class="ticket-info-mid">
				<fieldset>
					<label class="former">Intro:</label>
					<textarea name="intro" class="former" form="concert" rows="4">${concert.intro }</textarea>
				</fieldset>
			</div>
			<br/>
			
			<div class="clear"></div>
		</div>
			
		</article><!-- end of styles article -->
		
		<c:if test="${'1' eq edit}">
			<article class="module width_full">
				<header><h3 class="tabs_involved">Seatmaps</h3>
					<ul class="tabs">
			   			<c:forEach var="area" items="${concert.areas }" varStatus="obj">
			   				<li><a href="#tab${obj.count }">${area.name }</a></li>
			   			</c:forEach>
					</ul>
				</header>

				<div class="tab_container">
					<c:forEach var="seatmap" items="${seatmaps }" varStatus="obj">
						<div id="tab${obj.count }" class="tab_content">
							<c:forEach var="row" items="${seatmap }">
								<div>
									<c:forEach var="seat" items="${row }">
										<input name="ticket"
											<c:if test="${seat.status ne '-1' }">"class=seats"</c:if><c:if test="${seat.status eq '-1' }">class="noseat"</c:if>
											<c:if test="${seat.status ne '0' }">disabled</c:if>
											<c:if test="${seat.status eq '2' }">checked</c:if>
											id="seat${seat.id }"
											value="${seat.id }"
											type="checkbox">
										<label for="seat${seat.id }"><c:if test="${seat.status ne '-1' }">${seat.price }</c:if></label>
									</c:forEach>
								</div>
								<div class="clear"></div>
							</c:forEach>
						</div>
					</c:forEach>
				</div>
			</article>
		</c:if>
		
		<article class="module width_full">
			<header>
				<h3>Action</h3>
			</header>
			<div class="module_content">
				<c:if test="${'0' eq edit}">
					<button class="a-btn" type="submit" formaction="admin/addconcert" form="concert">Add</button>
					<a class="a-btn" href="admin/concertslist">Cancel</a>
				</c:if>
				<c:if test="${'1' eq edit}">
					<button class="a-btn" type="submit" formaction="admin/editconcert" form="concert">Edit</button>
					<a class="a-btn" href="admin/concertslist">Cancel</a>
				</c:if>
			</div>
			<div class="clear"></div>		
		</article>
				
		<div class="clear"></div>

		<div class="spacer"></div>
	</section>


</body>

</html>