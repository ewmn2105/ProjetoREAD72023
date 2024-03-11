package br.com.projeto.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import br.com.projeto.view.LeituraADMView;

//Classe responsável pelo downlaod de um resumo em pdf por parte do adm
public class DownloadADMController {
	private LeituraADMView view;

	public DownloadADMController(LeituraADMView view) {
		this.view = view;
		view.addBtnDownload(new download());
	}

	class download implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			String titulo = view.pegaTitutlo();
			String autor = view.pegaAutor();
			String resumo = view.pegaResumo();
			generatePDF("\nAutor: " + autor + "\n",
					"------------------------------------------------------------------------------------------------------------------------------\nResumo:\n\n", resumo);
			JOptionPane.showMessageDialog(null, "Download Concluído");
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

	public static void generatePDF(String content, String content2, String content3) {
		Document document = new Document();
		try {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("Salvar Resumo");
			int userSelection = fileChooser.showSaveDialog(fileChooser);
			if (userSelection == JFileChooser.APPROVE_OPTION) {
				String filePath = fileChooser.getSelectedFile().getAbsolutePath() + ".pdf";
				PdfWriter.getInstance(document, new FileOutputStream(filePath));
				document.open();
				document.add(new Paragraph(content));
				document.add(new Paragraph(content2));
				document.add(new Paragraph(content3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			document.close();
		}
	}

}
