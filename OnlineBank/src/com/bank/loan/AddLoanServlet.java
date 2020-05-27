package com.bank.loan;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddRoomsServlet
 */
@WebServlet("/AddLoanServlet")
public class AddLoanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddLoanServlet() {
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
		Loan loan = new Loan();
		
		loan.setLoanID(request.getParameter("LoanID"));				
		loan.setLoanType(request.getParameter("LoanType"));
		loan.setLoanAmount(request.getParameter("LoanAmount"));
		loan.setIntrest(request.getParameter("Intrest"));
		loan.setTotalLoan(request.getParameter("TotalLoan"));
		loan.setLoanStart(request.getParameter("LoanStart"));
		loan.setLoanEnd(request.getParameter("LoanEnd"));
		
		
		LoanSerivce loanService = new LoanServiceImpl(); 
		
		result = loanService. insertLoan(loan);	
		
		if(result) {
			response.sendRedirect("index.html");
		}else
			response.sendRedirect("contact.html");
	}

}
