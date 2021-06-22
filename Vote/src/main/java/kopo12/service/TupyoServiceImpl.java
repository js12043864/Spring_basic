package kopo12.service;

import java.sql.SQLException;
import java.util.List;
import kopo12.dao.TupyoDao;
import kopo12.dao.TupyoDaoImpl;
import kopo12.domain.Tupyo;

public class TupyoServiceImpl implements TupyoService {
	
	private TupyoDao tupyoDao = new TupyoDaoImpl();
	
	private static TupyoServiceImpl instance = new TupyoServiceImpl();
	
	private TupyoServiceImpl() {
		
	}
	
	public static TupyoServiceImpl getInstance() {
		return instance;
	}
	
	@Override
	public void create(Tupyo tupyo) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		tupyoDao.create(tupyo);
	}

	@Override
	public Tupyo selectOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tupyo> selectAll(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return tupyoDao.selectAll(id);
	}

	@Override
	public void update(Tupyo tupyo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Tupyo tupyo) {
		// TODO Auto-generated method stub
	}

	@Override
	public List<Tupyo> selectAll() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return tupyoDao.selectAll();
	}

}
