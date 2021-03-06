package fuctura.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fuctura.model.Cliente;

public class ClienteRepositorio {
	/*
	 * public void inserir(Connection conexao, Cliente c) throws SQLException {
	 * Statement stm = conexao.createStatement(); String comandoSQL =
	 * "insert into cliente (nome, cpf, email, idade)\n" + " values ('" +
	 * c.getNome() + "', '" + c.getCpf() ', 'm@gmai', 50)";
	 * 
	 * stm.execute(comandoSQL);
	 * 
	 * }
	 */

	// https://github.com/fuctura-java-mod1/java2071221
	public void inserirComPreparatedStatement(Connection conexao, Cliente c) throws SQLException {
		// 1 2 3 4
		String comandoSQL = "insert into cliente (nome, cpf, email, idade)\n" + " values (?, ?, ?, ?)";

		PreparedStatement pstm = conexao.prepareStatement(comandoSQL);

		pstm.setString(2, c.getCpf());
		pstm.setInt(4, c.getIdade());
		pstm.setString(1, c.getNome());
		pstm.setString(3, c.getEmail());

		pstm.execute();

	}

	// public void alterar();
	// public void excluir();
	// public List listarTodos();
	// https://github.com/fuctura-java-mod1/java2071221
	public ArrayList<Cliente> listarTodos(Connection conexao) throws SQLException {

		ArrayList<Cliente> clientesDaBase = new ArrayList<Cliente>();

		String comando = " select *  from cliente ";

		Statement stm = conexao.createStatement();

		ResultSet resultadoDaConsulta = stm.executeQuery(comando);

		while (resultadoDaConsulta.next()) {

			String nome = resultadoDaConsulta.getString(1);
			String cpf = resultadoDaConsulta.getString(4);
			String email = resultadoDaConsulta.getString(3);
			int idade = resultadoDaConsulta.getInt(2);

			Cliente cliente = new Cliente(nome, cpf, idade, email);

			clientesDaBase.add(cliente);

		}

		return clientesDaBase;
	}

	public ArrayList<Cliente> listarTodosPorIdade(Connection conexao) throws SQLException {
		ArrayList<Cliente> clientesDaBase = new ArrayList<Cliente>();

		String comando = " select *  from cliente where idade > 18 ";

		Statement stm = conexao.createStatement();

		ResultSet resultadoDaConsulta = stm.executeQuery(comando);

		while (resultadoDaConsulta.next()) {

			String nome = resultadoDaConsulta.getString(1);
			String cpf = resultadoDaConsulta.getString(4);
			String email = resultadoDaConsulta.getString(3);
			int idade = resultadoDaConsulta.getInt(2);

			Cliente cliente = new Cliente(nome, cpf, idade, email);

			clientesDaBase.add(cliente);

		}
		return clientesDaBase;
	}
}
