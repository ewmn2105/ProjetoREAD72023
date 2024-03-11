package br.com.projeto.model.bo;

import br.com.projeto.model.dao.CadastroDAO;
import br.com.projeto.model.dao.ExclusaoDAO;
import br.com.projeto.model.vo.CadastroVO;
import br.com.projeto.model.vo.GerenciamentodeContaVO;
public class ExclusãoBO{//BO da exclusão de conta
	private ExclusaoDAO exclusaoDAO;
	public ExclusãoBO() {
		exclusaoDAO = new ExclusaoDAO();
	}
	public boolean removeLogin (GerenciamentodeContaVO removelogin) {//Método que retorna um resultado a fim de verificar se o a exclusão de conta foi feita 
		return exclusaoDAO.removeConta(removelogin);
	}
	public boolean removeResumos (GerenciamentodeContaVO removelogin2) {//Método que retorna um resultado a fim de verificar se o a exclusão de resumos foi feita 
		return exclusaoDAO.removeResumos(removelogin2);
	}
}

