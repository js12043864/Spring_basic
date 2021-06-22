package kopo12.dao;

import java.sql.SQLException;
import java.util.List;

import kopo12.domain.BoardItem;

public interface BoardItemDao {
	void create(BoardItem boardItem) throws ClassNotFoundException, SQLException;
	void update(BoardItem boardItem) throws ClassNotFoundException, SQLException;
	void delete(BoardItem boardItem) throws ClassNotFoundException, SQLException;
	List<BoardItem> selectAll(int boardId) throws ClassNotFoundException, SQLException;
	BoardItem selectOne(int id) throws ClassNotFoundException, SQLException;
}
