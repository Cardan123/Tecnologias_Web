package escom;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Servlet1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");
            String filas = request.getParameter("filas");
            String columnas = request.getParameter("columnas");
            HttpSession session = request.getSession();
            session.setAttribute("clave_filas",filas);
            session.setAttribute("clave_columnas",columnas);
            int filas_i = Integer.parseInt(filas);
            int columnas_i =  Integer.parseInt(columnas);
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet1</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<form action='Servlet2' method='get'>");
            
            for(int i = 0; i < filas_i ; i++)
                for(int x = 0; x < columnas_i ; x++){
                    out.println("Contenido fila: "+(i+1)+" columna : "+(x+1)+"");
                    out.println("Contenido de la tabla <input type='text' name='contenido_"+i+"_"+x+"' /></br>");
                }
            
            out.println("<input type='submit' />");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
    }
}
