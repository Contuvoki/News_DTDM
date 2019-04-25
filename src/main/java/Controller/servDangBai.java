package Controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




import Connection.TinTucConn;
import Model.taikhoan;


/**
 * Servlet implementation class servDangBai
 */
@WebServlet("/servDangBai")
public class servDangBai extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public servDangBai() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		System.out.println("vao servDangBai roi ne");

		String header = request.getParameter("txtHeader");
		String content = request.getParameter("txtContent");


		HttpSession session = request.getSession();
		taikhoan tk=new taikhoan();
		tk = (taikhoan) session.getAttribute("user");
		String username=tk.getUserName();




		TinTucConn ttc=new TinTucConn();
		System.out.println("User: "+username);
		System.out.println("Tieude bai viet: "+header);

		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.now();
		String date=dtf.format(localDate); //2016/11/16


	
		
		
		

		boolean kq =ttc.createNewStatus(header, content, username,date);
		
		 
		if(!kq)
		{
			response.sendRedirect("dangbai.jsp");
		}
		else
		{
			response.sendRedirect("HomePage.jsp");

		}



	}

}
