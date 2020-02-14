
package escom;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author natal
 */

public class Servlet0 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");
            String numero = request.getParameter("numero");
            HttpSession session =  request.getSession();
            session.setAttribute("clavei",numero);
            int numero_i =Integer.parseInt(numero);
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet1</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<form method = 'get' action = 'Servlet1'>");
            for(int i = 0; i < numero_i; i++){
            out.println("Circulo : "+i+"<br />");
            out.println("Cordenada de X : <input type='text' name='xc_"+i+"' /> <br />");
            out.println("Cordenada de Y : <input type='text' name='yc_"+i+"' /> <br />");
            out.println("Radio : <input type='text' name='rc_"+i+"' /> <br />");
            }
            out.println("<input type='submit' />");
            out.println("");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
    }
}
