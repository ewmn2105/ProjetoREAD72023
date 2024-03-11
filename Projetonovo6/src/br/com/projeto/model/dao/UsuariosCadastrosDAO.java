package br.com.projeto.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.projeto.model.vo.ResumosVO;
import br.com.projeto.model.vo.LoginVO;

//Classe responsável pela lógica de pesquisas de usuários em forma de tabela
public class UsuariosCadastrosDAO {
	private Connection conexao;
	private String url = "jdbc:mysql://localhost:3306/BD";
	public List<LoginVO> buscaUsuarios() { //Aqui ocorre a pesquisa geral, mostrando pro ADM todos os usuários
		List<LoginVO> usuarios = new ArrayList<>();
		 try {
	    	 Connection conexao = DriverManager.getConnection(url, "root", "root");
	    	 String sql = "SELECT nome, senha, email FROM Usuarios";
    		 PreparedStatement statement = conexao.prepareStatement(sql);
    		 ResultSet resultado = statement.executeQuery();
    		 while(resultado.next()) {
    			 String coluna1 = resultado.getString("nome");
    			 String coluna2 = resultado.getString("senha");
    			 String coluna3 = resultado.getString("email");
    			 LoginVO lgvo = new LoginVO();
    			 lgvo.setNome(coluna1);
    			 lgvo.setSenha(coluna2);
    			 lgvo.setEmail(coluna3);
    			 usuarios.add(lgvo);
    		 }
	    } catch (SQLException slcte) {
	        return null;
	    }
		 return usuarios;
	}
	public List<LoginVO> buscaUsuariosEmail(String email) { //Aqui ocorre a filtragem específica, a partir do e-mail que o adm colocar do usuário
		List<LoginVO> usuarios = new ArrayList<>();
		 try {
	    	 Connection conexao = DriverManager.getConnection(url, "root", "root");
	    	 String sql = "SELECT nome, senha, email FROM Usuarios WHERE email LIKE ?";
    		 PreparedStatement statement = conexao.prepareStatement(sql);
    		 statement.setString(1, email+"%");
    		 ResultSet resultado = statement.executeQuery();
    		 while(resultado.next()) {
    			 String coluna1 = resultado.getString("nome");
    			 String coluna2 = resultado.getString("senha");
    			 String coluna3 = resultado.getString("email");
    			 LoginVO lgvo = new LoginVO();
    			 lgvo.setNome(coluna1);
    			 lgvo.setSenha(coluna2);
    			 lgvo.setEmail(coluna3);
    			 usuarios.add(lgvo);
    		 }
	    } catch (SQLException slcte) {
	        return null;
	    }
		 return usuarios;
	}
}
