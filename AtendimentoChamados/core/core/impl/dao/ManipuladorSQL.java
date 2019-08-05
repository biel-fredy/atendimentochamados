package core.impl.dao;

import java.util.Map;

import core.util.db.DbException;

public class ManipuladorSQL {

	private String sqlColunas = "";
	private String sqlWhere = "";
	private String sqlNomeTabela = "";
	private String sqlValues = "";
	private Map<String, String> mapColunasCampos;
	
	public ManipuladorSQL() {
	}
		
	public String getSqlNomeTabela() {
		return sqlNomeTabela;
	}

	public void setSqlNomeTabela(String sqlNomeTabela) {
		this.sqlNomeTabela = sqlNomeTabela;
	}
	
	public Map<String, String> getMapColunasCampos() {
		return mapColunasCampos;
	}

	public void setMapColunasCampos(Map<String, String> mapColunasCampos) {
		this.mapColunasCampos = mapColunasCampos;
	}
	
	//---------------------------------------------------------SQL trechos
	
	public void montaSqlColunas() {
		for (String key : mapColunasCampos.keySet()) {
			this.sqlColunas += key + ", ";
		}
	}

	public void montaSqlValues() {
		for (String key : mapColunasCampos.keySet()) {
			this.sqlValues += mapColunasCampos.get(key) + ", ";
		}
	}
	
	public void montaSqlWhere() {
		for (String key : mapColunasCampos.keySet()) {
			if (mapColunasCampos.get(key) != null) {
				this.sqlWhere += key + " = " + mapColunasCampos.get(key) + ", ";
			}
		}
	}
	
	//---------------------------------------------------------CRUD
	public String montaSqlUpdate() {
		String keyId = "id" + sqlNomeTabela;
		String sqlUpdate = "update " 
							+ sqlNomeTabela 
							+ " set ";
		for (String key : mapColunasCampos.keySet()) {
			if (!key.equals(keyId) ) {
				sqlUpdate += key + " = " + mapColunasCampos.get(key) + ", ";
			}
		}
		sqlUpdate = sqlUpdate.substring(0, sqlUpdate.length() - 2);
		if (mapColunasCampos.containsKey(keyId)) {
			sqlUpdate += " where " + keyId + " = " + mapColunasCampos.get(keyId);
		}
		else {
			throw new DbException("Não é possível realizar um update sem WHERE!");
		}
		return sqlUpdate;
	}

	public String montaSqlInsert() {
		String sqlInsert = "insert into " + sqlNomeTabela + " (";
		sqlColunas = sqlColunas.substring(0, sqlColunas.length() - 2);
		sqlValues = sqlValues.substring(0, sqlValues.length() - 2);
		sqlInsert += sqlColunas + ") values (" + sqlValues + ")"; 
		return sqlInsert;
	}

	public String montaSqlDelete() {
		String sqlDelete = "delete from " + sqlNomeTabela;
		if (!sqlWhere.isBlank()) {
			sqlWhere = sqlWhere.substring(0, sqlWhere.length() - 2);
			sqlDelete += " where " + sqlWhere;
		}
		else {
			throw new DbException("Não é possível realizar um delete sem WHERE!");
		}
		return sqlDelete;
	}

	public String montaSqlSelect() {
		String sqlSelect = "select ";
		sqlColunas = sqlColunas.substring(0, sqlColunas.length() - 2);
		sqlSelect += sqlColunas + " from " + sqlNomeTabela;
		if (!sqlWhere.isBlank()) {
			sqlWhere = sqlWhere.substring(0, sqlWhere.length() - 2);
			sqlSelect += " where " + sqlWhere;
		}
		return sqlSelect;
	}

	@Override
	public String toString() {
		return "ResultadoSQL [sqlColunas = " + sqlColunas + ", sqlWhere = " + sqlWhere + ", sqlNomeTabela = " + sqlNomeTabela
				+ "]";
	}
}
