package dominio.entidadesdominio;

import java.util.ArrayList;
import java.util.List;

import core.util.anotacoes.UmPraMuitos;
import core.util.anotacoesenum.CascadeType;
import dominio.entidadesenum.StatusConhecimento;

public class Conhecimento extends EntidadeDominio {

	private String nome;
	private String descricao;
	private StatusConhecimento statusConhecimento;
	
	@UmPraMuitos(cascade = CascadeType.ALL)
	private List<Tag> tags = new ArrayList<Tag>();
	
	@UmPraMuitos(cascade = CascadeType.ALL)
	private List<Categoria> categoriasRelacionadas = new ArrayList<Categoria>();
		
	public void aprovarConhecimento() {
		setStatusConhecimento(StatusConhecimento.ATIVADO);
	}
	
	public void inativarConhecimento() {
		setStatusConhecimento(StatusConhecimento.INATIVADO);
	}	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public StatusConhecimento getStatusConhecimento() {
		return statusConhecimento;
	}

	public void setStatusConhecimento(StatusConhecimento statusConhecimento) {
		this.statusConhecimento = statusConhecimento;
	}
	
	public void addTag(Tag tag) {
		this.tags.add(tag);
	}
	
	public void removeTag(Tag tag) {
		this.tags.remove(tag);
	}
	
	public List<Tag> getTags() {
		return this.tags;
	}
	
	public void addCategoriaRelacionada(Categoria categoria) {
		this.categoriasRelacionadas.add(categoria);
	}
	
	public void removeCategoriaRelacionada(Categoria categoria) {
		this.categoriasRelacionadas.remove(categoria);
	}
	
	public List<Categoria> getCategoriasRelacionadas() {
		return this.categoriasRelacionadas;
	}

	
}
