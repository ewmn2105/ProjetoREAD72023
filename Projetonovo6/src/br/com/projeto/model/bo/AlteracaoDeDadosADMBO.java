package br.com.projeto.model.bo;

import br.com.projeto.model.vo.LembrarSenhaVO;
import br.com.projeto.model.dao.EdicaoADMDATADAO;

public class AlteracaoDeDadosADMBO {//BO da alteração de dados
	private EdicaoADMDATADAO admDAO;
	public AlteracaoDeDadosADMBO() {
		admDAO = new EdicaoADMDATADAO();
	}
	public boolean alteraADM (LembrarSenhaVO alteraADM) {//Método que retorna um resultado vindo da classe EdicaoADMDATADAO, a fim de verificar se os dados do ADM foram alterados
		return admDAO.alterarSenha(alteraADM);
	}
}


