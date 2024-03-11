package br.com.projeto.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//Classe responsável pelas estatísticas do software
public class EstastísticasDAO {
	public int Estatisticas() { // Quantidade de usuários cadastrados
		int count = 0;
		try {
			Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/BD", "root", "root");
			String sql = "SELECT COUNT(nome)FROM Usuarios"; 
			PreparedStatement statement = conexao.prepareStatement(sql);
			ResultSet resultado = statement.executeQuery();
			if (resultado.next()) {
				count = resultado.getInt(1);
			}
		} catch (SQLException slcte) {
		}
		return count;
	}
	public int EstatisticasResumos() { // Quantidade de resumos feitos
		int count = 0;
		try {
			Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/BD", "root", "root");
			String sql = "SELECT COUNT(título)FROM Resumos";
			PreparedStatement statement = conexao.prepareStatement(sql);
			ResultSet resultado = statement.executeQuery();
			if (resultado.next()) {
				count = resultado.getInt(1);
			}
		} catch (SQLException slcte) {
		}
		return count;
	}

}
