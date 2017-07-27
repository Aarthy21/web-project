package pack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.File;
import org.omg.CORBA.portable.InputStream;

import com.sun.javafx.collections.MappingChange.Map;

/**
 * Servlet implementation class sam
 */
public class sam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sam() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");  
		PrintWriter pw=response.getWriter();  
		  
		response.sendRedirect("new.html");  
		  
		pw.close();  */
		String[] command = { "cmd.exe","/C","start"};
		        final ProcessBuilder pb = new ProcessBuilder(command);
		        Map<String, String> env = (Map<String, String>) pb.environment();
		        ((java.util.Map<String, String>) env).put("PATH", "C:\\curator-4.2.5-win32");
		        ((java.util.Map<String, String>) env).put("HTMLFile", "new.html");
		        ((java.util.Map<String, String>) env).put("XMLFile", "web.xml");
		        pb.directory( );
		      try
		      {
		            Process process = pb.start();
		            InputStream err = (InputStream) process.getErrorStream();
		            InputStreamReader isr = new InputStreamReader(err);
		            BufferedReader br = new BufferedReader(isr);
		            String line;
		            while ((line = br.readLine()) != null) 
		            {
		                System.out.println(line);
		            }
		        }
		        catch(Exception e)
		        {
		            e.printStackTrace();
		        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
