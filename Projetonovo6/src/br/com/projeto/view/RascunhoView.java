package br.com.projeto.view;
import javax.swing.*;
import javax.swing.text.*;

import br.com.projeto.controller.LimitadorController;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class RascunhoView extends JFrame{//Classe view do rascunho
	
	public RascunhoView() {
		createAndShowGUI();
	}
	private static final int MAX_CHARACTERS_PER_LINE = 70;


	    public void createAndShowGUI() {
	        JFrame frame = new JFrame("Rascunho");
	        frame.getContentPane().setBackground(Color.CYAN);
	        frame.setResizable(false);
	        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


	        JTextPane textPane = new JTextPane();
	        textPane.setBounds(0, 45, 532, 420);
	        textPane.setEditable(true);
	        LimitadorController limitedDocument = new LimitadorController();
	        textPane.setDocument(limitedDocument);

	        JButton boldUnderlineButton = new JButton("",new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\ProjetoNovo6\\Imagens\\NegritoRascunho.jpg"));
	        boldUnderlineButton.setBounds(258, 0, 214, 35);
	        boldUnderlineButton.setBackground(new Color(255, 255, 255));
	        boldUnderlineButton.addActionListener(e -> applyBoldUnderline(textPane));
	        boldUnderlineButton.setFocusPainted(false);
	        boldUnderlineButton.setPreferredSize(new Dimension(120, 25));
	        boldUnderlineButton.setBorderPainted(false);

	        JPanel panel = new JPanel();
	        panel.setLayout(null);
	        
	        	        JPanel comboBoxPanel = new JPanel(new GridLayout(1, 1));
	        	        comboBoxPanel.setBounds(482, 0, 50, 35);
	        	        panel.add(comboBoxPanel);
	        panel.add(textPane);
	        panel.add(boldUnderlineButton);
	        

	        JScrollPane scrollPane = new JScrollPane(panel);

	        frame.getContentPane().setLayout(new BorderLayout());
	        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

	        JButton underlineOrItalicButton = new JButton("");
	        underlineOrItalicButton.setBounds(0, -4, 249, 39);
	        underlineOrItalicButton.setBackground(new Color(255, 255, 255));

	        underlineOrItalicButton.setIcon(new ImageIcon("C:\\Users\\pwneg\\OneDrive\\Área de Trabalho\\MVC\\ProjetoNovo6\\Imagens\\ItálicoRascunho.jpg"));
	        underlineOrItalicButton.addActionListener(e -> applyItalicOrUnderline(textPane));
	        underlineOrItalicButton.setFocusPainted(false);
	        underlineOrItalicButton.setBorderPainted(false);
	        
	        panel.add(underlineOrItalicButton);
	        
	        JComboBox comboBox = new JComboBox();
	        comboBox.setBounds(0, 0, 0, 0);
	        panel.add(comboBox);
	        comboBox.setBorder(BorderFactory.createEmptyBorder());
	        comboBox.setBackground(Color.ORANGE);
	        
	        String[] fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
	        
	        	     JComboBox<String> fontComboBox = new JComboBox<>(fontNames);
	        	       comboBoxPanel.add(fontComboBox);
	        	       fontComboBox.setSelectedItem("Arial");
	        	        
	        	       fontComboBox.addActionListener(e -> applyFont(textPane, (String) fontComboBox.getSelectedItem()));
	        	        	       
	      
	        fontComboBox.setPreferredSize(new Dimension(50, 10));  
	        frame.setSize(551, 523);
	        frame.setLocationRelativeTo(null);
	        frame.setVisible(true);
	    }

	    private static void applyFont(JTextPane textPane, String fontName) {
	        StyledDocument doc = textPane.getStyledDocument();
	        int start = textPane.getSelectionStart();
	        int end = textPane.getSelectionEnd();

	        if (start != end) {
	            SimpleAttributeSet attrs = new SimpleAttributeSet();
	            StyleConstants.setFontFamily(attrs, fontName);
	            doc.setCharacterAttributes(start, end - start, attrs, false);
	        }
	    }

	    private static void applyItalicOrUnderline(JTextPane textPane) {
	        int start = textPane.getSelectionStart();
	        int end = textPane.getSelectionEnd();

	        if (start != end) {
	            StyledDocument doc = textPane.getStyledDocument();
	            Element element = doc.getCharacterElement(start);
	            AttributeSet as = element.getAttributes();

	            boolean isUnderline = StyleConstants.isUnderline(as);

	            SimpleAttributeSet attrs = new SimpleAttributeSet();
	            if (isUnderline) {
	                StyleConstants.setUnderline(attrs, false);
	                StyleConstants.setItalic(attrs, true);
	            } else {
	                StyleConstants.setUnderline(attrs, true);
	                StyleConstants.setItalic(attrs, false);
	            }

	            doc.setCharacterAttributes(start, end - start, attrs, false);
	        }
	    }

	    private static void applyBoldUnderline(JTextPane textPane) {
	        int start = textPane.getSelectionStart();
	        int end = textPane.getSelectionEnd();

	        if (start != end) {
	            StyledDocument doc = textPane.getStyledDocument();
	            SimpleAttributeSet attrs = new SimpleAttributeSet();

	            StyleConstants.setBold(attrs, true);
	            StyleConstants.setUnderline(attrs, true);

	            doc.setCharacterAttributes(start, end - start, attrs, false);
	        }
	    }        
}