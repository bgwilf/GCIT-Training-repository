package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import domain.Author;
import domain.Library_branch;
import domain.Publisher;

public class Library_branchDAO extends BaseDAO<Library_branch> {

	public Library_branchDAO(Connection conn) throws Exception {
		super(conn);
		// TODO Auto-generated constructor stub
	}
	
	public void create(Library_branch branches) throws Exception {
		save("insert into tbl_Library_branch (branchId, branchName, branchAddress) values(?, ?, ?)",
				new Object[] { branches.getBranchId(), branches.getBranchName(), branches.getBranchAddress() });
	}

	public void update(Library_branch branches) throws Exception {
		save("update tbl_Library_branch set branchName = ?, branchAddress=? where branchId = ?",
				new Object[] { branches.getBranchName(), branches.getBranchAddress(), branches.getBranchId() });

	}

	public void delete(Library_branch branches) throws Exception {
		save("delete from tbl_Library_branch where branchId = ?",
				new Object[] {branches.getBranchId()});
	}


	@Override
	public List<Library_branch> extractData(ResultSet rs) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Library_branch> extractDataFirstLevel(ResultSet rs)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
