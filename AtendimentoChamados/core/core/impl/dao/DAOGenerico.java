package core.impl.dao;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import core.IDao;
import core.aplicacao.Resultado;
import core.util.anotacoes.MuitosPraUm;
import core.util.anotacoes.UmPraMuitos;
import core.util.db.DB;
import dominio.entidadesdominio.EntidadeDominio;
import core.impl.dao.ManipuladorSQL;
import core.impl.dao.ManipuladorAtributos;

public class DAOGenerico implements IDao {

	@Override
	public Resultado salvar(EntidadeDominio entidade) {
		Resultado resultado = new Resultado();
		Connection conn = null;
		Statement st = null;

		try {
			SQLPronto sqlPronto = new SQLPronto();

			List<String> listaInserts = sqlPronto.geraSqlInsert(entidade);

			conn = DB.getConnection();
			st = conn.createStatement();

			int linhasAfetadas = 0;

			for (String sqlInsert : listaInserts) {
				linhasAfetadas += st.executeUpdate(sqlInsert);
			}

			if (linhasAfetadas != 0) {
				resultado.setMensagem("Cadastro realizado com sucesso. Linhas afetadas: " + linhasAfetadas + ".");
			} else {
				resultado.setMensagem("Falha ao salvar o cadastro. Contate o administrador do sistema.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			resultado.setMensagem("Falha ao salvar o cadastro. Contate o administrador do sistema.");
			return resultado;
		} finally {
			DB.closeStatement(st);
		}
		return resultado;
	}

	@Override
	public Resultado alterar(EntidadeDominio entidade) {
		Resultado resultado = new Resultado();
		Connection conn = null;
		Statement st = null;

		try {
			SQLPronto sqlPronto = new SQLPronto();

			List<String> listaUpdates = sqlPronto.geraSqlUpdate(entidade);

			conn = DB.getConnection();
			st = conn.createStatement();

			int linhasAfetadas = 0;

			for (String sqlUpdate : listaUpdates) {
				linhasAfetadas += st.executeUpdate(sqlUpdate);
			}

			if (linhasAfetadas != 0) {
				resultado.setMensagem("Alteração realizada com sucesso. Linhas afetadas: " + linhasAfetadas + ".");
			} else {
				resultado.setMensagem("Falha ao alterar o cadastro. Contate o administrador do sistema.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			resultado.setMensagem("Falha ao alterar o cadastro. Contate o administrador do sistema.");
			return resultado;
		} finally {
			DB.closeStatement(st);
		}
		return resultado;
	}

	@Override
	public Resultado excluir(EntidadeDominio entidade) {
		Resultado resultado = new Resultado();
		Connection conn = null;
		Statement st = null;
		try {
			SQLPronto sqlPronto = new SQLPronto();

			List<String> listaDeletes = sqlPronto.geraSqlDelete(entidade);

			// conn = DB.getConnection();
			// st = conn.createStatement();

			int linhasAfetadas = 0;

			for (String sqlDelete : listaDeletes) {
				// linhasAfetadas += st.executeUpdate(sqlDelete);
				System.out.println(sqlDelete);
			}

			if (linhasAfetadas != 0) {
				resultado.setMensagem("Exclusão realizada com sucesso. Linhas afetadas: " + linhasAfetadas + ".");
			} else {
				resultado.setMensagem("Falha ao excluir o cadastro. Contate o administrador do sistema.");
			}

		}
		/*
		 * catch (SQLException e) { e.printStackTrace(); resultado.
		 * setMensagem("Falha ao excluir o cadastro. Contate o administrador do sistema."
		 * ); return resultado; }
		 */
		finally {
			DB.closeStatement(st);
		}
		return resultado;
	}

	@Override
	public Resultado consultar(EntidadeDominio entidade) {
		Resultado resultado = new Resultado();
		Connection conn = null;
		Statement st = null;
		ResultSet resultadosQuery = null;
		List<EntidadeDominio> lista = new ArrayList<EntidadeDominio>();

		try {
			SQLPronto sqlPronto = new SQLPronto();

			LinkedHashMap<String, EntidadeDominio> mapSelects = sqlPronto.geraSqlSelect(entidade);
			
			conn = DB.getConnection();
			st = conn.createStatement();
			
			for (String key : mapSelects.keySet()) {
				ResultSet resultadoSelect = st.executeQuery(key);
				lista = ManipuladorAtributos.construtorEntidade(mapSelects.get(key), resultadoSelect);
				DB.closeResultSet(resultadoSelect);
			}
			
			resultado.setResultadoLista(lista);
			
			//resultado.setMensagem("Foram encontrados " + lista.size() + " objetos.");
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			resultado.setMensagem("Falha ao buscar o cadastro. Contate o administrador do sistema.");
			return resultado;
		} catch (SecurityException e) {
			e.printStackTrace();
			resultado.setMensagem("Falha ao buscar o cadastro. Contate o administrador do sistema.");
			return resultado;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DB.closeResultSet(resultadosQuery);
			DB.closeStatement(st);
			// DB.closeConnection();
		}

		return resultado;
	}

	@Override
	public Resultado consultarPorID(Integer id, EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

}
