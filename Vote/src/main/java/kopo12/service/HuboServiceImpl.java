package kopo12.service;

import java.sql.SQLException;
import java.util.List;

import kopo12.dao.HuboDao;
import kopo12.dao.HuboDaoImpl;
import kopo12.domain.Hubo;

public class HuboServiceImpl implements HuboService {

	private HuboDao huboDao = new HuboDaoImpl();
	private static HuboServiceImpl instance = new HuboServiceImpl();
	
	private HuboServiceImpl() {
		
	}
	
	public static HuboServiceImpl getInstance() {
		return instance;
	}
	
	@Override
	public void create(Hubo hubo) throws Exception {
		// TODO Auto-generated method stub
		huboDao.create(hubo);
	}

	@Override
	public Hubo selectOne(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return huboDao.selectOne(id);
	}

	@Override
	public List<Hubo> selectAll() throws Exception {
		// TODO Auto-generated method stub
		return huboDao.selectAll();
	}

	@Override
	public void update(Hubo hubo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Hubo hubo) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		huboDao.delete(hubo);
	}

}
