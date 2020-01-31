
package admin;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author natal
 */

public class Servlet1 extends HttpServlet {
float resultado;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");
            float a = Float.parseFloat(request.getParameter("A"));
            float b = Float.parseFloat(request.getParameter("B"));
            float c = Float.parseFloat(request.getParameter("C"));
            float raiz = (float) Math.sqrt((float)Math.pow(b,2)+(4*a*c));
            resultado = (-1*b + raiz)/(2*a);
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet1</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Resultado "+resultado+" </h1>");
            out.println("</body>");
            out.println("</html>");
    }
}
