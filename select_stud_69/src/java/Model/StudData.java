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
public class StudData {
    
    private String course;
    private int semester;

    // Constructor to initialize student data
    public StudData(String course, int semester) {
        this.course = course;
        this.semester = semester;
    }

    // Getter for course
    public String getCourse() {
        return course;
    }

    // Getter for semester
    public int getSemester() {
        return semester;
    }
}