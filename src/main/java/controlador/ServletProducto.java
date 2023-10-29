package controlador;

import dao.DaoProducto;
import models.Productocl2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ServletProducto extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public ServletProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

    DaoProducto dao = new DaoProducto();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Productocl2> list = dao.ListarProducto();
        request.setAttribute("list",list);
        request.getRequestDispatcher("Productos.jsp").forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion =  request.getParameter("accion");
        switch (accion) {
            case "guardar":
                Productocl2 pr = new Productocl2();
                pr.setId(Integer.parseInt(request.getParameter("id")));
                pr.setNombrecl2(request.getParameter("nombrecl2"));
                pr.setPrecioventacl2(Double.parseDouble(request.getParameter("precioventacl2")));
                pr.setPreciocompcl2(Double.parseDouble(request.getParameter("preciocompcl2")));
                pr.setEstadocl2(request.getParameter("estadocl2"));
                pr.setDescripcl2(request.getParameter("descripcl2"));
                if (pr.getId() != 0) {
                    dao.ActualizarProducto(pr);
                } else {
                    dao.AgregarProducto(pr);
                }
                break;
            case "eliminar":
                int codigo = Integer.parseInt(request.getParameter("idEliminar"));
                dao.EliminarProducto(codigo);
                break;
        }

        response.sendRedirect("ServletProducto");
    }
}
