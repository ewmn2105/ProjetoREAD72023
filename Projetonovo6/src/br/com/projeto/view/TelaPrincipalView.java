package br.com.projeto.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javax.swing.*;
import java.awt.Component;
import java.awt.event.MouseAdapter;

import br.com.projeto.controller.AcaoController;
import br.com.projeto.controller.TerrorController;
import br.com.projeto.controller.FiccaoController;
import br.com.projeto.controller.RomanceController;
import br.com.projeto.controller.TapSong;
import br.com.projeto.controller.AberturaSong;
import br.com.projeto.controller.PesquisaResumosController;
import br.com.projeto.controller.DataConfigController;
import br.com.projeto.controller.ExclusaoController;

import br.com.projeto.model.dao.PesquisaResumosDAO;
import br.com.projeto.model.vo.*;

public class TelaPrincipalView extends JFrame {//Classe view da tela principal
	private String nome;
	private ImageIcon i1, i2, i3, i4, logo, manual1, Con1, sair1, inf;
	private JLabel Gêneros, lblLogo, acao, manual2, con2, sair2, lblNewLabel, info, Manual;
	private Container container;

	public TelaPrincipalView(String nome) {
		super();
		this.nome = nome;
		inicializaComponentes();
	}

	public void inicializaComponentes() {
		ImageIcon read7 = new ImageIcon("Imagens/LOGOBRANCAnova.png");
		setIconImage(read7.getImage());
		setTitle("Read7");
		//setUndecorated(true);
		Font fontetip = new Font("Segoe UI Variable", Font.BOLD, 17);
		UIManager.put("ToolTip.font", fontetip);
		UIManager.put("ToolTip.background", (new Color(230, 228, 242)));

		lblNewLabel = new JLabel("Bem vindo, " + nome);
		lblNewLabel.setFont(new Font("Segoe UI Variable", Font.PLAIN, 17));
		lblNewLabel.setBounds(186, 10, 238, 63);
		getContentPane().add(lblNewLabel);
		setBounds(0, 0, 1900, 1080);
		container = getContentPane();
		getContentPane().setBackground(new Color(255, 255, 255));
		logo = new ImageIcon("Imagens/LogoTela.png");
		i1 = new ImageIcon("Imagens/acao.png");
		i2 = new ImageIcon("Imagens/Terror.png");
		i3 = new ImageIcon("Imagens/Ficção.png");
		i4 = new ImageIcon("Imagens/Romance.png");
		manual1 = new ImageIcon("Imagens/Manual.png");
		Con1 = new ImageIcon("Imagens/Config.png");
		sair1 = new ImageIcon("Imagens/Sair.png");
		Gêneros = new JLabel(
				new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo6\\Imagens\\Gêneros literário.png"));
		Gêneros.setBounds(199, 102, 322, 300);
		Gêneros.setToolTipText("Gêneros Literários");
		lblLogo = new JLabel(new ImageIcon("C:\\Users\\pwneg\\Downloads\\LogoJO.png"));
		manual2 = new JLabel(
				new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo6\\Imagens\\Resumos.png"));
		con2 = new JLabel(
				new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo6\\Imagens\\ConfiguraçõesTP.png"));
		sair2 = new JLabel(
				new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo6\\Imagens\\SaídaTP.png"));
		getContentPane().setLayout(null);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 0, 0, 0);
		getContentPane().add(panel_4);

		JPanel panel_5 = new JPanel();
		panel_5.setBounds(0, 0, 0, 0);
		getContentPane().add(panel_5);

		JPanel panel = new JPanel();
		panel.setBounds(174, 0, 2, 920);
		panel.setBackground(new Color(255, 128, 64));
		getContentPane().add(panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 83, 1540, 2);
		panel_1.setBackground(new Color(255, 128, 64));
		getContentPane().add(panel_1);

		sair2.setBounds(587, 451, 322, 300);
		sair2.setToolTipText("Sair");
		con2.setBounds(199, 451, 322, 300);
		con2.setToolTipText("Configurações");
		manual2.setBounds(587, 102, 322, 300);
		manual2.setToolTipText("Seus Resumos");
		lblLogo.setBounds(0, 328, 176, 168);
		getContentPane().add(lblLogo);
		getContentPane().add(Gêneros);
		getContentPane().add(con2);
		getContentPane().add(manual2);
		getContentPane().add(sair2);

		JLabel l2_1 = new JLabel((Icon) null);
		l2_1.setBounds(774, 186, 234, 213);
		getContentPane().add(l2_1);
		
		Gêneros.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				TapSong.getSong();
				GenerosView view = new GenerosView();
				view.setVisible(true);
				view.setResizable(false);

			}

			@Override
			public void mousePressed(MouseEvent e) {
				setForeground(Color.ORANGE);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				setForeground(Color.ORANGE);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});
		con2.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				try {
				ConfiguracoesView view = new ConfiguracoesView(nome);
				TapSong.getSong();
				String url = "jdbc:mysql://localhost:3306/BD";
				Connection conexao = DriverManager.getConnection(url, "root", "root");
				ExclusaoController controle1 = new ExclusaoController(view, conexao);
				DataConfigController controle2 = new DataConfigController(view, conexao);
				view.setVisible(true);
				view.setExtendedState(JFrame.MAXIMIZED_BOTH);
				}catch(SQLException sqle) {}

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

		});
		sair2.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				try {
				TapSong.getSong();
				Thread.sleep(1500);
				System.exit(0);
				}catch(Exception exceptione) {}

			}

			@Override
			public void mousePressed(MouseEvent e) {
				setForeground(Color.ORANGE);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				setForeground(Color.ORANGE);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});
		manual2.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					TapSong.getSong();
					PesquisaResumos view = new PesquisaResumos();
					String url = "jdbc:mysql://localhost:3306/BD";
					Connection conexao = DriverManager.getConnection(url, "root", "root");
					PesquisaResumosController controle = new PesquisaResumosController(view, conexao);
					PesquisaResumosDAO acrDAO = new PesquisaResumosDAO();
					List<ResumosVO> buscaResumo = acrDAO.buscarGeneros();
					view.tabela(buscaResumo);
					view.setVisible(true);
					view.setExtendedState(JFrame.MAXIMIZED_BOTH);
				} catch (SQLException sqle) {
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

		});
		
		Manual = new JLabel(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo6\\Imagens\\Manual do Usuário.png"));
		Manual.setToolTipText("Manual do Usuário");
		Manual.setBounds(970, 83, 322, 333);
		getContentPane().add(Manual);
		
		setVisible(true);
	}
	public void addBtnManualUser(MouseListener listener) {
		Manual.addMouseListener(listener);
	}
}