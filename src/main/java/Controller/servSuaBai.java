package Controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Connection.TinTucConn;
import Model.TinTuc;
import Model.taikhoan;

/**
 * Servlet implementation class servSuaBai
 */
@WebServlet("/servSuaBai")
public class servSuaBai extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public servSuaBai() {
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
		request.setCharacterEncoding("UTF-8");
		System.out.println("vao servSuaBai roi ne");

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.now();
		String date=dtf.format(localDate); //2016/11/16



		String tenBai = request.getParameter("txtTenBaiViet");
		String ngayDang = request.getParameter("txtNgayDang");
		String id=request.getParameter("idk"); 
		String content = request.getParameter("txtContent");

		int idr = -1;
		try {
			idr = Integer.valueOf(id);
		}
		catch (Exception e)
		{
			System.out.println();
		}

		TinTuc t=new TinTuc(idr,tenBai,content);
		  request.setAttribute("tintuc", t); 
		  RequestDispatcher rd =  
		             request.getRequestDispatcher("ViewDetail.jsp"); 
		
		          rd.forward(request, response); 
		
		
		TinTucConn ttc=new TinTucConn();





		boolean kq =ttc.editBaiViet(idr, tenBai, ngayDang,content);
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
