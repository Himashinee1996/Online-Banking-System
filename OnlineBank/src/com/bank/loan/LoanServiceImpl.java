package com.bank.loan;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class LoanServiceImpl implements LoanSerivce{

	private static PreparedStatement ps;
	@Override
	public boolean insertLoan(Loan loan) {
		// TODO Auto-generated method stub
		boolean result =false;
		
		try {
			Connection conn = db.dbconect.connect();
			ps = conn.prepareStatement("INSERT INTO loan(LoanID,LoanType,LoanAmount,Intrest,TotalLoan,LoanStart,LoanEnd) values(?,?,?,?,?,?,?)");
			
			ps.setString(1, loan.getLoanID());
			ps.setString(2, loan.getLoanType());
			ps.setString(3, loan.getLoanAmount());
			ps.setString(4, loan.getIntrest());
			ps.setString(5, loan.getTotalLoan());
			ps.setString(6, loan.getLoanStart());
			ps.setString(7, loan.getLoanEnd());

		
			
			System.out.println("In the service");
			
			result = ps.execute();
			conn.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}

	@Override
	public boolean modifyLoan(Loan loan) {
		// TODO Auto-generated method stub

		boolean result =false;
		
		try {
			Connection conn = db.dbconect.connect();
			ps = conn.prepareStatement("UPDATE loan SET LoanID=?,LoanType=?,LoanAmount=?,Intrest=?,TotalLoan=?,LoanStart=?,LoanEnd=? WHERE LoanID=?");
			
			ps.setString(1, loan.getLoanID());
			ps.setString(2, loan.getLoanType());
			ps.setString(3, loan.getLoanAmount());
			ps.setString(4, loan.getIntrest());
			ps.setString(5, loan.getTotalLoan());
			ps.setString(6, loan.getLoanStart());
			ps.setString(7, loan.getLoanEnd());
			
			
			result = ps.execute();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}

	@Override
	public boolean deleteLoan(Loan loan) {
		// TODO Auto-generated method stub
		boolean result =false;
		
		try {
			Connection conn =db.dbconect.connect();
			ps = conn.prepareStatement("DELETE FROM loans WHERE LoanID=?");
			
			ps.setString(1, loan.getLoanID());
			result = ps.execute();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}


}
