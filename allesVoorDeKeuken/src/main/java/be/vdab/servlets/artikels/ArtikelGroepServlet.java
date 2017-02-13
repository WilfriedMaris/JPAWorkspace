package be.vdab.servlets.artikels;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.services.ArtikelGroepService;

@WebServlet("/artikels/perartikelgroep.htm")
public class ArtikelGroepServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/artikels/artikelspergroep.jsp";
	private final transient ArtikelGroepService artikelgroepService = new ArtikelGroepService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("artikelgroepen", artikelgroepService.findAll());
		String id = request.getParameter("id");
		if(id != null){
					artikelgroepService.read(Long.parseLong(id))
					.ifPresent(artikelgroep -> request.setAttribute("artikels", artikelgroep.getArtikels()));
			
		}
		request.getRequestDispatcher(VIEW).forward(request, response);
	}
}