package core.impl.negocio;

import core.IStrategy;
import dominio.entidadesdominio.EntidadeDominio;
import dominio.entidadesdominio.Funcionario;
import dominio.entidadesdominio.Regional;
import dominio.entidadesdominio.Setor;

public class ValidadorDadosObrigatoriosFuncionario implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {

		if (entidade instanceof Funcionario) {
			Funcionario funcionario = (Funcionario) entidade;

			String nome = funcionario.getNome();
			Integer matricula = funcionario.getMatricula();
			String email = funcionario.getEmail();
			Regional regional = funcionario.getSetor().getRegional();
			Setor setor = funcionario.getSetor();

			if (nome == null || matricula == null || email == null || regional == null || setor == null) {
				return "Nome, matricula, email, regional e setor são de preenchimento obrigatório!";
			}

			if (nome.trim().equals("") || email.trim().equals("")) {
				return "Nome e email são de preenchimento obrigatório!";
			}
			
		} else {
			return "Deve ser registrado um funcionario!";
		}
		
		return null;

	}

}
