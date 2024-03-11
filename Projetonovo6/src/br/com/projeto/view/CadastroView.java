package br.com.projeto.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



public class CadastroView extends JFrame {//Classe view do cadastro
	private JLabel image3, txt1;
	private Container container;
	private ImageIcon i1, i2, i3;
	private Font fonte = new Font("Verdana", Font.BOLD, 20);
	private Font fonte1 = new Font("Calibri", Font.BOLD, 15);
	private Font fonte2 = new Font("Verdana", Font.BOLD, 9);
	private Font fonte3 = new Font("Calibri", Font.BOLD, 35);
	private JTextField nome, senha, email;
	private JButton btnCadastrar, btnVoltar;
	private JPanel panel, panel_1, panel_2;

	public CadastroView() {
		getContentPane().setBackground(new Color(255, 128, 64));
		inicializaComponentes();
	}

	public void inicializaComponentes() {

		ImageIcon read7 = new ImageIcon("Imagens/LOGOBRANCAnova.png");
		setIconImage(read7.getImage());
		setTitle("Cadastro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setBounds(487, 185, 585, 500);
		nome = new JTextField("Crie um login");
		nome.setOpaque(false);
		nome.setBorder(BorderFactory.createEmptyBorder());
		senha = new JTextField("Crie uma senha");
		senha.setOpaque(false);
		senha.setBorder(BorderFactory.createEmptyBorder());
		email = new JTextField("Registre seu e-mail");
		email.setOpaque(false);
		email.setBorder(BorderFactory.createEmptyBorder());
		btnVoltar = new JButton("Voltar");
		txt1 = new JLabel("Criar Conta");
		txt1.setForeground(new Color(255, 255, 255));
		i1 = new ImageIcon("Imagens/Fundo.jpg");
		i2 = new ImageIcon("Imagens/Fundo1.jpg");
		i3 = new ImageIcon("Imagens/read.png");
		image3 = new JLabel(i3);
		container = getContentPane();

		txt1.setBounds(100, 61, 350, 45);
		email.setBounds(117, 140, 350, 45);
		nome.setBounds(117, 210, 350, 45);
		senha.setBounds(117, 280, 350, 45);
		image3.setBounds(95, -60, 390, 320);
		nome.setFont(fonte1);
		senha.setFont(fonte1);
		email.setFont(fonte1);
		txt1.setFont(fonte3);
		nome.setForeground(Color.WHITE);
		senha.setForeground(Color.WHITE);
		email.setForeground(Color.WHITE);
		btnCadastrar = new JButton("");
		btnCadastrar.setOpaque(false);
		btnCadastrar.setContentAreaFilled(false);
		btnCadastrar.setBorderPainted(false);
		btnCadastrar.setBounds(149, 387, 140, 35);
		
				btnCadastrar.setFont(fonte);
				btnCadastrar.setBackground(Color.BLUE);
				btnCadastrar.setForeground(Color.WHITE);
				getContentPane().add(btnCadastrar);
		btnVoltar = new JButton("");
		btnVoltar.setOpaque(false);
		btnVoltar.setContentAreaFilled(false);
		btnVoltar.setBorderPainted(false);
		btnVoltar.setBounds(299, 395, 120, 27);
		btnVoltar.setFont(fonte2);
		btnVoltar.setBackground(new Color(227, 227, 227));
		getContentPane().add(btnVoltar);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(92, 225, 230));
		panel_3.setBounds(481, 10, 27, 24);
		getContentPane().add(panel_3);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 49, 49));
		panel_5.setBounds(534, 10, 27, 24);
		getContentPane().add(panel_5);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(56, 182, 255));
		panel_4.setBounds(508, 10, 27, 24);
		getContentPane().add(panel_4);

		panel_1 = new JPanel();
		panel_1.setBounds(100, 242, 350, 2);
		getContentPane().add(panel_1);

		panel = new JPanel();
		panel.setBounds(100, 172, 350, 2);
		getContentPane().add(panel);

		panel_2 = new JPanel();
		panel_2.setBounds(100, 312, 350, 2);
		getContentPane().add(panel_2);
		getContentPane().add(txt1);
		getContentPane().add(nome);
		getContentPane().add(senha);
		getContentPane().add(email);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo6\\Imagens\\Cadastro.png"));
		lblNewLabel.setBounds(0, 0, 571, 463);
		getContentPane().add(lblNewLabel);
		setVisible(true);
		nome.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				if (nome.getText().equals("Crie um login")) {
					nome.setText("");
					nome.setForeground(Color.black);
				}
			}

			public void focusLost(FocusEvent e) {
				if (nome.getText().isEmpty()) {
					nome.setText("Crie um login");
					nome.setForeground(Color.WHITE);
				}
			}
		});
		senha.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent g) {
				if (senha.getText().equals("Crie uma senha")) {
					senha.setText("");
					senha.setForeground(Color.black);
				}
			}

			public void focusLost(FocusEvent e) {
				if (senha.getText().isEmpty()) {
					senha.setText("Crie uma senha");
					senha.setForeground(Color.WHITE);
				}
			}
		});
		email.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent g) {
				if (email.getText().equals("Registre seu e-mail")) {
					email.setText("");
					email.setForeground(Color.black);
				}
			}

			public void focusLost(FocusEvent e) {
				if (email.getText().isEmpty()) {
					email.setText("Registre seu e-mail");
					email.setForeground(Color.WHITE);
				}
			}
		});
	}

	public String getNome() {
		return nome.getText();
	}

	public String getSenha() {
		return senha.getText();
	}

	public String getEmail() {
		return email.getText();
	}

	public void mensagem(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem);
	}

	public void mensagemErro(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem, "Erro ao cadastrar", JOptionPane.ERROR_MESSAGE);
	}

	public void addBtnCadastrar(ActionListener cadListener) {
		btnCadastrar.addActionListener(cadListener);
	}
}