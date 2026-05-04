package clases;

import java.time.LocalDate;

public class Intervencion {

	private int id;
	private String numRegistro;
	private String motivo;
	private String tipo;
	private LocalDate fecha_solicitud;
	private LocalDate fecha_realizacion;
	private LocalDate hora_inicio;
	private LocalDate hora_fin;
	private long tiempo_parada;

	public Intervencion() {
	}

	public Intervencion(int id, String numRegistro, String motivo, String tipo, LocalDate fecha_solicitud,
			LocalDate fecha_realizacion, LocalDate hora_inicio, LocalDate hora_fin) {
		this.id = id;
		this.numRegistro = numRegistro;
		this.motivo = motivo;
		this.tipo = tipo;
		this.fecha_solicitud = fecha_solicitud;
		this.fecha_realizacion = fecha_realizacion;
		this.hora_inicio = hora_inicio;
		this.hora_fin = hora_fin;
	}

	public Intervencion(int id, String numRegistro, String motivo, String tipo, LocalDate fecha_solicitud,
			LocalDate fecha_realizacion, LocalDate hora_inicio) {
		super();
		this.id = id;
		this.numRegistro = numRegistro;
		this.motivo = motivo;
		this.tipo = tipo;
		this.fecha_solicitud = fecha_solicitud;
		this.fecha_realizacion = fecha_realizacion;
		this.hora_inicio = hora_inicio;
	}

	public Intervencion(int id, String numRegistro, String motivo, String tipo, LocalDate fecha_solicitud) {
		super();
		this.id = id;
		this.numRegistro = numRegistro;
		this.motivo = motivo;
		this.tipo = tipo;
		this.fecha_solicitud = fecha_solicitud;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumRegistro() {
		return numRegistro;
	}

	public void setNumRegistro(String numRegistro) {
		this.numRegistro = numRegistro;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public LocalDate getFecha_solicitud() {
		return fecha_solicitud;
	}

	public void setFecha_solicitud(LocalDate fecha_solicitud) {
		this.fecha_solicitud = fecha_solicitud;
	}

	public LocalDate getFecha_realizacion() {
		return fecha_realizacion;
	}

	public void setFecha_realizacion(LocalDate fecha_realizacion) {
		this.fecha_realizacion = fecha_realizacion;
	}

	public LocalDate getHora_inicio() {
		return hora_inicio;
	}

	public void setHora_inicio(LocalDate hora_inicio) {
		this.hora_inicio = hora_inicio;
	}

	public LocalDate getHora_fin() {
		return hora_fin;
	}

	public void setHora_fin(LocalDate hora_fin) {
		this.hora_fin = hora_fin;
	}

	public long getTiempo_parada() {
		return tiempo_parada;
	}

	public void setTiempo_parada(long tiempo_parada) {
		this.tiempo_parada = tiempo_parada;
	}

	@Override
	public String toString() {
		return "Intervención con nº de registro: " + numRegistro + "\n" + "==> Motivo: " + motivo + "\n" + "==> Tipo: "
				+ tipo + "\n" + "==> Fecha de solicitud: " + fecha_solicitud + "\n" + "==> Fecha de realización: "
				+ fecha_realizacion + "\n" + "==> Hora de inicio: " + hora_inicio + "\n" + "==> Hora de finalización: "
				+ hora_fin + "\n" + "==> Tiempo total parada: " + tiempo_parada + "\n";
	}

}
