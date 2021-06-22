package kopo12.dao;

import java.sql.SQLException;
import java.util.List;

import kopo12.domain.Tupyo;


public interface TupyoDao {
	void create(Tupyo tupyo) throws ClassNotFoundException, SQLException;	
	Tupyo selectOne(int id);
	List<Tupyo> selectAll(int id) throws ClassNotFoundException, SQLException;
	List<Tupyo> selectAll() throws ClassNotFoundException, SQLException;
	void update(Tupyo tupyo);
	void delete(Tupyo tupyo);
	
}
