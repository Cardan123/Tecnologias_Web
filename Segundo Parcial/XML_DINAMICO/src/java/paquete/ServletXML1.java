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
            ruta = this.getServletContext().getRealPath("/XML");
		try
		{
			Element raiz = new Element("struts-config");
			Element hoja = new Element("form-bean");
                        Element hoja1 = new Element("form-beans");
                        
                        hoja.setAttribute("name", "ActionForm1");
                        hoja.setAttribute("type", "admin.ActionForm1");		
                        hoja1.addContent(hoja);
                        
                        Element hoja2 = new Element("global-exceptions");
                        
                        hoja2.setText("\n"); 
                        
                        Element hoja3 = new Element("global-forwards");
                        Element hoja4 = new Element("forward");
                        
                        hoja4.setAttribute("name","welcome");
                        hoja4.setAttribute("path","/Welcome.do");
                        
                        hoja3.addContent(hoja4);
                        
                        hoja4 = new Element("forward");
                        
                        hoja4.setAttribute("name","sucess");
                        hoja4.setAttribute("path","/exitoso.jsp");
                        
                        hoja3.addContent(hoja4);
                        
                        hoja4 = new Element("forward");
                        
                        hoja4.setAttribute("name","fail");
                        hoja4.setAttribute("path","/fracaso.jsp");
                        
                        hoja3.addContent(hoja4);
                        
                        Element hoja5 = new Element("action-mappings");
                        Element hoja6 = new Element("action");
                        
                        hoja6.setAttribute("input","/input.jsp");
                        hoja6.setAttribute("name","ActionForm1");
                        hoja6.setAttribute("path","/Accion");
                        hoja6.setAttribute("scope","session");
                        
                        hoja5.addContent(hoja6);
                        
                        hoja6 = new Element("action");
                        
                        hoja6.setAttribute("path","/Welcome");
                        hoja6.setAttribute("forward","/welcomeStruts.jsp");
                        
                        hoja5.addContent(hoja6);
                        
                        Element hoja7 = new Element("controller");
                        
                        hoja7.setAttribute("processorClass","org.apache.struts.tiles.TilesRequestProcessor");
                        
                        Element hoja8 = new Element("message-resource");
                        
                        hoja8.setAttribute("parameter","com/myapp/struts/ApplicationResource"); 
                        
                        Element hoja9 = new Element("plug-in");
                        
                        hoja9.setAttribute("className","org.apache.struts.titles.TilesPlugin");
                        
                        Element hoja10 = new Element("set-property");
                        
                        hoja10.setAttribute("property","definitions-config");
                        hoja10.setAttribute("value","/WEB-INF/titles-defs.xml");
                        hoja9.addContent(hoja10);
                        
                        hoja10 = new Element("set-property");
                        
                        hoja10.setAttribute("property","moduleAware");
                        hoja10.setAttribute("value","true");
                        hoja9.addContent(hoja10);
                        
                        Element hoja11 = new Element("plug-in");
                        
                        hoja11.setAttribute("className","org.apache.struts.validator.ValidatorPlugIn");
                        
                        Element hoja12 = new Element("set-property");
                        
                        hoja12.setAttribute("property","pathnames   ");
                        hoja12.setAttribute("value","/WEB-INF/validator-rules.xml,/WEB-INF/validation.xml");
                        hoja11.addContent(hoja12);
                        
                        raiz.addContent(hoja1); 
                        raiz.addContent(hoja2); 
                        raiz.addContent(hoja3);
                        raiz.addContent(hoja5);
                        raiz.addContent(hoja7);
                        raiz.addContent(hoja8);
                        raiz.addContent(hoja9);
                        raiz.addContent(hoja11);
  
                        //hoja.setAttribute("numerodehojas", "4"); //Establece los atributos xml
			// hoja.setText(" "); //crea el nodo raiz con el valor
                        
  
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
