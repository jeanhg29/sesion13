package pe.isil.itam.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pe.isil.itam.dao.ActivoDAO;
import pe.isil.itam.dao.EstadoDAO;
import pe.isil.itam.dao.UsuarioDAO;
import pe.isil.itam.model.Activo;
import pe.isil.itam.model.Estado;
import pe.isil.itam.model.Usuario;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class SvActivos
 */
@WebServlet("/SvActivos")
public class SvActivos extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ActivoDAO activoDAO;
    private UsuarioDAO usuarioDAO;
    private EstadoDAO estadoDAO;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SvActivos() {
        super();
        activoDAO = new ActivoDAO();
        usuarioDAO = new UsuarioDAO();
        estadoDAO = new EstadoDAO();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Activo> listaActivos = activoDAO.getAll();

        request.setAttribute("listaActivos", listaActivos);

        request.getRequestDispatcher("activos.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");

        Activo activo;
        String nombre;
        String tipo;
        String marca;
        String modelo;
        String numSerie;

        Usuario usuario;
        String codigo;

        Estado estado;
        int idEstado;


        if (accion != null) {
            switch (accion) {
                case "crear":
                    //DAO para INSERT
                    nombre = request.getParameter("nombre");
                    tipo = request.getParameter("tipo");
                    marca = request.getParameter("marca");
                    modelo = request.getParameter("modelo");
                    numSerie = request.getParameter("numSerie");

                    idEstado = Integer.parseInt(request.getParameter("estado"));
                    estado = estadoDAO.getById(idEstado);

                    codigo = request.getParameter("codigo");

                    if (codigo.isEmpty()) {
                        usuario = null;
                    }
                    else {
                        usuario = usuarioDAO.getByCodigo(codigo);
                    }

                    activo = new Activo(nombre,tipo,marca,modelo,numSerie,estado,usuario);

                    if (activoDAO.insert(activo)) {
                        System.out.println("Activo creado");
                    }
                    else {
                        System.out.println("Activo no creado");
                    }

                    break;
                case "editar":
                    //DAO para UPDATE
                    break;
                case "eliminar":
                    //DAO para DELETE
                    break;
                default:
                    // Si la acción no es reconocida, maneja el error
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Acción no válida");
                    break;
            }
        }

        response.sendRedirect("SvActivos");

    }


}
