package com.bank.customer;


public interface CustomerService {
	public boolean insertCustomer(Customer customer);
	public boolean modifyCustomer(Customer customer);
	public boolean deleteCustomer(Customer customer);

}
