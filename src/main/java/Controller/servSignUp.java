package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Connection.TaiKhoanConn;
import Connection.TaiKhoanConn;
import Model.taikhoan;


/**
 * Servlet implementation class servSignUp
 */
@WebServlet("/servSignUp")
public class servSignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public servSignUp() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Đã vào sigin up serv");
		taikhoan tk_new = new taikhoan();
		request.setCharacterEncoding("UTF-8");

		String username = request.getParameter("txtTenDangNhap");
		String myemail = request.getParameter("txtEmail");
		String passWord = request.getParameter("txtPassword");
		String confirm = request.getParameter("txtConfirm");



		if(!passWord.trim().equals(confirm.trim()))
		{
			String error = "Xác nhận mật khẩu sai";
			response.sendRedirect("signup.jsp?error=" + error);
		}
		else
		{
		
			tk_new.setUserName(username);
			tk_new.setPassWord(passWord);	
			tk_new.setEmail(myemail);
			

			// tạo account;

			TaiKhoanConn tkConn = new TaiKhoanConn();

			boolean kq = tkConn.createNewAccount(tk_new);
			if(!kq)
			{
				
				response.sendRedirect("sameAccount.jsp");
			}
			else
			{
				
					response.sendRedirect("login.jsp");
				

			}
		}
	}
}

