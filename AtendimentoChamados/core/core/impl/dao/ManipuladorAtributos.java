package core.impl.dao;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import core.util.anotacoes.Coluna;
import core.util.anotacoes.MuitosPraUm;
import core.util.anotacoes.NaoGravar;
import core.util.anotacoes.Tabela;
import core.util.anotacoes.UmPraMuitos;
import dominio.entidadesdominio.EntidadeDominio;

public class ManipuladorAtributos {

	public static ManipuladorSQL GeraSqlManipulado(EntidadeDominio entidade) {
		ManipuladorSQL resultado = new ManipuladorSQL();

		Map<String, String> mapColunas = GeraMapColunas(entidade);
		resultado.setSqlNomeTabela(GeraNomeTabela(entidade));
		resultado.setMapColunasCampos(mapColunas);
		resultado.montaSqlColunas();
		resultado.montaSqlWhere();
		resultado.montaSqlValues();

		return resultado;
	}

	public static ManipuladorSQL GeraSqlManipulado(EntidadeDominio entidade, String colunaEstrangeira, Integer id) {
		ManipuladorSQL resultado = new ManipuladorSQL();

		Map<String, String> mapColunas = GeraMapColunas(entidade);
		mapColunas.put(colunaEstrangeira, "'" + id.toString() + "'");
		resultado.setSqlNomeTabela(GeraNomeTabela(entidade));
		resultado.setMapColunasCampos(mapColunas);
		resultado.montaSqlColunas();
		resultado.montaSqlWhere();
		resultado.montaSqlValues();

		return resultado;
	}

	public static String GeraNomeTabela(EntidadeDominio entidade) {
		Class<? extends EntidadeDominio> classeDoObjeto = entidade.getClass();
		String nomeTabela;
		Tabela tabela = (Tabela) classeDoObjeto.getDeclaredAnnotation(Tabela.class);
		if (tabela != null) {
			nomeTabela = tabela.value();
		} else {
			nomeTabela = classeDoObjeto.getSimpleName().toLowerCase();
		}
		return nomeTabela;
	}

	public static Map<String, String> GeraMapColunas(EntidadeDominio entidade) {
		Class<? extends EntidadeDominio> classeDoObjeto = entidade.getClass();
		Class<?> sprClasseDoObjeto = classeDoObjeto.getSuperclass();
		Map<String, String> listaColunas = new LinkedHashMap<String, String>();
		String nomeColuna;
		String valorAtributo;

		for (Field atributoED : sprClasseDoObjeto.getDeclaredFields()) {
			NaoGravar naoGravar = (NaoGravar) atributoED.getDeclaredAnnotation(NaoGravar.class);
			if (null == naoGravar) {
				if ("id".equals(atributoED.getName())) {
					String nomeTabela = GeraNomeTabela(entidade);
					nomeColuna = atributoED.getName() + nomeTabela;
				} else {
					nomeColuna = atributoED.getName();
				}
				valorAtributo = GeraValorAtributo(atributoED, entidade);
				listaColunas.put(nomeColuna, valorAtributo);
			}
		}

		for (Field atributoE : classeDoObjeto.getDeclaredFields()) {
			NaoGravar naoGravar = (NaoGravar) atributoE.getDeclaredAnnotation(NaoGravar.class);
			UmPraMuitos umPraMuitos = (UmPraMuitos) atributoE.getDeclaredAnnotation(UmPraMuitos.class);
			// ChaveEstrangeira chaveEstrangeira = (ChaveEstrangeira)
			// atributoE.getDeclaredAnnotation(ChaveEstrangeira.class);
			if (naoGravar == null && umPraMuitos == null) {
				nomeColuna = GeraNomeColuna(atributoE);
				valorAtributo = GeraValorAtributo(atributoE, entidade);
				listaColunas.put(nomeColuna, valorAtributo);
			}
		}
		return listaColunas;
	}

	public static String GeraValorAtributo(Field atributo, EntidadeDominio entidade) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		// Annotations
		MuitosPraUm muitosPraUm = (MuitosPraUm) atributo.getDeclaredAnnotation(MuitosPraUm.class);

		String valorAtributo = null;
		atributo.setAccessible(true);
		try {
			if (atributo.get(entidade) != null) {

				valorAtributo = atributo.get(entidade).toString();
				if (muitosPraUm != null) {
					Object campoEntidade = atributo.getType().getConstructor().newInstance();
					campoEntidade = atributo.get(entidade);
					int id = 0;
					Field campoId = campoEntidade.getClass().getSuperclass().getDeclaredField("id");
					if (campoId.trySetAccessible()) {
						if (null != campoId.get(campoEntidade)) {
							id = (int) campoId.get(campoEntidade);
						}
					}
					campoId.setAccessible(false);
					valorAtributo = Integer.toString(id);
				} else if (isValidDate(valorAtributo)) {
					valorAtributo = sdf.format(atributo.get(entidade));
				} else if (!atributo.getType().equals(Boolean.class)) {
					valorAtributo = "'" + valorAtributo + "'";
				}

			}
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return valorAtributo;
	}

