package GestorMantenimiento;

import java.time.LocalDate;

public class MainFabrica {

	public static void main(String[] args) {
		System.out.println("Iniciando sistema de gestión de la fábrica");

        
        Tecnico tec1 = new Tecnico(1, "Carlos Ruiz", LocalDate.of(2018, 5, 10));
        Tecnico tec2 = new Tecnico(2, "Laura Gomez", LocalDate.of(2022, 11, 20));
        GestorIntervenciones listaTrabajos = new GestorIntervenciones();
        
        Intervencion int1 = new Intervencion("INT-001", "preventivo", LocalDate.of(2026, 3, 1), tec1);
        Intervencion int2 = new Intervencion("INT-002", "correctivo", LocalDate.now(), tec2);

        System.out.println("Info de " + tec1.getNombre() + ": " + tec1.calcularAniosExperiencia() + " años de experiencia.");
       
        listaTrabajos.agregarIntervencion(int1);
        listaTrabajos.agregarIntervencion(int2);
        listaTrabajos.mostrarTodasLasIntervenciones();
   
        System.out.println("¿La intervención INT-002 es urgente? " + (int2.esUrgente() ? "Sí" : "No"));
        System.out.println("El técnico " + tec2.getNombre() + " se ha puesto enfermo. Reasignando...");
      
        listaTrabajos.reasignarTecnico("INT-002", tec1);      
        listaTrabajos.mostrarTodasLasIntervenciones();

        tec1.registrarTiempoEfectivo(3, 45);
        System.out.println(tec1);
        tec1.registrarTiempoEfectivo(0, 30);
        System.out.println(tec1);
        
        
        System.out.println("La intervención INT-001 ha sido completada.");
        listaTrabajos.eliminarIntervencion("INT-001");
        listaTrabajos.mostrarTodasLasIntervenciones();
    }

}


