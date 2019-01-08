<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
System.out.println("logincheck.jsp");
String name=request.getParameter("roll");
String pass=request.getParameter("pass");
int passInt=0;
try{
	System.out.println("logincheck.jsp pass :: "+name);
	passInt=Integer.parseInt(name);
	System.out.println("logincheck.jsp passIInt :: "+passInt);
}catch(Exception e){
	System.out.println("logincheck.jsp Exception passIInt :: "+passInt);
	passInt=-1;
}
if(name==null||name.length()<=0||name==""||pass==null||pass.length()<=0||pass==""){
	System.out.println("Invalid UserName or Password !!");
	response.sendRedirect("login.jsp?msg=Invalid UserName or Password !!");
}else if((name.equalsIgnoreCase("adm")&&pass.equalsIgnoreCase("adm"))||(name.equalsIgnoreCase("din")&&pass.equalsIgnoreCase("din"))||(passInt>10)){
	
	//admin login
	System.out.println("success !! "+name+" pass : "+pass);
	response.sendRedirect("Student.html");
}else {
	System.out.println("success !! "+name+" pass : "+pass);
	response.sendRedirect("login.jsp?msg=Invalid UserName or Password !!");
	
}
%>