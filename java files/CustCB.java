package J2EEMiniProject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/cb")
public class CustCB extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cno=req.getParameter("cno");
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject","root","Tiger@5031");
			
			PreparedStatement ps=con.prepareStatement("select * from customer where cno=?");
			ps.setString(1, cno);
			ResultSet rs=ps.executeQuery();
			
			HttpSession hs=req.getSession();
			hs.setAttribute("custdetails", rs);
			
			RequestDispatcher rd=req.getRequestDispatcher("CustomerCB.jsp");
			rd.forward(req, resp);
		}
		catch (Exception e) {
			e.getMessage();
		}
	}
}
