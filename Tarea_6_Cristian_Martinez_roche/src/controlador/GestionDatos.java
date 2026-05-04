package controlador;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import clases.Tecnico;

public class GestionDatos {

	private Connection conexion;

	public GestionDatos(Connection conexion) {
		this.conexion = conexion;
	}

	public void verEmpleados() {

		String consulta = "SELECT id, nombre, nºempleado, fecha_incorporacion, calle, nºcasa, localidad, rango, salario FROM tecnico";

		try {
			PreparedStatement sentencia = conexion.prepareStatement(consulta);
			ResultSet resultado = sentencia.executeQuery();

			while (resultado.next()) {
				System.out.printf(
						" EMPLEADO CON ID: %d\n" + "-------------------------------------------------\n"
								+ " Nombre:      %s\n" + " Nº Empleado: %d\n" + " Fecha Alta:  %s\n"
								+ " Dirección:   %s %d, %s\n" + " Cargo:       %s\n" + " Salario:     %.2f €\n"
								+ "-------------------------------------------------\n",
						resultado.getInt("id"), resultado.getString("nombre"), resultado.getInt("nºempleado"),
						resultado.getString("fecha_incorporacion"), resultado.getString("calle"),
						resultado.getInt("nºcasa"), resultado.getString("localidad"), resultado.getString("rango"),
						resultado.getDouble("salario"));

			}
		} catch (SQLException e) {
			System.out.println("Error al realizar la consulta" + e.getMessage());
		} catch (NullPointerException e) {
			System.out.println("Conexión no inicializada");
		}
	}

