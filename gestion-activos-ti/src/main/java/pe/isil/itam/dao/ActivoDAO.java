package pe.isil.itam.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import pe.isil.itam.model.Activo;
import pe.isil.itam.model.Estado;
import pe.isil.itam.util.JPAUtil;

import java.util.ArrayList;
import java.util.List;

public class ActivoDAO {
    public boolean insert(Activo activo) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(activo);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            em.close();
        }
    }

    public List<Activo> getAll() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Activo> activos = new ArrayList<>();

        try {
            String jpql = "SELECT a FROM Activo a";
            TypedQuery<Activo> query = em.createQuery(jpql, Activo.class);
            activos = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }

        return activos;
    }

    public Activo getById(int idActivo) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            Activo activo = em.find(Activo.class, idActivo);
            return activo;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }

    public boolean update(Activo activo) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            em.getTransaction().begin();
            Activo dbActivo = em.find(Activo.class, activo.getIdActivo());

            if (dbActivo != null) {
                dbActivo.setNombre(activo.getNombre());
                dbActivo.setTipo(activo.getTipo());
                dbActivo.setMarca(activo.getMarca());
                dbActivo.setModelo(activo.getModelo());
                dbActivo.setNumSerie(activo.getNumSerie());
                dbActivo.setEstado(activo.getEstado());
                dbActivo.setUsuario(activo.getUsuario());

                em.getTransaction().commit();
                return true;
            } else {
                em.getTransaction().rollback();
                return false;
            }
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            em.close();
        }
    }

    public boolean delete(int idActivo) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Activo activo = em.find(Activo.class, idActivo);
            if (activo != null && activo.getEstado().equals("Retirado")) {

                String jpql = "SELECT e FROM Estado e WHERE e.nombre = :nombre";
                TypedQuery<Estado> query = em.createQuery(jpql, Estado.class);
                query.setParameter("nombre", "Dado de baja");
                Estado estadoDeBaja = query.getSingleResult();

                //Otra posible solución
                //EstadoDAO estadoDAO = new EstadoDAO();
                //Estado estadoDeBaja = estadoDAO.getByNombre("Dado de baja");

                activo.setEstado(estadoDeBaja);
                em.getTransaction().commit();
                return true;
            } else {
                em.getTransaction().rollback();
                return false;
            }
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            em.close();
        }
    }


}
