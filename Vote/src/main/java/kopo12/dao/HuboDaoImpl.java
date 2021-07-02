package kopo12.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kopo12.domain.Hubo;

public class HuboDaoImpl implements HuboDao {

	@Override
	public void create(Hubo hubo) throws Exception {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.103.16:3306/kopoctc", "root", "kopoctc");
		Statement stmt = conn.createStatement();
		ResultSet rset = stmt.executeQuery("select * from hubo_table order by id;");
		int num = 0;
		while (rset.next()) {
			num = rset.getInt(1);
		}
		stmt.execute("insert into hubo_table (id,name) values(" + (num + 1) + ",\"" + hubo.getName() + "\");");
		rset.close();
		stmt.close();
		conn.close();
	}

	@Override
	public Hubo selectOne(int id) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.103:3306/kopoctc", "root", "kopoctc");
		Statement stmt = conn.createStatement();
		ResultSet rset = stmt.executeQuery("select * from hubo_table where id = " + id + ";");
		Hubo hubo = new Hubo();
		while (rset.next()) {
			hubo.setId(rset.getInt(1));
			hubo.setName(rset.getString(2));
		}
		rset.close();
		stmt.close();
		conn.close();
		return hubo;
		// TODO Auto-generated method stub

	}

	@Override
	public List<Hubo> selectAll() throws Exception {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.103:3306/kopoctc", "root", "kopoctc");
		Statement stmt = conn.createStatement();
		ResultSet rset = stmt.executeQuery("select * from hubo_table order by id;");
		List<Hubo> showHubo = new ArrayList<Hubo>();
		
		while (rset.next()) {
			Hubo hubo = new Hubo();
			hubo.setId(rset.getInt(1));
			hubo.setName(rset.getString(2));
			showHubo.add(hubo);
		}
		rset.close();
		stmt.close();
		conn.close();
		
		return showHubo;
	}

	@Override
	public void update(Hubo hubo) {
		// TODO Auto-generated method stub
		hubo.getId();
	}

	@Override
	public void delete(Hubo hubo) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.103:3306/kopoctc", "root", "kopoctc");
		Statement stmt = conn.createStatement();
		stmt.execute("delete from tupyo_table where id = \"" + hubo.getId() + "\";");
		stmt.execute("delete from hubo_table where id = \"" + hubo.getId() + "\";");

		stmt.close();
		conn.close();
	}

}
