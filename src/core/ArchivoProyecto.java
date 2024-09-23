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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author sddva
 */
public class ArchivoProyecto {
    public String rutaProyecto;

    public ArchivoProyecto(String rutaProyecto) {
        this.rutaProyecto = rutaProyecto;
    }
    
    public ArrayList<Proyecto> leerArchivo(){
        ArrayList<Proyecto> proyectos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaProyecto))) {
            String linea;
            while((linea = br.readLine()) != null){
                String[] partes = linea.split(",");
                String nombre = partes[0];
                int id = Integer.parseInt(partes[1]);
                LocalDate fechaInicio  = LocalDate.parse(partes[2]);
                LocalDate fechaFinal  = LocalDate.parse(partes[3]);
                float presupuesto = Float.parseFloat(partes[4]);
                
                proyectos.add(new Proyecto(nombre, id, fechaInicio, fechaFinal, presupuesto));
            }
        }catch (IOException e){
            System.out.println("No se pudo F");
        }
        return proyectos;
    }
    
    public void mostrarArchivo(){
        try (BufferedReader br = new BufferedReader(new FileReader(rutaProyecto))) {
            String linea;
            while((linea = br.readLine()) != null){
                String[] partes = linea.split(",");
                String nombre = partes[0];
                int id = Integer.parseInt(partes[1]);
                LocalDate fechaInicio  = LocalDate.parse(partes[2]);
                LocalDate fechaFinal  = LocalDate.parse(partes[3]);
                float presupuesto = Float.parseFloat(partes[4]);
                
                System.out.println("NOMBRE: " + nombre + "ID: " + id +", FECHAINICIO: " + fechaInicio + ", FECHAFINAL: " + fechaFinal + ", SALARIO: " + presupuesto);
            }
        }catch (IOException e){
            System.out.println("No se pudo F");
        }
    }
    
    public void escribirArchivo(ArrayList<Proyecto> proyectos){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaProyecto))){
            for (Proyecto proyecto : proyectos){
                bw.write(proyecto.toString());
                bw.newLine();
            }
        } catch (Exception e) {
            System.out.println("No se pudo F");
        }
    }
    
    public Proyecto agregarProyecto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----------------------------------------------------------");
        System.out.println("Ingrese los datos del proyecto a agregar");
        
        System.out.print("Ingrese el id del proyecto: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Ingrese el nombre del proyecto: ");
        String nombre = scanner.nextLine();
        scanner.nextLine(); 
        
        System.out.println("Ingrese la fecha de inicio del proyecto: ");
        LocalDate fechaInicio = LocalDate.parse(scanner.nextLine());
        scanner.nextLine();
        
        System.out.println("Ingrese la fecha final del proyecto: ");
        LocalDate fechaFinal = LocalDate.parse(scanner.nextLine());
        scanner.nextLine();
        
        System.out.println("Ingrese el presupuesto del proyecto: ");
        float presupuesto = scanner.nextFloat();
        scanner.nextLine();
        
        return new Proyecto(nombre, id, fechaInicio, fechaFinal, presupuesto);
    }
    
    public void agregarProyecto2(ArrayList<Proyecto> proyectos) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            Proyecto proyecto = agregarProyecto();
            proyectos.add(proyecto);

            System.out.print("¿Desea agregar otro proyecto? (s/n): ");
            String continuar = scanner.nextLine();
            if (!continuar.toLowerCase().equals("s")) {
                break;
            }
        }
    }
    
    
}
