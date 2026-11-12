# 🩺 Sistema Consultório

Aplicação desktop em **Java Swing** com **Maven**, feita para a disciplina de Programação Orientada a Objetos. Ela gerencia um consultório de psicologia e permite:

- fazer login como psicólogo;
- cadastrar psicólogos e pacientes (com foto);
- listar e buscar pacientes;
- registrar a anamnese de um paciente;
- registrar sessões (data, queixas, plano de tratamento, evolução, pagamento).

Os dados ficam em um banco **MySQL**, acessado por **JDBC**.

---

## 📁 Estrutura do projeto

```
Consultorio/
├── pom.xml                         # dependências Maven (driver MySQL)
└── src/main/
    ├── java/
    │   ├── apresentacao/           # telas Swing (fmLogin, fmPrincipal, fmPaciente, ...)
    │   ├── Negocio/                # classes de modelo (Paciente, Psicologo, Anamnese, Sessao)
    │   └── Persistencia/           # acesso ao banco (ConFactory + DAOs)
    └── resources/Recursos/         # ícones usados nas telas
```

O código segue uma arquitetura em três camadas:

| Camada | Pacote | Responsabilidade |
|---|---|---|
| Apresentação | `apresentacao` | Telas e interação com o usuário |
| Negócio | `Negocio` | Objetos do domínio (getters/setters) |
| Persistência | `Persistencia` | SQL e conexão com o MySQL (padrão DAO) |

---

## ✅ Pré-requisitos

- **JDK 24** (o `pom.xml` usa `maven.compiler.release = 24`)
- **Maven 3.9+**, ou uma IDE com Maven embutido (NetBeans, IntelliJ, VS Code)
- **MySQL Server 8.x**, mais o MySQL Workbench ou o cliente `mysql` para rodar os scripts

---

## 🗄️ Integração com o MySQL

### Como funciona

A integração tem três partes.

**1. Driver JDBC.** O `pom.xml` declara a dependência do conector oficial do MySQL, e o Maven baixa o driver automaticamente:

```xml
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.33</version>
</dependency>
```

**2. Fábrica de conexões.** [`Persistencia/ConFactory.java`](Consultorio/src/main/java/Persistencia/ConFactory.java) é a única classe que sabe onde o banco está. Ela usa `DriverManager` para abrir a conexão:

```java
public Connection getConnection() {
    try {
        return DriverManager.getConnection(
            "jdbc:mysql://localhost/dbconsultorio", // URL: host + nome do banco
            "root",                                 // usuário do MySQL
            "SUA_SENHA");                           // senha do MySQL
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}
```

**3. DAOs (Data Access Objects).** Existe um DAO para cada tabela: `PacienteDAO`, `PsicologoDAO`, `AnamneseDAO` e `SessaoDAO`. Cada um implementa uma interface (`IPacienteDAO`, ...) e segue estes passos:

1. no construtor, pede uma conexão à `ConFactory`;
2. monta o SQL com parâmetros `?`;
3. preenche os parâmetros com um `PreparedStatement`, o que evita SQL Injection;
4. executa (`execute()` para INSERT, `executeQuery()` para SELECT);
5. no caso de SELECT, percorre o `ResultSet` e converte cada linha em um objeto do pacote `Negocio`.

Exemplo, tirado de `PacienteDAO.adiciona`:

```java
String sql = "insert into paciente (nome, cpf, data_nascimento, ...) values (?, ?, ?, ...)";
PreparedStatement stmt = connection.prepareStatement(sql);
stmt.setString(1, paciente.getNome());
stmt.setString(2, paciente.getCpf());
stmt.setDate(3, new java.sql.Date(paciente.getData_nascimento().getTimeInMillis()));
...
stmt.execute();
stmt.close();
```

Fluxo de uma operação:

```
Tela (fmPaciente) ──► Objeto (Paciente) ──► PacienteDAO.adiciona() ──► ConFactory ──► MySQL
```

### Passo a passo para configurar

#### 1. Criar o banco e as tabelas

Rode o script abaixo no MySQL Workbench ou no terminal (`mysql -u root -p < script.sql`). Os nomes das colunas são os mesmos usados nos DAOs.

