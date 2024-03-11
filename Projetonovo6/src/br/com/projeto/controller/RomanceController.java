package br.com.projeto.controller;

import java.awt.Desktop;
import java.awt.FontMetrics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfWriter;

import br.com.projeto.view.RomanceView;
import br.com.projeto.model.vo.ResumosVO;
import br.com.projeto.model.bo.GenerosBO;

//Essa classe é responsável por realizar a abertura do pdf que será lido pelo usuário, além de trabalhar com o salvamento do resumo em pdf.
public class RomanceController { 
	private RomanceView view;
	public RomanceController(RomanceView view, Connection conexao) {
		this.view = view;
		view.addBtnPegaTxt(new listener());
		view.addBtnPegaTxt2(new listener2());
		view.addBtnPegaTxt3(new listener3());
		view.addBtnSalvar(new salvarListener());
	}

	class listener implements MouseListener {
		public void mouseClicked(MouseEvent e) {
			try {
				//Aqui, abre-se um livro / texto.
				String caminhoArq = "ProjetoNovo6\\Livros\\O Evangelho segundo Mateus.pdf";
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
	class listener2 implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent e) {
			try {
				//Aqui, abre-se um livro / texto.
				String caminhoArq = "ProjetoNovo6\\Livros\\As Cartas do Passado.pdf";
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
	class listener3 implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent e) {
			try {
				//Aqui, abre-se um livro / texto.
				String caminhoArq = "ProjetoNovo6\\Livros\\O Café das Estações.pdf";
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
	class salvarListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			//Aqui, as variáveis são captadas para serem utilizadas no método generatePDF.
			String titulo = view.getTitulo();
			String autor = view.getAutor();
			String texto = view.getTexto();
			String classi = view.getClassificacao();
			ResumosVO acaoVO = new ResumosVO();
			acaoVO.setTitulo(titulo);
			acaoVO.setAutor(autor);
			acaoVO.setTexto(texto);
			acaoVO.setClassificao(classi);
			GenerosBO acaoBO = new GenerosBO();
			String fonte = view.getFonteName();
			boolean Negrito = view.getSelectNegrito();
			boolean Itálico = view.getSelectItalico();
			java.awt.Font fonteSize = view.getFont();
			int tamanho = fonteSize.getSize();
			boolean inserido = acaoBO.InserirAcao(acaoVO);
			if(inserido) {
				generatePDF("Título: "+titulo+"\n" , "Autor: "+autor+"\n", "------------------------------------------------------------------------------------------------------------------------------\nResumo:\n\n", texto, fonte, tamanho, Negrito, Itálico);
				view.mensagem("Texto Salvo");
			}else {
				view.mensagem("Texto não salvo");
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
	//Método que salva o resumo em pdf.
	public static void generatePDF(String titulo, String content, String content2, String content3, String fonte, int fontesize, boolean Negrito, boolean Itálico) {
		Document document = new Document();
		try {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("Salve seu resumo");
			int userSelection = fileChooser.showSaveDialog(fileChooser);
			if (userSelection == JFileChooser.APPROVE_OPTION) {
				String filePath = fileChooser.getSelectedFile().getAbsolutePath() + ".pdf";
				PdfWriter.getInstance(document, new FileOutputStream(filePath));
				document.open();
				Font fonteResumo = new Font(FontFamily.valueOf(fonte), fontesize, (Negrito ? Font.BOLD : 0)| (Itálico ? Font.ITALIC : 0));
				Chunk resumoComFonte = new Chunk(content3, fonteResumo);
				Phrase phrase = new Phrase();
				phrase.add(new Chunk(content3, fonteResumo));
				phrase.setFont(fonteResumo);
				document.add(new Paragraph (titulo));
				document.add(new Paragraph(content));
				document.add(new Paragraph(content2));
				document.add(phrase);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally	{
			document.close();
		}
	}
	
}
