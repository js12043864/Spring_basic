package kr.ac.kopo.kopo12.repository;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import kr.ac.kopo.kopo12.dao.BoardItemRepository;
import kr.ac.kopo.kopo12.dao.BoardRepository;
import kr.ac.kopo.kopo12.domain.Board;
import kr.ac.kopo.kopo12.domain.BoardItem;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardRepositoryTest {

	@Autowired
	private BoardRepository boardRepository;

	@Autowired
	private BoardItemRepository boardItemRepository;

	@Test
	void create() {
		Board board1 = new Board();
		board1.setTitle("hello");

		BoardItem boardItem1 = new BoardItem();
		boardItem1.setTitle("title1");
		boardItem1.setBoard(board1);

		BoardItem boardItem2 = new BoardItem();
		boardItem2.setTitle("title2");
		boardItem2.setBoard(board1);

		List<BoardItem> list = new ArrayList<>();
		list.add(boardItem1);
		list.add(boardItem2);

		board1.setBoardItem(list);
		boardRepository.save(board1);
	}

	@Test
	void selectAll() {
		List<Board> boards = boardRepository.findAll();
		for (Board board : boards) {
			System.out.println(board.getTitle());
		}
	}

	@Test
	void selectOne() {
		Board board = boardRepository.findById(1);
		System.out.println(board.getId() + " " + board.getTitle());
	}

//	@Test
//	void deleteOne() {
//		boardRepository.deleteById(7);
//		List<Board> boards = boardRepository.findAll();
//		for(Board board : boards) {
//			System.out.println(board.getTitle());
//		}
//	}

	@Test
	void selectAll1() {
		List<BoardItem> boardItems = boardItemRepository.findAll();
		for (BoardItem boardItem : boardItems) {
			System.out.println(boardItem.getTitle() + " " + boardItem.getDate());
		}
	}

	@Test
	void selectAll2() {
		List<BoardItem> boardItems = boardItemRepository.findAllByBoardId(1);
		for (BoardItem boardItem : boardItems) {
			System.out.println(boardItem.getTitle() + " " + boardItem.getDate());
		}
	}
}
