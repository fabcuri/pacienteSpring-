package br.com.praticando.pacienteSpring.request;


public class AccountPostRequest {

	private String nome;
	private String login;
	private String senha;
	public AccountPostRequest() {
		// TODO Auto-generated constructor stub
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	@Override
	public String toString() {
		return "AccountPostRequest [nome=" + nome + ", login=" + login + ", senha=" + senha + "]";
	}
	
}
