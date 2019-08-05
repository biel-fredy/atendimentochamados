package core.impl.negocio;

import java.util.Date;

import core.IStrategy;
import dominio.entidadesdominio.EntidadeDominio;

public class ComplementarDataCadastro implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		
		if(entidade !=null){
			Date data = new Date();		
			entidade.setDataCriacao(data);
		}else{
			return "Entidade nula!";
		}		
		
		return null;
	}

}
