package br.com.projeto.controller;

import java.awt.Desktop;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;

import javax.swing.JOptionPane;

import br.com.projeto.model.dao.AcaoDAO;
import br.com.projeto.view.AcaoView;
import br.com.projeto.view.TelaPrincipalView;

//Classe responsável por abrir o manual do usuário
public class ManualUserController {
	private TelaPrincipalView view;

	public ManualUserController(TelaPrincipalView view) {
		this.view = view;
		view.addBtnManualUser(new listener());
	}
	class listener implements MouseListener {
		public void mouseClicked(MouseEvent e) {
			try {
				String caminhoArq = "C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\ProjetoNovo6\\ManualdoUsuario\\READ7MANUALUSER.pdf";
				if (Desktop.isDesktopSupported()) {
					Desktop desktop = Desktop.getDesktop();
					File file = new File(caminhoArq);
					if (file.exists()) {
						desktop.open(file);
					} else {
						System.out.println("O arquivo não existe");
					}
				}
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, "ERRO");
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
	}
}