package br.com.projeto.controller;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import br.com.projeto.model.dao.PesquisaResumosDAO;
import br.com.projeto.model.vo.ResumosVO;
import br.com.projeto.view.ResumosReadADMView;

//Classe responsável pela pesquisa de resumos por parte do adm
public class TabelaControllerReadResumoADM {
	private ResumosReadADMView view;
	private PesquisaResumosDAO acrDAO;

	public TabelaControllerReadResumoADM(ResumosReadADMView view, Connection conexao) {
		this.view = view;
		this.acrDAO = new PesquisaResumosDAO();
		view.addtxtAutor(new listener3());
	}
		class listener3 implements DocumentListener{

			@Override
			public void insertUpdate(DocumentEvent e) {
				String email = view.getAutor();
				List<ResumosVO> generos = acrDAO.buscarGenerosEmail(email);
				view.tabela(generos);
				
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				String email = view.getAutor();
				List<ResumosVO> generos = acrDAO.buscarGenerosEmail(email);
				view.tabela(generos);
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				String email = view.getAutor();
				List<ResumosVO> generos = acrDAO.buscarGenerosEmail(email);
				view.tabela(generos);
				
			}
			
		}
}	