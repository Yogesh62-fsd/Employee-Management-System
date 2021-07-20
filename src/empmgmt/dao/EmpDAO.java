
package empmgmt.dao;

import empmgmt.dbutil.DBConnection;
import empmgmt.pojo.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmpDAO {

    private static PreparedStatement ps;

    public static boolean addEmployee(Employee e) throws SQLException {
          
        Connection conn = DBConnection.getConnection();
        ps = conn.prepareStatement("Insert into employees values(?,?,?)");
        ps.setInt(1, e.getEmpNO());
        ps.setString(2, e.getEmpName());
        ps.setDouble(3, e.getEmpSal());

        int result = ps.executeUpdate();
        return (result == 1);
    }

    public static Employee findEmployeeById(int empno) throws SQLException {
        Employee e = null;
        Connection conn = DBConnection.getConnection();
        ps = conn.prepareStatement("Select * from  employees where empno=?");
        ps.setInt(1,empno );

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            e = new Employee();
            e.setEmpNO(rs.getInt(1));
            e.setEmpName(rs.getString(2));
            e.setEmpSal(rs.getDouble(3));
            return e;
        }
        return e;
    }

    public  static ArrayList<Employee> getAllEmployee() throws SQLException {
        Connection conn = DBConnection.getConnection();

        ArrayList<Employee> empList = new ArrayList<>();

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("Select * from  employees ");
        while (rs.next()) {
            Employee e = new Employee();
            e.setEmpNO(rs.getInt(1));
            e.setEmpName(rs.getString(2));
            e.setEmpSal(rs.getDouble(3));
            empList.add(e);
        }
        return empList;
    }
    
    public  static boolean UpdateEmployee(Employee e)throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        ps=conn.prepareStatement("Update employees set ename=?,sal=? where empno=?");
        ps.setString(1,e.getEmpName());
        ps.setDouble(2,e.getEmpSal());
        ps.setInt(3,e.getEmpNO());
        
       int result= ps.executeUpdate();
          return (result==1);
        
    }
     public static boolean deleteEmployee(int Empno)throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        ps=conn.prepareStatement("Delete from employees where empno=?");
        ps.setInt(1,Empno);
       
        
       int result= ps.executeUpdate();
           return(result==1);      
    }
 }
