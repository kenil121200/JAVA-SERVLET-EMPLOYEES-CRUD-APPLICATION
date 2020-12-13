package com.controller;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.EmployeesBean;
import com.dao.EmployeeDao;

public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UpdateServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("id"));
		int id=Integer.parseInt(request.getParameter("id"));
		String firstName=request.getParameter("FirstName");
		String middleName=request.getParameter("MiddleName");
		String lastName	=request.getParameter("LastName");
		Date bday =Date.valueOf(request.getParameter("BirthDate"));
		String gender=request.getParameter("Gender");
		String email=request.getParameter("Email");
		String password=request.getParameter("Password");
		long contact	=Integer.parseInt(request.getParameter("Contact"));
		String address=request.getParameter("Address");
		int pincode	=Integer.parseInt(request.getParameter("Pincode"));
		String state=request.getParameter("State");
		String city=request.getParameter("City");
		EmployeesBean ebean=new EmployeesBean(id, firstName, middleName, lastName, bday, gender, email, password, contact, address, pincode, state, city);
		EmployeeDao edao=new EmployeeDao();
		int re=edao.update(ebean);
		if(re>0)
			response.sendRedirect("ListEmployeesServlet");
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
