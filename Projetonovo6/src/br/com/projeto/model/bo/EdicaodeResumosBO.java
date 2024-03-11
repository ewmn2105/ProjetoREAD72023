package br.com.projeto.model.bo;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.projeto.model.dao.EdiçãoResumoDAO;
import br.com.projeto.model.vo.LoginVO;
import br.com.projeto.model.vo.ResumosEdicaoVO;

public class EdicaodeResumosBO {// BO da edição de resumos
	private EdiçãoResumoDAO ediçãoDAO;

	public EdicaodeResumosBO() {
		ediçãoDAO = new EdiçãoResumoDAO();
	}

	public boolean textoAtualizado(ResumosEdicaoVO resumo) {
		return ediçãoDAO.alterarResumo(resumo.getOldTitulo(), resumo.getTitulo(), resumo.getOldResumo(),
				resumo.getResumo());
	}
}
