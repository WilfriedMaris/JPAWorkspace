package be.vdab.servlets.artikels;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import be.vdab.entities.Artikel;
import be.vdab.services.ArtikelService;

@WebServlet("/artikels/toevoegen.htm")
public class ToevoegenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final transient ArtikelService artikelService = new ArtikelService();
	private static final String VIEW = "/WEB-INF/JSP/artikels/toevoegen.jsp";
	private static final String REDIRECT_URL = "%s/artikels/zoekenopnummer.htm?id=%d";
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String naam = request.getParameter("naam");
		BigDecimal aankoopprijs = null;
		BigDecimal verkoopprijs = null;
		Map<String, String> fouten = new HashMap<>();
		
		if(!Artikel.isNaamValid(naam)){
			fouten.put("naam", "Geef een geldige naam in");
		}
		
		try{
			aankoopprijs = new BigDecimal(request.getParameter("aankoopprijs"));
			if(!Artikel.isAankoopprijsValid(aankoopprijs)){
				fouten.put("aankoopprijs", "Geef een geldige aankoopprijs in");
			}
		}catch(NumberFormatException ex){
			fouten.put("aankoopprijs", "Geef een geldige aankoopprijs in");
		}
		
		try{
			verkoopprijs = new BigDecimal(request.getParameter("verkoopprijs"));
			if(!Artikel.isAankoopprijsValid(verkoopprijs)){
				fouten.put("verkoopprijs", "Geef een geldige verkoopprijs in");
			}
		}catch(NumberFormatException ex){
			fouten.put("verkoopprijs", "Geef een geldige verkoopprijs in");
		}
		
		if(fouten.isEmpty()){
			Artikel artikel = new Artikel(naam, aankoopprijs, verkoopprijs);
			artikelService.createArtikel(artikel);
			response.sendRedirect(response.encodeRedirectURL(String.format(REDIRECT_URL, request.getContextPath(), artikel.getId())));
		}else{
			request.setAttribute("fouten", fouten);
			request.getRequestDispatcher(VIEW).forward(request, response);
		}
	}

}
