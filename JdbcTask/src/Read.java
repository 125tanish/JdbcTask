

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Read
 */
@WebServlet("/Read")
public class Read extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");      
	    	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/innostudents","root","root");
	    	String qr="select * from student";
	    	Statement st=con.createStatement();
	    	ResultSet rs=st.executeQuery(qr);
	    	if(rs.next())
	    	{
	    		out.println("<table align='center' border='1px'>");
	    		out.println("<th>Id</th>");
	    		out.println("<th>Name</th>");
	    		out.println("<th>Email</th>");
	    		out.println("<th>Address</th>");
	    		//out.println("<th>Phone<\th>");
	    		out.println("<th>Phone</th>");
	    		do
	    		{
	    			String sid=rs.getString("id");
					int id=Integer.parseInt(sid);
					String name=rs.getString("name");
					String email=rs.getString("email");
					String address=rs.getString("address");
					String phone=rs.getString("phone");
					out.println("<tr>");
					out.println("<form>");
					out.println("<td>");
					out.println("<input type=number name=id value="+id+">");
					out.println("</td>");
					out.println("<td>");
					out.println("<input type=text name=name value="+name+" />");
					out.println("</td>");
					out.println("<td>");
					out.println("<input type=text name=email value="+email+" />");
					out.println("</td>");
					out.println("<td>");
					out.println("<input type=text name=address value="+address+" />");
					out.println("</td>");
					out.println("<td>");
					out.println("<input type=text name=phone value="+phone+" />");
					out.println("</td>");
					out.println("</form>");
					out.println("<\tr>");
	    		}while(rs.next());
	    		out.println("</table>");
	    	}
		}catch(Exception e)
		{
			out.println("table not exist");
		}
	}

}