	public static String GeraNomeColuna(Field atributoE) {
		Coluna coluna = (Coluna) atributoE.getDeclaredAnnotation(Coluna.class);
		MuitosPraUm muitosPraUm = (MuitosPraUm) atributoE.getDeclaredAnnotation(MuitosPraUm.class);
		String nomeColuna = null;

		if (coluna != null) {
			nomeColuna = coluna.value();
		} else if (muitosPraUm != null) {
			nomeColuna = muitosPraUm.mappedBy();
		} else {
			nomeColuna = atributoE.getName();
		}
		return nomeColuna;
	}

	public static LinkedHashMap<String, List<EntidadeDominio>> criarMapUmPraMuitos(EntidadeDominio entidade) {
		LinkedHashMap<String, List<EntidadeDominio>> mapUmPraMuitos = new LinkedHashMap<String, List<EntidadeDominio>>();
		// List<List<EntidadeDominio>> listaUmPraMuitos = new
		// ArrayList<List<EntidadeDominio>>();
		List<EntidadeDominio> listaEntidades = new ArrayList<EntidadeDominio>();
		Class<? extends EntidadeDominio> classeEntidade = entidade.getClass();
		for (Field atributo : classeEntidade.getDeclaredFields()) {
			UmPraMuitos umPraMuitos = (UmPraMuitos) atributo.getDeclaredAnnotation(UmPraMuitos.class);
			if (umPraMuitos != null) {
				String nomeAtributo = atributo.getName();
				nomeAtributo = nomeAtributo.substring(0, 1).toUpperCase().concat(nomeAtributo.substring(1));
				String nomeMetodo = "get" + nomeAtributo;
				try {
					Method getLista = classeEntidade.getDeclaredMethod(nomeMetodo);
					listaEntidades = (List<EntidadeDominio>) getLista.invoke(entidade);
					mapUmPraMuitos.put(umPraMuitos.mappedBy(), listaEntidades);
				} catch (NoSuchMethodException | SecurityException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}

		}

		return mapUmPraMuitos;
	}

	public static List<EntidadeDominio> construtorEntidade(EntidadeDominio entidade, ResultSet resultadosQuery) {
		Class<? extends EntidadeDominio> classeDoObjeto = entidade.getClass();
		Class<?> sprClasseDoObjeto = classeDoObjeto.getSuperclass();
		List<EntidadeDominio> lista = new ArrayList<EntidadeDominio>();
		ManipuladorSQL sqlManipulado = new ManipuladorSQL();
		sqlManipulado = ManipuladorAtributos.GeraSqlManipulado(entidade);

		try {
			int numeroColunas = resultadosQuery.getMetaData().getColumnCount();
			while (resultadosQuery.next()) {
				Object obj = classeDoObjeto.getConstructor().newInstance();
				int coluna = 1;
				for (int i = 1; i <= numeroColunas; i++) {
					if (coluna <= sprClasseDoObjeto.getDeclaredFields().length) {
						for (Field atributoEntidadeDominio : sprClasseDoObjeto.getDeclaredFields()) {
							atributoEntidadeDominio.setAccessible(true);
							atributoEntidadeDominio.set(obj, resultadosQuery.getObject(coluna++));
							atributoEntidadeDominio.setAccessible(false);
						}
					} else {
						for (Field atributo : classeDoObjeto.getDeclaredFields()) {
							if (coluna <= sqlManipulado.getMapColunasCampos().size()) {
								MuitosPraUm muitosPraUm = atributo.getDeclaredAnnotation(MuitosPraUm.class);
								UmPraMuitos umPraMuitos = atributo.getDeclaredAnnotation(UmPraMuitos.class);
								atributo.setAccessible(true);
								if (muitosPraUm != null) {
									Object campoEntidade = atributo.getType().getConstructor().newInstance();
									int id = (int) resultadosQuery.getObject(coluna++);
									Method setId = campoEntidade.getClass().getSuperclass().getDeclaredMethod("setId",
											Integer.class);
									setId.invoke(campoEntidade, id);
									DAOGenerico dao = new DAOGenerico();
									List<EntidadeDominio> listaCampo = dao.consultar((EntidadeDominio) campoEntidade)
											.getResultadoLista();
									if (!listaCampo.isEmpty()) {
										campoEntidade = listaCampo.get(0);
									}
									atributo.set(obj, campoEntidade);
								} else if (umPraMuitos != null) {
									coluna++;
								} else if (atributo.getType().isEnum()) {
									Method valueOf = atributo.getType().getMethod("valueOf", String.class);
									Object value = valueOf.invoke(null, resultadosQuery.getObject(coluna++));
									atributo.set(obj, value);
								} else {
									atributo.set(obj, resultadosQuery.getObject(coluna++));
								}
								atributo.setAccessible(false);
							}
						}
					}
				}
				lista.add((EntidadeDominio) obj);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		
		return lista;

	}

	public static List<UmPraMuitos> temUmPraMuitos(EntidadeDominio entidade) {
		List<UmPraMuitos> listaAnotacoes = new ArrayList<UmPraMuitos>();

		for (Field atributo : entidade.getClass().getDeclaredFields()) {
			UmPraMuitos umPraMuitos = (UmPraMuitos) atributo.getDeclaredAnnotation(UmPraMuitos.class);
			if (umPraMuitos != null) {
				listaAnotacoes.add(umPraMuitos);
			}
		}

		return listaAnotacoes;
	}

	public static boolean isValidDate(String inDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.US);
		dateFormat.setLenient(false);
		try {
			dateFormat.parse(inDate.trim());
		} catch (ParseException pe) {
			return false;
		}
		return true;
	}

}
