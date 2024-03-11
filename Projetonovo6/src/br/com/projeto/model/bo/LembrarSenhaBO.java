package br.com.projeto.model.bo;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.projeto.model.dao.AlterarDados;
import br.com.projeto.model.vo.LembrarSenhaVO;
import br.com.projeto.model.vo.LoginVO;
public class LembrarSenhaBO {//BO da alteração de senha
	private AlterarDados lembraDAO;
	public LembrarSenhaBO() {
		lembraDAO = new AlterarDados();
	}
	public boolean alterarSenha (LembrarSenhaVO alter) {//Método que retorna um resultado vindo da classe AlterarDados, especificamente do método alterarSenha, a fim de verificar se a senha foi alterada
		return lembraDAO.alterarSenha(alter);
	}
	
	public boolean alterarEmail(LembrarSenhaVO alter2) {//Método que retorna um resultado vindo da classe AlterarDados, especificamente do método alterarEmail, a fim de verificar se o email foi alterado
		return lembraDAO.alterarEmail(alter2);
	}
}
