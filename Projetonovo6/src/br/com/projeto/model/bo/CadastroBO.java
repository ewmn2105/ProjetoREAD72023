package br.com.projeto.model.bo;
import java.sql.Connection;

import br.com.projeto.model.dao.CadastroDAO;
import br.com.projeto.model.vo.CadastroVO;
public class CadastroBO{//BO do cadastro
	private CadastroDAO cadastroDAO;
	public CadastroBO() {
		cadastroDAO = new CadastroDAO();
	}
	public boolean cadLogin (CadastroVO novologin) {//Método boolean que retorna verdadeiro ou falso dependendo do resultado vindo do CadastroDAO
		return cadastroDAO.novocad(novologin);
	}
}

