package controlador;

import dao.DaoUsuario;
import models.TblUsuariocl2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletLogin extends HttpServlet{
    private static final long serialVersionUID = 1L;
    public ServletLogin() {
        super();
    }

    DaoUsuario dao = new DaoUsuario();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("username");
        String pass = request.getParameter("password");
        System.out.println("pass = " + pass);
        System.out.println("user = " + user);
        TblUsuariocl2 logout = dao.Login(user, pass);

        if (logout != null) {
            request.getSession().setAttribute("user", logout);
            response.sendRedirect("ServletProducto");
        }
        else {
            System.out.println("logout.getUsuariocl2() = ");
            response.sendRedirect("ServletLogin");
        }
    }
}
