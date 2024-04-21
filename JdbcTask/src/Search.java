

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		boolean present=false;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");      
	    	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/innostudents","root","root");
	    	String qr="select * from student where id=?";
	    	PreparedStatement ps=con.prepareStatement(qr);
	    	ps.setInt(1,id);
	    	ResultSet rs=ps.executeQuery();
	    	while(rs.next())
	    	 {
	    		out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") +",Email: "+rs.getString("email")+",Address: "+rs.getString("address")+",Phone: "+rs.getString("phone"));
	    		present=true;
	    	 }
	    	if(present==false)
	    	{
	    		out.println("no record found");
	    	}
		}catch(Exception e)
		{
			out.println("table not exist");
		}
	}

}
