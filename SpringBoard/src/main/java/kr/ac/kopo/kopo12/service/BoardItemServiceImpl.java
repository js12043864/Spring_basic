package kr.ac.kopo.kopo12.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.kopo12.dao.BoardItemRepository;
import kr.ac.kopo.kopo12.domain.BoardItem;

@Service
public class BoardItemServiceImpl implements BoardItemService {
	
	@Autowired
	private BoardItemRepository boardItemRepository;
	
	@Override
	public void create(BoardItem boardItem) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		boardItemRepository.create(boardItem);
	}

	@Override
	public void update(BoardItem boardItem) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		boardItemRepository.update(boardItem);
	}

	@Override
	public void delete(BoardItem boardItem) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		boardItemRepository.delete(boardItem);
	}

	@Override
	public List<BoardItem> selectAll(int boardId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return boardItemRepository.selectAll(boardId);
	}

	@Override
	public BoardItem selectOne(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return boardItemRepository.selectOne(id);
	}

	@Override
	public int[] number(List<BoardItem> boardItemList, int from) {
		// TODO Auto-generated method stub
		int totalCnt = boardItemList.size();	//게시글 총 수
		int finPage = totalCnt % 10 == 0 ? totalCnt / 10 : (totalCnt / 10) + 1;	//마지막 페이지
		if( from < 1) {
			from = 1;
		}else if (from > finPage) {
			from = finPage;
		}	//예외처리
		int startNum = from * 10 <= totalCnt ? (from * 10) - 1 : totalCnt - 1;	//시작 번호
		int endNum = (from - 1) * 10;
		int cur_page = 0;
		if( from % 10 == 0) {
			cur_page = from / 10;
		}else {
			cur_page = from / 10 + 1;
		}
		
		int prPage = (cur_page / 10) * 10 + 1;
		if(cur_page % 10 == 0 ) {
			prPage = ((cur_page / 10) - 1) * 10 + 1;
		}
		int[] number = {startNum,endNum,prPage, finPage, from};
		return number;
	}

}
