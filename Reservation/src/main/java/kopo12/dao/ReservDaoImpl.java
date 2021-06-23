package kopo12.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import kopo12.domain.Reservation;

public class ReservDaoImpl implements ReservDao{
	
	private static ReservDaoImpl instance = new ReservDaoImpl();		//for singleton
	
	private ReservDaoImpl() {	//constructor for sigleton
		
	}
	
	public static ReservDaoImpl getInstance() {		//singleton method
		return instance;
	}

	@Override
	public void create(Reservation reservation) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.16:3306/kopoctc", "root", "kopoctc");
			Statement stmt = conn.createStatement();
			stmt.execute("insert into reservation values(\"" + reservation.getName() + "\",\"" + reservation.getResv_date() + "\", " 
					+ reservation.getRoom() + ",\"" + reservation.getAddr() + "\", \"" + reservation.getTelnum() + "\", \"" + reservation.getIn_name()
					+ "\",\"" + reservation.getComment() + "\", now(), " + reservation.getProcessing() + ");");
			stmt.close();
			conn.close();
			}catch(Exception e){
				
			}
	}

	@Override
	public Reservation selectOne(String resv_date, int room) {
		// TODO Auto-generated method stub
		Reservation reservation = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.16:3306/kopoctc", "root", "kopoctc");
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery("select * from reservation where resv_date = \"" + resv_date + "\" and room = " + room + ";");
			reservation = new Reservation();
			while (rset.next()) {
				reservation.setName(rset.getString(1));
				reservation.setResv_date(rset.getString(2));
				reservation.setRoom(rset.getInt(3));
				reservation.setAddr(rset.getString(4));
				reservation.setTelnum(rset.getString(5));
				reservation.setIn_name(rset.getString(6));
				reservation.setComment(rset.getString(7));
				reservation.setWrite_date(rset.getString(8));
				reservation.setProcessing(rset.getInt(9));
			}
			rset.close();
			stmt.close();
			conn.close();
			}catch(Exception e){
				
			}
		return reservation;
	}

	@Override
	public List<Reservation> selectAll(String resv_date, int room) {
		// TODO Auto-generated method stub
		List<Reservation> showReserv = null;
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.16:3306/kopoctc", "root", "kopoctc");
		Statement stmt = conn.createStatement();
		ResultSet rset = stmt.executeQuery("select * from reservation where resv_date = \"" + resv_date + "\" and room = " + room + ";");
		showReserv = new ArrayList<Reservation>();
		while (rset.next()) {
			Reservation reservation = new Reservation();
			reservation.setName(rset.getString(1));
			reservation.setResv_date(rset.getString(2));
			reservation.setRoom(rset.getInt(3));
			reservation.setAddr(rset.getString(4));
			reservation.setTelnum(rset.getString(5));
			reservation.setIn_name(rset.getString(6));
			reservation.setComment(rset.getString(7));
			reservation.setWrite_date(rset.getString(8));
			showReserv.add(reservation);
		}
		rset.close();
		stmt.close();
		conn.close();
		}catch(Exception e){
			
		}
		return showReserv;
	}

	@Override
	public void update(Reservation reservation) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.16:3306/kopoctc", "root", "kopoctc");
			Statement stmt = conn.createStatement();
			stmt.execute("update reservation Set addr=\"" + reservation.getAddr() + "\", telnum=\"" + reservation.getTelnum() + "\", in_name=\"" + reservation.getIn_name() 
					+ "\", comment=\"" + reservation.getComment() + "\", write_date=now() where resv_date = \"" + reservation.getResv_date() + "\" and room = " + reservation.getRoom() + ";");
			stmt.close();
			conn.close();
			}catch(Exception e){
				
			}
	}

	@Override
	public void delete(Reservation reservation) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.16:3306/kopoctc", "root", "kopoctc");
			Statement stmt = conn.createStatement();
			stmt.execute("delete from reservation where resv_date = \"" + reservation.getResv_date() + "\" and room = " + reservation.getRoom() + ";");
			stmt.close();
			conn.close();
			}catch(Exception e){
				
			}
	}

}
