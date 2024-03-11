package br.com.projeto.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import br.com.projeto.controller.EdiçãoResumosController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import java.awt.Component;

public class LeituraADMView extends JFrame {//Classe view de leitura dos resumos, feitos pelos usuários, por parte do adm
	private String Resumo;
	private String titulo;
	private String emailtxt;
	private JLabel download, Título, Autor;
	private JTextArea resumoparaleitura;

	public LeituraADMView(String titulo, String Resumo, String email) {
		this.titulo = titulo;
		this.Resumo = Resumo;
		this.emailtxt = email;
		inicializarComponentes();

	}

	public void inicializarComponentes() {
		ImageIcon read7 = new ImageIcon("Imagens/LOGOBRANCAnova.png");
		setIconImage(read7.getImage());
		setTitle("Leitura de resumo");
		getContentPane().setBackground(new Color(255, 255, 255));
		setBounds(200, 50, 1150, 750);
		getContentPane().setLayout(null);
		
		JScrollPane pane = new JScrollPane((Component) null);
		pane.setBorder(BorderFactory.createEmptyBorder());
		pane.setBackground(new Color(250, 250, 250));
		pane.setBounds(56, 129, 1070, 445);
		getContentPane().add(pane);
		
		resumoparaleitura = new JTextArea();
		resumoparaleitura.setText(Resumo);
		resumoparaleitura.setFont(new Font("Segoe UI Variable", Font.BOLD, 17));
		pane.setViewportView(resumoparaleitura);
		
		Título = new JLabel("");
		Título.setBounds(79, 39, 240, 33);
		Título.setText(titulo);
		Título.setFont(new Font("Segoe UI Variable", Font.BOLD, 17));
		getContentPane().add(Título);

		JLabel sair2 = new JLabel(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo6\\Imagens\\Saída.png"));
		sair2.setBounds(780, 10, 94, 89);
		getContentPane().add(sair2);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 128, 0));
		panel.setBounds(69, 75, 252, 2);
		getContentPane().add(panel);

		download = new JLabel(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo6\\Imagens\\Download.png"));
		download.setBounds(708, 26, 77, 51);
		download.setToolTipText("Baixar resumo em pdf");
		getContentPane().add(download);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo6\\Imagens\\Campo de escrita de resumos.png"));
		lblNewLabel.setBounds(25, 80, 1111, 534);
		getContentPane().add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 128, 0));
		panel_1.setBounds(341, 75, 252, 2);
		getContentPane().add(panel_1);
		
		Autor = new JLabel();
		Autor.setFont(new Font("Segoe UI Variable", Font.BOLD, 17));
		Autor.setBounds(341, 39, 240, 33);
		Autor.setText(emailtxt);
		getContentPane().add(Autor);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 49, 49));
		panel_5.setBounds(1099, 10, 27, 24);
		getContentPane().add(panel_5);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(56, 182, 255));
		panel_4.setBounds(1073, 10, 27, 24);
		getContentPane().add(panel_4);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(92, 225, 230));
		panel_3.setBounds(1046, 10, 27, 24);
		getContentPane().add(panel_3);

		setResizable(false);

		sair2.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
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

		setVisible(true);
	}

	public String pegaTitutlo() {
		return Título.getText();
	}

	public String pegaResumo() {
		return resumoparaleitura.getText();
	}

	public String pegaAutor() {
		return Autor.getText();
	}

	public void mensagem(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem);
	}

	public void addBtnDownload(MouseListener listener) {
		download.addMouseListener(listener);
	}
}