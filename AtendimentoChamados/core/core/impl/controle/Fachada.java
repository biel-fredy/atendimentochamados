package core.impl.controle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import core.IFachada;
import core.IStrategy;
import core.aplicacao.Resultado;
import core.impl.dao.DAOGenerico;
import core.impl.negocio.ComplementarDataCadastro;
import core.impl.negocio.InativarFuncionario;
import core.impl.negocio.ValidadorDadosObrigatoriosCategoria;
import core.impl.negocio.ValidadorDadosObrigatoriosChamado;
import core.impl.negocio.ValidadorDadosObrigatoriosConhecimento;
import core.impl.negocio.ValidadorDadosObrigatoriosFuncionario;
import core.impl.negocio.ValidadorDadosObrigatoriosGrupoAtendimento;
import core.impl.negocio.ValidadorDadosObrigatoriosSubCategoria;
import core.impl.negocio.ValidadorFormatosPermitidosAnexo;
import dominio.entidadesdominio.Anexo;
import dominio.entidadesdominio.Categoria;
import dominio.entidadesdominio.Chamado;
import dominio.entidadesdominio.Conhecimento;
import dominio.entidadesdominio.EntidadeDominio;
import dominio.entidadesdominio.Funcionario;
import dominio.entidadesdominio.GrupoAtendimento;
import dominio.entidadesdominio.SubCategoria;

public class Fachada implements IFachada {

	private Map<String, Map<String, List<IStrategy>>> regrasDeNegocio;

	private Resultado resultado;