```sql
CREATE DATABASE IF NOT EXISTS dbconsultorio
  DEFAULT CHARACTER SET utf8mb4;
USE dbconsultorio;

CREATE TABLE psicologo (
  idPsicologo INT AUTO_INCREMENT PRIMARY KEY,
  nome        VARCHAR(100) NOT NULL,
  cpf         VARCHAR(14)  NOT NULL,
  crp         VARCHAR(20)  NOT NULL,
  telefone    VARCHAR(20),
  login       VARCHAR(50)  NOT NULL UNIQUE,
  senha       VARCHAR(100) NOT NULL
);

CREATE TABLE paciente (
  idPaciente      INT AUTO_INCREMENT PRIMARY KEY,
  nome            VARCHAR(100) NOT NULL,
  cpf             VARCHAR(14)  NOT NULL,
  data_nascimento DATE,
  sexo            VARCHAR(20),
  endereco        VARCHAR(200),
  telefone        VARCHAR(20),
  foto            VARCHAR(255),
  plano_saude     VARCHAR(100),
  observacoes     TEXT,
  data_cadastro   DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE anamnese (
  idAnamnese             INT AUTO_INCREMENT PRIMARY KEY,
  queixas                TEXT,
  sintomas               TEXT,
  tratamentos_anteriores TEXT,
  medicamentos           TEXT,
  infancia               TEXT,
  rotina                 TEXT,
  vicios                 TEXT,
  hobbies                TEXT,
  trabalho               TEXT,
  historico_familiar     TEXT,
  comportamento          TEXT,
  linguagem              TEXT,
  humor                  TEXT,
  hipotese_diagnostica   TEXT,
  observacoes            TEXT,
  numero_sessoes         INT,
  valor_sessao           DECIMAL(10,2),
  periodicidade          VARCHAR(50),
  idPaciente             INT NOT NULL,
  idPsicologo            INT NOT NULL,
  FOREIGN KEY (idPaciente)  REFERENCES paciente(idPaciente),
  FOREIGN KEY (idPsicologo) REFERENCES psicologo(idPsicologo)
);

CREATE TABLE sessao (
  idSessao          INT AUTO_INCREMENT PRIMARY KEY,
  data              DATETIME NOT NULL,
  queixas_paciente  TEXT,
  plano_tratamento  TEXT,
  diagnostico_final TEXT,
  resumo_sessao     TEXT,
  evolucao          INT,
  pago              BOOLEAN DEFAULT FALSE,
  idAnamnese        INT NULL,
  FOREIGN KEY (idAnamnese) REFERENCES anamnese(idAnamnese)
);
```

> ℹ️ Hoje o `SessaoDAO` ainda não grava `idAnamnese`, por isso a coluna aparece como `NULL` no script. Quando o vínculo for implementado no código, troque para `NOT NULL`.

#### 2. Criar o primeiro psicólogo para conseguir logar

A tela de login (`PsicologoDAO.autenticar`) procura o login e a senha na tabela `psicologo`. Antes do primeiro acesso, insira um usuário:

```sql
INSERT INTO psicologo (nome, cpf, crp, telefone, login, senha)
VALUES ('Administrador', '000.000.000-00', '00/00000', '', 'admin', 'admin');
```

#### 3. Ajustar a conexão

Abra [`ConFactory.java`](Consultorio/src/main/java/Persistencia/ConFactory.java) e coloque o usuário e a senha do **seu** MySQL. Se o MySQL não estiver na porta padrão (3306) ou em outra máquina, ajuste também a URL:

```
jdbc:mysql://HOST:PORTA/dbconsultorio
```

Se aparecer um erro de fuso horário ou de SSL, use:

```
jdbc:mysql://localhost:3306/dbconsultorio?serverTimezone=America/Sao_Paulo&useSSL=false
```

> ⚠️ **Não suba a sua senha real para o GitHub.** Prefira usar um usuário próprio do banco em vez do `root`:
> ```sql
> CREATE USER 'consultorio'@'localhost' IDENTIFIED BY 'troque_esta_senha';
> GRANT ALL PRIVILEGES ON dbconsultorio.* TO 'consultorio'@'localhost';
> ```
> Outra opção é ler as credenciais de variáveis de ambiente com `System.getenv("DB_USER")` e `System.getenv("DB_PASS")`.

#### 4. Pasta das fotos

O cadastro de paciente copia a foto escolhida para `C:/fotos/` e grava esse caminho na coluna `foto`. Crie a pasta antes de usar:

```powershell
mkdir C:\fotos
```

---

## ▶️ Como executar

### Pela IDE (NetBeans / IntelliJ)
1. Abra a pasta `Consultorio` como projeto Maven.
2. Espere o Maven baixar as dependências.
3. Execute a classe **`apresentacao.fmLogin`** (tela de login).

### Pelo terminal
```bash
cd Consultorio
mvn clean compile
mvn exec:java -Dexec.mainClass=apresentacao.fmLogin
```

> O `exec.mainClass` do `pom.xml` aponta para `com.mycompany.consultorio.Consultorio`, uma classe que não existe. Por isso a classe principal é passada na linha de comando. Outra solução é trocar essa propriedade por `apresentacao.fmLogin`.

---

## 🛠️ Problemas comuns

| Erro | Causa provável | Solução |
|---|---|---|
| `Communications link failure` | MySQL não está rodando ou porta/host errados | Inicie o serviço do MySQL e confira a URL na `ConFactory` |
| `Access denied for user 'root'@'localhost'` | Usuário ou senha incorretos | Ajuste as credenciais na `ConFactory` |
| `Unknown database 'dbconsultorio'` | O banco não foi criado | Rode o script SQL do passo 1 |
| `Table 'dbconsultorio.xxx' doesn't exist` | Faltou criar alguma tabela | Rode o script completo |
| `Unknown column ...` | Nome de coluna diferente do usado no DAO | Use exatamente os nomes do script acima |
| `No suitable driver found` | Driver não baixado | Rode `mvn clean install` ou recarregue o projeto Maven |
| Login sempre falha | Tabela `psicologo` vazia | Faça o insert do passo 2 |

---

## 📌 Limitações conhecidas

- Os métodos `altera`, `remove` e `getByID` dos DAOs ainda não foram implementados.
- As senhas dos psicólogos são gravadas em texto puro. O ideal é usar hash (por exemplo, BCrypt).
- As conexões JDBC não são fechadas depois do uso. O ideal é usar `try-with-resources`.
