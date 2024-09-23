/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

/**
 *
 * @author sddva
 */
public class Empleado {
    public String nombre;
    public int id;
    public String departamento;
    public String cargo;
    public float salario;

    public Empleado(String nombre, int id, String departamento, String cargo, float salario) {
        this.nombre = nombre;
        this.id = id;
        this.departamento = departamento;
        this.cargo = cargo;
        this.salario = salario;
    }

    @Override
    public String toString() {
        return nombre + "," + id + "," + departamento + "," + cargo + "," + salario;
    }
    
    
}
