package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		
		out.print(" <h1 align='center'>Registration Form</h1>																									");
		out.print("  <form action='InsertServlet' method='POST'>                                                                                              ");
		out.print("      <table class='table' >                                                                                                                  ");
		out.print("          <tr>	                                                                                                                             ");
		out.print("              <td>FirstName:-</td><td><input type='text' name='FirstName'   value='"+request.getAttribute("firstName")+"'  required></td>           ");
		out.print("              <td>MiddleName:-</td><td><input type='text' name='MiddleName'  value='"+request.getAttribute("middleName")+"' required></td>       ");
		out.print("              <td>LastName:-</td><td><input type='text' name='LastName'  value='"+request.getAttribute("lastName")+"' required></td>              ");
		out.print("          </tr>                                                                                                                               ");
		out.print("          <tr>                                                                                                                                ");
		out.print("              <td>BirthDate:-</td>                                                                                               ");
		out.print("              <td><input type='date' name='BirthDate' value='"+request.getAttribute("bday")+"' required></td>                                                                    ");
		out.print("          </tr>                                                                                                                               ");
		out.print("          <tr>                                                                                                                                ");
		out.print("              <td>Gender:-</td>                                                                                                  ");
		out.print("              <td ><input type='radio' name='Gender'  value='Male' >Male                                                                 ");
		out.print("              <input type='radio' name='Gender'  value='Female'>Female                                                                   ");
		out.print("              <input type='radio' name='Gender' value='Other'>Other</td>                                                                ");
		out.print("          </tr>                                                                                                                               ");
		out.print("          <tr>                                                                                                                                ");
		out.print("              <td>Email:-</td>                                                                                                   ");
		out.print("              <td><input type='email' name='Email' value='"+request.getAttribute("email")+"' required></td>                                                   ");
		out.print("          </tr>                                                                                                                               ");
		out.print("          <tr>                                                                                                                                ");
		out.print("              <td>Password:-</td>                                                                                                ");
		out.print("              <td><input type='password' name='Password' value='"+request.getAttribute("password")+"' required></td>                                          ");
		out.print("          </tr>                                                                                                                               ");
		out.print("          <tr>                                                                                                                                ");
		out.print("              <td>Contact No:-</td>                                                                                              ");
		out.print("              <td><input type='text' name='Contact' value='"+request.getAttribute("contact")+"' required></td>                                              ");
		out.print("          </tr>                                                                                                                               ");
		out.print("          <tr>                                                                                                                                ");
		out.print("              <td class='font'>Address:-</td><td><textarea required name='Address' placeholder='Enter Address here.....' >"+request.getAttribute("address")+"</textarea></td>    ");
		out.print("          </tr>                                                                                                                               ");
		out.print("          <tr>                                                                                                                                ");
		out.print("              <td >Pincode:-</td>                                                                                                 ");
		out.print("              <td><input type='text' name='Pincode' value='"+request.getAttribute("pincode")+"' required></td>                                                ");
		out.print("          </tr>                                                                                                                               ");
		out.print("          <tr>                                                                                                                                ");
		out.print("              <td>State:-</td>                                                                                                   ");
		out.print("              <td><input type='text' name='State' value='"+request.getAttribute("state")+"' required></td>                                                    ");
		out.print("              <td >City:-</td>                                                                                                    ");
		out.print("              <td><input type='text' name='City'   value='"+request.getAttribute("city")+"'required></td>                                                      ");
		out.print("          </tr>                                                                                                                               ");
		out.print("          <tr><td><input type='submit' value='Submit' ></td></tr>                                                              ");
		out.print("      </table>                                                                                                                                ");
		out.print("  </form>                                                                                                                                     ");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
