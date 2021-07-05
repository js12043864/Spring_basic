package kr.ac.kopo.kopo12.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Sample {
	
	@Id		//해당필드는 pk
	@GeneratedValue	//autoincrement하겠다 
	@Column	//데이터베이스의 컬럼으로 취급
	private Long id;
	
	@Column
	private String title;

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
