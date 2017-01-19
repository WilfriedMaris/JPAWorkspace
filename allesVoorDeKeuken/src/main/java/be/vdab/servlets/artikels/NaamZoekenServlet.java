package be.vdab.servlets.artikels;

import java.io.IOException;
import java.util.Collections;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import be.vdab.services.ArtikelService;

@WebServlet("/artikels/zoekenopnaam.htm")
public class NaamZoekenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final transient ArtikelService artikelService = new ArtikelService();
	private final static String VIEW = "/WEB-INF/JSP/artikels/zoekenopnaam.jsp";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String woord = request.getParameter("woord");
		if(woord !=null){
			if(woord.isEmpty()){
				request.setAttribute("fouten", Collections.singletonMap("woord", "verplicht"));
			}else{
				request.setAttribute("artikels", artikelService.findByNameContains(woord));
			}
		}
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

}
