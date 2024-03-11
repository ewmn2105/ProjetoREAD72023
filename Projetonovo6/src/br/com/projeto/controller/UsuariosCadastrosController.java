package br.com.projeto.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import br.com.projeto.model.vo.LoginVO;

import br.com.projeto.view.UsuariosCadastrosView;
import br.com.projeto.model.vo.GerenciamentodeContaVO;
import br.com.projeto.model.dao.PesquisaResumosDAO;
import br.com.projeto.model.dao.UsuariosCadastrosDAO;

//Classe responsável pela pesquisa de usuário por parte do adm
public class UsuariosCadastrosController {
	private UsuariosCadastrosView view;
	private UsuariosCadastrosDAO userDAO;

	public UsuariosCadastrosController(UsuariosCadastrosView view, Connection conexao) {
		this.view = view;
		this.userDAO = new UsuariosCadastrosDAO();
		view.addTxtListener(new listener3());
	}

	class listener3 implements DocumentListener {

		@Override
		public void insertUpdate(DocumentEvent e) {
			String email = view.getAutor();
			List<LoginVO> usuarios = userDAO.buscaUsuariosEmail(email);
			view.tabela(usuarios);

		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			String email = view.getAutor();
			List<LoginVO> usuarios = userDAO.buscaUsuariosEmail(email);
			view.tabela(usuarios);

		}

		@Override
		public void changedUpdate(DocumentEvent e) {
			String email = view.getAutor();
			List<LoginVO> usuarios = userDAO.buscaUsuariosEmail(email);
			view.tabela(usuarios);

		}
	}
}