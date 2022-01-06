package bll;

import java.util.List;

import bo.Entrepot;
import dal.EntrepotDAO;

public class EntrepotManager {
	
	private EntrepotDAO dao;
	
	public EntrepotManager() {
		dao = new EntrepotDAO();
	}
	
	public List<Entrepot> selectAll(){
		return EntrepotDAO.selectAll();
	}
	
	public void insertEntrepot(Entrepot entrepot){
		EntrepotDAO.insert(entrepot);
	}
	
	public Entrepot selectById(int id){
		return EntrepotDAO.selectById(id);
	}

}
