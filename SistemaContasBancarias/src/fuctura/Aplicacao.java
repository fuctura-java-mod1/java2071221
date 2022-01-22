package fuctura;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import fuctura.model.Cliente;
import fuctura.repository.ClienteRepositorio;
import fuctura.util.DataSource;

public class Aplicacao {

	public static void main(String[] args) throws SQLException {

		DataSource fonteDeDados = new DataSource();

		Connection conexao = fonteDeDados.getConnection();

		System.out.println("Conectado com sucesso!");

		ClienteRepositorio repositorio = new ClienteRepositorio();

		repositorio.inserirComPreparatedStatement(null, null);

		System.out.println("Registro inserido com sucesso!");

		// usuario deve digitar a idade que ele deseja filtrar

		ArrayList<Cliente> resultado = repositorio.listarTodosPorIdade(conexao);

		exibirUsuarios(resultado);
	}

	public static void exibirUsuarios(ArrayList<Cliente> usuarios) {
		for (int i = 0; i < usuarios.size(); i++) {
			Cliente c = usuarios.get(i);
			System.out.println("Nome: " + c.getNome());
			System.out.println("Idade: " + c.getIdade());
		}
	}

}
