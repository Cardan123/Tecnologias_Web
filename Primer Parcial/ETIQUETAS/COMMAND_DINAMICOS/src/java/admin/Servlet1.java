package admin;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Servlet1 extends HttpServlet {//Modificador de clase (public), Encapsulamiento class, extends herencia

    @Override//Cancelar
    protected void doGet(HttpServletRequest request, HttpServletResponse response)//Response Enviamos info. al cliente
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");//Tipo que mandamos de info, nunca quitar, se podria, pero seria dejar al nevegador intepretarlo solo NO RECOMENDADO
        try (PrintWriter out = response.getWriter()) {//Canal de salida para el cliente.
            /* TODO output your page here. You may use following sample code. */
            String numero = request.getParameter("numero");
            int numeroi = Integer.parseInt(numero);
            HttpSession session = request.getSession();
            session.setAttribute("numerolinks", numero);
            out.println("<!DOCTYPE html>");//Tipo de documento HTML5
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet1</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<form method='get' action='Servlet2'>");
            for (int i = 0; i < numeroi; i++) {
                out.print("COMANDO : <input type='text' name='reference"+i+"'/><br />");
                out.print("JAVASCRIPT: <input type='text' name='texto"+i+"'/><br/>");
            }
            out.print("<input type='submit'>");
            out.print("</form>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
