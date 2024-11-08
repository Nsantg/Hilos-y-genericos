package org.example.dao;

import org.example.model.Producto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ProductoDAO {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("TiendaPU");

    public void guardar(Producto producto) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(producto);
        em.getTransaction().commit();
        em.close();
    }

    public List<Producto> obtenerProductos() {
        EntityManager em = emf.createEntityManager();
        List<Producto> productos = em.createQuery("SELECT p FROM Producto p", Producto.class).getResultList();
        em.close();
        return productos;
    }
}
