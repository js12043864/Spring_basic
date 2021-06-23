package kopo12.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import kopo12.dao.ReservDao;
import kopo12.dao.ReservDaoImpl;
import kopo12.domain.Reservation;

public class ReservServiceImpl implements ReservService {

	private static ReservDao reservationDao = ReservDaoImpl.getInstance();
	
	private static ReservServiceImpl instance = new ReservServiceImpl();		//for singleton
	
	private ReservServiceImpl() {	//constructor for sigleton
		
	}
	
	public static ReservServiceImpl getInstance() {		//singleton method
	
		return instance;
	}
	
	@Override
	public void create(Reservation reservation) {
		// TODO Auto-generated method stub
		reservationDao.create(reservation);
	}

	@Override
	public Reservation selectOne(String resv_date, int room) {
		// TODO Auto-generated method stub
		return reservationDao.selectOne(resv_date, room);
	}

	@Override
	public List<Reservation> selectAll(String resv_date, int room) {
		// TODO Auto-generated method stub
		return reservationDao.selectAll(resv_date, room);
	}

	@Override
	public void update(Reservation reservation) {
		// TODO Auto-generated method stub
		reservationDao.update(reservation);
	}

	@Override
	public void delete(Reservation reservation) {
		// TODO Auto-generated method stub
		reservationDao.delete(reservation);
	}

	@Override
	public String roomName(int room) {
		// TODO Auto-generated method stub
		String roomName = "";
		if(room == 1){
			roomName = "Standard";
		}else if(room == 2){
			roomName = "Superior";
		}else {
			roomName = "Deluxe";
		}
		return roomName;
	}

	@Override
	public List<List<String>> showList(String date, String selectedDate) {
		// TODO Auto-generated method stub
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		List<List<String>> List = new ArrayList<List<String>>();
		if(date.equals(selectedDate) == false){
			String[] day = selectedDate.split("-");
			cal.set(Integer.parseInt(day[0]),Integer.parseInt(day[1])-1,1);
		}
		int lastDay = cal.getActualMaximum(5);
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		for(int i = cal.get(cal.DATE); i <= lastDay; i++){
			List<String> OneLine = new ArrayList<String>();
			date = sdf.format(cal.getTime());
			OneLine.add(date);
			for(int room = 1; room < 4; room++){
					OneLine.add(Integer.toString(room));
				Reservation reservation = instance.selectOne(date, room);
				if(reservation.getName() == null){
					OneLine.add("예약가능");	
				}else{
					OneLine.add(reservation.getName());
				}
			}
			List.add(OneLine);
			cal.add(cal.DATE,+1);
		}
		
		return List;
	}
	
	

}
