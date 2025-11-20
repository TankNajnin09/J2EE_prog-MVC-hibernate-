/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package demo_pack;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.*;

/**
 *
 * @author TANK1
 */
public class dis_product {
    
    public static void main(String[] args)
    {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
         
        SessionFactory factory = cfg.buildSessionFactory();
        Session session=factory.openSession();
         
        
        try
        {
            Transaction t;
         
        Product pr=new Product();
         
            t=session.beginTransaction();
            List products = session.createQuery("FROM Product").list();
            Iterator i = products.iterator();
            
            System.out.println("\nID\t\tName\t\tPrice");
            
            while(i.hasNext())
            {
                pr = (Product)i.next();
                System.out.print("\n\n" + pr.getId() + "\t\t" + pr.getName() + "\t\t" + pr.getPrice());
            }
        }
        catch(Exception e)
        {
            System.out.print("Error : " + e);
        }
    }
    
}
