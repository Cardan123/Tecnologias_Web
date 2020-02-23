package escom;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Servlet3 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");
            HttpSession session=request.getSession();
            String numero = (String)session.getAttribute("clave_numero");
            int numero_i =  Integer.parseInt(numero);
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet1</title>");            
            out.println("</head>");
            out.println("<body>");
            for(int i = 0; i < numero_i ; i++){
                 out.println("<a href = '"+ request.getParameter("href_"+i)+"' target='contenido'>"+ request.getParameter("contenido_"+i)+"</a> <br />");
            }
           
            out.println("</body>");
            out.println("</html>");
    }
}