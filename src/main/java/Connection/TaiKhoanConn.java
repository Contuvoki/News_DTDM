package Connection;

import Connection.myConnect;
import Model.taikhoan;
import Model.taikhoan;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Model.taikhoan;

public class TaiKhoanConn {
	public  taikhoan checkTaiKhoan(String account)
	{
		myConnect myConn = new myConnect();
		Connection conn =myConn.getConn();
		try
		{

		Statement stmt = conn.createStatement();
		String sql = "SELECT * FROM taikhoan WHERE userName = '"+account+"' AND STATUS = 1";
		ResultSet rs = stmt.executeQuery(sql);
		
		if(rs.next())
		{
			taikhoan tk = new taikhoan(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4));
			conn.close();
			return tk;
		}
		else
			{
			conn.close();
			return null;
			}
		}
		catch (Exception e) {
			{
				try {
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				return null;
				}
		}
	}
	public static String getPassWord(String account)
	{
		myConnect myConn = new myConnect();
		Connection conn =myConn.getConn();
		try
		{
		
		Statement stmt = conn.createStatement();
		String sql = "SELECT * FROM taikhoan WHERE userName = '"+account+"'  AND STATUS = 1";
		ResultSet rs = stmt.executeQuery(sql);
		
		if(rs.next())
		{
			return rs.getString(2);
		}
		else
		{
			conn.close();
			return null;
			}
		}
		catch (Exception e) {
			{
				try {
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				return null;
				}
		}
	}
	public static int getRole(String account)
	{
		myConnect myConn = new myConnect();
		Connection conn =myConn.getConn();
		try
		{
		
		Statement stmt = conn.createStatement();
		String sql = "SELECT * FROM taikhoan WHERE userName = '"+account+"'  AND STATUS = 1";
		ResultSet rs = stmt.executeQuery(sql);
		
		if(rs.next())
		{
			return rs.getInt(5);
		}
		else
		{
			conn.close();
			return 1;
			}
		}
		catch (Exception e) {
			{
				try {
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				return 1;
				}
		}
	}
	public boolean createNewAccount(taikhoan newtk)
	{
		myConnect myConn = new myConnect();
		Connection conn = myConn.getConn();
		try
		{
			Statement stmt = conn.createStatement();
			String sql = "INSERT INTO taikhoan VALUES('"+newtk.getUserName()+"','"+newtk.getPassWord()+"','"+newtk.getEmail()+"',1,1)";
			stmt.executeUpdate(sql);
			conn.close();
			myConn.CloseConn();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		try
		{conn.close();}catch (Exception e) {
			// TODO: handle exception
		}
		myConn.CloseConn();
		return false;
	}
}
