package com.anirudh.Student.dao;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

import com.anirudh.Student.pojo.Student;
import com.anirudh.Student.uility.DBConnection;

public class StudentDao {

	public StudentDao() {}
	
	
	public int addStudent(Student students) {
		String logHaed="StudentDao.class :: addStudent() ";
		int result=-1;
		java.sql.Connection conn=null;
		DBConnection dbConn=new DBConnection();
		try {
			Student stud=findStudentByRollno(students);
			
			if(students.rollno.equals(stud.rollno)) {//already registered student 
				System.out.println(stud.rollno);
				students.setStatus("Sorry | Roll NO "+students.getRollno()+" Already Registered.");
			}else { //process registration
			
			conn=dbConn.getDBConnection("anirudh", "Pr@shan1");
			if(conn!=null) {
			Statement st=conn.createStatement();
			int marks1=students.getPhysics();
			int marks2=students.getMath();
			int marks3=students.getChemistry();
			float avg= (marks1+marks2+marks3)/3;
			String remark;
			if(avg>=90.0) {remark="A";}
			else if(avg>=80&&avg<90){remark="B";}
			else if(avg>=70&&avg<80){remark="C";}
			else {remark="D";}
			
			String sql="insert into Student(name,rollno,physics,math,chemistry,dob,photo,grade) values('"+students.getName()+"','"+students.getRollno()+"',"+students.getPhysics()+","+students.getMath()+","+students.getChemistry()+",'"+students.getDob()+"','"+students.getPhoto()+"','"+remark+"');";
			//System.out.println(logHaed+" SQL :: "+sql+" :: Result :: "+"your Data is saved");
			result=st.executeUpdate(sql);
				System.out.println(logHaed+" SQL :: "+sql+" :: Result :: "+"your Data is saved");
			}else {
				System.out.println(logHaed+" DB Connection Not Created :: ");
			}
		}
			}
		catch(Exception e) {
			result=-2;
			System.out.println(logHaed+" Exception while adding new Students "+e);
			
		}finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return result;
	}
	
	public int login(String rollno,String password)
	{
		System.out.println("login validation");
		String pass="";
		java.sql.Connection conn=null;
		java.sql.ResultSet rs=null;
		DBConnection DBconn=new DBConnection();
		try {
			conn=DBconn.getDBConnection("anirudh", "Pr@shan1");
			if(conn!=null) {
				Statement st=conn.createStatement();
				String sql="select name from Student where rollno='"+rollno+"' ;";
				rs=st.executeQuery(sql);
				System.out.println(rs);
			while(rs.next()) {
				pass=rs.getString(1);
			}
				if(st!=null)st.close();
				st=null;
			}
			else {
				System.out.println(" DB Connection Not Created :: ");
			}
		}catch(Exception e) {
			System.out.println(e);
		}	
		System.out.println(pass);
		if(pass.equals(password))
		{
			return 1;
		}
		else return 0;
	}
	
	
	
	
	
