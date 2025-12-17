package pe.isil.itam.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pe.isil.itam.dao.UsuarioDAO;
import pe.isil.itam.model.Usuario;

import java.io.IOException;
import java.util.List;

@WebServlet("/SvUsuarios")
public class SvUsuarios extends HttpServlet {
    private UsuarioDAO usuarioDAO;

    public SvUsuarios() {
        this.usuarioDAO = new UsuarioDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Usuario> listaUsuarios = usuarioDAO.getAll();

        req.setAttribute("listaUsuarios", listaUsuarios);

        req.getRequestDispatcher("usuarios.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accion = req.getParameter("accion");
        int id;
        String codigo;
        String nombre;
        String apellido;
        String area;
        String contrasena;
        Usuario usuario;


        if (accion != null) {
            switch (accion) {
                case "crear":
                    //DAO para INSERT
                    codigo = req.getParameter("codigo");
                    nombre = req.getParameter("nombre");
                    apellido = req.getParameter("apellido");
                    area = req.getParameter("area");
                    contrasena = req.getParameter("contrasena");

                    usuario = new Usuario(codigo,nombre,apellido,area,contrasena,true);

                    if (usuarioDAO.insert(usuario)) {
                        System.out.println("Usuario creado");
                    }
                    else {
                        System.out.println("Usuario no creado");
                    }

                    resp.sendRedirect("SvUsuarios");

                    break;
                case "vista-editar":
                    //Redirección a la vista editarUsuario.jsp
                    codigo = req.getParameter("codigo");
                    usuario = usuarioDAO.getByCodigo(codigo);
                    req.setAttribute("usuario",usuario);
                    req.getRequestDispatcher("editarUsuario.jsp").forward(req, resp);
                    break;
                case "editar":
                    //DAO para UPDATE
                    id = Integer.parseInt(req.getParameter("id"));
                    nombre = req.getParameter("nombre");
                    apellido = req.getParameter("apellido");
                    area = req.getParameter("area");
                    contrasena = req.getParameter("contrasena");

                    usuario = new Usuario(id,"",nombre,apellido,area,contrasena,true);

                    if (usuarioDAO.update(usuario)) {
                        System.out.println("Usuario editado");
                    }
                    else {
                        System.out.println("Usuario no editado");
                    }

                    resp.sendRedirect("SvUsuarios");
                    break;
                case "eliminar":
                    //DAO para DELETE
                    id = Integer.parseInt(req.getParameter("id"));
                    usuarioDAO.delete(id);

                    resp.sendRedirect("SvUsuarios");
                    break;
                default:
                    // Si la acción no es reconocida, maneja el error
                    resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Acción no válida");
                    break;
            }
        }
    }
}
