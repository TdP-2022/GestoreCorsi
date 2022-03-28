package it.polito.tdp.corsi.model;

import java.util.List;

import it.polito.tdp.corsi.db.CorsoDao;

public class Model {
	
	private CorsoDao corsoDao;
	
	public Model() {
		this.corsoDao = new CorsoDao();
	}
	
	public List<Corso> getCorsiByPeriodo(int periodo){
		return this.corsoDao.getCorsiByPeriodo(periodo);
	}
	
	
}
