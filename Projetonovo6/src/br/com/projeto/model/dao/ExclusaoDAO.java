package br.com.projeto.model.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.projeto.model.vo.GerenciamentodeContaVO;

//CLasse responsável pela exclusão de dados de um usuário
public class ExclusaoDAO {
	private String url = "jdbc:mysql://localhost:3306/BD";
	public boolean removeConta (GerenciamentodeContaVO removeLogin) {
		try {
			Connection conexao = DriverManager.getConnection (url, "root", "root");
			String sql = "DELETE FROM Usuarios WHERE email = ?";
			PreparedStatement statement = conexao.prepareStatement(sql);
			statement.setString(1, removeLogin.getEmail());
			int rowsAffected = statement.executeUpdate();
	            return rowsAffected > 0;
	        } catch (SQLException e) {
	            return false;
	        }
	}
	public boolean removeResumos (GerenciamentodeContaVO removeLogin) {
		try {
			Connection conexao = DriverManager.getConnection (url, "root", "root");
			String sql = "DELETE FROM Resumos WHERE emailAutor = ?";
			PreparedStatement statement = conexao.prepareStatement(sql);
			statement.setString(1, removeLogin.getEmail());
			int rowsAffected = statement.executeUpdate();
	            return rowsAffected > 0;
	        } catch (SQLException e) {
	            return false;
	        }
	}
}
