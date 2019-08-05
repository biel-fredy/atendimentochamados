package dominio.entidadesdominio;

import java.util.Date;

public class Funcionario extends EntidadeDominio {

	private String nome;
	private Integer matricula;
	private String email;
	private Boolean status;
	private Date dataNascimento;
	
	private Setor setor;

	private InativacaoFuncionario inativacaoFuncionario;
		
	public Funcionario() {
	}

	public Funcionario(String nome, Integer matricula) {
		this.nome = nome;
		this.matricula = matricula;
		this.status = true;
	}
	
	public Funcionario(Integer matricula, String nome, String email, Date dataNascimento) {
		this.nome = nome;
		this.matricula = matricula;
		this.email = email;
		this.status = true;
	}
	
	public Funcionario(Integer id, Integer matricula, String nome, String email, Date dataNascimento, Regional regional) {
		super(id);
		this.nome = nome;
		this.matricula = matricula;
		this.email = email;
		this.status = true;
	}
			
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Integer getMatricula() {
		return matricula;
	}
	
	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Boolean getStatus() {
		return status;
	}
	
	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public InativacaoFuncionario getInativacaoFuncionario() {
		return inativacaoFuncionario;
	}

	public void setInativacaoFuncionario(InativacaoFuncionario inativacaoFuncionario) {
		this.inativacaoFuncionario = inativacaoFuncionario;
	}	
}
