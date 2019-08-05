package dominio.entidadesdominio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import core.util.anotacoes.MuitosPraUm;
import core.util.anotacoes.UmPraMuitos;
import core.util.anotacoesenum.CascadeType;
import dominio.entidadesenum.StatusChamado;

public class Chamado extends EntidadeDominio {
	
	private String descricao;
	private StatusChamado statusChamado;
	private String atendimentoRealizado;
	private Date dataFechamento;
	
	@MuitosPraUm(cascade = CascadeType.ALL, mappedBy = "criadorchamado", removerOrfao = false)
	private Usuario criadorChamado;
	
	@MuitosPraUm(cascade = CascadeType.ALL, mappedBy = "donochamado", removerOrfao = false)
	private Usuario donoChamado;
	
	@MuitosPraUm(cascade = CascadeType.ALL, mappedBy = "atendentechamado", removerOrfao = false)
	private Usuario atendenteChamado;
	
	@MuitosPraUm(cascade = CascadeType.ALL, mappedBy = "id_categoria", removerOrfao = false)
	private Categoria categoria;
	
	@MuitosPraUm(cascade = CascadeType.ALL, mappedBy = "id_subcategoria", removerOrfao = false)
	private SubCategoria subCategoria;
	
	@UmPraMuitos(cascade = CascadeType.ALL, mappedBy = "id_chamado")
	private List<Anexo> listaAnexos = new ArrayList<Anexo>();
	
	public void solicitarCancelamento() {
		setStatusChamado(StatusChamado.EM_CANCELAMENTO);
	}
	
	public Date calcularPrazoAtendimento() {
		if (subCategoria != null) {
			GregorianCalendar gc = new GregorianCalendar();
			gc.setTime(super.getDataCriacao());
		    gc.add(Calendar.HOUR, subCategoria.getHorasAtendimento());
		    Date prazoAtendimento = gc.getTime();
		    return prazoAtendimento;
		}
		return null;
	}
	
	public void fecharChamado() {
		this.dataFechamento = new Date();
		setStatusChamado(StatusChamado.FINALIZADO);
	}
		
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getAtendimentoRealizado() {
		return atendimentoRealizado;
	}
	public void setAtendimentoRealizado(String atendimentoRealizado) {
		this.atendimentoRealizado = atendimentoRealizado;
	}

	public Date getDataFechamento() {
		return dataFechamento;
	}
	public void setDataFechamento(Date dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	public StatusChamado getStatusChamado() {
		return statusChamado;
	}

	public void setStatusChamado(StatusChamado statusChamado) {
		this.statusChamado = statusChamado;
	}

	public Usuario getCriadorChamado() {
		return criadorChamado;
	}

	public void setCriadorChamado(Usuario criadorChamado) {
		this.criadorChamado = criadorChamado;
	}

	public Usuario getAtendenteChamado() {
		return atendenteChamado;
	}

	public void setAtendenteChamado(Usuario atendenteChamado) {
		this.atendenteChamado = atendenteChamado;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public SubCategoria getSubCategoria() {
		return subCategoria;
	}

	public void setSubCategoria(SubCategoria subCategoria) {
		this.subCategoria = subCategoria;
	}

	public List<Anexo> getListaAnexo() {
		return listaAnexos;
	}

	public void setListaAnexo(List<Anexo> listaAnexo) {
		this.listaAnexos = listaAnexo;
	}

	public Usuario getDonoChamado() {
		return donoChamado;
	}

	public void setDonoChamado(Usuario donoChamado) {
		this.donoChamado = donoChamado;
	}
	
	public void addAnexo(Anexo anexo) {
		this.listaAnexos.add(anexo);
	}
	
	public void removeAnexo(Anexo anexo) {
		this.listaAnexos.remove(anexo);
	}
		
	public int sizeListaAnexos() {
		return this.listaAnexos.size();
	}
	
	public List<Anexo> getListaAnexos(){
		return this.listaAnexos;
	}

}
