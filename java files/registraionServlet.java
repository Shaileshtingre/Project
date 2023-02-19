package J2EEMiniProject;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/addcust")
public class registraionServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=req.getParameter("name");
		String cno=req.getParameter("cno");
		String email=req.getParameter("email");
		String location=req.getParameter("location");
		
		try
		{	
			Class .forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager .getConnection("jdbc:mysql://localhost:3306/miniproject","root","Tiger@5031");
			
			PreparedStatement ps=con.prepareStatement("insert into customer(name,cno,email,Location) values(?,?,?,?)");
			ps.setString(1, name);
			ps.setString(2, cno);
			ps.setString(3, email);
			ps.setString(4, location);
			ps.execute();
			
				PrintWriter pw=resp.getWriter();
				pw.write("Registration Successfully...!!");
				RequestDispatcher rd=req.getRequestDispatcher("User.html");
				rd.include(req, resp);
				resp.setContentType("text/html");
				
		}
		catch (Exception e) {
//			e.getMessage();
			PrintWriter pw=resp.getWriter();
			pw.write("Registration Unsuccessful Contact no./Email id are already exits...!!");
			RequestDispatcher rd=req.getRequestDispatcher("Registration.html");
			rd.include(req, resp);
			resp.setContentType("text/html");
		}
	}

}
