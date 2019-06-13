import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/User")
public class User extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public User() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String Uname = request.getParameter("Uname");
		
		HttpSession s2 = request.getSession();
		s2.setAttribute("Uname",Uname);
		response.sendRedirect("Itemlist.html");
	}

}
