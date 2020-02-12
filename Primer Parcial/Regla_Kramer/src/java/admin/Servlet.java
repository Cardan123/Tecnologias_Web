
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

public class Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");
            float x1 = Float.parseFloat(request.getParameter("parametro_x1"));
            float y1 = Float.parseFloat(request.getParameter("parametro_y1"));
            float z1 = Float.parseFloat(request.getParameter("parametro_z1"));
            float r1 = Float.parseFloat(request.getParameter("parametro_r1"));
            float x2 = Float.parseFloat(request.getParameter("parametro_x2"));
            float y2 = Float.parseFloat(request.getParameter("parametro_y2"));
            float z2 = Float.parseFloat(request.getParameter("parametro_z2"));
            float r2 = Float.parseFloat(request.getParameter("parametro_r2"));
            float x3 = Float.parseFloat(request.getParameter("parametro_x3"));
            float y3 = Float.parseFloat(request.getParameter("parametro_y3"));
            float z3 = Float.parseFloat(request.getParameter("parametro_z3"));
            float r3 = Float.parseFloat(request.getParameter("parametro_r3"));
            
            float d=(x1*y2*z3)+(y1*z2*x3)+(z1*x2*y3)-(z1*y2*x3)-(x1*z2*y3)-(y1*x2*z3);
            float x=(r1*y2*z3)+(y1*z2*r3)+(z1*r2*y3)-(z1*y2*r3)-(r1*z2*y3)-(y1*r2*z3);
            float y=(x1*r2*z3)+(r1*z2*x3)+(z1*x2*r3)-(z1*r2*x3)-(x1*z2*r3)-(r1*x2*z3);
            float z=(x1*y2*r3)+(y1*r2*x3)+(r1*x2*y3)-(r1*y2*x3)-(x1*r2*y3)-(y1*x2*r3);
            float dx=x/d,dy=y/d,dz=z/d;
            
            
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Calculadora de Cramer</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> El resultado por el metod de cramer es: </h1><br />");
            out.println("<h1> "+x1+" X "+y1+" Y "+z1+" Z = "+r1+"<br />");
            out.println("<h1> "+x2+" X "+y2+" Y "+z2+" Z = "+r2+"<br />");
            out.println("<h1> "+x3+" X "+y3+" Y "+z3+" Z = "+r3+"<br />");
            out.println("El valor de la determinante es: "+ d+"<br />");
            out.println("El valor de la determinante de X: "+ dx+"<br />");
            out.println("El valor de la determinante de Y: "+ dy+"<br />");
            out.println("El valor de la determinante de Z: "+ dz+"<br />");
            out.println("</body>");
            out.println("</html>");
    }
}