	public Fachada() {

		/* Criando Instancias */
		regrasDeNegocio = new HashMap<String, Map<String, List<IStrategy>>>();

		/* Criando instâncias de regras de negócio a serem utilizados */
		ComplementarDataCadastro comDataCadastro = new ComplementarDataCadastro();
		InativarFuncionario inativarFuncionario = new InativarFuncionario();
		ValidadorDadosObrigatoriosCategoria vrDadosObrigatoriosCategoria = new ValidadorDadosObrigatoriosCategoria();
		ValidadorDadosObrigatoriosSubCategoria vrDadosObrigatoriosSubCategoria = new ValidadorDadosObrigatoriosSubCategoria();
		ValidadorDadosObrigatoriosChamado vrDadosObrigatoriosChamado = new ValidadorDadosObrigatoriosChamado();
		ValidadorDadosObrigatoriosConhecimento vrDadosObrigatoriosConhecimento = new ValidadorDadosObrigatoriosConhecimento();
		ValidadorDadosObrigatoriosFuncionario vrDadosObrigatoriosFuncionario = new ValidadorDadosObrigatoriosFuncionario();
		ValidadorDadosObrigatoriosGrupoAtendimento vrDadosObrigatoriosGrupoAtendimento = new ValidadorDadosObrigatoriosGrupoAtendimento();
		ValidadorFormatosPermitidosAnexo vrFormatosPermitidosAenxo = new ValidadorFormatosPermitidosAnexo();
		// ----------------------------------------------------------------------------------------------------------------------------------

		// Mapeando regras da Entidade Dominio: Categoria

		// Lista Regras de Negocio - SALVAR
		List<IStrategy> rnsSalvarCategoria = new ArrayList<IStrategy>();
		rnsSalvarCategoria.add(comDataCadastro);
		rnsSalvarCategoria.add(vrDadosObrigatoriosCategoria);

		// Lista Regras de Negocio - ALTERAR

		// Lista Regras de Negocio - EXCLUIR

		// HashMap (Operacao, ListaRegrasNegocio)
		Map<String, List<IStrategy>> rnsCategoria = new HashMap<String, List<IStrategy>>();
		rnsCategoria.put("SALVAR", rnsSalvarCategoria);

		// Insere no HashMap das Regras de Negocio
		regrasDeNegocio.put(Categoria.class.getName(), rnsCategoria);

		// Fim Categoria
		// ---------------------------------------------------------------------------------------------------------------------

		// Mapeando regras da Entidade Dominio: SubCategoria

		// Lista Regras de Negocio - SALVAR
		List<IStrategy> rnsSalvarSubCategoria = new ArrayList<IStrategy>();
		rnsSalvarSubCategoria.add(comDataCadastro);
		rnsSalvarSubCategoria.add(vrDadosObrigatoriosSubCategoria);

		// Lista Regras de Negocio - ALTERAR

		// Lista Regras de Negocio - EXCLUIR

		// HashMap (Operacao, ListaRegrasNegocio)
		Map<String, List<IStrategy>> rnsSubCategoria = new HashMap<String, List<IStrategy>>();
		rnsSubCategoria.put("SALVAR", rnsSalvarSubCategoria);

		// Insere no HashMap das Regras de Negocio
		regrasDeNegocio.put(SubCategoria.class.getName(), rnsSubCategoria);

		// Fim SubCategoria
		// ---------------------------------------------------------------------------------------------------------------------

		// Mapeando regras da Entidade Dominio: Chamado

		// Lista Regras de Negocio - SALVAR
		List<IStrategy> rnsSalvarChamado = new ArrayList<IStrategy>();
		rnsSalvarChamado.add(comDataCadastro);
		rnsSalvarChamado.add(vrDadosObrigatoriosChamado);

		// Lista Regras de Negocio - ALTERAR
		List<IStrategy> rnsAlterarChamado = new ArrayList<IStrategy>();
		rnsAlterarChamado.add(vrDadosObrigatoriosChamado);

		// HashMap (Operacao, ListaRegrasNegocio)
		Map<String, List<IStrategy>> rnsChamado = new HashMap<String, List<IStrategy>>();
		rnsChamado.put("SALVAR", rnsSalvarChamado);
		rnsChamado.put("ALTERAR", rnsAlterarChamado);

		// Insere no HashMap das Regras de Negocio
		regrasDeNegocio.put(Chamado.class.getName(), rnsChamado);

		// Fim Chamado
		// -----------------------------------------------------------------------------------------------------------------------------

		// Mapeando regras da Entidade Dominio: Conhecimento

		// Lista Regras de Negocio - SALVAR
		List<IStrategy> rnsSalvarConhecimento = new ArrayList<IStrategy>();
		rnsSalvarConhecimento.add(comDataCadastro);
		rnsSalvarConhecimento.add(vrDadosObrigatoriosConhecimento);

		// Lista Regras de Negocio - ALTERAR
		List<IStrategy> rnsAlterarConhecimento = new ArrayList<IStrategy>();
		rnsAlterarConhecimento.add(vrDadosObrigatoriosConhecimento);

		// HashMap (Operacao, ListaRegrasNegocio)
		Map<String, List<IStrategy>> rnsConhecimento = new HashMap<String, List<IStrategy>>();
		rnsConhecimento.put("SALVAR", rnsSalvarConhecimento);
		rnsConhecimento.put("ALTERAR", rnsAlterarConhecimento);

		// Insere no HashMap das Regras de Negocio
		regrasDeNegocio.put(Conhecimento.class.getName(), rnsConhecimento);

		// Fim Conhecimento
		// -----------------------------------------------------------------------------------------------------------------------------
		// Mapeando regras da Entidade Dominio: Funcionario

		// Lista Regras de Negocio - SALVAR
		List<IStrategy> rnsSalvarFuncionario = new ArrayList<IStrategy>();
		rnsSalvarFuncionario.add(comDataCadastro);
		rnsSalvarFuncionario.add(vrDadosObrigatoriosFuncionario);

		// Lista Regras de Negocio - ALTERAR
		List<IStrategy> rnsAlterarFuncionario = new ArrayList<IStrategy>();
		rnsAlterarFuncionario.add(vrDadosObrigatoriosFuncionario);

		// HashMap (Operacao, ListaRegrasNegocio)
		Map<String, List<IStrategy>> rnsFuncionario = new HashMap<String, List<IStrategy>>();
		rnsFuncionario.put("SALVAR", rnsSalvarFuncionario);
		rnsFuncionario.put("ALTERAR", rnsAlterarFuncionario);

		// Insere no HashMap das Regras de Negocio
		regrasDeNegocio.put(Funcionario.class.getName(), rnsFuncionario);

		// Fim Funcionario
		// -----------------------------------------------------------------------------------------------------------------------------

		// Mapeando regras da Entidade Dominio: GrupoAtendimento

		// Lista Regras de Negocio - SALVAR
		List<IStrategy> rnsSalvarGrupoAtendimento = new ArrayList<IStrategy>();
		rnsSalvarGrupoAtendimento.add(comDataCadastro);
		rnsSalvarGrupoAtendimento.add(vrDadosObrigatoriosGrupoAtendimento);

		// Lista Regras de Negocio - ALTERAR
		List<IStrategy> rnsAlterarGrupoAtendimento = new ArrayList<IStrategy>();
		rnsAlterarGrupoAtendimento.add(vrDadosObrigatoriosGrupoAtendimento);

		// HashMap (Operacao, ListaRegrasNegocio)
		Map<String, List<IStrategy>> rnsGrupoAtendimento = new HashMap<String, List<IStrategy>>();
		rnsGrupoAtendimento.put("SALVAR", rnsSalvarGrupoAtendimento);
		rnsGrupoAtendimento.put("ALTERAR", rnsAlterarGrupoAtendimento);

		// Insere no HashMap das Regras de Negocio
		regrasDeNegocio.put(GrupoAtendimento.class.getName(), rnsGrupoAtendimento);

		// Fim GrupoAtendimento
		// -----------------------------------------------------------------------------------------------------------------------------
		
		// Mapeando regras da Entidade Dominio: Anexo

		// Lista Regras de Negocio - SALVAR
		List<IStrategy> rnsSalvarAnexo = new ArrayList<IStrategy>();
		rnsSalvarAnexo.add(comDataCadastro);
		//rnsSalvarAnexo.add(vrDadosObrigatoriosAnexo);

		// Lista Regras de Negocio - ALTERAR
		List<IStrategy> rnsAlterarAnexo = new ArrayList<IStrategy>();
		//rnsAlterarAnexo.add(vrDadosObrigatoriosAnexo);

		// HashMap (Operacao, ListaRegrasNegocio)
		Map<String, List<IStrategy>> rnsAnexo = new HashMap<String, List<IStrategy>>();
		rnsAnexo.put("SALVAR", rnsSalvarAnexo);
		rnsAnexo.put("ALTERAR", rnsAlterarAnexo);

		// Insere no HashMap das Regras de Negocio
		regrasDeNegocio.put(Anexo.class.getName(), rnsAnexo);

		// Fim Anexo
		// -----------------------------------------------------------------------------------------------------------------------------

	}

