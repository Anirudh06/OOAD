<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% String WsUrl = getServletContext().getInitParameter("WsUrl"); %>
<html>
<%@page import="com.anirudh.Student.dao.StudentDao"%>
<%@page import="com.anirudh.Student.pojo.Student"%>
<%@page import="java.util.*"%>
<%
    int result=0;
	String roll1 = request.getParameter("ani");
	System.out.println(roll1);
	try {
		Student s1= new Student();
		Student s2=new Student();
		s1.setRollno(roll1);
		StudentDao stDAO = new StudentDao();
		s2 = stDAO.findStudentByRollno(s1);
		if(s2.rollno==s1.rollno)
		{
			System.out.println("your rollno is not registered");
		}
	} catch (Exception e) {
		System.out.println("Exception :: " + e);
	}
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name='viewport' content='minimum-scale=1.0, initial-scale=1.0,
	width=device-width, maximum-scale=1.0, user-scalable=no'/>
<title>single-room-chat</title>
<link rel="stylesheet" type="text/css" href="content/styles/site.css">
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
<div id="container">
	<div id="loginPanel">
		<div id="infoLabel">Type a name to join the room</div>
		<div style="padding: 10px;">
			<input id="txtLogin" type="text" name="ani" class="loginInput"
				onkeyup="proxy.login_keyup(event)" />
			<button type="button" class="loginInput" onclick="proxy.login()">Login</button>
		</div>
									<%
							
						%>
	</div>
	<div id="msgPanel" style="display: none">
		<div id="msgContainer" style="overflow: auto;"></div>
		<div id="msgController">
			<textarea id="txtMsg" 
				title="Enter to send message"
				onkeyup="proxy.sendMessage_keyup(event)"
				style="height: 20px; width: 100%"></textarea>
			<button style="height: 30px; width: 100px" type="button"
				onclick="proxy.logout()">Logout</button>
		</div>
	</div>
</div>
</body>
</html>
<%!public int strToINT(String str, int defaultVal) {
		int retVal = defaultVal;
		try {
			retVal = Integer.parseInt(str);
		} catch (Exception e) {
			retVal = defaultVal;
		}
		return retVal;
	}%>
