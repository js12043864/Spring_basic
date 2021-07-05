package kr.ac.kopo.kopo12.boardWeb;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.kopo.kopo12.domain.Board;
import kr.ac.kopo.kopo12.service.BoardService;

@Controller	//annotation
public class BoardController {
	//컨트롤러 - > 요청이 들어오면 데이터 준비해서 /web-inf/views/hello.jsp에 연결
	
//	private BoardService boardService = new BoardServiceImpl(); //이렇게 쓰면 스프링이 만든 객체가 아님
	
	@Autowired
	private BoardService boardService;	//new로 할필요없다 . autowired하면 된다-> DI(의존성) for 느슨하게하기위해

	
	@RequestMapping(value = "/boardSelect")
	public String boardSelect(Model model) throws ClassNotFoundException, SQLException {
		List<Board> boardList = boardService.selectAll();
		model.addAttribute("boardList", boardService.selectAll());
//		model.addAttribute("name", "홍길동");	//key , value
		return "boardSelect";	//이것으로 대응하겠다. [1]
	}
	

}
