package web.command;

import core.aplicacao.Resultado;
import dominio.entidadesdominio.EntidadeDominio;

public interface ICommand {
	
	public Resultado execute(EntidadeDominio entidade);

}
