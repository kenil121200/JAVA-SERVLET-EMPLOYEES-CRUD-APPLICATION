package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.EmployeesBean;
import com.dao.EmployeeDao;

/**
 * Servlet implementation class EmployeesServlet
 */
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public InsertServlet() {
        super();
    }
    //bday,gender,address,password,email
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName=request.getParameter("FirstName");
		String middleName=request.getParameter("MiddleName");
		String lastName	=request.getParameter("LastName");
		Date bday =Date.valueOf(request.getParameter("BirthDate"));
		//System.out.println(bday);
		String gender=request.getParameter("Gender");
		String email=request.getParameter("Email");
		String password=request.getParameter("Password");
		long contact = Long.parseLong(request.getParameter("Contact"));
		String address=request.getParameter("Address");
		int pincode	=Integer.parseInt(request.getParameter("Pincode"));
		String state=request.getParameter("State");
		String city=request.getParameter("City");
		boolean flag=false;
		PrintWriter out=response.getWriter();
		if(city!=null)
		{
			if(city.length()>0 || city.trim().length()>0)
			{
				request.setAttribute("city", city);
			}
			else 
			{
				flag=true;
				request.setAttribute("city", "city Can Not Be Null Or Space Please enter Valid data' style='color:red; ");
			}

		}
		if(state!=null)
		{
			if(state.length()>0 || state.trim().length()>0)
			{
				request.setAttribute("state", state);
			}
			else 
			{
				flag=true;
				request.setAttribute("state","state Can Not Be Null Or Space Please enter Valid data' style='color:red; ");
			}

		}			
		if(pincode!=0)
		{
			if(pincode>100000 && pincode<999999)
			{
				request.setAttribute("pincode", pincode);
			}
			else
			{
				flag=true;
				request.setAttribute("pincode","Pincode Can Not Be Null Or Space Please enter Valid data' style='color:red;");
			}
		}
		if(firstName!=null)
		{
			if(firstName.length()>=3 && firstName.length()<=20 && firstName.trim().length()>0 )
			{
				if(firstName.matches("[a-zA-Z]*"))
				{

				
					request.setAttribute("firstName", firstName);
				}
				
			}
			else {
				flag=true;
				request.setAttribute("firstName","FirstName Can Not Be Null Or Space Please enter Valid data ' style='color:red;");
			}
		}
		if(middleName!=null)
		{
			if(middleName.length()>=3 && middleName.length()<=20 && middleName.trim().length()>0 )
			{
				if(middleName.matches("[a-zA-Z]*"))
				{
					request.setAttribute("middleName", middleName);
					
				}
			}
			else {
				flag=true;
				request.setAttribute("middleName","MiddleName Can Not Be Null Or Space Please enter Valid data' style='color:red;");
			}
		
		}
		if(lastName!=null)
		{
			if(lastName.length()>=3 && lastName.length()<=20 && lastName.trim().length()>0 )
			{
				if(lastName.matches("[a-zA-Z]*"))
				{
					
					request.setAttribute("lastName", lastName);
				}
				
			}
			else {
				flag=true;
				request.setAttribute("lastName","LastName Can Not Be Null Or Space Please enter Valid data' style='color:red;");
			}
		}
		
		if(email!=null && email.trim().length()>0) {
			request.setAttribute("email", email);
		}else {
			flag=true;
			request.setAttribute("email", "email Can Not Be Null Or Space Please enter Valid data ' style='color:red;");
		}
		
		if(password!=null && password.trim().length()>0) {
			request.setAttribute("password", password);
		}else {
			flag=true;
			request.setAttribute("password", "password Can Not Be Null Or Space Please enter Valid data ' style='color:red;");
		}
		
		if(address!=null && address.trim().length()>0) {
			request.setAttribute("address", address);
		}else {
			flag=true;
			request.setAttribute("address", "address Can Not Be Null Or Space Please enter Valid data ' style='color:red;");
		}
		
		
		RequestDispatcher rd = null;
		
		if(flag){
			//bday,gender,address,password,email
			
			request.setAttribute("bday",bday );
			request.setAttribute("contact", contact);
			rd=request.getRequestDispatcher("RegistrationServlet");
			rd.forward(request, response);
		}
		else {
			EmployeesBean ebean=new EmployeesBean(0, firstName, middleName, lastName, bday, gender, email, password, contact, address, pincode, state, city);
			EmployeeDao edao=new EmployeeDao();
			int re = edao.insert(ebean);
			if(re>0)
			{       
				System.out.println("List");
				rd=request.getRequestDispatcher("ListEmployeesServlet");      
			}else {                                                           
				rd=request.getRequestDispatcher("Registration.html");         
			} 
			rd.forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
