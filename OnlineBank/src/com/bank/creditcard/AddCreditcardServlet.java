package com.bank.creditcard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddRoomsServlet
 */
@WebServlet("/AddCreditcardServlet")
public class AddCreditcardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCreditcardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		boolean result=false;
		Creditcard creditcard = new Creditcard();
		
		creditcard.setCardID(request.getParameter("CardID"));				
		creditcard.setAccountNo(request.getParameter("AccountNo"));
		creditcard.setUsername(request.getParameter("Username"));
		creditcard.setCardNo(request.getParameter("CardNo"));
		creditcard.setCVV(request.getParameter("CVV"));
		
		CreditcardSerivce creditcardService = new CreditcardServiceImpl(); 
		
		result = creditcardService. insertCreditcard(creditcard);	
		
		if(result) {
			response.sendRedirect("Home.jsp");
		}else
			response.sendRedirect("room.jsp");
	}

}
