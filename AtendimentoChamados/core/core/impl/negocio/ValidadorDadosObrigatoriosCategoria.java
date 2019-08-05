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
				return "Nome é de preenchimento obrigatório!";
			}

			if (nome.trim().equals("")) {
				return "Nome é de preenchimento obrigatório!";
			}

		} else {
			return "Deve ser registrado uma categoria de chamado!";
		}
		
		return null;

	}
}
