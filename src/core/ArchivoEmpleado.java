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
public class ArchivoEmpleado {
    public String rutaEmpleado;

    public ArchivoEmpleado(String rutaEmpleado) {
        this.rutaEmpleado = rutaEmpleado;
    }
    
    public ArrayList<Empleado> leerArchivo(){
        ArrayList<Empleado> empleados = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaEmpleado))) {
            String linea;
            while((linea = br.readLine()) != null){
                String[] partes = linea.split(",");
                String nombre = partes[0];
                int id = Integer.parseInt(partes[1]);
                String departamento = partes[2];
                String cargo = partes[3];
                float salario = Float.parseFloat(partes[4]);
                
                empleados.add(new Empleado(nombre, id, departamento, cargo, salario));
            }
        }catch (IOException e){
            System.out.println("No se pudo F");
        }
        return empleados;
    }
    
    public void mostrarArchivo(){
        try (BufferedReader br = new BufferedReader(new FileReader(rutaEmpleado))) {
            String linea;
            while((linea = br.readLine()) != null){
                String[] partes = linea.split(",");
                String nombre = partes[0];
                int id = Integer.parseInt(partes[1]);
                String departamento = partes[2];
                String cargo = partes[3];
                float salario = Float.parseFloat(partes[4]);
                
                System.out.println("NOMBRE: " + nombre + "ID: " + id +", DEPARTAMENTO: " + departamento + ", CARGO: " + cargo + ", SALARIO: " + salario);
            }
        }catch (IOException e){
            System.out.println("No se pudo F");
        }
    }
    
    public void escribirArchivo(ArrayList<Empleado> empleados){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaEmpleado))){
            for (Empleado empleado : empleados){
                bw.write(empleado.toString());
                bw.newLine();
            }
        } catch (Exception e) {
            System.out.println("No se pudo F");
        }
    }
    
    public Empleado agregarProducto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----------------------------------------------------------");
        System.out.println("Ingrese los datos del Empleado a agregar");
        
        System.out.print("Ingrese el ID del Empleado: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Ingrese el nombre del empleado: ");
        String nombre = scanner.nextLine();
        scanner.nextLine(); 
        
        System.out.println("Ingrese el departamento del empleado: ");
        String departamento = scanner.nextLine();
        scanner.nextLine();
        
        System.out.println("Ingrese el cargo del empleado: ");
        String cargo = scanner.nextLine();
        scanner.nextLine();
        
        System.out.println("Ingrese el salario del empleado: ");
        float salario = scanner.nextFloat();
        scanner.nextLine();
        
        return new Empleado(nombre, id, departamento, cargo, salario);
    }
    
    public void agregarProducto2(ArrayList<Empleado> empleados) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            Empleado empleado = agregarProducto();
            empleados.add(empleado);

            System.out.print("¿Desea agregar otro empleado? (s/n): ");
            String continuar = scanner.nextLine();
            if (!continuar.toLowerCase().equals("s")) {
                break;
            }
        }
    }
    
    
}

