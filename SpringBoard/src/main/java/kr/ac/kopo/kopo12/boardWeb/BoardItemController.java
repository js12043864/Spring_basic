package kr.ac.kopo.kopo12.boardWeb;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.ac.kopo.kopo12.domain.Board;
import kr.ac.kopo.kopo12.domain.BoardItem;
import kr.ac.kopo.kopo12.service.BoardItemService;
import kr.ac.kopo.kopo12.service.BoardService;

@Controller	//annotation
public class BoardItemController {
	
	@Autowired
	private BoardService boardService;	

	@Autowired
	private BoardItemService boardItemService;

	
	@RequestMapping(value = "/PostTable", method=RequestMethod.GET)
	public String main(Model model, HttpServletRequest request) throws UnsupportedEncodingException, ClassNotFoundException, SQLException {
		request.setCharacterEncoding("utf-8");
		int boardId = Integer.parseInt(request.getParameter("id"));
		int from = Integer.parseInt(request.getParameter("from"));
		model.addAttribute("from", from);
		model.addAttribute("boardId", boardId);
		
		Board board = boardService.selectOne(boardId);
		String name = board.getTitle();
		model.addAttribute("name", name);
		
		List<BoardItem> boardItemList = boardItemService.selectAll(boardId);
		model.addAttribute("boardItemList", boardItemList);
		
		int[] boardNum = boardItemService.number(boardItemList, from);
		int boardItemSize = boardItemList.size();
		model.addAttribute("boardNum", boardNum);
		model.addAttribute("boardItemSize", boardItemSize);
		
		return "PostTable";
	}
}
