package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class AgendaDAO {
	
	// Parametros de Conexao
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/dbagenda?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "81815720";
	
	//Metodo de Conexao
	private Connection conectar() {
		Connection con = null;
		
		try {
			Class.forName(driver);  // ler o driver do banco de dados
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
}
