package dominio.entidadesdominio;

public class Categoria extends EntidadeDominio {
	
	private String nome;
	private Boolean status;
	
	public Categoria() {
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}	

}
