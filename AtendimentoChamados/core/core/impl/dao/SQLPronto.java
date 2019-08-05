package core.impl.dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import core.util.UnionList;
import dominio.entidadesdominio.EntidadeDominio;

public class SQLPronto {

	private List<String> sqlProntos = new ArrayList<String>();
	private LinkedHashMap<String, EntidadeDominio> mapSelect = new LinkedHashMap<String, EntidadeDominio>();

	public List<String> geraSqlInsert(EntidadeDominio entidade) {

		ManipuladorSQL sqlManipulado = new ManipuladorSQL();
		sqlManipulado = ManipuladorAtributos.GeraSqlManipulado(entidade);

		String sqlInsert = sqlManipulado.montaSqlInsert();

		this.sqlProntos.add(sqlInsert);

		LinkedHashMap<String, List<EntidadeDominio>> mapUmPraMuitos = ManipuladorAtributos
				.criarMapUmPraMuitos(entidade);

		if (mapUmPraMuitos.size() != 0) {
			List<String> sqlInsertsRelacionamento = new ArrayList<String>();
			SQLPronto sqlPronto = new SQLPronto();
			UnionList unionList = new UnionList();

			for (String key : mapUmPraMuitos.keySet()) {
				for (EntidadeDominio e : mapUmPraMuitos.get(key)) {
					sqlInsertsRelacionamento = sqlPronto.geraSqlInsert(e, key, entidade.getId());
					this.sqlProntos = unionList.union(this.sqlProntos, sqlInsertsRelacionamento);
				}
			}
		}
		return this.sqlProntos;
	}

	public List<String> geraSqlInsert(EntidadeDominio entidade, String colunaEstrangeira, Integer id) {

		ManipuladorSQL sqlManipulado = new ManipuladorSQL();
		sqlManipulado = ManipuladorAtributos.GeraSqlManipulado(entidade, colunaEstrangeira, id);

		String sqlInsert = sqlManipulado.montaSqlInsert();

		this.sqlProntos.add(sqlInsert);

		LinkedHashMap<String, List<EntidadeDominio>> mapUmPraMuitos = ManipuladorAtributos
				.criarMapUmPraMuitos(entidade);

		if (mapUmPraMuitos.size() != 0) {
			List<String> sqlInsertsRelacionamento = new ArrayList<String>();
			SQLPronto sqlPronto = new SQLPronto();
			UnionList unionList = new UnionList();

			for (String key : mapUmPraMuitos.keySet()) {
				for (EntidadeDominio e : mapUmPraMuitos.get(key)) {
					sqlInsertsRelacionamento = sqlPronto.geraSqlInsert(e, key, e.getId());
					this.sqlProntos = unionList.union(this.sqlProntos, sqlInsertsRelacionamento);
				}
			}
		}
		return this.sqlProntos;
	}

	public List<String> geraSqlUpdate(EntidadeDominio entidade) {

		ManipuladorSQL sqlManipulado = new ManipuladorSQL();
		sqlManipulado = ManipuladorAtributos.GeraSqlManipulado(entidade);

		String sqlUpdate = sqlManipulado.montaSqlUpdate();

		this.sqlProntos.add(sqlUpdate);

		LinkedHashMap<String, List<EntidadeDominio>> mapUmPraMuitos = ManipuladorAtributos
				.criarMapUmPraMuitos(entidade);

		if (mapUmPraMuitos.size() != 0) {
			List<String> sqlUpdatesRelacionamento = new ArrayList<String>();
			SQLPronto sqlPronto = new SQLPronto();
			UnionList unionList = new UnionList();

			for (String key : mapUmPraMuitos.keySet()) {
				for (EntidadeDominio e : mapUmPraMuitos.get(key)) {
					sqlUpdatesRelacionamento = sqlPronto.geraSqlUpdate(e, key, entidade.getId());
					this.sqlProntos = unionList.union(this.sqlProntos, sqlUpdatesRelacionamento);
				}
			}
		}
		return this.sqlProntos;
	}

	public List<String> geraSqlUpdate(EntidadeDominio entidade, String colunaEstrangeira, Integer id) {

		ManipuladorSQL sqlManipulado = new ManipuladorSQL();
		sqlManipulado = ManipuladorAtributos.GeraSqlManipulado(entidade, colunaEstrangeira, id);

		String sqlUpdate = sqlManipulado.montaSqlUpdate();

		this.sqlProntos.add(sqlUpdate);

		LinkedHashMap<String, List<EntidadeDominio>> mapUmPraMuitos = ManipuladorAtributos
				.criarMapUmPraMuitos(entidade);

		if (mapUmPraMuitos.size() != 0) {
			List<String> sqlUpdatesRelacionamento = new ArrayList<String>();
			SQLPronto sqlPronto = new SQLPronto();
			UnionList unionList = new UnionList();

			for (String key : mapUmPraMuitos.keySet()) {
				for (EntidadeDominio e : mapUmPraMuitos.get(key)) {
					sqlUpdatesRelacionamento = sqlPronto.geraSqlUpdate(e, key, e.getId());
					this.sqlProntos = unionList.union(this.sqlProntos, sqlUpdatesRelacionamento);
				}
			}
		}
		return this.sqlProntos;
	}

