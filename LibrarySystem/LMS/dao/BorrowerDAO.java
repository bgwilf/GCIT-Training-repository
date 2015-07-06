package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import domain.Borrower;

public class BorrowerDAO extends BaseDAO<Borrower> {

	public BorrowerDAO(Connection conn) throws Exception {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Borrower> extractData(ResultSet rs) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Borrower> extractDataFirstLevel(ResultSet rs) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
