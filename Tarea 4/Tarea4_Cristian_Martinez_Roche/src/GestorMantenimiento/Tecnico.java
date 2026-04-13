package GestorMantenimiento;

import java.time.LocalDate;
import java.time.Period;

public class Tecnico {
	
	private int id;
    private String nombre;
    private LocalDate fechaIncorporacion;
    private long minutosTotalesTrabajados;

    
    public Tecnico(int id, String nombre, LocalDate fechaIncorporacion) {
        this.id = id;
        this.nombre = nombre;
        this.fechaIncorporacion = fechaIncorporacion;
        this.minutosTotalesTrabajados = 0;
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
	public LocalDate getFechaIncorporacion() {
		return fechaIncorporacion;
	}
	public void setFechaIncorporacion(LocalDate fechaIncorporacion) {
		this.fechaIncorporacion = fechaIncorporacion;
	}
	
	public void registrarTiempoEfectivo(int horas, int minutos) {
        if (horas < 0 || minutos < 0) {
            System.out.println("Error: No se pueden introducir tiempos negativos.");
            return;
        }
        long minutosAñadidos = (horas * 60L) + minutos;
        this.sumarTiempo(minutosAñadidos);
        System.out.println("---> Se han registrado " + horas + " horas y " + minutos + " minutos de trabajo efectivo para el técnico: " + this.getNombre());
    }
	
	public int calcularAniosExperiencia() {
        LocalDate hoy = LocalDate.now();
        Period periodo = Period.between(this.fechaIncorporacion, hoy);
        return periodo.getYears();
    }
	public void sumarTiempo(long minutos) {
        if (minutos > 0) {
            this.minutosTotalesTrabajados += minutos;
        }
    }
	public String getTiempoFormateado() {
        long horas = minutosTotalesTrabajados / 60;
        long minutosRestantes = minutosTotalesTrabajados % 60;
        return horas + " horas " + minutosRestantes + " minutos";
    }
    @Override
	public String toString() {
		return "Tecnico [id=" + id + ", Nombre=" + nombre + ", Fecha incorporación=" + fechaIncorporacion
				+ ", Tiempo efectivo de trabajo=" + getTiempoFormateado() + ", Experiencia="
				+ calcularAniosExperiencia() + " años]";
	}
    
}
