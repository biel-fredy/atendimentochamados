package core.impl.negocio;

import core.IStrategy;
import dominio.entidadesdominio.Categoria;
import dominio.entidadesdominio.EntidadeDominio;

public class ValidadorDadosObrigatoriosCategoria implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {

		if (entidade instanceof Categoria) {
			Categoria categoria = (Categoria) entidade;

			String nome = categoria.getNome();

			if (nome == null) {
				return "Nome � de preenchimento obrigat�rio!";
			}

			if (nome.trim().equals("")) {
				return "Nome � de preenchimento obrigat�rio!";
			}

		} else {
			return "Deve ser registrado uma categoria de chamado!";
		}
		
		return null;

	}
}
