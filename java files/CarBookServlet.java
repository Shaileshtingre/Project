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
@WebServlet("/carbook")
public class CarBookServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cartype=req.getParameter("cartype");
		String from=req.getParameter("from");
		String to=req.getParameter("to");
		String startdate=req.getParameter("startdate");
		String enddate=req.getParameter("enddate");
		String cno=req.getParameter("cno");
		
		java.sql.Date startdate2=java.sql.Date.valueOf(startdate);
		java.sql.Date enddate2=java.sql.Date.valueOf(enddate);
		
		try
		{
			Class .forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject","root","Tiger@5031");
			
			PreparedStatement ps=con.prepareStatement("insert into carbooking(cartype,locfrom,locto,startdate,enddate,cno) values(?,?,?,?,?,?)");
			
			ps.setString(1, cartype);
			ps.setString(2, from);
			ps.setString(3, to);
			ps.setDate(4, startdate2);
			ps.setDate(5, enddate2);
			ps.setString(6, cno);
			
			ps.execute();
			
			RequestDispatcher rd=req.getRequestDispatcher("User.html");
			rd.forward(req, resp);
			
		}
		catch (Exception e) {
			e.getMessage();
		}
	}
}
