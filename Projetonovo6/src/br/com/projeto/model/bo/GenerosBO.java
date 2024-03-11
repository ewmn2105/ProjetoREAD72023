package br.com.projeto.model.bo;

import br.com.projeto.model.dao.AcaoDAO;
import br.com.projeto.model.dao.CadastroDAO;
import br.com.projeto.model.dao.RomanceDAO;
import br.com.projeto.model.vo.CadastroVO;
import br.com.projeto.model.dao.FiccaoDAO;
import br.com.projeto.model.dao.TerrorDAO;
import br.com.projeto.model.vo.ResumosVO;

public class GenerosBO {//BO dos gêneros literários, no caso, da inserção de resumos de cada gênero
	private AcaoDAO acaoDAO;
	private RomanceDAO RomanDAO;
	private TerrorDAO TerrorDAO;
	private FiccaoDAO FicDAO;
	public GenerosBO() {
		acaoDAO = new AcaoDAO();
		TerrorDAO = new TerrorDAO();
		FicDAO = new FiccaoDAO();
		RomanDAO = new RomanceDAO();
	}
	public boolean InserirAcao (ResumosVO textoAcao) {//Método que retorna um resultado da classe AcaoDAO, especificamente do método InserirAcao, verificando se o resumo foi inserido ou não
		return acaoDAO.InserirAcao(textoAcao);
	}
	public boolean InserirTerror (ResumosVO textoterror) {//Método que retorna um resultado da classe TerrorDAO, especificamente do método InserirTerror, verificando se o resumo foi inserido ou não
		return TerrorDAO.InserirTerror(textoterror);
	}
	public boolean InserirFiccao (ResumosVO textofic) {//Método que retorna um resultado da classe FiccaoDAO, especificamente do método InserirFiccao, verificando se o resumo foi inserido ou não
		return RomanDAO.InserirRomance(textofic);
	}
	public boolean InserirRomance (ResumosVO textoroman) {//Método que retorna um resultado da classe RomanceDAO, especificamente do método InserirRomance, verificando se o resumo foi inserido ou não
		return FicDAO.InserirFiccao(textoroman);
	}

}
