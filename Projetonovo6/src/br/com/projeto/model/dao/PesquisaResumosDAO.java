package br.com.projeto.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import br.com.projeto.model.vo.ResumosVO;

//Classe responsável pela lógica da pesquisa de resumos em forma de tabela
public class PesquisaResumosDAO { 
	private Connection conexao;
	private String url = "jdbc:mysql://localhost:3306/BD";
	public List<ResumosVO> buscarGeneros() { //Aqui ocorre a filtragem geral dos resumos, em que será mostrado ao usuário todos os resumos feitos
		List<ResumosVO> resumos = new ArrayList<>();
		 try {
	    	 Connection conexao = DriverManager.getConnection(url, "root", "root");
	    	 String sql = "SELECT emailAutor, Título, TextoUsuario, Classificação_resumo FROM Resumos";
    		 PreparedStatement statement = conexao.prepareStatement(sql);
    		 ResultSet resultado = statement.executeQuery();
    		 while(resultado.next()) {
    			 String coluna1 = resultado.getString("emailAutor");
    			 String coluna2 = resultado.getString("Título");
    			 String coluna3 = resultado.getString("TextoUsuario");
    			 String coluna4 = resultado.getString("Classificação_resumo");
    			 ResumosVO gvo = new ResumosVO();
    			 gvo.setAutor(coluna1);
    			 gvo.setTitulo(coluna2);
    			 gvo.setTexto(coluna3);
    			 gvo.setClassificao(coluna4);
    			 resumos.add(gvo);
    		 }
	    } catch (SQLException slcte) {
	        return null;
	    }
		 return resumos;
	}
	
	public List<ResumosVO> buscarGenerosEmail(String email) { // Aqui ocorre a pesquisa com filtro, sendo esse o e-mail do usuário
		List<ResumosVO> resumos = new ArrayList<>();
		 try {
	    	 Connection conexao = DriverManager.getConnection(url, "root", "root");
	    	 String sql = "SELECT emailAutor, Título, TextoUsuario, Classificação_resumo FROM Resumos WHERE emailAutor LIKE ?";
    		 PreparedStatement statement = conexao.prepareStatement(sql);
    		 statement.setString(1, email+"%");
    		 ResultSet resultado = statement.executeQuery();
    		 while(resultado.next()) {
    			 String coluna1 = resultado.getString("emailAutor");
    			 String coluna2 = resultado.getString("Título");
    			 String coluna3 = resultado.getString("TextoUsuario");
    			 String coluna4 = resultado.getString("Classificação_resumo");
    			 ResumosVO gvo = new ResumosVO();
    			 gvo.setAutor(coluna1);
    			 gvo.setTitulo(coluna2);
    			 gvo.setTexto(coluna3);
    			 gvo.setClassificao(coluna4);
    			 resumos.add(gvo);
    		 }
	    } catch (SQLException slcte) {
	        return null;
	    }
		 return resumos;
	}
}
