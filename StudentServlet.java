package com.testing.onealpha_2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static ArrayList<Student> slist = new ArrayList<>();
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("student details");
		for(Student st:slist) {
			out.println("Id: "+st.getId());
			out.println("Name: "+st.getName());
			out.println("Department: "+st.getDept());
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id1 = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String dept = request.getParameter("dept");
		
		Student st = new Student(id1, name, dept);
		slist.add(st);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("details are added successfully");
		
	}
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		
		out.println("student details");
		boolean found = false;
		for(Student st:slist) {
			if(id == st.getId()) {
				st.setName("Tharuni");
				st.setDept("cse");
				found = true;
				break;
			}
		}
		if(found) {
			out.println("Details updated");
		}
		else {
			out.println("Details are not updated");
		}
	}

}
