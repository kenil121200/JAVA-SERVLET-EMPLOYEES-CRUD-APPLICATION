package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bean.EmployeesBean;
import com.util.DBConnection;

public class EmployeeDao 
{
	public int insert(EmployeesBean ebean) 
	{
		String insertQuery="insert into employees(FirstName,MiddleName,LastName,BirthDay,Gender,Email,Password,Contact,Address,Pincode,State,City) values(?,?,?,?,?,?,?,?,?,?,?,?);";
		Connection conn=DBConnection.setConnection();
		PreparedStatement pstmt=null;
		int re = 0;
		try {
			pstmt=conn.prepareStatement(insertQuery);
			pstmt.setString(1,ebean.getFirstName());
			pstmt.setString(2,ebean.getMiddleName());
			pstmt.setString(3,ebean.getLastName());
			pstmt.setDate(4, ebean.getBday());
			pstmt.setString(5, ebean.getGender());
			pstmt.setString(6,ebean.getEmail());
			pstmt.setString(7,ebean.getPassword());
			pstmt.setLong(8, ebean.getContact());
			pstmt.setString(9, ebean.getAddress());
			pstmt.setInt(10, ebean.getPincode());
			pstmt.setString(11,ebean.getState());
			pstmt.setString(12, ebean.getCity());
			 re=pstmt.executeUpdate();
			if (re>0) {
				System.out.println("Data inserted Succesfully");
			} else {
				System.out.println("Data not inserted");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return re;
	}
	public ArrayList<EmployeesBean> select(String sorting)
	{
		String selectQuery=null;
		if(sorting.equals("firstName"))
			selectQuery="select * from employees order by firstname;";
		else if(sorting.equals("middleName"))
			selectQuery="select * from employees order by middlename;";
		else if(sorting.equals("lastName"))
			selectQuery="select * from employees order by lastname;";
		ArrayList<EmployeesBean> list= new ArrayList<EmployeesBean>();
		Connection conn=DBConnection.setConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try 
		{
			pstmt=conn.prepareStatement(selectQuery);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				EmployeesBean ebean = new EmployeesBean(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getDate(5),rs.getString(6), rs.getString(7),rs.getString(8), rs.getLong(9), rs.getString(10), rs.getInt(11),rs.getString(12),rs.getString(13));
				list.add(ebean);
			}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return list;
	}
	public EmployeesBean getElementById(int id)
	{
		String findQuery="select * from employees where id="+id+"";
		Connection conn=DBConnection.setConnection();
		Statement st=null;
		EmployeesBean ebean=null;
		ResultSet rs=null;
		try {
			st=conn.createStatement();
			rs=st.executeQuery(findQuery);
			rs.next();
			ebean=new EmployeesBean(rs.getInt(1), rs.getString(2),rs.getString(3), rs.getString(4), rs.getDate(5),rs.getString(6),rs.getString(7), rs.getString(8), rs.getLong(9), rs.getString(10), rs.getInt(11), rs.getString(12), rs.getString(13));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ebean;
		
	}
	public int delete(int id) 
	{
		String deleteQuery="delete from employees where id="+id+"";
		Connection conn=DBConnection.setConnection();
		int re=0;
		Statement st=null;
		try {
			st=conn.createStatement();
			re=st.executeUpdate(deleteQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return re;
	}
	public int update(EmployeesBean ebean) {
		int re=0;
		String updateQuery="update employees set FirstName=?,MiddleName=?,LastName=?,BirthDay=?,Gender=?,Email=?,Password=?,Contact=?,Address=?,Pincode=?,State=?,City=? where id=?;";
		Connection conn=DBConnection.setConnection();
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(updateQuery);
			pstmt.setString(1, ebean.getFirstName());
			pstmt.setString(2, ebean.getMiddleName());
			pstmt.setString(3, ebean.getLastName());
			pstmt.setDate(4, ebean.getBday());
			pstmt.setString(5, ebean.getGender());
			pstmt.setString(6, ebean.getEmail());
			pstmt.setString(7, ebean.getPassword());
			pstmt.setLong(8, ebean.getContact());
			pstmt.setString(9, ebean.getAddress());
			pstmt.setInt(10, ebean.getPincode());
			pstmt.setString(11, ebean.getState());
			pstmt.setString(12, ebean.getCity());
			pstmt.setInt(13,ebean.getId());
			re=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return re;
	}
}
