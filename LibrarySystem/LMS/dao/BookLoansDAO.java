package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import domain.Book_loans;

public class BookLoansDAO extends BaseDAO<Book_loans> {

	public BookLoansDAO(Connection conn) throws Exception {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Book_loans> extractData(ResultSet rs) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book_loans> extractDataFirstLevel(ResultSet rs)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
