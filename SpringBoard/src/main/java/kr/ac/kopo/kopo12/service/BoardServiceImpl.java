package kr.ac.kopo.kopo12.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.kopo12.dao.BoardRepository;
import kr.ac.kopo.kopo12.domain.Board;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardRepository boardRepository;
	
	@Override
	public void create(Board board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Board selectOne(int id) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return boardRepository.selectOne(id);
	}

	@Override
	public List<Board> selectAll() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return boardRepository.selectAll();
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
