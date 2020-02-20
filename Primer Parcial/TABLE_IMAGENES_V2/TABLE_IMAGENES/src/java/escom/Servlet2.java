package escom;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Servlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");
            HttpSession session = request.getSession();
            String filas = (String) session.getAttribute("clave_filas");
            String columnas = (String) session.getAttribute("clave_columnas");
            String imagenes = (String) session.getAttribute("imagenes");
            String nombrevideo="";
            int filas_i= Integer.parseInt(filas);
            int columnas_i = Integer.parseInt(columnas);
            int imagenes_i = Integer.parseInt(imagenes);
            
            
            
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet1</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<table border='1'>");
            for (int i = 0; i < filas_i ; i++){
                out.println("<tr>");
                for(int x = 0; x < columnas_i; x++){
                    nombrevideo = (String) session.getAttribute(("nombrevideo")+(i+x));
                    out.println("<td><a href='" + request.getParameter("reference_"+i+"_"+x) + "'><img src='"+nombrevideo+"' alt='Descripción de la imagen' width='100' height='100'></a></td>");
                }
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
    }
}
