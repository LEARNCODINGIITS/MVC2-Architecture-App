package com.iits.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.itts.dao.ProductDAO;
import com.itts.dao.ProductDAOImpl;
import com.itts.model.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api")
public class ProductController extends HttpServlet {

	
	
	public ProductController() {
		System.out.println("--PC object is created--");
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		ProductDAO prodao = new ProductDAOImpl();
		List<Product> list=prodao.getAllProducts();
		
		request.setAttribute("lists", list);
		request.getRequestDispatcher("display.jsp").forward(request, response);
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 PrintWriter out=response.getWriter();
		 response.setContentType("text/html");
		 //we have to get the data from the request object and store in db
		 int pid=Integer.parseInt(request.getParameter("pid"));
		 String pname=request.getParameter("pname");
		 double price=Double.parseDouble(request.getParameter("price"));
	 //Creating an object for a Bean
		  Product product=new Product();
		  product.setPid(pid);
		  product.setPname(pname);
		  product.setPrice(price);
    // Creating an object for DAO implementation class
		  ProductDAO pdao = new ProductDAOImpl();
		 // Invoke the addProduct method
		 boolean status = pdao.addProduct(product);
		 
		 if(status==true) {
			 request.getRequestDispatcher("success.jsp").forward(request, response);
		 }else {
			 out.println("Some Issues");
			 request.getRequestDispatcher("product.jsp").include(request, response);
		 }
		 
		 out.close();
	}
}
