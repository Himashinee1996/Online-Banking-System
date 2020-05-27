package com.bank.customer;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CustomerServiceImpl implements CustomerService{

	private static PreparedStatement ps;
	
	@Override
	public boolean insertCustomer(Customer customer) {
		// TODO Auto-generated method stub
		boolean result =false;
		
		try {
			Connection conn = db.dbconect.connect();
			ps = conn.prepareStatement("INSERT INTO customer(CustomerID,Fullname,Address,Country,NIC,ContactNo,Email,AccountNo,Balance) values(?,?,?,?,?,?,?,?,?)");
			
			ps.setString(1, customer.getCID());
			ps.setString(2, customer.getFullname());
			ps.setString(3, customer.getAddress());
			ps.setString(4, customer.getCountry());
			ps.setString(5, customer.getNIC());
			ps.setString(6, customer.getContactNo());
			ps.setString(7, customer.getEmail());
			ps.setString(8, customer.getAccountNo());
			ps.setString(9, customer.getBalance());
			
			System.out.println("In the service");
			
			result = ps.execute();
			conn.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}

	@Override
	public boolean modifyCustomer(Customer customer) {
		// TODO Auto-generated method stub
		boolean result =false;
		
		try {
			Connection conn = db.dbconect.connect();
			ps = conn.prepareStatement("UPDATE customer SET CustomerID=?,Address=?,Country=?,NIC=?,ContectNo=?,Email=?,AccountNo=? Balance=? WHERE CustomerID=?");
			
			ps.setString(1, customer.getCID());
			ps.setString(2, customer.getFullname());
			ps.setString(3, customer.getAddress());
			ps.setString(4, customer.getCountry());
			ps.setString(5, customer.getNIC());
			ps.setString(6, customer.getContactNo());
			ps.setString(7, customer.getEmail());
			ps.setString(8, customer.getAccountNo());
			ps.setString(9, customer.getBalance());
			
			result = ps.execute();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}

	@Override
	public boolean deleteCustomer(Customer customer) {
		
		boolean result =false;
		
		try {
			Connection conn =db.dbconect.connect();
			ps = conn.prepareStatement("DELETE FROM customer WHERE CustomerID=?");
			
			ps.setString(1, customer.getCID());
			result = ps.execute();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}

}
