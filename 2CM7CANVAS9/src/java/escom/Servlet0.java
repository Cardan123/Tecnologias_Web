
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
            out.println("Punto: "+i+"<br />");
            out.println("Cordenada de Xi : <input type='text' name='xi_"+i+"' /> <br />");
            out.println("Cordenada de Yi : <input type='text' name='yi_"+i+"' /> <br />");
            out.println("Cordenada de Xf : <input type='text' name='xf_"+i+"' /> <br />");
            out.println("Cordenada de Yf : <input type='text' name='yf_"+i+"' /> <br />");
            }
            out.println("<input type='submit' />");
            out.println("");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
    }
}
