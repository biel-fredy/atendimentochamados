package dominio.entidadesdominio;

import java.util.ArrayList;
import java.util.List;

public class Triagem extends EntidadeDominio{
	
	private List<Chamado> listaChamados = new ArrayList<Chamado>();
	
	private GrupoAtendimento grupoAtendimento;

	public GrupoAtendimento getGrupoAtendimento() {
		return grupoAtendimento;
	}

	public void setGrupoAtendimento(GrupoAtendimento grupoAtendimento) {
		this.grupoAtendimento = grupoAtendimento;
	}
	
	public void addChamado(Chamado chamado) {
		this.listaChamados.add(chamado);
	}
	
	public void removeChamado(Chamado chamado) {
		this.listaChamados.remove(chamado);
	}
	
	public int sizeListaChamados() {
		return this.listaChamados.size();
	}
	
	public List<Chamado> getListaChamados(){
		return new ArrayList<Chamado>(this.listaChamados);
	}

}
