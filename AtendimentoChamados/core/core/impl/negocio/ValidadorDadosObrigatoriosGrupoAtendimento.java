package core.impl.negocio;

import core.IStrategy;
import dominio.entidadesdominio.EntidadeDominio;
import dominio.entidadesdominio.GrupoAtendimento;

public class ValidadorDadosObrigatoriosGrupoAtendimento implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {

		if (entidade instanceof GrupoAtendimento) {
			GrupoAtendimento grupoAtendimento = (GrupoAtendimento) entidade;

			String nome = grupoAtendimento.getNome();

			if (nome == null) {
				return "Nome é de preenchimento obrigatório!";
			}

			if (nome.trim().equals("")) {
				return "Nome é de preenchimento obrigatório!";
			}
		} else {
			return "Deve ser registrado um Grupo de Atendimento!";
		}

		return null;
	}
}
