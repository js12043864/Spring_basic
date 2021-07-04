package kr.ac.kopo.kopo12.service;

import java.sql.SQLException;
import java.util.List;

import kr.ac.kopo.kopo12.domain.Board;


public interface BoardService {
	void create(Board board);
	Board selectOne(int id) throws SQLException, ClassNotFoundException;
	List<Board> selectAll() throws SQLException, ClassNotFoundException;
	void update(Board board);
	void delete(Board board);
}
