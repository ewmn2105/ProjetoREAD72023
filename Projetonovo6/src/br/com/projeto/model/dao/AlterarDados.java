package br.com.projeto.model.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.projeto.model.vo.CadastroVO;
import br.com.projeto.model.vo.LembrarSenhaVO;

//Classe responsável pela lógica de atualização dos dados do usuário
public class AlterarDados {
	private String url = "jdbc:mysql://localhost:3306/BD";
	private Connection conexao;
	public boolean alterarSenha (LembrarSenhaVO lembraVO) {
		try{
			conexao = DriverManager.getConnection (url, "root", "root");
			String sql = "UPDATE Usuarios SET nome = ?, senha = ? WHERE email = ?";
			PreparedStatement statement = conexao.prepareStatement(sql);
			statement.setString(1, lembraVO.getNome());
			statement.setString(2, lembraVO.getSenha());
			statement.setString(3, lembraVO.getEmail());
			int retorno = statement.executeUpdate(); 
			return retorno > 0;
	        } catch (SQLException e) {
	            return false;
	        }
	}
	public boolean alterarEmail (LembrarSenhaVO lembraVO) {
		try{
			conexao = DriverManager.getConnection (url, "root", "root");
			String sql = "UPDATE Resumos SET email = ?";
			PreparedStatement statement = conexao.prepareStatement(sql);
			statement.setString(1, lembraVO.getEmail());
			int retorno = statement.executeUpdate(); 
			return retorno > 0;
	        } catch (SQLException e) {
	            return false;
	        }
	}
	public boolean alterarSenha3 (LembrarSenhaVO lembraVO) {
		try{
			conexao = DriverManager.getConnection (url, "root", "root");
			String sql = "UPDATE Usuarios SET nome = ?, senha = ? WHERE email = ?";
			PreparedStatement statement = conexao.prepareStatement(sql);
			statement.setString(1, lembraVO.getNome());
			statement.setString(2, lembraVO.getSenha());
			statement.setString(3, lembraVO.getEmail());
			int retorno = statement.executeUpdate(); 
			return retorno > 0;
	        } catch (SQLException e) {
	            return false;
	        }
	}
}