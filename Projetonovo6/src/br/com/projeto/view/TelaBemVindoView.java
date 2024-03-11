package br.com.projeto.view;

import java.awt.Color;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class TelaBemVindoView extends JFrame {//Classe view da tela de splash 
	private ImageIcon image, image2;
	private JLabel i;
	private Container container;
	public TelaBemVindoView() {
		inicializarComponentes();
	}
	public void inicializarComponentes() {
		ImageIcon read7 = new ImageIcon("Imagens/LOGOBRANCAnova.png");
		setIconImage(read7.getImage());
		setBounds(487, 185, 585, 500);
		setUndecorated(true);
		setBackground(Color.ORANGE);
		container = getContentPane();
		image = new ImageIcon("Imagens/LogoJO.png");
		i = new JLabel(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\Projetonovo6\\Imagens\\LogoJO.png"));
		i.setBackground(new Color(230, 228, 242));
		getContentPane().add(i);
		setVisible(true);
		}

}
