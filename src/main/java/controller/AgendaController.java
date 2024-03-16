package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.AgendaDAO;
import model.AgendaBean;

@WebServlet(urlPatterns = { "/Controller", "/main", "/insert" })
public class AgendaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	AgendaDAO agendaDAO = new AgendaDAO();
	AgendaBean contato = new AgendaBean();

	public AgendaController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String servletPath = request.getServletPath();

		if (servletPath.equals("/main")) {
			listarContatos(request, response);
		} else if (servletPath.equals("/insert")) {
			criarContato(request, response);
		} else {
			response.sendRedirect("index.html");
		}
		
	}

	// listar contatos
	protected void listarContatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<AgendaBean> listaContatos = agendaDAO.listarContatos();
	}

	// Cria novo contato
	protected void criarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		contato.setNome(request.getParameter("nome"));
		contato.setFone(request.getParameter("fone"));
		contato.setEmail(request.getParameter("email"));
		
		agendaDAO.criarContato(contato);
		
		response.sendRedirect("main");
	}

}
