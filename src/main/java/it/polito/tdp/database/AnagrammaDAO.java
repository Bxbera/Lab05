package it.polito.tdp.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AnagrammaDAO {
	
	public boolean isCorrect(String anagramma) {
		String sql = "SELECT * "
				+ "FROM parola "
				+ "WHERE nome = ? ";
		
		try {
			boolean find = false;
			Connection conn = ConnectDB.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, anagramma);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				find = true;
			}
			
			rs.close();
			ps.close();
			conn.close();
			
			return find;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
