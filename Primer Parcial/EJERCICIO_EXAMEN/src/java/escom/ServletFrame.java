package escom;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ServletFrame extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8"); 
            HttpSession session=request.getSession();
            String numero = (String)session.getAttribute("numero");
            int numero_i =  Integer.parseInt(numero);
            String parametros = "";
            String parametros1 = "";
            for(int i = 0; i < numero_i ; i++){
                parametros += "reference_"+i+"="+request.getParameter("reference_"+i)+"&"+"contenido_"+i+"="+request.getParameter("contenido_"+i)+"&";
            }
            
          
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<frameset cols='20%,*'>");
            out.println("<frame src='Servlet2?"+parametros+"'name='Imagenes'/>");
            out.println("<frameset rows='15%,85%'>");
            out.println("<frame src='contenido.html' name='titulo'/>");
            out.println("<frame src='contenido.html' name='contenido'/>");
            out.println("</frameset>");
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