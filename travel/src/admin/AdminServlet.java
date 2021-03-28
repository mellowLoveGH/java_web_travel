package admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String method = request.getParameter("method");
		if("login".equals(method)) {
			 String username = request.getParameter("username");  
	         String password = request.getParameter("password");
	         
	         if(username.equals("admin") && password.equals("admin")) {
	        	 System.out.println("successful!");
//	        	 RequestDispatcher dispatcher =  request.getRequestDispatcher("/ManageServlet");
//	        	 dispatcher.forward(request, response);
	        	 
	        	 response.sendRedirect("/travel/ManageServlet");
	        	 response.getWriter().append("admin login successfully!");
	         }else {
	        	 
	        	 response.getWriter().append("admin login unsuccessfully!");
	         }
	         
		}
		
		
		
//		response.getWriter().append("admin login successfully!");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
