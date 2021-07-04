package kr.ac.kopo.kopo12.service;

import java.sql.SQLException;
import java.util.List;

import kr.ac.kopo.kopo12.domain.BoardItem;

public interface BoardItemService {
	void create(BoardItem boardItem) throws ClassNotFoundException, SQLException;
	void update(BoardItem boardItem) throws ClassNotFoundException, SQLException;
	void delete(BoardItem boardItem) throws ClassNotFoundException, SQLException;
	List<BoardItem> selectAll(int boardId) throws ClassNotFoundException, SQLException;
	BoardItem selectOne(int id) throws ClassNotFoundException, SQLException;
	int[] number(List<BoardItem> boardItemList, int from);
}
