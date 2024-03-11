package br.com.projeto.view;

import javax.swing.JFrame;
import javax.swing.JLabel;

import br.com.projeto.controller.TapSong;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import br.com.projeto.controller.AcaoController;
import br.com.projeto.controller.TerrorController;
import br.com.projeto.controller.FiccaoController;
import br.com.projeto.controller.RomanceController;
import javax.swing.ImageIcon;
import java.awt.Font;

public class GenerosView extends JFrame {//Classe view das opções de gêneros literários presente no software
	public GenerosView() {
		getContentPane().setBackground(new Color(230, 228, 242));
		inicializarComponentes();
	}

	public void inicializarComponentes() {
		ImageIcon read7 = new ImageIcon("Imagens/LOGOBRANCAnova.png");
		setIconImage(read7.getImage());
		setBounds(200, 260, 1155, 302);
		setTitle("Gêneros");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel l1 = new JLabel("New label");
		l1.setIcon(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo6\\Imagens\\acao.png"));
		l1.setBounds(21, 10, 218, 205);
		getContentPane().add(l1);

		JLabel l2 = new JLabel("New label");
		l2.setIcon(
				new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo6\\Imagens\\Terror.png"));
		l2.setBounds(259, 10, 233, 205);
		getContentPane().add(l2);

		JLabel l3 = new JLabel("New label");
		l3.setIcon(
				new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo6\\Imagens\\Ficção.png"));
		l3.setBounds(502, 10, 233, 205);
		getContentPane().add(l3);

		JLabel l4 = new JLabel("New label");
		l4.setIcon(
				new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo6\\Imagens\\Romance.png"));
		l4.setBounds(742, 10, 233, 205);
		getContentPane().add(l4);

		l1.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					dispose();
					TapSong.getSong();
					AcaoView view = new AcaoView();
					String url = "jdbc:mysql://localhost:3306/BD";
					Connection conexao = DriverManager.getConnection(url, "root", "root");
					AcaoController controller = new AcaoController(view, conexao);
					view.setVisible(true);
					view.setExtendedState(JFrame.MAXIMIZED_BOTH);
				} catch (SQLException sqle) {
				}

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
		l2.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					TapSong.getSong();
					TerrorView view = new TerrorView();
					String url = "jdbc:mysql://localhost:3306/BD";
					Connection conexao = DriverManager.getConnection(url, "root", "root");
					TerrorController controller = new TerrorController(view, conexao);
					view.setVisible(true);
					view.setExtendedState(JFrame.MAXIMIZED_BOTH);
				} catch (SQLException sqle) {
				}

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
		l3.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					TapSong.getSong();
					FiccaoView view = new FiccaoView();
					String url = "jdbc:mysql://localhost:3306/BD";
					Connection conexao = DriverManager.getConnection(url, "root", "root");
					FiccaoController controller = new FiccaoController(view, conexao);
					view.setVisible(true);
					view.setExtendedState(JFrame.MAXIMIZED_BOTH);
				} catch (SQLException sqle) {
				}

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
		l4.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					TapSong.getSong();
					RomanceView view = new RomanceView();
					String url = "jdbc:mysql://localhost:3306/BD";
					Connection conexao = DriverManager.getConnection(url, "root", "root");
					RomanceController controller = new RomanceController(view, conexao);
					view.setVisible(true);
					view.setExtendedState(JFrame.MAXIMIZED_BOTH);
				} catch (SQLException sqle) {
				}

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

		JLabel sair = new JLabel("");
		sair.setIcon(
				new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo6\\Imagens\\Saída.png"));
		sair.setBounds(1034, 73, 70, 92);
		getContentPane().add(sair);

		JLabel lblNewLabel = new JLabel("Ação");
		lblNewLabel.setFont(new Font("Segoe UI Variable", Font.PLAIN, 20));
		lblNewLabel.setBounds(97, 209, 57, 40);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Terror");
		lblNewLabel_1.setFont(new Font("Segoe UI Variable", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(343, 209, 70, 40);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Ficção");
		lblNewLabel_1_1.setFont(new Font("Segoe UI Variable", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(596, 209, 57, 40);
		getContentPane().add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Romance");
		lblNewLabel_1_1_1.setFont(new Font("Segoe UI Variable", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(818, 209, 89, 40);
		getContentPane().add(lblNewLabel_1_1_1);
		sair.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();

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

	}
}
