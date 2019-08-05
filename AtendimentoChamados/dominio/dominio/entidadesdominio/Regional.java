package dominio.entidadesdominio;

public class Regional extends EntidadeDominio {

	private String estado;
	private String cidade;
	private String pais;

	public Regional(String estado, String cidade, String pais) {
		super();
		this.estado = estado;
		this.cidade = cidade;
		this.pais = pais;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

}
