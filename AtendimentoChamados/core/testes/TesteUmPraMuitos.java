package testes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import core.impl.dao.DAOGenerico;
import core.util.db.DB;
import dominio.entidadesdominio.Anexo;
import dominio.entidadesdominio.Chamado;
import dominio.entidadesdominio.EntidadeDominio;
import dominio.entidadesenum.StatusChamado;

public class TesteUmPraMuitos {

	public static void main(String[] args) {
		
		Chamado chamado = new Chamado();
		
		//Preenche Chamado
		chamado.setId(2);
		
		Anexo anexo = new Anexo();
		
		chamado.addAnexo(anexo);
		
		DAOGenerico dao = new DAOGenerico();
		
		dao.consultar(chamado);
		
		DB.closeConnection();

	}

}
