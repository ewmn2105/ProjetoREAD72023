package br.com.projeto.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import br.com.projeto.model.vo.ResumosVO;
import br.com.projeto.model.vo.LoginVO;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

public class UsuariosCadastrosView extends JFrame {//Classe view para pesquisa de usuários cadastros por parte do ADM

	private JLabel sair;
	private Font fonte = new Font("Verdana", Font.BOLD, 20);
	private Font fonte1 = new Font("Calibri", Font.BOLD, 15);
	private Font fonte2 = new Font("Verdana", Font.BOLD, 9);
	private JScrollPane pane;
	private DefaultTableModel tableModel;
	private JTable table;
	private JTextField txtAutor;

	public UsuariosCadastrosView() {
		inicializaComponentes();
	}

	public void inicializaComponentes() {
		ImageIcon read7 = new ImageIcon("Imagens/LOGOBRANCAnova.png");
		setIconImage(read7.getImage());
		setBounds(0, 0, 1920, 1080);
		setTitle("Pesquisa por usuários");
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(255, 255, 255));
		Font fontetip = new Font("Segoe UI Variable", Font.BOLD, 17);
		UIManager.put("ToolTip.font", fontetip);
		UIManager.put("ToolTip.background", (new Color(230, 228, 242)));
		pane = new JScrollPane();
		sair = new JLabel(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo6\\Imagens\\Saída.png"));
		
		pane.setBounds(424, 213, 717, 433);
		sair.setBounds(1429, 55, 101, 130);
		
		table = new JTable();
		tableModel = new DefaultTableModel(new Object[] {"Nome", "Senha", "E-mail"}, 0);
		table.setModel(tableModel);
		table.setBounds(538, 221, 558, 433);
		table.setBackground(new Color(230, 228, 242));
		table.setFont(new Font("Segoe UI Variable", Font.BOLD, 12));
		pane.setViewportView(table);
		
		getContentPane().add(sair);
		getContentPane().add(pane);
		
		txtAutor = new JTextField();
		txtAutor.setHorizontalAlignment(SwingConstants.LEFT);
		txtAutor.setForeground(new Color(0, 0, 0));
		txtAutor.setFont(new Font("Segoe UI Variable", Font.PLAIN, 15));
		txtAutor.setColumns(10);
		txtAutor.setBounds(361, 75, 770, 50);
		txtAutor.setOpaque(false);
		txtAutor.setBorder(BorderFactory.createEmptyBorder());
		getContentPane().add(txtAutor);
		
		JLabel pesquisa = new JLabel("");
		pesquisa.setIcon(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo6\\Imagens\\Pesquisa de resumos.png"));
		pesquisa.setBounds(273, 21, 1209, 752);
		getContentPane().add(pesquisa);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 128, 0));
		panel.setBounds(196, 0, 2, 845);
		getContentPane().add(panel);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 49, 49));
		panel_5.setBounds(1503, 21, 27, 24);
		getContentPane().add(panel_5);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(56, 182, 255));
		panel_4.setBounds(1477, 21, 27, 24);
		getContentPane().add(panel_4);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(92, 225, 230));
		panel_3.setBounds(1450, 21, 27, 24);
		getContentPane().add(panel_3);
		
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

	public DefaultTableModel getTexto() {
		return tableModel;
	}
	
	public void tabela(List<LoginVO> usuario) {
		tableModel.setRowCount(0);
		for(LoginVO usuarios: usuario) {
			tableModel.addRow(new Object[] {usuarios.getNome(), usuarios.getSenha(), usuarios.getEmail()});
		}
	}
	public String getAutor() {
		return txtAutor.getText();
	}
	
	public void addTxtListener(DocumentListener listener) {
		txtAutor.getDocument().addDocumentListener(listener);
	}
	
	public void mensagem(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem);
	}

	public void mostrarMensagem(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem, "Erro ao logar", JOptionPane.ERROR_MESSAGE);
	}
}
