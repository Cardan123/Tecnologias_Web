package admin;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Servlet2 extends HttpServlet {//Modificador de clase (public), Encapsulamiento class, extends herencia

    @Override//Cancelar
    protected void doGet(HttpServletRequest request, HttpServletResponse response)//Response Enviamos info. al cliente
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");//Tipo que mandamos de info, nunca quitar, se podria, pero seria dejar al nevegador intepretarlo solo NO RECOMENDADO
        try (PrintWriter out = response.getWriter()) {//Canal de salida para el cliente.
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession();
            String numero = (String) session.getAttribute("numerolinks");
            int numeroi = Integer.parseInt(numero);
            out.println("<!DOCTYPE html>");//Tipo de documento HTML5
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet1</title>");
            out.println("<base href="+request.getParameter("reference")+" target='_blank'>");
            out.println("</head>");
            out.println("<body>");
         
            for (int i = 0; i < numeroi; i++) {
                out.println(request.getParameter("texto_"+i));
                out.println("</br>");
            }
            out.println("</map>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
