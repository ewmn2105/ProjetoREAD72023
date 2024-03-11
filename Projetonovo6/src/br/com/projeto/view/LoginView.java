package br.com.projeto.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.text.PlainDocument;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import br.com.projeto.model.bo.LoginBO;
import br.com.projeto.model.vo.LoginVO;
import javax.swing.JCheckBox;

public class LoginView extends JFrame {//Classe view do login
	private JLabel image2, image3, image4, CriarConta, AlterarDados, Sair, Entrar;
	private Container container;
	private Font fonte = new Font("Verdana", Font.BOLD, 20);
	private Font fonte1 = new Font("Calibri", Font.BOLD, 15);
	private Font fonte2 = new Font("Verdana", Font.BOLD, 10);
	private JTextField nome;
	private JPasswordField senha;
	private JButton btnLogin, btnCriarCadastro, btnLembrarSenha, btnfechar;
	private JPanel panel;
	private JPanel panel_1;
	private ImageIcon i;

	public LoginView() {
		inicializaComponentes();
	}

	public void inicializaComponentes() {
		ImageIcon read7 = new ImageIcon("Imagens/LOGOBRANCAnova.png");
		setIconImage(read7.getImage());
		setBounds(487, 185, 585, 571);
		setTitle("Read7");
		getContentPane().setBackground(new Color(247, 157, 51));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		nome = new JTextField("Login");
		nome.setOpaque(false);
		nome.setBorder(BorderFactory.createEmptyBorder());
		senha = new JPasswordField("Senha");
		senha.setOpaque(false);
		senha.setBorder(BorderFactory.createEmptyBorder());
		btnLogin = new JButton("Login");
		btnCriarCadastro = new JButton("Criar Conta");
		btnLembrarSenha = new JButton("Alterar Dados");
		btnfechar = new JButton("Sair");
		i = new ImageIcon("Imagens/read.png");
		image3 = new JLabel(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo6\\Imagens\\rosto.png"));
		container = getContentPane();

		nome.setBounds(108, 194, 350, 45);
		senha.setBounds(108, 274, 350, 45);
		btnLogin.setBounds(386, 166, 145, 45);
		btnCriarCadastro.setBounds(96, 437, 120, 27);
		btnLembrarSenha.setBounds(222, 437, 120, 27);
		btnfechar.setBounds(348, 437, 120, 27);
		image3.setBounds(178, 10, 204, 167);
		
		btnLogin.setBackground(Color.BLUE);
		btnLogin.setForeground(Color.WHITE);
		btnCriarCadastro.setForeground(Color.BLACK);
		btnLembrarSenha.setForeground(Color.BLACK);
		btnfechar.setForeground(Color.BLACK);
		btnLogin.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		btnCriarCadastro.setFont(new Font("Segoe UI Variable", Font.BOLD, 10));
		btnLembrarSenha.setFont(new Font("Segoe UI Variable", Font.BOLD, 10));
		btnfechar.setFont(new Font("Segoe UI Variable", Font.BOLD, 10));
		nome.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
		senha.setFont(fonte1);

		btnCriarCadastro.setBackground(new Color(227, 227, 227));
		btnLembrarSenha.setBackground(new Color(227, 227, 227));
		btnfechar.setBackground(new Color(227, 227, 227));
		nome.setForeground(Color.WHITE);
		senha.setForeground(Color.WHITE);

		Entrar = new JLabel("");
		Entrar.setBounds(222, 336, 130, 34);
		getContentPane().add(Entrar);

		AlterarDados = new JLabel("");
		AlterarDados.setBounds(222, 396, 137, 34);
		getContentPane().add(AlterarDados);

		Sair = new JLabel("");
		Sair.setBounds(368, 396, 137, 34);
		getContentPane().add(Sair);

		CriarConta = new JLabel("");
		CriarConta.setBounds(70, 396, 137, 34);
		getContentPane().add(CriarConta);
		getContentPane().add(nome);
		getContentPane().add(senha);
		getContentPane().add(image3);

		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(104, 237, 354, 2);
		getContentPane().add(panel);

		panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(104, 316, 354, 2);
		getContentPane().add(panel_1);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(
				"C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo6\\Imagens\\LoginTela.png"));
		lblNewLabel.setBounds(-11, 0, 582, 534);
		getContentPane().add(lblNewLabel);
		nome.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				if (nome.getText().equals("Login")) {
					nome.setText("");
					nome.setForeground(Color.WHITE);
				}
			}

			public void focusLost(FocusEvent e) {
				if (nome.getText().isEmpty()) {
					nome.setText("Login");
					nome.setForeground(Color.WHITE);
				}
			}
		});
		senha.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent g) {
				if (senha.getText().equals("Senha")) {
					senha.setText("");
					senha.setForeground(Color.WHITE);
				}

			}

			public void focusLost(FocusEvent e) {
				if (senha.getText().isEmpty()) {
					senha.setText("Senha");
					senha.setForeground(Color.WHITE);
				}
			}
		});
		Sair.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				btnfechar.setBackground(Color.red);
				btnfechar.setForeground(Color.white);
			}

			public void mousePressed(MouseEvent e) {
				btnfechar.setBackground(Color.LIGHT_GRAY);
				dispose();
			}

			public void mouseReleased(MouseEvent e) {
				btnfechar.setBackground(Color.LIGHT_GRAY);
			}

			public void mouseEntered(MouseEvent e) {
				btnfechar.setBackground(Color.red);
				btnfechar.setForeground(Color.white);
			}

			public void mouseExited(MouseEvent e) {
				btnfechar.setBackground(new Color(227, 227, 227));
				btnfechar.setForeground(Color.black);
			}
		});
	}

	public String getNome() {
		return nome.getText();
	}

	public String getSenha() {
		return new String(senha.getPassword());
	}

	public void mensagem(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem, "Erro ao logar", JOptionPane.ERROR_MESSAGE);
	}

	public void addBtnLoginListener(MouseListener logListener) {
		Entrar.addMouseListener(logListener);
	}

	public void addBtnCriarCadastro(MouseListener cadListener) {
		CriarConta.addMouseListener(cadListener);
	}

	public void addBtnLembrarSenha(MouseListener lembraListener) {
		AlterarDados.addMouseListener(lembraListener);
	}
}