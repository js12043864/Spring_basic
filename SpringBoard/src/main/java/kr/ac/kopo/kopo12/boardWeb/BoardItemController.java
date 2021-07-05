package kr.ac.kopo.kopo12.boardWeb;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.kopo.kopo12.domain.Board;
import kr.ac.kopo.kopo12.domain.BoardItem;
import kr.ac.kopo.kopo12.service.BoardItemService;
import kr.ac.kopo.kopo12.service.BoardService;

@Controller // annotation
public class BoardItemController {

	@Autowired
	private BoardService boardService;

	@Autowired
	private BoardItemService boardItemService;

	@RequestMapping(value = "/PostTable")
	public String postTable(Model model, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
			int boardId = Integer.parseInt(request.getParameter("id"));
			int from = Integer.parseInt(request.getParameter("from"));
			if (from < 1) {
				from = 1;
			}
			model.addAttribute("from", from);
			model.addAttribute("boardId", boardId);

			Board board = boardService.selectOne(boardId);
			String name = board.getTitle();
			model.addAttribute("name", name);

			List<BoardItem> boardItemList = boardItemService.selectAll(boardId);
			model.addAttribute("boardItemList", boardItemList);

			int[] boardNum = boardItemService.number(boardItemList, from);
			int end = boardNum[0];
			int first = boardNum[1];
			model.addAttribute("end", end);
			model.addAttribute("first", first);
			model.addAttribute("boardNum", boardNum);

			int boardItemSize = boardItemList.size();
			model.addAttribute("boardItemSize", boardItemSize);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "PostTable";
	}

