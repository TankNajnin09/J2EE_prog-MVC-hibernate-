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
public class stud_data {
    
    private String cr;
    private int sem;

    public stud_data(String cr, int sem) {
        this.cr = cr;
        this.sem = sem;
    }

    public String getCr() {
        return cr;
    }

    public int getSem() {
        return sem;
    }
    
}
