<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<%@page import="com.anirudh.Student.dao.StudentDao"%>
<%@page import="com.anirudh.Student.pojo.Student"%>
<%@page import="java.util.*"%>
<%
	List<Student> studentList = null;
	long roll1 = strToLong(request.getParameter("roll1"), 10L);
	long roll2 = strToLong(request.getParameter("roll2"), 100L);
	try {
		StudentDao stDAO = new StudentDao();
		studentList = stDAO.findAllStudentInRange(roll1, roll2);
		System.out.println("DataSet Size :: " + studentList.size());
	} catch (Exception e) {
		System.out.println("Exception :: " + e);
	}
%>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Student Carosuel</title>

<!-- Bootstrap Core CSS -->
<link title="Search Range" rel="icon" type="image/gif/png"
	href="data:image/png;base64,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">
<link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="../vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

<!-- DataTables CSS -->
<link href="../vendor/datatables-plugins/dataTables.bootstrap.css"
	rel="stylesheet">

<!-- DataTables Responsive CSS -->
<link href="../vendor/datatables-responsive/dataTables.responsive.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="../dist/css/sb-admin-2.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="../vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<style type="text/css">
/* carousel */
#quote-carousel {
	padding: 0 10px 30px 10px;
	margin-top: 30px;
}

/* Control buttons  */
#quote-carousel .carousel-control {
	background: none;
	color: #222;
	font-size: 2.3em;
	text-shadow: none;
	margin-top: 30px;
}
/* Previous button  */
#quote-carousel .carousel-control.left {
	left: -12px;
}
/* Next button  */
#quote-carousel .carousel-control.right {
	right: -12px !important;
}
/* Changes the position of the indicators */
#quote-carousel .carousel-indicators {
	right: 50%;
	top: auto;
	bottom: 0px;
	margin-right: -19px;
}
/* Changes the color of the indicators */
#quote-carousel .carousel-indicators li {
	background: #c0c0c0;
}

#quote-carousel .carousel-indicators .active {
	background: #333333;
}

#quote-carousel img {
	width: 250px;
	height: 100px
}
/* End carousel */
.item blockquote {
	border-left: none;
	margin: 0;
}

.item blockquote img {
	margin-bottom: 10px;
}

.item blockquote p:before {
	content: "\f10d";
	font-family: 'Fontawesome';
	float: left;
	margin-right: 10px;
}

/**
  MEDIA QUERIES
*/

/* Small devices (tablets, 768px and up) */
@media ( min-width : 768px) {
	#quote-carousel {
		margin-bottom: 0;
		padding: 0 40px 30px 40px;
	}
}

/* Small devices (tablets, up to 768px) */
@media ( max-width : 768px) {
	/* Make the indicators larger for easier clicking with fingers/thumb on mobile */
	#quote-carousel .carousel-indicators {
		bottom: -20px !important;
	}
	#quote-carousel .carousel-indicators li {
		display: inline-block;
		margin: 0px 5px;
		width: 15px;
		height: 15px;
	}
	#quote-carousel .carousel-indicators li.active {
		margin: 0px 5px;
		width: 20px;
		height: 20px;
	}
}

.button {
	display: inline-block;
	border-radius: 4px;
	background-color: #0B5BBB;
	border: none;
	color: #FFFFFF;
	text-align: center;
	font-size: 22px;
	padding: 2px;
	width: 105px;
	transition: all 0.5s;
	cursor: pointer;
	margin: 7px;
}

.button span {
	cursor: pointer;
	display: inline-block;
	position: relative;
	transition: 0.5s;
}

.button span:after {
	content: '\00bb';
	position: absolute;
	opacity: 0;
	top: 0;
	right: -20px;
	transition: 0.5s;
}



.home
{
text-align: center;
position: absolute;
    top: 20%;
font-size:17px;
}
</style>
<script type="text/javascript">
//When the DOM is ready, run this function
$(document).ready(function() {
  //Set the carousel options
  $('#quote-carousel').carousel({
    pause: true,
    interval: 500,
  })
});
</script>
</head>

