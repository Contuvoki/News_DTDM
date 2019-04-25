package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Connection.TinTucConn;
import Model.TinTuc;

/**
 * Servlet implementation class servXemBai
 */
@WebServlet("/servXemBai")
public class servXemBai extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servXemBai() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		String idBaiViet=request.getParameter("idk");
		
		System.out.println("id bai viet la: "+idBaiViet);
		int idr = -1;
		try {
			idr = Integer.valueOf(idBaiViet);
		}
		catch (Exception e)
		{
			System.out.println();
		}
		System.out.println("id bai viet nay la: "+idr);

		TinTucConn ttc=new TinTucConn();
		
		TinTuc tt =new TinTuc();
		tt=ttc.getTinTuc(idr);
		
		  request.setAttribute("tintuc", tt); 
		  RequestDispatcher rd =  
		             request.getRequestDispatcher("ViewDetail.jsp"); 
		
		          rd.forward(request, response); 
		
	
		           
	}

}
