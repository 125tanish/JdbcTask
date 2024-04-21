

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");      
	    	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/innostudents","root","root");
	    	String qr="delete from student where id=?";
	    	PreparedStatement ps=con.prepareStatement(qr);
	    	ps.setInt(1, id);
	    	int i=ps.executeUpdate();
	    	out.println(i+" value deleted");
	    	
	    	con.close();
		}
		catch(Exception e)
		{
			out.println("table not exist");
		}
	}

}
