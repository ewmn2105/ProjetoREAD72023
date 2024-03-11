package br.com.projeto.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;

import javax.swing.JFrame;

import br.com.projeto.controller.LoginController.cadListener;
import br.com.projeto.model.bo.LembrarSenhaBO;
import br.com.projeto.model.vo.LembrarSenhaVO;
import br.com.projeto.view.ConfiguracoesView;
import br.com.projeto.view.LembrarSenhaView;
import br.com.projeto.view.TelaPrincipalView;

//Classe responsável pelas configurações de dados do usuário, neste caso, responsável pela alteração de dados
public class DataConfigController {
		private ConfiguracoesView view;
		private LembrarSenhaBO lembraBO;
		public DataConfigController  (ConfiguracoesView view, Connection conexao) {
			this.view = view;
			lembraBO = new LembrarSenhaBO ();
			view.addBtnLembrarSenha(new lembraListener());
		}
		class lembraListener implements MouseListener{

			@Override
			public void mouseClicked(MouseEvent e) {
				String nome = view.getNome();
				String senha = view.getSenha();
				String email = view.getEmail();
				LembrarSenhaVO alterar = new LembrarSenhaVO();
				alterar.setEmail(email);
				alterar.setNome(nome);
				alterar.setSenha(senha);
				boolean alterado = lembraBO.alterarSenha(alterar);
				if (alterado == true) {
					view.mensagem("Alteração de senha efetuada\nO aplicativo será fechado");
					view.mensagem("Abra-o novamente, logando com suas novas informações");
					System.exit(0);
				}else if (alterado == false){
					view.mensagemAtencao("Alteração não foi feita\nVerifique se seu e-mail foi informado corretamente");
					
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
