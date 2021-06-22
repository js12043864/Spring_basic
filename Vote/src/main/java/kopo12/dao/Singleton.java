package kopo12.dao;

public class Singleton {
	private static Singleton instance = new Singleton();
	
	private Singleton() {		//private으로 생성자 생성
		
	}
	
	public static Singleton getInstance() {	//호출 
			return instance;
	}
}
