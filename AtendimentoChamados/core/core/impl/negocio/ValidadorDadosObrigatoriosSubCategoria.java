package core.impl.negocio;

import core.IStrategy;
import dominio.entidadesdominio.Categoria;
import dominio.entidadesdominio.EntidadeDominio;
import dominio.entidadesdominio.SubCategoria;

public class ValidadorDadosObrigatoriosSubCategoria implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		
		if (entidade instanceof SubCategoria) {
			SubCategoria sub = (SubCategoria) entidade;

			String nome = sub.getNome();
			Integer horasAtendimento = sub.getHorasAtendimento();
			Categoria categoria = sub.getCategoria();
			
			if (nome == null || horasAtendimento == null || categoria == null) {
				return "Nome, Horas de atendimento e Categoria são de preenchimento obrigatório!";
			}

			if (nome.trim().equals("")) {
				return "Nome é de preenchimento obrigatório!";
			}
		}
		else {
			return "Deve ser cadastrado uma SubCategoria";
		}
		
		
		return null;
	}
	
	

}
