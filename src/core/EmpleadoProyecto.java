/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

/**
 *
 * @author sddva
 */
public class EmpleadoProyecto {
    public int idEmpleado;
    public int idProyecto;
    public String nombreProyecto;
    public String nombreEmpleado;

    public EmpleadoProyecto(int idEmpleado, int idProyecto, String nombreProyecto, String nombreEmpleado) {
        this.idEmpleado = idEmpleado;
        this.idProyecto = idProyecto;
        this.nombreProyecto = nombreProyecto;
        this.nombreEmpleado = nombreEmpleado;
    }

    @Override
    public String toString() {
        return idEmpleado + "," + nombreEmpleado + "," + idProyecto + "," + nombreProyecto;
    }
}
