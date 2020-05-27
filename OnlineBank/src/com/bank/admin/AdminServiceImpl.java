package com.bank.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminServiceImpl implements AdminService {
						
	private static PreparedStatement ps;

	@Override
	public boolean insertAdmin(Admin admin) {
		boolean result =false;
		
		try {
			Connection conn = db.dbconect.connect();
			ps = conn.prepareStatement("INSERT INTO admin(StaffID,UserName,Password) values(?,?,?)");
			
			ps.setString(1, admin.getStaffID());
			ps.setString(2, admin.getUsername());
			ps.setString(3, admin.getPassword());
			
			System.out.println("In the service");
			
			result = ps.execute();
			conn.close();
			
		} catch (Exception e) {
			System.out.println("Exception caught(While inserting customer):"+e);
		}
		return result;
	}

	@Override
	public boolean isAdminValid(Admin admin) {
		boolean result =false;
		
		String recievedUserName="";
		String recievedPassword="";
		
		if(admin.getUsername() != null && admin.getPassword() != null) {
			try {
				Connection conn =db.dbconect.connect();
				ps = conn.prepareStatement("SELECT StaffID,UserName,Password FROM admin WHERE StaffID=?");
				
				ps.setString(1, admin.getStaffID());
				
				ResultSet resultSet = ps.executeQuery();
				
				if(resultSet.next()) {
					recievedUserName = resultSet.getString("UserName");
					recievedPassword = resultSet.getString("Password");
				}
				
				if(admin.getUsername().equals(recievedUserName) && admin.getPassword().equals(recievedPassword)) {
					result =  true;
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return result;
	}

}
