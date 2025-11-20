package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.*; // Correct package import

@WebServlet("/stud_data")
public class display_info extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            // Get parameters from form
            String cr = request.getParameter("txt_cor");
            String se = request.getParameter("txt_sem");
            int sem = Integer.parseInt(se);

            // Create data object
            stud_data user = new stud_data(cr, sem);

            try {
                // Load driver and connect to database
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "");

                // Prepare SQL query (fixed)
                String sql = "SELECT * FROM student WHERE course=? AND semester=?";
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, user.getCr());
                pst.setInt(2, user.getSem());

                ResultSet rs = pst.executeQuery();

                // HTML Output
                out.println("<html><body>");
                out.println("<h2>Student Information</h2>");
                out.println("<table border='1' cellpadding='10'>");
                out.println("<tr><th>ID</th><th>Name</th><th>Course</th><th>Semester</th></tr>");
                
                while (rs.next()) {
                    out.println("<tr>");
                    out.println("<td>" + rs.getInt("id") + "</td>");
                    out.println("<td>" + rs.getString("name") + "</td>");
                    out.println("<td>" + rs.getString("course") + "</td>");
                    out.println("<td>" + rs.getInt("semester") + "</td>");
                    out.println("</tr>");
                }

                out.println("</table>");
                out.println("</body></html>");

                // Close connection
                conn.close();

            } catch (Exception e) {
                out.println("<p>Error: " + e.getMessage() + "</p>");
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Servlet to display student info based on course and semester.";
    }
}
