package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import domain.Book_loans;
import domain.Library_branch;

public class BookLoansDAO extends BaseDAO<Book_loans> {

	public BookLoansDAO(Connection conn) throws Exception {
		super(conn);
		// TODO Auto-generated constructor stub
	}
	
	public void over_RideDueDate(Book_loans loan) throws Exception {
		save("update tbl_book_loans set dueDate=? where  bookId = ?",
				new Object[] {loan.getDueDate(), loan.getBookId() });
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