	public List<Student> findAllStudent(String sortby) {
		String logHaed="StudentDao.class :: findAllStudent() ";
		List<Student> student_list=new ArrayList<>();
		//Student student=null;
		java.sql.Connection conn=null;
		java.sql.ResultSet rs=null;
		DBConnection dbConn=new DBConnection();
		try {
			
			conn=dbConn.getDBConnection("anirudh", "Pr@shan1");
			if(conn!=null) {
			Statement st=conn.createStatement();
			String sql="select name,rollno,physics,math,chemistry,dob,photo from Student order by "+sortby+" asc;";
			rs=st.executeQuery(sql);
			while(rs.next()) {
				Student student=new Student();
				student.setName(rs.getString("name"));				
				student.setRollno(rs.getString("rollno"));
				student.setPhysics(rs.getInt("physics"));
				student.setMath(rs.getInt("math"));
				student.setChemistry(rs.getInt("chemistry"));
				student.setDob(rs.getString("dob"));
				student.setPhoto(rs.getString("photo"));
				double avg=((student.getPhysics()+student.getMath()+student.getChemistry())/3);
				if(avg>=90.0) {student.setGrade("A");}
				else if(avg>=80.0&&avg<90.0){student.setGrade("B");}
				else if(avg>=70.0&&avg<80.0){student.setGrade("C");}
				else {student.setGrade("D");}
				
				
				student_list.add(student);
			}
			if(st!=null)st.close();
			st=null;
			if(rs!=null)rs=null;
				System.out.println(logHaed+" SQL :: "+sql+" :: Result :: "+student_list.size());
			}else {
				System.out.println(logHaed+" DB Connection Not Created :: ");
			}
		}catch(Exception e) {
			System.out.println(logHaed+" Exception while adding new Students "+e);
			
		}finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return student_list;
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Student loginStudent(Student s1 ) {
		String logHead="StudentDao.class :: updateStudent() ";
		int result=-1;
		java.sql.Connection conn=null;
		java.sql.ResultSet rs=null;
		DBConnection DBconn=new DBConnection();
		try {
			conn=DBconn.getDBConnection("anirudh", "Pr@shan1");
			if(conn!=null) {
				Statement st=conn.createStatement();	
			//	String sql1="update student set physics='"+s.getPhysics()+"',chemistry='"+s.getChemistry()+"',math='"+s.getMath()+"' where rollno='"+s.getRollno()+"';";
				String sql="select * from Student where rollno='"+s1.getRollno()+"'and name='"+s1.getName()+"';";
				rs=st.executeQuery(sql);
				System.out.println(logHead+" SQL :: "+sql+" :: Result :: "+s1.toString());
				System.out.println(rs);
				if(result>0) {
					System.out.println("login Successfully");
				}
				else 
				{
					System.out.println("Unable to login.");
				}
				if(st!=null)st.close();
				st=null;
			}else {
				System.out.println("Fail To Creating mysql Connection");
			}
			
		}catch(Exception ex) {
			System.out.println("Exception occured While Creating mysql Connection :: "+ex);

		}finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		return s1;	
	}
	
	public Student findStudentByRollno(Student students) {
		String logHaed="StudentDao.class :: findStudentByRollno() ";
		int result=-1;
		Student student=new Student();
		student.setRollno("NA");
		java.sql.Connection conn=null;
		java.sql.ResultSet rs=null;
		DBConnection dbConn=new DBConnection();
		try {
			conn=dbConn.getDBConnection("anirudh", "Pr@shan1");
			if(conn!=null) {
			Statement st=conn.createStatement();
			String sql="select name, rollno, physics, math, chemistry, dob, photo from Student where rollno='"+students.getRollno()+"';";
			rs=st.executeQuery(sql);
			if(rs.next()) {
				student.setName(rs.getString("name"));				
				student.setRollno(rs.getString("rollno"));
				student.setPhysics(rs.getInt("physics"));
				student.setMath(rs.getInt("math"));
				student.setChemistry(rs.getInt("chemistry"));
				student.setDob(rs.getString("dob"));
				student.setPhoto(rs.getString("photo"));
				double avg=((student.getPhysics()+student.getMath()+student.getChemistry())/3);
				if(avg>=90.0) {student.setGrade("A");}
				else if(avg>=80&&avg<90){student.setGrade("B");}
				else if(avg>=70&&avg<80){student.setGrade("C");}
				else {student.setGrade("D");}
				
			}
			if(st!=null)st.close();
			st=null;
			if(rs!=null)rs=null;
				System.out.println(logHaed+" SQL :: "+sql+" :: Result :: "+student.toString());
			}else {
				System.out.println(logHaed+" DB Connection Not Created :: ");
			}	
		}catch(Exception e) {
			result=-2;
			System.out.println(logHaed+" Exception while adding new Students "+e);
			
		}finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return student;
	}
	
	
	
	public List<Student> findAllStudentInRange(Student s1,Student s2,String sortby) {
		//System.out.println(s1.getRollno()+" "+s2.getRollno());
		String logHaed="StudentDao.class :: findAllStudentInRange() ";
		List<Student> student_list=new ArrayList<>();
		java.sql.Connection conn=null;
		java.sql.ResultSet rs=null;
		DBConnection dbConn=new DBConnection();
		try {
			conn=dbConn.getDBConnection("anirudh", "Pr@shan1");
			if(conn!=null) {
			Statement st=conn.createStatement();
			String sql= "select name,rollno,physics,math,chemistry,dob,photo from Student where rollno between'"+s1.getRollno()+"'and'"+s2.getRollno()+"' order by "+sortby+" asc;";
			rs=st.executeQuery(sql);
			while(rs.next()) {
				Student student=new Student();
				student.setName(rs.getString("name"));				
				student.setRollno(rs.getString("rollno"));
				student.setPhysics(rs.getInt("physics"));
				student.setMath(rs.getInt("math"));
				student.setChemistry(rs.getInt("chemistry"));
				student.setDob(rs.getString("dob"));
				student.setPhoto(rs.getString("photo"));
				double avg=((student.getPhysics()+student.getMath()+student.getChemistry())/3);
				if(avg>=90.0) {student.setGrade("A");}
				else if(avg>=80.0&&avg<90.0){student.setGrade("B");}
				else if(avg>=70.0&&avg<80.0){student.setGrade("C");}
				else {student.setGrade("D");}

				student_list.add(student);
			}
			if(st!=null)st.close();
			st=null;
			if(rs!=null)rs=null;
				System.out.println(logHaed+" SQL :: "+sql+" :: Result :: "+student_list.size());
			}else {
				System.out.println(logHaed+" DB Connection Not Created :: ");
			}
		}catch(Exception e) {
			System.out.println(logHaed+" Exception while adding new Students "+e);
			
		}finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return student_list;
	}

	public List<Student> findAllStudentInRange(long s1,long s2) {
		//System.out.println(s1.getRollno()+" "+s2.getRollno());
		String logHaed="StudentDao.class :: findAllStudentInRange() ";
		List<Student> student_list=new ArrayList<>();
		java.sql.Connection conn=null;
		java.sql.ResultSet rs=null;
		DBConnection dbConn=new DBConnection();
		try {
			conn=dbConn.getDBConnection("anirudh", "Pr@shan1");
			if(conn!=null) {
			Statement st=conn.createStatement();
			String sql= "select name,rollno,physics,math,chemistry,dob,photo from Student where rollno between "+s1+" and "+s2+";";
			rs=st.executeQuery(sql);
			while(rs.next()) {
				Student student=new Student();
				student.setName(rs.getString("name"));				
				student.setRollno(rs.getString("rollno"));
				student.setPhysics(rs.getInt("physics"));
				student.setMath(rs.getInt("math"));
				student.setChemistry(rs.getInt("chemistry"));
				student.setDob(rs.getString("dob"));
				student.setPhoto(rs.getString("photo"));
				double avg=((student.getPhysics()+student.getMath()+student.getChemistry())/3);
				if(avg>=90.0) {student.setGrade("A");}
				else if(avg>=80.0&&avg<90.0){student.setGrade("B");}
				else if(avg>=70.0&&avg<80.0){student.setGrade("C");}
				else {student.setGrade("D");}

				student_list.add(student);
			}
			if(st!=null)st.close();
			st=null;
			if(rs!=null)rs=null;
				System.out.println(logHaed+" SQL :: "+sql+" :: Result :: "+student_list.size());
			}else {
				System.out.println(logHaed+" DB Connection Not Created :: ");
			}
		}catch(Exception e) {
			System.out.println(logHaed+" Exception while adding new Students "+e);
			
		}finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return student_list;
	}
	
	public Student findStudentByRollpass(Student students) {
		String logHaed="StudentDao.class :: findStudentByRollno() ";
		int result=-1;
		Student student=new Student();
		student.setRollno("NA");
		student.setName("NA");
		java.sql.Connection conn=null;
		java.sql.ResultSet rs=null;
		DBConnection dbConn=new DBConnection();
		try {
			conn=dbConn.getDBConnection("anirudh", "Pr@shan1");
			if(conn!=null) {
			Statement st=conn.createStatement();
			String sql="select rollno,name from Student where rollno='"+students.getRollno()+"' and name='"+students.getName()+"' ;";
			rs=st.executeQuery(sql);
			if(rs.next()) {
				student.setName(rs.getString("name"));				
				student.setRollno(rs.getString("rollno"));
				student.setPhysics(rs.getInt("physics"));
				student.setMath(rs.getInt("math"));
				student.setChemistry(rs.getInt("chemistry"));
				student.setDob(rs.getString("dob"));
				student.setPhoto(rs.getString("photo"));
				double avg=((student.getPhysics()+student.getMath()+student.getChemistry())/3);
				if(avg>=90.0) {student.setGrade("A");}
				else if(avg>=80&&avg<90){student.setGrade("B");}
				else if(avg>=70&&avg<80){student.setGrade("C");}
				else {student.setGrade("D");}
				
			}
			if(st!=null)st.close();
			st=null;
			if(rs!=null)rs=null;
				System.out.println(logHaed+" SQL :: "+sql+" :: Result :: "+student.toString());
			}else {
				System.out.println(logHaed+" DB Connection Not Created :: ");
			}	
		}catch(Exception e) {
			result=-2;
			System.out.println(logHaed+" Exception while adding new Students "+e);
			
		}finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return student;
	}
	
	
	public Student updateStudent(Student s) {
		String logHead="StudentDao.class :: updateStudent() ";
		int result=-1;
		java.sql.Connection conn=null;
		DBConnection DBconn=new DBConnection();
		try {
			conn=DBconn.getDBConnection("anirudh", "Pr@shan1");
			if(conn!=null) {
				Statement st=conn.createStatement();	
				String sql="update Student set name='"+s.getName()+"', physics='"+s.getPhysics()+"',chemistry='"+s.getChemistry()+"',math='"+s.getMath()+"',dob='"+s.getDob()+"' where rollno='"+s.getRollno()+"';";
				result=st.executeUpdate(sql);
				System.out.println(logHead+" SQL :: "+sql+" :: Result :: "+"your Data is saved");
				if(result>0) {
					System.out.println("Data Update Successfully");
				}
				else 
				{
					System.out.println("Unable to Update data.");
				}
				if(st!=null)st.close();
				st=null;
			}else {
				System.out.println("Fail To Creating mysql Connection");
			}
			
		}catch(Exception ex) {
			System.out.println("Exception occured While Creating mysql Connection :: "+ex);

		}finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		return s;	
	}

}
