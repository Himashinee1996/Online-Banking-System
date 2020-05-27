package com.bank.creditcard;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CreditcardServiceImpl implements CreditcardSerivce{

	private static PreparedStatement ps;
	@Override
	public boolean insertCreditcard(Creditcard creditcard) {
		// TODO Auto-generated method stub
		boolean result =false;
		
		try {
			Connection conn = db.dbconect.connect();
			ps = conn.prepareStatement("INSERT INTO creditcard(CardID,AccountNo,Username,CardNo,CVV) values(?,?,?,?,?)");
			
			ps.setString(1, creditcard.getCardID());
			ps.setString(2, creditcard.getAccountNo());
			ps.setString(3, creditcard.getUsername());
			ps.setString(4, creditcard.getCardNo());
			ps.setString(5, creditcard.getCVV());
		
			
			System.out.println("In the service");
			
			result = ps.execute();
			conn.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}

	@Override
	public boolean modifyCreditcard(Creditcard creditcard) {
		// TODO Auto-generated method stub

		boolean result =false;
		
		try {
			Connection conn = db.dbconect.connect();
			ps = conn.prepareStatement("UPDATE creditcard SET CardID=?,AccountNo=?,Username=?,CardNo=?,CVV=? WHERE CardID=?");
			
			ps.setString(1, creditcard.getCardID());
			ps.setString(2, creditcard.getAccountNo());
			ps.setString(3, creditcard.getUsername());
			ps.setString(4, creditcard.getCardNo());
			ps.setString(5, creditcard.getCVV());

			
			
			result = ps.execute();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}

	@Override
	public boolean deleteCreditcard(Creditcard creditcard) {
		// TODO Auto-generated method stub
		boolean result =false;
		
		try {
			Connection conn =db.dbconect.connect();
			ps = conn.prepareStatement("DELETE FROM creditcard WHERE CardID=?");
			
			ps.setString(1, creditcard.getCardID());
			result = ps.execute();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}
}