	public List<String> geraSqlDelete(EntidadeDominio entidade) {
		ManipuladorSQL sqlManipulado = new ManipuladorSQL();
		sqlManipulado = ManipuladorAtributos.GeraSqlManipulado(entidade);

		String sqlDelete = sqlManipulado.montaSqlDelete();

		this.sqlProntos.add(sqlDelete);

		LinkedHashMap<String, List<EntidadeDominio>> mapUmPraMuitos = ManipuladorAtributos
				.criarMapUmPraMuitos(entidade);

		if (mapUmPraMuitos.size() != 0) {
			List<String> sqlDeletesRelacionamento = new ArrayList<String>();
			SQLPronto sqlPronto = new SQLPronto();
			UnionList unionList = new UnionList();

			for (String key : mapUmPraMuitos.keySet()) {
				for (EntidadeDominio e : mapUmPraMuitos.get(key)) {
					sqlDeletesRelacionamento = sqlPronto.geraSqlDelete(e, key, entidade.getId());
					this.sqlProntos = unionList.union(this.sqlProntos, sqlDeletesRelacionamento);
				}
			}
		}
		return this.sqlProntos;
	}

	public List<String> geraSqlDelete(EntidadeDominio entidade, String colunaEstrangeira, Integer id) {
		ManipuladorSQL sqlManipulado = new ManipuladorSQL();
		sqlManipulado = ManipuladorAtributos.GeraSqlManipulado(entidade, colunaEstrangeira, id);

		String sqlDelete = sqlManipulado.montaSqlDelete();

		this.sqlProntos.add(sqlDelete);

		LinkedHashMap<String, List<EntidadeDominio>> mapUmPraMuitos = ManipuladorAtributos
				.criarMapUmPraMuitos(entidade);

		if (mapUmPraMuitos.size() != 0) {
			List<String> sqlDeletesRelacionamento = new ArrayList<String>();
			SQLPronto sqlPronto = new SQLPronto();
			UnionList unionList = new UnionList();

			for (String key : mapUmPraMuitos.keySet()) {
				for (EntidadeDominio e : mapUmPraMuitos.get(key)) {
					sqlDeletesRelacionamento = sqlPronto.geraSqlDelete(e, key, entidade.getId());
					this.sqlProntos = unionList.union(this.sqlProntos, sqlDeletesRelacionamento);
				}
			}
		}
		return this.sqlProntos;
	}

	public LinkedHashMap<String, EntidadeDominio> geraSqlSelect(EntidadeDominio entidade) {
		ManipuladorSQL sqlManipulado = new ManipuladorSQL();
		sqlManipulado = ManipuladorAtributos.GeraSqlManipulado(entidade);

		String sqlSelect = sqlManipulado.montaSqlSelect();

		this.sqlProntos.add(sqlSelect);

		LinkedHashMap<String, List<EntidadeDominio>> mapUmPraMuitos = ManipuladorAtributos
				.criarMapUmPraMuitos(entidade);

		if (mapUmPraMuitos.size() != 0) {
			LinkedHashMap<String, EntidadeDominio> sqlSelectRelacionamento = new LinkedHashMap<String, EntidadeDominio>();
			SQLPronto sqlPronto = new SQLPronto();

			for (String key : mapUmPraMuitos.keySet()) {
				for (EntidadeDominio e : mapUmPraMuitos.get(key)) {
					sqlSelectRelacionamento = sqlPronto.geraSqlSelect(e, key, entidade.getId());
					this.mapSelect.putAll(sqlSelectRelacionamento);
				}
			}
		}

		return this.mapSelect;
	}

	
	public LinkedHashMap<String, EntidadeDominio> geraSqlSelect(EntidadeDominio entidade, String colunaEstrangeira, Integer id) {
		ManipuladorSQL sqlManipulado = new ManipuladorSQL();
		sqlManipulado = ManipuladorAtributos.GeraSqlManipulado(entidade, colunaEstrangeira, id);

		String sqlSelect = sqlManipulado.montaSqlSelect();

		this.sqlProntos.add(sqlSelect);

		LinkedHashMap<String, List<EntidadeDominio>> mapUmPraMuitos = ManipuladorAtributos
				.criarMapUmPraMuitos(entidade);

		if (mapUmPraMuitos.size() != 0) {
			LinkedHashMap<String, EntidadeDominio> sqlSelectRelacionamento = new LinkedHashMap<String, EntidadeDominio>();
			SQLPronto sqlPronto = new SQLPronto();

			for (String key : mapUmPraMuitos.keySet()) {
				for (EntidadeDominio e : mapUmPraMuitos.get(key)) {
					sqlSelectRelacionamento = sqlPronto.geraSqlSelect(e, key, entidade.getId());
					this.mapSelect.putAll(sqlSelectRelacionamento);
				}
			}
		}

		return this.mapSelect;
	}

}
