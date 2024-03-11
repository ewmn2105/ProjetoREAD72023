package br.com.projeto.model.vo;

public class ResumosVO { //getters and setters dos resumos
	private String titulo;
	private String texto;
	private String autor;
	private String classificao;
	public String getClassificao() {
		return classificao;
	}
	public void setClassificao(String classificao) {
		this.classificao = classificao;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
}
