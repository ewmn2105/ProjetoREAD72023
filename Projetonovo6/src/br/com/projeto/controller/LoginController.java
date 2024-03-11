package br.com.projeto.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import br.com.projeto.view.*;
import br.com.projeto.model.bo.LoginBO;
import br.com.projeto.model.vo.LoginVO;

//Classe responsável por efetuar o login do usuário ou admm
public class LoginController {
	private LoginView view;
	private LoginVO vo;
	private LoginBO loginBO;
	private String url = "jdbc:mysql://localhost:3306/BD";

	public LoginController(LoginView view, Connection conexao) {
		this.view = view;
		loginBO = new LoginBO(conexao);
		view.addBtnLoginListener(new logListener());
		view.addBtnCriarCadastro(new cadListener());
		view.addBtnLembrarSenha(new lembraListener());
	}

	class logListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			String nome = view.getNome();
			String senha = view.getSenha();
			LoginVO login = new LoginVO();
			login.setNome(nome);
			login.setSenha(senha);
			LoginVO adm = new LoginVO();
			adm.setNome(nome);
			adm.setSenha(senha);
			boolean logado = loginBO.verificaLogin(login); 
			boolean admLogado = loginBO.verificarLoginAdm(login);
			if (logado == true) { // Verifica se o login é de usuário e abre a tela principal
				try {
					Connection conexao = DriverManager.getConnection(url, "root", "root");
					view.dispose();
					TelaPrincipalView tela2 = new TelaPrincipalView(nome);
					ManualUserController controlerManual = new ManualUserController(tela2);
					AcaoView roman = new AcaoView();
					tela2.setVisible(true);
					tela2.setExtendedState(JFrame.MAXIMIZED_BOTH);
				} catch (Exception g) {
				}
			} else if (admLogado == true) { // Verifica se o login é de adm e abre a tela de adm
				try {
					Connection conexao = DriverManager.getConnection(url, "root", "root");
					view.dispose();
					TelaADMView telaADM = new TelaADMView();
					EdicaoTxtReadADMController controle2 = new EdicaoTxtReadADMController(telaADM);
					telaADM.setVisible(true);
					telaADM.setExtendedState(JFrame.MAXIMIZED_BOTH);
				} catch (SQLException e5) {
				}
			} else if (logado == false && admLogado == false) {
				view.mensagem("Nome ou senha incorretos");
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

	class cadListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			try {
				Connection conexao = DriverManager.getConnection(url, "root", "root");
				CadastroView cad = new CadastroView();
				CadastroController controle = new CadastroController(cad, conexao);
				cad.setVisible(true);
				cad.setResizable(false);
			} catch (SQLException e3) {
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

	class lembraListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			try {
				Connection conexao = DriverManager.getConnection(url, "root", "root");
				LembrarSenhaView leb = new LembrarSenhaView();
				LembrarSenhaController lembra = new LembrarSenhaController(leb, conexao);
				leb.setVisible(true);
				leb.setResizable(false);
			} catch (SQLException e2) {}
			
			
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
