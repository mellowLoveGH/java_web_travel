package show;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DBAdmin;
import javabean.Post;
import javabean.User;

/**
 * Servlet implementation class UserInfo
 */
@WebServlet("/UserInfo")
public class UserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name = request.getParameter("name");
//		System.out.println();
		
		List<Post> list = DBAdmin.reading(name);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		//
		String html = "<html><table border='1' align='center' width='360'>";
		html = html + "<tr><th>username</th><th>id</th><th>title</th><th>content</th><th>operation</th></tr>";
		for (int i = 0; i < list.size(); i++) {
			Post post = list.get(i);
			
			//
			int id = post.getId();
			String title = post.getTitle();
			String content = post.getContent();
			String operation = "<a href='DeletePost?name=" + name + "&&id=" + id + "'>delete</a>";;
			
			String line = "<tr><td>" + name + "</td><td>" + id + "</td><td>" + title + "</td><td>" + content + "</td><td>" + "<a href = ''>" + operation + "</a></td></tr>";
			html = html + line;
		}
		html = html + "</table></html>";
		
		
		//
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
