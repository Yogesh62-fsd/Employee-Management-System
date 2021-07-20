/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empmgmt.pojo;

/**
 *
 * @author dell
 */
public class Employee {

    public Employee()
    {
        
    }
     public Employee(int empNO, String empName, double empSal) {
        this.empNO = empNO;
        this.empName = empName;
        this.empSal = empSal;
    }
     
    public int getEmpNO() {
        return empNO;
    }

    public void setEmpNO(int empNO) {
        this.empNO = empNO;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Double getEmpSal() {
        return empSal;
    }

    public void setEmpSal(double empSal) {
        this.empSal = empSal;
    }

   
         private int empNO  ;
         private String empName;
         private double empSal;
}
