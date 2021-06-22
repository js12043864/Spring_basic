package kopo12.dao;

import java.sql.SQLException;
import java.util.List;

import kopo12.domain.Board;

public interface BoardDao {
	void create(Board board);	//row를 하나 집어넣는다(insert)
	Board selectOne(int id) throws SQLException, ClassNotFoundException;
	List<Board> selectAll() throws SQLException, ClassNotFoundException;
	void update(Board board);
	void delete(Board board);
}
