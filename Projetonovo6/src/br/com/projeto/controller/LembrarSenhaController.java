package br.com.projeto.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JFrame;

import br.com.projeto.controller.LoginController.cadListener;
import br.com.projeto.model.bo.LembrarSenhaBO;
import br.com.projeto.model.vo.LembrarSenhaVO;
import br.com.projeto.view.LembrarSenhaView;
import br.com.projeto.view.TelaPrincipalView;

//Classe responsável pela alteração de nome (login) e senha de usuário.
public class LembrarSenhaController {
		private LembrarSenhaView view;
		private LembrarSenhaBO lembraBO;
		public LembrarSenhaController (LembrarSenhaView view, Connection conexao) {
			this.view = view;
			lembraBO = new LembrarSenhaBO ();
			view.addBtnLembrarSenha(new lembraListener());
		}
		class lembraListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				String nome = view.getNome();
				String senha = view.getSenha();
				String email = view.getEmail();
				LembrarSenhaVO alterar = new LembrarSenhaVO();
				alterar.setEmail(email);
				alterar.setNome(nome);
				alterar.setSenha(senha);
				boolean alterado = lembraBO.alterarSenha(alterar);
				if (alterado == true) {
					view.mensagem("Alterações efetuadas");
					view.dispose();
				}else if (alterado == false){
					view.mensagemAtencao("Alterações não foram feitas\nVerifique se seu e-mail foi informado corretamente");
					
				}
			}
		}

}
