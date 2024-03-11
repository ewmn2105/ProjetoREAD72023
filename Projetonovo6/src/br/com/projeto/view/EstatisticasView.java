package br.com.projeto.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class EstatisticasView extends JFrame {//Classe view das estatísticas do software
	private int numUsers, numResum;
	private JPanel panel, panel_1, panel_2;
	private JLabel UsuariosCadastrados;
	private JLabel ResumosFeitos;
	public EstatisticasView(int numUsers, int numResum) {
		this.numUsers = numUsers;
		this.numResum = numResum;
		inicializarComponentes();
	}

	public void inicializarComponentes() {
		ImageIcon read7 = new ImageIcon("Imagens/LOGOBRANCAnova.png");
		setIconImage(read7.getImage());
		setTitle("Estatísticas");
		setBounds(487, 185, 655, 500);
		setResizable(false);
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(230, 228, 242));
		
		ResumosFeitos = new JLabel(" 0");
		ResumosFeitos.setFont(new Font("Segoe UI Variable", Font.PLAIN, 23));
		ResumosFeitos.setBounds(472, 249, 76, 60);
		ResumosFeitos.setText(" " +numResum);
		getContentPane().add(ResumosFeitos);
		
		UsuariosCadastrados = new JLabel("");
		UsuariosCadastrados.setFont(new Font("Segoe UI Variable", Font.PLAIN, 23));
		UsuariosCadastrados.setText(" " +numUsers);
		UsuariosCadastrados.setBounds(472, 166, 76, 60);
		
		getContentPane().add(UsuariosCadastrados);
		
		JLabel sair = new JLabel("");
		sair.setIcon(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo6\\Imagens\\Saída.png"));
		sair.setBounds(521, 34, 76, 101);
		getContentPane().add(sair);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo6\\Imagens\\Estastísticas.png"));
		lblNewLabel.setBounds(36, 0, 605, 426);
		getContentPane().add(lblNewLabel);
		
		panel = new JPanel();
		panel.setBackground(new Color(56, 182, 255));
		panel.setBounds(578, 10, 27, 24);
		getContentPane().add(panel);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 49, 49));
		panel_1.setBounds(604, 10, 27, 24);
		getContentPane().add(panel_1);
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(92, 225, 230));
		panel_2.setBounds(551, 10, 27, 24);
		getContentPane().add(panel_2);
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
}
