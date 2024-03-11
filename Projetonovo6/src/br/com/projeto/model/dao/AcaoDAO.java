package br.com.projeto.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.projeto.model.vo.ResumosVO;

//Classe responsável pela lógica de inserção dos resumos do gênero ação no banco de dados
public class AcaoDAO {
	private Connection conexao;
	private String url = "jdbc:mysql://localhost:3306/BD";	
	public boolean InserirAcao(ResumosVO inserirAcao) {
		try {
			Connection conexao = DriverManager.getConnection (url, "root", "root");
			String sql = "INSERT INTO Resumos(emailAutor, Título, TextoUsuario, Classificação_resumo) VALUES (?, ?, ?, ?)";
			PreparedStatement statement = conexao.prepareStatement(sql);
			statement.setString(1, inserirAcao.getAutor());
			statement.setString(2, inserirAcao.getTitulo());
			statement.setString(3, inserirAcao.getTexto());
			statement.setString(4, inserirAcao.getClassificao());
			int rowsAffected = statement.executeUpdate();
	            return rowsAffected > 0;
	        } catch (SQLException e) {
	            return false;
	        }
	}
}

