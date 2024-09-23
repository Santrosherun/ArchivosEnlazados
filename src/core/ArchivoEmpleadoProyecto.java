/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author sddva
 */
public class ArchivoEmpleadoProyecto {
    public String rutaArchivoEmpleadoProyecto;

    public ArchivoEmpleadoProyecto(String rutaArchivoEmpleadoProyecto) {
        this.rutaArchivoEmpleadoProyecto = rutaArchivoEmpleadoProyecto;
    }
    
    public ArrayList<EmpleadoProyecto> leerArchivo(){
        ArrayList<EmpleadoProyecto> empleadosProyectos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivoEmpleadoProyecto))) {
            String linea;
            while((linea = br.readLine()) != null){
                String[] partes = linea.split(",");
                int idEmpleado = Integer.parseInt(partes[0]);
                String nombreEmpleado = partes[1];
                int idProyecto = Integer.parseInt(partes[2]);
                String nombreProyecto = partes[3];
                
                empleadosProyectos.add(new EmpleadoProyecto(idEmpleado, idProyecto, nombreProyecto, nombreEmpleado));
            }
        }catch (IOException e){
            System.out.println("No se pudo F");
        }
        return empleadosProyectos;
    }
    
    public void escribirArchivo(ArrayList<EmpleadoProyecto> empleadosProyectos){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivoEmpleadoProyecto))){
            for (EmpleadoProyecto empleadoProyecto : empleadosProyectos){
                bw.write(empleadoProyecto.toString());
                bw.newLine();
            }
        } catch (Exception e) {
            System.out.println("No se pudo F");
        }
    }
    
    public void asignarEmpleados(ArrayList<Empleado> empleados, ArrayList<Proyecto> proyectos, ArrayList<EmpleadoProyecto> empleadosProyectos){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Que Empleado desea asignar?");
        int empleadoN = scanner.nextInt();
        System.out.println("a Que proyecto lo desea agregar?");
        int proyectoN = scanner.nextInt();
        for(Empleado empleado : empleados){
            for(Proyecto proyecto : proyectos){
                if(empleado.id == empleadoN && proyecto.id == proyectoN){
                    empleadosProyectos.add(new EmpleadoProyecto(empleadoN, proyectoN, proyecto.nombre, empleado.nombre));
                }
            }
        }
    }
    
    public void mostrarArchivo(ArrayList<EmpleadoProyecto> empleadosProyectos){
        System.out.println("PROYECTOS/EMPLEADOS REGISTRADOS");
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivoEmpleadoProyecto))) {
            String linea;
            while((linea = br.readLine()) != null){
                String[] partes = linea.split(",");
                int idEmpleado = Integer.parseInt(partes[0]);
                String nombreEmpleado = partes[1];
                int idProyecto = Integer.parseInt(partes[2]);
                String nombreProyecto = partes[3];
                
                System.out.println("IDEmpleado: " + idEmpleado + ", NOMBREEmpleado: " + nombreEmpleado +", IDProyecto: " + idProyecto + ", NOMBREProyecto: " + nombreProyecto);
            }
        }catch (IOException e){
            System.out.println("No se pudo F");
        }
    }
    
    public void imprimirEmpleados(ArrayList<EmpleadoProyecto> empleadosProyectos){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cual proyecto desea ver sus empledos?");
        int proyectoN = scanner.nextInt();
        for(EmpleadoProyecto empleadoProyecto : empleadosProyectos){
            if(empleadoProyecto.idProyecto == proyectoN){
                System.out.println(empleadoProyecto.idEmpleado + ", " + empleadoProyecto.nombreEmpleado);
            }
        }
    }
}
