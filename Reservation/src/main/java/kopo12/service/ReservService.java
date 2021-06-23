package kopo12.service;

import java.util.List;

import kopo12.domain.Reservation;

public interface ReservService {
	void create(Reservation reservation);
	Reservation selectOne(String resv_date, int room);
	List<Reservation> selectAll(String resv_date, int room);
	void update(Reservation reservation);
	void delete(Reservation reservation);
	String roomName(int room);
	List<List<String>> showList(String date, String selectedDate);
}
