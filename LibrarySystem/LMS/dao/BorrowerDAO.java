package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import domain.Author;
import domain.Borrower;
import domain.Publisher;

public class BorrowerDAO extends BaseDAO<Borrower> {

	public BorrowerDAO(Connection conn) throws Exception {
		super(conn);
		// TODO Auto-generated constructor stub
	}
	
	public void create(Borrower borrower) throws Exception {
		save("insert into tbl_Borrower (cardNo, name, address, phone) values(?, ?, ?, ?)",
				new Object[] { borrower.getCardNo(), borrower.getName(), borrower.getAddress(), borrower.getPhone() });
	}

	public void update(Borrower borrower) throws Exception {
		save(" update tbl_Borrower set cardNo = ?, name =? , address=?, phone=? where cardNo = ?",
				new Object[] { borrower.getCardNo(), borrower.getName(), borrower.getAddress(), borrower.getPhone(), borrower.getCardNo() });

	}

	public void delete(Borrower borrower) throws Exception {
		save("delete from tbl_Borrower where cardNo = ?",
				new Object[] { borrower.getCardNo() });
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
