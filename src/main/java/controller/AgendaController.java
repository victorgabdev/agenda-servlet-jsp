package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.AgendaDAO;
import model.AgendaBean;

@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/select", "/update", "/delete" })
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
		} else if (servletPath.equals("/select")) {
			selecionarContato(request, response);
		} else if (servletPath.equals("/update")) {
			editarContato(request, response);
		} else if (servletPath.equals("/delete")) {
			removerContato(request, response);
		} else {
			response.sendRedirect("index.html");
		}

	}

	protected void listarContatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<AgendaBean> listaContatos = agendaDAO.listarContatos();
		request.setAttribute("contatos", listaContatos);
		RequestDispatcher dispatcher = request.getRequestDispatcher("agenda.jsp");
		dispatcher.forward(request, response);
	}

	protected void criarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		contato.setNome(request.getParameter("nome"));
		contato.setFone(request.getParameter("fone"));
		contato.setEmail(request.getParameter("email"));

		agendaDAO.criarContato(contato);

		response.sendRedirect("main");
	}

	protected void selecionarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idcon = request.getParameter("idcon");
		contato.setIdcon(idcon);
		agendaDAO.selecionarContatoPorId(contato);

		request.setAttribute("idcon", contato.getIdcon());
		request.setAttribute("nome", contato.getNome());
		request.setAttribute("fone", contato.getFone());
		request.setAttribute("email", contato.getEmail());

		RequestDispatcher dispatcher = request.getRequestDispatcher("editar.jsp");
		dispatcher.forward(request, response);
	}

	protected void editarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		contato.setIdcon(request.getParameter("idcon"));
		contato.setNome(request.getParameter("nome"));
		contato.setFone(request.getParameter("fone"));
		contato.setEmail(request.getParameter("email"));
		
		agendaDAO.editarContato(contato);
		
		response.sendRedirect("main");
	}
	
	protected void removerContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idcon = request.getParameter("idcon");
		contato.setIdcon(idcon);
		agendaDAO.removerContato(contato);
		
		response.sendRedirect("main");
	}
}
