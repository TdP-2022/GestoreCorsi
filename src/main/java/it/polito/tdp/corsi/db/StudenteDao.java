package it.polito.tdp.corsi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.corsi.model.Divisione;
import it.polito.tdp.corsi.model.Studente;

public class StudenteDao {

	public List<Studente> getStudentiByCorso(String codins) {
		String sql = "select s.matricola, s.cognome, s.nome, s.CDS "
				+ "from studente s, iscrizione i "
				+ "where s.matricola = i.matricola AND i.codins = ?";
		List<Studente> result = new ArrayList<Studente>();
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, codins);
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				result.add(new Studente(rs.getInt("matricola"),
						rs.getString("cognome"), rs.getString("nome"),
						rs.getString("CDS")));
			}
			
			rs.close();
			st.close();
			conn.close();
			
			return result;
		} catch(SQLException e) {
			System.err.println("Errore nel DAO");
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Divisione> getDivisioneStudenti(String codins){
		String sql = "select s.CDS, COUNT(*) as n "
				+ "from studente s, iscrizione i "
				+ "where s.matricola = i.matricola AND i.codins = ? AND s.cds <> '' "
				+ "group by s.CDS";
		List<Divisione> result = new ArrayList<Divisione>();
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, codins);
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				result.add(new Divisione(rs.getString("CDS"),
						rs.getInt("n")));
			}
			
			rs.close();
			st.close();
			conn.close();
			
			return result;
		} catch(SQLException e) {
			System.err.println("Errore nel DAO");
			e.printStackTrace();
			return null;
		}
	}
}
