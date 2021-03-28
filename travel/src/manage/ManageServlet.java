package manage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DBAdmin;
import javabean.User;

/**
 * Servlet implementation class ManageServlet
 */
@WebServlet("/ManageServlet")
public class ManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("manage page");
		
		List<User> list = DBAdmin.reading();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		String html = "<html><table border='1' align='center' width='360'>";
		html = html + "<tr><th>username</th><th>detail</th><th>operation</th></tr>";
		for (int i = 0; i < list.size(); i++) {
			User u = list.get(i);
			String name = u.getName();
			
			//
			String detail = "<a href='UserInfo?name=" + name + "'>see more</a>";
			String operation = "<a href='DeleteUser?name=" + name + "'>delete</a>";;
			
			String line = "<tr><td>" + name + "</td><td>" + detail + "</td><td><a href = ''>" + operation + "</a></td></tr>";
			html = html + line;
		}
		
		//
		String notice = "<a href='sendNotice.jsp'>" + "send notice" + "</a>";
		
		html = html + "</table><br/><br/>" + notice + "</html>";
		
		
		
		response.getWriter().append(html);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
}