	public Resultado salvar(EntidadeDominio entidade) {
		resultado = new Resultado();

		String msg = executarRegras(entidade, "SALVAR");

		if (msg == null) {
			DAOGenerico dao = new DAOGenerico();
			resultado = dao.salvar(entidade);
			List<EntidadeDominio> entidades = new ArrayList<EntidadeDominio>(1);
			entidades.add(entidade);
			resultado.setResultadoLista(entidades);
		} else {
			resultado.setMensagem(msg);
		}

		return resultado;
	}

	@Override
	public Resultado alterar(EntidadeDominio entidade) {
		resultado = new Resultado();

		String msg = executarRegras(entidade, "ALTERAR");

		if (msg == null) {
			DAOGenerico dao = new DAOGenerico();
			resultado = dao.alterar(entidade);
			List<EntidadeDominio> entidades = new ArrayList<EntidadeDominio>(1);
			entidades.add(entidade);
			resultado.setResultadoLista(entidades);
		} else {
			resultado.setMensagem(msg);
		}

		return resultado;
	}

	@Override
	public Resultado excluir(EntidadeDominio entidade) {
		resultado = new Resultado();

		String msg = executarRegras(entidade, "EXCLUIR");

		if (msg == null) {
			DAOGenerico dao = new DAOGenerico();
			resultado = dao.excluir(entidade);
			List<EntidadeDominio> entidades = new ArrayList<EntidadeDominio>(1);
			entidades.add(entidade);
			resultado.setResultadoLista(entidades);
		} else {
			resultado.setMensagem(msg);
		}

		return resultado;
	}

	@Override
	public Resultado consultar(EntidadeDominio entidade) {
		resultado = new Resultado();

		String msg = executarRegras(entidade, "SALVAR");

		if (msg == null) {
			DAOGenerico dao = new DAOGenerico();
			resultado = dao.salvar(entidade);
			List<EntidadeDominio> entidades = new ArrayList<EntidadeDominio>(1);
			entidades.add(entidade);
			resultado.setResultadoLista(entidades);
		} else {
			resultado.setMensagem(msg);
		}

		return resultado;
	}

	@Override
	public Resultado visualizar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	private String executarRegras(EntidadeDominio entidade, String operacao) {
		String nmClasse = entidade.getClass().getName();
		StringBuilder msg = new StringBuilder();

		Map<String, List<IStrategy>> regrasOperacao = regrasDeNegocio.get(nmClasse);

		if (regrasOperacao != null) {
			List<IStrategy> regras = regrasOperacao.get(operacao);

			if (regras != null) {
				for (IStrategy strategies : regras) {
					String mensagemValidacao = strategies.processar(entidade);

					if (mensagemValidacao != null) {
						msg.append(mensagemValidacao);
						msg.append("\n");
					}
				}
			}

		}

		if (msg.length() > 0)
			return msg.toString();
		else
			return null;
	}

}
