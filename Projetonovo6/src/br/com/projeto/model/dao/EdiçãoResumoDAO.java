package br.com.projeto.model.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.projeto.view.LembrarSenhaView;

//Classe responsável pela lógica de atualização dos resumos feitos pelo usuário
public class EdiçãoResumoDAO  {
	private String url = "jdbc:mysql://localhost:3306/BD";
	private LembrarSenhaView view;
	private Connection conexao;
	public boolean alterarResumo (String oldTítulo, String título, String oldResumo, String resumo) {
		try{
			conexao = DriverManager.getConnection (url, "root", "root");
			String sql = "UPDATE Resumos SET Título = ?, TextoUsuario = ? WHERE Título LIKE ? AND TextoUsuario LIKE ?";
			PreparedStatement statement = conexao.prepareStatement(sql);
			statement.setString(1, título);
			statement.setString(2, resumo);
			statement.setString(3, oldTítulo);
			statement.setString(4, oldResumo);
			int retorno = statement.executeUpdate(); 
			return retorno > 0;
	        } catch (SQLException e) {
	            return false;
	        }
	}
}