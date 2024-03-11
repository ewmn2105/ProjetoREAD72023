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
import br.com.projeto.controller.DownloadADMController;
import br.com.projeto.model.vo.ResumosVO;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

public class ResumosReadADMView extends JFrame {//Classe view da tela de leitura de resumos por parte do ADM

	private JLabel sair;
	private Font fonte = new Font("Verdana", Font.BOLD, 20);
	private Font fonte1 = new Font("Calibri", Font.BOLD, 15);
	private Font fonte2 = new Font("Verdana", Font.BOLD, 9);
	private JScrollPane pane;
	private String texto;
	private JTextField emailAutor;
	private DefaultTableModel tableModel;
	private JTable table;
	private JLabel pesquisa;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;

	public ResumosReadADMView() {
		inicializaComponentes();
	}

	public void inicializaComponentes() {
		ImageIcon read7 = new ImageIcon("Imagens/LOGOBRANCAnova.png");
		setIconImage(read7.getImage());
		setTitle("Pesquisa de resumos");
		setBounds(0, 0, 1920, 1080);
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(255, 255, 255));
		Font fontetip = new Font("Segoe UI Variable", Font.BOLD, 17);
		UIManager.put("ToolTip.font", fontetip);
		UIManager.put("ToolTip.background", (new Color(230, 228, 242)));
		pane = new JScrollPane();
		sair = new JLabel(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo6\\Imagens\\Saída.png"));
		
		pane.setBounds(414, 190, 717, 433);
		sair.setBounds(1400, 104, 130, 113);
		
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
					int linha = table.getSelectedRow();
					String Email = (String) table.getValueAt(linha, 0);
					String Título = (String) table.getValueAt(linha, 1);
					String Resumo = (String) table.getValueAt(linha, 2);
					String Classificação = (String) table.getValueAt(linha, 3);
					LeituraADMView view = new LeituraADMView(Título, Resumo, Email);
					DownloadADMController controle = new DownloadADMController(view);
					view.setVisible(true);
				}
				
			}
		});
		
		getContentPane().add(sair);
		getContentPane().add(pane);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 128, 64));
		panel.setBounds(242, 0, 2, 845);
		getContentPane().add(panel);

		emailAutor = new JTextField();
		emailAutor.setHorizontalAlignment(SwingConstants.LEFT);
		emailAutor.setForeground(new Color(0, 0, 0));
		emailAutor.setFont(new Font("Segoe UI Variable", Font.PLAIN, 15));
		emailAutor.setColumns(10);
		emailAutor.setBounds(359, 63, 769, 50);
		emailAutor.setOpaque(false);
		emailAutor.setBorder(BorderFactory.createEmptyBorder());
		getContentPane().add(emailAutor);
		
		pesquisa = new JLabel("");
		pesquisa.setIcon(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo6\\Imagens\\Pesquisa de resumos.png"));
		pesquisa.setBounds(272, 10, 1209, 752);
		getContentPane().add(pesquisa);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 49, 49));
		panel_1.setBounds(1503, 10, 27, 24);
		getContentPane().add(panel_1);
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(56, 182, 255));
		panel_2.setBounds(1477, 10, 27, 24);
		getContentPane().add(panel_2);
		
		panel_3 = new JPanel();
		panel_3.setBackground(new Color(92, 225, 230));
		panel_3.setBounds(1450, 10, 27, 24);
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
		setVisible(true);
	}
	

	public DefaultTableModel getTexto() {
		return tableModel;
	}
	
	public void tabela(List<ResumosVO> generos) {
		tableModel.setRowCount(0);
		for(ResumosVO genero: generos) {
			tableModel.addRow(new Object[] {genero.getAutor(), genero.getTexto(), genero.getTitulo(), genero.getClassificao()});
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