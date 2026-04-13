package GestorMantenimiento;

import java.time.LocalDate;

public class Intervencion {
	
	private String numRegistro;
    private String tipo;
    private LocalDate fechaSolicitud;
    private Tecnico tecnicoAsignado;
    
	public Intervencion(String numRegistro, String tipo, LocalDate fechaSolicitud, Tecnico tecnicoAsignado) {
		
		this.numRegistro = numRegistro;
		this.tipo = tipo;
		this.fechaSolicitud = fechaSolicitud;
		this.tecnicoAsignado = tecnicoAsignado;
	}

	public String getNumRegistro() {
		return numRegistro;
	}

	public void setNumRegistro(String numRegistro) {
		this.numRegistro = numRegistro;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public LocalDate getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(LocalDate fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public Tecnico getTecnicoAsignado() {
		return tecnicoAsignado;
	}

	public void setTecnicoAsignado(Tecnico tecnicoAsignado) {
		this.tecnicoAsignado = tecnicoAsignado;
	}
    
	public boolean esUrgente() {
      
        return this.tipo.equalsIgnoreCase("correctivo");
    }

	@Override
	public String toString() {
		return "Intervencion [Número de registro=" + numRegistro + ", tipo de intervención=" + tipo + ", fecha de solicitud=" + fechaSolicitud
				+ ", técnico asignado=" + tecnicoAsignado + "]";
	}
    
    
    
    
    
    
    
}
