

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Insert
 */
@WebServlet("/Insert")
public class Insert extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text.html");
		//String sid=request.getParameter("id");
		//int id=Integer.parseInt(sid);
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		String phone=request.getParameter("phone");
		try
	       {
	    	   Class.forName("com.mysql.cj.jdbc.Driver");      
	    	   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/innostudents","root","root");
	    	   String qr="insert into student(name,email,address,phone) values(?,?,?,?)";
	    	   PreparedStatement ps=con.prepareStatement(qr);
	    	   //ps.setInt(1,id);
	    	   ps.setString(1,name);
	    	   ps.setString(2,email);
	    	   ps.setString(3,address);
	    	   ps.setString(4,phone);
	    	   int i=ps.executeUpdate();
	    	   out.println(i+"value added");
	    	   //response.getWriter().
	    	   //out.print("value added");
	    	   con.close();
	       }catch(Exception e)                             
	       {
	    	   //e.printStackTrace();
	    	   out.println("table not exist");
	       }
	}

}
