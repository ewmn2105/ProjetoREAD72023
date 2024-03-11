import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import br.com.projeto.controller.AberturaSong;
import br.com.projeto.view.TelaBemVindoView;
import br.com.projeto.view.LoginView;
import br.com.projeto.controller.LoginController;
public class Main {
	public static void main (String[]args) {
		try {
			String url = "jdbc:mysql://localhost:3306/BD";
			Connection conexao = DriverManager.getConnection(url, "root", "root");
			AberturaSong.getSong();
			TelaBemVindoView tela = new TelaBemVindoView();
			tela.setVisible(true);
			Thread.sleep(3000);
			tela.setVisible(false);
			LoginView view = new LoginView();
			LoginController controle = new LoginController (view, conexao);
			view.setResizable(false);
			view.setVisible(true);
			}catch (Exception e) {}
		}

	}


