package com.easypoetto.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.easypoetto.model.BeachResort;
import com.easypoetto.model.BeachResortFactory;
import com.easypoetto.model.ClientFactory;
import com.easypoetto.model.UserFactory;

/**
 * Servlet implementation class Search
 */
@WebServlet("/search.html")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String[] servicesStrings = request.getParameterValues("service");
		
		String searchDate = request.getParameter("search_date");
		
		//imposta la data odierna
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		String today = formatter.format(cal.getTime());
		
		if(searchDate == null) {
			searchDate = today;
		}
		
		String year = today.substring(0,4);
		request.setAttribute("year", year);
		request.setAttribute("today_date", today);
		request.setAttribute("reservation_date", searchDate);
		request.setAttribute("search_date", searchDate);
		
		List<BeachResort> beachResorts = null;
		
		if(servicesStrings != null) {
		
			List<String> services = new ArrayList<String>(Arrays.asList(servicesStrings));	
			
			Map<String, Boolean> servicesMap = new HashMap<String, Boolean>();
			
			for(String service : services) {
				servicesMap.put(service, true);
			}
			
			beachResorts = BeachResortFactory.getInstance().getFilteredBeachResorts(services, searchDate);
			
			request.setAttribute("servicesMap", servicesMap);
			request.setAttribute("beachResorts", beachResorts);
			
			
		}else {			
			
			beachResorts = BeachResortFactory.getInstance().getBeachResorts(searchDate);
			request.setAttribute("beachResorts", beachResorts);
		}
		
		if(beachResorts.isEmpty()) {
			request.setAttribute("error", "Non sono stati trovati stabilimenti");
		}
		
		HttpSession session = request.getSession(false);
		
		if(session == null || session.getAttribute("email") == null || session.getAttribute("password") == null 
				|| session.getAttribute("role") == null) {
			
			request.setAttribute("logged", false);
			request.getRequestDispatcher("WEB-INF/JSP/search.jsp").forward(request, response);
		}else{
			
			//System.out.println("esiste sessione");
			
			String email = (String) session.getAttribute("email");
			String password = (String) session.getAttribute("password");
			Integer role = (Integer) session.getAttribute("role");
			
			if (email!= null && password != null && role != null &&
					!email.isEmpty() && !password.isEmpty() && role >= 0 && role <= 2 &&
					UserFactory.getInstance().login(email, password) == role){
				
				request.setAttribute("role", role);
				request.setAttribute("logged", true);
			}else {
				request.setAttribute("logged", false);
			}
			
			request.getRequestDispatcher("WEB-INF/JSP/search.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(false);
		
		if(session == null || session.getAttribute("email") == null || session.getAttribute("password") == null 
				|| session.getAttribute("role") == null) {
			
			request.setAttribute("logged", false);
			
		}else{
			
			//System.out.println("esiste sessione");
			
			String email = (String) session.getAttribute("email");
			String password = (String) session.getAttribute("password");
			Integer role = (Integer) session.getAttribute("role");
			
			if (email!= null && password != null && role != null &&
					!email.isEmpty() && !password.isEmpty() && role >= 0 && role <= 2 &&
					UserFactory.getInstance().login(email, password) == role){
				
				if(role == 2 && ClientFactory.getInstance().getClient(email) == null) {
									
					request.setAttribute("complete_profile", true);

				}else{
					request.setAttribute("complete_profile", false);
				}
				
				String date = request.getParameter("reservation_date");
				request.setAttribute("reservation_date", date);
				
				request.setAttribute("role", role);
				request.setAttribute("logged", true);
			}else {
				request.setAttribute("logged", false);
			}
			
		}	


		request.setAttribute("beachResort", 
				BeachResortFactory.getInstance().getBeachResortById(Integer.parseInt(request.getParameter("beachResortId"))));
		request.getRequestDispatcher("WEB-INF/JSP/beach_resort.jsp").forward(request, response);
	}

}
