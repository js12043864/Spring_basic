package kopo12.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kopo12.dao.BoardItemDao;
import kopo12.dao.BoardItemDaoImpl;
import kopo12.domain.BoardItem;

public class BoardItemServiceImpl implements BoardItemService{
	
	private BoardItemDao boardItemDao = BoardItemDaoImpl.getInstance();
	
	private static BoardItemServiceImpl instance = new BoardItemServiceImpl();
	
	private BoardItemServiceImpl() {
		
	}
	
	public static BoardItemServiceImpl getInstance() {
		return instance;
	}
	
	@Override
	public void create(BoardItem boardItem) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		boardItemDao.create(boardItem);
	}

	@Override
	public void update(BoardItem boardItem) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		boardItemDao.update(boardItem);
	}

	@Override
	public void delete(BoardItem boardItem) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		boardItemDao.delete(boardItem);
	}

	@Override
	public BoardItem selectOne(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return boardItemDao.selectOne(id);
	}

	@Override
	public List<BoardItem> selectAll(int boardId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return boardItemDao.selectAll(boardId);
	}

}
