package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Connection.TinTucConn;

/**
 * Servlet implementation class servXoaBai
 */
@WebServlet("/servXoaBai")
public class servXoaBai extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servXoaBai() {
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
	
		String id=request.getParameter("idk"); 


		int idr = -1;
		try {
			idr = Integer.valueOf(id);
		}
		catch (Exception e)
		{
			System.out.println();
		}

		TinTucConn ttc=new TinTucConn();





		boolean kq =ttc.deleteBaiViet(idr);
		if(!kq)
		{
			response.sendRedirect("HomePage.jsp");
		}
		else
		{
			response.sendRedirect("quanlybaiviet.jsp");

		}
	}

}
