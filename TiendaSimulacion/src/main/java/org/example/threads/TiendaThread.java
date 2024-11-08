package org.example.threads;

import org.example.model.Producto;

public class TiendaThread<T extends Producto> extends Thread {
    private final T producto;

    public TiendaThread(T producto) {
        this.producto = producto;
    }

    @Override
    public void run() {
        System.out.println("Simulando operación en la tienda con el producto: " + producto.getNombre());
        try {
            Thread.sleep(2000); // Simulación de tiempo de operación
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Operación completada con el producto: " + producto.getNombre());
    }
}
