package pe.isil.itam.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import pe.isil.itam.model.Usuario;
import pe.isil.itam.util.JPAUtil;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    public boolean insert(Usuario usuario) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(usuario);
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

    public List<Usuario> getAll() {
        List<Usuario> usuarios = new ArrayList<>();
        EntityManager em = JPAUtil.getEntityManager();

        try {
            String jpql = "SELECT u FROM Usuario u";

            TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);

            usuarios = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }

        return usuarios;
    }

    public Usuario getByCodigo(String codigo) {
        EntityManager em = JPAUtil.getEntityManager();
        Usuario usuario = null;

        try {
            String jpql = "SELECT u FROM Usuario u WHERE u.codigo = :cod";
            TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
            query.setParameter("cod", codigo);
            usuario = query.getSingleResult();
        } catch (NoResultException e){
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }

        return usuario;
    }

    public boolean update(Usuario usuario) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            em.getTransaction().begin();

            Usuario dbUsuario = em.find(Usuario.class, usuario.getIdUsuario());

            if (dbUsuario != null) {
                dbUsuario.setNombre(usuario.getNombre());
                dbUsuario.setApellido(usuario.getApellido());
                dbUsuario.setArea(usuario.getArea());
                dbUsuario.setContrasena(usuario.getContrasena());

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

    public boolean delete(int idUsuario) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            em.getTransaction().begin();
            Usuario usuario = em.find(Usuario.class, idUsuario);

            if (usuario != null) {
                usuario.setActivo(false);
                em.getTransaction().commit();
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

        return false;
    }
}
