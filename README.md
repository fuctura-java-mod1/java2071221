# java2071221

Repositório da turma de Java 2 (07/12/21)

## Aula 2

* Abrimos uma conexão com o SGBD da Oracle

* Utilizando o DriverManager e a classe Connection para abrir uma conexão:

<pre><code>
        String URL = "jdbc:oracle:thin:@localhost:1521:xe";
		String usuario = "fuctura";
		String senha = "123";
		
		Connection conexao = DriverManager.getConnection(URL, usuario, senha);
</code></pre>

* Criamos o nosso pacote de repositorios (repository)

* Criamos nosso primeiro repositório: ClienteRepositorio

* Inserimos os primeiros registros

- Utilizamos a classe Statement para inserir 1 registro fixo:

<pre><code>
       public void inserir(Connection conexao) throws SQLException {
		Statement stm = conexao.createStatement();
		String comandoSQL = "insert into cliente (nome, cpf, email, idade) values ('Maria', '999', 'm@gmai', 50)";

		stm.execute(comandoSQL);

	}
</code></pre>