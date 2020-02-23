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
            HttpSession session=request.getSession();
            String numero = (String)session.getAttribute("clave_numero");
            int numero_i =  Integer.parseInt(numero);
            String parametros = "";
            for(int i = 0; i < numero_i ; i++){
                parametros += "href_"+i+"="+request.getParameter("href_"+i)+"&"+"contenido_"+i+"="+request.getParameter("contenido_"+i)+"&";
            }
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<frameset cols='50%,50%'>");
            out.println("<frame src='Servlet3?"+parametros+"' />");
            out.println("<frame src='contenido.html' name='contenido'/>");
            out.println("</frameset>");
            out.println("<title>Servlet Servlet2</title>");            
            out.println("</head>");
            out.println("<noframes>");
            out.println("<body>");
            out.println("");
            out.println("</body>");
            out.println("</noframes>");
            out.println("</html>");
    }
}