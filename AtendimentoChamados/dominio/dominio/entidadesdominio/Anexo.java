package dominio.entidadesdominio;

public class Anexo extends EntidadeDominio {
	
	private String nome;
	private String caminho;
	private String extensao;
	private String legenda;
	
	public String getLegenda() {
		return legenda;
	}
	public void setLegenda(String legenda) {
		this.legenda = legenda;
	}
	public String getCaminho() {
		return caminho;
	}
	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}
	public String getExtensao() {
		return extensao;
	}
	public void setExtensao(String extensao) {
		this.extensao = extensao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	

}
