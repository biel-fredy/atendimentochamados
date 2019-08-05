package dominio.entidadesdominio;

import dominio.entidadesenum.PerfilAtendimento;

public class Usuario extends EntidadeDominio {
	
	private String senha;
	private String login;
	private PerfilAtendimento perfilAtendimento;
	
	private Funcionario funcionario;
	
	public boolean verificarForcaSenha(String senha) {
		return false;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		
		this.login = login;
	}

	public PerfilAtendimento getPerfilAtendimento() {
		return perfilAtendimento;
	}

	public void setPerfilAtendimento(PerfilAtendimento perfilAtendimento) {
		this.perfilAtendimento = perfilAtendimento;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

}
