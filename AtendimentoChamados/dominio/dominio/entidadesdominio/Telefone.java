package dominio.entidadesdominio;

public class Telefone extends EntidadeDominio{
	
	private String numero;
	private String codigoOperadora;
		
	public Telefone(String codigoOperadora, String numero) {
		super();
		this.codigoOperadora = codigoOperadora;
		this.numero = numero;
	}

	public String getCodigoOperadora() {
		return codigoOperadora;
	}

	public void setCodigoOperadora(String codigoOperadora) {
		this.codigoOperadora = codigoOperadora;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
}
