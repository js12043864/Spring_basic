package kr.ac.kopo.kopo12.dao;

import java.sql.SQLException;
import java.util.List;

import kr.ac.kopo.kopo12.domain.Board;



public interface BoardRepository {
	void create(Board board);	//row�� �ϳ� ����ִ´�(insert)
	Board selectOne(int id) throws SQLException, ClassNotFoundException;
	List<Board> selectAll() throws SQLException, ClassNotFoundException;
	void update(Board board);
	void delete(Board board);
}
