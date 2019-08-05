CREATE TABLE CATEGORIA(
	IDCATEGORIA INT PRIMARY KEY AUTO_INCREMENT,
	DATACRIACAO DATE NOT NULL,
	NOME VARCHAR(30) NOT NULL,
	STATUS BOOLEAN DEFAULT TRUE
);

CREATE TABLE SUBCATEGORIA(
	IDSUBCATEGORIA INT PRIMARY KEY AUTO_INCREMENT,
	DATACRIACAO DATE NOT NULL,
	NOME VARCHAR(30) NOT NULL,
	STATUS BOOLEAN DEFAULT TRUE,
	HORASATENDIMENTO INT NOT NULL
);

CREATE TABLE FUNCIONARIO(
	IDFUNCIONARIO INT PRIMARY KEY AUTO_INCREMENT,
	DATACRIACAO DATE NOT NULL,
	NOME VARCHAR(30) NOT NULL,
	MATRICULA VARCHAR(15) NOT NULL,
	EMAIL VARCHAR(30) NOT NULL,
	STATUS BOOLEAN DEFAULT TRUE,
	DATANASCIMENTO DATE NOT NULL,
	ID_SETOR INT NOT NULL,
	FOREIGN KEY(ID_SETOR)
	REFERENCES SETOR(IDSETOR)
);

CREATE TABLE INATIVACAOFUNCIONARIO(
	IDINATIVACAOFUNCIONARIO INT PRIMARY KEY AUTO_INCREMENT,
	DATACRIACAO DATE NOT NULL,
	MOTIVO VARCHAR(30) NOT NULL,
	ID_FUNCIONARIO INT NOT NULL,
	FOREIGN KEY(ID_FUNCIONARIO)
	REFERENCES FUNCIONARIO(IDFUNCIONARIO)
);

CREATE TABLE CHAMADO(
	IDCHAMADO INT PRIMARY KEY AUTO_INCREMENT,
	DATACRIACAO DATE NOT NULL,
	DESCRICAO VARCHAR(30) NOT NULL,
	STATUSCHAMADO ENUM('ABERTO','FINALIZADO','EM_CANCELAMENTO','CANCELADO') DEFAULT 'ABERTO',
	ATENDIMENTOREALIZADO VARCHAR(30) NOT NULL,
	DATAFECHAMENTO DATE,
	CRIADORCHAMADO INT NOT NULL,
	DONOCHAMADO INT NOT NULL,
	ATENDENTECHAMADO INT,
	ID_CATEGORIA INT,
	ID_SUBCATEGORIA INT,
	ID_TRIAGEM INT DEFAULT 1,
	FOREIGN KEY(CRIADORCHAMADO)
	REFERENCES USUARIO(IDUSUARIO),
	FOREIGN KEY(DONOCHAMADO)
	REFERENCES USUARIO(IDUSUARIO),
	FOREIGN KEY(ATENDENTECHAMADO)
	REFERENCES USUARIO(IDUSUARIO),
	FOREIGN KEY(ID_CATEGORIA)
	REFERENCES CATEGORIA(IDCATEGORIA),
	FOREIGN KEY(ID_SUBCATEGORIA)
	REFERENCES SUBCATEGORIA(IDSUBCATEGORIA),
	FOREIGN KEY(ID_TRIAGEM)
	REFERENCES TRIAGEM(IDTRIAGEM)
);

CREATE TABLE PEDIDOCANCELAMENTO(
	IDPEDIDOCANCELAMENTO INT PRIMARY KEY AUTO_INCREMENT,
	DATACRIACAO DATE NOT NULL,
	MOTIVO VARCHAR(30) NOT NULL,
	ID_CHAMADO INT NOT NULL,
	FOREIGN KEY(ID_CHAMADO)
	REFERENCES CHAMADO(ID_CHAMADO)
);

CREATE TABLE GRUPOATENDIMENTO(
	IDCONHECIMENTO INT PRIMARY KEY AUTO_INCREMENT,
	DATACRIACAO DATE NOT NULL,
	NOME VARCHAR(30) NOT NULL,
	STATUS BOOLEAN DEFAULT TRUE
);

CREATE TABLE TRIAGEM(
	IDTRIAGEM INT PRIMARY KEY AUTO_INCREMENT,
	DATACRIACAO DATE NOT NULL,
	ID_GRUPOATENDIMENTO INT,
	FOREIGN KEY(ID_GRUPOATENDIMENTO)
	REFERENCES GRUPOATENDIMENTO(IDGRUPOATENDIMENTO)	
);

CREATE TABLE CONHECIMENTO(
	IDCONHECIMENTO INT PRIMARY KEY AUTO_INCREMENT,
	DATACRIACAO DATE NOT NULL,
	NOME VARCHAR(30) NOT NULL,
	DESCRICAO VARCHAR(30) NOT NULL,
	STATUSCONHECIMENTO ENUM('ATIVADO','INATIVADO','PENDENTE_APROVACAO','PENDENTE_ALTERACAO') DEFAULT 'PENDENTE_APROVACAO'
);

CREATE TABLE CONHECIMENTO_TAG(
	IDCONHECIMENTO_TAG INT PRIMARY KEY AUTO_INCREMENT,
	ID_CONHECIMENTO INT NOT NULL,
	ID_TAG INT NOT NULL,
	FOREIGN KEY(ID_CONHECIMENTO)
	REFERENCES CONHECIMENTO(IDCONHECIMENTO),
	FOREIGN KEY(ID_TAG)
	REFERENCES TAG(IDTAG)
);

CREATE TABLE TAG(
	IDTAG INT PRIMARY KEY AUTO_INCREMENT,
	DATACRIACAO DATE NOT NULL,
	NOME VARCHAR(30) NOT NULL
);

CREATE TABLE REGIONAL(
	IDREGIONAL INT PRIMARY KEY AUTO_INCREMENT,
	DATACRIACAO DATE NOT NULL,
	ESTADO VARCHAR(30) NOT NULL,
	CIDADE VARCHAR(30) NOT NULL,
	PAIS VARCHAR(30) NOT NULL,
);

CREATE TABLE SETOR(
	IDSETOR INT PRIMARY KEY AUTO_INCREMENT,
	DATACRIACAO DATE NOT NULL,
	NOME VARCHAR(30) NOT NULL,
	ID_REGIONAL INT NOT NULL,
	ID_TELEFONE INT NOT NULL,
	FOREIGN KEY(ID_REGIONAL)
	REFERENCES REGIONAL(IDREGIONAL),
	FOREIGN KEY(ID_TELEFONE)
	REFERENCES TELEFONE(IDTELEFONE)
);

CREATE TABLE TELEFONE(
	IDTELEFONE INT PRIMARY KEY AUTO_INCREMENT,
	NUMERO VARCHAR(10) NOT NULL,
	CODIGOOPERADORA CHAR(2) NOT NULL
);

CREATE TABLE ANEXO(
	IDANEXO INT PRIMARY KEY AUTO_INCREMENT,
	DATACRIACAO DATE NOT NULL,
	NOME VARCHAR(30) NOT NULL,
	CAMINHO VARCHAR(30) NOT NULL,
	EXTENSAO CHAR(4) NOT NULL,
	LEGENDA VARCHAR(30),
	ID_CHAMADO INT,
	FOREIGN KEY(ID_CHAMADO)
	REFERENCES CHAMADO(IDCHAMADO)
);