package br.com.projeto.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import br.com.projeto.model.bo.AlteracaoDeDadosADMBO;
import br.com.projeto.model.vo.LembrarSenhaVO;
import br.com.projeto.view.ConfiguracoesADMView;

//Classe responsável pela edição de dados do ADM

public class EdicaoDATAADMController {
	private ConfiguracoesADMView view;
	private AlteracaoDeDadosADMBO admBO;

	public EdicaoDATAADMController(ConfiguracoesADMView view, Connection conexao) {
		this.view = view;
		admBO = new AlteracaoDeDadosADMBO();
		view.addBtnSalvar(new editaListener());
	}

	class editaListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			String nome = view.getNome();
			String senha = view.getSenha();
			LembrarSenhaVO alterar = new LembrarSenhaVO();
			alterar.setNome(nome);
			alterar.setSenha(senha);
			boolean alterado = admBO.alteraADM(alterar);
			if (alterado == true) {
				view.mensagem("Alteração de dados efetuada");
				view.dispose();
			} else if (alterado == false) {
				view.mensagem("Alteração não foi feita");

			}
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