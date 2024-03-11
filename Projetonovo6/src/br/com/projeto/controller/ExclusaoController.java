package br.com.projeto.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;

import br.com.projeto.model.bo.ExclusãoBO;
import br.com.projeto.model.vo.GerenciamentodeContaVO;
import br.com.projeto.view.ConfiguracoesView;

//Classe responsável pela exclusão de conta do usuário
public class ExclusaoController {
	private ConfiguracoesView view;
	private ExclusãoBO exBO;
	public ExclusaoController(ConfiguracoesView view, Connection conexao) {
		this.view = view;
		exBO = new ExclusãoBO();
		view.addBtnExcluir(new excluirListener());
	}
	class excluirListener implements MouseListener{

		@Override
		public void mouseClicked
		(MouseEvent e) {
			 	 String email = view.getEmailDel();
	          	 GerenciamentodeContaVO removeLogin = new GerenciamentodeContaVO();
	          	 GerenciamentodeContaVO removeLogin2 = new GerenciamentodeContaVO();
	          	 removeLogin.setEmail(email);
	          	 removeLogin2.setEmail(email);
	          	 boolean removidoUsuario = exBO.removeLogin(removeLogin);
	          	 boolean removidoResumo = exBO.removeResumos(removeLogin2);
	          	 if (removidoUsuario == true && removidoResumo == true) {
	          		view.mensagem("Conta Removida");
	          		view.mensagem("Seus dados foram removidos juntamente com o seus resumos\nFoi bom ter você conosco.");
	          		System.exit(0);
	          	 } else if (removidoUsuario == false && removidoResumo == false){
	          		 view.mensagemErro("Erro ao remover conta");
	          	}else if (removidoUsuario == true && removidoResumo == false);
	          	view.mensagem("Conta Removida");
	          	view.mensagem("Seus resumos continuarão aqui para que outros leitores possam se inspirar no que você escreveu\nFoi bom ter você conosco.");
          		System.exit(0);
		}
		

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
}