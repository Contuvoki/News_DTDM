package Connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Connection.myConnect;
import Model.TinTuc;

public class TinTucConn {

	public boolean createNewStatus(String header,String content, String username,String ngayDang)
	{
		myConnect myConn = new myConnect();
		Connection conn = myConn.getConn();
		try
		{
			Statement stmt = conn.createStatement();
			String sql = "INSERT INTO xemtintuc.tintuc (header,content,userName,ngayDang,status)VALUES('"+header+"','"+content+"','"+username+"','"+ngayDang+"',1)";
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


	public  List<TinTuc> getAllTinTuc()
	{

		List<TinTuc> myList = new ArrayList<TinTuc>();
		myConnect myConn = new myConnect();
		Connection conn = myConn.getConn();
		try {
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM tintuc where status=1";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				TinTuc c = new TinTuc(rs.getInt(1),rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5));
				myList.add(c);
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return myList;
		}catch (Exception e) {
			try {
				conn.close();
			} catch (SQLException ev) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
	}
	public boolean editBaiViet(int id ,String header,String ngayDang,String content)
	{
		myConnect myConn = new myConnect();
		Connection conn = myConn.getConn();
		try
		{
			Statement stmt = conn.createStatement();
			String sql = "Update tintuc set header='"+header+"',ngayDang='"+ngayDang+"',content='"+content+"' where id='"+id+"'";
			stmt.executeUpdate(sql);
			conn.close();
			myConn.CloseConn();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("loi khi edit bai viet");
		}


		try
		{conn.close();}catch (Exception e) {
			// TODO: handle exception
		}
		myConn.CloseConn();
		return false;
	}

	public boolean deleteBaiViet(int id)
	{
		myConnect myConn = new myConnect();
		Connection conn = myConn.getConn();
		try
		{
			Statement stmt = conn.createStatement();
			String sql = "Update TinTuc set status=0 WHERE id='"+id+"';";
			stmt.executeUpdate(sql);
			conn.close();
			myConn.CloseConn();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("loi khi Xoa bai viet");
		}


		try
		{conn.close();}catch (Exception e) {
			// TODO: handle exception
		}
		myConn.CloseConn();
		return false;
	}

	public String getHeaderbyId(int id)
	{
		myConnect myConn = new myConnect();
		Connection conn =myConn.getConn();
		try
		{

			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM tintuc WHERE id = '"+id+"'";
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
	public String getContentbyId(int id)
	{
		myConnect myConn = new myConnect();
		Connection conn =myConn.getConn();
		try
		{

			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM tintuc WHERE id = '"+id+"'";
			ResultSet rs = stmt.executeQuery(sql);

			if(rs.next())
			{
				return rs.getString(3);
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

	public TinTuc getTinTuc(int  id)
	{
		myConnect myConn = new myConnect();
		Connection conn =myConn.getConn();
		try
		{

		Statement stmt = conn.createStatement();
		String sql = "SELECT * FROM TinTuc WHERE id = '"+id+"'";
		ResultSet rs = stmt.executeQuery(sql);
		
		if(rs.next())
		{
			TinTuc tt = new TinTuc(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			conn.close();
			return tt;
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
}
