package br.com.projeto.model.bo;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.projeto.model.dao.LoginDAO;
import br.com.projeto.model.vo.LoginVO;
public class LoginBO {//BO do login
	private LoginDAO loginDAO;
	public LoginBO(Connection conexao) {
		loginDAO = new LoginDAO(conexao);
	}
	public boolean verificaLogin (LoginVO login) {//Método boolean que retorna verdadeiro ou falso dependendo do resultado vindo do loginDAO, especificamente do método verificaLogin
		return loginDAO.verificaLogin(login.getNome(), login.getSenha());
	}
	public boolean verificarLoginAdm(LoginVO adm) {//Método boolean que retorna verdadeiro ou falso dependendo do resultado vindo do loginDAO, especificamente do método verificaLoginADM
		return loginDAO.verificaLoginADM(adm.getNome(), adm.getSenha());
	}

}
