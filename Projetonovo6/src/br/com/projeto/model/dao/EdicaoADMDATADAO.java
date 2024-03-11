package br.com.projeto.model.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.projeto.model.vo.LembrarSenhaVO;
import br.com.projeto.view.LembrarSenhaView;

//Classe responsável pela lógica de edição dos dados do adm
public class EdicaoADMDATADAO {
	private String url = "jdbc:mysql://localhost:3306/BD";
	private LembrarSenhaView view;
	private Connection conexao;
	public boolean alterarSenha (LembrarSenhaVO lembraVO) {
		try{
			conexao = DriverManager.getConnection (url, "root", "root");
			String sql = "UPDATE ADM SET nome = ?, senha = ? WHERE ID = 1";
			PreparedStatement statement = conexao.prepareStatement(sql);
			statement.setString(1, lembraVO.getNome());
			statement.setString(2, lembraVO.getSenha());
			int retorno = statement.executeUpdate(); 
			return retorno > 0;
	        } catch (SQLException e) {
	            return false;
	        }
	}
}