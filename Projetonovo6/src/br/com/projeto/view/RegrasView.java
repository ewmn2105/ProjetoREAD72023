package br.com.projeto.view;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class RegrasView extends JFrame {//Classe view da tela de regras para os resumos
	public RegrasView() {
		inicializarComponentes();
	}

	public void inicializarComponentes() {
		ImageIcon read7 = new ImageIcon("Imagens/LOGOBRANCAnova.png");
		setIconImage(read7.getImage());
		setTitle("Read7");
		setBounds(0, 0, 458, 469);
		setResizable(false);
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(230, 228, 242));
		
		JLabel Saída = new JLabel("");
		Saída.setIcon(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo6\\Imagens\\Saída.png"));
		Saída.setBounds(372, 24, 64, 56);
		getContentPane().add(Saída);
		Saída.addMouseListener(new MouseListener() {

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
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo6\\Imagens\\REGRAS.png"));
		lblNewLabel.setBounds(0, 0, 445, 443);
		getContentPane().add(lblNewLabel);
	}
}
