package com.anirudh.Student;

import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.anirudh.Student.dao.StudentDao;
import com.anirudh.Student.pojo.Student;

import com.anirudh.Student.dao.StudentDao;

@Path("/Student")
public class StudentService {
	
	@GET @Path("/show")
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		
		
		return "Working....";
	}
	
	@GET@Path("/listInRange")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Student> findAllInRange(@QueryParam("fromrollno") String roll1,@QueryParam("torollno") String roll2,@QueryParam("sortby") String sortby) {
	//	System.out.println(roll1+" "+roll2);
		StudentDao stDAO=new StudentDao();
		Student student1=new Student();
		student1.setRollno(roll1);
		Student student2=new Student();
		student2.setRollno(roll2);
		return stDAO.findAllStudentInRange(student1,student2,sortby);
	}
	
	
	@GET@Path("/list")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Student> findAll(@QueryParam("sortby") String sortby) {
		StudentDao stDAO=new StudentDao();
		return stDAO.findAllStudent(sortby);
	}
	
	@GET
	@Path("/login")
	@Produces(MediaType.TEXT_PLAIN)
	public int login(@QueryParam("rollno") String rollno,@QueryParam("password") String pass)
	{
		System.out.println(rollno);
		System.out.println(pass);
		StudentDao stDAO=new StudentDao();
		System.out.println(stDAO.login(rollno,pass));
		return stDAO.login(rollno,pass);
	}
	
	
	@PATCH @Path("/update")
	@Consumes({MediaType.APPLICATION_JSON/*,MediaType.APPLICATION_XML*/})
	@Produces({/*MediaType.APPLICATION_XML,*/MediaType.APPLICATION_JSON})
	public Student update(Student s) {		
		StudentDao stDAO=new StudentDao();
		stDAO.updateStudent(s);
		return s;
	}	
	
	@GET@Path("/findByRollno")
	@Produces({/*MediaType.APPLICATION_XML,*/MediaType.APPLICATION_JSON})
	public Student findStudentByRollno(@QueryParam("rollno") String rollno) {
		StudentDao stDAO=new StudentDao();
		Student student=new Student();
		student.setRollno(rollno);
		return stDAO.findStudentByRollno(student);
	}
	
	
	@POST @Path("/addStudent")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces({"application/json", "application/xml"})
	public String addNewStudents(
			@FormDataParam("file") InputStream uploadedInputStream,
			@FormDataParam("file") FormDataContentDisposition fileDetail,
			@FormDataParam("name") String name,
			@FormDataParam("rollno") String roll,
			@FormDataParam("dob") String dob,
			@FormDataParam("physics") int pm,
			@FormDataParam("chemistry") int cm,
			@FormDataParam("math") int mm)
	{
			
		Student st=new Student(name,roll,pm,mm,cm,dob,"");
		String uploadedFileLocation = "/home/anirudh/eclipse-workspac/Student/src/main/webapp/img/" + fileDetail.getFileName();
		st.setPhoto(uploadedFileLocation);
		writeToFile(uploadedInputStream, uploadedFileLocation);
		String output = "File uploaded to : " + uploadedFileLocation+" name : "+name+" roll : "+roll;
		st.setPhoto("img/"+fileDetail.getFileName());
		StudentDao stDAO=new StudentDao();
		stDAO.addStudent(st);
		return st.status;
		
	}
	// save uploaded file to new location
		private void writeToFile(InputStream uploadedInputStream,
			String uploadedFileLocation) {

			try {
				OutputStream out = new FileOutputStream(new File(uploadedFileLocation));
				int read = 0;
				byte[] bytes = new byte[1024];
				out = new FileOutputStream(new File(uploadedFileLocation));
				while ((read = uploadedInputStream.read(bytes)) != -1) {
					out.write(bytes, 0, read);
				}
				out.flush();
				out.close();
			} catch (Exception e) {
				System.out.println("Exception "+e);
			}

		}
}
