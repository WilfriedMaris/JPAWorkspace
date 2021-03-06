package be.vdab.servlets.artikels;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.services.ArtikelService;

@WebServlet("/artikels/zoekenopnummer.htm")
public class ZoekenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/artikels/zoeken.jsp";
	private final transient ArtikelService artikelService = new ArtikelService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getQueryString() != null){
			try{
				artikelService.read(Long.parseLong(request.getParameter("id")))
				.ifPresent(artikel-> request.setAttribute("artikel",artikel));
			}catch(NumberFormatException ex){
				request.setAttribute("fout", "Geef een correct nummer in.");
				//bovenstaande is een beetje overbodig omwille van controles door browser.
			}
		}
		request.getRequestDispatcher(VIEW).forward(request, response);
	}
}