package pe.isil.itam.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import pe.isil.itam.model.Estado;
import pe.isil.itam.util.JPAUtil;

import java.util.ArrayList;
import java.util.List;

public class EstadoDAO {

    public List<Estado> getAll() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Estado> estados = new ArrayList<>();
        try {
            String jpql = "SELECT e FROM Estado e";
            TypedQuery<Estado> query = em.createQuery(jpql, Estado.class);
            estados = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return estados;
    }

    public Estado getById(int idEstado) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(Estado.class, idEstado);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }

    public Estado getByNombre(String nombre) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            String jpql = "SELECT e FROM Estado e WHERE e.nombre = :nom";
            TypedQuery<Estado> query = em.createQuery(jpql, Estado.class);
            query.setParameter("nom", nombre);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }
}