package kopo12.service;

import java.sql.SQLException;
import java.util.List;

import kopo12.dao.BoardDao;
import kopo12.dao.BoardDaoImpl;
import kopo12.domain.Board;

public class BoardServiceImpl implements BoardService {
	
	private BoardDao boardDao = BoardDaoImpl.getInstance();
	private static BoardServiceImpl instance = new BoardServiceImpl();
	
	private BoardServiceImpl() {	//constructor for sigleton
		
	}
	
	public static BoardServiceImpl getInstance() {		//singleton method
		return instance;
	}
	
	@Override
	public void create(Board board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Board selectOne(int id) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return boardDao.selectOne(id);
	}

	@Override
	public List<Board> selectAll() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return boardDao.selectAll();
	}

	@Override
	public void update(Board board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Board board) {
		// TODO Auto-generated method stub
		
	}

}
