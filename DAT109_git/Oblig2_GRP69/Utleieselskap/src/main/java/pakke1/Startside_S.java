package pakke1;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Startside_S", urlPatterns = "/homepage")
public class Startside_S extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private Kontor_DAO kontor;
	
	@EJB
	private Reservasjon_DAO res;
	
	@EJB
	private Bil_DAO biler;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Kontor> adresser = kontor.hente_alle_kontor();
		
		req.setAttribute("kontor", adresser);
		
		req.getRequestDispatcher("WEB-INF/homepage.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String dato = req.getParameter("datetimes");
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		
		LocalDateTime datoF = LocalDateTime.parse(dato.substring(0, 16), formatter);
		LocalDateTime datoT = LocalDateTime.parse(dato.substring(19, 35), formatter);
		
		String add = req.getParameter("adresse");
		
		List<Reservasjon> reservasjoner = res.hente_alle_res();
		
		List<String> resSkilt = reservasjoner.stream()
				.map(x -> x.getRegnr())
				.collect(Collectors.toList());
		
		List<String> tilgjen = biler.hente_alle_biler()
				.stream()
				.filter(x -> resSkilt.contains(x.getRegnr()))
				.map(x -> x.getRegnr())
				.collect(Collectors.toList())
				;
		
		for (Reservasjon res : reservasjoner) {
			if (res.getDatofra().compareTo(datoF) < 0 && res.getDatotil().compareTo(datoT) > 0) {
				tilgjen.add(res.getRegnr());
			}
		}
		
		
		
//		req.getRequestDispatcher("WEB-INF/paameldingsbekreftelse.jsp").forward(req, resp);
		
	}
	
	
}
