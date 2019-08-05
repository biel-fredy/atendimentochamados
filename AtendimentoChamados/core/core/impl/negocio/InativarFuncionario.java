package core.impl.negocio;

import core.IStrategy;
import dominio.entidadesdominio.EntidadeDominio;
import dominio.entidadesdominio.InativacaoFuncionario;

public class InativarFuncionario implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		
		
		if (entidade instanceof InativacaoFuncionario) {
			InativacaoFuncionario inativacao = (InativacaoFuncionario) entidade;
			
			if (inativacao.getMotivo() == null || inativacao.getFuncionario() == null) {
				return "Os campos motivo e funcionario s�o obrigat�rios para a Inativacao de um Funcionario.";
			}
		}
		else {
			return "S� � poss�vel inativar funcionarios!";
		}
		
		return null;
	}

}
