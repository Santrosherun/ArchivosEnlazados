/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

import java.time.LocalDate;

/**
 *
 * @author sddva
 */
public class Proyecto {
    public String nombre;
    public int id;
    public LocalDate horaInicio;
    public LocalDate horaFinal;
    public float presupuesto;

    public Proyecto(String nombre, int id, LocalDate horaInicio, LocalDate horaFinal, float presupuesto) {
        this.nombre = nombre;
        this.id = id;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.presupuesto = presupuesto;
    }

    @Override
    public String toString() {
        return nombre + "," + id + "," + horaInicio + "," + horaFinal + "," + presupuesto;
    }
    
    
}
