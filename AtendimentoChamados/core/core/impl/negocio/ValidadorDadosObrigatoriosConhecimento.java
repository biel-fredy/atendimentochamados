package core.impl.negocio;

import java.util.List;

import core.IStrategy;
import dominio.entidadesdominio.Conhecimento;
import dominio.entidadesdominio.EntidadeDominio;
import dominio.entidadesdominio.Tag;

public class ValidadorDadosObrigatoriosConhecimento implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		
		if (entidade instanceof Conhecimento) {
			Conhecimento conhecimento = (Conhecimento) entidade;
			
			String nome = conhecimento.getNome();
			List<Tag> tags = conhecimento.getTags();
			String descricao = conhecimento.getDescricao();
			
			if (nome == null || descricao == null || tags.size() == 0) {
				return "O conhecimento deve ter nome, descricao de procedimento e pelo menos uma tag para poder ser cadastrado!";
			}

			if (nome.trim().equals("") || descricao.trim().equals("")) {
				return "Nome e descricao são de preenchimento obrigatório!";
			}
		}
		else {
			return "Deve ser registrado um conhecimento!";
		}
		
		
		return null;
	}

}
