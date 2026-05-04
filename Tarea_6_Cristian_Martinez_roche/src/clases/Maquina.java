package clases;

public class Maquina {

	private int id;
	private String nombre;
	private String tipo;
	private String modelo;
	private String numSerie;
	private int productoDia;
	private String potencia;
	private long tiempo_marcha;
	private double rendimiento;

	public Maquina() {
	}

	public Maquina(int id, String nombre, String tipo, String modelo, String numSerie, int productoDia, String potencia,
			long tiempo_marcha) {
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.modelo = modelo;
		this.numSerie = numSerie;
		this.productoDia = productoDia;
		this.potencia = potencia;
		this.tiempo_marcha = tiempo_marcha;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getNumSerie() {
		return numSerie;
	}

	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}

	public int getProductoDia() {
		return productoDia;
	}

	public void setProductoDia(int productoDia) {
		this.productoDia = productoDia;
	}

	public String getPotencia() {
		return potencia;
	}

	public void setPotencia(String potencia) {
		this.potencia = potencia;
	}

	public long getTiempo_marcha() {
		return tiempo_marcha;
	}

	public void setTiempo_marcha(long tiempo_marcha) {
		this.tiempo_marcha = tiempo_marcha;
	}

	public double getRendimiento() {
		return rendimiento;
	}

	public void setRendimiento(double rendimiento) {
		this.rendimiento = rendimiento;
	}

	@Override
	public String toString() {
		return "==> Máquina: " + nombre + " - " + modelo + "\n" + "==> Tipo: " + tipo + "\n" + "==> Nº de serie:"
				+ numSerie + "\n" + "==> Potencia: " + potencia + "KW \n" + "==> Producción diaria estimada: "
				+ productoDia + "\n" + "==> Tiempo programado de máquina en marcha: " + tiempo_marcha + "\n" + "==> Rendimiento: "
				+ rendimiento + "% \n" ;
	}

}
