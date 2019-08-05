package dominio.entidadesdominio;

public class Setor extends EntidadeDominio {

	private String nome;

	private Regional regional;
	private Telefone telefone;

	public Setor(String nome, Regional regional, Telefone telefone) {
		super();
		this.nome = nome;
		this.regional = regional;
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Regional getRegional() {
		return regional;
	}

	public void setRegional(Regional regional) {
		this.regional = regional;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}
}
