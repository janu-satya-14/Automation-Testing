package com.testing.onealpha_2;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public ProductServlet() {
		super();
	}
       public void init() {
    	   ServletContext context = getServletContext();
    	   ArrayList<Product> prodlist = new ArrayList<>();
    	   Product p = new Product(1,"Notebook","50");
    	   prodlist.add(p);
    	   context.setAttribute("data", prodlist);
    	   
       }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 	   ServletContext context = getServletContext();
	 	   ArrayList<Product> prodlist=(ArrayList<Product>)context.getAttribute("data");
	  	  PrintWriter out = response.getWriter();
	  	  for(Product p1:prodlist) {
	  		  out.println(p1.getId()+"\t"+p1.getName()+"\t"+p1.getPrice());
	  	  }
	 	  context.setAttribute("data", prodlist);


	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 	   ServletContext context = getServletContext();
 	   ArrayList<Product> prodlist=(ArrayList<Product>)context.getAttribute("data");
 	  int id =Integer.parseInt(request.getParameter("id"));
 	  String name = request.getParameter("name");
 	  String price=request.getParameter("price");
 	  Product p = new Product(id,name,price);
 	  prodlist.add(p);
 	  context.setAttribute("data", prodlist);
 	  PrintWriter out = response.getWriter();
 	  out.println("Product added successfully!!");

	}

	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}