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
            String numero = request.getParameter("numero");
            HttpSession session = request.getSession();
            session.setAttribute("numero",numero);
            int numero_i = Integer.parseInt(numero);
          
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet1</title>");            
            out.println("</head>");
            out.println("<body>");
             out.println("<form action = 'UploadServlet' method = 'post' enctype = 'multipart/form-data'>");
            for (int i = 0; i < numero_i; i++) {
                    out.println("Contenido : "+i);
                    out.print(" <input type = 'file' name = 'file' size = '45' /><br />");
            }
            out.print("<input type = 'submit' value = 'Upload File'>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
    }
}
/*

               out.println("<form action = 'UploadServlet' method = 'post' enctype = 'multipart/form-data'>");
            for (int i = 0; i < filas_i; i++) 
                for(int x = 0; x < columnas_i ; x++){
                    out.println("Contenido fila: "+(i+1)+" columna : "+(x+1)+"");
                    out.print("HREF : <input type='text' name='reference_"+i+"_"+x+"'/>");
                    out.print(" <input type = 'file' name = 'file' size = '45' /><br />");
                }
            
            out.print("<input type = 'submit' value = 'Upload File'>");
*/
