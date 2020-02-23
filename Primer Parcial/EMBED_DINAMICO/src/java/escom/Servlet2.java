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
 
        int numero_i = Integer.parseInt(numero);

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet1</title>");
            out.println("</head>");
            out.println("<body>");
            
            for(int i = 0; i < numero_i ; i ++){
                String nombrevideo = (String) session.getAttribute(("nombrevideo")+i);
                out.println("<figure>");
                out.println("<embed src='"+nombrevideo+"'/></br>");
                out.println("<figcaption>Imagenes : "+i+"</figcaption>");
                out.println("</figure>");
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

}
