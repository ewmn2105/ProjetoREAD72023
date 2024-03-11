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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.com.projeto.model.bo.LoginBO;
import br.com.projeto.model.dao.PesquisaResumosDAO;
import br.com.projeto.model.dao.EstastísticasDAO;
import br.com.projeto.model.vo.ResumosVO;
import br.com.projeto.model.vo.LoginVO;
import br.com.projeto.controller.TapSong;
import br.com.projeto.controller.UsuariosCadastrosController;
import br.com.projeto.controller.EdicaoDATAADMController;
import br.com.projeto.view.ConfiguracoesADMView;
import javax.swing.Icon;
import br.com.projeto.model.dao.UsuariosCadastrosDAO;
import br.com.projeto.controller.TabelaControllerReadResumoADM;

public class TelaADMView extends JFrame {//Classe view da tela de ADM
	private JLabel image2, image3;
	private JPanel p, p2, p3;
	private Container container;
	private ImageIcon i1, i2, i3;
	private Font fonte = new Font("Calibri", Font.BOLD, 30);
	private Font fonte1 = new Font("Calibri", Font.BOLD, 15);
	private Font fonte2 = new Font("Calibri", Font.BOLD, 27);
	private Font fonte3 = new Font("Calibri", Font.BOLD, 40);
	private Font fonte4 = new Font("Calibri", Font.BOLD, 12);
	private String contaCad;
	private JLabel Estatisticas, Add;

	public TelaADMView() {
		getContentPane().setForeground(new Color(255, 255, 255));
		inicializaComponentes();
	}

	public void inicializaComponentes() {
		ImageIcon read7 = new ImageIcon("Imagens/LOGOBRANCAnova.png");
		setIconImage(read7.getImage());
		setTitle("Acesso ADM");
		setBounds(0, 0, 1920, 1080);
		getContentPane().setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		i1 = new ImageIcon("Imagens/Fundo.jpg");
		i2 = new ImageIcon("Imagens/Fundo1.jpg");
		i3 = new ImageIcon("Imagens/read.png");
		image2 = new JLabel(i2);
		image3 = new JLabel(i3);
		p = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		container = getContentPane();
		image3.setBounds(95, -60, 390, 320);
		p.setBounds(90, 200, 500, 350);
		p2.setBounds(0, 130, 500, 5);
		p3.setBounds(920, 200, 500, 350);
		p.add(image2);
		p2.setBackground(Color.black);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 128, 64));
		panel.setBounds(122, 0, 2, 845);
		getContentPane().add(panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 128, 64));
		panel_1.setBounds(0, 90, 1540, 2);
		getContentPane().add(panel_1);

		JLabel Resumos = new JLabel(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo6\\Imagens\\Resumos tela adm.png"));
		Resumos.setBounds(133, 105, 322, 300);
		getContentPane().add(Resumos);
		Resumos.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					TapSong.getSong();
					ResumosReadADMView view = new ResumosReadADMView();
					String url = "jdbc:mysql://localhost:3306/BD";
					Connection conexao = DriverManager.getConnection(url, "root", "root");
					TabelaControllerReadResumoADM controle = new TabelaControllerReadResumoADM(view, conexao);
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
		setVisible(true);

		JLabel l1 = new JLabel(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo6\\Imagens\\Usuários tela adm.png"));
		l1.setBounds(476, 105, 322, 300);
		getContentPane().add(l1);

		l1.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					TapSong.getSong();
					UsuariosCadastrosView view = new UsuariosCadastrosView();
					String url = "jdbc:mysql://localhost:3306/BD";
					Connection conexao = DriverManager.getConnection(url, "root", "root");
					UsuariosCadastrosController controle = new UsuariosCadastrosController(view, conexao);
					UsuariosCadastrosDAO userDAO = new UsuariosCadastrosDAO();
					List<LoginVO> buscaUsuário = userDAO.buscaUsuarios();
					view.tabela(buscaUsuário);
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

		Estatisticas = new JLabel(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo6\\Imagens\\Estatísticas tela adm.png"));
		Estatisticas.setBounds(1133, 102, 333, 300);
		getContentPane().add(Estatisticas);
		Estatisticas.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				TapSong.getSong();
				EstastísticasDAO estDAO = new EstastísticasDAO();
				int numUsers = estDAO.Estatisticas();
				int numResum = estDAO.EstatisticasResumos();
				EstatisticasView view = new EstatisticasView(numUsers, numResum);
				view.setVisible(true);
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

		Add = new JLabel(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo6\\Imagens\\Textos tela adm.png"));
		Add.setBounds(832, 113, 291, 292);
		getContentPane().add(Add);

		JLabel lblNewLabel = new JLabel("Bem Vindo, ADM!");
		lblNewLabel.setFont(new Font("Segoe UI Variable", Font.PLAIN, 25));
		lblNewLabel.setBounds(134, 26, 215, 54);
		getContentPane().add(lblNewLabel);

		JLabel Sair_1 = new JLabel(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo6\\Imagens\\Sair tela adm.png"));
		Sair_1.setBounds(465, 445, 333, 300);
		getContentPane().add(Sair_1);

		JLabel Con = new JLabel(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo6\\Imagens\\Configurações.png"));
		Con.setBounds(122, 445, 333, 300);
		getContentPane().add(Con);
		Con.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					TapSong.getSong();
					ConfiguracoesADMView view = new ConfiguracoesADMView();
					String url = "jdbc:mysql://localhost:3306/BD";
					Connection conexao = DriverManager.getConnection(url, "root", "root");
					EdicaoDATAADMController controle =  new EdicaoDATAADMController(view, conexao);
					view.setVisible(true);
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
		Sair_1.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				TapSong.getSong();
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

	public void mensagem(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem, "Usuário Removido", JOptionPane.INFORMATION_MESSAGE);
	}

	public void mensagemErro(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem, "Remoção não realizada", JOptionPane.WARNING_MESSAGE);
	}

	public void addBtnEstatisticas(MouseListener listener) {
		Estatisticas.addMouseListener(listener);
	}
	public void addBtnAdicionaLivrosOuTextos(MouseListener listener) {
		Add.addMouseListener(listener);
	}
	
	
}