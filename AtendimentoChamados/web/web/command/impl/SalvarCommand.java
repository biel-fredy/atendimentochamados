package web.command.impl;

import core.aplicacao.Resultado;
import dominio.entidadesdominio.EntidadeDominio;

public class SalvarCommand extends AbstractCommand {
	
	@Override
	public Resultado execute(EntidadeDominio entidade) {
		
		return fachada.salvar(entidade);
	}

}
