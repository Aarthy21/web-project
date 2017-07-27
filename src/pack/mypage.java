package pack;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class mypage extends HttpServlet
{
	private static final long serialVersionUID = 1L;
    public mypage()
    {
        super();
        
    }
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    response.setContentType("text/html");
	        String name=request.getParameter("name"); 
	        PrintWriter writer = response.getWriter();
	        String message=name ;
	        writer.println(message);
	        String[] command = {"CMD", "/C", "start", "C:\\curator-4.2.5-win32\\curator.exe", "--config","C:\\curator-4.2.5-win32\\config.yml","C:\\curator-4.2.5-win32\\snapshot.yml"};
	        ProcessBuilder pb = new ProcessBuilder(command);
	        File f = new File("C:\\curator-4.2.5-win32");
	        pb.redirectErrorStream(true);
	        pb.directory(f);
	        System.out.println(name);
	        Process p = pb.start();
	        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
	        String line;
	        while (true) {
	        line = br.readLine();
	        if (line == null) 
	        { 
	        	break;
            }
	        System.out.println(line);
	        }
    	  
       }
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
