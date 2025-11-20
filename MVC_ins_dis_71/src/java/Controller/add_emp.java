/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
@WebServlet("/emp_data")

/**
 *
 * @author TANK1
 */
public class add_emp extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String nm=request.getParameter("txt_nm");
            String des=request.getParameter("txt_des");
            String dep=request.getParameter("txt_dep");
            
            emp_data emp=new emp_data(nm,des,dep);
            
            ins_dis_logic obj_ins=new ins_dis_logic();
            
            try
            {
                obj_ins.ins_method(emp);
                out.print("Inserted Successfully...");
                
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","");

                String sql="SELECT * FROM emp";

                Statement st=conn.createStatement();
                ResultSet rs=st.executeQuery(sql);

               // HTML Output
                out.println("<html><body>");
                out.println("<h2>Employee Information</h2>");
                out.println("<table border='1' cellpadding='10'>");
                out.println("<tr><th>Empno</th><th>Empnm</th><th>Designation</th><th>Department</th></tr>");

                while (rs.next()) {
                    out.println("<tr>");
                    out.println("<td>" + rs.getInt("empno") + "</td>");
                    out.println("<td>" + rs.getString("empnm") + "</td>");
                    out.println("<td>" + rs.getString("designation") + "</td>");
                    out.println("<td>" + rs.getString("dept") + "</td>");
                    out.println("</tr>");
                }

                out.println("</table>");
                out.println("</body></html>");

                // Close connection
                conn.close();
                
            }
            catch(Exception e)
            {
               e.printStackTrace();
            }
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
