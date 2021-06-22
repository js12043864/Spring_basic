package kopo12.dao;

import java.sql.SQLException;
import java.util.List;

import kopo12.domain.Hubo;

public interface HuboDao {
	void create(Hubo hubo) throws Exception;
	Hubo selectOne(int id) throws ClassNotFoundException, SQLException;
	List<Hubo> selectAll() throws Exception;
	void update(Hubo hubo);
	void delete(Hubo hubo) throws ClassNotFoundException, SQLException;
}