package kr.ac.kopo.kopo12.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kr.ac.kopo.kopo12.domain.BoardItem;

@Repository
public class BoardItemRepositoryImpl implements BoardItemRepository {

	@Override
	public void create(BoardItem boardItem) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.16:3306/kopoctc", "root", "kopoctc");
		Statement stmt = conn.createStatement();
		if(boardItem.getTitle() != null) {	//게시글 작성
			stmt.execute("insert into boardItem (title, date, content, boardId) values(\"" + boardItem.getTitle() + "\", now(),\""
				+ boardItem.getContent() + "\", " + boardItem.getBoardId() + ");");
		}else {	//댓글 작성
			stmt.execute("insert into boardItem (date, content, parentId) values(now(), \"" + boardItem.getContent() + "\", " + boardItem.getParentId() + ");");
		}
		stmt.close();
		conn.close();
	}

	@Override
	public void update(BoardItem boardItem) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.16:3306/kopoctc", "root", "kopoctc");
		Statement stmt = conn.createStatement();
		stmt.execute("update boardItem Set title = \"" + boardItem.getTitle() + "\",content = \"" + boardItem.getContent()
				+ "\", date= now() where id = " + boardItem.getId() + ";");
		stmt.close();
		conn.close();
	}

	@Override
	public void delete(BoardItem boardItem) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.16:3306/kopoctc", "root", "kopoctc");
		Statement stmt = conn.createStatement();
		stmt.execute("delete from boardItem where id=" + boardItem.getId() + ";");
		stmt.close();
		conn.close();
	}

	@Override
	public List<BoardItem> selectAll(int boardId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.16:3306/kopoctc", "root", "kopoctc");
		Statement stmt = conn.createStatement();
		ResultSet rset = stmt.executeQuery("select * from boardItem where boardId = " + boardId + ";");
		List<BoardItem> showBoardItem = new ArrayList<BoardItem>();
		while (rset.next()) {
			if(rset.getString(2) == null) {
				BoardItem boardItem = new BoardItem();
				boardItem.setId(rset.getInt(1));
				boardItem.setDate(rset.getString(3));
				boardItem.setContent(rset.getString(4));
				boardItem.setParentId(rset.getInt(6));
				showBoardItem.add(boardItem);
			}else {
				BoardItem boardItem = new BoardItem();
				boardItem.setId(rset.getInt(1));
				boardItem.setTitle(rset.getString(2));
				boardItem.setDate(rset.getString(3));
				boardItem.setContent(rset.getString(4));
				boardItem.setBoardId(rset.getInt(5));
				showBoardItem.add(boardItem);
			}
		}
		rset.close();
		stmt.close();
		conn.close();
		return showBoardItem;
	}

	@Override
	public BoardItem selectOne(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.16:3306/kopoctc", "root", "kopoctc");
		Statement stmt = conn.createStatement();
		ResultSet rset = stmt.executeQuery("select * from boardItem where id =" + id + " or parentId = " + id + ";");
		BoardItem boardItem = new BoardItem();
		List<BoardItem> commentList = new ArrayList<BoardItem>();
		while (rset.next()) {
			if(rset.getString(2) != null) {
				boardItem.setTitle(rset.getString(2));
				boardItem.setDate(rset.getString(3));
				boardItem.setContent(rset.getString(4));
				boardItem.setBoardId(rset.getInt(5));
			}
			if(rset.getString(2) == null) {
				BoardItem Comment = new BoardItem();
				Comment.setDate(rset.getString(3));
				Comment.setContent(rset.getString(4));
				commentList.add(Comment);
			}
			boardItem.setComments(commentList);
		}
		rset.close();
		stmt.close();
		conn.close();
		return boardItem;
	}

}
