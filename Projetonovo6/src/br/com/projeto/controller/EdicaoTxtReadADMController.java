package br.com.projeto.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import javax.swing.filechooser.FileNameExtensionFilter;
import br.com.projeto.view.TelaADMView;

//Classe responsável por adicionar um arquivo a pasta Livros do projeto, em que é possível 
public class EdicaoTxtReadADMController {
	private TelaADMView view;

	public EdicaoTxtReadADMController(TelaADMView view) {
		this.view = view;
		view.addBtnAdicionaLivrosOuTextos(new listener());
	}

	class listener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			mostraSelecionadorArq(view);
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
	private static void mostraSelecionadorArq(JFrame parent) {
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("Arquivos de Texto", "txt");
		fileChooser.setFileFilter(filtro);
		int returnVal = fileChooser.showOpenDialog(parent);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			File sourceFile = fileChooser.getSelectedFile();
			File destino = new File("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\ProjetoNovo6\\Livros");
			try {
				moveFileToDirectory(sourceFile.toPath(), destino.toPath());
				JOptionPane.showMessageDialog(null, "O arquivo de seu livro/texto foi direcionado para a pasta em que eles estão posicionados no aplicativo\nAgora, procure ajeitar os pontos determinados do código onde eles serão usados");
			}catch(IOException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "O arquivo não foi inserido na pasta de livros e textos", "Erro ao inserir o arquivo", JOptionPane.ERROR_MESSAGE);
			}		
		}
	}
	private static void moveFileToDirectory(Path source, Path destino) throws IOException{
		Files.move(source, destino.resolve(source.getFileName()), StandardCopyOption.REPLACE_EXISTING);
	}
}