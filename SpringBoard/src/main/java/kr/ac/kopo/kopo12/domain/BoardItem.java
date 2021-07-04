package kr.ac.kopo.kopo12.domain;

import java.util.List;

public class BoardItem {
	private int id;	
	private String title;	
	private String date;	
	private String content;		
	private int boardId;	
	private int parentId;
	private List<BoardItem> comments;
	
	public List<BoardItem> getComments() {
		return comments;
	}

	public void setComments(List<BoardItem> comments) {
		this.comments = comments;
	}

	public BoardItem() {
		
	}
	
	public BoardItem(int id) {
		this.id = id;
	}
	
	public BoardItem(String title, String content, int boardId) {
		this.title = title;
		this.content = content;
		this.boardId = boardId;
	}
	
	public BoardItem(String content, int parentId) {
		this.content = content;
		this.parentId = parentId;
	}
	
	
	public BoardItem(int id, String title, String content) {
		this.title = title;
		this.content = content;
		this.id = id;
	}
	
	public BoardItem(String title, String content, int boardId, int parentId) {
		this.title = title;
		this.content = content;
		this.boardId = boardId;
		this.parentId = parentId;
		
	}
	
	public int getParentId() {
		return parentId;
	}
	
	public void setParentId(int parentId) {
		this.parentId = parentId;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	
}
