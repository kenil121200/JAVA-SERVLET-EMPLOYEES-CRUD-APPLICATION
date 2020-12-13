package com.controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bean.EmployeesBean;
import com.dao.EmployeeDao;

public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		response.setContentType("text/html");
		EmployeeDao edao=new EmployeeDao();
		EmployeesBean ebean=edao.getElementById(id);
		PrintWriter out=response.getWriter();
		
		out.print("<form action='UpdateServlet' method='POST'>                                                                                ");
	    out.print("  <table class='table' >                                                                                                      ");
	    out.print("<tr>");
	    out.print("<td>Id:-</td><td><input type='text' value="+ebean.getId()+" name='id' readonly value="+ebean.getId()+"></td>");
	    out.print("</tr>");
	    out.print("      <tr>                                                                                                                    ");
	    out.print("          <td>FirstName:-</td><td><input type='text' name='FirstName'  value="+ebean.getFirstName()+"></td>        ");
	    out.print("          <td>MiddleName:-</td><td><input type='text' name='MiddleName'  value="+ebean.getMiddleName()+"></td>    ");
	    out.print("          <td>LastName:-</td><td><input type='text' name='LastName' value="+ebean.getLastName()+" ></td>           ");
	    out.print("      </tr>                                                                                                                   ");
	    out.print("      <tr>                                                                                                                    ");
	    out.print("          <td>BirthDate:-</td>                                                                                   ");
	    out.print("          <td><input type='date' name='BirthDate' value="+ebean.getBday()+"></td>                                                                 ");
	    out.print("      </tr>                                                                                                                   ");
	    out.print("      <tr>                                                                                                                    ");
	    out.print("          <td>Gender:-</td>                                                        ");
	    out.print("          <td ><input type='radio' name='Gender' value='Male' checked>Male                                                      ");
	    out.print("          <input type='radio' name='Gender'  value='Female'>Female                                                       ");
	    out.print("          <input type='radio' name='Gender'  value='Other'>Other</td>                                                    ");
	    out.print("      </tr>                                                                                                                   ");
	    out.print("      <tr>                                                                                                                    ");
	    out.print("          <td>Email:-</td>                                                                                       ");
	    out.print("          <td><input type='email' name='Email' value="+ebean.getEmail()+"></td>                                                ");
	    out.print("      </tr>                                                                                                                   ");
	    out.print("      <tr>                                                                                                                    ");
	    out.print("          <td>Password:-</td>                                                                                    ");
	    out.print("          <td><input type='password' name='Password' value="+ebean.getPassword()+"></td>                                       ");
	    out.print("      </tr>                                                                                                                   ");
	    out.print("      <tr>                                                                                                                    ");
	    out.print("          <td>Contact No:-</td>                                                                                  ");
	    out.print("          <td><input type='text' name='Contact' value="+ebean.getContact()+"></td>                                           ");
	    out.print("      </tr>                                                                                                                   ");
	    out.print("      <tr>                                                                                                                    ");
	    out.print("          <td>Address:-</td><td><textarea name='Address' value='Enter Address here.....' >"+ebean.getAddress()+"</textarea></td> ");
	    out.print("      </tr>                                                                                                                   ");
	    out.print("      <tr>                                                                                                                    ");
	    out.print("          <td>Pincode:-</td>                                                                                     ");
	    out.print("          <td><input type='text' name='Pincode'value="+ebean.getPincode()+"></td>                                             ");
	    out.print("      </tr>                                                                                                                   ");
	    out.print("      <tr>                                                                                                                    ");
	    out.print("          <td>State:-</td>                                                                                       ");
	    out.print("          <td><input type='text' name='State' value="+ebean.getState()+"></td>                                                 ");
	    out.print("          <td>City:-</td>                                                                                        ");
	    out.print("          <td><input type='text' name='City'  value="+ebean.getCity()+"></td>                                                   ");
	    out.print("      </tr>                                                                                                                   ");
	    out.print("      <tr><td><input type='submit' value='Submit'></td></tr>                                                  ");
	    out.print("  </table>                                                                                                                    ");
	    out.print("</form>                                                                                                                       ");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
