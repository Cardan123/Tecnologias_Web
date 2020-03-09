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
            String ruta="";
            ruta = this.getServletContext().getRealPath("/");
		try
		{
			Element raiz = new Element("struts-config");
			Element hoja = new Element("form-beans");
                        Element hoja1 = new Element("form-bean");
                        hoja1.setAttribute("name", "ActionForm1");
                        hoja1.setAttribute("type", "admin.ActionForm1");
			//hoja.setAttribute("numerodehojas", "4"); //Establece los atributos xml
			hoja.setText(" "); //crea el nodo raiz con el valor
			raiz.addContent(hoja); //Agrega una hoja 
                        raiz.addContent(hoja1); //Agrega una hoja 
  
  
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
