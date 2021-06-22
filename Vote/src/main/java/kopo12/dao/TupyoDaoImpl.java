package kopo12.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kopo12.domain.Hubo;
import kopo12.domain.Tupyo;

public class TupyoDaoImpl implements TupyoDao {
	
//	private static TupyoDaoImpl instance = new TupyoDaoImpl();
//	
//	private TupyoDaoImpl () {
//		
//	}
//	
//	public static TupyoDaoImpl getInstance() {
//		return instance;
//	}
	
	@Override
	public void create(Tupyo tupyo) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.jdbc.Driver");	
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.16:3306/kopoctc", "root", "kopoctc");
		Statement stmt = conn.createStatement();
		stmt.execute("insert into tupyo_table (id, age) values(" + tupyo.getId() + "," + tupyo.getAge() + ");");
		stmt.close();
	}

	@Override
	public Tupyo selectOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Tupyo> selectAll(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.16:3306/kopoctc", "root", "kopoctc");
		Statement stmt = conn.createStatement();
		ResultSet rset = stmt.executeQuery("select * from tupyo_table where id = " + id + ";");
		List<Tupyo> showTupyo = new ArrayList<Tupyo>();
		while (rset.next()) {
			Tupyo tupyo = new Tupyo();
			tupyo.setId(rset.getInt(1));
			tupyo.setAge(rset.getInt(2));
			showTupyo.add(tupyo);
		}
		rset.close();
		stmt.close();
		conn.close();
		return showTupyo;
	}

	@Override
	public void update(Tupyo tupyo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Tupyo tupyo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Tupyo> selectAll() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.16:3306/kopoctc", "root", "kopoctc");
		Statement stmt = conn.createStatement();
		ResultSet rset = stmt.executeQuery("select * from tupyo_table;");
		List<Tupyo> showTupyo = new ArrayList<Tupyo>();
		while (rset.next()) {
			Tupyo tupyo = new Tupyo();
			tupyo.setId(rset.getInt(1));
			tupyo.setAge(rset.getInt(2));
			showTupyo.add(tupyo);
		}
		rset.close();
		stmt.close();
		conn.close();
		return showTupyo;
	}


}
