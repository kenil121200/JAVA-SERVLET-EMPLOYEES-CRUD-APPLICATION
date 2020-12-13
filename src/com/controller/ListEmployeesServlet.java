package com.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bean.EmployeesBean;
import com.dao.EmployeeDao;
public class ListEmployeesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ListEmployeesServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<EmployeesBean> list=null;
		PrintWriter out = response.getWriter();
		EmployeesBean ebean=new EmployeesBean();
		EmployeeDao edao=new EmployeeDao();		
//		public EmployeesBean(int id, String firstName, String middleName, String lastName, Date bday, String gender,String email, String password, int contact, String address, int pincode, String state, String city) {
		out.print("<a href='Registration.html'>Click here for insert</a>");
		out.print("<form action=\"ListEmployeesServlet\" action='post'>");
		out.print("<tr><td><select name=\"sorting\">");
		out.print("<option value=\"firstName\" default>Sorting by FirstName</option>");
		out.print("<option value=\"lastName\">Sorting by LastName</option>");
		out.print("<option value=\"middleName\">Sorting by MiddleName</option></tr></td>");
		out.print("<tr><td><input type='submit' value='Submit'></tr</td>");
		out.print("</select>");
		out.print("</form>");
		String sorting=request.getParameter("sorting");
		if(sorting==null)
			sorting="firstName";
		list=edao.select(sorting);
		out.print("  <form action=\"\" method=\"POST\">  ");
	    out.print("    <table class=\"table\">           ");
	    
			out.print("<tr>");
		    out.print("<th>ID</th>");
		    out.print("<th>FirstName</th>");
		    out.print("<th>MiddleName</th>");
		    out.print("<th>LastName</th>");
		    out.print("<th>DOB</th>");
		    out.print("<th>Gender</th>");
		    out.print("<th>Email</th>");
		    out.print("<th>Password</th>");
		    out.print("<th>Contact No</th>");
		    out.print("<th>Address</th>");
		    out.print("<th>PinCode</th>");
		    out.print("<th>State</th>");
		    out.print("<th>City</th>");
		    out.print("<th>Edit</th>");
		    out.print("<th>Delete</th>");
		    out.print("</tr>");
		    for(int i=0;i<list.size();i++)
			{
		    	ebean=list.get(i);
		    	//System.out.println(ebean.getBday());
		    	out.print("<tr>");
		    	out.print("<td>"+ebean.getId()+"</td>");
		    	out.print("<td>"+ebean.getFirstName()+"</td>");
		    	out.print("<td>"+ebean.getMiddleName()+"</td>");
		    	out.print("<td>"+ebean.getLastName()+"</td>");
		    	out.print("<td>"+ebean.getBday()+"</td>");
		    	out.print("<td>"+ebean.getGender()+"</td>");
		    	out.print("<td>"+ebean.getEmail()+"</td>");
		    	out.print("<td>");
		    	for (int j = 0; j <ebean.getPassword().length(); j++) {
					out.print("*");
				}
		    	out.print("</td>");
		    	
		    	out.print("<td>"+ebean.getContact()+"</td>");
		    	out.print("<td>"+ebean.getAddress()+"</td>");
		    	out.print("<td>"+ebean.getPincode()+"</td>");
		    	out.print("<td>"+ebean.getState()+"</td>");
		    	out.print("<td>"+ebean.getCity()+"</td>");
		    	out.print("<td><a href='EditServlet?id="+ebean.getId()+"'>Edit</a></td>");
		    	out.print("<td><a href='DeleteServlet?id="+ebean.getId()+"'>Delete</a></td>");
		    	out.print("</tr>");
			}
		    out.print("</table>");
		    out.print("</form>");
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
