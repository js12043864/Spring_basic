package kr.ac.kopo.kopo12.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kr.ac.kopo.kopo12.domain.Board;

@Repository
public class BoardRepositoryImpl implements BoardRepository {

	@Override
	public void create(Board board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Board selectOne(int id) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.103:3306/kopoctc", "root", "kopoctc");
		Statement stmt = conn.createStatement();
		ResultSet rset = stmt.executeQuery("select * from board where id = " + id + ";");
		Board board = new Board();
		while (rset.next()) {
			board.setId(rset.getInt(1));
			board.setTitle(rset.getString(2));
		}
		return board;
	}

	@Override
	public List<Board> selectAll() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.103:3306/kopoctc", "root", "kopoctc");
		Statement stmt = conn.createStatement();
		ResultSet rset = stmt.executeQuery("select * from board order by id;");
		List<Board> showBoard = new ArrayList<Board>();
		while (rset.next()) {
			Board board = new Board();
			board.setId(rset.getInt(1));
			board.setTitle(rset.getString(2));
			showBoard.add(board);
		}
		rset.close();
		stmt.close();
		conn.close();
		return showBoard;
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
