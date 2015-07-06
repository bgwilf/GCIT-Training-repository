package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import domain.Library_branch;

public class Library_branchDAO extends BaseDAO<Library_branch> {

	public Library_branchDAO(Connection conn) throws Exception {
		super(conn);
		// TODO Auto-generated constructor stub
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