	@RequestMapping(value = "/PostInsert")
	public String postInsert(Model model, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
			int boardId = Integer.parseInt(request.getParameter("id"));
			model.addAttribute("boardId", boardId);

			Board board = boardService.selectOne(boardId);
			model.addAttribute("name", board.getTitle());

			model.addAttribute("date", boardItemService.date());
		} catch (Exception e) {

		}
		return "PostInsert";
	}

	@RequestMapping(value = "/PostWrite")
	public String postWrite(Model model, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			if (title.contains("<") || content.contains("<")) {
				title = title.replaceAll("<", "&lt;");
				content = content.replaceAll("<", "&lt;");
			}
			int boardId = Integer.parseInt(request.getParameter("id"));
			BoardItem boardItem = new BoardItem(title, content, boardId);
			boardItemService.create(boardItem);

			List<BoardItem> postNumber = boardItemService.selectAll(boardId);
			int size = postNumber.size();
			int id = postNumber.get(size - 1).getId();
			model.addAttribute("boardId", boardId);
			model.addAttribute("id", id);
		} catch (Exception e) {

		}
		return "PostWrite";
	}

	@RequestMapping(value = "/PostView")
	public String postView(Model model, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
			int boardId = Integer.parseInt(request.getParameter("boardId"));
			int id = Integer.parseInt(request.getParameter("id"));
			model.addAttribute("boardId", boardId);
			model.addAttribute("id", id);
			Board board = boardService.selectOne(boardId);
			model.addAttribute("name", board.getTitle());

			BoardItem boardItem = boardItemService.selectOne(id);
			List<BoardItem> boardItemList = boardItemService.selectAll(boardId);
			int number = 0;
			int startNumber = 0;
			for (BoardItem boardItem2 : boardItemList) {
				if (boardItem2.getId() == id) {
					number = startNumber + 1;
				}
				startNumber++;
			}
			String title = boardItem.getTitle();
			String content = boardItem.getContent();
			String date = boardItem.getDate();
			content = content.replaceAll("\n", "<br>");
			model.addAttribute("number", number - 1);
			model.addAttribute("title", title);
			model.addAttribute("date", date);
			model.addAttribute("content", content);

			List<BoardItem> showComments = boardItem.getComments();
			model.addAttribute("showComments", showComments);
		} catch (Exception e) {
		}
		return "PostView";
	}

	@RequestMapping(value = "/CommentInsert")
	public String commentInsert(Model model, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
			int boardId = Integer.parseInt(request.getParameter("boardId"));
			int id = Integer.parseInt(request.getParameter("id"));
			String comment = request.getParameter("comment");
			if (comment.contains("<")) {
				comment = comment.replaceAll("<", "&lt;");
			}
			comment = comment.replaceAll("\n", "<br>");
			BoardItem boardItem = new BoardItem(comment, id);
			boardItemService.create(boardItem);
			model.addAttribute("boardId", boardId);
			model.addAttribute("id", id);
		} catch (Exception e) {
		}
		return "CommentInsert";
	}

	@RequestMapping(value = "/PostDelete")
	public String postDelete(Model model, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
			int id = Integer.parseInt(request.getParameter("id"));
			int boardId = Integer.parseInt(request.getParameter("boardId"));
			BoardItem boardItem = new BoardItem(id);
			boardItemService.delete(boardItem);
			model.addAttribute("boardId", boardId);
		} catch (Exception e) {
		}
		return "PostDelete";
	}

	@RequestMapping(value = "/CompleteUpdate")
	public String completeUpdate(Model model, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			if (title.contains("<") || content.contains("<")) {
				title = title.replaceAll("<", "&lt;");
				content = content.replaceAll("<", "&lt;");
			}
			int id = Integer.parseInt(request.getParameter("id"));
			int boardId = Integer.parseInt(request.getParameter("boardId"));
			BoardItem boardItem = new BoardItem(id, title, content);
			boardItemService.update(boardItem);
			model.addAttribute("boardId", boardId);
			model.addAttribute("id", id);

		} catch (Exception e) {
		}
		return "CompleteUpdate";
	}

	@RequestMapping(value = "/PostUpdate")
	public String postUpdate(Model model, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
			int id = Integer.parseInt(request.getParameter("id"));
			int boardId = Integer.parseInt(request.getParameter("boardId"));
			model.addAttribute("id", id);
			model.addAttribute("boardId", boardId);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal = Calendar.getInstance();

			Board board = boardService.selectOne(boardId);
			String name = board.getTitle();
			model.addAttribute("name", name);

			BoardItem boardItem = boardItemService.selectOne(id);
			List<BoardItem> boardItemList = boardItemService.selectAll(boardId);
			int size = boardItemList.size();
			int number = 0;
			int startNumber = 0;
			for (BoardItem boardItem2 : boardItemList) {
				if (boardItem2.getId() == id) {
					number = startNumber + 1;
				}
				startNumber++;
			}
			String title = boardItem.getTitle();
			String content = boardItem.getContent();
			String date = sdf.format(cal.getTime());
			model.addAttribute("number", number - 1);
			model.addAttribute("title", title);
			model.addAttribute("date", date);
			model.addAttribute("content", content);

		} catch (Exception e) {
		}
		return "PostUpdate";
	}

	@RequestMapping(value = "/PostSearch")
	public String postSearch(Model model, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
			int boardId = Integer.parseInt(request.getParameter("boardId"));
			model.addAttribute("boardId", boardId);

			Board board = boardService.selectOne(boardId);
			String name = board.getTitle();
			model.addAttribute("name", name);

			String keyWord = request.getParameter("keyWord");
			if (keyWord.contains("<")) {
				keyWord = keyWord.replaceAll("<", "&lt;");
			}
			model.addAttribute("keyWord", keyWord);
			String[] spKeyWord = keyWord.split(" ");
			model.addAttribute("spKeyWord", spKeyWord);
			List<BoardItem> boardItemList = boardItemService.selectAll(boardId);
			model.addAttribute("boardItemList", boardItemList);

			int number = 1;
			for (BoardItem boardItem : boardItemList) {
				HashSet<Integer> hash = new HashSet<Integer>();
				for (String key : spKeyWord) {
					if (boardItem.getContent().contains(key) || boardItem.getTitle().contains(key)) {
						hash.add(boardItem.getId());
					}
				}
				Iterator iterator = hash.iterator();
				model.addAttribute("iterator", iterator);
			}
		} catch (Exception e) {
		}
		return "PostSearch";
	}
}
