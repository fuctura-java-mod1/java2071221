package fuctura.repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ClienteRepositorio {

	public void inserir(Connection conexao) throws SQLException {
		Statement stm = conexao.createStatement();
		String comandoSQL = "insert into cliente (nome, cpf, email, idade)\n"
				+ " values ('Maria', '999', 'm@gmai', 50)";

		stm.execute(comandoSQL);

	}

	// public void alterar();
	// public void excluir();
	// public List listarTodos();

}
