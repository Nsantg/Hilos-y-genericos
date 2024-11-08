package org.example.main;

import org.example.dao.ProductoDAO;
import org.example.model.Producto;
import org.example.threads.TiendaThread;

import java.util.Scanner;

public class Main {
    private static ProductoDAO productoDAO = new ProductoDAO();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("=== TIENDA SIMULACIÓN ===");
            System.out.println("1. Iniciar simulación");
            System.out.println("2. Ver productos guardados");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> iniciarSimulacion();
                case 2 -> verProductosGuardados();
                case 3 -> {
                    System.out.println("Saliendo de la simulación...");
                    exit = true;
                }
                default -> System.out.println("Opción no válida.");
            }
        }
        scanner.close();
    }

    private static void iniciarSimulacion() {
        // Usando generics con la clase TiendaThread
        TiendaThread<Producto> hiloProducto = new TiendaThread<>(new Producto("Producto Genérico"));
        hiloProducto.start();
        productoDAO.guardar(new Producto("Producto de ejemplo"));
    }

    private static void verProductosGuardados() {
        productoDAO.obtenerProductos().forEach(System.out::println);
    }
}
