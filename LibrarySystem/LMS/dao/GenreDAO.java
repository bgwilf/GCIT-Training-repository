package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import domain.Genre;

public class GenreDAO extends BaseDAO<Genre> {

	public GenreDAO(Connection conn) throws Exception {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Genre> extractData(ResultSet rs) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Genre> extractDataFirstLevel(ResultSet rs) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
