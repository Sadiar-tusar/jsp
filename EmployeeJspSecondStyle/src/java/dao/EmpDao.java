
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Emp;
import util.DbUtil;


public class EmpDao {
    
    static DbUtil util = new DbUtil();
    static PreparedStatement ps;
    static ResultSet rs;
    static String sql;
    
    public static int saveEmp(Emp e){
    
    int status=0;
    sql="insert into emp(name,designation,salary) values(?,?,?)";
    
        try {
            ps=util.getCon().prepareStatement(sql);
            ps.setString(1,e.getName());
            ps.setString(2,e.getDesignation());
            ps.setFloat(3, e.getSalary());
            
            status=ps.executeUpdate();
            
            ps.close();
            util.getCon().close();
        } catch (SQLException ex) {
            Logger.getLogger(EmpDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return status;
    
    }
    
    public static List<Emp> getAllEmp(){
    
        List<Emp> emp=new ArrayList<>();
        
        sql="select * from emp";
        
        try {
            ps=util.getCon().prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
            
                Emp e=new Emp(rs.getInt("id"), rs.getString("name"),rs.getString("designation"), rs.getFloat("salary"));
                
                emp.add(e);
            }
            
            ps.close();
            rs.close();
            util.getCon().close();
        } catch (SQLException ex) {
            Logger.getLogger(EmpDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return emp;
    }
    
    public static void deleteEmp(int id){
    
        sql="delete from emp where id=?";
        
        try {
            ps=util.getCon().prepareStatement(sql);
            
            ps.setInt(1, id);
            ps.executeUpdate();
            
            ps.close();
            util.getCon().close();
        } catch (SQLException ex) {
            Logger.getLogger(EmpDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Emp getById(int id){
    
        Emp e = new Emp();
        
        sql="select * from emp where id=?";
        
        try {
            ps=util.getCon().prepareStatement(sql);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            
            while(rs.next()){
            
                e=new Emp(rs.getInt("id"), rs.getString("name"),rs.getString("designation"), rs.getFloat("salary"));
                
                
            }
            
            ps.close();
            rs.close();
            util.getCon().close();
        } catch (SQLException ex) {
            Logger.getLogger(EmpDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return e;
    }
    
     public static int updateEmp(Emp e) {

        int status = 0;

        sql = "update emp set name=?,designation=?,salary=? where id=?";

        try {
            ps = util.getCon().prepareStatement(sql);
            ps.setString(1, e.getName());
            ps.setString(2, e.getDesignation());
            ps.setFloat(3, e.getSalary());
            ps.setInt(4, e.getId());

            status = ps.executeUpdate();

            ps.close();
            util.getCon().close();
        } catch (SQLException ex) {
            Logger.getLogger(EmpDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return status;
    }
}
