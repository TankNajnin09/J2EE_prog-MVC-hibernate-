/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

/**
 *
 * @author TANK1
 */
public class emp_data {
    
    private int no;
    private String nm;
    private String des;
    private String dep;

    public emp_data(String nm, String des, String dep) {
        this.nm = nm;
        this.des = des;
        this.dep = dep;
    }

    public int getNo() {
        return no;
    }

    public String getNm() {
        return nm;
    }

    public String getDes() {
        return des;
    }

    public String getDep() {
        return dep;
    }
    
    
}
