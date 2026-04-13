package GestorMantenimiento;

import java.util.ArrayList;

public class GestorIntervenciones {
	   
	    private ArrayList<Intervencion> listaIntervenciones;

	   
	    public GestorIntervenciones() {
	        this.listaIntervenciones = new ArrayList<>();
	    }
	    public void agregarIntervencion(Intervencion nuevaIntervencion) {
	        listaIntervenciones.add(nuevaIntervencion);
	        System.out.println("--> Intervención " + nuevaIntervencion.getNumRegistro() + " añadida con éxito.");
	    }
	    public void mostrarTodasLasIntervenciones() {
	        System.out.println("--- LISTADO DE INTERVENCIONES ---");
	        System.out.println(listaIntervenciones);
	        System.out.println("---------------------------------");
	    }
	    public void reasignarTecnico(String numRegistro, Tecnico nuevoTecnico) {
	        for (Intervencion i : listaIntervenciones) {
	            if (i.getNumRegistro().equals(numRegistro)) {
	                i.setTecnicoAsignado(nuevoTecnico);
	                System.out.println("--> Técnico reasignado con éxito para la intervención " + numRegistro);
	                return;
	            }
	        }
	        System.out.println("--> Error: No se encontró la intervención " + numRegistro);
	    }
	    public void eliminarIntervencion(String numRegistro) {
	        for (int i = 0; i < listaIntervenciones.size(); i++) {
	            if (listaIntervenciones.get(i).getNumRegistro().equals(numRegistro)) {
	                listaIntervenciones.remove(i);
	                System.out.println("--> Intervención " + numRegistro + " eliminada del registro.");
	                return;
	            }
	        }
	        System.out.println("--> Error: No se encontró la intervención " + numRegistro + " para eliminar.");
	    }
	}