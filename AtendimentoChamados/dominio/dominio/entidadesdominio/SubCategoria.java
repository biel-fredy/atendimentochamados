package dominio.entidadesdominio;

public class SubCategoria extends EntidadeDominio {

	private String nome;
	private Boolean status;
	private Integer horasAtendimento;

	private Categoria categoria;

	public void inativarSubCategoria() {
		this.status = false;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getHorasAtendimento() {
		return horasAtendimento;
	}

	public void setHorasAtendimento(Integer prazoAtendimento) {
		this.horasAtendimento = prazoAtendimento;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
