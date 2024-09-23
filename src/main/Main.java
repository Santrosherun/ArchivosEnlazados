/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import core.ArchivoEmpleado;
import core.ArchivoEmpleadoProyecto;
import core.ArchivoProyecto;
import core.Empleado;
import core.EmpleadoProyecto;
import core.Proyecto;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author sddva
 */
public class Main {
    public static void main(String[] args) {
        ArchivoProyecto ArchivoP = new ArchivoProyecto("C:\\Users\\sddva\\OneDrive\\Documentos\\NetBeansProjects\\Estructura cagá\\src\\core\\Proyectos.txt");
        ArchivoEmpleado ArchivoE = new ArchivoEmpleado("C:\\Users\\sddva\\OneDrive\\Documentos\\NetBeansProjects\\Estructura cagá\\src\\core\\Empleados.txt");
        ArchivoEmpleadoProyecto ArchivoEP = new ArchivoEmpleadoProyecto("C:\\Users\\sddva\\OneDrive\\Documentos\\NetBeansProjects\\Estructura cagá\\src\\core\\EmpleadosProyectos.txt");
        ArrayList<Empleado> empleados = ArchivoE.leerArchivo();
        ArrayList<Proyecto> proyectos = ArchivoP.leerArchivo();
        ArrayList<EmpleadoProyecto> empleadosProyectos = ArchivoEP.leerArchivo();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Gestion de proyectos ==> 1 / gestion de empleados ==>  / ver cruce ==> 3");
            String op = scanner.nextLine();
            switch(op){
                case "1":
                    System.out.println("Gestion de proyectos");
                    System.out.println("Agregar Proyectos ==> 1 / ");
                    String op1 = scanner.nextLine();
                    switch(op1){
                        case "1":
                            ArchivoP.agregarProyecto2(proyectos);
                            ArchivoP.escribirArchivo(proyectos);
                            ArchivoP.mostrarArchivo();
                            break;
                    }
                    
                    break;
                    
                case "2":
                    System.out.println("Gestion de empleados");
                    System.out.println("Agregar empleados ==> 1 / ");
                    String op2 = scanner.nextLine();
                    switch(op2){
                        case "1":
                            ArchivoE.agregarProducto2(empleados);
                            ArchivoE.escribirArchivo(empleados);
                            ArchivoE.mostrarArchivo();
                            break;
                    }
                    
                    break;
                    
                case "3":
                    System.out.println("Archivo cruzado");
                    System.out.println("Desea asignar un empleado? ==> 1 / Desea ver la lista? ==> 2 / Desea ver los empleados por proyecto? ==> 3 / Desea buscar proyectos por presupuesto? ==> 4");
                    String op3 = scanner.nextLine();
                    switch(op3){
                        case "1":
                            ArchivoEP.asignarEmpleados(empleados, proyectos, empleadosProyectos);
                            ArchivoEP.escribirArchivo(empleadosProyectos);
                            ArchivoEP.mostrarArchivo(empleadosProyectos);
                            break;
                        case "2":
                            ArchivoEP.mostrarArchivo(empleadosProyectos);
                            break;
                            
                        case "3":
                            ArchivoEP.imprimirEmpleados(empleadosProyectos);
                            break;
                            
                        case "4":
                            
                            break;
                    }
                    break;
                    
                default:
                    System.out.println("F");
                    System.exit(0);
            }
        }
    }
}
