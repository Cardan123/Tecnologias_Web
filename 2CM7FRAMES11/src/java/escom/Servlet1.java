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
            String numero = (String)request.getParameter("numero");
            HttpSession session=request.getSession();
            session.setAttribute("clave_numero", numero);
            int numero_i =  Integer.parseInt(numero);
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet1</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<form action='Servlet2' method='get'>");
            for(int i = 0; i < numero_i ; i++){
                out.println("Hipervinculo : "+i+" <br />");
                out.println("Href : <input type='text' name='href_"+i+"' /> <br />");
                out.println("Contedio : <input type='text' name='contenido_"+i+"' /> <br />");
            }
            out.println("<input type='submit' />");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
    }
}