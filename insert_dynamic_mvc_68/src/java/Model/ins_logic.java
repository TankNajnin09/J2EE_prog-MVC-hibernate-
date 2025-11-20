/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.sql.*;

/**
 *
 * @author TANK1
 */
public class ins_logic 
{
    public void ins_method(user_data obj)
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","");
            
            String sql="INSERT INTO stud(name,password,mobile_no) VALUES (?,?,?)";
            
            PreparedStatement pst=conn.prepareStatement(sql);
            pst.setString(1,obj.getNm());
            pst.setString(2,obj.getPwd());
            pst.setString(3,obj.getMob());
            pst.executeUpdate();
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
