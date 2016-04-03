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
	<script src="js/hideshow.js" t
	ype="text/javascript"></script>
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
		
		<h4 class="alert_info">Welcome to whatever for booking concert's tickets.</h4>
		
		<!-- start of News -->
		<article class="module width_full">
			<header><h3>News</h3></header>
			<div class="message_list">
				<div class="module_content">
					<div class="message"><p>张信哲参赛伤喉咙 北京演唱会后暂别舞台</p>
					<p><strong>网易娱乐</strong></p></div>
					<div class="message"><p>“为爱而唱”帮助留守儿童 长沙5月迎童星公益演唱会</p>
					<p><strong>梅州网</strong></p></div>
					<div class="message"><p>两位“邓丽君”相聚南京备战演唱会！</p>
					<p><strong>金陵晚报</strong></p></div>
					
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
		<header><h3 class="tabs_involved">Concerts</h3>
		<ul class="tabs">
   			<li><a href="#tab1">Pop music</a></li>
    		<li><a href="#tab2">Rock</a></li>
		</ul>
		</header>

		<div class="tab_container">
			<div id="tab1" class="tab_content">
			<table class="tablesorter" cellspacing="0"> 
			<thead> 
				<tr> 
   					<th></th> 
    				<th></th> 
    				<th></th> 
    				<th></th> 
    				<td><a href="concert/list">more</a></td> 
				</tr> 
			</thead> 
			<tbody> 
				<tr> 
   					<td>
   						<a class="img" href="concert/info/1"><img src="images/concerts/1.jpg" width="160" height="220" alt="周杰伦2016“地表最强”世界巡回演唱会" title="周杰伦2016“地表最强”世界巡回演唱会" /></a>
   						<div class="inf">
	   						<span class="ml10"> 周杰伦2016“地表最强”世界巡回演唱会</span>
	   						<p>时间：2016.07.01-2016.07.03 <br/>
	   						<span class="ml20" >场馆：五棵松体育馆</span>
					        </p>
   						</div>
   					</td> 
    				<td>
    					<a class="img" href="concert/info/2"><img src="images/concerts/2.jpg" width="160" height="220" alt="陈奕迅 ANOTHER EASON’S LIFE 演唱会" title="陈奕迅 ANOTHER EASON’S LIFE 演唱会" /></a>
    					<div class="inf">
	   						<span class="ml10"> 陈奕迅 ANOTHER EASON’S LIFE 演唱会</span>
	   						<p>时间：2016.10.22  <br/>
	   						<span class="ml20" >场馆：鸟巢体育馆</span>
					        </p>
   						</div>
    				</td> 
    				<td>
    					<a class="img" href=""><img src="images/concerts/3.jpg" width="160" height="220" alt="张信哲《还爱·光年》世界巡回演唱会" title="张信哲《还爱·光年》世界巡回演唱会" /></a>
    					<div class="inf">
	   						<span class="ml10"> 张信哲《还爱·光年》世界巡回演唱会</span>
	   						<p>时间：2016.04.30 <br/>
	   						<span class="ml20" >场馆：乐视体育生态中心</span>
					        </p>
   						</div>
    				</td> 
    				
				</tr> 

				
			</tbody> 
			</table>
			</div><!-- end of #tab1 -->
			
			<div id="tab2" class="tab_content">
			<table class="tablesorter" cellspacing="0"> 
			<thead> 
				<tr> 
   					<th></th> 
    				<th></th> 
    				<th></th> 
    				<th></th> 
    				<td><a href="concert/list">more</a></td> 
				</tr> 
			</thead> 
			<tbody> 
				<tr> 
   					<td>
   						<a class="img" href=""><img src="images/concerts/4.jpg" 
	   					width="160" height="220"	alt="逃跑计划2016巡回演唱会" title="逃跑计划2016巡回演唱会" /></a>
   						<div class="inf">
	   						<span class="ml10"> 逃跑计划2016巡回演唱会</span>
	   						<p>时间：2016.06.26 <br/>
	   						<span class="ml20" >场馆：五棵松体育馆</span>
					        </p>
   						</div>
   					</td> 

    				<td>
   						<a class="img" href=""><img src="images/concerts/5.jpg" 
	   					width="160" height="220"	alt="Iron Maiden铁娘子乐队“灵魂之书”2016年世界巡演" title="Iron Maiden铁娘子乐队“灵魂之书”2016年世界巡演" /></a>
   						<div class="inf">
	   						<span class="ml10"> Iron Maiden铁娘子乐队“灵魂之书”2016年世界巡演</span>
	   						<p>时间：2016.04.24<br/>
	   						<span class="ml20" >场馆：乐视体育生态中心</span>
					        </p>
   						</div>
   					</td>  
    				
				
			</tbody> 
			</table>

			</div><!-- end of #tab2 -->
			
		</div><!-- end of .tab_container -->
		
		</article><!-- end of content manager article -->

		<!-- start the stadiums -->
		<article class="module width_full">
			<header><h3>Stadiums</h3></header>
			<div class="module_content">
				<article class="stats_graph">
					<table class="tablesorter" cellspacing="0">
						<tbody>
						<tr>
							<td><a href="stadium/list">more</a></td>
						</tr>
						<tr>
							<td>
							<a href=""><img src="images/stadiums/3.jpg" width="260" height="140" alt="五棵松体育馆" value="五棵松体育馆" /></a>
							<h3>五棵松体育馆</h3>
							</td>
							<td>
							<a href=""><img src="images/stadiums/2.jpg" width="260" height="140" alt="工人体育馆" value="工人体育馆"/></a>
							<h3>工人体育馆</h3>
							</td>
							<td>
							<a href=""><img src="images/stadiums/1.jpg" width="260" height="140" alt="鸟巢体育馆" value="鸟巢体育馆"/></a>
							<h3>鸟巢体育馆</h3>
							</td>
						</tr>
						</tbody>
					</table>
				</article>
				
				
				
				<div class="clear"></div>
			</div>
		</article>
		
		
		
		<div class="clear"></div>
		
		
		

		<div class="spacer"></div>
	</section>


</body>

</html>