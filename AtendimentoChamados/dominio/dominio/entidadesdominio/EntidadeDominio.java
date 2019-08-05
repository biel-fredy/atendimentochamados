package dominio.entidadesdominio;

import java.util.Date;

public class EntidadeDominio {
	
	private Integer id;
	private Date dataCriacao;
	
	public EntidadeDominio() {
	}
	
	public EntidadeDominio(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}	
	
}
