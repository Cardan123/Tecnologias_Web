/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escom;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Edmundo J Sanchez M
 */
public class Servlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session =  request.getSession();
        String numero = (String) session.getAttribute("numero");
        String posicion = (String) session.getAttribute("posicion");
        int numeroi = Integer.parseInt(numero);
        int posicioni = Integer.parseInt(posicion);
        
        if(posicioni < numeroi-1){
             posicioni++;
        }
        
        String nombrevideo = (String) session.getAttribute(("nombrevideo")+posicioni);
        session.setAttribute("posicion", Integer.toString(posicioni));
        
        
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet1</title>");
            out.println("</head>");
            out.println("<body>");
             out.println("<audio controls>");
            out.println("<source src='"+nombrevideo+"' type='audio/mpeg' />");
            out.println("</audio>");;
            out.println("<form method='get' action='Servlet2'>");
            out.print("<input type = 'submit' value = 'Adelante' />");
            out.print("</form>");
            out.println("<form method='get' action='Servlet3'>");
            out.print("<input type = 'submit' value = 'ATRAS' />");
            out.print("</form>");
            out.println("</body>");
            out.println("</html>");
        }
    }

}
