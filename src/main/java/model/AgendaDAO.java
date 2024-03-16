package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AgendaDAO {

	// Parametros de Conexao
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/dbagenda?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "81815720";

	// Metodo de Conexao
	private Connection conectar() {
		Connection con = null;

		try {
			Class.forName(driver); // ler o driver do banco de dados
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	// CRUD CREATE
	public void inserirContato(AgendaBean contato) {
		String scriptInsert = "INSERT INTO CONTATOS(NOME, FONE, EMAIL) VALUE (?, ?, ?);";

		try {
			// abrir a conexão
			Connection con = conectar();

			// Preparando a query
			PreparedStatement ps = con.prepareStatement(scriptInsert);
			ps.setString(1, contato.getNome());
			ps.setString(2, contato.getFone());
			ps.setString(3, contato.getEmail());

			// Executar a Query
			ps.executeUpdate();

			// Encerrar a conexão
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
