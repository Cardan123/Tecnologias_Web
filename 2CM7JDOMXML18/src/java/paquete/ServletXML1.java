package paquete;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jdom.*;
import org.jdom.output.XMLOutputter;
import java.io.PrintWriter;
import java.io.FileWriter;

/**
 * Servlet implementation class Servlet1
 */
public class ServletXML1 extends HttpServlet {
//	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
            String raiz1 =  request.getParameter("raiz");
            String hijo =  request.getParameter("hijo");
            String atributo =  request.getParameter("att");
            String valor =  request.getParameter("valor");
            String nodo =  request.getParameter("nodo");
            
            String ruta="";
            ruta = this.getServletContext().getRealPath("/XML");
		try
		{
			Element raiz = new Element(raiz1);
			Element hoja = new Element(hijo);
			hoja.setAttribute(atributo, valor); //Establece los atributos xml
			hoja.setText(nodo); //crea el nodo raiz con el valor
			raiz.addContent(hoja); //Agrega una hoja 
  
  
			Document newdoc = new Document(raiz); //le pasa el nodo raiz al documento
			XMLOutputter fmt = new XMLOutputter(); // Constructor por default
			FileWriter writer = new FileWriter(ruta+"/pregunta2.xml"); //Instaciamos un objeto de tipo FIleWriter, le ponemos 
			fmt.output(newdoc, writer);
            // writer.flush(); 
            writer.close(); 
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		

	}


}
