package dominio.entidadesdominio;

public class PedidoCancelamento extends EntidadeDominio {

	private String motivo;

	private Chamado chamado;

	public void autorizarCancelamento() {

	}

	public void cancelarChamado() {

	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public Chamado getChamado() {
		return chamado;
	}

	public void setChamado(Chamado chamado) {
		this.chamado = chamado;
	}

}
