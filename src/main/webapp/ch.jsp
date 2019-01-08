<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% String WsUrl = getServletContext().getInitParameter("WsUrl"); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name='viewport' 	content='minimum-scale=1.0, initial-scale=1.0,	width=device-width, maximum-scale=1.0, user-scalable=no' />
<title>Chat Room</title>
<link title="Search Range" rel="icon" type="image/gif/png"	href="data:image/png;base64,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">

<link href="http://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" 	rel="stylesheet" id="bootstrap-css">
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="Student.css" rel="stylesheet" media="all">
<style type="text/css">
lin {
	display: inline-block;
	height: 40px;
	weigth: 600px;
	margin-left: 10em;
	margin-right: 6em;
}

a:link, a:visited {
	margin-top: 2%;
	margin-left: -38%;
	border: none;
	border-radius: 4rem;
	padding: 15%;
	background: #0062cc;
	color: #fff;
	font-weight: 50px;
	width: 190%;
	cursor: pointer;
}

a:hover, a:active {
	background-color: blue;
}

button {
	display: inline-block;
	border-radius: 4px;
	background-color: #0B5BBB;
	border: none;
	color: #FFFFFF;
	text-align: center;
	font-size: 28px;
	padding: 2px;
	width: 130px;
	transition: all 0.5s;
	cursor: pointer;
	margin: 5px;
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

.button:hover span {
	padding-right: 25px;
}

.button:hover span:after {
	opacity: 1;
	right: 0;
}

a:link, a:visited {
	float: center;
	margin-top: -20%;
	margin-left: 5%;
	border: none;
	background: #0062cc;
	color: #fff;
	border-radius: 1.5rem;
	padding: 5%;
	font-weight: 500;
	width: 60%;
	cursor: pointer;
}

a:hover, a:active {
	background-color: blue;
}
</style>
<script type="text/javascript" src="scripts/chatroom.js"></script>
<script type="text/javascript">
var wsUri = '<%=WsUrl%>';
var proxy = CreateProxy(wsUri);

document.addEventListener("DOMContentLoaded", function(event) {
	console.log(document.getElementById('loginPanel'));
	proxy.initiate({
		loginPanel: document.getElementById('loginPanel'),
		msgPanel: document.getElementById('msgPanel'),
		txtMsg: document.getElementById('txtMsg'),
		txtLogin: document.getElementById('txtLogin'),
		msgContainer: document.getElementById('msgContainer')
	});
});

</script>
</head>
<body>
	<div id="loginPanel" class="container register">
		<div class="row">
			<div class="col-md-3 register-left">
				<img src="https://image.ibb.co/n7oTvU/logo_white.png" alt="" />
				<h3>Welcome IIIT Bangalore</h3>
				<p>26/C, Electronics City, Hosur Road, Bangalore - 560100 Phone:
					+91 80 4140 7777/ 2852 7627 Fax: +91 80 4140 7704</p>
					<br/>
<br/>
				<div class="submit">
					<a href="Student.html">Home</a>
				</div>
<br/>
<br/>


			</div>


			<div class="col-md-9 register-right">
				<div class="tab-content" id="myTabContent">
					<div class="tab-pane fade show active" id="home" role="tabpanel"
						aria-labelledby="home-tab">
						<h3 class="register-heading">Enter the Name of Person for
							Chat</h3>

						<div class="row register-form">
							<div class="col-md-9">
								<div class="form-group">

									<input id="txtLogin" type="text" class="form-control"
										onkeyup="proxy.login_keyup(event)" />
								</div>
								<div class="form-group">
									<button type="button" align="left" class="button" onclick="proxy.login()">Login</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>

	<div id="msgPanel" class="container register">
		<div class="row">
			<div class="col-md-3 register-left">
				<img src="https://image.ibb.co/n7oTvU/logo_white.png" alt="" />
				<h3>Welcome IIIT Bangalore</h3>
				<p>26/C, Electronics City, Hosur Road, Bangalore - 560100 Phone:
					+91 80 4140 7777/ 2852 7627 Fax: +91 80 4140 7704</p>
				<div class="submit">
					<a href="Student.html" class="button">Home</a>
				</div>
<br/>
<br/>

			</div>


			<div class="col-md-9 register-right">
				<div class="tab-content" id="myTabContent">
					<div class="tab-pane fade show active" id="home" role="tabpanel"
						aria-labelledby="home-tab">
						<h3 class="register-heading">Enter the Name of Person for
							Chat</h3>

						<div class="row register-form">

							<div id="msgPanel" align="right" class="col-md-12 register-right">
								<div id="msgContainer"></div>
								<div id="msgController" class="tab-content">
									<textarea id="txtMsg" title="Enter to send message"
										onkeyup="proxy.sendMessage_keyup(event)"
										autocomplete="transaction-currency" class="form-control"
										onkeyup="proxy.login_keyup(event)" /></textarea>
									<button type="button" class="button" onclick="proxy.logout()">Logout</button>
								</div>
							</div>



						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>