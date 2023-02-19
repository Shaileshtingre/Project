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
@WebServlet("/cancelb")
public class CancelBookServ extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bid=req.getParameter("bid");
		int bid1=Integer.parseInt(bid);
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject","root","Tiger@5031");
			
			PreparedStatement ps=con.prepareStatement("Delete from carbooking where bid=?");
			ps.setInt(1, bid1);
			
			int rs=ps.executeUpdate();
			
			HttpSession hs=req.getSession();
			hs.setAttribute("cancelbooking", rs);
			
			RequestDispatcher rd=req.getRequestDispatcher("CancelBooking.jsp");
			rd.forward(req, resp);
		}
		catch (Exception e) {
			e.getMessage();
		}
	}
}

