package clases;

public class Respuesto {

	private int id;
	private String numReferencia;
	private String nombre;
	private String modelo;
	private int stock;
	private double precio;
	private String estanteria;
	private String pasillo;
	private String gaveta;

	public Respuesto() {
	}

	public Respuesto(int id, String numReferencia, String nombre, String modelo, int stock, double precio,
			String estanteria, String pasillo, String gaveta) {
		this.id = id;
		this.numReferencia = numReferencia;
		this.nombre = nombre;
		this.modelo = modelo;
		this.stock = stock;
		this.precio = precio;
		this.estanteria = estanteria;
		this.pasillo = pasillo;
		this.gaveta = gaveta;
	}

	public Respuesto(String numReferencia, String nombre, String modelo, int stock, double precio) {

		this.numReferencia = numReferencia;
		this.nombre = nombre;
		this.modelo = modelo;
		this.stock = stock;
		this.precio = precio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumReferencia() {
		return numReferencia;
	}

	public void setNumReferencia(String numReferencia) {
		this.numReferencia = numReferencia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getEstanteria() {
		return estanteria;
	}

	public void setEstanteria(String estanteria) {
		this.estanteria = estanteria;
	}

	public String getPasillo() {
		return pasillo;
	}

	public void setPasillo(String pasillo) {
		this.pasillo = pasillo;
	}

	public String getGaveta() {
		return gaveta;
	}

	public void setGaveta(String gaveta) {
		this.gaveta = gaveta;
	}

	@Override
	public String toString() {
		return "Respuesto con nº de referencia: " + numReferencia + "\n" + "==> Nombre: " + nombre + "\n"
				+ "==> Modelo: " + modelo + "\n" + "==> Precio: " + precio + "\n" + "==> Cantidad en stock:" + stock
				+ "\n" + "==> Ubicación: Estantería - " + estanteria + " - Pasillo - " + pasillo + " - Gaveta - "
				+ gaveta + "\n";
	}

}
