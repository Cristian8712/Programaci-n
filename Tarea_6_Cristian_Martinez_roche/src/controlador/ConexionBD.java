package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

	private static final String SERVIDOR = "jdbc:mysql://localhost:3306/";
	private static final String DATABASE = "fabrica";
	private static final String URLCOMPLETA = SERVIDOR + DATABASE;
	private static final String USUARIO = "java";
	private static final String PASSWORD = "javabbdd1.";

	private Connection conexion = null;

	public Connection conectar() {
		try {
			conexion = DriverManager.getConnection(URLCOMPLETA, USUARIO, PASSWORD);
			System.out.println("Conexión a base de datos realizada con éxito");
		} catch (SQLException e) {
			System.out.println("Conexión a base de datos fallida, sistema no listo");
			System.out.println(e.getClass());
			System.out.println(e.getMessage());
		}
		return conexion;
	}

	public void desconectar() {
		if (conexion != null) {
			try {
				conexion.close();
				System.out.println("Conexión con base de datos finalizada.");
			} catch (SQLException e) {
				System.err.println("Conexión con base datos no cerrada.Error.");
			}
		}
	}
}
