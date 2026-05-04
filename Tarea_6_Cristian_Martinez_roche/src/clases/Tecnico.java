package clases;

import java.sql.Date;

public class Tecnico {

	private int id;
	private String nombre;
	private int numEmpleado;
	private Date fechaIncorporacion;
	private String calle;
	private int numCasa;
	private String localidad;
	private String rango;
	private double salario;

	public Tecnico() {
	}

	public Tecnico(int id, String nombre, int numEmpleado, Date fechaIncorporacion, String calle, int numCasa,
			String localidad, String rango, double salario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.numEmpleado = numEmpleado;
		this.fechaIncorporacion = fechaIncorporacion;
		this.calle = calle;
		this.numCasa = numCasa;
		this.localidad = localidad;
		this.rango = rango;
		this.salario = salario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumEmpleado() {
		return numEmpleado;
	}

	public void setNumEmpleado(int numEmpleado) {
		this.numEmpleado = numEmpleado;
	}

	public Date getFechaIncorporacion() {
		return fechaIncorporacion;
	}

	public void setFechaIncorporacion(Date fechaIncorporacion) {
		this.fechaIncorporacion = fechaIncorporacion;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNumCasa() {
		return numCasa;
	}

	public void setNumCasa(int numCasa) {
		this.numCasa = numCasa;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getRango() {
		return rango;
	}

	public void setRango(String rango) {
		this.rango = rango;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "Técnico con nº de empleado: " + numEmpleado + "\n" + "==> Nombre: " + nombre + "\n"
				+ "==> Fecha de incorporación: " + fechaIncorporacion + "\n" + "==> Dirección: " + calle + " Nº "
				+ numCasa + " en " + localidad + "\n" + "==> Rango: " + rango + "\n" + "==> Salario: " + salario + "€ \n";
	}

}
