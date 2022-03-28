package it.polito.tdp.corsi.model;

public class Divisione implements Comparable<Divisione>{
	private String CDS;
	private Integer n;
	
	public Divisione(String cDS, Integer n) {
		super();
		CDS = cDS;
		this.n = n;
	}

	public String getCDS() {
		return CDS;
	}

	public void setCDS(String cDS) {
		CDS = cDS;
	}

	public Integer getN() {
		return n;
	}

	public void setN(Integer n) {
		this.n = n;
	}

	@Override
	public int compareTo(Divisione o) {
		return (-1) * o.getCDS().compareTo(this.CDS);
	}
	
	
	
	
}
