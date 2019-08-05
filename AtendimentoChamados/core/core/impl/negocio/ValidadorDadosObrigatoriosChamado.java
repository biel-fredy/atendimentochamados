package core.impl.negocio;

import java.util.Date;

import core.IStrategy;
import dominio.entidadesdominio.Categoria;
import dominio.entidadesdominio.Chamado;
import dominio.entidadesdominio.EntidadeDominio;
import dominio.entidadesdominio.Funcionario;
import dominio.entidadesdominio.Regional;
import dominio.entidadesdominio.Setor;
import dominio.entidadesdominio.SubCategoria;
import dominio.entidadesdominio.Telefone;

public class ValidadorDadosObrigatoriosChamado implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {

		if (entidade instanceof Chamado) {
			Chamado chamado = (Chamado) entidade;
			Funcionario criadorChamado = chamado.getCriadorChamado().getFuncionario();
			
			String nomeFuncionario = criadorChamado.getNome();
			Setor setorFuncionario = criadorChamado.getSetor();
			Regional regionalFuncionario = criadorChamado.getSetor().getRegional();
			Telefone telefoneSetor = criadorChamado.getSetor().getTelefone();
			
			Categoria categoria = chamado.getCategoria();
			SubCategoria subCategoria = chamado.getSubCategoria();
					
			String descricao = chamado.getDescricao();
			Date dataAbertura = chamado.getDataCriacao();
			Date previsaoFechamento = chamado.calcularPrazoAtendimento();			

			if (nomeFuncionario == null || setorFuncionario == null ||
					regionalFuncionario == null || telefoneSetor == null ||
					categoria == null || subCategoria == null ||
					descricao == null || dataAbertura == null || 
					previsaoFechamento == null) {
				return "Os seguintes campos são de preenchimento obrigatório: : nome, setor e regional do funcionário, telefone para contato, categoria, subcategoria, descrição, data de abertura e data de previsão do fechamento.";
			}

			if (nomeFuncionario.trim().equals("") || descricao.trim().equals("")) {
				return "Nome do funcionario e descricao do chamado são de preenchimento obrigatório!";
			}

		} 
		else {
			return "Deve ser registrado um chamado!";
		}
		
		return null;

	}
}
