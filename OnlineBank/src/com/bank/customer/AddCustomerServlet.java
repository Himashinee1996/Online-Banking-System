package com.bank.customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddCustomerServlet
 */
@WebServlet("/AddCustomerServlet")
public class AddCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCustomerServlet() {
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
		Customer customer = new Customer();
		
		customer.setCID(request.getParameter("CustomerID"));				
		customer.setFullname(request.getParameter("Fullname"));
		customer.setAddress(request.getParameter("Address"));
		customer.setCountry(request.getParameter("Country"));
		customer.setNIC(request.getParameter("NIC"));
		customer.setContactNo(request.getParameter("ContactNo"));
		customer.setEmail(request.getParameter("Email"));
		customer.setAccountNo(request.getParameter("AccountNo"));
		customer.setBalance(request.getParameter("Balance"));
		
		CustomerService customerRegistrationService = new CustomerServiceImpl(); 
		
		result = customerRegistrationService.insertCustomer(customer);	
		
		if(result) {
			/*response.sendRedirect("room.jsp");*/
		}else
			response.sendRedirect("index.html");
	}

}
