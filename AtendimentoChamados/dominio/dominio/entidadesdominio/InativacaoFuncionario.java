package dominio.entidadesdominio;

public class InativacaoFuncionario extends EntidadeDominio {

	private String motivo;
	private Funcionario funcionario;

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

}
