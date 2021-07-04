package kr.ac.kopo.kopo12.domain;

public class Board {
	private int id;
	private String title;

	public Board() {
		
	}
	
	public Board(int id) {
		this.id = id;
	}
	
	public Board(int id, String title) {
		this.id = id;
		this.title = title;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