<body>
	<div class="home">
		<div class="form-group"
			style="position: relative; left; left: 10px; top: 3px;">
			<img src="https://image.ibb.co/n7oTvU/logo_white.png" style="width: 60px; height: 60px;" alt="" />
				<h4>Welcome IIIT Bangalore</h4><br/>
				<p>26/C, Electronics City,<br/> Hosur Road, Bangalore <br/>- 560100 Phone:<br/>
					+91 80 4140 7777/ 2852 7627 <br/>Fax: +91 80 4140 7704</p>
				<br />
			<button
				onclick="location.href='http://localhost:8087/Student/search.html'"
				class="button" style="vertical-align: middle">
				<span> Go Back</span>
			</button>
			<br />
			<button
				onclick="location.href='http://localhost:8087/Student/ch.jsp'"
				class="button" style="vertical-align: middle">
				<span> Chat >></span>
			</button>
		</div>
	</div>
	<div id="wrapper">


		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
		<script
			src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Find Multiple Student's</h1>
				</div>
				<!-- /.col-lg-12 -->
				
			</div>
			<!-- /.row -->
			<div class="col-lg-12">
			
				<div class="panel panel-default">
					<div class="panel-heading">
						<b>Find Multiple Student's Details</b>
					</div>
					<div class="panel-body">
						<div class="row">

							<form role="form">
								<div class="col-lg-6">
									<div class="form-group">
										<label><b>From Roll</b></label> <input class="form-control"
											id="from_roll" name="roll1" placeholder="Enter From Roll No"
											autocomplete="off">
									</div>
								</div>
								<div class="col-lg-6">
									<div class="form-group">
										<label>To Roll</label> <input class="form-control"
											id="to_roll" name="roll2" placeholder="Enter To Roll No"
											autocomplete="off">
									</div>
									<button type="submit" class="button">Find</button>
							</form>
							<%
							
						%>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-6"></div>
					</div>
					<div class="row">
						<div class="col-lg-12">
							<div class="panel panel-default">
								<div class="panel-heading">
									<b>Students Details</b>
								</div>
								<!-- /.panel-heading -->
								<div class="panel-body">
									<!--div class="table-responsive" id="tbl">
											<div id="msg"></div>
										</div-->
									<!-- Corosal Starts Here -->

									<div class="row">
										<div class='col-lg-12 text-center'>
											<h2>Student Details</h2>
										</div>
									</div>
									<div class='col-lg-12'>
										<div class="carousel slide" data-ride="carousel"
											id="quote-carousel">
											<!-- Bottom Carousel Indicators -->
											<ol class="carousel-indicators">
												<li data-target="#quote-carousel" data-slide-to="0"
													class="active"></li>
												<li data-target="#quote-carousel" data-slide-to="1"></li>
												<li data-target="#quote-carousel" data-slide-to="2"></li>
											</ol>

											<!-- The slideshow -->
											<div class="carousel-inner">
												<%
														boolean flag = false;
														for (Student s : studentList) {

															if (!flag) {
																flag = true;
													%>
												<div class="item active">
													<blockquote>
														<div class="row">
															<div class="col-lg-3 text-center ">
																<img class="img-circle" src="../../<%=s.getPhoto()%>"
																	style="width: 150px; height: 150px;">
																<!--<img class="img-circle" src="https://s3.amazonaws.com/uifaces/faces/twitter/kolage/128.jpg" style="width: 100px;height:100px;">-->
															</div>
															<div class="col-lg-9">
																<p>
																	Your Roll number is
																	<td><%=s.getRollno()%> . Your marks in Physics is
																		<%=s.getPhysics()%>, in Chemistry is <%=s.getChemistry()%>
																		and in Math is <%=s.getMath()%> with Grade of <%=s.getGrade()%>.

																	
																</p>
																<small><bold><%=s.getName()%></bold></small>

															</div>
														</div>
													</blockquote>
												</div>
												<%
														} else {
													%>
												<div class="item">
													<blockquote>
														<div class="row">
															<div class="col-lg-3 text-center">
																<img class="img-circle" src="../../<%=s.getPhoto()%>"
																	style="width: 150px; height: 150px;">
															</div>
															<div class="col-lg-9">
																<p>
																	Your Roll number is
																	<td><%=s.getRollno()%> . Your marks in Physics is
																		<%=s.getPhysics()%>, in Chemistry is <%=s.getChemistry()%>
																		and in Math is <%=s.getMath()%> with Grade of <%=s.getGrade()%>.

																	
																</p>
																<small><bold><%=s.getName()%></bold></small>

															</div>
														</div>
													</blockquote>
												</div>
												<%
														}
														}
													%>


											</div>

											<!-- Carousel Buttons Next/Prev -->
											<a data-slide="prev" href="#quote-carousel"
												class="left carousel-control"><i
												class="fa fa-chevron-left"></i></a> <a data-slide="next"
												href="#quote-carousel" class="right carousel-control"><i
												class="fa fa-chevron-right"></i></a>
										</div>
									</div>

									<!-- Corosal Ends Here  -->
								</div>
								<!-- /.panel -->
							</div>
							<!-- /.col-lg-6 -->
						</div>
					</div>
				</div>
			</div>

		</div>
		<!-- /#page-wrapper -->
		
	</div>
	</div>
	<!-- /#wrapper -->
	<!-- jQuery -->
	<script src="../vendor/jquery/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="../vendor/bootstrap/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="../vendor/metisMenu/metisMenu.min.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="../dist/js/sb-admin-2.js"></script>

</body>

</html>
<%!public long strToLong(String str, long defaultVal) {
		long retVal = defaultVal;
		try {
			retVal = Long.parseLong(str);
		} catch (Exception e) {
			retVal = defaultVal;
		}
		return retVal;
	}%>
