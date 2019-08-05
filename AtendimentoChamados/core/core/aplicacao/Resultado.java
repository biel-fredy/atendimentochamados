package core.aplicacao;

import java.util.List;

import dominio.entidadesdominio.EntidadeDominio;

public class Resultado {
	
	private String mensagem;
	private List<EntidadeDominio> resultadoLista;
	
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public List<EntidadeDominio> getResultadoLista() {
		return resultadoLista;
	}
	public void setResultadoLista(List<EntidadeDominio> resultadoLista) {
		this.resultadoLista = resultadoLista;
	}

}
