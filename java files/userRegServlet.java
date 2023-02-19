package J2EEMiniProject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/useradd")
public class userRegServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		String cno=req.getParameter("cno");
		String email=req.getParameter("email");
		
		long cno1=Long.parseLong(cno);
		
		try
		{
			Class .forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager .getConnection("jdbc:mysql://localhost:3306/miniproject","root","Tiger@5031");
			
			PreparedStatement ps=con.prepareStatement("insert into user(username,password,cno,email) values(?,?,?,?)");
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setLong(3, cno1);
			ps.setString(4, email);
			ps.execute();
			
			RequestDispatcher rd=req.getRequestDispatcher("UserReg.html");
			rd.forward(req, resp);
			
		}
		catch (Exception e) {
			e.getMessage();
		}
	}

}
