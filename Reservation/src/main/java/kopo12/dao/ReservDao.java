package kopo12.dao;

import java.sql.SQLException;
import java.util.List;

import kopo12.domain.Reservation;

public interface ReservDao {
	void create(Reservation reservation);
	Reservation selectOne(String resv_date, int room);
	List<Reservation> selectAll(String resv_date, int room);
	void update(Reservation reservation);
	void delete(Reservation reservation);
}