	public void insertarEmpleado(String nombre, int numEmpleado, String calle, int numCasa, String localidad,
			String rango, double salario) {
		String consulta = "INSERT INTO tecnico (nombre, nºempleado, calle, nºcasa, localidad, rango, salario) VALUES (?, ?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement sentencia = conexion.prepareStatement(consulta);
			sentencia.setString(1, nombre);
			sentencia.setInt(2, numEmpleado);
			sentencia.setString(3, calle);
			sentencia.setInt(4, numCasa);
			sentencia.setString(5, localidad);
			sentencia.setString(6, rango);
			sentencia.setDouble(7, salario);
			sentencia.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al realizar la inserción" + e.getMessage());
		} catch (NullPointerException e) {
			System.out.println("Conexión no inicializada");
		}
	}

	public String consultaNombre(int idTecnico) {
		String consulta = "SELECT nombre FROM tecnico WHERE id = ?";

		try {
			PreparedStatement sentencia = conexion.prepareStatement(consulta);
			sentencia.setInt(1, idTecnico);
			ResultSet resultado = sentencia.executeQuery();
			if (resultado.next()) {
				return resultado.getString("nombre");

			}
		} catch (Exception e) {
			System.out.println("Error al buscar al técnico" + e.getMessage());
		}
		return null;

	}

	public void eliminarEmpleado(String nombre) {

		String consulta = "DELETE FROM tecnico WHERE id = ?";

		try {
			PreparedStatement sentencia = conexion.prepareStatement(consulta);
			sentencia.setString(1, nombre);
			sentencia.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al eliminiar el tecnico" + e.getMessage());
		} catch (NullPointerException e) {
			System.out.println("Conexión no inicializada");
		}
	}

	public String consultaRango(String nombreAscenso) {

		String consulta = "SELECT rango FROM tecnico WHERE nombre = ?";
		try {
			PreparedStatement sentencia = conexion.prepareStatement(consulta);
			sentencia.setString(1, nombreAscenso);
			ResultSet resultado = sentencia.executeQuery();

			if (resultado.next()) {
				return resultado.getString("rango");
			}
		} catch (SQLException e) {

			System.out.println("Error al buscar el rango" + e.getMessage());
		}

		return null;

	}

	public void modificarRangoTecnico(String nuevoRango, String nombreAscenso) {

		String consulta = "UPDATE tecnico SET rango = ?, salario = salario * 1.15 WHERE nombre = ?";

		try {
			PreparedStatement sentencia = conexion.prepareStatement(consulta);
			sentencia.setString(1, nuevoRango);
			sentencia.setString(2, nombreAscenso);
			int filasAfectadas = sentencia.executeUpdate();

			if (filasAfectadas == 0) {
				System.out.println("Error no se pudo realizar el ascenso en la BBDD.");
			}

		} catch (SQLException e) {
			System.out.println("Error al actualizar el rango y el salario" + e.getMessage());
		}
	}

	public void verMaquinas() {
		String consulta = "SELECT id, nombre, tipo, modelo, nºserie, producto_dia, potencia, tiempo_marcha, rendimiento FROM maquina";

		try {
			PreparedStatement sentencia = conexion.prepareStatement(consulta);
			ResultSet resultado = sentencia.executeQuery();

			while (resultado.next()) {
				System.out.printf(
						" MAQUINA CON ID: %d\n" + "-------------------------------------------------\n"
								+ " Nombre:      %s\n" + " Tipo: %s\n" + " Modelo:  %s\n" + " Número de serie:   %s\n"
								+ " Producción estimada: %d diaria\n" + " Potencia:  %s\n"
								+ " Tiempo en marcha planificado: %s\n" + " Rendimiento %s\n"
								+ "-------------------------------------------------\n",
						resultado.getInt("id"), resultado.getString("nombre"), resultado.getString("tipo"),
						resultado.getString("modelo"), resultado.getString("nºserie"), resultado.getInt("producto_dia"),
						resultado.getString("potencia"), resultado.getString("tiempo_marcha"),
						resultado.getString("rendimiento"));

			}
		} catch (SQLException e) {
			System.out.println("Error al realizar la consulta: " + e.getMessage());
		} catch (NullPointerException e) {
			System.out.println("Conexión no inicializada");
		}

	}

	public void insertarMaquina(String nombre, String tipo, String modelo, String numSerie, int productoDia,
			String potencia, long tiempo_marcha) {
		String consulta = "INSERT INTO maquina (nombre, tipo, modelo, nºserie, producto_dia, potencia, tiempo_marcha) VALUES (?, ?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement sentencia = conexion.prepareStatement(consulta);
			sentencia.setString(1, nombre);
			sentencia.setString(2, tipo);
			sentencia.setString(3, modelo);
			sentencia.setString(4, numSerie);
			sentencia.setInt(5, productoDia);
			sentencia.setString(6, potencia);
			sentencia.setLong(7, tiempo_marcha);
			sentencia.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al realizar la inserción" + e.getMessage());
		} catch (NullPointerException e) {
			System.out.println("Conexión no inicializada");
		}

	}

	public void intervencionesGeneral() {
		String consulta = "SELECT nºregistro, motivo, tipo, fecha_solicitud, fecha_realizacion, hora_inicio, hora_fin, tiempo_parada FROM intervencion";

		try {
			PreparedStatement sentencia = conexion.prepareStatement(consulta);
			ResultSet resultado = sentencia.executeQuery();

			while (resultado.next()) {

				System.out.printf(
						" INTERVENCIÓN CON Nº DE REGISTRO: %s\n" + "-------------------------------------------------\n"
								+ " Motivo:      %s\n" + " Tipo: %s\n" + " Fecha de solicitud:  %s\n"
								+ " Fecha de realización:   %s\n" + " Hora de inicio: %s\n"
								+ " Hora de finalización:  %s\n" + " Tiempo total de parada: %s\n"
								+ "-------------------------------------------------\n",
						resultado.getString("nºregistro"), resultado.getString("motivo"), resultado.getString("tipo"),
						resultado.getString("fecha_solicitud"), resultado.getString("fecha_realizacion"),
						resultado.getString("hora_inicio"), resultado.getString("hora_fin"),
						resultado.getString("tiempo_parada"));
			}

		} catch (SQLException e) {
			System.out.println("Error al realizar la consulta");
			System.out.println("Error al realizar la consulta: " + e.getMessage());
		} catch (NullPointerException e) {
			System.out.println("Conexión no inicializada");
		}

	}

	public void intervencionesMaquina(int idMaquina) {
		String consulta = "SELECT nºregistro, motivo, tipo, fecha_solicitud, fecha_realizacion, hora_inicio, hora_fin, tiempo_parada FROM intervencion WHERE id_maquina = ?";

		try {
			PreparedStatement sentencia = conexion.prepareStatement(consulta);
			sentencia.setInt(1, idMaquina);
			ResultSet resultado = sentencia.executeQuery();
			boolean hayIntervenciones = false;

			while (resultado.next()) {

				hayIntervenciones = true;

				System.out.printf(
						" INTERVENCIÓN CON Nº DE REGISTRO: %s\n" + "-------------------------------------------------\n"
								+ " Motivo:      %s\n" + " Tipo: %s\n" + " Fecha de solicitud:  %s\n"
								+ " Fecha de realización:   %s\n" + " Hora de inicio: %s\n"
								+ " Hora de finalización:  %s\n" + " Tiempo total de parada: %s\n"
								+ "-------------------------------------------------\n",
						resultado.getString("nºregistro"), resultado.getString("motivo"), resultado.getString("tipo"),
						resultado.getString("fecha_solicitud"), resultado.getString("fecha_realizacion"),
						resultado.getString("hora_inicio"), resultado.getString("hora_fin"),
						resultado.getString("tiempo_parada"));

			}
			if (!hayIntervenciones) {
				System.out.println("==> No se han encontrado intervenciones para está máquina. <==");
				System.out.println("==> Puede que el ID no exista o que la máquina no tenga averías registradas. <==");

			}
		} catch (SQLException e) {
			System.out.println("Error al realizar la consulta");
			System.out.println("Error al realizar la consulta: " + e.getMessage());
		} catch (NullPointerException e) {
			System.out.println("Conexión no inicializada");
		}

	}

	public void costesGlobales() {
		String consulta = "SELECT SUM(intervencion_usa_repuesto.cantidad_usada * repuesto.precio) AS coste_total "
				+ " FROM intervencion_usa_repuesto "
				+ " INNER JOIN repuesto ON intervencion_usa_repuesto.id_repuesto = repuesto.id ";

		try {
			PreparedStatement sentencia = conexion.prepareStatement(consulta);
			ResultSet resultado = sentencia.executeQuery();

			if (resultado.next()) {
				double totalGasto = resultado.getDouble("coste_total");
				System.out.println("-------------------------------------------------");
				System.out.println("==== INFORME DE GASTOS TOTALES EN REPUESTOS ====");
				System.out.println("--------------------------------------------------");
				System.out.printf(" Coste total de materiales es: %.2f €\n", totalGasto);
				System.out.println("--------------------------------------------------");

			}
		} catch (Exception e) {
			System.out.println("Error al calcular el gasto total" + e.getMessage());
		}

	}

	public void costesMaquina(int idMaquina) {

		String consulta = " SELECT maquina.nombre, SUM(intervencion_usa_repuesto.cantidad_usada * repuesto.precio) AS total_maquina "
				+ " FROM maquina " + " JOIN intervencion ON maquina.id = intervencion.id_maquina "
				+ " JOIN intervencion_usa_repuesto ON intervencion.id = intervencion_usa_repuesto.id_intervencion "
				+ " JOIN repuesto ON intervencion_usa_repuesto.id_repuesto = repuesto.id " + "WHERE maquina.id = ? ";

		try {
			PreparedStatement sentencia = conexion.prepareStatement(consulta);
			sentencia.setInt(1, idMaquina);
			ResultSet resultado = sentencia.executeQuery();
			boolean hayIntervenciones = false;

			while (resultado.next() && resultado.getString("nombre") != null) {
				String nombreMaquina = resultado.getString("nombre");
				double total = resultado.getDouble("total_maquina");
				hayIntervenciones = true;

				System.out.println("--------------------------------------------------");
				System.out.println("========= ANÁLISIS DE COSTES POR MÁQUINA =========");
				System.out.println("--------------------------------------------------");
				System.out.printf(" Gasto total en repuestos: %.2f €\n", total);
				System.out.println("-------------------------------------------------\n");
			}
			if (!hayIntervenciones) {
				System.out.println("==> No se han encontrado gastos para está máquina. <==");
				System.out.println("==> Puede que el ID no exista o que la máquina no tenga averías registradas. <==");
			}

		} catch (SQLException e) {
			System.out.println("Error al calcular el coste de la máquina: " + e.getMessage());
		}
	}

	public void verRepuestosTotal() {
		String consulta = "SELECT nºreferencia, nombre, modelo, stock, precio, estanteria, pasillo, gaveta FROM repuesto";

		try {
			PreparedStatement sentencia = conexion.prepareStatement(consulta);
			ResultSet resultado = sentencia.executeQuery();

			System.out.printf("%s | %s | %s | %s | %s | %s\n", "REF", "NOMBRE", "MODELO", "STOCK", "PRECIO",
					"UBICACIÓN (Estanteria-Pasillo-Gaveta)");
			System.out.println(
					"--------------------------------------------------------------------------------------------------");

			boolean hayDatos = false;
			while (resultado.next()) {
				hayDatos = true;
				String ubicacion = resultado.getString("estanteria") + "-" + resultado.getString("pasillo") + "-"
						+ resultado.getString("gaveta");

				System.out.printf("%s | %s | %s | %d | %.2f €  | %s\n", resultado.getString("nºreferencia"),
						resultado.getString("nombre"), resultado.getString("modelo"), resultado.getInt("stock"),
						resultado.getDouble("precio"), ubicacion);
			}

			if (!hayDatos) {
				System.out.println("El almacén de repuestos está completamente vacío.");
			}
			System.out.println(
					"--------------------------------------------------------------------------------------------------\n");

		} catch (SQLException e) {
			System.out.println("Error al cargar el inventario: " + e.getMessage());
		}
	}

	public void verRepuestosMaquina(int idMaquina) {
		String consulta = "SELECT repuesto.nºreferencia, repuesto.nombre, repuesto.stock, repuesto.precio "
				+ "FROM repuesto "
				+ " JOIN repuesto_pertenece_maquina ON repuesto.id = repuesto_pertenece_maquina.id_repuesto "
				+ "WHERE repuesto_pertenece_maquina.id_maquina = ?";

		try {
			PreparedStatement sentencia = conexion.prepareStatement(consulta);
			sentencia.setInt(1, idMaquina);
			ResultSet resultado = sentencia.executeQuery();

			boolean hayDatos = false;
			while (resultado.next()) {
				if (!hayDatos) {

					System.out.printf("%s | %s | %s | %s\n", "REF", "NOMBRE", "STOCK", "PRECIO");
					System.out.println("----------------------------------------------------------");
				}
				hayDatos = true;

				System.out.printf("%s | %s | %d | %.2f €\n", resultado.getString("nºreferencia"),
						resultado.getString("nombre"), resultado.getInt("stock"), resultado.getDouble("precio"));
			}

			if (!hayDatos) {
				System.out.println("==> No hay repuestos asociados a la máquina con ID: " + idMaquina);
			} else {
				System.out.println("----------------------------------------------------------\n");
			}

		} catch (SQLException e) {
			System.out.println("Error al buscar recambios de la máquina: " + e.getMessage());
		}
	}

	public void eliminarRepuesto(String referencia) {
		String consulta = "DELETE FROM repuesto WHERE nºreferencia = ?";

		try {
			PreparedStatement sentencia = conexion.prepareStatement(consulta);
			sentencia.setString(1, referencia);

			int filasAfectadas = sentencia.executeUpdate();

			if (filasAfectadas > 0) {
				System.out.println(
						"==> ÉXITO: El repuesto con referencia " + referencia + " ha sido eliminado del sistema.");
			} else {
				System.out.println(
						"==> AVISO: No se ha encontrado ningún repuesto con la referencia " + referencia + ".");
			}

		} catch (SQLException e) {

			if (e.getErrorCode() == 1451) {
				System.out.println("==> ERROR: No se puede eliminar este repuesto.");
				System.out.println(
						"==> Motivo: El repuesto ya está registrado en el historial de intervenciones, proveedores o máquinas.");
				System.out.println(
						"==> Consejo de mantenimiento: Si la pieza está descatalogada, es mejor que actualices su stock a 0 en lugar de borrarla para no perder el registro de gastos.");
			} else {
				System.out.println("Error al intentar eliminar el repuesto: " + e.getMessage());
			}
		}
	}

	public void verRepuestosMasUsados() {
		String consulta = "SELECT repuesto.nºreferencia, repuesto.nombre, SUM(intervencion_usa_repuesto.cantidad_usada) AS total_gastado "
				+ "FROM repuesto "
				+ " JOIN intervencion_usa_repuesto ON repuesto.id = intervencion_usa_repuesto.id_repuesto "
				+ "GROUP BY repuesto.id, repuesto.nºreferencia, repuesto.nombre "
				+ "ORDER BY total_gastado DESC LIMIT 10";

		try {
			PreparedStatement sentencia = conexion.prepareStatement(consulta);
			ResultSet resultado = sentencia.executeQuery();

			System.out.printf("%s | %s | %s\n", "REF", "NOMBRE DEL REPUESTO", "UD. GASTADAS");
			System.out.println("----------------------------------------------------------");

			boolean hayDatos = false;
			while (resultado.next()) {
				hayDatos = true;
				System.out.printf("%s | %s | %d\n", resultado.getString("nºreferencia"), resultado.getString("nombre"),
						resultado.getInt("total_gastado"));
			}

			if (!hayDatos) {
				System.out.println("Todavía no se ha registrado el uso de ningún repuesto.");
			}
			System.out.println("----------------------------------------------------------\n");

		} catch (SQLException e) {
			System.out.println("Error al generar el top de repuestos: " + e.getMessage());
		}
	}

	public void insertarRepuesto(String ref, String nombre, String modelo, int stock, double precio, String estanteria,
			String pasillo, String gaveta) {

		String insercion = "INSERT INTO repuesto (nºreferencia, nombre, modelo, stock, precio, estanteria, pasillo, gaveta) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement sentencia = conexion.prepareStatement(insercion);
			sentencia.setString(1, ref);
			sentencia.setString(2, nombre);
			sentencia.setString(3, modelo);
			sentencia.setInt(4, stock);
			sentencia.setDouble(5, precio);
			sentencia.setString(6, estanteria);
			sentencia.setString(7, pasillo);
			sentencia.setString(8, gaveta);

			int filasAfectadas = sentencia.executeUpdate();
			if (filasAfectadas > 0) {
				System.out.println("==> Base de datos actualizada: Repuesto " + ref + " insertado correctamente.");
			} else {
				System.out.println("==> No se pudo insertar el repuesto.");
			}

		} catch (SQLException e) {
			System.out.println("Error al insertar el repuesto (¿Referencia duplicada?): " + e.getMessage());
		}
	}

	public void informeStock() {

		String consulta = "SELECT nºreferencia, nombre, stock, gaveta FROM repuesto WHERE stock < 10 ORDER BY stock ASC";

		try {
			PreparedStatement sentencia = conexion.prepareStatement(consulta);
			ResultSet resultado = sentencia.executeQuery();

			System.out.println("----------------------------------------------------------");
			System.out.println(" == ALERTA: REPUESTOS POR DEBAJO DEL STOCK MÍNIMO (10) == ");
			System.out.println("----------------------------------------------------------");
			System.out.printf("%s | %s | %s | %s\n", "REF", "NOMBRE", "STOCK", "GAVETA");
			System.out.println("----------------------------------------------------------");

			boolean hayDatos = false;
			while (resultado.next()) {
				hayDatos = true;
				int stockActual = resultado.getInt("stock");
				String aviso = (stockActual == 0) ? " ==> (AGOTADO)" : "";

				System.out.printf("%s | %s | %d | %s %s\n", resultado.getString("nºreferencia"),
						resultado.getString("nombre"), stockActual, resultado.getString("gaveta"), aviso);
			}

			if (!hayDatos) {
				System.out.println("¡Buenas noticias! Todos los repuestos tienen niveles de stock correctos.");
			}
			System.out.println("==========================================================\n");

		} catch (SQLException e) {
			System.out.println("Error al comprobar el stock: " + e.getMessage());
		}
	}
}
