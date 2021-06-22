package kopo12.domain;

import java.util.List;

public class Hubo {
	private int id;
	private String name;
	//private List<Tupyo> tupyos;	
	
	public Hubo() {
		
	}
	
	public Hubo(String name) {
		this.name = name;
	}
	
	public Hubo(int id) {
		this.id = id;
	}
	
	public Hubo(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
