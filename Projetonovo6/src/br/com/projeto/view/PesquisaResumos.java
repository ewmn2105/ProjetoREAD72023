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
import javax.swing.event.DocumentListener;

import br.com.projeto.controller.DownloadController;
import br.com.projeto.model.vo.ResumosVO;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

public class PesquisaResumos extends JFrame {//Classe view da pesquisa de resumos por parte do usuário

	private JScrollPane pane;
	private String texto;
	private JTextField emailAutor;
	private DefaultTableModel tableModel;
	private JTable table;
	private JLabel salvar;
	private JLabel lblNewLabel_1;

	public PesquisaResumos() {
		inicializaComponentes();
	}

	public void inicializaComponentes() {
		ImageIcon read7 = new ImageIcon("Imagens/LOGOBRANCAnova.png");
		setIconImage(read7.getImage());
		setBounds(0, 0, 1920, 1080);
		getContentPane().setLayout(null);
		setTitle("Pesquisa de resumos");
		getContentPane().setBackground(new Color(255, 255, 255));
		pane = new JScrollPane();
		
		pane.setBounds(415, 210, 717, 433);
		table = new JTable();
		tableModel = new DefaultTableModel(new Object[] {"E-mail", "Título", "Resumo", "Classificação"}, 0);
		table.setModel(tableModel);
		table.setBounds(538, 221, 558, 433);
		table.setBackground(new Color(230, 228, 242));
		table.setFont(new Font("Segoe UI Variable", Font.BOLD, 12));
		pane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==1) {
					try {
					int linha = table.getSelectedRow();
					String Email = (String) table.getValueAt(linha, 0);
					String Título = (String) table.getValueAt(linha, 1);
					String Resumo = (String) table.getValueAt(linha, 2);
					String Classificação = (String) table.getValueAt(linha, 3);
					String url = "jdbc:mysql://localhost:3306/BD";
					TelaLeituraView view = new TelaLeituraView(Título, Resumo, Email);
					DownloadController controle = new DownloadController(view);
					Connection conexao = DriverManager.getConnection(url, "root", "root");
					view.setVisible(true);
	       			}catch(SQLException SQLe) {}
				}
				
			}
		});
		
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo6\\Imagens\\Saída.png"));
		lblNewLabel_1.setBounds(1411, 65, 71, 119);
		getContentPane().add(lblNewLabel_1);
		
				lblNewLabel_1.addMouseListener(new MouseListener() {
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
		getContentPane().add(pane);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 128, 64));
		panel.setBounds(136, 0, 2, 845);
		getContentPane().add(panel);

		emailAutor = new JTextField();
		emailAutor.setForeground(Color.GRAY);
		emailAutor.setHorizontalAlignment(SwingConstants.LEFT);
		emailAutor.setForeground(new Color(0, 0, 0));
		emailAutor.setFont(new Font("Segoe UI Variable", Font.PLAIN, 15));
		emailAutor.setColumns(10);
		emailAutor.setBounds(356, 76, 776, 50);
		emailAutor.setOpaque(false);
		emailAutor.setBorder(BorderFactory.createEmptyBorder());
		getContentPane().add(emailAutor);
		
		salvar = new JLabel();
		salvar.setBounds(1447, 0, 83, 97);
		getContentPane().add(salvar);
		
		JLabel pesquisa = new JLabel("");
		pesquisa.setIcon(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo6\\Imagens\\Pesquisa de resumos.png"));
		pesquisa.setBounds(273, 21, 1209, 752);
		getContentPane().add(pesquisa);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 49, 49));
		panel_5.setBounds(1455, 21, 27, 24);
		getContentPane().add(panel_5);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(56, 182, 255));
		panel_4.setBounds(1429, 21, 27, 24);
		getContentPane().add(panel_4);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(92, 225, 230));
		panel_3.setBounds(1402, 21, 27, 24);
		getContentPane().add(panel_3);
		setVisible(true);
	}
	

	public DefaultTableModel getTexto() {
		return tableModel;
	}
	
	public void tabela(List<ResumosVO> generos) {
		tableModel.setRowCount(0);
		for(ResumosVO genero: generos) {
			tableModel.addRow(new Object[] {genero.getAutor(), genero.getTitulo(), genero.getTexto(), genero.getClassificao()});
		}
	}
	public String getAutor() {
		return emailAutor.getText();
	}	
	public void addtxtAutor (DocumentListener listener) {
		emailAutor.getDocument().addDocumentListener(listener);
	}

	public void mensagem(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem);
	}

	public void mostrarMensagem(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem, "Erro ao logar", JOptionPane.ERROR_MESSAGE);
	}
}
