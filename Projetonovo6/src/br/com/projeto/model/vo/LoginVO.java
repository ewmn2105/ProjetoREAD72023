package br.com.projeto.model.vo;

	public class LoginVO {//getters and setters para o login
		String nome, senha, email;
		public void Logar (String nome, String senha, String email) {
			this.nome = nome;
			this.senha = senha;
			this.email = email;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getSenha() {
			return senha;
		}
		public void setSenha(String senha) {
			this.senha = senha;
		}
	}

