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

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ConfiguracoesADMView extends JFrame {
	private JLabel save, Sair;
	private Container container;
	private JTextField nome, senha;

	public ConfiguracoesADMView() {
		inicializaComponentes();
	}

	public void inicializaComponentes() {//Classe view da configurações de dados de usuários
		ImageIcon read7 = new ImageIcon("Imagens/LOGOBRANCAnova.png");
		setIconImage(read7.getImage());
		setTitle("Configurações de dados de ADM");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(230, 228, 242));
		setBounds(487, 185, 613, 500);
		container = getContentPane();
		nome = new JTextField("Crie um login");
		nome.setOpaque(false);
		nome.setBorder(BorderFactory.createEmptyBorder());
		nome.setBounds(37, 90, 493, 45);
		nome.setFont(new Font("Segoe UI Variable", Font.PLAIN, 22));
		nome.setForeground(Color.LIGHT_GRAY);
		getContentPane().add(nome);
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
					nome.setForeground(Color.LIGHT_GRAY);
				}
			}
		});
		senha = new JTextField("Crie uma senha");
		senha.setOpaque(false);
		senha.setBorder(BorderFactory.createEmptyBorder());
		senha.setBounds(37, 238, 493, 45);
		senha.setFont(new Font("Segoe UI Variable", Font.PLAIN, 22));
		senha.setForeground(Color.LIGHT_GRAY);
		getContentPane().add(senha);
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
					senha.setForeground(Color.LIGHT_GRAY);
				}
			}
		});

		Sair = new JLabel("");
		Sair.setIcon(
				new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo6\\Imagens\\Saída.png"));
		Sair.setBounds(513, 0, 67, 67);
		getContentPane().add(Sair);
		Sair.addMouseListener(new MouseListener() {

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

		JLabel Cancelar = new JLabel("");
		Cancelar.setBounds(274, 343, 206, 67);
		getContentPane().add(Cancelar);
		Cancelar.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				nome.setText("");
				senha.setText("");
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

		save = new JLabel("");
		save.setBounds(37, 343, 206, 67);
		getContentPane().add(save);

		save = new JLabel("");
		save.setIcon(new ImageIcon(
				"C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo6\\Imagens\\Captura de tela 2023-11-06 123450.png"));
		save.setBounds(22, 27, 539, 406);
		getContentPane().add(save);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo6\\Imagens\\ConfiguraçõesADM.png"));
		lblNewLabel.setBounds(0, 0, 599, 463);
		getContentPane().add(lblNewLabel);
	}

	public String getNome() {
		return nome.getText();
	}

	public String getSenha() {
		return senha.getText();
	}

	public void mensagem(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem);
	}

	public void mensagemErro(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem, "Erro ao cadastrar", JOptionPane.ERROR_MESSAGE);
	}

	public void addBtnSalvar(MouseListener listener) {
		save.addMouseListener(listener);
	}
}