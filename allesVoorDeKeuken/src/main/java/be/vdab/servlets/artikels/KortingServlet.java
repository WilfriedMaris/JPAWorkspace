package be.vdab.servlets.artikels;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.services.ArtikelService;

@WebServlet("/artikels/kortingen.htm")
public class KortingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/artikels/korting.jsp";
	private final ArtikelService artikelService = new ArtikelService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("artikels", artikelService.findByNameContains(""));
		String id = request.getParameter("id");
		if(id != null){
			artikelService.read(Long.parseLong(id)).ifPresent(artikel -> request.setAttribute("artikel",artikel));
		}
		request.getRequestDispatcher(VIEW).forward(request, response);
	}
}
