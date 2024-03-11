package br.com.projeto.controller;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Element;
import javax.swing.text.PlainDocument;

//Classe que quebra a linha do JTextPane presente na classe RascunhoView
public class LimitadorController extends DefaultStyledDocument {

	private static final int MAX_CHARACTERS_PER_LINE = 90;

	@Override
	public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
		if (str == null) {
			return;
		}

		int currentLine = getDefaultRootElement().getElementIndex(offs);
		Element lineElement = getDefaultRootElement().getElement(currentLine);
		int lineStart = lineElement.getStartOffset();
		int lineEnd = lineElement.getEndOffset() - 1;
		int lineLength = lineEnd - lineStart;

		if (lineLength >= MAX_CHARACTERS_PER_LINE) {
			offs = insertBreak(offs); // Insere a quebra e atualiza o offset
			super.insertString(offs, str, a); // Insere o texto na próxima linha
		} else {
			int allowedChars = MAX_CHARACTERS_PER_LINE - lineLength;
			String insertString = str.substring(0, Math.min(str.length(), allowedChars));
			super.insertString(offs, insertString, a);

			if (str.length() > allowedChars) {
				offs = insertBreak(offs + allowedChars); // Insere a quebra e atualiza o offset
				insertString(offs, str.substring(allowedChars), a);
			}
		}
	}

	private int insertBreak(int offs) throws BadLocationException {
		if (offs == getLength()) {
			super.insertString(offs, "\n", null);
		} else {
			super.insertString(offs, "\n", null);
		}
		return offs + 1;
	}
}
