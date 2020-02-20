package escom;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Servlet0 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String imagenes = (String) session.getAttribute("imagenes");
        String filas = (String)session.getAttribute("clave_filas");
        String columnas = (String) session.getAttribute("clave_columnas");
        session.setAttribute("clave_filas",filas);
        session.setAttribute("imagenes",imagenes);
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
             out.println("<form action = 'Servlet2' method = 'get'>");
            for (int i = 0; i < filas_i; i++) 
                for(int x = 0; x < columnas_i ; x++){
                    out.println("LINK    fila: "+(i+1)+" columna : "+(x+1)+"");
                    out.print("HREF : <input type='text' name='reference_"+i+"_"+x+"'/></br>");
                }
            
            out.print("<input type = 'submit' >");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
    }
}
