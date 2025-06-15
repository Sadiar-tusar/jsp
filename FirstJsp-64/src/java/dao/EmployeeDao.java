
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Employee;
import util.Dbutil;

public class EmployeeDao {
    
    static Dbutil newUtil=new Dbutil();
    static PreparedStatement ps;
    static ResultSet rs;
    static String sql;
    
    public static List<Employee> getAllEmployee(){
    
    List<Employee> employee=new ArrayList<>();
    
    sql="select * from employee";
    
        try {
            ps=newUtil.getCon().prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
            
                Employee e=new Employee( rs.getInt("id"),
                rs.getString("name"),
                rs.getString("dejignation"),
                rs.getFloat("salary"));
                
               employee.add(e);
            }
            
            ps.close();
            rs.close();
            newUtil.getCon().close();
            
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return employee;
    }
    
    public static int saveaEmployee(Employee e){
    
        int status=0;
        sql="insert into employee(name, dejignation, salary) values (?,?,?)";
        
        try {
            ps=newUtil.getCon().prepareStatement(sql);
            
            ps.setString(1, e.getName());
            ps.setString(2, e.getDejignation());
            ps.setFloat(3, e.getSalary());
            
            status= ps.executeUpdate();
            
            ps.close();
            newUtil.getCon().close();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return status;
    }
}
