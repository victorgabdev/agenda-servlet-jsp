package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet(urlPatterns = {"/Controller", "/main"})
public class AgendaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AgendaController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String servletPath = request.getServletPath();
		
		if(servletPath.equals("/main")) {
			response.sendRedirect("agenda.jsp");
		}
	}

}
