package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Connection.TaiKhoanConn;
import Model.taikhoan;

/**
 * Servlet implementation class servLogin
 */
@WebServlet("/servLogin")
public class servLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public servLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String account = request.getParameter("txtTaiKhoan");
		String pass = request.getParameter("txtMatKhau");
		
		
		
	
		
		
		taikhoan tk;
		TaiKhoanConn tkConn = new TaiKhoanConn();
		tk = tkConn.checkTaiKhoan(account);

		System.out.println(account);
		if(tk !=null)
		{
			String thisPass = TaiKhoanConn.getPassWord(account);
			if(pass.equals(thisPass))
			{
				HttpSession session = request.getSession();
				tk.setPassWord(thisPass);
			
				session.setAttribute("user", tk);
				response.sendRedirect("HomePage.jsp");// hinh nhu chay dc roi do, dung bass moi qua trang HomePage
				return;

			}
			else
			{
				response.sendRedirect("login.jsp");
			}
		}
		else
		{
			response.sendRedirect("login.jsp");
		}
		
		


	}
}


