package pe.isil.itam.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import pe.isil.itam.dao.UsuarioDAO;
import pe.isil.itam.model.Usuario;

import java.io.IOException;

@WebServlet("/SvLogin")
public class SvLogin extends HttpServlet {
    private UsuarioDAO usuarioDAO;

    public SvLogin() {
        this.usuarioDAO = new UsuarioDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession sesion = req.getSession();

        String codigo = req.getParameter("codigo");
        String contrasena = req.getParameter("contrasena");
        String mensaje = "";
        Boolean esValido = false;

        Usuario usuario = usuarioDAO.getByCodigo(codigo);

        if (codigo == null || codigo.isEmpty() || contrasena == null || contrasena.isEmpty() || usuario == null) {
            mensaje = "Debe ingresar valores correctos para usuario y/o contraseña.";
        }
        else {
            if (usuario.getContrasena().equals(contrasena)) {

                esValido = true;
            }

            if (!esValido) {
                mensaje = "Usuario y/o contraseña incorrectos.";
            }
        }

        if(esValido) {
            sesion.setAttribute("usuario", usuario);
            resp.sendRedirect("dashboard.jsp");
        }
        else {
            req.setAttribute("mensajeError", mensaje);
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }
}
