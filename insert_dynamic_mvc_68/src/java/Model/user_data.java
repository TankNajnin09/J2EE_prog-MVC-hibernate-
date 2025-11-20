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
public class user_data 
{
    private String nm;
    private String pwd;
    private String mob;

    public user_data(String nm, String pwd, String mob) {
        this.nm = nm;
        this.pwd = pwd;
        this.mob = mob;
    }

    public String getNm() {
        return nm;
    }

    public String getPwd() {
        return pwd;
    }

    public String getMob() {
        return mob;
    }

}
