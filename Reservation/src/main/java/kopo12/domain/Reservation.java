package kopo12.domain;

public class Reservation {
	private String name;
	private String resv_date;
	private int room;
	private String addr;
	private String telnum;
	private String in_name;
	private String comment;
	private String write_date;
	private int processing;
	
	public Reservation() {
		
	}
	
	public Reservation(String resv_date, int room) {
		this.resv_date = resv_date;
		this.room = room;
	}
	
	public Reservation(String resv_date, int room, String addr, String telnum, String in_name, String comment) {
		this.resv_date = resv_date;
		this.room = room;
		this.addr = addr;
		this.telnum = telnum;
		this.in_name = in_name;
		this.comment = comment;
	}
	
	
	public Reservation(String name, String resv_date, int room, String addr, String telnum, String in_name,
			String comment, int processing) {
		super();
		this.name = name;
		this.resv_date = resv_date;
		this.room = room;
		this.addr = addr;
		this.telnum = telnum;
		this.in_name = in_name;
		this.comment = comment;
		this.processing = processing;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getResv_date() {
		return resv_date;
	}
	public void setResv_date(String resv_date) {
		this.resv_date = resv_date;
	}
	public int getRoom() {
		return room;
	}
	public void setRoom(int room) {
		this.room = room;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTelnum() {
		return telnum;
	}
	public void setTelnum(String telnum) {
		this.telnum = telnum;
	}
	public String getIn_name() {
		return in_name;
	}
	public void setIn_name(String in_name) {
		this.in_name = in_name;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getWrite_date() {
		return write_date;
	}
	public void setWrite_date(String write_date) {
		this.write_date = write_date;
	}
	public int getProcessing() {
		return processing;
	}
	public void setProcessing(int processing) {
		this.processing = processing;
	}
}
